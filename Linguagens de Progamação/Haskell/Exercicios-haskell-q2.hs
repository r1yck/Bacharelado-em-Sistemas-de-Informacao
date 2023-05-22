main :: IO ()
main = do
  putStrLn "\nDigite seu nome."
  nome <- getLine
  putStrLn "\nDigite seu sexo.(M ou F)"
  sexo <- getLine
  putStrLn "\nDigite seu estado civil.(SOLTEIRO ou CASADO)"
  estadocivil <- getLine

  if sexo == "F" && estadocivil == "CASADO"
    then do
      putStrLn "\nDigite o tempo de casada.(anos)"
      tempoCasada <- getLine
      putStrLn ("\nNome: " ++ nome ++ "\nSexo: " ++ sexo ++ "\nEstado Civil: " ++ estadocivil ++ "\nTempo de casada: " ++ tempoCasada ++ " anos")
    else putStrLn ("\nNome: " ++ nome ++ "\nSexo: " ++ sexo ++ "\nEstado Civil: " ++ estadocivil)
