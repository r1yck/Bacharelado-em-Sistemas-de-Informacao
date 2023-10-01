main :: IO ()
maior2 :: Float -> Float -> Float -> String
maior2 v1 v2 v3
  | v1 > v2 && v1 > v3 = "O valor 1 e o maior."
  | v2 > v1 && v2 > v3 = "O valor 2 e o maior."
  | v3 > v1 && v3 > v2 = "O valor 3 e o maior"
  | otherwise = "Valores Iguais."
main = do
  putStrLn ("\nDigite o valor 1.")
  v1 <- readLn

  putStrLn ("\nDigite o valor 2.")
  v2 <- readLn

  putStrLn ("\nDigite o valor 3.")
  v3 <- readLn

  putStrLn ("\n" ++ show (maior2 v1 v2 v3))