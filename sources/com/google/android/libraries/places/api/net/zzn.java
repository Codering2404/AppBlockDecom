package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzn extends FindCurrentPlaceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CancellationToken f75504b;

    /* synthetic */ zzn(List list, CancellationToken cancellationToken, byte[] bArr) {
        this.f75503a = list;
        this.f75504b = cancellationToken;
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceRequest, com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75504b;
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceRequest
    public final List c() {
        return this.f75503a;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceRequest) {
            FindCurrentPlaceRequest findCurrentPlaceRequest = (FindCurrentPlaceRequest) obj;
            if (this.f75503a.equals(findCurrentPlaceRequest.c()) && ((cancellationToken = this.f75504b) != null ? cancellationToken.equals(findCurrentPlaceRequest.a()) : findCurrentPlaceRequest.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f75503a.hashCode() ^ 1000003;
        CancellationToken cancellationToken = this.f75504b;
        return (iHashCode * 1000003) ^ (cancellationToken == null ? 0 : cancellationToken.hashCode());
    }

    public final String toString() {
        String string = this.f75503a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f75504b);
        StringBuilder sb = new StringBuilder(length + 56 + strValueOf.length() + 1);
        sb.append("FindCurrentPlaceRequest{placeFields=");
        sb.append(string);
        sb.append(", cancellationToken=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
