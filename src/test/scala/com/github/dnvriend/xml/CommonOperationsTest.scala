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

// http://alvinalexander.com/scala/scala-xml-examples-xml-literals-source-code-searching-xpath
// http://alvinalexander.com/scala/scala-xml-examples-xml-literals-source-code-searching-xpath
// http://alvinalexander.com/scala/xml-parsing-xpath-extract-xml-tag-attributes
// http://alvinalexander.com/scala/how-extract-data-array-xml-elements-xpath-scala
// http://alvinalexander.com/scala/how-to-extract-data-from-xml-nodes-in-scala
class CommonOperationsTest extends TestSpec {
  it should "get a node" in {
    // the <foo> is the root node so you start with "bar" etc if you traverse the tree
    (<foo> <bar></bar> </foo> \ "bar").head.label shouldBe "bar"
  }
}
