main :: IO ()
dobrooutriplo :: Int -> Int
dobrooutriplo n
  | n > 0 = n * 2
  | n < 0 = n * 3
  | otherwise = -1
main = do
  putStrLn "\nDigite um número negativo ou positivo."
  n <- readLn
  if n > 0
    then putStrLn ("\nO dobro do número é: " ++ show (dobrooutriplo n))
    else
      if n < 0
        then putStrLn ("\nO triplo do número é: " ++ show (dobrooutriplo n))
        else putStrLn "\nO número não pode ser 0."