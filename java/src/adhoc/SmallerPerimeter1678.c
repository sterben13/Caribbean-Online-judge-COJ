#include <stdio.h>
#ifndef max
    #define min(a,b) ((a) < (b) ? (a) : (b))
#endif

int isTriangle(long a, long b, long c) {
    return ((a + b) > c && (a + c) > b && (c + b) > a)?1:0;
}

int main(void){
    int n;
    long a, b, c, m=2147483647;
    scanf("%d", &n);
     while(n--){
        scanf("%ld %ld %ld", &a, &b, &c);
        if(isTriangle){
            m= min(m, (a+b+c));
        }
    } 
    printf("%d\n",m);
    return 0;
}

#include <iostream>
#include <string>


using namespace std;
static const string dishonest="Stan is dishonest";
static const string honst="Stan may be honest";
static const string TooLow="too low";
static const string TooHigh="too high";
static const string Bingo="right on";
int main(){
    string currentResult;
    int Highest=11;
    int Lowest=0;
    int currentAnswer=0;
    do{
        cin>>currentAnswer;
        cin.get();
        if (currentAnswer!=0){
            getline(cin,currentResult);
            if (currentResult.compare(TooHigh)==0){
                if(currentAnswer<Highest)
                    Highest=currentAnswer;
                } else if (currentResult.compare(TooLow)==0){
                    if (currentAnswer>Lowest)
                        Lowest=currentAnswer;
                } else if (currentResult.compare(Bingo)==0){
                    if (currentAnswer>=Highest||currentAnswer<=Lowest){
                        cout<<dishonest<<endl;
                    } else
                        cout<<honst<<endl;
                        Highest=11;
                        Lowest=0;
                }
        }
    } while (currentAnswer!=0);
    return 0;
}