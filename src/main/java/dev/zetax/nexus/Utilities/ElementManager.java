package dev.zetax.nexus.Utilities;

import me.TechsCode.UltraCustomizer.scriptSystem.ElementRegistration;
import me.TechsCode.UltraCustomizer.scriptSystem.objects.*;

public class ElementManager {

    private final Element element;

    public ElementManager(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return this.element;
    }

    public void registerElement() {
        ElementRegistration.register(this.element.getClass());
    }

    public void unregisterElement() {
        ElementRegistration.unregister(this.element);
    }

}
