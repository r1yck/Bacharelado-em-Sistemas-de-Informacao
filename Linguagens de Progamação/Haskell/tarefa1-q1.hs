main :: IO()

ac :: Float -> Float
ac r = (3.14 * r * r)

aq :: Int -> Int
aq l = (l * l)

at :: Float -> Float -> Float
at b h = ((b  *  h) / 2)

ar :: Int -> Int -> Int
ar b h = (b*h)

main = do
  putStrLn("\nDigite o valor do raio do circulo")
  r <- readLn
  putStrLn("Area do circulo = " ++show(ac r))

  putStrLn("\nDigite o valor do lado do quadrado ")
  l <- readLn
  putStrLn("Area do quadrado = " ++show(aq l))

  putStrLn("\nDigite o valor da base do triangulo ")
  b <- readLn
  putStrLn("Digite o valor da altura do triangulo ")
  h <- readLn
  putStrLn("Area do triangulo = " ++show(at b h))

  putStrLn("\nDigite o valor da base do retangulo ")
  b <- readLn
  putStrLn("Digite o valor da altura do retangulo ")
  h <- readLn
  putStrLn("Area do retangulo = " ++show(ar b h))