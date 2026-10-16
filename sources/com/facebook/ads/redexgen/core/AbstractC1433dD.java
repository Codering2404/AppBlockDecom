package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1433dD {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1432dC>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1432dC>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1432dC A01(C1648gi c1648gi, AbstractC1813jd abstractC1813jd, int i3, InterfaceC1430dA interfaceC1430dA) {
        C1432dC c1432dC = new C1432dC(c1648gi, abstractC1813jd, c1648gi.A02().A0A(), i3);
        c1432dC.A0b(interfaceC1430dA);
        c1432dC.A0X();
        A01.put(abstractC1813jd.A1D(), new WeakReference<>(c1432dC));
        return c1432dC;
    }

    public static C1432dC A02(String str) {
        WeakReference<C1432dC> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC1813jd abstractC1813jd, C1432dC c1432dC) {
        A01.put(abstractC1813jd.A1D(), new WeakReference<>(c1432dC));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
