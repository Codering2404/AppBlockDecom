package com.google.android.recaptcha.internal;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.recaptcha.RecaptchaAction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzdt {
    private final String zza;
    private final zzek zzb;
    private final zzl zzc;
    private final Lazy zzd;
    private final Lazy zze;
    private final Lazy zzf;
    private final Lazy zzg;
    private final Lazy zzh;
    private final zzbi zzi;

    public zzdt(String str, zzbi zzbiVar, zzek zzekVar, zzl zzlVar) {
        this.zza = str;
        this.zzi = zzbiVar;
        this.zzb = zzekVar;
        this.zzc = zzlVar;
        int i3 = zzav.zza;
        this.zzd = LazyKt.b(zzdm.zza);
        this.zze = LazyKt.b(zzdn.zza);
        this.zzf = LazyKt.b(zzdo.zza);
        this.zzg = LazyKt.b(zzdp.zza);
        this.zzh = LazyKt.b(zzdq.zza);
    }

    public static final /* synthetic */ zzbr zzd(zzdt zzdtVar) {
        return (zzbr) zzdtVar.zze.getValue();
    }

    public static final /* synthetic */ zzff zzg(zzdt zzdtVar) {
        return (zzff) zzdtVar.zzd.getValue();
    }

    public static final /* synthetic */ zzfj zzh(zzdt zzdtVar) {
        return (zzfj) zzdtVar.zzg.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application zzr() {
        return (Application) this.zzh.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbd zzs(Exception exc, zzbd zzbdVar) {
        return !zzx() ? new zzbd(zzbb.zzc, zzba.zzao, exc.getMessage()) : zzbdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzbf zzt() {
        return (zzbf) this.zzf.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzek zzu(String str) {
        zzek zzekVarZza = this.zzb.zza();
        zzekVarZza.zzc(str);
        return zzekVarZza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzv(com.google.android.recaptcha.internal.zzsc r10, long r11, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.google.android.recaptcha.internal.zzdj
            if (r0 == 0) goto L14
            r0 = r13
            com.google.android.recaptcha.internal.zzdj r0 = (com.google.android.recaptcha.internal.zzdj) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.zzd = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            com.google.android.recaptcha.internal.zzdj r0 = new com.google.android.recaptcha.internal.zzdj
            r0.<init>(r9, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.zzb
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.zzd
            r7 = 2
            r8 = 1
            if (r1 == 0) goto L49
            if (r1 == r8) goto L3b
            if (r1 == r7) goto L32
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L32:
            java.lang.Object r10 = r6.zza
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.b(r13)
            goto Lbe
        L3b:
            java.lang.Object r10 = r6.zza
            com.google.android.recaptcha.internal.zzdt r10 = (com.google.android.recaptcha.internal.zzdt) r10
            kotlin.ResultKt.b(r13)
            kotlin.Result r13 = (kotlin.Result) r13
            java.lang.Object r11 = r13.j()
            goto L83
        L49:
            kotlin.ResultKt.b(r13)
            java.lang.String r13 = r10.zzO()
            zzy(r13)
            java.util.List r13 = r9.zzw()
            java.util.Iterator r13 = r13.iterator()
        L5b:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L71
            java.lang.Object r1 = r13.next()
            com.google.android.recaptcha.internal.zze r1 = (com.google.android.recaptcha.internal.zze) r1
            com.google.android.recaptcha.internal.zzl r2 = r9.zzc
            com.google.android.recaptcha.internal.zze[] r1 = new com.google.android.recaptcha.internal.zze[]{r1}
            r2.zzf(r1)
            goto L5b
        L71:
            com.google.android.recaptcha.internal.zzl r1 = r9.zzc
            com.google.android.recaptcha.internal.zzek r5 = r9.zzb
            r6.zza = r9
            r6.zzd = r8
            r4 = r10
            r2 = r11
            java.lang.Object r11 = r1.zzc(r2, r4, r5, r6)
            if (r11 != r0) goto L82
            goto Lbc
        L82:
            r10 = r9
        L83:
            java.lang.Throwable r11 = kotlin.Result.e(r11)
            if (r11 != 0) goto L8c
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L8c:
            com.google.android.recaptcha.internal.zzbi r12 = r10.zzi
            kotlinx.coroutines.CoroutineScope r12 = r12.zzd()
            kotlin.coroutines.CoroutineContext r12 = r12.getCoroutineContext()
            r13 = 0
            kotlinx.coroutines.JobKt.i(r12, r13, r8, r13)
            com.google.android.recaptcha.internal.zzbi r10 = r10.zzi
            kotlinx.coroutines.CoroutineScope r10 = r10.zzd()
            kotlin.coroutines.CoroutineContext r10 = r10.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.m(r10)
            kotlin.sequences.Sequence r10 = r10.getChildren()
            java.util.List r10 = kotlin.sequences.SequencesKt.S(r10)
            java.util.Collection r10 = (java.util.Collection) r10
            r6.zza = r11
            r6.zzd = r7
            java.lang.Object r10 = kotlinx.coroutines.AwaitKt.c(r10, r6)
            if (r10 != r0) goto Lbd
        Lbc:
            return r0
        Lbd:
            r10 = r11
        Lbe:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzv(com.google.android.recaptcha.internal.zzsc, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List zzw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzv(zzr(), this.zzb.zza(), this.zzi, null, 8, null));
        arrayList.add(new zzja(this.zzb, this.zzi));
        return CollectionsKt.toList(arrayList);
    }

    private final boolean zzx() {
        NetworkCapabilities networkCapabilities;
        int i3 = zzav.zza;
        try {
            Object systemService = zzr().getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
                return false;
            }
            return networkCapabilities.hasCapability(16);
        } catch (Exception unused) {
            return false;
        }
    }

    private static final void zzy(String str) throws zzbd {
        try {
            zzrv zzrvVarZzj = zzrv.zzj(zzbt.zza(str));
            int i3 = zzav.zza;
            ((zzfu) LazyKt.b(zzde.zza).getValue()).zza(zzrvVarZzj);
        } catch (Exception e3) {
            throw new zzbd(zzbb.zzl, zzba.zzan, e3.getMessage());
        }
    }

    public final zzsp zzi(RecaptchaAction recaptchaAction, zzsi zzsiVar, zzsc zzscVar) {
        zzso zzsoVarZzf = zzsp.zzf();
        zzsoVarZzf.zzs(this.zza);
        zzsoVarZzf.zze(recaptchaAction.getAction());
        zzsoVarZzf.zzf(zzscVar.zzN());
        zzsoVarZzf.zzq(zzscVar.zzM());
        zzsoVarZzf.zzr(zzsiVar);
        return (zzsp) zzsoVarZzf.zzk();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzl(java.lang.String r6, long r7, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.google.android.recaptcha.internal.zzdd
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.recaptcha.internal.zzdd r0 = (com.google.android.recaptcha.internal.zzdd) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdd r0 = new com.google.android.recaptcha.internal.zzdd
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            com.google.android.recaptcha.internal.zzen r6 = r0.zzd
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d com.google.android.recaptcha.internal.zzbd -> L2f
            goto L55
        L2b:
            r7 = move-exception
            goto L66
        L2d:
            r7 = move-exception
            goto L78
        L2f:
            r7 = move-exception
            goto L8a
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.b(r9)
            com.google.android.recaptcha.internal.zzek r9 = r5.zzu(r6)
            r2 = 27
            com.google.android.recaptcha.internal.zzen r9 = r9.zzf(r2)
            com.google.android.recaptcha.internal.zzl r2 = r5.zzc     // Catch: java.lang.Exception -> L5c kotlinx.coroutines.TimeoutCancellationException -> L5f com.google.android.recaptcha.internal.zzbd -> L62
            r0.zzd = r9     // Catch: java.lang.Exception -> L5c kotlinx.coroutines.TimeoutCancellationException -> L5f com.google.android.recaptcha.internal.zzbd -> L62
            r0.zzc = r3     // Catch: java.lang.Exception -> L5c kotlinx.coroutines.TimeoutCancellationException -> L5f com.google.android.recaptcha.internal.zzbd -> L62
            java.lang.Object r6 = r2.zzb(r6, r7, r0)     // Catch: java.lang.Exception -> L5c kotlinx.coroutines.TimeoutCancellationException -> L5f com.google.android.recaptcha.internal.zzbd -> L62
            if (r6 == r1) goto L5b
            r4 = r9
            r9 = r6
            r6 = r4
        L55:
            com.google.android.recaptcha.internal.zzsi r9 = (com.google.android.recaptcha.internal.zzsi) r9     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d com.google.android.recaptcha.internal.zzbd -> L2f
            r6.zza()     // Catch: java.lang.Exception -> L2b kotlinx.coroutines.TimeoutCancellationException -> L2d com.google.android.recaptcha.internal.zzbd -> L2f
            return r9
        L5b:
            return r1
        L5c:
            r6 = move-exception
            r7 = r6
            goto L65
        L5f:
            r6 = move-exception
            r7 = r6
            goto L77
        L62:
            r6 = move-exception
            r7 = r6
            goto L89
        L65:
            r6 = r9
        L66:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzaa
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L77:
            r6 = r9
        L78:
            com.google.android.recaptcha.internal.zzbd r8 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r9 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r0 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r9, r0, r7)
            r6.zzb(r8)
            throw r8
        L89:
            r6 = r9
        L8a:
            r6.zzb(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzl(java.lang.String, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zzm(zzsp zzspVar, String str, long j3, Continuation continuation) {
        return BuildersKt.g(this.zzi.zza().getCoroutineContext(), new zzdg(this, str, j3, zzspVar, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzn(com.google.android.recaptcha.internal.zzsc r11, long r12, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.google.android.recaptcha.internal.zzdk
            if (r0 == 0) goto L13
            r0 = r14
            com.google.android.recaptcha.internal.zzdk r0 = (com.google.android.recaptcha.internal.zzdk) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdk r0 = new com.google.android.recaptcha.internal.zzdk
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            kotlin.ResultKt.b(r14)     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2c com.google.android.recaptcha.internal.zzbd -> L2f
            goto L4f
        L29:
            r0 = move-exception
            r11 = r0
            goto L52
        L2c:
            r0 = move-exception
            r11 = r0
            goto L60
        L2f:
            r0 = move-exception
            r11 = r0
            goto L6e
        L32:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3a:
            kotlin.ResultKt.b(r14)
            com.google.android.recaptcha.internal.zzdl r4 = new com.google.android.recaptcha.internal.zzdl     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2c com.google.android.recaptcha.internal.zzbd -> L2f
            r9 = 0
            r5 = r10
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r9)     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2c com.google.android.recaptcha.internal.zzbd -> L2f
            r0.zzc = r3     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2c com.google.android.recaptcha.internal.zzbd -> L2f
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.c(r7, r4, r0)     // Catch: java.lang.Exception -> L29 kotlinx.coroutines.TimeoutCancellationException -> L2c com.google.android.recaptcha.internal.zzbd -> L2f
            if (r11 != r1) goto L4f
            return r1
        L4f:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        L52:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzap
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L60:
            com.google.android.recaptcha.internal.zzbd r12 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r13 = com.google.android.recaptcha.internal.zzbb.zzb
            com.google.android.recaptcha.internal.zzba r14 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r11 = r11.getMessage()
            r12.<init>(r13, r14, r11)
            throw r12
        L6e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzn(com.google.android.recaptcha.internal.zzsc, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzo(long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.recaptcha.internal.zzdr
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.recaptcha.internal.zzdr r0 = (com.google.android.recaptcha.internal.zzdr) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdr r0 = new com.google.android.recaptcha.internal.zzdr
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            com.google.android.recaptcha.internal.zzen r6 = r0.zze
            com.google.android.recaptcha.internal.zzdt r7 = r0.zzd
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Exception -> L2d kotlinx.coroutines.TimeoutCancellationException -> L2f com.google.android.recaptcha.internal.zzbd -> L31
            goto L5d
        L2d:
            r8 = move-exception
            goto L6b
        L2f:
            r8 = move-exception
            goto L84
        L31:
            r8 = move-exception
            goto L9d
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.b(r8)
            com.google.android.recaptcha.internal.zzek r8 = r5.zzb
            r2 = 22
            com.google.android.recaptcha.internal.zzen r8 = r8.zzf(r2)
            com.google.android.recaptcha.internal.zzds r2 = new com.google.android.recaptcha.internal.zzds     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            r4 = 0
            r2.<init>(r5, r8, r4)     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            r0.zzd = r5     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            r0.zze = r8     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            r0.zzc = r3     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.c(r6, r2, r0)     // Catch: java.lang.Exception -> L61 kotlinx.coroutines.TimeoutCancellationException -> L63 com.google.android.recaptcha.internal.zzbd -> L65
            if (r6 == r1) goto L60
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L5d:
            com.google.android.recaptcha.internal.zzsc r8 = (com.google.android.recaptcha.internal.zzsc) r8     // Catch: java.lang.Exception -> L2d kotlinx.coroutines.TimeoutCancellationException -> L2f com.google.android.recaptcha.internal.zzbd -> L31
            return r8
        L60:
            return r1
        L61:
            r6 = move-exception
            goto L67
        L63:
            r6 = move-exception
            goto L80
        L65:
            r6 = move-exception
            goto L99
        L67:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L6b:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r2 = com.google.android.recaptcha.internal.zzba.zzaw
            java.lang.String r3 = r8.getMessage()
            r0.<init>(r1, r2, r3)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r8, r0)
            r6.zzb(r7)
            throw r7
        L80:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L84:
            com.google.android.recaptcha.internal.zzbd r0 = new com.google.android.recaptcha.internal.zzbd
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            com.google.android.recaptcha.internal.zzba r2 = com.google.android.recaptcha.internal.zzba.zzb
            java.lang.String r3 = r8.getMessage()
            r0.<init>(r1, r2, r3)
            com.google.android.recaptcha.internal.zzbd r7 = r7.zzs(r8, r0)
            r6.zzb(r7)
            throw r7
        L99:
            r7 = r8
            r8 = r6
            r6 = r7
            r7 = r5
        L9d:
            com.google.android.recaptcha.internal.zzbb r0 = r8.zzb()
            com.google.android.recaptcha.internal.zzbb r1 = com.google.android.recaptcha.internal.zzbb.zzc
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto Lad
            com.google.android.recaptcha.internal.zzbd r8 = r7.zzs(r8, r8)
        Lad:
            r6.zzb(r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdt.zzo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void zzq(String str, zzsr zzsrVar) {
        zzen zzenVarZzf = zzu(str).zzf(29);
        try {
            List<zzst> listZzk = zzsrVar.zzk();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listZzk, 10)), 16));
            for (zzst zzstVar : listZzk) {
                Pair pairA = TuplesKt.a(zzstVar.zzg(), zzstVar.zzi());
                linkedHashMap.put(pairA.e(), pairA.f());
            }
            zzt().zzb(linkedHashMap);
            this.zzc.zzg(zzsrVar);
            zzenVarZzf.zza();
        } catch (zzbd e3) {
            zzenVarZzf.zzb(e3);
        } catch (Exception e4) {
            zzenVarZzf.zzb(new zzbd(zzbb.zzb, zzba.zzas, e4.getMessage()));
        }
    }
}
