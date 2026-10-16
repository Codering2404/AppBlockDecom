package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbut extends zzbkd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbkq f76920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbit f76921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f76922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbml f76923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbjs f76924e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzbis f76925f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbix f76926g;

    zzbut(zzbkq zzbkqVar, zzbit zzbitVar, Executor executor, zzbml zzbmlVar, zzbis zzbisVar) {
        this.f76920a = zzbkqVar;
        this.f76921b = zzbitVar;
        this.f76923d = zzbmlVar;
        executor = zzbisVar.j() != null ? zzbisVar.j() : executor;
        this.f76922c = executor;
        this.f76925f = zzbisVar.e(executor);
        this.f76924e = zzbjs.a();
    }

    @Override // com.google.android.libraries.places.internal.zzbkd, com.google.android.libraries.places.internal.zzbix
    public final void a(zzbiw zzbiwVar, zzbmg zzbmgVar) {
        zzbis zzbisVar = this.f76925f;
        zzblh zzblhVar = zzbvr.f76982k0;
        zzbml zzbmlVar = this.f76923d;
        zzbkp zzbkpVarA = this.f76920a.a(new zzbxk(zzbmlVar, zzbmgVar, zzbisVar, zzblhVar));
        zzbnp zzbnpVarA = zzbkpVarA.a();
        if (!zzbnpVarA.j()) {
            this.f76922c.execute(new zzbus(this, zzbiwVar, zzbsz.i(zzbnpVarA)));
            this.f76926g = zzbvr.f76983l0;
        } else {
            zzbvz zzbvzVarE = ((zzbwb) zzbkpVarA.b()).e(zzbmlVar);
            if (zzbvzVarE != null) {
                this.f76925f = this.f76925f.h(zzbvz.f77050g, zzbvzVarE);
            }
            zzbix zzbixVarD = this.f76921b.d(zzbmlVar, this.f76925f);
            this.f76926g = zzbixVarD;
            zzbixVarD.a(zzbiwVar, zzbmgVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbnd, com.google.android.libraries.places.internal.zzbix
    public final void e(String str, Throwable th) {
        zzbix zzbixVar = this.f76926g;
        if (zzbixVar != null) {
            zzbixVar.e(str, th);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbkd, com.google.android.libraries.places.internal.zzbnd
    protected final zzbix f() {
        return this.f76926g;
    }

    final /* synthetic */ zzbjs g() {
        return this.f76924e;
    }
}
