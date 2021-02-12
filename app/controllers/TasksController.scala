package controllers

import models.Task
import javax.inject._
import play.api.mvc._

@Singleton
class TasksController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
    def index() = Action { implicit request: Request[AnyContent] =>
        Ok(views.html.tasks.index(Task.all))
    }

    def create() = Action { implicit request: Request[AnyContent] =>
        Task.create(request.body.asFormUrlEncoded.get("name").head)
        Redirect(routes.TasksController.index())
    }

    def destroy(id: Int) = Action { implicit request: Request[AnyContent] =>
        val task: Task = Task.destroy(id)
        Ok
    }
}