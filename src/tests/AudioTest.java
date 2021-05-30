package tests;
import interpreteur.*;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AudioTest {
	protected Audio a;
	Date d;
	
	@Before
	public void setUp() throws Exception {
		d = new Date();
		a = new Audio("France Inter","Radio France","petite description",d,"https://www.google.com", "OUI","NON", "arts" );
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = dateFormat.format(d);
		assertEquals("Audio{titre : France Inter, auteur : Radio France, description : petite description, date : " + strDate + 
				", url : https://www.google.com, format : OUI, urlImage : NON, category : arts}", a.toString());
	}

}