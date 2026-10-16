package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import d.qFm.sECyKyO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzg extends FetchResolvedPhotoUriRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f75468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f75469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PhotoMetadata f75470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellationToken f75471d;

    zzg() {
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    public final Integer b() {
        return this.f75469b;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    public final Integer c() {
        return this.f75468a;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    public final FetchResolvedPhotoUriRequest.Builder d(CancellationToken cancellationToken) {
        this.f75471d = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    public final FetchResolvedPhotoUriRequest.Builder e(Integer num) {
        this.f75469b = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    public final FetchResolvedPhotoUriRequest.Builder f(Integer num) {
        this.f75468a = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    final FetchResolvedPhotoUriRequest h() {
        PhotoMetadata photoMetadata = this.f75470c;
        if (photoMetadata != null) {
            return new zzh(this.f75468a, this.f75469b, photoMetadata, this.f75471d, null);
        }
        throw new IllegalStateException("Missing required properties: photoMetadata");
    }

    final FetchResolvedPhotoUriRequest.Builder i(PhotoMetadata photoMetadata) {
        if (photoMetadata == null) {
            throw new NullPointerException("Null photoMetadata");
        }
        this.f75470c = photoMetadata;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest.Builder
    final PhotoMetadata g() {
        PhotoMetadata photoMetadata = this.f75470c;
        if (photoMetadata != null) {
            return photoMetadata;
        }
        throw new IllegalStateException(sECyKyO.DRdoNjDarGsqR);
    }
}
