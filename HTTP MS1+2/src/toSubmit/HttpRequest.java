package toSubmit;

import java.io.Serializable;

public class HttpRequest implements Serializable {
	String method;
	String version;
	String URL;
	String Host;
	String format;
	String Connection;
	public HttpRequest(String URL,String Host,String format,String connection) {
		this.method = "GET";
		this.version = "1.1";
		this.URL = URL;
		this.Host = Host;
		this.format = format;
		this.Connection = connection;
	}
	public String toString() {
		return "Host:" +this.Host+"\n" + "URL:" + this.URL + "\n" + "Format:"+this.format +"\n" + "Connection:"+this.Connection + "\n";
	}
}
