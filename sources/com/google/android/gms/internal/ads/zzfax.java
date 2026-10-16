package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfax implements zzfck {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;

    zzfax(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 29;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    @Override // com.google.android.gms.internal.ads.zzfck
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            r9 = this;
            android.content.pm.ApplicationInfo r0 = r9.zza
            java.lang.String r2 = r0.packageName
            android.content.pm.PackageInfo r0 = r9.zzb
            r1 = 0
            if (r0 != 0) goto Lb
            r3 = r1
            goto L11
        Lb:
            int r3 = r0.versionCode
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L11:
            if (r0 != 0) goto L15
            r4 = r1
            goto L18
        L15:
            java.lang.String r0 = r0.versionName
            r4 = r0
        L18:
            android.content.Context r0 = r9.zzc     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            com.google.android.gms.internal.ads.zzgam r5 = com.google.android.gms.ads.internal.util.zzs.f70374l     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.CharSequence r0 = r0.d(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            r5 = r0
            goto L2b
        L2a:
            r5 = r1
        L2b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 30
            if (r0 < r6) goto L77
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzol
            com.google.android.gms.internal.ads.zzbio r6 = com.google.android.gms.ads.internal.client.zzba.c()
            java.lang.Object r0 = r6.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L77
            android.content.Context r0 = r9.zzc     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            android.content.pm.InstallSourceInfo r0 = com.appsflyer.internal.k.a(r0, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            if (r0 == 0) goto L77
            java.lang.String r6 = com.appsflyer.internal.m.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L75
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            if (r7 == 0) goto L5f
            java.lang.String r7 = "No installing package name found"
            com.google.android.gms.ads.internal.util.zze.k(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            r6 = r1
        L5f:
            java.lang.String r7 = com.appsflyer.internal.l.a(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L73
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L70
            if (r0 == 0) goto L86
            java.lang.String r0 = "No initiating package name found"
            com.google.android.gms.ads.internal.util.zze.k(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L70
        L6e:
            r7 = r1
            goto L86
        L70:
            r0 = move-exception
            r1 = r7
            goto L7b
        L73:
            r0 = move-exception
            goto L7b
        L75:
            r0 = move-exception
            goto L7a
        L77:
            r6 = r1
            r7 = r6
            goto L86
        L7a:
            r6 = r1
        L7b:
            r7 = 0
            java.lang.String r7 = cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy.jKzuGgjJusVi
            com.google.android.gms.internal.ads.zzcfd r8 = com.google.android.gms.ads.internal.zzt.l()
            r8.zzg(r0, r7)
            goto L6e
        L86:
            com.google.android.gms.internal.ads.zzfay r1 = new com.google.android.gms.internal.ads.zzfay
            r1.<init>(r2, r3, r4, r5, r6, r7)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzhbw.zza(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfax.zza():com.google.common.util.concurrent.ListenableFuture");
    }
}
