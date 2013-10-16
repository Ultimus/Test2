maximum' :: (Ord a) => [a] -> a
maximum' [] = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
	| x > maxTail = x
	| otherwise = maxTail
	where maxTail = maximum' xs


sum' 1 = 1+2
sum' x = x+2 + sum' (x-1) 

sum'' 1 = 1
sum'' x = x+ sum''(x-1)
