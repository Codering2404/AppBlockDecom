package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkt implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzaz f74101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74102b;

    zzkt(zzlj zzljVar, zzaz zzazVar) {
        this.f74101a = zzazVar;
        Objects.requireNonNull(zzljVar);
        this.f74102b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74102b;
        zzic zzicVar = zzljVar.f73997a;
        zzhh zzhhVarX = zzicVar.x();
        zzic zzicVar2 = zzhhVarX.f73997a;
        zzhhVarX.h();
        zzaz zzazVarU = zzhhVarX.u();
        zzaz zzazVar = this.f74101a;
        if (!zzjl.u(zzazVar.b(), zzazVarU.b())) {
            zzicVar.a().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzazVar.b()));
            return;
        }
        SharedPreferences.Editor editorEdit = zzhhVarX.p().edit();
        editorEdit.putString("dma_consent_settings", zzazVar.e());
        editorEdit.apply();
        zzicVar.a().w().b("Setting DMA consent(FE)", zzazVar);
        zzic zzicVar3 = zzljVar.f73997a;
        if (zzicVar3.J().D()) {
            zzicVar3.J().a0();
        } else {
            zzicVar3.J().Y(false);
        }
    }
}
