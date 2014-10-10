/* MonteCarlo.java */
import java.util.Random;

/**
 * Point类：
 * 默认构造函数为随机生成一个横纵坐标均在[-1,1]之间的点
 * @author Yunpeng
 *
 */
class Point {
	public static Random rand = new Random();
	private double x;
	private double y;
	Point() {
		x = 2.0 * rand.nextDouble() - 1.0;
		y = 2.0 * rand.nextDouble() - 1.0;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
}


/**
 * MonteCarlo
 * @author Yunpeng
 *
 */
public class MonteCarlo {
	final static int TEST_TIMES = 1000000;
	private double[] result = new double[4];


	/**
	 * begin
	 * 开始模拟撒点
	 */
	public void begin(){
		int[] simulation = new int[4];
		
		for(int i=0;i<TEST_TIMES;i++){
			Point point = new Point();
			if(point.getX()<0)
				simulation[0]++;
			else if(point.getY()<0)
				simulation[3]++;
			else if(point.getX() + point.getY() < 1)
				simulation[2]++;
			else
				simulation[1]++;
		}
		result[0] = 1.0 * simulation[0] / TEST_TIMES;
		result[1] = 1.0 * simulation[1] / TEST_TIMES;
		result[2] = 1.0 * simulation[1] / TEST_TIMES;
		result[3] = 1.0 * simulation[1] / TEST_TIMES;
	}
	
	
	/**
	 * showResult
	 * 输出结果
	 */
	public void showResult(){
		System.out.format("Probability:\nRegion 1: %.2f%%\nRegion 3: %.2f%%",
					result[0]*100,result[2]*100);
	}
	
	public static void main(String[] args) {
		MonteCarlo monteCarlo = new MonteCarlo();
		monteCarlo.begin();
		monteCarlo.showResult();
	}
}
