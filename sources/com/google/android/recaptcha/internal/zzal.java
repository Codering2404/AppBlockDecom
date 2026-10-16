package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzal extends SuspendLambda implements Function2 {
    long zza;
    boolean zzb;
    int zzc;
    final /* synthetic */ zzan zzd;
    final /* synthetic */ zzen zze;
    final /* synthetic */ Ref.ObjectRef zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzal(zzan zzanVar, zzen zzenVar, Ref.ObjectRef objectRef, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzanVar;
        this.zze = zzenVar;
        this.zzf = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzal(this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzal) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r8 != r0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007c, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r4, r7) != r0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0081, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x001c, TRY_ENTER, TryCatch #0 {Exception -> 0x001c, blocks: (B:14:0x0026, B:16:0x0032, B:8:0x0018), top: B:41:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:13:0x0024). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x007c -> B:6:0x0013). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.zzc
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L16
            boolean r1 = r7.zzb
            long r4 = r7.zza
            kotlin.ResultKt.b(r8)
        L13:
            r8 = r1
            goto L7f
        L16:
            long r4 = r7.zza
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Exception -> L1c
            goto L32
        L1c:
            r8 = move-exception
            goto L4b
        L1e:
            kotlin.ResultKt.b(r8)
            r4 = 1000(0x3e8, double:4.94E-321)
            r8 = r3
        L24:
            if (r8 == 0) goto L83
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch: java.lang.Exception -> L1c
            r7.zza = r4     // Catch: java.lang.Exception -> L1c
            r7.zzc = r3     // Catch: java.lang.Exception -> L1c
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzan.zza(r8, r7)     // Catch: java.lang.Exception -> L1c
            if (r8 == r0) goto L81
        L32:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r8 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r8     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan r1 = r7.zzd     // Catch: java.lang.Exception -> L1c
            kotlinx.coroutines.CompletableDeferred r1 = r1.zzf()     // Catch: java.lang.Exception -> L1c
            r1.J(r8)     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan r8 = r7.zzd     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzao r1 = com.google.android.recaptcha.internal.zzao.zzc     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzan.zzh(r8, r1)     // Catch: java.lang.Exception -> L1c
            com.google.android.recaptcha.internal.zzen r8 = r7.zze     // Catch: java.lang.Exception -> L1c
            r8.zza()     // Catch: java.lang.Exception -> L1c
            r8 = r2
            goto L24
        L4b:
            kotlin.jvm.internal.Ref$ObjectRef r1 = r7.zzf
            r1.f140144a = r8
            boolean r1 = r8 instanceof com.google.android.play.core.integrity.StandardIntegrityException
            if (r1 == 0) goto L6c
            r1 = r8
            com.google.android.play.core.integrity.StandardIntegrityException r1 = (com.google.android.play.core.integrity.StandardIntegrityException) r1
            int r1 = r1.getErrorCode()
            r6 = -100
            if (r1 == r6) goto L6e
            r6 = -18
            if (r1 == r6) goto L6e
            r6 = -12
            if (r1 == r6) goto L6e
            r6 = -8
            if (r1 == r6) goto L6e
            r6 = -3
            if (r1 == r6) goto L6e
        L6c:
            r1 = r2
            goto L6f
        L6e:
            r1 = r3
        L6f:
            if (r1 == 0) goto L82
            r7.zza = r4
            r7.zzb = r3
            r8 = 2
            r7.zzc = r8
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r4, r7)
            if (r8 == r0) goto L81
            goto L13
        L7f:
            long r4 = r4 + r4
            goto L24
        L81:
            return r0
        L82:
            throw r8
        L83:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzal.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
