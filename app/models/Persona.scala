package models

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Persona(id: Int,nombre: String,ci: String)

object Persona {

  val simple = {
    get[Int]("persona.id") ~
    get[String]("persona.nombre") ~
    get[String]("persona.ci") map {
      case id~nombre~ci=> Persona(id, nombre, ci)
    }
  }

  def findAll: Seq[Persona] = {
    DB.withConnection { implicit connection =>
      SQL("select * from persona").as(Persona.simple *)
    }
  }

  def create(persona: Persona): Persona = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into persona values (
            {id}, {nombre}, {ci}
          )
        """
      ).on(
        'id -> persona.id,
        'nombre -> persona.nombre,
        'ci -> persona.ci
      ).executeUpdate()

      persona

    }
  }


}