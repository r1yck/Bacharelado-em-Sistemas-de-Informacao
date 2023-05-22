main :: IO ()
f :: Float -> Float
f c = (c * 1.8) + 32
main = do
  putStrLn ("\nDigite o valor em graus (C).")
  c <- readLn
  putStrLn ("\nValor em Farenheit (F): " ++ show (f c))