main = do
  putStrLn "Digite o nome da pessoa: "
  nome <- getLine
  putStrLn "Digite o sexo da pessoa (M/F): "
  sexo <- getLine
  putStrLn "Digite o estado civil da pessoa (SOLTEIRO/CASADO): "
  estadoCivil <- getLine
  if sexo == "F" && estadoCivil == "CASADO"
    then do
      putStrLn "Digite o tempo de casamento em anos: "
      tempoCasamento <- getLine
      putStrLn $ "A pessoa de nome " ++ nome ++ " está casada há " ++ tempoCasamento ++ " anos."
    else putStrLn $ "A pessoa de nome " ++ nome ++ " não está casada."
