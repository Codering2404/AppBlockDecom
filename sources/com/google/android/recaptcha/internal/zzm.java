package com.google.android.recaptcha.internal;

import android.content.ContentResolver;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzm implements zzy {
    private final zzek zza;
    private final ContentResolver zzb;

    public zzm(zzek zzekVar, ContentResolver contentResolver) {
        this.zza = zzekVar;
        this.zzb = contentResolver;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final int zza() {
        return 17;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final zzek zzb() {
        return this.zza;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzc(String str, Continuation continuation) {
        zzen zzenVarZzb = zzz.zzb(this, str);
        String strZza = zzap.zza(this.zzb);
        zzenVarZzb.zza();
        zztf zztfVarZzf = zzti.zzf();
        zztg zztgVarZzf = zzth.zzf();
        zztgVarZzf.zzw(strZza);
        zztfVarZzf.zze(CollectionsKt.listOf(zztgVarZzf.zzk()));
        return zzz.zza(this, (zzti) zztfVarZzf.zzk());
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final Object zzd(zzse zzseVar, Continuation continuation) {
        zzz.zzc(this).zza();
        return Unit.f139807a;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.android.recaptcha.internal.zzy
    public final void zze(zzsr zzsrVar) {
    }
}
