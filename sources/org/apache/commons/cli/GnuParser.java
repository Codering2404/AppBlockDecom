package org.apache.commons.cli;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class GnuParser extends Parser {
    @Override // org.apache.commons.cli.Parser
    protected String[] c(Options options, String[] strArr, boolean z2) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        boolean z3 = false;
        while (i3 < strArr.length) {
            String str = strArr[i3];
            if ("--".equals(str)) {
                arrayList.add("--");
                z3 = true;
            } else if ("-".equals(str)) {
                arrayList.add("-");
            } else if (str.startsWith("-")) {
                String strB = Util.b(str);
                if (options.e(strB)) {
                    arrayList.add(str);
                } else if (strB.indexOf(61) != -1 && options.e(strB.substring(0, strB.indexOf(61)))) {
                    arrayList.add(str.substring(0, str.indexOf(61)));
                    arrayList.add(str.substring(str.indexOf(61) + 1));
                } else if (options.e(str.substring(0, 2))) {
                    arrayList.add(str.substring(0, 2));
                    arrayList.add(str.substring(2));
                } else {
                    arrayList.add(str);
                    z3 = z2;
                }
            } else {
                arrayList.add(str);
            }
            if (z3) {
                while (true) {
                    i3++;
                    if (i3 < strArr.length) {
                        arrayList.add(strArr[i3]);
                    }
                }
            }
            i3++;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
