package controllers

import model.Underpayment
import play.api.libs.json.{JsSuccess, JsValue, Json}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import service.UnderpaymentService

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import model.Underpayment.underpaymentWrites
import play.api.libs.Files.logger

@Singleton()
class UnderpaymentsController @Inject()(
   underpaymentsResourceHandler: UnderpaymentService,
   cc: ControllerComponents)(
  implicit val ec: ExecutionContext)
  extends BaseController {

  override protected def controllerComponents: ControllerComponents = cc

  def lookup(nino: String, periodId: String): Action[AnyContent] = Action.async { implicit request =>
      logger.info(s"Received request for Underpayment ${nino}/${periodId}")
      underpaymentsResourceHandler.lookup(nino, periodId).map { up => Ok(Json.toJson(up)) }
  }

  def save(nino: String, periodId: String): Action[JsValue] = Action(parse.json) { implicit request =>
    val underpayment = request.body.validate[Underpayment] match {
      case JsSuccess(value, path) => value
    }
    underpaymentsResourceHandler.save(nino, periodId, underpayment)
    Ok(Json.obj("message" -> ("Saving Underpayment: " + underpayment )))
  }

  def bulkSave(nino: String, periodId: String): Action[JsValue] = Action(parse.json) { implicit request =>
    val underpayments = request.body.validate[List[Underpayment]] match {
      case JsSuccess(values, _) => values
    }
    underpaymentsResourceHandler.bulkSave(nino, periodId, underpayments)
    Ok(Json.obj("message" -> ("Saving Underpayments: " + underpayments )))
  }
}
