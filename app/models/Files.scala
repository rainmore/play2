package models

import scala.slick.driver.MySQLDriver.simple._
import java.sql.Timestamp


case class File (id: Option[Long], name: String, module: Int, contentType: Option[String], created: Timestamp, transferred: Option[Timestamp])

object Files extends Table[File]("files") {
  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name", O.NotNull)
  def module = column[Int]("module", O.NotNull)
  def contentType = column[String]("contentType", O.Nullable)
  def created = column[Timestamp]("created", O.NotNull)
  def transferred = column[Timestamp]("transferred", O.Nullable)

  def * = id.? ~ name ~ module ~ contentType.? ~ created ~ transferred.? <> (File.apply _, File.unapply _)
}
