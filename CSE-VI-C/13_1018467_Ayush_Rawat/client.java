//client
import java.net.*;
import java.io.*;
public class client{
	public static void main(String args[])
	throws Exception{
		Socket s= new Socket("localhost",9000);
		//dataRead
		DataInputStream dataRead = new DataInputStream(s.getInputStream());
		//dataWrite
		DataOutputStream dataWrite = new DataOutputStream(s.getOutputStream());
		//keyboard Reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str="",str2="";
		while(!str.equals("bye"))
		{
			str=br.readLine();
			dataWrite.writeUTF(str);
			dataWrite.flush();
			str2=dataRead.readUTF();
			System.out.println("Arvind says :"+str2);
		}
		dataRead.close();
		s.close();
	}
}