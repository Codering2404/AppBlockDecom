package com.google.android.datatransport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Encoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f69056a;

    private Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f69056a = str;
    }

    public static Encoding b(String str) {
        return new Encoding(str);
    }

    public String a() {
        return this.f69056a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding) {
            return this.f69056a.equals(((Encoding) obj).f69056a);
        }
        return false;
    }

    public int hashCode() {
        return this.f69056a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.f69056a + "\"}";
    }
}
