import java.io.*;import java.lang.*;import java.util.*;
//* --> number of prime numbers less then or equal to x are  -->  x/ln(x)
//* --> String concatenation using the + operator within a loop should be avoided. Since the String object is immutable, each call for concatenation will
// result in a new String object being created.
// THE SIEVE USED HERE WILL RETURN A LIST CONTAINING ALL THE PRIME NUMBERS TILL N
 public class b {static FastScanner sc;static PrintWriter pw;static class FastScanner {InputStreamReader is;BufferedReader br;StringTokenizer st;
public FastScanner() {is = new InputStreamReader(System.in);br = new BufferedReader(is);}
String next() throws Exception {while (st == null || !st.hasMoreElements())st = new StringTokenizer(br.readLine());
return st.nextToken();}int nextInt() throws Exception {return Integer.parseInt(next());}long nextLong() throws Exception {
return Long.parseLong(next());}int[] readArray(int num) throws Exception {int arr[]=new int[num];
for(int i=0;i<num;i++)arr[i]=nextInt();return arr;}String nextLine() throws Exception {return br.readLine();
}} public static boolean power_of_two(int a){if((a&(a-1))==0){ return true;}return false;}
static boolean PS(double x){if (x >= 0) {double i= Math.sqrt(x);if(i%1!=0){
return false;}return ((i * i) == x);}return false;}public static int[] ia(int n){int ar[]=new int[n];
return ar;}public static long[] la(int n){long ar[]=new long[n];return ar;}
public static void print(int ans,int t){System.out.println("Case"+" "+"#"+t+":"+" "+ans);}
static long mod=1000000007;static int max=Integer.MIN_VALUE;static int min=Integer.MAX_VALUE;
public static void sort(long[] arr){//because Arrays.sort() uses quicksort which is dumb
//Collections.sort() uses merge sort
ArrayList<Long> ls = new ArrayList<Long>();for(long x: arr)ls.add(x);Collections.sort(ls);
for(int i=0; i < arr.length; i++)arr[i] = ls.get(i);}public static long fciel(long a, long b) {if (a == 0)  return 0;return (a - 1) / b + 1;}
 static boolean[] is_prime = new boolean[1000001];static ArrayList<Integer> list = new ArrayList<>();
static long n = 1000000;public static void sieve() {Arrays.fill(is_prime, true);
is_prime[0] = is_prime[1] = false;for (int i = 2; i * i <= n; i++) {
if (is_prime[i]) {for (int j = i * i; j <= n; j += i)is_prime[j] = false;}}for (int i = 2; i <= n; i++) {
if (is_prime[i]) {list.add(i);}}}

                        // ----------   NCR   ---------- \

static int NC=100005;
static long inv[]=new long[NC];
static long fac_inv[]=new long[NC];
static long fac[]=new long[NC];public static void initialize()
{
    long MOD=mod;
   int  i;
    inv[1]=1;
    for(i=2;i<=NC-2;i++)
        inv[i]=(MOD-MOD/i)*inv[(int)MOD%i]%MOD; 
    fac[0]=fac[1]=1;
    for(i=2;i<=NC-2;i++)
        fac[i]=i*fac[i-1]%MOD;
    fac_inv[0]=fac_inv[1]=1;
    for(i=2;i<=NC-2;i++)
        fac_inv[i]=inv[i]*fac_inv[i-1]%MOD;
}
public static long  ncr(int  n,int  r)
{
    long MOD=mod;
    if(n<r) return 0;
    return (fac[n]*fac_inv[r]%MOD)*fac_inv[n-r]%MOD;
}
                        // ----------   NCR   ---------- \
                   
                       // ----------   FACTORS --------  \
static int div[][] = new int[1000001][];
public static void factors()
{
  int divCnt[] = new int[1000001];
                       
  for(int i = 1000000; i >= 1; --i) {
  for(int j = i; j <= 1000000; j += i)
  divCnt[j]++;
  }
                 
                   
  for(int i = 1; i <= 1000000; ++i)
  div[i] = new int[divCnt[i]];
                 
  int ptr[] = new int[1000001];
  for(int i = 1000000; i >= 1; --i) {
  for(int j = i; j <= 1000000; j += i)
  div[j][ptr[j]++] = i;
    }   
}    
                  // ----------   FACTORS --------  \

                // ------------- DSU ---------------\

static int par[]=new int[1000001];static int size[]=new int[1000001];
public static void make(int v){par[v]=v;size[v]++;} 
public static void union(int a,int b){a=find(a);b=find(b);
if(a!=b){if(size[a]<size[b]){int temp=a;a=b;b=temp;}par[b]=a;
size[a]++;}}public static int find(int v)
{if(v==par[v]){return v;}return par[v]=find(par[v]);}

                // ------------- DSU ---------------\                    
              static class pair{
                  int h;
                  int v;
                  pair(int h,int v)
                  {
                      this.h=h;
                      this.v=v;
                  }
              }          
public static void main(String args[]) throws java.lang.Exception {
sc = new FastScanner();pw = new PrintWriter(System.out);StringBuilder s = new StringBuilder();
int t=sc.nextInt();
while(t-->0)
{
 int n=sc.nextInt();
 int m=sc.nextInt();
 char ar[][]=new char[n][];
for(int i=0;i<n;i++)
{
    ar[i]=sc.next().toCharArray();
}
 List<pair> list=new ArrayList<>();
for(int i=0;i<n;i++)
{
    for(int j=0;j<m;j++)
    {
        if(ar[i][j]=='R')
        {
        int x[]=find(ar,i,j);
        list.add(new pair(x[0],x[1]));
        }
    }
}
int f=0;
Collections.sort(list,(a,b)->(a.v+a.h-b.v+b.h));
for(int i=1;i<list.size();i++)
{
    pair p=list.get(i);
   // System.out.println(p.h+" "+p.v);
    if(p.h<list.get(0).h||p.v<list.get(0).v)
    {
     f=1;
     s.append("NO");
     break;
    }
}
if(f==0)
{
s.append("YES");
}
if(t>0)
{
    s.append("\n");
}}
pw.print(s);pw.close();}
static int[] find(char ar[][],int i,int j)
{
    int v=0;
    int h=0;
    int x=1;
    int y=1;
    while(i-x>=0)
    {
    h++;
    x++;
    }
    while(j-y>=0)
    {
    v++;
    y++;
    }
    return new int[]{h,v};
}
}
