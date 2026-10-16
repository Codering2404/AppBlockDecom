package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzxl f78830b = new zzxl("about:invalid#zGuavaz");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78831a;

    zzxl(String str) {
        str.getClass();
        this.f78831a = str;
    }

    public final String a() {
        return this.f78831a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzxl) {
            return this.f78831a.equals(((zzxl) obj).f78831a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f78831a.hashCode() ^ 18288376;
    }

    public final String toString() {
        String str = this.f78831a;
        StringBuilder sb = new StringBuilder(str.length() + 9);
        sb.append("SafeUrl{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
