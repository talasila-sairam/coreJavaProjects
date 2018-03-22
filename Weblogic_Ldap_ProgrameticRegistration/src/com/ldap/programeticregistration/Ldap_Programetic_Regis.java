package com.ldap.programeticregistration;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Hashtable;
import java.util.Set;
 
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;
 
public class Ldap_Programetic_Regis {
 
 //Input your WebLogic credentials to connect to connect your Weblogic server    
 private static String hostname = "localhost";
 private static String portString = "7001";
 private static String username = "administrator";
 private static String password = "administrator@123";
 
 // TODO Auto-generated method stub
 private static MBeanServerConnection connection;
 private static JMXConnector connector;
 private static final ObjectName service=null;
 ObjectName[]  atnProviders  = null;
 ObjectName mBeanTypeService = null;
 
 //This method creates a WebLogic connection  Object
 public static void initConnection() throws IOException,
        MalformedURLException {
        String protocol = "t3";
        Integer portInteger = Integer.valueOf(portString);
        int port = portInteger.intValue();
        String jndiroot = "/jndi/";
        String mserver = "weblogic.management.mbeanservers.domainruntime";
        JMXServiceURL serviceURL = new JMXServiceURL(protocol, hostname, port,
        jndiroot + mserver);
 
        Hashtable h = new Hashtable();
        h.put(Context.SECURITY_PRINCIPAL, username);
        h.put(Context.SECURITY_CREDENTIALS, password);
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES,
           "weblogic.management.remote");
        h.put("jmx.remote.x.request.waiting.timeout", new Long(10000));
        connector = JMXConnectorFactory.connect(serviceURL, h);
        connection = connector.getMBeanServerConnection();
        System.out.println("connection object and connector are created");
     }
          
     //Retrieve the Auth-provider from the Security Realm 
 
     ObjectName[] getAuthprovider(){
    	 
   try{
     mBeanTypeService = new ObjectName( "com.bea:Name=MBeanTypeService,Type=weblogic.management.mbeanservers.MBeanTypeService");
     ObjectName service = new ObjectName("com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean");
     ObjectName domainMBean = (ObjectName) connection.getAttribute(service , "DomainConfiguration");
     ObjectName securityConfiguration  = (ObjectName) connection.getAttribute(domainMBean, "SecurityConfiguration");
     ObjectName defaultRealm = (ObjectName) connection.getAttribute(securityConfiguration , "DefaultRealm");
     atnProviders  = (ObjectName[]) connection.getAttribute(defaultRealm, "AuthenticationProviders");
   }
   catch(Exception e){
   e.printStackTrace();
   }
    System.out.println("inside getAuthProvider method");
    return atnProviders ;
   }
       
     //Get the UserEditor Object.Using the UserEditor object we can add, edit, update a USER   
     ObjectName getUsereditor(){
     
     ObjectName userEditor = null;
     	try{
     for(ObjectName provider : atnProviders ) {
    	 System.out.println("getUserEditor Object class method");
         if(userEditor == null) {
             ModelMBeanInfo info = (ModelMBeanInfo) connection.getMBeanInfo(provider);
             String className = (String) info.getMBeanDescriptor().getFieldValue("interfaceClassName");
             
             if(className != null) {
                 String[] beans = (String[]) connection.invoke(mBeanTypeService
                                         , "getSubtypes"
                                         , new Object[] {"weblogic.management.security.authentication.UserEditorMBean"}
                                         , new String[] {"java.lang.String"}
                                     );
                 
                 for(String bean : beans) {
                     if(bean.equals(className)) {
                         userEditor = provider;
                     }
                 }
             }
         }
     }
     	}
     	catch(Exception e){
      e.printStackTrace();
     	}
     return userEditor;
     }
    
     //Main Class 
 public static void main(String[]args)   {
    
 Ldap_Programetic_Regis c= new Ldap_Programetic_Regis();
    
    try{
      //Creates connection to Weblogic 
  	  initConnection();
  	  //Retrieve the Provider from the Weblogic Security Realm  
      c.getAuthprovider();
      //Fetch the UserEditor Object
  	  ObjectName userEditor = c.getUsereditor();
  	  
 	//Check the  user 'wlsadmin' exist in the WebLogic Server Parameter: {username}
  	boolean isUserExist =(boolean) connection.invoke(
   userEditor, "userExists",
     new Object[] {"wlsadmin"},
     new String [] {"java.lang.String"}
   ); 
  	 /*
  //The below method will create a User 'wlsadmin' in Weblogic Server. Parameters: {username, password, description}
  	if(!isUserExist){
  	  connection.invoke(userEditor
             , "createUser"
             , new Object[] {"wlsadmin", "password123","User created through programmatically."}
             , new String[] {"java.lang.String", "java.lang.String","java.lang.String"}
          );
  	}
 	
   //The below method add the Administrator group to the user and makes the user as Admin , Parameter: {Group,username}
  	connection.invoke(
  	         userEditor, "addMemberToGroup",
  	         new Object[] {"Administrators", "wlsadmin"},
  	         new String [] {"java.lang.String", "java.lang.String"}
  	      );
  		
  	//Update the password {Username, Old-password, New-password}
//	connection.invoke(
// userEditor, "changeUserPassword",
//   new Object[] {"wlsadmin","bablu123", "govind123"},
//   new String [] {"java.lang.String", "java.lang.String","java.lang.String"}
// ); 
 
  //Update a user password(Username, New-Password) - Only for Admin user 
 connection.invoke(
 userEditor, "resetUserPassword",
   new Object[] {"wlsadmin","wlsadmin@123"},
   new String [] {"java.lang.String","java.lang.String"}
 );  
  */
  	
 //Check the given user exist in the WebLogic Parameter: {username}
 isUserExist =(boolean) connection.invoke(
 userEditor, "userExists",
   new Object[] {"testuser"},
   new String [] {"java.lang.String"}
 ); 
 

 //Remove an user from WebLogic server, Parameter: {username}
 
 if(isUserExist){
 connection.invoke(
 userEditor, "removeUser",
   new Object[] {"testuser"},
   new String [] {"java.lang.String"}
    );
 System.out.println("user got removed");
  } 
  

 //end of the try
 
    }
    catch(Exception e){
  	  e.printStackTrace();
    }
    finally{
    //Close the Weblogic connection
    try{connector.close();}
    catch(Exception e){e.printStackTrace();}
    }
     }
 
}