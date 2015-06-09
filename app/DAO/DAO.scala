package DAO

import slick.driver.PostgresDriver.api._
import play.api.db.DB
import play.api.Play.current

object DAO {
  def db: Database = Database.forDataSource(DB.getDataSource())
}