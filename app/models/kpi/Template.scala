package models.kpi

import play.api.data._
import play.api.data.Forms._

class Template {
  var id: Long = _
  var name: String = _
  var description: String = _
  var isActive: Boolean = _
  var sections: List[Section] = _

  override def toString = {
    "Template [id: %d, name = %s, isActive = %s]".format(id, name, isActive.toString)
  }
}

object Template {
  def apply(id: Option[Long], name: String, description: String, isActive: Boolean) = {
    val t: Template = new Template
    t.id = id.getOrElse(0)
    t.name = name
    t.description = description
    t.isActive = isActive
    t
  }

  def unapply(t: Template) = Some((Option(t.id), t.name, t.description, t.isActive))
}
