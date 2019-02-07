package comm;

import java.security.MessageDigest;

public class PassUtli {
	
	public static String pwdCr(String vau1, String vau2) throws Exception {

		final String fixedSal = "kksoft";

		String id = vau1.concat(fixedSal);
		String pass = vau2.concat(id);

		byte[] enclyptedHash = null;
		MessageDigest md;

		// 暗号化されたByte型配列を、16進数表記文字列に変換する
		for (int i = 0; i < 10000; i++) {

			// MDアルゴリズムの指定
			md = MessageDigest.getInstance("SHA-256");
			md.update(pass.getBytes());
			enclyptedHash = md.digest();

			// Byte型配列を16進数表記文字列に変換
			StringBuilder sb = new StringBuilder();
			for (byte b : enclyptedHash) {
				String hex = String.format("%02x", b);
				sb.append(hex);
			}

			pass = sb.toString();
		}

		// 生成したパスワードを出力
		//System.out.println(pass);
		return pass;
	}

}
