package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f77562a;

    public final int a() {
        return this.f77562a.length >> 1;
    }

    public final String b(int i3) {
        int i4 = i3 + i3;
        if (i4 < 0) {
            return null;
        }
        String[] strArr = this.f77562a;
        if (i4 >= strArr.length) {
            return null;
        }
        return strArr[i4];
    }

    public final String c(int i3) {
        int i4 = i3 + i3 + 1;
        if (i4 < 0) {
            return null;
        }
        String[] strArr = this.f77562a;
        if (i4 >= strArr.length) {
            return null;
        }
        return strArr[i4];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int iA = a();
        for (int i3 = 0; i3 < iA; i3++) {
            sb.append(b(i3));
            sb.append(": ");
            sb.append(c(i3));
            sb.append("\n");
        }
        return sb.toString();
    }
}
