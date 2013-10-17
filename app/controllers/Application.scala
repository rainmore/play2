package controllers

import play.api.mvc._
import models.{File, Files}
import play.api.db.DB
import play.api.Play.current
import java.util.Date
import java.sql.Timestamp
import scala.slick.driver.MySQLDriver.simple._
import play.api.Play.current
import Database.threadLocalSession


object Application extends Controller {
  lazy val database = Database.forDataSource(DB.getDataSource())
  
  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def db = Action {


    var output = "test db\n"
//
//    val data = Seq(
//      new Asset(None, "a file name", "a module name", None, now(), None),
//      new Asset(None, "a file name", "a module name", None, now(), None),
//      new Asset(None, "a file name", "a module name", None, now(), None)
//    )

    val file = new File(None, "a file name", 1, None, now(), None)
    output += file.module + "\n"

    database withSession {
      Files.insert(file)
      val statement = Files.insertStatement
      output += statement.toString + "\n"
      output += file.id.toString + "\n"

    }

    Ok(output)
  }

  def now() = {
    val date: Date = new Date()
    val tm: Timestamp = new Timestamp(date.getTime)
    tm
  }
}
