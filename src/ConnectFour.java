/*   MonteCarlo.java   */
import java.util.Random;
import java.util.Scanner;

enum Player {
	RED,
	YELLOW;
}

public class ConnectFour {
	final private Random rand = new Random();
	final private int ROW=6;
	final private int COLUMN=7;
	private char[][] board = new char[ROW][COLUMN];
	private Player player = Player.RED;
	
	/**
	 * ��ȡ��Ϸ��ǰ״̬
	 */
	public void getStatus() {
		for(char[] i : board){
			for(char j : i)
				System.out.print("|" + j);
			System.out.println("|");
		}
	}
	
	/**
	 * �������
	 */
	public void exchange() {

		if(player.equals(Player.RED))
			player = Player.YELLOW;
		else
			player = Player.RED;
	}
	
	/**
	 * ��ʼ��Ϸ
	 */
	public void begin(){
//		Scanner sc = new Scanner(System.in);
		int index = 0;
		game: while(true){
			System.out.println("-------------------------------");
			System.out.print("Drop a "+ player + " disk at column (0-6):");
			index = rand.nextInt(7);
			System.out.println(index);
//			index = sc.nextInt();
			
			
			if(index>COLUMN-1 || index<0) continue;
			int i=0;
			while(i<ROW && !Character.isLetter(board[i][index]))
				i++;
			
			
			if(i==0){
				System.out.println("This conlumn is full.");
				continue;
			}
			else {
				if(player.equals(Player.RED))
					board[i-1][index] = 'R';
				else
					board[i-1][index] = 'Y';
			}
			if(isOver(i-1,index)){
//				sc.close();
				return;
				
			}
			getStatus();
			exchange(); //�������
			
			for(char c:board[0]){
				if(!Character.isLetter(c)){
					continue game;
				}
			}
			player = null;
//			sc.close();
			return;
		}
	}
	
	/**
	 * �ж���Ϸ�Ƿ����
	 * @param row
	 * @param column
	 * @return
	 */
	public boolean isOver(int row,int column){
		int r = row, c = column;
		
		String check="";
		if(player.equals(Player.RED))
			check = "RRRR";
		else
			check = "YYYY";
		
		
		//�������Ƿ�������Ϸ����
		if(String.valueOf(board[row]).indexOf(check)>-1)
			return true;
		
		//�������Ƿ�������Ϸ����
		StringBuffer bufferColumn = new StringBuffer();
		for(int i=ROW-1;i>0;i--)
			bufferColumn.append(board[i][column]);
		if(bufferColumn.toString().indexOf(check)>-1)
			return true;
		
		
		//�������µ�����б���Ƿ�������Ϸ����
		if(row + column >= 4 && row + column <= 8){
			while(r<ROW-1 && c >0){
				r++;
				c--;
			}
			StringBuffer bufferDiagonal = new StringBuffer();
			while(r>=0 && c<COLUMN && Character.isLetter(board[r][c])){
				bufferDiagonal.append(board[r][c]);
				r--;
				c++;
			}
			if(bufferDiagonal.toString().indexOf(check)>-1)
				return true;
		}
		
		//�������ϵ�����б���Ƿ�������Ϸ����
		r = row;
		c = column;
		while(r<ROW-1 && c <COLUMN-1){
			r++;
			c++;
		}
		if(r+c>=8){
			StringBuffer bufferDiagonal2 = new StringBuffer();
			while(r>=0 && c>=0 && Character.isLetter(board[r][c])){
				bufferDiagonal2.append(board[r][c]);
				r--;
				c--;
			}
			if(bufferDiagonal2.toString().indexOf(check)>-1)
				return true;
		}
		
		return false;
		
	}
	public Player getPlayer(){
		return player;
	}
	
	public static void main(String[] args) {
	
		ConnectFour connectFour = new ConnectFour();
		connectFour.getStatus();
		connectFour.begin();
		connectFour.getStatus();
		System.out.println("-------------------------------");
		if(connectFour.getPlayer()!=null)
			System.out.println("The " + connectFour.getPlayer() + " player won");
		else
			System.out.println("Game Over: Draw!");
	}
	
}
