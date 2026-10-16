package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf extends FetchPlaceResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place f75467a;

    zzf(Place place) {
        if (place == null) {
            throw new NullPointerException("Null place");
        }
        this.f75467a = place;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceResponse
    public final Place a() {
        return this.f75467a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceResponse) {
            return this.f75467a.equals(((FetchPlaceResponse) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75467a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75467a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 26);
        sb.append("FetchPlaceResponse{place=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
