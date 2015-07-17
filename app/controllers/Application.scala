package controllers

import play.api._
import play.api.mvc._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.TimeoutException

import models.{User, Sticla}
import DAO.{SticlaData}
import common.{Global, Pagina}

object Application extends Controller {

  def index: Action[AnyContent] = Action.async { implicit request =>
    //ar trebui sa initializez userul global
    Global.connectedUser = User("micky.sotirca@gmail.com", "", false, false)
    
    SticlaData.listaRandom(0, 3, "%" + "" + "%").map { pagina =>
      Ok(views.html.index("...", Global.connectedUser, pagina))
    }.recover {
      case ex: TimeoutException =>
        Logger.error("Problema la incarcare lista sticlute")
        InternalServerError(ex.getMessage)
    }
  }
  
  def sticla(id:Int): Action[AnyContent] = Action.async { implicit request =>
    SticlaData.sticlaById(id).map { 
      case Some(sticla) => Ok(views.html.sticla(Global.connectedUser, sticla))
      case None => NotFound("not found")
    }.recover {
      case ex: TimeoutException =>
        Logger.error("Problema la incarcare sticluta")
        InternalServerError(ex.getMessage)
    } 
  }

}