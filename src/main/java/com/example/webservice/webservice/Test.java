package com.example.webservice.webservice;

 import java.net.URL;
 import java.rmi.RemoteException;

 import javax.xml.namespace.QName;
  import javax.xml.rpc.ParameterMode;
 import javax.xml.rpc.ServiceException;

 import org.apache.axis.Constants;
 import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
 import org.apache.axis.encoding.XMLType;

/**
 * @author baiyun@56p2b.com
 * @date 2018/12/6/006  19:52
 */
public class Test {
    public static void main(String[] args)  {
        try {
            Service s = new Service();
            Call call = (Call) s.createCall();
            call.setTimeout(new Integer(5000));
            call.setOperationName(new QName("http://tempuri.org/", "sendSmsTask"));
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://tempuri.org/sendSmsTask");
            call.setTargetEndpointAddress(new URL("http://139.159.241.64/HySmsService.asmx"));
            call.setEncodingStyle("UTF-8");
            call.addParameter(new QName("http://tempuri.org/", "userName"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName("http://tempuri.org/", "userpass"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName("http://tempuri.org/", "telnoStr"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName("http://tempuri.org/", "Msg"), org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(XMLType.XSD_INT);
            Integer result = (Integer) call.invoke(new Object[] { "username","passowrd","185xxxxxxxx","测试信息"});
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
         }