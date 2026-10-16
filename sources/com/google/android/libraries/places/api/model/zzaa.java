package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzaa extends EncodedPolyline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75031a;

    zzaa(String str) {
        if (str == null) {
            throw new NullPointerException("Null encodedPolyline");
        }
        this.f75031a = str;
    }

    @Override // com.google.android.libraries.places.api.model.EncodedPolyline
    public final String c() {
        return this.f75031a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EncodedPolyline) {
            return this.f75031a.equals(((EncodedPolyline) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75031a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String str = this.f75031a;
        StringBuilder sb = new StringBuilder(str.length() + 33);
        sb.append("EncodedPolyline{encodedPolyline=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
