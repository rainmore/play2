package models.kpi

import javax.validation.constraints.Size

class Section {
  var id: Long = _
  @Size(min=1, max=256)
  var name: String = _
  var position: Int = 1
  var template: Template = _

  override def toString = {
    "Section [id: %d, name = %s]".format(id, name)
  }
}
