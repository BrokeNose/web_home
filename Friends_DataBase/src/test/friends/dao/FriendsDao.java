package test.friends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.friends.dto.FriendsDto;
import test.util.DBConnect;

public class FriendsDao {
	private static FriendsDao dao;
	private FriendsDao() {}
	public static FriendsDao getInstance() {
		if (dao==null) {
			dao=new FriendsDao();
		}
		return dao;
	}
	//친구 정보를 저장하는 메소드
	public boolean insert(FriendsDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO friends (num,name,phone)"
					+" VALUES(MEMBER_SEQ.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			flag=pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if (flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//list에 담는 메소드
	public List<FriendsDto> getList(){
		//필요한 객체를 담을 지역 변수 만들기
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		//친구 목록을 담을 객체 생성
		List<FriendsDto> list= new ArrayList<>();
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num,name,phone FROM member"
					+" ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			//sql문 수행하고 결과셋 받아오기
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num=rs.getInt("num");
				String name=rs.getString("name");
				String phone= rs.getString("phone");			
				//회원 한명의 정보를 FriendsDto 객체에 담는다.
				FriendsDto dto=new FriendsDto(num,name,phone);
				//FriendsDto 객체의 참조값을 ArrayList 에 저장
				list.add(dto);		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return list;
	}
}
