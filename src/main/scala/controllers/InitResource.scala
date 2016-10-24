package controllers

import play.api.mvc.{Action, Controller}

class InitResource extends Controller{

  def init = Action { request =>
    Ok("Hello")
  }

}
