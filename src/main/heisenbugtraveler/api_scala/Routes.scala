package heisenbugtraveler.api_scala

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import heisenbugtraveler.api_scala.domain.User
import spray.json.DefaultJsonProtocol
import heisenbugtraveler.api_scala.infrastructure.UserMarshaller._

object Routes extends SprayJsonSupport with DefaultJsonProtocol {
  val all: Route = get {
    path("status") {
      complete(HttpEntity(ContentTypes.`application/json`, """{"status":"ok"}"""))
    } ~
      path("ping") {
        complete(HttpEntity(ContentTypes.`application/json`, """{"data":"pong"}"""))
      } ~
      path("users") {
        complete(systemUsers)
      }
  }
  private val systemUsers = Seq(
    User("123", "Isabel"),
    User("456", "Antonio"),
  )
}
