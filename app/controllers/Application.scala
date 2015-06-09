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
    
    SticlaData.lista(0, 10, "%" + "" + "%").map { pagina =>
      Ok(views.html.index("Colectie de sticlute mickyshor.ro", Global.connectedUser, pagina))
    }.recover {
      case ex: TimeoutException =>
        Logger.error("Problema la incarcare lista sticlute")
        InternalServerError(ex.getMessage)
    }
  }

}