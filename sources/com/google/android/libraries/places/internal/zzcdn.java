package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcdn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f77678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f77679c;

    /* synthetic */ zzcdn(zzcdm zzcdmVar, byte[] bArr) {
        this.f77677a = zzcdmVar.f77675b;
        this.f77678b = zzcdmVar.d();
        this.f77679c = zzcdmVar.toString();
    }

    public static int c(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static int d(char c3) {
        if (c3 >= '0' && c3 <= '9') {
            return c3 - '0';
        }
        if (c3 >= 'a' && c3 <= 'f') {
            return c3 - 'W';
        }
        if (c3 < 'A' || c3 > 'F') {
            return -1;
        }
        return c3 - '7';
    }

    public final String a() {
        return this.f77677a;
    }

    public final int b() {
        return this.f77678b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzcdn) && ((zzcdn) obj).f77679c.equals(this.f77679c);
    }

    public final int hashCode() {
        return this.f77679c.hashCode();
    }

    public final String toString() {
        return this.f77679c;
    }
}
