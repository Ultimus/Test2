import Data.List

-- 1b)
oneB = filter even [0..1000]

--1c)
oneC = takeWhile (<1000) $ map (\x-> x*x) [0..]  



--1.3a)
factors :: Integer -> [Integer]
factors n = [x|x <- [1..n-1], (mod n x) == 0] 

is_perfect :: Integer -> Bool
is_perfect n = (sum (factors n)) == n


--next_perfect n = drop n ( take n+1 ( takeWhile is_perfect [1..]))

fibs :: [Integer]
fibs = 0 : 1 : (zipWith (+) fibs (tail fibs))

--fib n = take n fibs

oneFive xs = nub xs
