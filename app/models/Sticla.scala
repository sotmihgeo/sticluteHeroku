package models

import slick.lifted.Tag
import slick.driver.PostgresDriver.api._

case class Sticla(id: Option[Int], denumire: Option[String], greutate: Option[Int], colectie: Option[String], tara: Option[String], descriere: Option[String], calePoza: Option[String])

class Sticle(tag: Tag) extends Table[Sticla](tag, "sticla") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def denumire = column[String]("denumire")
  def greutate = column[Int]("greutate")
  def colectie = column[String]("colectie")
  def tara = column[String]("tara")
  def descriere = column[String]("descriere")
  def calePoza = column[String]("calepoza")
  
  def * = (id.?, denumire.?, greutate.?, colectie.?, tara.?, descriere.?, calePoza.?) <> (Sticla.tupled, Sticla.unapply _)
}