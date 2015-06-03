# Case Study

In the case study section of the paper, _Shy_ framework is applied to the QL language, a DSL for questionnaires, to illustrate how _Shy_ helps to remove boilerplate code and reduce the size of client code when traversing AST structures.

## How to build

Please make sure all the three projects are imported into Eclipse:

- Library: A copy of [Shy](https://github.com/JasonCHU/SYBwithOA/tree/master/Shy), the implementation of _Shy_ framework.
- QL: The main project for case study, where QL is defined and implemented, _Shy_ is applied and other experiments are conducted. 
- naked-object-algebras:  Object Algebras decorated with concrete syntax annotations. Also it helps to generate an ANTLR4 parser automatically.

