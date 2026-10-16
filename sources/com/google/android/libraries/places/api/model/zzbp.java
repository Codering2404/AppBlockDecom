package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.ReviewSummary;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbp extends ReviewSummary.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f75291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f75294f;

    zzbp() {
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary a() {
        return new zzfc(this.f75289a, this.f75290b, this.f75291c, this.f75292d, this.f75293e, this.f75294f);
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder b(String str) {
        this.f75292d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder c(String str) {
        this.f75293e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder d(Uri uri) {
        this.f75291c = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder e(Uri uri) {
        this.f75294f = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder f(String str) {
        this.f75289a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary.Builder
    public final ReviewSummary.Builder g(String str) {
        this.f75290b = str;
        return this;
    }
}
