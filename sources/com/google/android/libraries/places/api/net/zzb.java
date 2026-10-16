package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzb extends FetchPhotoRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f75452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f75453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PhotoMetadata f75454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CancellationToken f75455d;

    /* synthetic */ zzb(Integer num, Integer num2, PhotoMetadata photoMetadata, CancellationToken cancellationToken, byte[] bArr) {
        this.f75452a = num;
        this.f75453b = num2;
        this.f75454c = photoMetadata;
        this.f75455d = cancellationToken;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest, com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75455d;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest
    public final Integer c() {
        return this.f75453b;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest
    public final Integer d() {
        return this.f75452a;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest
    public final PhotoMetadata e() {
        return this.f75454c;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoRequest) {
            FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) obj;
            Integer num = this.f75452a;
            if (num != null ? num.equals(fetchPhotoRequest.d()) : fetchPhotoRequest.d() == null) {
                Integer num2 = this.f75453b;
                if (num2 != null ? num2.equals(fetchPhotoRequest.c()) : fetchPhotoRequest.c() == null) {
                    if (this.f75454c.equals(fetchPhotoRequest.e()) && ((cancellationToken = this.f75455d) != null ? cancellationToken.equals(fetchPhotoRequest.a()) : fetchPhotoRequest.a() == null)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.f75452a;
        int iHashCode = num == null ? 0 : num.hashCode();
        Integer num2 = this.f75453b;
        int iHashCode2 = ((((iHashCode ^ 1000003) * 1000003) ^ (num2 == null ? 0 : num2.hashCode())) * 1000003) ^ this.f75454c.hashCode();
        CancellationToken cancellationToken = this.f75455d;
        return (iHashCode2 * 1000003) ^ (cancellationToken != null ? cancellationToken.hashCode() : 0);
    }

    public final String toString() {
        CancellationToken cancellationToken = this.f75455d;
        String string = this.f75454c.toString();
        String strValueOf = String.valueOf(cancellationToken);
        Integer num = this.f75452a;
        int length = String.valueOf(num).length();
        Integer num2 = this.f75453b;
        int length2 = String.valueOf(num2).length();
        StringBuilder sb = new StringBuilder(length + 39 + length2 + 16 + string.length() + 20 + strValueOf.length() + 1);
        sb.append("FetchPhotoRequest{maxWidth=");
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
