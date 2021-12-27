//package controllers
//
//import org.scalatestplus.play.PlaySpec
//import reactivemongo.api.{AsyncDriver, MongoConnection}
//
//import java.util.UUID
//import scala.concurrent.ExecutionContext.Implicits.global
//import scala.concurrent.Future
//import scala.util.Try
//
//class PersistenceSpec extends PlaySpec {
//
//  case class Underpayment(nino: String, periodId: UUID, taxYear: String, amount: Double, source: String)
//
////  "An Underpayment" must {
////    "persist to mongodb" in {
////      val client: MongoClient = MongoClient("mongodb://localhost")
////      val db: MongoDatabase = client.getDatabase("breathing-space-if-dynamic-stub")
////      val coll: MongoCollection[Document] = db.getCollection("underpayment")
////
////      val u1 = Underpayment(
////        "AS00000A1",
////        UUID.fromString("9514fd84-6661-11ec-8e22-60f262c313dc"),
////        "2012",
////        123.23,
////        "UK SA")
////
////      val doc: Document = Document(
////        "_id" -> 0,
////        "nino" -> u1.nino,
////        "periodId" -> u1.periodId.toString,
////        "taxYear" -> u1.taxYear,
////        "amount" -> u1.amount,
////        "source" -> u1.source)
////
////      val obvs: Observable[Completed] = coll.insertOne(doc)
////      obvs.subscribe(new Observer[Completed] {
////        override def onNext(result: Completed): Unit = println("Inserted")
////        override def onError(e: Throwable): Unit = println("failed")
////        override def onComplete(): Unit = println("completed")
////      })
////    }
////  }
//
//  //try(con.map(f => f.database(dn)))
//
//  "An Underpayment" must {
//    "Persist via HMRC mongo driver" in {
//
//    val repo = MongoUnderpaymentsRepository
//  }
//}
