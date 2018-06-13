package developergirls;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Tes {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("123")); 

	}

}
