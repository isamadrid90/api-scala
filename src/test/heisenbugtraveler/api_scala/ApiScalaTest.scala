package heisenbugtraveler.api_scala

import org.scalatest.Matchers._
import org.scalatest._

final class ApiScalaTest extends WordSpec with GivenWhenThen {
  "ApiScala" should {
    "greet" in {
      Given("a ApiScala")

      val apiScala = new ApiScala

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting    = apiScala.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
