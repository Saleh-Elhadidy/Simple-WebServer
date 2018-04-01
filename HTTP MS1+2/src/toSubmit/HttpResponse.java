package toSubmit;

import java.io.Serializable;
import java.util.Date;

public class HttpResponse implements Serializable{
String status;
String Version;
Date TimeStamp;
String Format;
String Connection;
Object payload;
public HttpResponse(String status,String version,Date timeStamp,String format,String Connection,Object payload) {
	this.status = status;
	this.Version = version;
	this.TimeStamp = timeStamp;
	this.Format = format;
	this.Connection = Connection;
	this.payload = payload;
}
public String toString() {
	return "Host:" +this.status+"\n" + "Version:" + this.Version + "\n" + "Format:"+this.Format +"\n" + "Connection:"+this.Connection + "\n";
}
}
