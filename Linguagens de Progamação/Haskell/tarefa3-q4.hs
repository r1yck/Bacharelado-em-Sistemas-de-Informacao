{- main :: IO ()
maior2 :: Float -> Float -> Float -> String
maior2 v1 v2 v3 =
  if v1 > v2 && v1 > v3
    then "Valor 1 maior."
    else
      if v2 > v1 && v2 > v3
        then "Valor 2 maior"
        else
          if v3 > v1 && v3 > v2
            then "Valor 3 maior."
            else "Valores iguais."
main = do
  putStrLn ("\nDigite o valor 1.")
  v1 <- readLn

  putStrLn ("\nDigite o valor 2.")
  v2 <- readLn

  putStrLn ("\nDigite o valor 3.")
  v3 <- readLn

  putStrLn ("\n" ++ show (maior2 v1 v2 v3)) -}

main :: IO ()
maior2 :: Float -> Float -> Float -> String
maior2 v1 v2 v3
  | v1 > v2 && v1 > v3 = "Valor 1 maior."
  | v2 > v1 && v2 > v3 = "Valor 2 maior."
  | v3 > v1 && v3 > v2 = "Valor 3 maior."
  | otherwise = "Valores iguais."
main = do
  putStrLn ("\nDigite o valor 1.")
  v1 <- readLn

  putStrLn ("\nDigite o valor 2.")
  v2 <- readLn

  putStrLn ("\nDigite o valor 3.")
  v3 <- readLn

  putStrLn ("\n" ++ show (maior2 v1 v2 v3))
