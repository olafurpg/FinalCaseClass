/*
rule = "scala:fix.FinalCaseClass"
*/
package fix

object Finalcaseclass_v1_Test {
  case class Foo(a: Int) // assert: FinalCaseClass
  final case class Bar(b: Int)
}
