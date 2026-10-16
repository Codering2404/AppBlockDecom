package com.google.android.libraries.places.api.net;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzi extends FetchResolvedPhotoUriResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f75476a;

    zzi(Uri uri) {
        this.f75476a = uri;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse
    public final Uri a() {
        return this.f75476a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FetchResolvedPhotoUriResponse)) {
            return false;
        }
        FetchResolvedPhotoUriResponse fetchResolvedPhotoUriResponse = (FetchResolvedPhotoUriResponse) obj;
        Uri uri = this.f75476a;
        return uri == null ? fetchResolvedPhotoUriResponse.a() == null : uri.equals(fetchResolvedPhotoUriResponse.a());
    }

    public final int hashCode() {
        Uri uri = this.f75476a;
        return (uri == null ? 0 : uri.hashCode()) ^ 1000003;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f75476a);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 35);
        sb.append("FetchResolvedPhotoUriResponse{uri=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
