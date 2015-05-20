package controllers

import play.api._
import play.api.mvc._

import models.User
import common.Global

object Application extends Controller {

  def index = Action {
    //ar trebui sa initializez userul global
    Global.connectedUser = User("micky.sotirca@gmail.com", "", false, false)
    
    /*import slick.driver.PostgresDriver.api._
    import slick.codegen.SourceCodeGenerator
    
    slick.codegen.SourceCodeGenerator.main(
      Array("slick.driver.PostgresDriver", 
            "org.postgresql.Driver", 
            "jdbc:postgresql:sticlute", 
            "app\\", "models", 
            "postgres", "smg1983")
    )*/
    
    Ok(views.html.index("Colectie de sticlute mickyshor.ro", Global.connectedUser))
  }

}