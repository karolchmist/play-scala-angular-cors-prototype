import play.api._
import play.api.mvc._


object Global extends GlobalSettings {

  /**
   * Global action composition.
   */
  override def doFilter(action: EssentialAction): EssentialAction = EssentialAction { request =>
    action.apply(request).map(_.withHeaders(
      "Access-Control-Allow-Origin" -> "http://localhost:20000"
    // may be useful one day
      //      "Access-Control-Allow-Origin" -> "*"    ,
      //      "Access-Control-Allow-Methods" -> "GET, POST, PUT, DELETE, OPTIONS",
      //      "Access-Control-Allow-Headers" -> "Content-Type, X-Requested-With, Accept",
      //      // cache access control response for one day
      //      "Access-Control-Max-Age" -> (60 * 60 * 24).toString
      //    )
    ))
  }
}