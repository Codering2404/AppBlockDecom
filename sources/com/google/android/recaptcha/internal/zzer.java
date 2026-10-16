package com.google.android.recaptcha.internal;

import android.content.ContentValues;
import com.applovin.sdk.AppLovinErrorCodes;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzer extends SuspendLambda implements Function2 {
    final /* synthetic */ zzes zza;
    final /* synthetic */ zztx zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzer(zzes zzesVar, zztx zztxVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzesVar;
        this.zzb = zztxVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzer(this.zza, this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzer) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        ResultKt.b(obj);
        zztx zztxVar = this.zzb;
        zzes zzesVar = this.zza;
        synchronized (zzeo.class) {
            try {
                if (zzesVar.zze != null) {
                    byte[] bArrZzd = zztxVar.zzd();
                    zzej zzejVar = new zzej(zzkh.zzg().zzi(bArrZzd, 0, bArrZzd.length), System.currentTimeMillis(), 0);
                    zzei zzeiVar = zzesVar.zze;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ss", zzejVar.zzc());
                    contentValues.put("ts", Long.valueOf(zzejVar.zzb()));
                    zzeiVar.getWritableDatabase().insert("ce", null, contentValues);
                    int iZzb = zzesVar.zze.zzb() + AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                    if (iZzb > 0) {
                        zzesVar.zze.zza(CollectionsKt.take(zzesVar.zze.zzd(), iZzb));
                    }
                    if (zzesVar.zze.zzb() >= 20) {
                        zzesVar.zzg();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return Unit.f139807a;
    }
}
