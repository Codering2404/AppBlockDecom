package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvl extends zzbit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f76954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbit f76956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbvr f76957d;

    /* synthetic */ zzbvl(zzbvr zzbvrVar, String str, byte[] bArr) {
        Objects.requireNonNull(zzbvrVar);
        this.f76957d = zzbvrVar;
        this.f76954a = new AtomicReference(zzbvr.f76981j0);
        this.f76956c = new zzbvc(this);
        this.f76955b = (String) Preconditions.u(str, "authority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final zzbix i(zzbml zzbmlVar, zzbis zzbisVar) {
        zzbkq zzbkqVar = (zzbkq) this.f76954a.get();
        if (zzbkqVar == null) {
            return this.f76956c.d(zzbmlVar, zzbisVar);
        }
        if (!(zzbkqVar instanceof zzbwa)) {
            return new zzbut(zzbkqVar, this.f76956c, this.f76957d.q0(), zzbmlVar, zzbisVar);
        }
        zzbvz zzbvzVarE = ((zzbwa) zzbkqVar).f77057b.e(zzbmlVar);
        if (zzbvzVarE != null) {
            zzbisVar = zzbisVar.h(zzbvz.f77050g, zzbvzVarE);
        }
        return this.f76956c.d(zzbmlVar, zzbisVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final zzbix d(zzbml zzbmlVar, zzbis zzbisVar) {
        AtomicReference atomicReference = this.f76954a;
        if (atomicReference.get() != zzbvr.f76981j0) {
            return i(zzbmlVar, zzbisVar);
        }
        zzbvr zzbvrVar = this.f76957d;
        zzbvf zzbvfVar = new zzbvf(this);
        zzbnx zzbnxVar = zzbvrVar.f77001n;
        zzbnxVar.a(zzbvfVar);
        zzbnxVar.zza();
        if (atomicReference.get() != zzbvr.f76981j0) {
            return i(zzbmlVar, zzbisVar);
        }
        if (zzbvrVar.u().get()) {
            return new zzbvg(this);
        }
        zzbvk zzbvkVar = new zzbvk(this, zzbjs.a(), zzbmlVar, zzbisVar);
        zzbnxVar.a(new zzbvh(this, zzbvkVar));
        zzbnxVar.zza();
        return zzbvkVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final String f() {
        return this.f76955b;
    }

    final void g(zzbkq zzbkqVar) {
        AtomicReference atomicReference = this.f76954a;
        zzbkq zzbkqVar2 = (zzbkq) atomicReference.get();
        atomicReference.set(zzbkqVar);
        if (zzbkqVar2 == zzbvr.f76981j0) {
            zzbvr zzbvrVar = this.f76957d;
            if (zzbvrVar.p() != null) {
                Iterator it = zzbvrVar.p().iterator();
                while (it.hasNext()) {
                    ((zzbvk) it.next()).p();
                }
            }
        }
    }

    final void h() {
        if (this.f76954a.get() == zzbvr.f76981j0) {
            g(null);
        }
    }

    final /* synthetic */ AtomicReference j() {
        return this.f76954a;
    }

    final /* synthetic */ String k() {
        return this.f76955b;
    }
}
