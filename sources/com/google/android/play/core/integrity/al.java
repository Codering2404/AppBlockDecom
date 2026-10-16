package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class al implements com.google.android.play.integrity.internal.ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f82977d;

    public al(com.google.android.play.integrity.internal.an anVar, com.google.android.play.integrity.internal.an anVar2, com.google.android.play.integrity.internal.an anVar3, com.google.android.play.integrity.internal.an anVar4) {
        this.f82974a = anVar;
        this.f82975b = anVar2;
        this.f82976c = anVar3;
        this.f82977d = anVar4;
    }

    @Override // com.google.android.play.integrity.internal.an
    public final /* bridge */ /* synthetic */ Object a() {
        return new aj((Context) this.f82974a.a(), (com.google.android.play.integrity.internal.s) this.f82975b.a(), ((au) this.f82976c).a(), new i());
    }
}
