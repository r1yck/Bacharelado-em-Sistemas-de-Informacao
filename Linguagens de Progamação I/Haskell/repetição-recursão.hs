main :: IO ()
fat :: Float -> Float
fat n
  | n == 0 = 1
  | otherwise = n + fat (n - 1)
main = do
  putStrLn ("\nDigite um numero.")
  n <- readLn
  putStrLn ("\nFatorial = " ++ show (fat n))

{- Em Haskell, não existe repetição, usamos recursão -}