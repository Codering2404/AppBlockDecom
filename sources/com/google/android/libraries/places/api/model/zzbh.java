package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.PlusCode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbh extends PlusCode.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75258b;

    zzbh() {
    }

    @Override // com.google.android.libraries.places.api.model.PlusCode.Builder
    public final PlusCode a() {
        return new zzeu(this.f75257a, this.f75258b);
    }

    @Override // com.google.android.libraries.places.api.model.PlusCode.Builder
    public final PlusCode.Builder b(String str) {
        this.f75257a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.PlusCode.Builder
    public final PlusCode.Builder c(String str) {
        this.f75258b = str;
        return this;
    }
}
