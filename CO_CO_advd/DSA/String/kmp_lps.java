package DSA.String;


public class kmp_lps{
    static int longestPrefixAlsoSuffix(String pat){
        
        int i=1;
        int len =0;
        int[] lps  = new int[pat.length()];
        lps[0]=0;
        int max = 0;

        while(i<pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                lps[i] = len+1;
                max = Math.max(max, lps[i]);
                len+=1;
                i+=1;
            } else {
                if(len !=0){
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i+=1;
                }
            }

        }

        return lps[pat.length()-1];
    }
}




























