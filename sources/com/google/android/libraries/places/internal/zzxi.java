package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78820a;

    static {
        new zzxi("");
        new zzxi("<br>");
        new zzxi("<!DOCTYPE html>");
    }

    zzxi(String str) {
        str.getClass();
        this.f78820a = str;
    }

    public final String a() {
        return this.f78820a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzxi) {
            return this.f78820a.equals(((zzxi) obj).f78820a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f78820a.hashCode() ^ 867184553;
    }

    public final String toString() {
        String str = this.f78820a;
        StringBuilder sb = new StringBuilder(str.length() + 10);
        sb.append("SafeHtml{");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
