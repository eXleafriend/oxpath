package net.folab.oxpath;

import java.util.List;

public abstract class OxParent extends OxExpression {

    public OxElement child(String nodeName) {
        return new OxElement(this, nodeName);
    }

    public List<OxElement> children(String nodeName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
