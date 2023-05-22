main :: IO ()
somaAB :: Int -> Int -> Int -> String
somaAB a b c
  | a + b < c = "A soma de A + B e MAIOR que C."
  | a + b > c = "A soma de A + B e MENOR que C."
main = do
  putStrLn ("\nDigite o valor A.")
  a <- readLn

  putStrLn ("\nDigite o valor B.")
  b <- readLn

  putStrLn ("\nDigite o valor C.")
  c <- readLn

  putStrLn ("\n" ++ show (somaAB a b c))