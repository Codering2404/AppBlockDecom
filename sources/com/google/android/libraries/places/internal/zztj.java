package com.google.android.libraries.places.internal;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zztj implements zzts, zzun {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f78588f = new String();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Level f78589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzti f78590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zztm f78591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzvp f78592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object[] f78593e;

    @Override // com.google.android.libraries.places.internal.zzun
    public final Level zze() {
        return this.f78589a;
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final zztm zzg() {
        zztm zztmVar = this.f78591c;
        if (zztmVar != null) {
            return zztmVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final zzvp zzh() {
        return this.f78592d;
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final Object[] zzi() {
        zzxb.c(this.f78592d != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.f78593e;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final Object zzj() {
        zzxb.c(this.f78592d == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.f78593e;
        if (objArr != null) {
            return objArr[0];
        }
        throw new IllegalStateException("cannot get literal argument before calling log()");
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final boolean zzk() {
        zzti zztiVar = this.f78590b;
        return zztiVar != null && Boolean.TRUE.equals(zztiVar.d(zzth.f78583g));
    }

    @Override // com.google.android.libraries.places.internal.zzun
    public final zzut zzl() {
        zzti zztiVar = this.f78590b;
        return zztiVar != null ? zztiVar : zzut.e();
    }
}
