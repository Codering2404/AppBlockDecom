package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzp implements zzy {
    private final zzek zza;
    private final Lazy zzb;
    private boolean zzc;

    public zzp(zzek zzekVar) {
        this.zza = zzekVar;
        int i3 = zzav.zza;
        this.zzb = LazyKt.b(zzo.zza);
        this.zzc = true;
    }

    private final zzbf zzg() {
        return (zzbf) this.zzb.getValue();
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final zzek zzb() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzc(String str, Continuation continuation) {
        zzen zzenVarZzb = zzz.zzb(this, str);
        String strZza = zzg().zza();
        zzenVarZzb.zza();
        zztf zztfVarZzf = zzti.zzf();
        zztg zztgVarZzf = zzth.zzf();
        zztgVarZzf.zzw(strZza);
        zztfVarZzf.zze(CollectionsKt.listOf(zztgVarZzf.zzk()));
        return zzz.zza(this, (zzti) zztfVarZzf.zzk());
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzd(zzse zzseVar, Continuation continuation) {
        zzen zzenVarZzc = zzz.zzc(this);
        if (zzseVar.zzl().length() == 0) {
            this.zzc = false;
            zzenVarZzc.zzb(new zzbd(zzbb.zzb, zzba.zzab, null));
            return Unit.f139807a;
        }
        zzg().zzb(MapsKt.mapOf(TuplesKt.a("_GRECAPTCHA_KC", zzseVar.zzl())));
        zzenVarZzc.zza();
        return Unit.f139807a;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final boolean zzf() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final void zze(zzsr zzsrVar) {
    }
}
