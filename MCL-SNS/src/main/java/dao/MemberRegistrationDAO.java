package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Register;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class MemberRegistrationDAO {

	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}

	public static int registerMember(Register register) {
		String sql = "INSERT INTO MCL_SNS_ACCOUNT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		String salt = GenerateSalt.getSalt(32);
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(register.getPass(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, register.getMail());
			pstmt.setString(2, register.getNickName());
			pstmt.setString(3, register.getLastName());
			pstmt.setString(4, register.getFirstName());
			pstmt.setString(5, register.getBirthday());
			pstmt.setString(6, register.getSchoolNamel());
			pstmt.setString(7, salt);
			pstmt.setString(8, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
}