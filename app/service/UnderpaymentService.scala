package service

import model.Underpayment
import play.api.mvc.Result
import reactivemongo.bson.BSONObjectID
import repository.{MongoUnderpaymentsRepository, UnderpaymentRecord, UnderpaymentsRepository}

import java.util.UUID
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UnderpaymentService @Inject()(underpaymentsRepository: UnderpaymentsRepository)
                                   (implicit ec: ExecutionContext) {

  def bulkSave(nino: String, periodId: String, underpayments: List[Underpayment]): Future[Boolean] = {
    underpaymentsRepository.bulkSave(nino, periodId, underpayments)
  }


  def save(nino: String, periodId: String, underpayment: Underpayment): Future[Boolean] =
    underpaymentsRepository.save(nino, periodId, underpayment)

  def lookup(nino: String, periodId: String): Future[List[Underpayment]] = {
    underpaymentsRepository.lookup(nino, periodId)
//    Future {
//      Underpayment("2011", 234.22, "UK SA")
//    }
  }
}
