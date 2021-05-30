package tests;
import interpreteur.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class MediaTest {
	protected Media m;
	protected String url;
	@Before
	public void setUp() throws Exception {
		Date date = Calendar.getInstance().getTime();
		m = new Media("Marseille", "JUL", "C'est une clip", date, "url.media");
		url = "https://www.google.com";
		m.setUrl(url);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(" Play : https://www.google.com", " Play : " + m.getUrl());
	}

}
