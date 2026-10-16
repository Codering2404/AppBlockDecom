package org.apache.commons.cli;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class PosixParser extends Parser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f145251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f145252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Option f145253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Options f145254g;

    private void l(Iterator it) {
        if (this.f145252e) {
            while (it.hasNext()) {
                this.f145251d.add(it.next());
            }
        }
    }

    private void m() {
        this.f145252e = false;
        this.f145251d.clear();
    }

    private void n(String str, boolean z2) {
        Option option;
        if (z2 && ((option = this.f145253f) == null || !option.o())) {
            this.f145252e = true;
            this.f145251d.add("--");
        }
        this.f145251d.add(str);
    }

    private void o(String str, boolean z2) {
        if (z2 && !this.f145254g.e(str)) {
            this.f145252e = true;
        }
        if (this.f145254g.e(str)) {
            this.f145253f = this.f145254g.b(str);
        }
        this.f145251d.add(str);
    }

    @Override // org.apache.commons.cli.Parser
    protected String[] c(Options options, String[] strArr, boolean z2) {
        m();
        this.f145254g = options;
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("--")) {
                int iIndexOf = str.indexOf(61);
                String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
                if (options.e(strSubstring)) {
                    this.f145253f = options.b(strSubstring);
                    this.f145251d.add(strSubstring);
                    if (iIndexOf != -1) {
                        this.f145251d.add(str.substring(iIndexOf + 1));
                    }
                } else {
                    n(str, z2);
                }
            } else if ("-".equals(str)) {
                this.f145251d.add(str);
            } else if (!str.startsWith("-")) {
                n(str, z2);
            } else if (str.length() == 2 || options.e(str)) {
                o(str, z2);
            } else {
                k(str, z2);
            }
            l(it);
        }
        List list = this.f145251d;
        return (String[]) list.toArray(new String[list.size()]);
    }

    protected void k(String str, boolean z2) {
        int i3;
        for (int i4 = 1; i4 < str.length(); i4++) {
            String strValueOf = String.valueOf(str.charAt(i4));
            if (!this.f145254g.e(strValueOf)) {
                if (z2) {
                    n(str.substring(i4), true);
                    return;
                } else {
                    this.f145251d.add(str);
                    return;
                }
            }
            List list = this.f145251d;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("-");
            stringBuffer.append(strValueOf);
            list.add(stringBuffer.toString());
            Option optionB = this.f145254g.b(strValueOf);
            this.f145253f = optionB;
            if (optionB.o() && str.length() != (i3 = i4 + 1)) {
                this.f145251d.add(str.substring(i3));
                return;
            }
        }
    }
}
