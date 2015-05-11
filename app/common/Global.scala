package common

import play.api._

import models.User

object Global extends GlobalSettings {
  var connectedUser: User = User("---", "", false, false)
}