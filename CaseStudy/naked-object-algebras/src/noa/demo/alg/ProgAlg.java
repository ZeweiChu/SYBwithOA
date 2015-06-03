package noa.demo.alg;

import noa.annos.Syntax;

public interface ProgAlg<P, E> {
	@Syntax("prog = exp")
	P start(E e);
}
