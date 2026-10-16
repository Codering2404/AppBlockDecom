package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zza extends FetchPhotoRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f75448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f75449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PhotoMetadata f75450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellationToken f75451d;

    zza() {
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    public final Integer b() {
        return this.f75449b;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    public final Integer c() {
        return this.f75448a;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    public final FetchPhotoRequest.Builder d(CancellationToken cancellationToken) {
        this.f75451d = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    public final FetchPhotoRequest.Builder e(Integer num) {
        this.f75449b = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    public final FetchPhotoRequest.Builder f(Integer num) {
        this.f75448a = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    final PhotoMetadata g() {
        PhotoMetadata photoMetadata = this.f75450c;
        if (photoMetadata != null) {
            return photoMetadata;
        }
        throw new IllegalStateException("Property \"photoMetadata\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.FetchPhotoRequest.Builder
    final FetchPhotoRequest h() {
        PhotoMetadata photoMetadata = this.f75450c;
        if (photoMetadata != null) {
            return new zzb(this.f75448a, this.f75449b, photoMetadata, this.f75451d, null);
        }
        throw new IllegalStateException("Missing required properties: photoMetadata");
    }

    final FetchPhotoRequest.Builder i(PhotoMetadata photoMetadata) {
        if (photoMetadata == null) {
            throw new NullPointerException("Null photoMetadata");
        }
        this.f75450c = photoMetadata;
        return this;
    }
}
