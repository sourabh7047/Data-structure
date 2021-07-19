#include <bits/stdc++.h>
using namespace std;

#define MAX 1E9

int main(){
    long t;
    cin>>t;
    while(t--){
        long n,m; 

    cin>>n>>m;

    long a[n];
    long b[m];

    for (int i=0;i<n;i++){
        cin>>a[i];
    }

    for(int i=0;i<m;i++){
        cin>>b[i];
    }

    int primary[n];
    int forward=-1,backward=-1;

    for(int i=0;i<n;i++){
       if(i==0){
        primary[i]=0;
       }
       else if(a[i]!=0){
        primary[i]=0;
       }
       else{
        primary[i]=MAX;   
       } 
   }

   for(int i=0;i<n;i++){
       if(a[i]==1){
           forward=i;
       }

       if(forward!=-1){
           if(a[i]==0){
            primary[i]=min(primary[i],i-forward);
           }
       }
   }

    for(int i=n-1;i>=0;i--){
        if(a[i]==2){
            backward=i;  
        }

        if(backward!=-1){
            if(a[i]==0){ 
                primary[i] =min(primary[i],backward-i);
            }
        }
    }

    int j;
    for(int i=0;i<m;i++){
        j=b[i]-1;
        if(primary[j]!=MAX){
            cout<<primary[j]<<" ";
        }
        else{
            cout<<-1<<" ";
        }
    }
   cout<<endl;
    }
}