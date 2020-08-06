
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Mp3_İşlemleri {
    public Connection connect=null;
    public Statement statement=null;
    public PreparedStatement prestate=null;
    
    
    public boolean GirişYap(String kullanıcı_adı,String şifre) throws SQLException{
        
        String sorgu="Select * from adminler where username=? and password=?";
        prestate=connect.prepareStatement(sorgu);
        prestate.setString(1, kullanıcı_adı);
        prestate.setString(2, şifre);
        ResultSet rs=prestate.executeQuery();
        if(rs.next()==false){
            return false;
        }
        else{
            return true;
        }
    }
    public ArrayList<Muzikler> VeriAl(){
        ArrayList<Muzikler> çıktı=new  ArrayList<Muzikler>();
       
        try {
            String sorgu="Select * From muzikler";
            statement=connect.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while (rs.next()) {                
              int id=rs.getInt("Sıra");
              String şarkı=rs.getString("Sarkı");
              
              çıktı.add(new Muzikler(id, şarkı));
            }
            return çıktı;
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }
    public ArrayList<Muzikler> FavAl(){
        ArrayList<Muzikler> çıktı=new  ArrayList<Muzikler>();
       
        try {
            String sorgu="Select * From favori";
            statement=connect.createStatement();
            ResultSet rs=statement.executeQuery(sorgu);
            while (rs.next()) {                
              int id=rs.getInt("Sıra");
              String şarkı=rs.getString("Sarkı");
              
              çıktı.add(new Muzikler(id, şarkı));
            }
            return çıktı;
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }
    public void VeriEkle(String Sarkı){
        
        
        
        try {
            String sorgu="Insert Into muzikler (Sarkı) Values(?)";
            prestate=connect.prepareStatement(sorgu);
            prestate.setString(1,Sarkı);
            prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void favekle(String Sarkı){
         try {
            String sorgu="Insert Into favori (Sarkı) Values(?)";
            prestate=connect.prepareStatement(sorgu);
            prestate.setString(1,Sarkı);
            prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void VeriSil(int id){
        
        try {
            String sorgu="Delete From muzikler where Sıra=?";
            prestate=connect.prepareStatement(sorgu);
            
            prestate.setInt(1, id);
            prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void FavSil(int id){
        
        try {
            String sorgu="Delete From favori where Sıra=?";
            prestate=connect.prepareStatement(sorgu);
            
            prestate.setInt(1, id);
            prestate.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Mp3_İşlemleri(){
        
        String url="jdbc:mysql://"+Database.host+":"+Database.port+"/"+Database.database_ismi+"?useUnicode=true&characterEncoding=utf8";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            connect=DriverManager.getConnection(url, Database.username, Database.password);
            System.out.println("Baglantı başarılı.");
        } catch (SQLException ex) {
            Logger.getLogger(Mp3_İşlemleri.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Baglantı başarısız.");
        }
    }
    public static void main(String[] args) {
        Mp3_İşlemleri baglantı=new Mp3_İşlemleri();
        
    }
}
