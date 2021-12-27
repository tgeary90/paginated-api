package repository

import model.Underpayment
import play.api.libs.json.Json
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.json.ReactiveMongoFormats.mongoEntity
import reactivemongo.play.json.ImplicitBSONHandlers._

case class UnderpaymentRecord(id: BSONObjectID = BSONObjectID.generate(), nino: String, periodId: String, underpayment: Underpayment)

object UnderpaymentRecord {
  implicit val jsonFormat = Json.format[UnderpaymentRecord]
  implicit val mongoFormat = mongoEntity { jsonFormat }
}