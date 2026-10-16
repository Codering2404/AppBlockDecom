package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzath;
import com.google.android.gms.internal.ads.zzcfw;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public final class zzbl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static zzath f70286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f70287b = new Object();

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:17:0x003b, B:16:0x0036, B:18:0x003d), top: B:22:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzbl(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto Ld
            android.content.Context r4 = r4.getApplicationContext()
        Ld:
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzbl.f70287b
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzath r1 = com.google.android.gms.ads.internal.util.zzbl.f70286a     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L3d
            com.google.android.gms.internal.ads.zzbiq.zza(r4)     // Catch: java.lang.Throwable -> L34
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.a()     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L36
            com.google.android.gms.internal.ads.zzbih r1 = com.google.android.gms.internal.ads.zzbiq.zzfq     // Catch: java.lang.Throwable -> L34
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L34
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L34
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L34
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L36
            com.google.android.gms.internal.ads.zzath r4 = com.google.android.gms.ads.internal.util.zzay.a(r4)     // Catch: java.lang.Throwable -> L34
            goto L3b
        L34:
            r4 = move-exception
            goto L3f
        L36:
            r1 = 0
            com.google.android.gms.internal.ads.zzath r4 = com.google.android.gms.internal.ads.zzauj.zza(r4, r1)     // Catch: java.lang.Throwable -> L34
        L3b:
            com.google.android.gms.ads.internal.util.zzbl.f70286a = r4     // Catch: java.lang.Throwable -> L34
        L3d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbl.<init>(android.content.Context):void");
    }

    public final ListenableFuture a(String str) {
        zzcfw zzcfwVar = new zzcfw();
        f70286a.zzb(new zzbk(str, null, zzcfwVar));
        return zzcfwVar;
    }

    public final ListenableFuture b(int i3, String str, Map map, byte[] bArr) {
        zzbi zzbiVar = new zzbi(null);
        zzbg zzbgVar = new zzbg(this, str, zzbiVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbh zzbhVar = new zzbh(this, i3, str, zzbiVar, zzbgVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.j()) {
            try {
                zzlVar.b(str, "GET", zzbhVar.zzm(), zzbhVar.zzn());
            } catch (zzasm e3) {
                String message = e3.getMessage();
                int i4 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f(message);
            }
        }
        f70286a.zzb(zzbhVar);
        return zzbiVar;
    }
}
