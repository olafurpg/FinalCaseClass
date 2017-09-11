package fix

import scalafix._
import scala.meta._, contrib._

case object FinalCaseClass extends Rule("FinalCaseClass") {
  val error = LintCategory.error(
    "Extending a case classes can have surprising equals/hashCode behavior."
  )
  override def check(ctx: RuleCtx): List[LintMessage] = ctx.tree.collect {
    case cls: Defn.Class if cls.hasMod(mod"case") && !cls.hasMod(mod"final") =>
      error.at(s"case class $name must be final", cls.name.pos)
  }
}

