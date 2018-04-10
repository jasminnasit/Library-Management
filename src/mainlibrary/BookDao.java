package mainlibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author) values(?,?,?)");
		ps.setString(1,callno);
		ps.setString(2,name);
		ps.setString(3,author);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

    /**
     *
     * @param Publisher
     * @return
     */
    public static boolean PublisherValidate( String Publisher)
{
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from Publisher where PublisherName = ?"); 
        ps.setString(1, Publisher);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}
    
    public static int AddPublisher( String Publisher)
    {
        int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("insert into Publisher(PublisherName) values(?)");
		ps.setString(1,Publisher);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }

  
    public static int SaveBook(String BookN, String AuthorN,String GenreN) {
            int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("insert into books(BookName,Author,Genre) values(?,?,?)");
		ps.setString(1,BookN);
                ps.setString(2, AuthorN);
                ps.setString(3, GenreN);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;    }
    
    public static int Delete(int BookID)
    {
          int status= 0;
        try(Connection con = DB.getConnection()) {
		PreparedStatement ps=con.prepareStatement("DELETE FROM books where BookID=?");
		ps.setInt(1,BookID);
		status=ps.executeUpdate();
                con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
        
    }
            
    
 

}
