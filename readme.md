# FinalCaseClass

Scalafix rule to prohibit non-final case classes.
Extending a case class can result in surprising equals/hashCode behavior.
To run this linter on your codebase, install [sbt-scalafix][] and
from the sbt shell

```
> scalafix github:olafurpg/FinalCaseClass/v1
```

