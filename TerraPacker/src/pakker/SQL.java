package pakker;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;

	public class SQL {
		private static int teller =0;
		private static ArrayList<Mod> array = new ArrayList<Mod>();
	    public static void main(String[] args) throws Exception {
	        // TODO Auto-generated method stub
	        getmods();
	       
	 
	    }
	    public static ArrayList<Mod> getmods() throws Exception{
	        try{
	            Connection con = getConnection();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM mods ORDER BY id DESC");
	           
	            ResultSet result = statement.executeQuery();
	       
	            while(result.next()){
	                System.out.print(result.getString("name"));
	                System.out.print(" ");
	               
	                array.add(new Mod((result.getString("name")), null, null));
	                teller++;

	            }
	            System.out.println("All records have been selected!");
	            
	           
	        }catch(Exception e){System.out.println(e);
	        	System.out.println(e.getCause());
	        	}
	        return null;
	    }
	    public static ArrayList<Mod> getmodver() throws Exception{
	        try{
	            Connection con = getConnection();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM modversions ORDER BY id DESC");
	           
	            ResultSet result = statement.executeQuery();
	            ArrayList<String> ver = new ArrayList<>();
	            while(result.next()){
	                System.out.print(result.getString("version"));
	                System.out.print(" ");
	                
	                ver.add(result.getString("version"));
	             
	             
	            }
	            System.out.println("All records have been selected!");
	            	
	            	  for (int i=0; i<teller; i++)
	  	                array.get(i).setversion(ver.get(i));
	            	  return array;
	        }catch(Exception e){System.out.println(e);
	        	System.out.println(e.getCause());
	        	}
	        return null;
	       
	    }
	    public static ArrayList<String> getmodpack() throws Exception{
	        try{
	            Connection con = getConnection();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM modpacks ORDER BY name DESC");
	           
	            ResultSet result = statement.executeQuery();
	           
	            ArrayList<String> array = new ArrayList<String>();
	            while(result.next()){
	                System.out.print(result.getString("name"));
	                System.out.print(" ");
	                System.out.println(result.getString("id"));
	               
	                array.add(result.getString("name"));
	            }
	            System.out.println("All records have been selected!");
	            return array;
	           
	        }catch(Exception e){System.out.println(e);}
	        return null;
	       
	    }
		 public static Connection getConnection() throws Exception{
		        try{
		            String driver = "com.mysql.jdbc.Driver";
		            String url = "jdbc:mysql://192.168.5.3:3306/solder";
		            String username = "Solder";
		            String password = "password";
		            Class.forName(driver);
		           
		            Connection conn = DriverManager.getConnection(url,username,password);
		            System.out.println("Connected");
		            return conn;
		        } catch(Exception e){System.out.println(e);}
		       
		       
		        return null;
		    }
	}
