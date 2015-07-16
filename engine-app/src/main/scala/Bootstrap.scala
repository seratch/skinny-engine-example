import javax.servlet._
import skinny.engine._

class Bootstrap extends LifeCycle {
  override def init(ctx: ServletContext) {
    ctx.mount(app.Hello, "/hello/*")
  }
}
