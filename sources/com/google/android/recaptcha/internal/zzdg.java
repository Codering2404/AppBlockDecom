package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzdg extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzdt zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzsp zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdg(zzdt zzdtVar, String str, long j3, zzsp zzspVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzdtVar;
        this.zzd = str;
        this.zze = j3;
        this.zzf = zzspVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzdg(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdg) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzen zzenVar;
        Exception e3;
        TimeoutCancellationException e4;
        zzbd e5;
        Object objF = IntrinsicsKt.f();
        if (this.zzb != 0) {
            zzenVar = (zzen) this.zza;
            try {
                ResultKt.b(obj);
            } catch (zzbd e6) {
                e5 = e6;
                zzbd zzbdVarZzs = this.zzc.zzs(e5, e5);
                zzenVar.zzb(zzbdVarZzs);
                throw zzbdVarZzs;
            } catch (TimeoutCancellationException e7) {
                e4 = e7;
                zzbd zzbdVarZzs2 = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzb, e4.getMessage()));
                zzenVar.zzb(zzbdVarZzs2);
                throw zzbdVarZzs2;
            } catch (Exception e8) {
                e3 = e8;
                zzbd zzbdVarZzs3 = this.zzc.zzs(e3, new zzbd(zzbb.zzc, zzba.zzZ, e3.getMessage()));
                zzenVar.zzb(zzbdVarZzs3);
                throw zzbdVarZzs3;
            }
        } else {
            ResultKt.b(obj);
            zzen zzenVarZzf = this.zzc.zzu(this.zzd).zzf(28);
            try {
                long j3 = this.zze;
                zzdf zzdfVar = new zzdf(this.zzc, this.zzf, zzenVarZzf, null);
                this.zza = zzenVarZzf;
                this.zzb = 1;
                Object objC = TimeoutKt.c(j3, zzdfVar, this);
                if (objC == objF) {
                    return objF;
                }
                zzenVar = zzenVarZzf;
                obj = objC;
            } catch (zzbd e9) {
                zzenVar = zzenVarZzf;
                e5 = e9;
                zzbd zzbdVarZzs4 = this.zzc.zzs(e5, e5);
                zzenVar.zzb(zzbdVarZzs4);
                throw zzbdVarZzs4;
            } catch (TimeoutCancellationException e10) {
                zzenVar = zzenVarZzf;
                e4 = e10;
                zzbd zzbdVarZzs22 = this.zzc.zzs(e4, new zzbd(zzbb.zzc, zzba.zzb, e4.getMessage()));
                zzenVar.zzb(zzbdVarZzs22);
                throw zzbdVarZzs22;
            } catch (Exception e11) {
                zzenVar = zzenVarZzf;
                e3 = e11;
                zzbd zzbdVarZzs32 = this.zzc.zzs(e3, new zzbd(zzbb.zzc, zzba.zzZ, e3.getMessage()));
                zzenVar.zzb(zzbdVarZzs32);
                throw zzbdVarZzs32;
            }
        }
        return (zzsr) obj;
    }
}
