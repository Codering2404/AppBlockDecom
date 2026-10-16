package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.ContentBlock;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzu extends ContentBlock.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f75404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f75405d;

    zzu() {
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    public final ContentBlock.Builder b(String str) {
        this.f75402a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    public final ContentBlock.Builder c(String str) {
        this.f75403b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    public final ContentBlock.Builder d(List list) {
        this.f75405d = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    public final ContentBlock.Builder e(List list) {
        this.f75404c = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    final List f() {
        return this.f75404c;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    final List g() {
        return this.f75405d;
    }

    @Override // com.google.android.libraries.places.api.model.ContentBlock.Builder
    final ContentBlock h() {
        return new zzde(this.f75402a, this.f75403b, this.f75404c, this.f75405d);
    }
}
