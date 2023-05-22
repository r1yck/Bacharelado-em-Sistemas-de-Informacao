main :: IO ()
pot :: Float -> Float -> Float
pot a b
  | b == 0 = 1
  | b > 0 = a * pot a (b - 1)
  | b < 0 = 1 / pot a (-b)
main = do
  putStrLn ("\nDigite o valor A.")
  a <- readLn
  putStrLn ("\nDigite o valor B.")
  b <- readLn
  putStrLn ("\nA elevado a B = " ++ show (pot a b))