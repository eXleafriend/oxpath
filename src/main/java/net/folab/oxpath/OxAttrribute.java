package net.folab.oxpath;

public class OxAttrribute extends OxExpression {

    private final OxExpression prefix;

    private final String attrName;

    public OxAttrribute(String attrName) {
        prefix = null;
        this.attrName = attrName;
    }

    public OxAttrribute(OxExpression prefix, String attrName) {
        this.prefix = prefix;
        this.attrName = attrName;
    }

    @Override
    public String expr() {
        if (prefix != null)
            if (prefix instanceof OxElement)
                return pack(prefix.expr() + "/@" + attrName);
            else
                return pack(prefix.expr() + "@" + attrName);
        else
            return pack("@" + attrName);
    }

}
