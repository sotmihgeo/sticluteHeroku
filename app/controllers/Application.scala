package controllers

import play.api._
import play.api.mvc._

import models.User
import common.Global

object Application extends Controller {

  def index = Action {
    //ar trebui sa initializez userul global
    Global.connectedUser = User("micky.sotirca@gmail.com", "", false, false)
    
    Ok(views.html.index("Colectie de sticlute mickyshor.ro", Global.connectedUser))
  }

}