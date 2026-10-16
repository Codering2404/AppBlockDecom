package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzcek extends zzblg {
    @Override // com.google.android.libraries.places.internal.zzblg
    public final zzblm a(zzbld zzbldVar) {
        return f().a(zzbldVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public void b(zzbjn zzbjnVar, zzbln zzblnVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final void c() {
        f().c();
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final zzbnx d() {
        return f().d();
    }

    @Override // com.google.android.libraries.places.internal.zzblg
    public final ScheduledExecutorService e() {
        return f().e();
    }

    protected abstract zzblg f();

    public final String toString() {
        return MoreObjects.c(this).d("delegate", f()).toString();
    }
}
