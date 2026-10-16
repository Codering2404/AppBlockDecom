package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbx extends SearchAlongRouteParameters {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Polyline f75313a;

    zzbx(Polyline polyline) {
        if (polyline == null) {
            throw new NullPointerException("Null polyline");
        }
        this.f75313a = polyline;
    }

    @Override // com.google.android.libraries.places.api.model.SearchAlongRouteParameters
    public final Polyline c() {
        return this.f75313a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchAlongRouteParameters) {
            return this.f75313a.equals(((SearchAlongRouteParameters) obj).c());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75313a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75313a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 37);
        sb.append("SearchAlongRouteParameters{polyline=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
