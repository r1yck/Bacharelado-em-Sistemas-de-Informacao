main :: IO ()
somaoumult :: Int -> Int -> Int
somaoumult a b
  | a == b = a + b
  | otherwise = a * b
main = do
  putStrLn "\nDigite o valor de A."
  a <- readLn
  putStrLn "\nDigite o valor de B."
  b <- readLn
  if a == b
    then do
      putStrLn ("\nA soma de A e B é: " ++ show (somaoumult a b))
    else putStrLn ("\nA multiplicação de A e B é: " ++ show (somaoumult a b))