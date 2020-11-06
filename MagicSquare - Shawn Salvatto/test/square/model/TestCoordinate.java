package square.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestCoordinate {

	@Test
	public void testEquals() {
		Coordinate c1 = new Coordinate(1,2);
		assertFalse (c1.equals(null));
		assertFalse (c1.equals("somehitn"));
		

		assertEquals ("(1,2)", c1.toString());
	}

}
