//VisibleLatticePoints1047.c
#include <stdio.h>
int gcd(int a, int b){
    if(a==0)return b;
    return gcd(b%a,a);
}

int main(void){
    int points[1001];
    int t,n;
    points[0]=0;
    points[1]=3;
    for(int x = 2; x < 1001; x++){
		int sum = 0;
		for(int y = 1; y < x; y++){
            if(x<y){
                int aux= x;
                x=y;
                y=aux;
            }
			if(gcd(x,y) == 1) sum++;
		}
		points[x] = points[x-1] + 2 * sum;
	}
    scanf("%d", &t);
    for(int i=1; i<=t;i++){
        scanf("%d", &n);
        printf("%d %d %d\n", i, n,points[n]);
    }
    return 0;
}