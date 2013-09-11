package controllers

import play.api._
import play.api.mvc._

object Persona extends Controller {

  def list = Action {
    Ok(views.html.persona(models.Persona.findAll))
  }

}
