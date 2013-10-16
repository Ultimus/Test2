import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConsCell {
	private double value;
	private ConsCell cell;

	@Test
	public void test_get_and_setValue() {
		ConsCell myCC = new ConsCell();
		myCC.setValue(1.0);

		assertEquals(1.0, myCC.getValue(), 1.0E-10);

		myCC.setValue(3.5);
		assertEquals(3.5, myCC.getValue(), 1.0E-10);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Test
	public void test_get_and_setNext() {
		ConsCell myCC = new ConsCell();
		ConsCell myCC2 = new ConsCell();
		myCC2.setValue(1.0);
		myCC.setNext(myCC2);

		assertEquals(myCC2, myCC.getNext());

		ConsCell myCC3 = myCC.getNext();
		assertEquals(1.0, myCC3.getValue(), 1.0E-10);

	}

	public ConsCell getNext() {
		return cell;
	}

	public void setNext(ConsCell cell) {
		this.cell = cell;
	}
}

	
