main :: IO ()
imc :: Double -> Double -> String
imc peso altura
  | peso / (altura * altura) < 18.5 = "Abaixo do peso."
  | peso / (altura * altura) >= 18.5 && peso / (altura * altura) < 25 = "Peso normal."
  | peso / (altura * altura) >= 25 && peso / (altura * altura) <= 30 = "Acima do peso."
  | peso / (altura * altura) > 30 = "Obeso."
  | otherwise = "Dados inválidos."
main = do
  putStrLn "\nDigite o peso em kg:"
  peso <- readLn
  putStrLn "\nDigite a altura em metros:"
  altura <- readLn
  putStrLn ("\nCondição de peso: " ++ show (imc peso altura))
