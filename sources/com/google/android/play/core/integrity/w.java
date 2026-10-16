package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class w implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w f83068a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83074g;

    /* synthetic */ w(Context context, v vVar) {
        com.google.android.play.integrity.internal.ak akVarB = com.google.android.play.integrity.internal.al.b(context);
        this.f83069b = akVarB;
        com.google.android.play.integrity.internal.an anVarB = com.google.android.play.integrity.internal.aj.b(bb.f83005a);
        this.f83070c = anVarB;
        au auVar = new au(akVarB, n.f83059a);
        this.f83071d = auVar;
        com.google.android.play.integrity.internal.an anVarB2 = com.google.android.play.integrity.internal.aj.b(new bp(akVarB, anVarB, auVar, n.f83059a));
        this.f83072e = anVarB2;
        com.google.android.play.integrity.internal.an anVarB3 = com.google.android.play.integrity.internal.aj.b(new bu(anVarB2));
        this.f83073f = anVarB3;
        this.f83074g = com.google.android.play.integrity.internal.aj.b(new ba(anVarB2, anVarB3));
    }

    @Override // com.google.android.play.core.integrity.aw
    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f83074g.a();
    }
}
