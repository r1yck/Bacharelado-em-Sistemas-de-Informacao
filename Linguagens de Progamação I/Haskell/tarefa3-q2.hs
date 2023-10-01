main :: IO ()
maior2 :: Float -> Float -> String
maior2 v1 v2 = if v1 > v2 then "O valor 1 e o maior." else "O valor 2 e o maior."
main = do
  putStrLn ("\nDigite o valor 1.")
  v1 <- readLn

  putStrLn ("\nDigite o valor 2.")
  v2 <- readLn

  putStrLn ("\n" ++ show (maior2 v1 v2))