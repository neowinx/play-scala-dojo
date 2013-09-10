package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  var authenticated = false
  
  def index = Action {
    if(!authenticated)
      Ok(views.html.login())
    else
      Ok(views.html.index())
  }
  
}