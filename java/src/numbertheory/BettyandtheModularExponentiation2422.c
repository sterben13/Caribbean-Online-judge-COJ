/**
* Judge Online: Caribbean Online Judge.
* URL: http://coj.uci.cu/24h/problem.xhtml?pid=2422
* Problem: 2422 - Betty and the Modular Exponentiation
* Description
*
* Betty likes integer–number mathematics, and knows that calculating something like a^b
* can produce rather large results when a and b are suﬃciently big. Furthermore, Betty is 
* only interested in knowing the last 9 digits from a^b. For this reason, she has hired you,
* a member of the Union for Tremendous Powers (UTP), to tell her the 9 least signiﬁcant digits 
* from the exponentiation.
**/
#include <stdio.h>
#define mod 1000000000

long long power(long long x, long long y){
    long long int res = 1;      // Initialize result
    x = x % mod;  // Update x if it is more than or 
     while (y > 0){
        if (y & 1)
            res = ((res%mod)*(x%mod)) % mod;
         y = y>>1; // y = y/2
        x = ((x%mod)*(x%mod)) % mod;  
    }
    return res;
}

int main(void){
    int t;
    long long a, b;
    scanf("%d", &t);
    while(t--){
        scanf("%ld %ld", &a, &b);
        printf("%lld\n", power(a,b));
    }
    return 0;
}