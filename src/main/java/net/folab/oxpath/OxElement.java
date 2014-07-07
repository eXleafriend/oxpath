package net.folab.oxpath;

import java.util.List;

public class OxElement extends OxParent {

    private final OxExpression prefix;

    private final String nodeName;

    public OxElement(String nodeName) {
        this(null, nodeName);
    }

    public OxElement(OxExpression prefix, String nodeName) {
        this.prefix = prefix;
        this.nodeName = nodeName;
    }

    @Override
    public String expr() {
        if (prefix != null)
            if (prefix instanceof OxElement)
                return pack(prefix.expr() + "/" + nodeName);
            else
                return pack(prefix.expr() + nodeName);
        else
            return pack(nodeName);
    }

    public OxAttrribute attr(String attrName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public OxElement anyElem(String nodeName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<OxElement> anyElems(String nodeName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public OxAny any() {
        return new OxAny(this);
    }

}
