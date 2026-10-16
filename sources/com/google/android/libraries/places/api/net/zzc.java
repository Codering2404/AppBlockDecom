package com.google.android.libraries.places.api.net;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzc extends FetchPhotoResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f75456a;

    zzc(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Null bitmap");
        }
        this.f75456a = bitmap;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoResponse
    public final Bitmap a() {
        return this.f75456a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoResponse) {
            return this.f75456a.equals(((FetchPhotoResponse) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f75456a.hashCode() ^ 1000003;
    }

    public final String toString() {
        String string = this.f75456a.toString();
        StringBuilder sb = new StringBuilder(string.length() + 27);
        sb.append("FetchPhotoResponse{bitmap=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
