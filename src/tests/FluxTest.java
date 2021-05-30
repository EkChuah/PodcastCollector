package tests;
import interpreteur.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FluxTest {
	protected Flux f;
	ArrayList<Media> listAudio;
	
	@Before
	public void setUp() throws Exception {
		f = new Flux();
		listAudio = new ArrayList<>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		listAudio = f.fluxRadio("flux/fluxFranceInter.xml");
	}
	
	@Test
	public void test2() {
		listAudio = f.fluxRadio("flux/fluxFranceInter.xml");
		assertEquals("http://rf.proxycast.org/1650348438665043968/13939-17.12.2019-ITEMA_22232010-0.mp3",listAudio.get(0).getUrl());
		}
	
	
	@Test
	public void test3() {
		listAudio = f.fluxRadio("flux/fluxFranceInter.xml");
		assertEquals("Nagui",listAudio.get(0).getAuteur());
		
	}
	

}
