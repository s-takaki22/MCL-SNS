package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Follow;
import dto.MemberSearch;

public class FollowManagementDAO {

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
	//アカウント検索
	public static List<MemberSearch> memberSearchs(MemberSearch member) {
		String sql = "SELECT nick_name FROM mcl_sns_account WHERE nick_name LIKE '%$search%'";
		sql = sql.replace("$search", member.getAccountName());
		List<MemberSearch> result = new ArrayList<>();

		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String accountName = rs.getString("nick_name");

					MemberSearch post = new MemberSearch(accountName);
					result.add(post);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}

	//フォローする
	public static int followAccount(Follow follow) {
		String sql = "INSERT INTO $tablename VALUES(?)";
		sql = sql.replace("$tablename", follow.getAccountName() + "followlist");
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, follow.getName());

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
	//フォロー一覧検索
	public static List<MemberSearch> folllowSearchs(MemberSearch member) {
		String sql = "SELECT * FROM $tablename";
		sql = sql.replace("$tablename", member.getAccountName() + "followlist");
		List<MemberSearch> result = new ArrayList<>();

		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String accountName = rs.getString("name");

					MemberSearch post = new MemberSearch(accountName);
					result.add(post);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}

}