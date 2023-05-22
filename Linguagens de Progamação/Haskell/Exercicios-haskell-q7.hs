main :: IO ()
somaparouimpar :: Int -> Int
somaparouimpar n
  | n `rem` 2 == 0 = n + 5
  | otherwise = n + 8
main = do
  putStrLn "\nDigite um numero."
  n <- readLn
  if n `rem` 2 == 0
    then putStrLn ("\nEste número somado 5 é: " ++ show (somaparouimpar n))
    else putStrLn ("\nEste número somado 8 é: " ++ show (somaparouimpar n))