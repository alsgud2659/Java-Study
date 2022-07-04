package ambiguity;

public class ClassC implements InterA, InterB{
	@Override
	public void printData() {
		InterB.super.printData();
	}
}
