class Solution {
    Stack<Integer> st;
    StringBuilder sb;
    public String decodeString(String s) {
        st= new Stack<>();
        sb= new StringBuilder();
        solve(0, sb, s);
        return sb.toString();
    }
    public void solve(int i, StringBuilder sb, String s){
        while(i<s.length()){
            int a= 0;
            if(Character.isDigit(s.charAt(i))){
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    a= a*10+(s.charAt(i)-'0');
                    i++;
                }
                i++;
                StringBuilder sb2= new StringBuilder();
                solve(i, sb2, s);
                for(int j=0; j<a; j++){
                    sb.append(sb2.toString());
                    
                }
                int count=1;
                while(i<s.length() && count>0){
                    if(s.charAt(i)=='[') count++;
                    else if(s.charAt(i)==']') count--;
                    i++;
                }
            }
            else if(s.charAt(i)==']'){
                return;
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
    }
}