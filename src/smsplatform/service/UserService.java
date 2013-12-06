package smsplatform.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdUser;
import smsplatform.dao.TBdUserDAO;
import smsplatform.dao.impl.SUserDao;

public class UserService {
	
	public TBdMessagesend tBdMessagesend;
	public TBdMessagesendgroup tBdMessagesendgroup ;
	public String update(TBdUser tBdUser,Long id){
		try {
			SUserDao sUserDao = new SUserDao();
			TBdUser tBdUser2 = sUserDao.findById(id);
		    tBdUser2.setFUserId(tBdUser.getFUserId());
			tBdUser2.setFPhoneNumber(tBdUser.getFPhoneNumber());
			tBdUser2.setFEmail(tBdUser.getFEmail());
			tBdUser2.setFUserFullName(tBdUser.getFUserFullName());
			tBdUser2.setFCompanyType(tBdUser.getFCompanyType());
			tBdUser2.setFSignature(tBdUser.getFSignature());
	    	sUserDao.update(tBdUser2);
		} catch (Exception e) {
		    e.printStackTrace();
			return "fail";
		}
		return "success";
	}
	
	public String sendmsg(TBdMessagesendgroup tBdMessagesendgroup){
		try {
			
			 String location = "http://www.baidu.com";
			 /*    String location = "http://baidu.com";
			 */  //  response.sendRedirect(location);
			    System.out.println(sendGet(location));;
			
			
		} catch (Exception e) {
		    e.printStackTrace();
			return "fail";
		}
		return "success";
	}

	
	public static String sendGet(String url)
    {
     String result = "";
     try{
      String urlName = url ;

      URL U = new URL(urlName);
      URLConnection connection = U.openConnection();
      connection.connect();
     
      BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = in.readLine())!= null)
      {
       result += line;
      }
      in.close();   
     }catch(Exception e){
      System.out.println("没有结果！"+e);
     }
     return result;
    }

	public TBdMessagesend gettBdMessagesend() {
		return tBdMessagesend;
	}

	public void settBdMessagesend(TBdMessagesend tBdMessagesend) {
		this.tBdMessagesend = tBdMessagesend;
	}

	public TBdMessagesendgroup gettBdMessagesendgroup() {
		return tBdMessagesendgroup;
	}

	public void settBdMessagesendgroup(TBdMessagesendgroup tBdMessagesendgroup) {
		this.tBdMessagesendgroup = tBdMessagesendgroup;
	}

	
}
