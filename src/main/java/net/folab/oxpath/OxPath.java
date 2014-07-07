package net.folab.oxpath;

import org.w3c.dom.Document;

public abstract class OxPath {

    public static OxElement child(String nodeName) {
        return new OxElement(nodeName);
    }

    public static OxAny any() {
        return new OxAny();
    }

    public static OxRoot root() {
        return new OxRoot();
    }

    public static OxElement from(Document document) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Not yet implemented");
        return new OxElement("");
    }

}
