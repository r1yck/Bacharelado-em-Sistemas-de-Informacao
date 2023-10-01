main :: IO ()
numDigito :: Float -> Float
numDigito n
  | n < 10 && n >= 0 = 1
  | otherwise = 1 + numDigito (n / 10)
main = do
  putStrLn ("\nDigite um numero.")
  n <- readLn
  putStrLn ("\nQuantidade de digitos: " ++ show (numDigito n))