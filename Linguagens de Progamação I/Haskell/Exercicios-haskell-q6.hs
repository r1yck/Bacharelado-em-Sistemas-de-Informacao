main :: IO ()
main = do
  putStrLn "Digite o primeiro valor booleano (True ou False):"
  valor1 <- readLn
  putStrLn "Digite o segundo valor booleano (True ou False):"
  valor2 <- readLn
  if valor1 && valor2
    then putStrLn "Ambos são verdadeiros."
    else
      if not valor1 && not valor2
        then putStrLn "Ambos são falsos."
        else putStrLn "Um é verdadeiro e o outro é falso."
