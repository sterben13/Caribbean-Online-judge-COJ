#include <stdio.h>
int main(void){
    long d, v, di;
    scanf("%ld %ld", &d, &v);
    di=v*(v-3)/2;
    printf(di==d?"yes\n":"no\n");
    return 0;
}