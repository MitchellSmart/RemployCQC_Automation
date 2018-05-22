package testRailSupport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Functions {
	
    @SuppressWarnings("unused")
	public static String getStackTraceAsString(Throwable throwable) throws UnsupportedEncodingException {
        if (throwable == null)
        {
            return "";
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        throwable.printStackTrace(new PrintStream(os));
        String str = new String(os.toByteArray(), "UTF-8");
        str = "    " + str.replace("\n", "\n    ").replace("\t", "    "); //better printing
        return str;
    }

}
