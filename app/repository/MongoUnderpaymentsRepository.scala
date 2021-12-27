package repository

import model.Underpayment
import play.api.libs.json.Json
import play.modules.reactivemongo.ReactiveMongoComponent
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.ReactiveRepository
import uk.gov.hmrc.mongo.json.ReactiveMongoFormats
import uk.gov.hmrc.mongo.json.ReactiveMongoFormats.mongoEntity

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import scala.util.Failure
// BSON-JSON conversions/collection
import reactivemongo.play.json._
import play.api.libs.json._

@Singleton()
class MongoUnderpaymentsRepository @Inject()(mongo: ReactiveMongoComponent)(implicit executionContext: ExecutionContext)
  extends ReactiveRepository[UnderpaymentRecord, BSONObjectID](
  collectionName = "underpaymentTest",
  mongo = mongo.mongoConnector.db,
  domainFormat = UnderpaymentRecord.mongoFormat,
  idFormat = ReactiveMongoFormats.objectIdFormats
) with UnderpaymentsRepository {

  override def save(nino: String, periodId: String, underpayment: Underpayment): Future[Boolean] = {
    insert(UnderpaymentRecord(nino = nino, periodId = periodId, underpayment = underpayment)).map(_ => true)
  }

  override def bulkSave(nino: String, periodId: String, underpayments: List[Underpayment]): Future[Boolean] =
    bulkInsert(underpayments.map(u => UnderpaymentRecord(nino = nino, periodId = periodId, underpayment = u))).map(_ => true)

  override def lookup(nino: String, periodId: String): Future[List[Underpayment]] =
    find("nino" -> nino, "periodId" -> periodId).map(ls => ls.map(record => Underpayment(
      record.underpayment.taxYear,
      record.underpayment.amount,
      record.underpayment.source)))

}
