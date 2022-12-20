public class BraceChecker {
    /**
     * The function should return true if the string parameter contains correctly nested
     * parenthesis (), square-braces [], and curly-braces {}
     * @param str
     * @return
     */
    public static boolean checkBraces(String str){
        GenericStack<Character> bStack = new GenericStack<>(20);
        char[] arr = str.toCharArray();
        for (char ele : arr){
            if (ele == '(' || ele == '[' || ele == '{'){
                bStack.push(ele);
            }
            if ((ele == ')') || (ele == ']') || (ele == '}')){
                if (bStack.isEmpty()){
                    return false;
                }
                if (ele==')' && bStack.peek()=='('){
                    bStack.pop();
                    continue;
                }
                if (ele==']' && bStack.peek()=='['){
                    bStack.pop();
                    continue;
                }
                if (ele=='}' && bStack.peek()=='{'){
                    bStack.pop();
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        if (!bStack.isEmpty()){
            return false;
        }
        return true;
    }
}
