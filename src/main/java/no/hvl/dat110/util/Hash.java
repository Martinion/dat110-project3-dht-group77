package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			byte[] digest = messageDigest.digest(entity.getBytes());
			
			String hex = toHex(digest);
			
			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		BigInteger size = BigInteger.valueOf(2);
		
		for(int i = 0; i < bitSize()-1; i++) {
			size = size.multiply(BigInteger.valueOf(2));
		}
		
		return size;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			byte[] digest = messageDigest.digest("bitlengthdigesttest".getBytes());
			
			digestlen = digest.length;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
