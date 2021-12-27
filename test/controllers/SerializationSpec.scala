package controllers

import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatestplus.play.PlaySpec
import play.api.libs.json.{JsResult, JsSuccess, JsValue, Json}

class SerializationSpec extends PlaySpec {

  case class Underpayment(taxYear: String, amount: Double, source: String)

  "Underpayment" must {
    "serialize to json" in {
      implicit val underpaymentWrites = Json.writes[Underpayment]

      val u1 = Underpayment("2012", 123.23, "UK SA")
      val jsonRepr: JsValue = Json.toJson(u1)
      val output = Json.stringify(jsonRepr)

      output shouldBe "{\"taxYear\":\"2012\",\"amount\":123.23,\"source\":\"UK SA\"}"
    }

    "serialize list to json" in {
      implicit val underpaymentWrites = Json.writes[Underpayment]

      val u1 = Underpayment("2012", 123.23, "UK SA")
      val u2 = Underpayment("2001", 2939.33, "UK PAYE")
      val jsonRepr: JsValue = Json.toJson(List(u1, u2))
      val output = Json.stringify(jsonRepr)

      println(output)
    }

    "deserialize from json" in {
      implicit val underpaymentReads = Json.reads[Underpayment]

      val jsonInput = "{\"taxYear\":\"2001\",\"amount\":38383.22,\"source\":\"UK PAYE\"}"
      val jsonRepr: JsValue = Json.parse(jsonInput)
      val jsonOutput: JsResult[Underpayment] = jsonRepr.validate[Underpayment]
      val u1 = jsonOutput match {
        case JsSuccess(value, path) => value
      }

      val expectedUnderpayment = Underpayment("2001", 38383.22, "UK PAYE")
      u1 shouldBe expectedUnderpayment
    }

    "deserialize list from json" in {
      implicit val underpaymentReads = Json.reads[Underpayment]

      val jsonInput = "[{\"taxYear\":\"2001\",\"amount\":38383.22,\"source\":\"UK PAYE\"},{\"taxYear\":\"2021\",\"amount\":3433.1,\"source\":\"UK SA\"}]"

      val jsonRepr: JsValue = Json.parse(jsonInput)
      val jsonOutput: JsResult[List[Underpayment]] = jsonRepr.validate[List[Underpayment]]
      val us = jsonOutput match {
        case JsSuccess(values, path) => values
      }

      println(us)
    }
  }
}
