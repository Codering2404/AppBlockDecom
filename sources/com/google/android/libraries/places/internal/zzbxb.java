package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblm f77124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbjn f77125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f77126c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbjo f77127d = zzbjo.a(zzbjn.IDLE);

    public zzbxb(zzblm zzblmVar, zzbjn zzbjnVar) {
        this.f77124a = zzblmVar;
        this.f77125b = zzbjnVar;
    }

    public final zzblm a() {
        return this.f77124a;
    }

    public final zzbjn b() {
        return this.f77125b;
    }

    public final boolean c() {
        return this.f77126c;
    }

    final /* synthetic */ void d(zzbjn zzbjnVar) {
        boolean z2;
        this.f77125b = zzbjnVar;
        if (zzbjnVar == zzbjn.READY || zzbjnVar == zzbjn.TRANSIENT_FAILURE) {
            z2 = true;
        } else if (zzbjnVar != zzbjn.IDLE) {
            return;
        } else {
            z2 = false;
        }
        this.f77126c = z2;
    }

    final /* synthetic */ zzbjn e() {
        return this.f77127d.c();
    }

    final /* synthetic */ zzblm f() {
        return this.f77124a;
    }

    final /* synthetic */ zzbjn g() {
        return this.f77125b;
    }

    final /* synthetic */ zzbjo h() {
        return this.f77127d;
    }

    final /* synthetic */ void i(zzbjo zzbjoVar) {
        this.f77127d = zzbjoVar;
    }
}
