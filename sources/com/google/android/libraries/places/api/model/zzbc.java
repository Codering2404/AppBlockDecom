package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbc extends PhotoMetadata.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f75149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f75150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AuthorAttributions f75153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Uri f75154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte f75155h;

    zzbc() {
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder b(String str) {
        if (str == null) {
            throw new NullPointerException("Null attributions");
        }
        this.f75148a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder c(AuthorAttributions authorAttributions) {
        this.f75153f = authorAttributions;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder d(int i3) {
        this.f75149b = i3;
        this.f75155h = (byte) (this.f75155h | 1);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder e(int i3) {
        this.f75150c = i3;
        this.f75155h = (byte) (this.f75155h | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder f(String str) {
        this.f75152e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    public final PhotoMetadata.Builder g(Uri uri) {
        this.f75154g = uri;
        return this;
    }

    final PhotoMetadata.Builder i(String str) {
        if (str == null) {
            throw new NullPointerException("Null photoReference");
        }
        this.f75151d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata.Builder
    final PhotoMetadata h() {
        String str;
        String str2;
        if (this.f75155h == 3 && (str = this.f75148a) != null && (str2 = this.f75151d) != null) {
            return new zzeo(str, this.f75149b, this.f75150c, str2, this.f75152e, this.f75153f, this.f75154g);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75148a == null) {
            sb.append(" attributions");
        }
        if ((this.f75155h & 1) == 0) {
            sb.append(" height");
        }
        if ((this.f75155h & 2) == 0) {
            sb.append(" width");
        }
        if (this.f75151d == null) {
            sb.append(YznnJpHcAmeoW.AMwIVhBeEDl);
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
