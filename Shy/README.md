# Shy
__Shy__ is a framework automatically generating Object Algebras queries and transformations for user-defined generic Object Algebra interfaces annotated with a simple "@Algebra". With these generated classes/interfaces, users can then inherit from them to implement structure-shy traversals by overriding only a few interesting cases. Hence boilerplate traversal code is avoided. The library has been tested in JRE 8 in Eclipse. 

For complete examples of writing object algebras code with Shy, please refer [SYBwithOA.Examples](https://github.com/JasonCHU/SYBwithOA/tree/master/Examples).

## Why use this library?

Some advantages of __Shy__ are:

- __Implemented in plain Java__: This project contains the complete source code of __Shy_, and it's written in plain Java using Java reflection and annotations. Users can easily export this project to create a _.jar_ file. It's a light-weighted library for use.

- __Boilerplate code avoided__: Generic traversals are generated automatically for user-defined data structures annotated with "@Algebra". In that case boilerplate traversal code is avoided and the code users have to write is much shorter.

- __Adaptive and structure shy__: The generated traversals are structure-shy and adaptive to future extensions. Extensibility in both dimensions, including structures and behaviours, is inherited from Object Algebras. Moreover, __Shy__ supports separate compilation.

- __Type-safe__: Type safety is guaranteed by Java type system, and no runtime casts are needed for traversal code.

## How to use?

To use this library, download [Library.jar](https://github.com/JasonCHU/SYBwithOA/blob/master/Library.jar) file at the main repository, or you may also export the library yourself from this Java project. 

Include Library.jar in the Java build path of your project. Also include Library.jar in the factory path of your project, that is, Java Compiler - Annotation Processing - Factory Path if you are using Eclipse. 

Now create your first interface with @Algebra annotation. All default extended OA interfaces such as queries, transformations will be created at their corresponding packages. 

```java
import com.zewei.annotation.processor.Algebra;

@Algebra
public interface ExpAlg<Exp> {
	Exp Var(String s);
	Exp Lit(int i);
	Exp Add(Exp e1, Exp e2);
}
```

The following code will be generated automatically in the package "query". 

```java
package query;

import library.Monoid;
import com.ExpAlg;

public interface ExpAlgQuery<R> extends ExpAlg<R> {

	Monoid<R> m();

	default R Add(R p0, R p1) {
		R res = m().empty();
		res = m().join(res, p0);
		res = m().join(res, p1);
		return res;
	}

	default R Lit(int p0) {
		R res = m().empty();
		return res;
	}

	default R Var(java.lang.String p0) {
		R res = m().empty();
		return res;
	}

}
```

Check out other auto-generated code by yourself. 

If they are not created automatically, build your project manually. Another possible reason is that the auto-generated packages are hidden by default, you may set the default generated source directory to be "src". In Eclipse, that is at the setting of Java Compiler - Annotation Processing - Generated Source Directory. Warning: This library may pollute the packages as 4 packages namely "combinator", "query", "transform" and "util" will be created at the root directory. 
