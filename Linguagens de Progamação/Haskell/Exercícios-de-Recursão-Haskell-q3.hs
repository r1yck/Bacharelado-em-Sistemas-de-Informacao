main :: IO()
mdc :: Int -> Int -> Int
mdc n1 n2
  | mod n1 n2 == 0 = n2
  | mod n2 n1 == 0 = n1
  | n1 > n2 = mdc n2 (mod n1 n2)
  | n1 < n2 = mdc n1 (mod n2 n1)
main = do
  putStrLn ("\nDigite o numero 1.")
  n1 <- readLn
  putStrLn ("\nDigite o numero 2.")
  n2 <- readLn
  putStrLn ("\nMaximo divisor comum: " ++ show (mdc n1 n2))