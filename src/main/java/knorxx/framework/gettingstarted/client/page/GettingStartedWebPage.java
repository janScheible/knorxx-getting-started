package knorxx.framework.gettingstarted.client.page;

import knorxx.framework.generator.web.client.WebPage;
import org.springframework.stereotype.Component;
import static org.stjs.javascript.Global.alert;
import org.stjs.javascript.dom.Element;
import org.stjs.javascript.jquery.Event;
import static org.stjs.javascript.jquery.GlobalJQueryUI.$;
import org.stjs.javascript.jquery.JQuery;
import org.stjs.javascript.jquery.plugins.ButtonOptions;

/**
 *
 * @author sj
 */
@Component
public class GettingStartedWebPage extends WebPage {

	@Override
	public void render() {
		ButtonOptions buttonOptions = new ButtonOptions();
		buttonOptions.label = "Click me";
		
		$(CONTAINER_ID)
			.append((JQuery) $("<h1>I'm a Knorxx Framework application!</h1>"))
			.append($("<div>").button(buttonOptions).click((Event event, Element elmnt) -> {
				alert("Hello Knorxx!");
				return true;
			}));
	}
}
