package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	//会員登録
	public static int registerMember(Register register) {
		String sql = "INSERT INTO MCL_SNS_ACCOUNT VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		String sql2 = "CREATE TABLE $tablename ( time timestamp, note text not null)";
		String sql3 = "CREATE TABLE &tablename2 (name VARCHAR(64))";
		sql2 = sql2.replace("$tablename", register.getNickName());
		sql3 = sql3.replace("&tablename2", register.getNickName() + "followlist");
		int result = 0;
		int result2 = 0;
		int result3 = 0;
		
		String salt = GenerateSalt.getSalt(32);
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(register.getPass(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				PreparedStatement pstmt2 = con.prepareStatement(sql2);
				PreparedStatement pstmt3 = con.prepareStatement(sql3);
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
			result2 = pstmt2.executeUpdate();
			result3 = pstmt3.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
			System.out.println("テーブルを作成しました。");
		}
		return result;
	}
	
	//ソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT solt FROM mcl_sns_account WHERE mailadress = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("solt");
					System.out.println("ソルト取得完了!");
					return salt;
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
		public static Register login(String mail, String hashedPw) {
			String sql = "SELECT * FROM mcl_sns_account WHERE mailadress = ? AND hashed_pass = ?";
			
			try (
					Connection con = getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					){
				pstmt.setString(1, mail);
				pstmt.setString(2, hashedPw);

				try (ResultSet rs = pstmt.executeQuery()){
					
					if(rs.next()) {
						String mailad = rs.getString("mailadress");
						String nickName = rs.getString("nick_name");
						String lastName = rs.getString("last_name");
						String firstName = rs.getString("first_name");
						String birthday = rs.getString("birthday");
						String schoolName = rs.getString("school_name");
						String solt = rs.getString("solt");
						
						
						return new Register(mailad, null, nickName, lastName, firstName, birthday, schoolName, solt, null);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return null;
		}
}