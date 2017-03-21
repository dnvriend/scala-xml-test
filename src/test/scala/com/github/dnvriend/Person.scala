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

package com.github.dnvriend
import scala.xml.NodeSeq

case class Person(id: String, name: String, age: Int)

object Person {
  implicit val xmlFormat: XmlFormat[Person] = new XmlFormat[Person] {
    override def marshal(person: Person): NodeSeq = {
      <person id={ person.id }>
        <name>{ person.name }</name>
        <age>{ person.age }</age>
      </person>
    }

    override def unmarshal(xml: NodeSeq): Person = {
      val id: String = xml \@ "id"
      val name: String = (xml \ "name").text
      val age: Int = (xml \ "age").text.toInt
      Person(id, name, age)
    }
  }
}
