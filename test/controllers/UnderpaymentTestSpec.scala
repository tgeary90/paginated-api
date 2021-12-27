package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import model.Underpayment
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.Files.logger
import play.api.test.Helpers.{GET, contentAsString, contentType, status, stubControllerComponents}
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._
import repository.UnderpaymentsRepository
import service.UnderpaymentService

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class UnderpaymentTestSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  class MockUnderpaymentRepository extends UnderpaymentsRepository {
    override def save(nino: String, periodId: String, underpayment: Underpayment): Future[Boolean] = ???

    override def bulkSave(nino: String, periodId: String, underpayments: List[Underpayment]): Future[Boolean] = ???
  }

  "UnderpaymentController GET" should {
    "return one underpayment" in {
      val repo = new MockUnderpaymentRepository
      val handler = new UnderpaymentService(repo)
      val controller = new UnderpaymentsController(handler, stubControllerComponents())
      val u1 = controller.lookup("AS00000A1", "fc2576a8-66f6-11ec-83c6-60f262c313dc").apply(FakeRequest(GET, "/"))

      val expectedUnderpayment = Underpayment("2011", 234.22, "UK SA")

      status(u1) mustBe 200
      contentType(u1) mustBe Some("application/json")
      contentAsString(u1) must include ("taxYear")
      logger.info("Underpayment: " + contentAsString(u1))
    }
  }
}
