package controllers

import models.kpi._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._

object Kpi extends Controller {

  val list = TemplateService.list
  val form = Form(
    mapping (
      "id"           -> optional(of[Long]),
      "name"         -> nonEmptyText,
      "description"  -> text,
      "isActive"     -> boolean
    ) (Template.apply)(Template.unapply)
  )

  def index(id: Long) = Action {
    var template: Template = null
    if (id > 0) template = TemplateService.findById(id)
    Ok(views.html.kpi.index("KPI List", list, template))
  }

  def activate(id: Long) = Action {
    val template: Template = TemplateService.findById(id)
    template.isActive = !template.isActive
    Redirect(routes.Kpi.index(id))
  }

  def copy(id: Long) = Action {
    Ok("Copy %d".format(id))
  }

  def edit(id: Long) = Action {
    val template: Template = TemplateService.findById(id)
    Ok(views.html.kpi.template(form.fill(template)))
  }

  def save() = Action { implicit request =>
    form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.kpi.template(formWithErrors))
      },
      template => {
        Console.println(template)
        if (template.id > 0)
          TemplateService.save(template)
        Redirect(routes.Kpi.index(template.id))
      }
    )
  }

  def delete(id: Long) = Action {
    Ok("delete")
  }
}
