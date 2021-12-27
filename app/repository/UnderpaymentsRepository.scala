package repository


import com.google.inject.ImplementedBy
import model.Underpayment

import scala.concurrent.Future

@ImplementedBy(classOf[MongoUnderpaymentsRepository])
trait UnderpaymentsRepository {
  def lookup(nino: String, periodId: String): Future[List[Underpayment]]
  def save(nino: String, periodId: String, underpayment: Underpayment): Future[Boolean]
  def bulkSave(nino: String, periodId: String, underpayments: List[Underpayment]): Future[Boolean]
}
