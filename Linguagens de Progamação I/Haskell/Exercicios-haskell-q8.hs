main :: IO ()
ordemdecrescente :: Int -> Int -> Int -> [Int]
ordemdecrescente n1 n2 n3
  | n1 > n2 && n1 > n3 && n2 > n3 = [n1, n2, n3]
  | n1 > n2 && n1 > n3 && n3 > n2 = [n1, n3, n2]
  | n1 > n2 && n1 > n3 && n3 == n2 = [n1, n3, n2]
  | n2 > n1 && n2 > n3 && n1 > n3 = [n2, n1, n3]
  | n2 > n1 && n2 > n3 && n3 > n1 = [n2, n3, n1]
  | n2 > n1 && n2 > n3 && n3 == n1 = [n2, n3, n1]
  | n3 > n1 && n3 > n2 && n1 > n2 = [n3, n1, n2]
  | n3 > n1 && n3 > n2 && n2 > n1 = [n3, n2, n1]
  | n3 > n1 && n3 > n2 && n2 == n1 = [n3, n2, n1]
  | n2 == n3 && n1 < n2 && n1 < n3 = [n2, n3, n1]
  | n1 == n3 && n2 < n1 && n2 < n3 = [n1, n3, n2]
  | otherwise = [n1, n2, n3]
main = do
  putStrLn "\nDigite o número 1."
  n1 <- readLn
  putStrLn "\nDigite o número 2."
  n2 <- readLn
  putStrLn "\nDigite o número 3."
  n3 <- readLn
  putStrLn ("\nNúmeros em ordem decrescente: " ++ show (ordemdecrescente n1 n2 n3))
