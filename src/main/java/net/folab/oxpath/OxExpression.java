package net.folab.oxpath;

import java.util.ArrayList;
import java.util.List;

public abstract class OxExpression {

    public abstract String expr();

    public static String pack(String expr) {
        List<String> exps = new ArrayList<>();
        for (String exp : expr.split("/", -1)) {
            if (".".equals(exp))
                continue;
            exps.add(exp);
        }
        StringBuilder builder = new StringBuilder();
        boolean isFirst = true;
        for (String exp : exps) {
            if (isFirst)
                isFirst = false;
            else
                builder.append("/");
            builder.append(exp);
        }
        return builder.toString();
    }

}
