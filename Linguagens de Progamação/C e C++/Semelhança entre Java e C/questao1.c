#include <stdio.h>
#include <stdlib.h>

int main(void)
{

  double n1, n2, n3, media, ma;

  printf("Digite a nota 1.\n");
  scanf("%d", &n1);

  printf("Digite a nota 2.\n");
  scanf("%d", &n2);

  printf("Digite a nota 3.\n");
  scanf("%d", &n3);

  media = (n1 + n2 + n3) / 3;
  ma = (n1 + (n2 * 2) + (n3 * 3) + media) / 7;

  if (ma >= 9 && ma <= 10)
  {
    printf("Nota geral = A");
  }

  else if (ma >= 7.5 && ma < 9)
  {
    printf("Nota geral = B");
  }

  else if (ma >= 6 && ma < 7.5)
  {
    printf("Nota geral = C");
  }

  else if (ma >= 4 && ma < 6)
  {
    printf("Nota geral = D");
  }

  else if (ma >= 0 && ma < 4)
  {
    printf("Nota geral = E");
  }

  else
  {
    printf("Erro. \nAlguma nota foi inserida negativa ou maior que 10.");
  }

  return 0;
}