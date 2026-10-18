class Solution {
    public int appendCharacters(String s, String t) {
        int i=0,j=0;
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        int m=a.length,n=b.length;
        while(i<m&&j<n){
            if(a[i]==b[j]){
                i++;j++;
            }else{
                i++;
            }
        }
        return n-j;
    }
}