package model

import play.api.libs.json.Json

case class Underpayment(taxYear: String, amount: Double, source: String)

object Underpayment {
  implicit val underpaymentWrites = Json.writes[Underpayment]
  implicit val underpaymentReads = Json.reads[Underpayment]
  implicit val jsonFormat = Json.format[Underpayment]

}