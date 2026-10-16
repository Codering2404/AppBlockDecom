package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzh extends FetchResolvedPhotoUriRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f75472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f75473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PhotoMetadata f75474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CancellationToken f75475d;

    /* synthetic */ zzh(Integer num, Integer num2, PhotoMetadata photoMetadata, CancellationToken cancellationToken, byte[] bArr) {
        this.f75472a = num;
        this.f75473b = num2;
        this.f75474c = photoMetadata;
        this.f75475d = cancellationToken;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest, com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75475d;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest
    public final Integer c() {
        return this.f75473b;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest
    public final Integer d() {
        return this.f75472a;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest
    public final PhotoMetadata e() {
        return this.f75474c;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchResolvedPhotoUriRequest) {
            FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest = (FetchResolvedPhotoUriRequest) obj;
            Integer num = this.f75472a;
            if (num != null ? num.equals(fetchResolvedPhotoUriRequest.d()) : fetchResolvedPhotoUriRequest.d() == null) {
                Integer num2 = this.f75473b;
                if (num2 != null ? num2.equals(fetchResolvedPhotoUriRequest.c()) : fetchResolvedPhotoUriRequest.c() == null) {
                    if (this.f75474c.equals(fetchResolvedPhotoUriRequest.e()) && ((cancellationToken = this.f75475d) != null ? cancellationToken.equals(fetchResolvedPhotoUriRequest.a()) : fetchResolvedPhotoUriRequest.a() == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f75472a;
        int iHashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.f75473b;
        int iHashCode2 = ((((iHashCode ^ 1000003) * 1000003) ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.f75474c.hashCode();
        CancellationToken cancellationToken = this.f75475d;
        return (iHashCode2 * 1000003) ^ (cancellationToken != null ? cancellationToken.hashCode() : 0);
    }

    public final String toString() {
        CancellationToken cancellationToken = this.f75475d;
        String string = this.f75474c.toString();
        String strValueOf = String.valueOf(cancellationToken);
        Integer num = this.f75472a;
        int length = String.valueOf(num).length();
        Integer num2 = this.f75473b;
        int length2 = String.valueOf(num2).length();
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 16 + string.length() + 20 + strValueOf.length() + 1);
        sb.append("FetchResolvedPhotoUriRequest{maxWidth=");
        sb.append(num);
        sb.append(", maxHeight=");
        sb.append(num2);
        sb.append(", photoMetadata=");
        sb.append(string);
        sb.append(", cancellationToken=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
