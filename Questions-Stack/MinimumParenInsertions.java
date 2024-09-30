public class MinimumParenInsertions {
    public int minInsertions(String s) {

        int open = 0; // Keeps track of '(' that need two ')'
        int insertions = 0; // Keeps track of the number of insertions required

        int i = 0;
        while (i < s.length()) {
            if(s.charAt(i) == '('){
                open++;
            } else{
                if(i + 1 < s.length() && s.charAt(i+1) == ')'){
                    if(open > 0){
                        open--;
                    } else{
                        insertions++;
                    }
                    i++;
                } else{
                    if(open > 0){
                        open--;
                        insertions++;
                    } else{
                        insertions += 2;
                    }
                }
            }
            i++;
        }

        return insertions + open * 2;
    }

    // public int minInsertions(String s){
    //     int opening = 0;
    //     int closing = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         if(s.charAt(i) == '('){
    //             opening++;
    //         } else{
    //             closing ++;
    //         }
    //     }
    //     return Math.abs(opening * 2 - closing);
    // }
}

