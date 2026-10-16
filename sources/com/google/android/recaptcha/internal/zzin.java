package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzin extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzja zzb;
    final /* synthetic */ String zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzin(zzja zzjaVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzjaVar;
        this.zzc = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzin(this.zzb, this.zzc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzin) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r4.zzF(r1, r3) == r0) goto L13;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) throws java.lang.Throwable {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r3.zza
            r2 = 1
            kotlin.ResultKt.b(r4)
            if (r1 == 0) goto Lf
            if (r1 == r2) goto L19
            goto L2c
        Lf:
            com.google.android.recaptcha.internal.zzja r4 = r3.zzb
            r3.zza = r2
            java.lang.Object r4 = r4.zzw(r3)
            if (r4 == r0) goto L2f
        L19:
            android.webkit.WebView r4 = (android.webkit.WebView) r4
            r4.clearCache(r2)
            com.google.android.recaptcha.internal.zzja r4 = r3.zzb
            java.lang.String r1 = r3.zzc
            r2 = 2
            r3.zza = r2
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzja.zzu(r4, r1, r3)
            if (r4 != r0) goto L2c
            goto L2f
        L2c:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzin.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
