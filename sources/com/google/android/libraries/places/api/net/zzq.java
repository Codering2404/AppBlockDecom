package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzq extends IsOpenRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place f75511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f75513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CancellationToken f75514d;

    /* synthetic */ zzq(Place place, String str, long j3, CancellationToken cancellationToken, byte[] bArr) {
        this.f75511a = place;
        this.f75512b = str;
        this.f75513c = j3;
        this.f75514d = cancellationToken;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest, com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75514d;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IsOpenRequest) {
            IsOpenRequest isOpenRequest = (IsOpenRequest) obj;
            Place place = this.f75511a;
            if (place != null ? place.equals(isOpenRequest.f()) : isOpenRequest.f() == null) {
                String str = this.f75512b;
                if (str != null ? str.equals(isOpenRequest.g()) : isOpenRequest.g() == null) {
                    if (this.f75513c == isOpenRequest.h() && ((cancellationToken = this.f75514d) != null ? cancellationToken.equals(isOpenRequest.a()) : isOpenRequest.a() == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest
    public final Place f() {
        return this.f75511a;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest
    public final String g() {
        return this.f75512b;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest
    public final long h() {
        return this.f75513c;
    }

    public final int hashCode() {
        Place place = this.f75511a;
        int iHashCode = place == null ? 0 : place.hashCode();
        String str = this.f75512b;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int i3 = iHashCode ^ 1000003;
        long j3 = this.f75513c;
        CancellationToken cancellationToken = this.f75514d;
        return (((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (cancellationToken != null ? cancellationToken.hashCode() : 0);
    }

    public final String toString() {
        CancellationToken cancellationToken = this.f75514d;
        String strValueOf = String.valueOf(this.f75511a);
        String strValueOf2 = String.valueOf(cancellationToken);
        int length = strValueOf.length();
        String str = this.f75512b;
        int length2 = String.valueOf(str).length();
        long j3 = this.f75513c;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 16 + String.valueOf(j3).length() + 20 + strValueOf2.length() + 1);
        sb.append("IsOpenRequest{place=");
        sb.append(strValueOf);
        sb.append(", placeId=");
        sb.append(str);
        sb.append(", utcTimeMillis=");
        sb.append(j3);
        sb.append(", cancellationToken=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
