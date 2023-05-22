main :: IO ()
hs :: Int -> Int
hs h = h * 3600

ms :: Int -> Int
ms m = m * 60

main = do
  putStrLn ("\nDigite a hora.")
  h <- readLn

  putStrLn ("\nDigite o minuto.")
  m <- readLn

  putStrLn ("\nHoras e minutos em segundos: " ++ show (hs h + ms m))