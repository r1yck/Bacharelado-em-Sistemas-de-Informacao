main :: IO ()
an :: Int -> Int -> Int
an a i = a - i
main = do
  putStrLn ("\nDigite o ano atual.")
  a <- readLn
  putStrLn ("\nDigite sua idade esse ano.")
  i <- readLn
  putStrLn ("\nSeu ano de nascimento e: " ++ show (an a i))