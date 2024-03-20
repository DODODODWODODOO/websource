package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDto;

public class BookDao {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // JDBC 단계
    // 1. 드라이버 로드

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }

    // 2. 커넥션 얻기 jdbc:oracle:thin: (고정)
    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "c##test2";
        String password = "test";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return con;
    }

    // 3. CRUD
    public List<BookDto> getList() {
        List<BookDto> list = new ArrayList<>();

        con = getConnection();
        String sql = "select * from booktbl order by code desc";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BookDto dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));

                list.add(dto);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return list;
    }

    public BookDto getRow(int code) {
        BookDto dto = null;

        con = getConnection();
        String sql = "select * from booktbl where code=?";
        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, code);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new BookDto();
                dto.setCode(rs.getInt("code"));
                dto.setTitle(rs.getString("title"));
                dto.setWriter(rs.getString("writer"));
                dto.setPrice(rs.getInt("price"));
                dto.setDecription(rs.getString("decription"));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return dto;

    }

    public int update(BookDto updateDto) {
        int result = 0;
        con = getConnection();
        String sql = "UPDATE BOOKTBL SET PRICE =? WHERE CODE=?";

        try {
            pstmt = con.prepareStatement(sql);

            // ? 해결
            pstmt.setInt(1, updateDto.getPrice());

            pstmt.setInt(2, updateDto.getCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }
        return result;
    }

    public int insert(BookDto insertDto) {
        int result = 0;

        con = getConnection();
        String sql = "insert into booktbl(code, title, writer, price, decription)";
        sql += "values(?,?,?,?,?)";
        try {
            pstmt = con.prepareStatement(sql);

            // ? 해결
            pstmt.setInt(1, insertDto.getCode());
            pstmt.setString(2, insertDto.getTitle());
            pstmt.setString(3, insertDto.getWriter());
            pstmt.setInt(4, insertDto.getPrice());
            pstmt.setString(5, insertDto.getDecription());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }
        return result;
    }

    public int delete(BookDto deleteDto) {
        int result = 0;

        return result;
    }

    // 4. 자원 정리
    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(Connection con, PreparedStatement pstmt) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
