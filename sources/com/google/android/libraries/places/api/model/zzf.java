package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.AuthorAttribution;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzf extends AuthorAttribution.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f75341c;

    zzf() {
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution.Builder
    public final AuthorAttribution.Builder b(String str) {
        this.f75341c = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution.Builder
    public final AuthorAttribution.Builder c(String str) {
        this.f75340b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AuthorAttribution.Builder
    final AuthorAttribution d() {
        String str = this.f75339a;
        if (str != null) {
            return new zzcm(str, this.f75340b, this.f75341c);
        }
        throw new IllegalStateException("Missing required properties: name");
    }

    final AuthorAttribution.Builder e(String str) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.f75339a = str;
        return this;
    }
}
