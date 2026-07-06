class Solution {
    public String decodeString(String s) {
        while(s.contains("["))
        {
            int close = s.indexOf(']');
            int open = s.lastIndexOf('[',close);
            String inside = s.substring(open+1,close);
            int num = open-1;
            while(num>=0&&Character.isDigit(s.charAt(num)))
            {
                num--;
            }
            num++;
            int rc = Integer.parseInt(s.substring(num,open));
            StringBuilder repeat  = new StringBuilder();
            for(int i =0;i<rc;i++)
            {
                repeat.append(inside);
            }
            s = s.substring(0,num)+repeat.toString()+s.substring(close+1);
        }
        return s;
    }
}