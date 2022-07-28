public class utils {
    public boolean isSubsequence(String s, String t) {
        int ind=0;
        if (s.length()>t.length())
            return false;
        if (s=="")return  false;
        for (int i=0;i<t.length();i++)
        {
            if (s.charAt(ind)==t.charAt(i))
                ind++;

            if (ind==s.length())
                return  true;
        }
        return  false;



    }

    public static void main(String[] args) {
        utils s=new utils();

        boolean r=s.isSubsequence( "", "ahbgdc");
        System.out.println(r);
    }
}