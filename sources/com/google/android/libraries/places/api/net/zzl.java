package com.google.android.libraries.places.api.net;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzl extends FindAutocompletePredictionsResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75500a;

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse
    public final List a() {
        return this.f75500a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsResponse) {
            return this.f75500a.equals(((FindAutocompletePredictionsResponse) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75500a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75500a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 61);
        sb.append("FindAutocompletePredictionsResponse{autocompletePredictions=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }

    zzl(List list) {
        if (list != null) {
            this.f75500a = list;
            return;
        }
        throw new NullPointerException(SbbqvQlxi.umgmsSFqieVq);
    }
}
