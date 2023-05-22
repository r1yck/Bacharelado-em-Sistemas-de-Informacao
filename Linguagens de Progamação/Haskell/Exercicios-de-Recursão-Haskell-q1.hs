main :: IO ()
soma :: Float -> Float
soma n
  | n == 1 = 1
  | otherwise = n + soma (n - 1)
main = do
  putStrLn ("\nSomatoria de 1 a N, digite o valor para N.")
  n <- readLn
  putStrLn ("\nSomatoria = " ++ show (soma n))