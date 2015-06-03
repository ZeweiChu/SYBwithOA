
set terminal postscript eps #color colortext

set key left

set grid ytics lt 0 lw 1 lc rgb "#bbbbbb"
set grid xtics lt 0 lw 1 lc rgb "#bbbbbb"


f(x) = A0*x
fit f(x) 'with-ast-0-1000-10-controlDeps.csv' every ::1 using 1:2 via A0
g(x) = A1*x
fit g(x) 'with-alg-0-1000-10-controlDeps.csv' every ::1 using 1:2 via A1

set output "controldeps.eps"
set title "Control Dependencies"
set xlabel "Input size (bytes)"
set ylabel "Running time (s)"
plot "with-ast-0-1000-10-controlDeps.csv" every ::1 using 1:2 \
     title "AST", \
     f(x) ls 0 title "Linear fit AST", \
     "with-alg-0-1000-10-controlDeps.csv" every ::1 using 1:2 \
     title "Object Algebra" pt 6, \
     g(x) ls 2 title "Linear fit ObjAlg"

set output "typeenv.eps"
set title "Extract type environment"
set xlabel "Input size (bytes)"
set ylabel "Running time (s)"
plot "with-ast-0-1000-10-typeEnv.csv" every ::1 using 1:2 \
     title "AST", \
     "with-alg-0-1000-10-typeEnv.csv" every ::1 using 1:2 \
     title "Object Algebra" pt 6

set output "renamevar.eps"
set title "Rename variable"
set xlabel "Input size (bytes)"
set ylabel "Running time (s)"
plot "with-ast-0-1000-10-rename.csv" every ::1 using 1:2 \
     title "AST", \
     "with-alg-0-1000-10-rename.csv" every ::1 using 1:2 \
     title "Object Algebra" pt 6

set output "inline.eps"
set title "Flatten conditions"
set xlabel "Input size (bytes)"
set ylabel "Running time (s)"
plot "with-ast-0-1000-10-inline.csv" every ::1 using 1:2 \
     title "AST", \
     "with-alg-0-1000-10-inline.csv" every ::1 using 1:2 \
     title "Object Algebra" pt 6


