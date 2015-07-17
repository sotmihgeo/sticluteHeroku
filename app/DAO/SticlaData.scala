package DAO

import slick.driver.PostgresDriver.api._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import models.{Sticla, Sticle}
import common._

object SticlaData {
  import DAO._
  
  private val sticlute = TableQuery[Sticle]
  
  def nrSticlute: Future[Int] =
    try db.run(sticlute.length.result)
    finally db.close
    
  private def nrSticlute(filtru: String): Future[Int] = 
    try db.run(sticlute.filter(_.denumire.toLowerCase like filtru.toLowerCase()).length.result)
    finally db.close
    
  /*def lista6Random(): Future[Pagina[Sticla]] = {
      try {
        val rand = SimpleFunction.nullary[Double]("random")
        val query = sticlute.sortBy(sticla => rand).take(6)
        val result = db.run(query.result)
        result flatMap (sticlute => Future { 0 } map (nrTotalSticlute => Pagina(sticlute, 0, 0, nrTotalSticlute)))
      }
      finally { db.close() }
    }*/
  def listaRandom(pagina: Int = 0, nrElementePerPagina: Int = 10, filtru: String ="%"): Future[Pagina[Sticla]] = {
      try {
        val nrSticluteAfisate = pagina * nrElementePerPagina
        val rand = SimpleFunction.nullary[Double]("random")
        val query = 
          (for {
            sticluta <- sticlute if sticluta.denumire.toLowerCase like filtru.toLowerCase()
          } yield (sticluta)).sortBy(sticla => rand).drop(nrSticluteAfisate).take(nrElementePerPagina)
        val nrSticluteTotal = nrSticlute(filtru)
        val result = db.run(query.result)
        result flatMap (sticlute => nrSticluteTotal map (nrTotalSticlute => Pagina(sticlute, pagina, nrSticluteAfisate, nrTotalSticlute)))
      }
      finally { db.close() }
    }  
  
  def lista(pagina: Int = 0, nrElementePerPagina: Int = 10, filtru: String ="%"): Future[Pagina[Sticla]] = {
      try {
        val nrSticluteAfisate = pagina * nrElementePerPagina
        val query = 
          (for {
            sticluta <- sticlute if sticluta.denumire.toLowerCase like filtru.toLowerCase()
          } yield (sticluta)).sortBy(_.denumire).drop(nrSticluteAfisate).take(nrElementePerPagina)
        val nrSticluteTotal = nrSticlute(filtru)
        val result = db.run(query.result)
        result flatMap (sticlute => nrSticluteTotal map (nrTotalSticlute => Pagina(sticlute, pagina, nrSticluteAfisate, nrTotalSticlute)))
      }
      finally { db.close() }
    }
  
  def sticlaById(id: Int): Future[Option[Sticla]] ={
    try {
      val query = sticlute.filter(_.id === id)
      db.run(query.result.headOption) 
    }
    finally { db.close() }
  }
}