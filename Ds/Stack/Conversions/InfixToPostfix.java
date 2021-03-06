package CONVERSIONS;
import java.util.Scanner;
import java.util.Stack;


public class InfixToPostfix
{
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
System.out.print("Scan Testcases: ");
int T=Integer.parseInt(sc.nextLine());
while(T-- > 0)
{
System.out.print("Scan INFIX: ");
String str=sc.nextLine();

System.out.println("POSTFIX: "+ InfixToPostfixUtil(str));
}
}


public static String InfixToPostfixUtil(String str)				//INFIX_TO_POSTFIX METHOD
{
Stack<Character> s1=new Stack<>();						//STACK

str+=')';
s1.push('(');

System.out.println("STRING: "+str);
String E="";									//POSTFIX EXPRESSION

for(int i=0;i<str.length();i++)
{
char c=str.charAt(i);								//CURRENT CHARACTER


//CASE OF OPERANDS:-
if(Character.isDigit(c) || Character.isLetter(c))
{
System.out.println("OPERAND=> "+c);
E+=c;
System.out.println("EXPRESSION: "+E);
}


//CASE OF OPENING BRACES:-
if(c == '(')
{
s1.push(c);
System.out.println("\'"+c+"\' pushed to stack");
}


//CASE OF OPERATOR:-
if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '$')
{
if(getPresidance(s1.peek()) >= getPresidance(c))
{
while(!s1.isEmpty() && s1.peek() != '(') E+=s1.pop();
System.out.println("EXPRESSION: "+E);
System.out.println("PEEK: "+s1.peek());
}
System.out.println("OPERATOR: "+c);
System.out.println("\'"+c+"\' pushed to stack");
s1.push(c);
}


//CASE OF CLOSING BRACES:-
if(c == ')' || c == '}' || c == ']' && !s1.isEmpty())
{
while(!s1.isEmpty() && s1.peek() != '(') E+=s1.pop();
s1.pop();
}
System.out.println("\n");
}
return E;									//POSTFIX EXPRESSION
}


private static int getPresidance(char item)					//PRESIDANCE METHOD
{
if(item == '+' || item == '-') return 1;
if(item == '*' || item == '/') return 2;
if(item == '^' || item == '$') return 3;
return 0;
}
}

/*
#TESTCASES:-

 ((x+y)^a)+((x-c)/b)
 =>xy+a^xc-b/+

 a+b*(c^d-e)^(f+g*h)-i
 =>abcd^e-fgh*+^*+i-

 A*(B+C)/D
 =>ABC+*D/
 
 (A-(B+C))*D
 =>ABC+-D*
*/
