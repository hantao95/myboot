package mySpringBoot.com.lago.configuation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class TomcatConfig {

	private Tomcat tomcat;
	
	
	public void startTomcat() throws  Exception {
		Tomcat tomcat = new Tomcat();
		File baseDir = createTempDir("tomcat");
		tomcat.setBaseDir(baseDir.getAbsolutePath());
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		tomcat.getService().addConnector(connector);
		connector.setPort(8080);
		connector.setProperty("bindOnInit", "false");
		connector.setRedirectPort(8443);
		tomcat.setConnector(connector);
		tomcat.getHost().setAutoDeploy(false);
		this.tomcat = tomcat;
		this.tomcat.start();
	}
	
	protected final File createTempDir(String prefix) throws IOException {
			File tempDir = Files.createTempDirectory(prefix + ".8080.").toFile();
			tempDir.deleteOnExit();
			return tempDir;
	}

	public Tomcat getTomcat() {
		return tomcat;
	}

	public void setTomcat(Tomcat tomcat) {
		this.tomcat = tomcat;
	}


	

	
	
}
