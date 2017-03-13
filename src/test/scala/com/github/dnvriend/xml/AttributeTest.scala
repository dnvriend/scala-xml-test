/*
 * Copyright 2016 Dennis Vriend
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dnvriend.xml

import com.github.dnvriend.TestSpec

import scala.xml.Elem

class AttributeTest extends TestSpec {
  it should "extract an attribute" in {
    xml \@ "id" shouldBe "12345"
  }

  it should "extract an attribute on a NodeSeq" in {
    <foo><bar id="345"></bar></foo> \ "bar" \@ "id" shouldBe "345"
  }

  it should "extract when not available" in {
    <foo></foo> \@ "id" shouldBe ""
  }

  it should "extract from an elem" in {
    val x: Elem = <foo id="123"></foo>
    x \@ "id" shouldBe "123"
  }
}
