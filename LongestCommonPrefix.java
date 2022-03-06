public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        StringBuilder prefix = new StringBuilder();
        boolean found = true;
        int pos =0;
        String word = strs[0];
        while(found){
            
            for(int i=1;i<strs.length;i++){
                if(pos>=word.length() || pos>=strs[i].length() || word.charAt(pos)!=strs[i].charAt(pos)){
                    found = false;
                    break;
                }
            }
            if(found){
                prefix.append(word.charAt(pos));
                pos++;
            }
        }
        return prefix.toString();
        
    }
}
