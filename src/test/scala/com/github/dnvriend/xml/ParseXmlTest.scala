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

import com.github.dnvriend.{ TestSpec, XmlPrinter }

import scala.xml.{ Node, NodeSeq, XML }

class ParseXmlTest extends TestSpec {
  val xmlHeader =
    """
      |<?xml version="1.0" encoding="UTF-8"?>
      |<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
    """.stripMargin
  it should "parse xml" in {
    val xmlWithHeader: NodeSeq = scala.xml.Unparsed(xmlHeader) ++ <foo></foo>
    val result: String = XmlPrinter.prettyPrint(xmlWithHeader)
    result shouldBe
      """<?xml version="1.0" encoding="UTF-8"?>
        |<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"><foo></foo>""".stripMargin
  }
}
