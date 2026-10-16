package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzue implements zztn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zztn f78616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f78617b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzue)) {
            return false;
        }
        zzue zzueVar = (zzue) obj;
        return this.f78616a.equals(zzueVar.f78616a) && this.f78617b.equals(zzueVar.f78617b);
    }

    public final int hashCode() {
        Object obj = this.f78617b;
        return obj.hashCode() ^ this.f78616a.hashCode();
    }

    public final String toString() {
        String string = this.f78616a.toString();
        int length = string.length();
        String string2 = this.f78617b.toString();
        StringBuilder sb = new StringBuilder(length + 47 + string2.length() + 3);
        sb.append("SpecializedLogSiteKey{ delegate='");
        sb.append(string);
        sb.append("', qualifier='");
        sb.append(string2);
        sb.append("' }");
        return sb.toString();
    }
}
