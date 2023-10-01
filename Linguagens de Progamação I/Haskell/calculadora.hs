main :: IO()

soma :: Int -> Int -> Int
soma a b = (a + b)

subtracao :: Int -> Int -> Int
subtracao c d = (c - d)

multiplica :: Int -> Int -> Int
multiplica e f = (e * f)

divide :: Float -> Float -> Float
divide g h = (g / h)

--main = do
--print(soma 7 5)
--print(subtracao 8 9)
--print(multiplica 6 3)
--print(divide 8 2)

main = do
  putStrLn("Digite o valor de a ")
  a <- readLn
  putStrLn("Digite o valor de b ")
  b <- readLn
  putStrLn("Soma = " ++show(soma a b))

  putStrLn("Digite o valor de c ")
  c <- readLn
  putStrLn("Digite o valor de d ")
  d <- readLn
  putStrLn("Subtracao = " ++show(subtracao c d))

  putStrLn("Digite o valor de e ")
  e <- readLn
  putStrLn("Digite o valor de f ")
  f <- readLn
  putStrLn("Multiplicacao = " ++show(multiplica e f))

  putStrLn("Digite o valor de g ")
  g <- readLn
  putStrLn("Digite o valor de h ")
  h <- readLn
  putStrLn("Divisao = " ++show(divide g h))