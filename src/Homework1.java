/* Homework1.java */
import java.util.Random;


public class Homework1 {
	private static Random rand = new Random();
	final static int MAX = 54;
	
	/**
	 * getRandom
	 * �õ�һ�����ڲ����б��е�0~54�������
	 * @param numbers
	 * @return
	 */
	public static int getRandom(int...numbers){
		
		StringBuffer numberBuffer = new StringBuffer();
		for(int i : numbers) {
			numberBuffer.append(" " + i);
		}
		String numberList = numberBuffer.toString();
		System.out.println("Variable-Length Argument Lists : " + numberList);
		
		int random = 0;
		do {
			random = rand.nextInt(MAX) + 1;
		}while(numberList.indexOf(Integer.toString(random)) != -1);
		//���ֱ��ʹ����numberList.indexOf(random),�����鷢�ֲ���
		return random;
	}
	
	public static void main(String[] args) {

		
		int [] num = new int[30];
		for(int i=0;i<num.length;i++){
			num[i] = 2*i;
		}
		int i = Homework1.getRandom(num);
		System.out.println("Return: " + i);
	}
}
