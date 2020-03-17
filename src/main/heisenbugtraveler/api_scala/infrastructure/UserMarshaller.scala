package heisenbugtraveler.api_scala.infrastructure

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import heisenbugtraveler.api_scala.domain.User
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object UserMarshaller extends SprayJsonSupport with DefaultJsonProtocol {

  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply)

}
