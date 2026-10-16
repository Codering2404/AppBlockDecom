package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class au implements com.google.android.play.integrity.internal.ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82995b;

    public au(com.google.android.play.integrity.internal.an anVar, com.google.android.play.integrity.internal.an anVar2) {
        this.f82994a = anVar;
        this.f82995b = anVar2;
    }

    @Override // com.google.android.play.integrity.internal.an
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final at a() {
        return new at(this.f82994a, this.f82995b);
    }
}
