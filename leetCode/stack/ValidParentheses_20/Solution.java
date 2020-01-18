import java.util.Stack;

class Solution {

    char getOpeningBracket(char closingBracket) {
        switch (closingBracket){
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return 0;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!characterStack.isEmpty() &&
                    (characterStack.peek() == getOpeningBracket(s.charAt(i)))) {
                characterStack.pop();
            } else {
                characterStack.push(s.charAt(i));
            }
        }
        return characterStack.isEmpty();
    }
}