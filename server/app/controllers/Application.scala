package controllers

import play.api.mvc._;
import play.api.libs.json.Json.toJson;


object Application extends Controller {

  def sayHello = Action { request =>

    Ok(toJson(
      Map("status" -> "OK", "message" -> ("Hello world!"))
    ))
  }

  def options(url: String) = Action { request =>
    Ok("")
  }


}


