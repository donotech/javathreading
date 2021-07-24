echo "Enter first number"
read x
echo "Enter second number"
read y
(( sum=x+y ))
sum1=`expr $x + $y`
sum2=`echo $x + $y`

echo "The result of addition=$sum $sum1 $sum2 "

if (( $sum % 2 == 0 ))
then
	echo "Sum is even"
else
	echo "Sum is odd"
fi
