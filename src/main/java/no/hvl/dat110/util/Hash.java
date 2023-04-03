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
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		try {		
			MessageDigest md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			byte[] hashIn = md.digest(entity.getBytes());
			// convert the hash into hex format
			String hexFormat = toHex(hashIn);
			// convert the hex into BigInteger
			hashint = new BigInteger(hexFormat, 16);
			// return the BigInteger
			
		} catch (NoSuchAlgorithmException e) {
		}
		
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		// compute the number of bits = bitSize()
		// compute the address size = 2 ^ number of bits
		BigInteger addressSize = new BigInteger("2");
		addressSize = addressSize.pow(bitSize());
		// return the address size
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
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
