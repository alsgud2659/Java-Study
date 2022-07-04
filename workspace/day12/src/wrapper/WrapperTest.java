package wrapper;

public class WrapperTest {
	public static void main(String[] args) {
		int data_i = 10;
		
		//boxing
//		Integer data_I = new Integer(data_i);
		
		//auto boxing
		Integer data_I = data_i;
		
		//unboxing
//		data_i = data_I.intValue();
		
		//auto unboxing
		data_i = data_I;
		
	}
}
