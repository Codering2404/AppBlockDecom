package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpu;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzac extends zzab {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.android.gms.internal.measurement.zzfn f73376g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzad f73377h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzac(zzad zzadVar, String str, int i3, com.google.android.gms.internal.measurement.zzfn zzfnVar) {
        super(str, i3);
        Objects.requireNonNull(zzadVar);
        this.f73377h = zzadVar;
        this.f73376g = zzfnVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final int a() {
        return this.f73376g.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzab
    final boolean c() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final boolean k(Long l3, Long l4, com.google.android.gms.internal.measurement.zziu zziuVar, boolean z2) {
        zzpu.zza();
        zzic zzicVar = this.f73377h.f73997a;
        boolean zH = zzicVar.w().H(this.f73370a, zzfy.E0);
        com.google.android.gms.internal.measurement.zzfn zzfnVar = this.f73376g;
        boolean zZze = zzfnVar.zze();
        boolean zZzf = zzfnVar.zzf();
        boolean zZzh = zzfnVar.zzh();
        Object[] objArr = zZze || zZzf || zZzh;
        Boolean boolE = null;
        boolE = null;
        boolE = null;
        boolE = null;
        boolE = null;
        if (z2 && objArr != true) {
            zzicVar.a().w().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f73371b), zzfnVar.zza() ? Integer.valueOf(zzfnVar.zzb()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.zzfh zzfhVarZzd = zzfnVar.zzd();
        boolean zZzf2 = zzfhVarZzd.zzf();
        if (zziuVar.zzf()) {
            if (zzfhVarZzd.zzc()) {
                boolE = zzab.e(zzab.g(zziuVar.zzg(), zzfhVarZzd.zzd()), zZzf2);
            } else {
                zzicVar.a().r().b("No number filter for long property. property", zzicVar.D().c(zziuVar.zzc()));
            }
        } else if (zziuVar.zzj()) {
            if (zzfhVarZzd.zzc()) {
                boolE = zzab.e(zzab.h(zziuVar.zzk(), zzfhVarZzd.zzd()), zZzf2);
            } else {
                zzicVar.a().r().b("No number filter for double property. property", zzicVar.D().c(zziuVar.zzc()));
            }
        } else if (!zziuVar.zzd()) {
            zzicVar.a().r().b("User property has no value, property", zzicVar.D().c(zziuVar.zzc()));
        } else if (zzfhVarZzd.zza()) {
            boolE = zzab.e(zzab.f(zziuVar.zze(), zzfhVarZzd.zzb(), zzicVar.a()), zZzf2);
        } else if (!zzfhVarZzd.zzc()) {
            zzicVar.a().r().b("No string or number filter defined. property", zzicVar.D().c(zziuVar.zzc()));
        } else if (zzpk.O(zziuVar.zze())) {
            boolE = zzab.e(zzab.i(zziuVar.zze(), zzfhVarZzd.zzd()), zZzf2);
        } else {
            zzicVar.a().r().c("Invalid user property value for Numeric number filter. property, value", zzicVar.D().c(zziuVar.zzc()), zziuVar.zze());
        }
        zzicVar.a().w().b("Property filter result", boolE == null ? "null" : boolE);
        if (boolE == null) {
            return false;
        }
        this.f73372c = Boolean.TRUE;
        if (zZzh && !boolE.booleanValue()) {
            return true;
        }
        if (!z2 || zzfnVar.zze()) {
            this.f73373d = boolE;
        }
        if (boolE.booleanValue() && objArr != false && zziuVar.zza()) {
            long jZzb = zziuVar.zzb();
            if (l3 != null) {
                jZzb = l3.longValue();
            }
            if (zH && zzfnVar.zze() && !zzfnVar.zzf() && l4 != null) {
                jZzb = l4.longValue();
            }
            if (zzfnVar.zzf()) {
                this.f73375f = Long.valueOf(jZzb);
            } else {
                this.f73374e = Long.valueOf(jZzb);
            }
        }
        return true;
    }
}
