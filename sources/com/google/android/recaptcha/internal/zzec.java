package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzec implements zzcn {
    private final zzdt zza;
    private final zzek zzb;
    private zzbd zzd;
    private zzsc zze;
    private final zzbi zzg;
    private CompletableDeferred zzc = CompletableDeferredKt.b(null, 1, null);
    private zzcm zzf = zzcm.zza;

    public zzec(zzdt zzdtVar, zzbi zzbiVar, zzek zzekVar, zzbo zzboVar) {
        this.zza = zzdtVar;
        this.zzg = zzbiVar;
        this.zzb = zzekVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzl(kotlin.jvm.functions.Function1 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzdv
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzdv r0 = (com.google.android.recaptcha.internal.zzdv) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdv r0 = new com.google.android.recaptcha.internal.zzdv
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            com.google.android.recaptcha.internal.zzbn r5 = r0.zzd
            kotlin.ResultKt.b(r6)
            goto L46
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            com.google.android.recaptcha.internal.zzbn r6 = new com.google.android.recaptcha.internal.zzbn
            r6.<init>()
            r0.zzd = r6
            r0.zzc = r3
            java.lang.Object r5 = r5.invoke(r0)
            if (r5 == r1) goto L54
            r5 = r6
        L46:
            r5.zzc()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r5.zza(r6)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            return r5
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzl(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0077 A[Catch: Exception -> 0x0031, TRY_ENTER, TryCatch #1 {Exception -> 0x0031, blocks: (B:13:0x002d, B:26:0x0065, B:31:0x0077, B:32:0x0080), top: B:53:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzm(long r7, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdw
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzdw r0 = (com.google.android.recaptcha.internal.zzdw) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdw r0 = new com.google.android.recaptcha.internal.zzdw
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r0 = r0.zze
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L31
            goto L65
        L31:
            r7 = move-exception
            goto L83
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            long r7 = r0.zza
            com.google.android.recaptcha.internal.zzec r2 = r0.zze
            kotlin.ResultKt.b(r9)
            goto L53
        L43:
            kotlin.ResultKt.b(r9)
            r0.zze = r6
            r0.zza = r7
            r0.zzd = r4
            java.lang.Object r9 = r6.zzn(r7, r0)
            if (r9 == r1) goto Lb9
            r2 = r6
        L53:
            com.google.android.recaptcha.internal.zzdy r9 = new com.google.android.recaptcha.internal.zzdy     // Catch: java.lang.Exception -> L81
            r9.<init>(r7, r2, r5)     // Catch: java.lang.Exception -> L81
            r0.zze = r2     // Catch: java.lang.Exception -> L81
            r0.zza = r7     // Catch: java.lang.Exception -> L81
            r0.zzd = r3     // Catch: java.lang.Exception -> L81
            java.lang.Object r9 = r2.zzl(r9, r0)     // Catch: java.lang.Exception -> L81
            if (r9 == r1) goto Lb9
            r0 = r2
        L65:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Exception -> L31
            long r1 = r9.longValue()     // Catch: java.lang.Exception -> L31
            long r7 = r7 - r1
            r1 = 500(0x1f4, double:2.47E-321)
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 < 0) goto L77
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.e(r7)
            return r7
        L77:
            com.google.android.recaptcha.internal.zzbd r7 = new com.google.android.recaptcha.internal.zzbd     // Catch: java.lang.Exception -> L31
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc     // Catch: java.lang.Exception -> L31
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar     // Catch: java.lang.Exception -> L31
            r7.<init>(r8, r9, r5)     // Catch: java.lang.Exception -> L31
            throw r7     // Catch: java.lang.Exception -> L31
        L81:
            r7 = move-exception
            r0 = r2
        L83:
            boolean r8 = r7 instanceof com.google.android.recaptcha.internal.zzbd
            if (r8 == 0) goto L8a
            r5 = r7
            com.google.android.recaptcha.internal.zzbd r5 = (com.google.android.recaptcha.internal.zzbd) r5
        L8a:
            if (r5 != 0) goto L99
            com.google.android.recaptcha.internal.zzbd r5 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r8 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r9 = com.google.android.recaptcha.internal.zzba.zzar
            java.lang.String r7 = r7.getMessage()
            r5.<init>(r8, r9, r7)
        L99:
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzci r8 = com.google.android.recaptcha.internal.zzcm.zza()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 != 0) goto Lb3
            com.google.android.recaptcha.internal.zzcm r7 = r0.zzf
            com.google.android.recaptcha.internal.zzck r8 = com.google.android.recaptcha.internal.zzcm.zzc()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r8)
            if (r7 == 0) goto Lb2
            goto Lb3
        Lb2:
            throw r5
        Lb3:
            com.google.android.recaptcha.internal.zzbd r7 = r0.zzd
            if (r7 == 0) goto Lb8
            r5 = r7
        Lb8:
            throw r5
        Lb9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zzm(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object zzn(long j3, Continuation continuation) {
        if (Intrinsics.areEqual(this.zzf, zzcm.zzb) || Intrinsics.areEqual(this.zzf, zzcm.zzc)) {
            return Unit.f139807a;
        }
        if (Intrinsics.areEqual(this.zzf, zzcm.zzd) && !zzo(this.zzd)) {
            return Unit.f139807a;
        }
        this.zzf = zzcm.zzc;
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        this.zzc = completableDeferredB;
        BuildersKt__Builders_commonKt.d(this.zzg.zza(), null, null, new zzeb(this, completableDeferredB, j3, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzo(Exception exc) {
        if (!(exc instanceof zzbd)) {
            return true;
        }
        zzbd zzbdVar = (zzbd) exc;
        return (Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zzd) || Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zze) || Intrinsics.areEqual(zzbdVar.zzb(), zzbb.zzf)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.google.android.recaptcha.internal.zzcn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zza(java.lang.String r18, com.google.android.recaptcha.RecaptchaAction r19, long r20, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzec.zza(java.lang.String, com.google.android.recaptcha.RecaptchaAction, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.android.recaptcha.internal.zzcn
    public final Object zzb(long j3, Continuation continuation) {
        Object objZzn = zzn(j3, continuation);
        return objZzn == IntrinsicsKt.f() ? objZzn : Unit.f139807a;
    }
}
