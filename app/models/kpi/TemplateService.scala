package models.kpi

import scala.beans.BeanProperty

object TemplateService {
  @BeanProperty val list: List[Template] = initList()

  private def initList() = {
    val list: List[Template] = (for (i <- 1 to 5) yield createTemplate(i.toLong)).toList
    list
  }

  def createTemplate(id: Long) = {
    val template: Template = new Template
    template.id = id
    template.name = "Test %d".format(id)
    template.sections = ((for (i <- 1 to 4) yield createSection(template, i)).toList)
    template
  }

  def createSection(template: Template, position: Int) = {
    val section: Section = new Section
    val id: Long = template.id + position.toLong
    section.template = template
    section.id = id
    section.name = "Section [Position: %d, Id: %d]".format(position, section.id)
    section.position = position
    section
  }

  def findById(id: Long) = {
    list.filter(t => t.id.equals(id)).head
  }

  def save(template: Template): Unit = {
    Console.println(template)
    list.find(t => t.id.equals(template.id)) map {t =>
      t.name = template.name
      t.description = template.description
      t.isActive = template.isActive
    }
    Console.println(findById(template.id))
  }
}
