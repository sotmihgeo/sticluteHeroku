package models
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.driver.PostgresDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.driver.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema = PozaSticla.schema ++ Sticla.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table PozaSticla
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param idPoza Database column id_poza SqlType(int4)
   *  @param calepoza Database column calepoza SqlType(varchar), Length(200,true), Default(None) */
  case class PozaSticlaRow(id: Int, idPoza: Int, calepoza: Option[String] = None)
  /** GetResult implicit for fetching PozaSticlaRow objects using plain SQL queries */
  implicit def GetResultPozaSticlaRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[PozaSticlaRow] = GR{
    prs => import prs._
    PozaSticlaRow.tupled((<<[Int], <<[Int], <<?[String]))
  }
  /** Table description of table poza_sticla. Objects of this class serve as prototypes for rows in queries. */
  class PozaSticla(_tableTag: Tag) extends Table[PozaSticlaRow](_tableTag, "poza_sticla") {
    def * = (id, idPoza, calepoza) <> (PozaSticlaRow.tupled, PozaSticlaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(idPoza), calepoza).shaped.<>({r=>import r._; _1.map(_=> PozaSticlaRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column id_poza SqlType(int4) */
    val idPoza: Rep[Int] = column[Int]("id_poza")
    /** Database column calepoza SqlType(varchar), Length(200,true), Default(None) */
    val calepoza: Rep[Option[String]] = column[Option[String]]("calepoza", O.Length(200,varying=true), O.Default(None))

    /** Foreign key referencing Sticla (database name fk_poza) */
    lazy val sticlaFk = foreignKey("fk_poza", idPoza, Sticla)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table PozaSticla */
  lazy val PozaSticla = new TableQuery(tag => new PozaSticla(tag))

  /** Entity class storing rows of table Sticla
   *  @param id Database column id SqlType(serial), AutoInc, PrimaryKey
   *  @param denumire Database column denumire SqlType(varchar), Length(60,true)
   *  @param greutate Database column greutate SqlType(int4), Default(None)
   *  @param colectie Database column colectie SqlType(varchar), Length(30,true), Default(None)
   *  @param tara Database column tara SqlType(bpchar), Length(2,false), Default(None)
   *  @param descriere Database column descriere SqlType(varchar), Length(250,true), Default(None)
   *  @param calepoza Database column calepoza SqlType(varchar), Length(200,true), Default(None) */
  case class SticlaRow(id: Int, denumire: String, greutate: Option[Int] = None, colectie: Option[String] = None, tara: Option[String] = None, descriere: Option[String] = None, calepoza: Option[String] = None)
  /** GetResult implicit for fetching SticlaRow objects using plain SQL queries */
  implicit def GetResultSticlaRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[Int]], e3: GR[Option[String]]): GR[SticlaRow] = GR{
    prs => import prs._
    SticlaRow.tupled((<<[Int], <<[String], <<?[Int], <<?[String], <<?[String], <<?[String], <<?[String]))
  }
  /** Table description of table sticla. Objects of this class serve as prototypes for rows in queries. */
  class Sticla(_tableTag: Tag) extends Table[SticlaRow](_tableTag, "sticla") {
    def * = (id, denumire, greutate, colectie, tara, descriere, calepoza) <> (SticlaRow.tupled, SticlaRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(id), Rep.Some(denumire), greutate, colectie, tara, descriere, calepoza).shaped.<>({r=>import r._; _1.map(_=> SticlaRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(serial), AutoInc, PrimaryKey */
    val id: Rep[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column denumire SqlType(varchar), Length(60,true) */
    val denumire: Rep[String] = column[String]("denumire", O.Length(60,varying=true))
    /** Database column greutate SqlType(int4), Default(None) */
    val greutate: Rep[Option[Int]] = column[Option[Int]]("greutate", O.Default(None))
    /** Database column colectie SqlType(varchar), Length(30,true), Default(None) */
    val colectie: Rep[Option[String]] = column[Option[String]]("colectie", O.Length(30,varying=true), O.Default(None))
    /** Database column tara SqlType(bpchar), Length(2,false), Default(None) */
    val tara: Rep[Option[String]] = column[Option[String]]("tara", O.Length(2,varying=false), O.Default(None))
    /** Database column descriere SqlType(varchar), Length(250,true), Default(None) */
    val descriere: Rep[Option[String]] = column[Option[String]]("descriere", O.Length(250,varying=true), O.Default(None))
    /** Database column calepoza SqlType(varchar), Length(200,true), Default(None) */
    val calepoza: Rep[Option[String]] = column[Option[String]]("calepoza", O.Length(200,varying=true), O.Default(None))
  }
  /** Collection-like TableQuery object for table Sticla */
  lazy val Sticla = new TableQuery(tag => new Sticla(tag))
}
