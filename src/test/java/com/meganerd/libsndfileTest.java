package com.meganerd;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class libsndfileTest {
	
    static Logger logger = Logger.getLogger(libsndfileTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.loadLibrary("libsndfile_wrap");
		System.loadLibrary("libsndfile-1");
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSf_open() {
		String filePath = "example_data/wav/example_1.wav";
		Assert.assertTrue("File doesn't exist at path: " + filePath, Files.exists(Paths.get(filePath)));
		
		SF_INFO sndInfo = new SF_INFO();
		SWIGTYPE_p_SNDFILE_tag sndFile = libsndfile.sf_open(filePath, libsndfile.SFM_READ, sndInfo);
		Assert.assertNotNull("Sound file should not be null", sndFile);
		
		Assert.assertEquals(0, libsndfile.sf_close(sndFile));
	}

	@Test
	public void testSf_open_checkFormat() {
		String filePath = "example_data/wav/example_1.wav";
		Assert.assertTrue("File doesn't exist at path: " + filePath, Files.exists(Paths.get(filePath)));
		
		SF_INFO sndInfo = new SF_INFO();
		SWIGTYPE_p_SNDFILE_tag sndFile = libsndfile.sf_open(filePath, libsndfile.SFM_READ, sndInfo);
		Assert.assertNotNull("Sound file should not be null", sndFile);
		
		Assert.assertEquals("Sound file format should be WAV: " + sndInfo.getFormat(), libsndfile.SF_FORMAT_WAV | libsndfile.SF_FORMAT_PCM_16, sndInfo.getFormat());
		logger.debug("channels: " + sndInfo.getChannels());
		
		Assert.assertEquals(0, libsndfile.sf_close(sndFile));
	}

	
//	@Test
	public void testSf_open_fd() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_open_virtual() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_error() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_strerror() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_error_number() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_perror() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_error_str() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_command() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_format_check() {
		/*
		SF_INFO sndInfo = new SF_INFO();
		Assert.assertEquals(1, libsndfile.sf_format_check(sndInfo));
		*/
	}

//	@Test
	public void testSf_seek() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_set_string() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_get_string() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_version_string() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_read_raw() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_write_raw() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_readf_short() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_writef_short() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_readf_int() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_writef_int() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_readf_float32() {
	}
	
//	@Test
	public void testSf_readf_float32_ex() {
	}
	
	@Test
	public void testSf_readf_float_CAF() {
		String filePath = "example_data/caf/example_2_8KHz_10db.CAF";
		Assert.assertTrue("File doesn't exist at path: " + filePath, Files.exists(Paths.get(filePath)));
		
		SF_INFO sndInfo = new SF_INFO();
		SWIGTYPE_p_SNDFILE_tag sndFile = libsndfile.sf_open(filePath, libsndfile.SFM_READ, sndInfo);
		Assert.assertNotNull("Sound file should not be null", sndFile);

		int arraySize = (sndInfo.getFrames() > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)sndInfo.getFrames());
		CArrayFloat farray = new CArrayFloat(arraySize);
		long count = libsndfile.sf_readf_float(sndFile, farray.cast(), sndInfo.getFrames());
		Assert.assertTrue("Sound file should have more than 0 frames: " + count, count > 0);
		
		Assert.assertEquals("Sound file format should be CAF: " + sndInfo.getFormat(), libsndfile.SF_FORMAT_CAF | libsndfile.SF_FORMAT_PCM_16, sndInfo.getFormat());
		logger.debug("channels: " + sndInfo.getChannels() + ", sample rate: " + sndInfo.getSamplerate() + "Hz, frame count: " + arraySize);
		
		Assert.assertEquals(0, libsndfile.sf_close(sndFile));
	}
	
	
	@Test
	public void testSf_readf_float_WAV() {
		String filePath = "example_data/wav/example_1.wav";
		Assert.assertTrue("File doesn't exist at path: " + filePath, Files.exists(Paths.get(filePath)));
		
		SF_INFO sndInfo = new SF_INFO();
		SWIGTYPE_p_SNDFILE_tag sndFile = libsndfile.sf_open(filePath, libsndfile.SFM_READ, sndInfo);
		Assert.assertNotNull("Sound file should not be null", sndFile);
	
		CArrayFloat farray = new CArrayFloat(sndInfo.getFrames() > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)sndInfo.getFrames());
		
		long count = libsndfile.sf_readf_float(sndFile, farray.cast(), sndInfo.getFrames());
		logger.debug(farray.getitem(0));
		Assert.assertTrue("Sound file should have more than 0 frames: " + count, count > 0);
		
		Assert.assertEquals("Sound file format should be WAV: " + sndInfo.getFormat(), libsndfile.SF_FORMAT_WAV | libsndfile.SF_FORMAT_PCM_16, sndInfo.getFormat());
		logger.debug("channels: " + sndInfo.getChannels());
		
		Assert.assertEquals(0, libsndfile.sf_close(sndFile));
	}

	@Test
	public void testSf_writef_float_CAF_from_WAV() throws IOException {
		String filePath = "example_data/caf/example_1_24KHz_10db.CAF";
		Assert.assertTrue("File doesn't exist at path: " + filePath, Files.exists(Paths.get(filePath)));
		
		SF_INFO sndInfo = new SF_INFO();
		SWIGTYPE_p_SNDFILE_tag sndFile = libsndfile.sf_open(filePath, libsndfile.SFM_READ, sndInfo);
		Assert.assertNotNull("Sound file should not be null", sndFile);
	
		int arraySize = (sndInfo.getFrames() > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)sndInfo.getFrames());
		CArrayFloat farray = new CArrayFloat(arraySize);
		
		long count = libsndfile.sf_readf_float(sndFile, farray.cast(), sndInfo.getFrames());
		logger.debug(farray.getitem(0));
		Assert.assertTrue("Sound file should have more than 0 frames: " + count, count > 0);
		
		Assert.assertEquals("Sound file format should be WAV: " + sndInfo.getFormat(), libsndfile.SF_FORMAT_CAF | libsndfile.SF_FORMAT_PCM_16, sndInfo.getFormat());
		logger.debug("channels: " + sndInfo.getChannels() + ", sample rate: " + sndInfo.getSamplerate() + "Hz, frame count: " + arraySize);
		
		Assert.assertEquals(0, libsndfile.sf_close(sndFile));
		
	
		// temporary output file
		Path path = Files.createTempFile("test_from_caf_to_wav", ".wav");
		logger.debug("temporary output file: " + path.toString());
		
		SF_INFO outsndInfo = new SF_INFO();
		outsndInfo.setFormat(libsndfile.SF_FORMAT_WAV | libsndfile.SF_FORMAT_PCM_16);
		outsndInfo.setChannels(sndInfo.getChannels());
		outsndInfo.setSamplerate(sndInfo.getSamplerate());
		
		SWIGTYPE_p_SNDFILE_tag outsndFile = libsndfile.sf_open(path.toString(), libsndfile.SFM_WRITE, outsndInfo);
		Assert.assertNotNull("Out sound file should not be null", outsndFile);

		long outcount = libsndfile.sf_writef_float(outsndFile, farray.cast(), sndInfo.getFrames());
		Assert.assertTrue("Sound file should have written more than 0 frames: " + outcount, outcount > 0);
		
		Assert.assertEquals(0, libsndfile.sf_close(outsndFile));
	}

//	@Test
	public void testSf_readf_double() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_writef_double() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_read_short() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_write_short() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_read_int() {
	}

//	@Test
	public void testSf_write_int() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_read_float() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_write_float() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_read_double() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_write_double() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_close() {
		fail("Not yet implemented");
	}

//	@Test
	public void testSf_write_sync() {
		fail("Not yet implemented");
	}

}
