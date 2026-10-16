package com.google.android.libraries.places.api.net;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzo extends FindCurrentPlaceResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75505a;

    zzo(List list) {
        if (list == null) {
            throw new NullPointerException("Null placeLikelihoods");
        }
        this.f75505a = list;
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceResponse
    public final List a() {
        return this.f75505a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceResponse) {
            return this.f75505a.equals(((FindCurrentPlaceResponse) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75505a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75505a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 43);
        sb.append("FindCurrentPlaceResponse{placeLikelihoods=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
