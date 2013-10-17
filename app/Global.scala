import play.api.db.DB
import play.api.GlobalSettings
import play.api.Application
import scala.slick.driver.MySQLDriver.simple._
import play.api.Play.current
import Database.threadLocalSession

object Global extends GlobalSettings {
  override def onStart(app: Application) {
    lazy val database = Database.forDataSource(DB.getDataSource())
  }
}
