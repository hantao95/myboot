package mySpringBoot.com.lago.configuation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class MySpringBootApplication {
	public static void run() throws  Exception {
		Tomcat tomcat = new Tomcat();
		File baseDir = createTempDir("tomcat");
		tomcat.setBaseDir(baseDir.getAbsolutePath());
		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		tomcat.getService().addConnector(connector);
		connector.setPort(8080);
		connector.setProperty("bindOnInit", "false");
		connector.setRedirectPort(8443);
		tomcat.getEngine();
		tomcat.setConnector(connector);
		tomcat.getHost().setAutoDeploy(false);
		StandardContext myCtx = (StandardContext) tomcat
	            .addWebapp("/access", System.getProperty("user.dir") + File.separator + "src/main");
		 myCtx.setReloadable(false);
	        // 上下文监听器
	        myCtx.addLifecycleListener(new AprLifecycleListener());
		tomcat.start();
		tomcat.getServer().await();
	}
	protected final static File createTempDir(String prefix) throws IOException {
		File tempDir = Files.createTempDirectory(prefix + ".8080.").toFile();
		tempDir.deleteOnExit();
		return tempDir;
}
	


}
