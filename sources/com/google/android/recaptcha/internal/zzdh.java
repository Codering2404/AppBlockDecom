package com.google.android.recaptcha.internal;

import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdh extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzdt zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdh(zzdt zzdtVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdtVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdh(this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.zza;
        ResultKt.b(obj);
        if (i3 != 0) {
            return obj;
        }
        int iZza = new zzbs(GoogleApiAvailabilityLight.h()).zza(this.zzb.zzr());
        zzdt zzdtVar = this.zzb;
        String str = zzdtVar.zza;
        String packageName = zzdtVar.zzr().getPackageName();
        String strZzd = this.zzb.zzb.zzd();
        zzbf zzbfVarZzt = this.zzb.zzt();
        int i4 = Build.VERSION.SDK_INT;
        String strZza = zzbfVarZzt.zza();
        zztn zztnVarZzf = zzto.zzf();
        zztnVarZzf.zzt(str);
        zztnVarZzf.zzq(packageName);
        zztnVarZzf.zzu(iZza);
        zztnVarZzf.zzr("18.6.1");
        zztnVarZzf.zzs(strZzd);
        zztnVarZzf.zzf(String.valueOf(i4));
        zztnVarZzf.zze(strZza);
        zzto zztoVar = (zzto) zztnVarZzf.zzk();
        zzdt zzdtVar2 = this.zzb;
        zzff zzffVarZzg = zzdt.zzg(zzdtVar2);
        String strZzb = zzdt.zzd(zzdtVar2).zzb();
        this.zza = 1;
        Object objZzc = zzffVarZzg.zzc(strZzb, zztoVar, this);
        return objZzc == objF ? objF : objZzc;
    }
}
