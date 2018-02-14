//SideoftheRhombus1214
#include <stdio.h>
#include <math.h>

double sideC(double a, double s){
    return sqrt(pow(s,2) - (4 * a))/2;
}

int main(void){
    int t;
    double a, s, side;
    scanf("%d", &t);
    while(t--){
        scanf("%lf %lf", &a, &s);
        side = sideC(a, s);
        printf("%.2f\n",side);
    }
    return 0;
}