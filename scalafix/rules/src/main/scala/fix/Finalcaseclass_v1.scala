package fix

import scalafix._
import scala.meta._

case object FinalCaseClass extends Rule("FinalCaseClass") {
  val error = LintCategory.error(
    "Extending a case classes can have surprising equals/hashCode behavior. " +
      "It's recommended to mark all case classes as final."
  )
  override def check(ctx: RuleCtx): List[LintMessage] = ctx.tree.collect {
    case q"..$mods case class $name[..$_] ..$_ (...$_) extends $_" 
      if !mods.exists { case mod"final" => true case _ => false } =>
      error.at(s"case class $name must be final", name.pos)
  }
}

