# Case Study

In the case study section of the paper, __Shy__ framework is applied to the QL language, a DSL for questionnaires, to illustrate how __Shy__ helps to remove boilerplate code and reduce the size of client code when traversing AST structures.

## How to build

Please make sure all the three projects are imported into Eclipse:

- [Library](https://github.com/JasonCHU/SYBwithOA/tree/master/CaseStudy/Library): A copy of [Shy](https://github.com/JasonCHU/SYBwithOA/tree/master/Shy), the implementation of __Shy__ framework.
- [QL](https://github.com/JasonCHU/SYBwithOA/tree/master/CaseStudy/QL): The main project for case study, where QL is defined and implemented, __Shy__ is applied and other experiments are conducted. 
- [naked-object-algebras](https://github.com/JasonCHU/SYBwithOA/tree/master/CaseStudy/naked-object-algebras):  Object Algebras decorated with concrete syntax annotations. It helps to generate an ANTLR4 parser automatically.

