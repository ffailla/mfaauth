package mfaauth;

import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.google.android.apps.authenticator.Base32String;
import com.google.android.apps.authenticator.PasscodeGenerator;
import com.google.android.apps.authenticator.Base32String.DecodingException;

public class Authenticator {

    public static final long INTERVAL = 30L;
    
    public static long getTotpState(long step) {
	long time = System.currentTimeMillis() / 1000;
	if (time >= 0) {
	    return time / step;
	} else {
	    return (time - (step - 1)) / step;
	}
    }
    
    public static String getCheckCode(String secret) throws GeneralSecurityException, DecodingException {
	byte[] kb = Base32String.decode(secret);
	Mac mac = Mac.getInstance("HMACSHA1");
	mac.init(new SecretKeySpec(kb, ""));
	PasscodeGenerator pcg = new PasscodeGenerator(mac);
	long state = getTotpState(INTERVAL);
	return pcg.generateResponseCode(state);
    }
	  
    public static void main(String[] args) {
	try {
	    String key = "7777777777777777"; //=>167857
	    System.out.println(getCheckCode(key));
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
