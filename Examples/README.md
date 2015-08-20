# Examples

Source code of the examples shown in the paper can be found here. Since __Shy__ is based on Object Algebras and Java annotations, with those examples you'll be able to find how a simple annotation "@Algebra" helps to implement traversals of complex AST structures easily.

For more details on how to configure your own project and use the __Shy__ library, please click: https://github.com/JasonCHU/SYBwithOA/tree/master/Shy

## How to build

Simply import this directory into a Java IDE you are using (like Eclipse). Don't forget to make sure Java 8 is available in your IDE.

This project requires a library of the __Shy__ framework, but a _.jar_ file has already been put in /lib/.

## Contents (with reference to the paper)

- [/src/ObjectAlgebras/](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples/src/ObjectAlgebras): Small examples of Object Algebras. See the section "Background: Object Algebras" of the paper.
- [/src/MiniQL/](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples/src/MiniQL): The example of MiniQL. See the section "MiniQL".
- [/src/ExpAlg/](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples/src/ExpAlg): The example of ExpAlg, which is the Object Algebra interface standing for an expression, and its extensions. See the sections "Queries", "Generalized Queries", "Transformations", "Contextual Transformations" and "Extensible Queries and Transformations".
- [/src/Utils/](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples/src/Utils): Some utilities are defined here.
- [/src/AutoTest/](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples/src/AutoTest): An integrated JUnit test module is provided for running all the examples included in this project.

## Notes

__Shy__ generates traversal code for Object Algebra interfaces annotated with "@Algebra" automatically. Since this Java project is already configured, when it is successfully imported into Eclipse (or you compile those java files from command line), new classes and interfaces will be generated in:

- /src/query/: Generic queries and generic generalized queries.
- /src/transform/: Generic transformations and generic contextual transformations.
- /src/util/: Utilities for generic transformations. The generic transformations are generated as interfaces, but here default classes with constructors are provided for convenient use.
- /src/combinator/: Generic combinators.
