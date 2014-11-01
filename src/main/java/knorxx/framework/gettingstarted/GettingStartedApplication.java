package knorxx.framework.gettingstarted;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import knorxx.framework.generator.GenerationRoots;
import knorxx.framework.generator.jqueryuibridge.JQueryUiDetector;
import knorxx.framework.generator.springadapter.KnorxxController;
import knorxx.framework.generator.springadapter.KnorxxGeneratorCacheConfig;
import knorxx.framework.generator.web.KnorxxApplication;
import knorxx.framework.generator.web.server.rpc.VerboseExceptionMarshaller;
import knorxx.framework.gettingstarted.client.page.GettingStartedWebPage;
import knorxx.framework.gettingstarted.client.JavaScriptGenerationRoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 *
 * @author sj
 */
@Controller
@EnableAutoConfiguration
@Import({KnorxxGeneratorCacheConfig.class})
@ComponentScan("knorxx.framework.gettingstarted")
public class GettingStartedApplication extends KnorxxController {

	@Component
	public static class GettingStartedKnorxxApplication implements KnorxxApplication {

		@Override
		public String getName() {
			return "Knorxx Framework - Getting Started";
		}
	}
	
	private static class CurrentWorkingDirMavenGenerationRoots extends GenerationRoots {

		@Override
		public String getSourceRoot() {
			return new File(".").getAbsolutePath() + "/src/main/java";
		}

		@Override
		public String getOutputRoot() {
			return new File(".").getAbsolutePath() + "/target/classes";
		}
	}

	public GettingStartedApplication() {
		super(GettingStartedApplication.class, JavaScriptGenerationRoot.class, GettingStartedWebPage.class,
				(HttpServletRequest input) -> new CurrentWorkingDirMavenGenerationRoots(),
				new JQueryUiDetector(), new VerboseExceptionMarshaller());
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GettingStartedApplication.class, args);
	}
}
