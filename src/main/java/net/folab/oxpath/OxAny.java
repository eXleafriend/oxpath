package net.folab.oxpath;

public class OxAny extends OxParent {

    private final OxExpression prefix;

    public OxAny() {
        prefix = null;
    }

    public OxAny(OxExpression prefix) {
        this.prefix = prefix;
    }

    @Override
    public String expr() {
        if (prefix != null)
            if (prefix instanceof OxRoot)
                return pack("//");
            else
                return pack(prefix.expr() + "//");
        else

            return pack("//");
    }

    public OxElement child(String nodeName) {
        return new OxElement(this, nodeName);
    }

    public OxAttrribute attr(String attrName) {
        return new OxAttrribute(this, attrName);
    }

}
