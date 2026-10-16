package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final s f83061a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.an f83066f;

    /* synthetic */ s(Context context, r rVar) {
        com.google.android.play.integrity.internal.ak akVarB = com.google.android.play.integrity.internal.al.b(context);
        this.f83062b = akVarB;
        com.google.android.play.integrity.internal.an anVarB = com.google.android.play.integrity.internal.aj.b(ac.f82952a);
        this.f83063c = anVarB;
        au auVar = new au(akVarB, l.f83054a);
        this.f83064d = auVar;
        com.google.android.play.integrity.internal.an anVarB2 = com.google.android.play.integrity.internal.aj.b(new al(akVarB, anVarB, auVar, l.f83054a));
        this.f83065e = anVarB2;
        this.f83066f = com.google.android.play.integrity.internal.aj.b(new ab(anVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f83066f.a();
    }
}
