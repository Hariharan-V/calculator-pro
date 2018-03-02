package Calculator;

import java.util.ArrayList;
/**
 *	This class solves simple mathematical expressions using order of operations 
 * @author Hariharan Vijayachandran & Zion Fung
 * @version 4.5 
 * @since 20161203
 * 
 * I pledge my honor that I have abided by the Stevens Honor System
 *
 */
public class evaluate {
	private static ArrayList<Character> operators = new ArrayList<Character>();
	private static ArrayList<Double> operands = new ArrayList<Double>();
    public static double pow(double x, double y){
        if(x<0&&(y<1)&&(1/y)%2!=0&&((int)(1.0/y)==(1.0/y))){
            return -1*Math.pow(-1*x, y);
        }
        return (y<0)?(1/Math.pow(x, -1*y)):Math.pow(x, y);
    }
/** 
 * Organizes the operators and operands so that they can be later evaluated
 * @param input & index
 * 
 */
	private static void organize(String input,int index) throws IllegalArgumentException{
		if((index<=input.length()-2)&&(input.charAt(index+1)!='-')&&(input.charAt(index)=='+'||input.charAt(index)=='*'||input.charAt(index)=='/'||input.charAt(index)=='^'||input.charAt(index)=='-')){
			if((index==0&&input.charAt(index)!='-')||input.charAt(index+1)=='+'||input.charAt(index+1)=='*'||input.charAt(index+1)=='/'||input.charAt(index+1)=='^'){
				throw new IllegalArgumentException("incorrect syntax");
			} 
			
			
			
			if(index==0&&input.charAt(index)=='-'){
				index++;
				while(index!=input.length()&&!(input.charAt(index)=='+'||input.charAt(index)=='*'||input.charAt(index)=='/'||input.charAt(index)=='^'||input.charAt(index)=='-')){
					index++;
				}
				
				try{
				operands.add(Double.parseDouble(input.substring(0,index)));
				organize(input,index);
				} catch (Exception e){
					
					throw new IllegalArgumentException("incorrect syntax");
				}
				
			}else{
				operators.add(input.charAt(index));
			organize(input,index+1);
			}
		} else if((index<=input.length()-2)&&(input.charAt(index)=='+'||input.charAt(index)=='*'||input.charAt(index)=='/'||input.charAt(index)=='^'||input.charAt(index)=='-')&&input.charAt(index+1)=='-'){
			
			operators.add(input.charAt(index));
			index+=1;
			int start = index;
			index++;
			while(index!=input.length()&&!(input.charAt(index)=='+'||input.charAt(index)=='*'||input.charAt(index)=='/'||input.charAt(index)=='^'||input.charAt(index)=='-')){
				index++;
			}
			
			try{
			operands.add(Double.parseDouble(input.substring(start,index)));
			organize(input,index);
			} catch (Exception e){
				
				throw new IllegalArgumentException("incorrect syntax");
			}
		}else if (index<input.length()){
			int start = index;
			while(index!=input.length()&&!(input.charAt(index)=='+'||input.charAt(index)=='*'||input.charAt(index)=='/'||input.charAt(index)=='^'||input.charAt(index)=='-')){
				index++;
			}
			try{
				//System.out.println(input.substring(start,index));
			operands.add(Double.parseDouble(input.substring(start,index)));
		
			
			organize(input,index);
			} catch (Exception e){
				
				throw new IllegalArgumentException("incorrect syntax");
			}
			
		}else{
			
			
		}
	//System.out.println(evaluate.operands+""+evaluate.operators);
	
	}
		
	/** 
	 * @param opands and oper
	 * @return the result of a calculation that just involves emdas of PEMDAS*/
		
	
	private static double fourfunc(ArrayList<Double> opands,ArrayList<Character> oper)throws IllegalArgumentException{
		int index = 0;
		if(oper.contains('^')){
				index = oper.indexOf('^');
				opands.set(index, pow(opands.get(index),opands.get(index+1)));
				opands.remove(index+1);
				oper.remove(index);
			
			return fourfunc(opands,oper);
		}else if(oper.contains('*')&&(oper.indexOf('/')==-1||oper.indexOf('*')<oper.indexOf('/'))){
			index = oper.indexOf('*');
			opands.set(index, opands.get(index)*opands.get(index+1));
			opands.remove(index+1);
			oper.remove(index);
			
		return fourfunc(opands,oper);		
		}else if(oper.contains('/')&&(oper.indexOf('*')==-1||oper.indexOf('*')>oper.indexOf('/'))){
			index = oper.indexOf('/');
			if(opands.get(index+1)!=0){
			opands.set(index, opands.get(index)/opands.get(index+1));
			opands.remove(index+1);
			oper.remove(index);
			
			return fourfunc(opands,oper);}else{
			
				throw new IllegalArgumentException("div by 0");
			}
				
		}else if((oper.contains('+'))&&(oper.indexOf('-')==-1||oper.indexOf('+')<oper.indexOf('-'))){
			index = oper.indexOf('+');
			opands.set(index, opands.get(index)+opands.get(index+1));
			opands.remove(index+1);
			oper.remove(index);
			
		return fourfunc(opands,oper);		
		}else if((oper.contains('-'))&&(oper.indexOf('+')==-1||oper.indexOf('+')>oper.indexOf('-'))){
			index = oper.indexOf('-');
			opands.set(index, opands.get(index)-opands.get(index+1));
			opands.remove(index+1);
			oper.remove(index);
			
		return fourfunc(opands,oper);		
		}else if(oper.size()==0||opands.size()==1){
			
			return opands.get(0);
		}else{
			
			throw new IllegalArgumentException("incorrect syntax");
		}
		
		
		
	}
	/** 
	 * @param input
	 * organizes the string so that parantheses can be taken care of*/
	private static String evalparanth(String input){
		if(input.lastIndexOf('(')!=-1){
			String x = input.substring(input.lastIndexOf('(')+1, input.indexOf(')', input.lastIndexOf('(')));
			
			organize(x,0);
			
			double y = fourfunc(operands,operators);
			evaluate.operands.removeAll(operands);
			evaluate.operators.removeAll(operators);
			input = input.substring(0,input.lastIndexOf('('))+y+input.substring(input.indexOf(')', input.lastIndexOf('('))+1,input.length());
			
				return evalparanth(input);
		}else{
			return input;
		}
		
	}
/** 
 * @param input
 * formats the input so that incase a number is followed by a  parantheses it gets dealth with without throwing an error*/	
private static String format(String input) throws IllegalArgumentException{
		
		for(int x = 1;x<input.length();x++){
			if(input.charAt(x)=='('&&(input.charAt(x-1)!='^'&&input.charAt(x-1)!='*'&&input.charAt(x-1)!='/'&&input.charAt(x-1)!='+'&&input.charAt(x-1)!='-'&&input.charAt(x-1)!='(')){
				input = input.substring(0,x)+"*"+input.substring(x,input.length());
				
				x++;
			}
		}
		return input;
	}
/** 
 * @param input
 * @return y
 * evaluates the expression and returns the result*/
	public static double evaluateexpression(String input){
		input = format(input);
		
		input = evalparanth(input);
		
		evaluate.operands.removeAll(operands);
		evaluate.operators.removeAll(operators);
		organize(input,0);
		double y = fourfunc(operands,operators);
		evaluate.operands.removeAll(operands);
		evaluate.operators.removeAll(operators);
		return y;
		
			
		}
	}
	



