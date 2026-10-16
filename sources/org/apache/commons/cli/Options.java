package org.apache.commons.cli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Options implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map f145226a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f145227b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f145228c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f145229d = new HashMap();

    public Options a(Option option) {
        String strH = option.h();
        if (option.r()) {
            this.f145227b.put(option.i(), option);
        }
        if (option.v()) {
            if (this.f145228c.contains(strH)) {
                List list = this.f145228c;
                list.remove(list.indexOf(strH));
            }
            this.f145228c.add(strH);
        }
        this.f145226a.put(strH, option);
        return this;
    }

    public Option b(String str) {
        String strB = Util.b(str);
        return this.f145226a.containsKey(strB) ? (Option) this.f145226a.get(strB) : (Option) this.f145227b.get(strB);
    }

    public OptionGroup c(Option option) {
        return (OptionGroup) this.f145229d.get(option.h());
    }

    public List d() {
        return this.f145228c;
    }

    public boolean e(String str) {
        String strB = Util.b(str);
        return this.f145226a.containsKey(strB) || this.f145227b.containsKey(strB);
    }

    List f() {
        return new ArrayList(this.f145226a.values());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ Options: [ short ");
        stringBuffer.append(this.f145226a.toString());
        stringBuffer.append(" ] [ long ");
        stringBuffer.append(this.f145227b);
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
