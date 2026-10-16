package com.google.android.recaptcha.internal;

import android.app.Application;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.recaptcha.RecaptchaException;
import java.util.UUID;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcv {
    private final Application zza;
    private zzdc zzc;
    private final zzl zze;
    private final Mutex zzb = MutexKt.b(false, 1, null);
    private final String zzd = UUID.randomUUID().toString();
    private zzbi zzf = new zzbi();

    /* JADX WARN: Multi-variable type inference failed */
    public zzcv(Application application) {
        this.zza = application;
        int i3 = 1;
        this.zze = new zzl(null, i3, 0 == true ? 1 : 0);
        int i4 = zzav.zza;
        zzaw[] zzawVarArr = {new zzaw(zzaz.class.getName().hashCode(), new zzaz(null, 1, null)), new zzaw(zzfu.class.getName().hashCode(), new zzfu()), new zzaw(zzbe.class.getName().hashCode(), new zzbe()), new zzaw(zzjd.class.getName().hashCode(), new zzjd()), new zzaw(zzbr.class.getName().hashCode(), new zzbr("https://www.recaptcha.net/recaptcha/api3")), new zzaw(zzex.class.getName().hashCode(), new zzex(0 == true ? 1 : 0, i3, 0 == true ? 1 : 0)), new zzaw(zzfk.class.getName().hashCode(), new zzfk(true)), new zzaw(Application.class.getName().hashCode(), application), new zzaw(zzbf.class.getName().hashCode(), new zzbf(application)), new zzaw(zzfj.class.getName().hashCode(), new zzfj()), new zzaw(zzaq.class.getName().hashCode(), new zzbm(application)), new zzaw(zzey.class.getName().hashCode(), new zzfa()), new zzaw(zzff.class.getName().hashCode(), new zzff())};
        for (int i5 = 0; i5 < 13; i5++) {
            zzaw zzawVar = zzawVarArr[i5];
            if (!zzav.zzc.containsKey(Integer.valueOf(zzawVar.zza()))) {
                zzav.zzc.put(Integer.valueOf(zzawVar.zza()), zzawVar);
            }
        }
    }

    public static final /* synthetic */ zzdc zza(zzcv zzcvVar, String str) throws zzbd {
        zzdc zzdcVar = zzcvVar.zzc;
        if (zzdcVar == null) {
            return null;
        }
        if (Intrinsics.areEqual(zzdcVar.zzd(), str)) {
            return zzdcVar;
        }
        throw new zzbd(zzbb.zzd, zzba.zzam, null);
    }

    public static final /* synthetic */ void zzc(zzcv zzcvVar, long j3) throws zzbd {
        if (j3 < 5000) {
            throw new zzbd(zzbb.zzj, zzba.zzI, null);
        }
        if (ContextCompat.checkSelfPermission(zzcvVar.zza, "android.permission.INTERNET") != 0) {
            throw new zzbd(zzbb.zzc, zzba.zzao, null);
        }
    }

    public static final /* synthetic */ zzcn zze(zzcv zzcvVar, String str, zzbi zzbiVar, zzch zzchVar, zzek zzekVar) {
        zzdt zzdtVar = new zzdt(str, zzbiVar, zzekVar, zzcvVar.zze);
        return Intrinsics.areEqual(zzchVar, zzch.zza) ? new zzef(zzdtVar) : new zzec(zzdtVar, zzbiVar, zzekVar, new zzbo());
    }

    public static /* synthetic */ Object zzh(zzcv zzcvVar, String str, long j3, zzcn zzcnVar, zzbi zzbiVar, zzch zzchVar, Continuation continuation, int i3, Object obj) throws RecaptchaException, TimeoutCancellationException, ApiException {
        if ((i3 & 8) != 0) {
            zzbiVar = zzcvVar.zzf;
        }
        zzbi zzbiVar2 = zzbiVar;
        if ((i3 & 16) != 0) {
            zzchVar = zzch.zza;
        }
        zzch zzchVar2 = zzchVar;
        if ((i3 & 2) != 0) {
            j3 = 10000;
        }
        return zzcvVar.zzg(str, j3, null, zzbiVar2, zzchVar2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzj(java.lang.String r6, int r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzcu
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzcu r0 = (com.google.android.recaptcha.internal.zzcu) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzcu r0 = new com.google.android.recaptcha.internal.zzcu
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2b com.google.android.recaptcha.internal.zzbd -> L2d
            goto L50
        L2b:
            r7 = move-exception
            goto L5c
        L2d:
            r7 = move-exception
            goto L74
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.b(r9)
            com.google.android.recaptcha.internal.zzbi r9 = r5.zzf
            com.google.android.recaptcha.internal.zzek r6 = r5.zzk(r6, r9, r7)
            r7 = 6
            com.google.android.recaptcha.internal.zzen r7 = r6.zzf(r7)
            r0.zzd = r7     // Catch: java.lang.Exception -> L55 com.google.android.recaptcha.internal.zzbd -> L57
            r0.zzc = r3     // Catch: java.lang.Exception -> L55 com.google.android.recaptcha.internal.zzbd -> L57
            java.lang.Object r9 = r8.invoke(r6, r0)     // Catch: java.lang.Exception -> L55 com.google.android.recaptcha.internal.zzbd -> L57
            if (r9 == r1) goto L54
            r6 = r7
        L50:
            r6.zza()     // Catch: java.lang.Exception -> L2b com.google.android.recaptcha.internal.zzbd -> L2d
            return r9
        L54:
            return r1
        L55:
            r6 = move-exception
            goto L59
        L57:
            r6 = move-exception
            goto L71
        L59:
            r4 = r7
            r7 = r6
            r6 = r4
        L5c:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zza
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            com.google.android.recaptcha.RecaptchaException r6 = r8.zzc()
            throw r6
        L71:
            r4 = r7
            r7 = r6
            r6 = r4
        L74:
            r6.zzb(r7)
            com.google.android.recaptcha.RecaptchaException r6 = r7.zzc()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzj(java.lang.String, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final zzek zzk(String str, zzbi zzbiVar, int i3) {
        String string = UUID.randomUUID().toString();
        int i4 = zzav.zza;
        zzes zzesVar = new zzes(this.zza, new zzeu(((zzbr) LazyKt.b(zzcr.zza).getValue()).zzc()), zzbiVar.zza());
        zzek zzekVar = new zzek(str, this.zzd, string, i3, this.zza, zzesVar, null);
        zzekVar.zzc(string);
        return zzekVar;
    }

    public final zzbi zzd() {
        return this.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzg(java.lang.String r18, long r19, com.google.android.recaptcha.internal.zzcn r21, com.google.android.recaptcha.internal.zzbi r22, com.google.android.recaptcha.internal.zzch r23, kotlin.coroutines.Continuation r24) throws java.lang.Throwable {
        /*
            r17 = this;
            r1 = r17
            r0 = r24
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzcs
            if (r2 == 0) goto L17
            r2 = r0
            com.google.android.recaptcha.internal.zzcs r2 = (com.google.android.recaptcha.internal.zzcs) r2
            int r3 = r2.zzg
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.zzg = r3
            goto L1c
        L17:
            com.google.android.recaptcha.internal.zzcs r2 = new com.google.android.recaptcha.internal.zzcs
            r2.<init>(r1, r0)
        L1c:
            java.lang.Object r0 = r2.zze
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.zzg
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L5b
            if (r4 == r5) goto L41
            if (r4 != r6) goto L39
            java.lang.Object r2 = r2.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.b(r0)     // Catch: java.lang.Throwable -> L36
            goto Lb6
        L36:
            r0 = move-exception
            goto Lbe
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L41:
            long r4 = r2.zzd
            java.lang.Object r8 = r2.zzc
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            com.google.android.recaptcha.internal.zzch r9 = r2.zzi
            com.google.android.recaptcha.internal.zzbi r10 = r2.zzj
            java.lang.String r11 = r2.zzh
            java.lang.Object r12 = r2.zza
            com.google.android.recaptcha.internal.zzcv r12 = (com.google.android.recaptcha.internal.zzcv) r12
            kotlin.ResultKt.b(r0)
            r15 = r9
            r14 = r10
            r10 = r11
            r9 = r12
            r11 = r4
            r4 = r8
            goto L84
        L5b:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.zzb
            r2.zza = r1
            r4 = r18
            r2.zzh = r4
            r2.zzb = r7
            r8 = r22
            r2.zzj = r8
            r9 = r23
            r2.zzi = r9
            r2.zzc = r0
            r10 = r19
            r2.zzd = r10
            r2.zzg = r5
            java.lang.Object r5 = r0.f(r7, r2)
            if (r5 == r3) goto Lc2
            r14 = r8
            r15 = r9
            r11 = r10
            r9 = r1
            r10 = r4
            r4 = r0
        L84:
            com.google.android.recaptcha.internal.zzch r0 = com.google.android.recaptcha.internal.zzch.zza     // Catch: java.lang.Throwable -> Lbc
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r0)     // Catch: java.lang.Throwable -> Lbc
            if (r0 == 0) goto L8e
            r0 = 3
            goto L99
        L8e:
            com.google.android.recaptcha.internal.zzch r0 = com.google.android.recaptcha.internal.zzch.zzb     // Catch: java.lang.Throwable -> Lbc
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r0)     // Catch: java.lang.Throwable -> Lbc
            if (r0 == 0) goto L98
            r0 = 4
            goto L99
        L98:
            r0 = r6
        L99:
            com.google.android.recaptcha.internal.zzct r8 = new com.google.android.recaptcha.internal.zzct     // Catch: java.lang.Throwable -> Lbc
            r16 = 0
            r13 = 0
            r8.<init>(r9, r10, r11, r13, r14, r15, r16)     // Catch: java.lang.Throwable -> Lbc
            r2.zza = r4     // Catch: java.lang.Throwable -> Lbc
            r2.zzh = r7     // Catch: java.lang.Throwable -> Lbc
            r2.zzb = r7     // Catch: java.lang.Throwable -> Lbc
            r2.zzj = r7     // Catch: java.lang.Throwable -> Lbc
            r2.zzi = r7     // Catch: java.lang.Throwable -> Lbc
            r2.zzc = r7     // Catch: java.lang.Throwable -> Lbc
            r2.zzg = r6     // Catch: java.lang.Throwable -> Lbc
            java.lang.Object r0 = r9.zzj(r10, r0, r8, r2)     // Catch: java.lang.Throwable -> Lbc
            if (r0 == r3) goto Lc2
            r2 = r4
        Lb6:
            com.google.android.recaptcha.internal.zzdc r0 = (com.google.android.recaptcha.internal.zzdc) r0     // Catch: java.lang.Throwable -> L36
            r2.i(r7)
            return r0
        Lbc:
            r0 = move-exception
            r2 = r4
        Lbe:
            r2.i(r7)
            throw r0
        Lc2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcv.zzg(java.lang.String, long, com.google.android.recaptcha.internal.zzcn, com.google.android.recaptcha.internal.zzbi, com.google.android.recaptcha.internal.zzch, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
