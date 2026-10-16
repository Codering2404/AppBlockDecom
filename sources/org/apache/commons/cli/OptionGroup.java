package org.apache.commons.cli;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.comparisons.xn.YvFRmou;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class OptionGroup implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f145223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f145224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f145225c;

    public Collection a() {
        return this.f145223a.values();
    }

    public String b() {
        return this.f145224b;
    }

    public boolean c() {
        return this.f145225c;
    }

    public void d(Option option) throws AlreadySelectedException {
        String str = this.f145224b;
        if (str != null && !str.equals(option.j())) {
            throw new AlreadySelectedException(this, option);
        }
        this.f145224b = option.j();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = a().iterator();
        stringBuffer.append("[");
        while (it.hasNext()) {
            Option option = (Option) it.next();
            if (option.j() != null) {
                stringBuffer.append("-");
                stringBuffer.append(option.j());
            } else {
                stringBuffer.append(YvFRmou.gcpgVgO);
                stringBuffer.append(option.i());
            }
            stringBuffer.append(" ");
            stringBuffer.append(option.g());
            if (it.hasNext()) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
