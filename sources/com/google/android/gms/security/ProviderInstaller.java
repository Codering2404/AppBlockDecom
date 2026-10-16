package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ProviderInstaller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f74545a = GoogleApiAvailabilityLight.h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f74546b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f74547c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f74548d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f74549e = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProviderInstallListener {
        void a();

        void b(int i3, Intent intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098 A[Catch: all -> 0x0028, TryCatch #2 {, blocks: (B:4:0x0014, B:7:0x001b, B:14:0x0040, B:15:0x0045, B:12:0x002c, B:17:0x0047, B:28:0x0091, B:29:0x0096, B:31:0x0098, B:32:0x00a6, B:20:0x0052, B:22:0x0057, B:25:0x0081), top: B:39:0x0014, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r12) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.n(r12, r0)
            com.google.android.gms.common.GoogleApiAvailabilityLight r0 = com.google.android.gms.security.ProviderInstaller.f74545a
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.n(r12, r1)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = com.google.android.gms.security.ProviderInstaller.f74546b
            monitor-enter(r2)
            boolean r3 = com.google.android.gms.security.ProviderInstaller.f74548d     // Catch: java.lang.Throwable -> L28
            r4 = 0
            if (r3 != 0) goto L47
            java.lang.String r3 = "Failed to load providerinstaller module: "
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r5 = com.google.android.gms.dynamite.DynamiteModule.f72399f     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            java.lang.String r6 = "com.google.android.gms.providerinstaller.dynamite"
            com.google.android.gms.dynamite.DynamiteModule r5 = com.google.android.gms.dynamite.DynamiteModule.e(r12, r5, r6)     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            android.content.Context r3 = r5.b()     // Catch: java.lang.Throwable -> L28 com.google.android.gms.dynamite.DynamiteModule.LoadingException -> L2b
            goto L3e
        L28:
            r12 = move-exception
            goto La7
        L2b:
            r5 = move-exception
            java.lang.String r6 = "ProviderInstaller"
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = r3.concat(r5)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r6, r3)     // Catch: java.lang.Throwable -> L28
            r3 = r4
        L3e:
            if (r3 == 0) goto L47
            java.lang.String r0 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            c(r3, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            goto L97
        L47:
            boolean r3 = com.google.android.gms.security.ProviderInstaller.f74548d     // Catch: java.lang.Throwable -> L28
            java.lang.String r5 = "Failed to report request stats: "
            android.content.Context r6 = com.google.android.gms.common.GooglePlayServicesUtilLight.e(r12)     // Catch: java.lang.Throwable -> L28
            if (r6 != 0) goto L52
            goto L8f
        L52:
            r4 = 1
            com.google.android.gms.security.ProviderInstaller.f74548d = r4     // Catch: java.lang.Throwable -> L28
            if (r3 != 0) goto L8e
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.String r3 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.String r9 = "reportRequestStats2"
            java.lang.ClassLoader r10 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            java.lang.Class<android.content.Context> r11 = android.content.Context.class
            com.google.android.gms.internal.common.zzi r11 = com.google.android.gms.internal.common.zzi.zzb(r11, r12)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r0 = com.google.android.gms.internal.common.zzh.zza(r0)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzh r1 = com.google.android.gms.internal.common.zzh.zza(r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7 = 3
            com.google.android.gms.internal.common.zzi[] r7 = new com.google.android.gms.internal.common.zzi[r7]     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r8 = 0
            r7[r8] = r11     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r7[r4] = r0     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            r0 = 2
            r7[r0] = r1     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            com.google.android.gms.internal.common.zzj.zzb(r3, r9, r10, r7)     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L80
            goto L8e
        L80:
            r0 = move-exception
            java.lang.String r1 = "ProviderInstaller"
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L28
            java.lang.String r0 = r5.concat(r0)     // Catch: java.lang.Throwable -> L28
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L28
        L8e:
            r4 = r6
        L8f:
            if (r4 == 0) goto L98
            java.lang.String r0 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            c(r4, r12, r0)     // Catch: java.lang.Throwable -> L28
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
        L97:
            return
        L98:
            java.lang.String r12 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r12, r0)     // Catch: java.lang.Throwable -> L28
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r12 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch: java.lang.Throwable -> L28
            r0 = 8
            r12.<init>(r0)     // Catch: java.lang.Throwable -> L28
            throw r12     // Catch: java.lang.Throwable -> L28
        La7:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L28
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.a(android.content.Context):void");
    }

    private static void c(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (f74547c == null) {
                f74547c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f74547c.invoke(null, context);
        } catch (Exception e3) {
            Throwable cause = e3.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e3.toString() : cause.toString())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
