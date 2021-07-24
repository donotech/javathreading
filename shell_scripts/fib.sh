#!/bin/bash

fib() {
	N=$1
	a=1
	b=1
	fn=0
	echo "The Fibonacci series is : "
	for (( i=0; i<N; i++ ))
	do
		echo "$a "
		fn=$((a + b))
		a=$b
		b=$fn
	done
}

fib 5
