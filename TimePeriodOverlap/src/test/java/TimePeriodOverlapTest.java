import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

public class TimePeriodOverlapTest {

	TimePeriod timePeriod;
	TimePeriod timePeriod2;
	
	@Before
	public void setUp(){
		timePeriod = new TimePeriod();
		timePeriod2 = new TimePeriod();
	}
	
	@Test
	public void testPeriodOverlap(){
		timePeriod = new TimePeriod(LocalTime.of(10, 40), LocalTime.of(23, 55));
		timePeriod2 = new TimePeriod(LocalTime.of(15, 40), LocalTime.of(22, 55));
			
		assertTrue(timePeriod.overlapsWith(timePeriod2));
	}
	
	@Test
	public void testInvalidInputValues(){
		timePeriod = null;
		timePeriod2 = new TimePeriod(LocalTime.of(15, 40), LocalTime.of(22, 55));
	
		try{
			timePeriod2.overlapsWith(timePeriod);
			fail();
		}catch(IllegalArgumentException e){
			assertEquals("invalid input", e.getMessage());
		}
	}
	
}
