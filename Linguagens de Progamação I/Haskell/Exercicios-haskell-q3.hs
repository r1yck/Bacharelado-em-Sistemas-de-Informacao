main :: IO ()
parouimpar :: Int -> String
parouimpar n
  | n `rem` 2 == 0 = "O numero e par."
  | otherwise = "O numero e impar."
main = do
  putStrLn "\nDigite um numero."
  n <- readLn
  putStrLn ("\n" ++ show (parouimpar n))