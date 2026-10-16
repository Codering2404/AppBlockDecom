package com.facebook.ads.redexgen.core;

import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ki, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0837Ki {
    public static String[] A02 = {"qTeBguUhuyM1MFes5Wth7HwI8JVW0esL", "wy2OEDVCsbs7Li1HpnMScgVTk8nNd5Di", "4", "CU9fduzhq9VQNbJmZcJcyCUxTgO6nbWs", "5", "s", "JcGduWYdz", "iAKvMVZDfF33p8y0i7fbnjg8iQoR6jrx"};
    public static final Comparator<C0837Ki> A03 = new Comparator() { // from class: com.facebook.ads.redexgen.X.Kh
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((C0837Ki) obj).A01.A00, ((C0837Ki) obj2).A01.A00);
        }
    };
    public final int A00;
    public final C0838Kj A01;

    public C0837Ki(C0838Kj c0838Kj, int i3) {
        this.A01 = c0838Kj;
        this.A00 = i3;
    }

    public static /* synthetic */ Comparator A03() {
        Comparator<C0837Ki> comparator = A03;
        if (A02[1].charAt(25) != '8') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "h";
        strArr[5] = "u";
        return comparator;
    }
}
