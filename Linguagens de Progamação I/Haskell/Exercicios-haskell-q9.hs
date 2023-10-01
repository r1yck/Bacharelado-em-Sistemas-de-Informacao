main :: IO ()
pesoideal :: String -> Double -> Double
pesoideal sexo h
  | sexo == "M" = (72.7 * h) - 58
  | sexo == "F" = (62.1 * h) - 44.7

main = do
  putStrLn "\nDigite seu sexo.(M ou F)"
  sexo <- getLine
  putStrLn "\nDigite sua altura."
  h <- readLn
  putStrLn ("\nSeu peso ideal: " ++ show (round(pesoideal sexo h)) ++ "kg.")
