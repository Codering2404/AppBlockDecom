package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.GenerativeSummary;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzah extends GenerativeSummary.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f75056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75058e;

    zzah() {
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary a() {
        return new zzds(this.f75054a, this.f75055b, this.f75056c, this.f75057d, this.f75058e);
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary.Builder b(String str) {
        this.f75057d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary.Builder c(String str) {
        this.f75058e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary.Builder d(Uri uri) {
        this.f75056c = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary.Builder e(String str) {
        this.f75054a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary.Builder
    public final GenerativeSummary.Builder f(String str) {
        this.f75055b = str;
        return this;
    }
}
