--a


--b

--c
cycle


--d
drop


--e
elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
	| a == x = True
	| otherwise = a `elem'` xs


--f
fst' :: (a,b) -> a
fst' (x,_) = x 

flip' :: (a -> b -> c) -> (b -> a -> c)
flip' f y x= f x y

filter :: (a-> Bool) -> [a] -> [a]
filter _ [] = []
filter p (x:xs)
	| p x = x:filter p xs
	| otherwise = filter p xs

foldl

foldr

foldl1

foldr1



--g


--h
head' :: [a] -> a
head' [] = error "Incorrect input"
head' (x:_) = x


--i
init


--j

--k

--l
last

lengt' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1+length' xs

--m
min x y = if x < y then x else y

max x y = if x > y then x else y

minimum' :: (Ord a ) => [a] -> a
minimum' [] = error "minimum of empty list"
minimum' [x] = x
minimum' (x:xs) = min x (minimum' xs)

maximum' :: (Ord a) => [a] -> a
maximum' [] = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs) = max x (maximum' xs)

map' :: (a -> b) -> [a] -> [b]
map' _ [] = []
map' f (x:xs) = f x : map f xs



--n
null --[1,2,3] False | null [] True

--o

--p
product

--q

--r
reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x]

repeat' :: a -> [a]
repeat' x = x:repeat' x

replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
	| n >= 0 []
	| otherwise = x:replicate' (n-1) x
--s
succ x  --increments a number

sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x+ sum' xs

snd' :: (a,b) -> b
snd' (a,b) = b

scanl

scanr

scanl1

scanr1

--t
tail

take' :: (Num i, Ord i) => i -> [a] -> [a]
take' n _
	|n <= 0 = []
take' _ [] 	= []
take' n (x:xs)  = x: take' (n-1) xs

takeWhile




--u

--v

--w

--x

--y


--z
zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip'[] _ = []
zip' (x:xs) (y:ys) = (x,y):zip' xs ys

zipWith' :: (a->b->c) -> [a] -> [b] -< [c]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys
