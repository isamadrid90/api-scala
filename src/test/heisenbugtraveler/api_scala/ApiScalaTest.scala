package heisenbugtraveler.api_scala

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

class ApiScalaTest extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  "ApiScala" should {
    "respond successfully when requesting its status " in {
      Get("/status") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"status":"ok"}"""
      }
    }
    "respond pong when requesting ping " in {
      Get("/ping") ~> Routes.all ~> check {
        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String] shouldBe """{"data":"pong"}"""
      }
    }
    "respond with all users when requesting /users" in {
      Get("/users") ~> Routes.all ~> check {
        val expectedSystemUsers =
          """
            |    [
            |        {
            |            "id":"123",
            |            "name":"Isabel"
            |        },
            |        {
            |            "id":"456",
            |            "name":"Antonio"
            |        }
            |    ]
            |""".stripMargin

        status shouldBe StatusCodes.OK
        contentType shouldBe ContentTypes.`application/json`
        entityAs[String].replaceAll("\\s", "") shouldBe expectedSystemUsers.replaceAll("\\s", "")
      }
    }
  }

}
