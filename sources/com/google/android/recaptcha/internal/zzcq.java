package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcq {
    private static zzcv zza;

    public static final zzcv zza(Application application) {
        zzcv zzcvVar = zza;
        if (zzcvVar == null) {
            zzcvVar = new zzcv(application);
        }
        if (zza == null) {
            zza = zzcvVar;
        }
        return zzcvVar;
    }

    public static final Object zzb(Application application, String str, long j3, Continuation continuation) throws RecaptchaException, TimeoutCancellationException, ApiException {
        return zzcv.zzh(zza(application), str, j3, null, null, null, continuation, 28, null);
    }

    public static final Task zzc(Application application, String str, long j3) throws RecaptchaException, TimeoutCancellationException, ApiException {
        return zzas.zza(BuildersKt__Builders_commonKt.b(zza(application).zzd().zza(), null, null, new zzco(application, str, j3, null), 3, null));
    }

    public static final Object zzd(Application application, String str, Continuation continuation) throws RecaptchaException, ApiException {
        zzcv zzcvVarZza = zza(application);
        return zzcv.zzh(zzcvVarZza, str, 0L, null, zzcvVarZza.zzf, zzch.zzb, continuation, 2, null);
    }

    public static final Task zze(Application application, String str) throws RecaptchaException, ApiException {
        return zzas.zza(BuildersKt__Builders_commonKt.b(zza(application).zzd().zza(), null, null, new zzcp(application, str, null), 3, null));
    }
}
