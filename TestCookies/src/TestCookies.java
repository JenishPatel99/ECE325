import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ECE 325 - Fall 2020 <br/>
 * Assignment 2: Java regular expressions <br/>
 * Test cookies using regular expressions
 * <p>
 * 
 * @author <replace with your name>
 */
public class TestCookies {

	/**
	 * Verify a cookie and return the verification result
	 * 
	 * @param cookie The cookie string
	 * @return True for a legal cookie; false for an illegal one
	 */
	public static boolean verifyCookie(String cookie) {
		boolean legal = false;

		String digit = "[\\d]";
		String letter = "[a-zA-Z]";
		String letDig = "[a-zA-Z|0-9]";
		String ldh = "[a-zA-Z|0-9|\\-]";
		String ldhStr = "[a-zA-Z|0-9|\\-]+";
		String label = "[a-zA-Z]([a-zA-Z|0-9|\\-]+[a-zA-Z|0-9]*)?";
		String subdomain = String.format("(%s(\\.%s)*)", label, label);
		String domain = String.format("(\\.?%s)", subdomain);

		String httponlyAv = "HttpOnly";
		String secureAv = "Secure";
		String pathValue = "[^;\\p{Cntrl}]";
		String pathAv = String.format("(Path=%s)", pathValue);
		String domainAv = String.format("(Domain=%s?)", domain);
		String maxAgeAv = "Max-Age=.[1-9].[0-9]";
		String month = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)";
		String wkday = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun)";
		String date1 = String.format("%s{2} %s %s{4}", digit, month, digit);
		String time = String.format("%s{2}:%s{2}:%s{2}", digit, digit, digit);
		String rfc123Date = String.format("%s, %s %s GMT", wkday, date1, time);
		String expiresAv = String.format("(Expires=%s)", rfc123Date);
		String cookieAv = String.format("(%s|%s|%s|%s|%s|%s|)", expiresAv, maxAgeAv, domainAv, pathAv, secureAv,
				httponlyAv);
		String cookieOctet = "[\\x21\\x23-\\x2b\\x2d-\\x3a\\x3c-\\x5b\\x5d-\\x7e]";
		String cookieValue = String.format("\"%s*?\"|%s*", cookieOctet, cookieOctet);
		String seperators = "\\(\\)<>\\@,\\.,;:\\\\\"\\/\\[\\]\\?=\\{\\} \t";
		String token = String.format("[^%s]+", seperators);
		String cookieName = String.format("%s", token);
		String cookiePair = String.format("%s=(%s)", cookieName, cookieValue);
		String setCookieString = String.format("%s(; %s)*", cookiePair, cookieAv);
		String setCookieHeader = String.format("Set-Cookie: %s", setCookieString);

		Pattern p = Pattern.compile(setCookieHeader);
		Matcher m = p.matcher(cookie);

		legal = m.matches();
		// TODO: Assignment 2 -- compose your regular expression, and use it to verify
		// the cookie

		return legal;
	}

	/**
	 * Main entry
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		String[] cookies = {
				// Legal cookies:
				"Set-Cookie: ns1=\"alss/0.foobar^\"", // 01 name=value
				"Set-Cookie: ns1=", // 02 empty value
				"Set-Cookie: ns1=\"alss/0.foobar^\"; Expires=Tue, 18 Nov 2008 16:35:39 GMT", // 03 Expires=time_stamp
				"Set-Cookie: ns1=; Domain=", // 04 empty domain
				"Set-Cookie: ns1=; Domain=.srv.a.com-0", // 05 Domain=host_name
				"Set-Cookie: lu=Rg3v; Expires=Tue, 18 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly", // 06
				// Illegal cookies:
				"Set-Cookie:", // 07 empty cookie-pair
				"Set-Cookie: sd", // 08 illegal cookie-pair: no "="
				"Set-Cookie: =alss/0.foobar^", // 09 illegal cookie-pair: empty name
				"Set-Cookie: ns@1=alss/0.foobar^", // 10 illegal cookie-pair: illegal name
				"Set-Cookie: ns1=alss/0.foobar^;", // 11 trailing ";"
				"Set-Cookie: ns1=; Expires=Tue 18 Nov 2008 16:35:39 GMT", // 12 illegal Expires value
				"Set-Cookie: ns1=alss/0.foobar^; Max-Age=01", // 13 illegal Max-Age: starting 0
				"Set-Cookie: ns1=alss/0.foobar^; Domain=.0com", // 14 illegal Domain: starting 0
				"Set-Cookie: ns1=alss/0.foobar^; Domain=.com-", // 15 illegal Domain: trailing non-letter-digit
				"Set-Cookie: ns1=alss/0.foobar^; Path=", // 16 illegal Path: empty
				"Set-Cookie: ns1=alss/0.foobar^; httponly", // 17 lower case
		};

		for (int i = 0; i < cookies.length; i++)
			System.out.println(String.format("Cookie %2d: %s", i + 1, verifyCookie(cookies[i]) ? "Legal" : "Illegal"));
	}

}
