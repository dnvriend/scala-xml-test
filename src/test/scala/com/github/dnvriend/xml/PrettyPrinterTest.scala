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

import scala.xml.PrettyPrinter

class PrettyPrinterTest extends TestSpec {
  def withPrettyPrinter(block: PrettyPrinter => Unit): Unit =
    block(new scala.xml.PrettyPrinter(80, 4))

  it should "format xml" in withPrettyPrinter { printer =>
    val xml = XmlFormat[Person].toXml(Person("1", "foo", 42))
    val str = printer.formatNodes(xml)
    str shouldBe
      """<person id="1">
        |    <name>foo</name>
        |    <age>42</age>
        |</person>""".stripMargin
  }
}
