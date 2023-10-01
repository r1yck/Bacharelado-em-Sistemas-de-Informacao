main :: IO ()
calcularImposto :: Double -> (Double, Double, Double)
calcularImposto salario = (salario, imposto, salarioLiquido)
  where
    imposto = salario * 0.275
    salarioLiquido = salario - imposto
main = do
  let salario = 3000.0
  let (salarioBruto, imposto, salarioLiquido) = calcularImposto salario
  putStrLn $ "Salario bruto: " ++ show salarioBruto
  putStrLn $ "Imposto a pagar: " ++ show imposto
  putStrLn $ "Salario liquido: " ++ show salarioLiquido