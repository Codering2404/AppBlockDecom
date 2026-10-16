package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdj implements zzfck {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzcev zzg;

    zzfdj(zzcev zzcevVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i3, boolean z2, boolean z3) {
        this.zzg = zzcevVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i3;
        this.zze = z2;
        this.zzf = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzhbo zzhboVarZzw = zzhbo.zzw(this.zzg.zza(this.zza, this.zzd));
        zzgta zzgtaVar = new zzgta() { // from class: com.google.android.gms.internal.ads.zzfdi
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((AdvertisingIdClient.Info) obj);
            }
        };
        Executor executor = this.zzc;
        return (zzhbo) zzhbw.zzg((zzhbo) zzhbw.zzi((zzhbo) zzhbw.zzk(zzhboVarZzw, zzgtaVar, executor), ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbH)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzfdh
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzd((Throwable) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 40;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.android.gms.internal.ads.zzfdk zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzgcg r0 = new com.google.android.gms.internal.ads.zzgcg
            r0.<init>()
            boolean r1 = r7.zze
            if (r1 != 0) goto L1c
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzeb
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L2f
            goto L6b
        L1c:
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzec
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L2f
            goto L6b
        L2f:
            android.content.Context r0 = r7.zza     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            com.google.android.gms.internal.ads.zzgck r1 = com.google.android.gms.internal.ads.zzgck.zzh(r0)     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.util.Objects.requireNonNull(r8)     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.lang.String r2 = r8.getId()     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.util.Objects.requireNonNull(r2)     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.lang.String r3 = r0.getPackageName()     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzeh     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.lang.Object r0 = r4.zzd(r0)     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            long r4 = r0.longValue()     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            boolean r6 = r7.zzf     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            com.google.android.gms.internal.ads.zzgcg r0 = r1.zzj(r2, r3, r4, r6)     // Catch: java.lang.IllegalArgumentException -> L5a java.io.IOException -> L5c
            goto L6b
        L5a:
            r0 = move-exception
            goto L5d
        L5c:
            r0 = move-exception
        L5d:
            java.lang.String r1 = "AdIdInfoSignalSource.getPaidV1"
            com.google.android.gms.internal.ads.zzcfd r2 = com.google.android.gms.ads.internal.zzt.l()
            r2.zzg(r0, r1)
            com.google.android.gms.internal.ads.zzgcg r0 = new com.google.android.gms.internal.ads.zzgcg
            r0.<init>()
        L6b:
            com.google.android.gms.internal.ads.zzfdk r1 = new com.google.android.gms.internal.ads.zzfdk
            r2 = 0
            r1.<init>(r8, r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdj.zzc(com.google.android.gms.ads.identifier.AdvertisingIdClient$Info):com.google.android.gms.internal.ads.zzfdk");
    }

    final /* synthetic */ zzfdk zzd(Throwable th) {
        com.google.android.gms.ads.internal.client.zzay.a();
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzfdk(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzgcg());
    }
}
