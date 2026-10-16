package com.google.android.recaptcha.internal;

import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcb {
    private Object zza;
    private final Mutex zzb = MutexKt.b(false, 1, null);

    public zzcb(Object obj) {
        this.zza = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zza(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzby
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzby r0 = (com.google.android.recaptcha.internal.zzby) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzby r0 = new com.google.android.recaptcha.internal.zzby
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzje r1 = r0.zzf
            com.google.android.recaptcha.internal.zzcb r0 = r0.zze
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L53
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r0.zze = r5
            r2 = r6
            com.google.android.recaptcha.internal.zzje r2 = (com.google.android.recaptcha.internal.zzje) r2
            r0.zzf = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 == r1) goto L66
            r0 = r5
        L53:
            java.lang.Object r0 = r0.zza     // Catch: java.lang.Throwable -> L61
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)     // Catch: java.lang.Throwable -> L61
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)     // Catch: java.lang.Throwable -> L61
            r7.i(r4)
            return r6
        L61:
            r6 = move-exception
            r7.i(r4)
            throw r6
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcb.zza(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb(java.lang.Object[] r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzbz
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzbz r0 = (com.google.android.recaptcha.internal.zzbz) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzbz r0 = new com.google.android.recaptcha.internal.zzbz
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzje[] r1 = r0.zzf
            com.google.android.recaptcha.internal.zzcb r0 = r0.zze
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L53
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r0.zze = r5
            r2 = r6
            com.google.android.recaptcha.internal.zzje[] r2 = (com.google.android.recaptcha.internal.zzje[]) r2
            r0.zzf = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 == r1) goto L66
            r0 = r5
        L53:
            java.lang.Object r0 = r0.zza     // Catch: java.lang.Throwable -> L61
            boolean r6 = kotlin.collections.ArraysKt.contains(r6, r0)     // Catch: java.lang.Throwable -> L61
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r6)     // Catch: java.lang.Throwable -> L61
            r7.i(r4)
            return r6
        L61:
            r6 = move-exception
            r7.i(r4)
            throw r6
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcb.zzb(java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzc(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzca
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzca r0 = (com.google.android.recaptcha.internal.zzca) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzca r0 = new com.google.android.recaptcha.internal.zzca
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzje r1 = r0.zzf
            com.google.android.recaptcha.internal.zzcb r0 = r0.zze
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L53
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r0.zze = r5
            r2 = r6
            com.google.android.recaptcha.internal.zzje r2 = (com.google.android.recaptcha.internal.zzje) r2
            r0.zzf = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.f(r4, r0)
            if (r0 == r1) goto L62
            r0 = r5
        L53:
            r0.zza = r6     // Catch: java.lang.Throwable -> L5d
            kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L5d
            r7.i(r4)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L5d:
            r6 = move-exception
            r7.i(r4)
            throw r6
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcb.zzc(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
