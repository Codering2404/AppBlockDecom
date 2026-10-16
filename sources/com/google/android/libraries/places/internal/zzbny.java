package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbny extends zzbjr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f76518a = Logger.getLogger(zzbny.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final ThreadLocal f76519b = new ThreadLocal();

    zzbny() {
    }

    @Override // com.google.android.libraries.places.internal.zzbjr
    public final zzbjs a(zzbjs zzbjsVar) {
        zzbjs zzbjsVarC = c();
        f76519b.set(zzbjsVar);
        return zzbjsVarC;
    }

    @Override // com.google.android.libraries.places.internal.zzbjr
    public final void b(zzbjs zzbjsVar, zzbjs zzbjsVar2) {
        if (c() != zzbjsVar) {
            f76518a.logp(Level.SEVERE, "io.grpc.ThreadLocalContextStorage", "detach", "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (zzbjsVar2 != zzbjs.f76295b) {
            f76519b.set(zzbjsVar2);
        } else {
            f76519b.set(null);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbjr
    public final zzbjs c() {
        zzbjs zzbjsVar = (zzbjs) f76519b.get();
        return zzbjsVar == null ? zzbjs.f76295b : zzbjsVar;
    }
}
