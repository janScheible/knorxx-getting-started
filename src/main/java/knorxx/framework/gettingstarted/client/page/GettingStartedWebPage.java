package knorxx.framework.gettingstarted.client.page;

import knorxx.framework.generator.web.client.WebPage;
import org.springframework.stereotype.Component;
import static org.stjs.javascript.Global.alert;

/**
 *
 * @author sj
 */
@Component
public class GettingStartedWebPage extends WebPage {

	@Override
	public void render() {
		alert("I'm a Knorxx Framework application!");
	}	
}
