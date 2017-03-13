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

import com.github.dnvriend.{ Person, TestSpec, XmlFormat }

import scala.xml.NodeSeq

class XmlFormatTest extends TestSpec {
  it should "Marshal and unmarshal using a format" in {
    val xml: NodeSeq = XmlFormat[Person].toXml(Person("1", "foo", 42))
    XmlFormat[Person].fromXml(xml) shouldBe Person("1", "foo", 42)
  }
}