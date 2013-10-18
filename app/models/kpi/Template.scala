package models.kpi

import play.api.db.slick.Config.driver.simple._

class Template extends Table[(Long, String, String, Boolean)]("kpiTemplate"){
  def id = column[Long]("id")
  def name = column[String]("name")
  def description = column[String]("description")
  def isActive = column[Boolean]("isActive")

  var sections: List[Section] = _

  override def toString = {
    "Template [id: %d, name = %s, isActive = %s]".format(id, name, isActive.toString)
  }
}

object Template {
  def apply(id: Option[Long], name: String, description: String, isActive: Boolean) = {
    val t: Templates = new Templates
    t.id = id.getOrElse(0)
    t.name = name
    t.description = description
    t.isActive = isActive
    t
  }

  def unapply(t: Templates) = Some((Option(t.id), t.name, t.description, t.isActive))
}
