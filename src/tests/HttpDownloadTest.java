package tests;
import interpreteur.*;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpDownloadTest {
	protected HttpDownload http;
	protected String adresseURL;
	protected String name;
	
	
	@Before
	public void setUp() throws Exception {
		adresseURL = "http://www.2hdp.fr/culture/culture.xml";
		name = "testJUnit.xml";
		http = new HttpDownload(adresseURL,name);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		http.downloadUsingStream();
		assertEquals(1,http.verifExist());	
	}

}
