package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GoogleSignatureVerifier {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static GoogleSignatureVerifier f71464c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile String f71466b;

    public GoogleSignatureVerifier(Context context) {
        this.f71465a = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier a(Context context) {
        Preconditions.m(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (f71464c == null) {
                    zzo.a(context);
                    f71464c = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f71464c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0099, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final boolean d(android.content.pm.PackageInfo r10, boolean r11) {
        /*
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            r1 = 1
            if (r11 == 0) goto L28
            java.lang.String r2 = r10.packageName
            java.lang.String r3 = "com.android.vending"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L1b
            java.lang.String r2 = r10.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L28
        L1b:
            android.content.pm.ApplicationInfo r11 = r10.applicationInfo
            if (r11 != 0) goto L21
        L1f:
            r11 = r0
            goto L28
        L21:
            int r11 = r11.flags
            r11 = r11 & 129(0x81, float:1.81E-43)
            if (r11 == 0) goto L1f
            r11 = r1
        L28:
            if (r11 == 0) goto L2d
            com.google.android.gms.internal.common.zzah r2 = com.google.android.gms.common.zzn.f72334c     // Catch: java.lang.IllegalArgumentException -> La4
            goto L2f
        L2d:
            com.google.android.gms.internal.common.zzah r2 = com.google.android.gms.common.zzn.f72333b     // Catch: java.lang.IllegalArgumentException -> La4
        L2f:
            int r3 = com.google.android.gms.common.util.AndroidUtilsLight.f72267b     // Catch: java.lang.IllegalArgumentException -> La4
            com.google.android.gms.internal.common.zzr.zza(r1)     // Catch: java.lang.IllegalArgumentException -> La4
            android.content.pm.SigningInfo r3 = r10.signingInfo     // Catch: java.lang.IllegalArgumentException -> La4
            if (r3 == 0) goto L65
            boolean r4 = r3.hasMultipleSigners()     // Catch: java.lang.IllegalArgumentException -> La4
            if (r4 != 0) goto L65
            android.content.pm.Signature[] r4 = r3.getSigningCertificateHistory()     // Catch: java.lang.IllegalArgumentException -> La4
            if (r4 != 0) goto L45
            goto L65
        L45:
            int r4 = com.google.android.gms.internal.common.zzah.zzd     // Catch: java.lang.IllegalArgumentException -> La4
            com.google.android.gms.internal.common.zzad r4 = new com.google.android.gms.internal.common.zzad     // Catch: java.lang.IllegalArgumentException -> La4
            r4.<init>()     // Catch: java.lang.IllegalArgumentException -> La4
            android.content.pm.Signature[] r3 = r3.getSigningCertificateHistory()     // Catch: java.lang.IllegalArgumentException -> La4
            int r5 = r3.length     // Catch: java.lang.IllegalArgumentException -> La4
            r6 = r0
        L52:
            if (r6 >= r5) goto L60
            r7 = r3[r6]     // Catch: java.lang.IllegalArgumentException -> La4
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.IllegalArgumentException -> La4
            r4.zzb(r7)     // Catch: java.lang.IllegalArgumentException -> La4
            int r6 = r6 + 1
            goto L52
        L60:
            com.google.android.gms.internal.common.zzah r3 = r4.zzd()     // Catch: java.lang.IllegalArgumentException -> La4
            goto L69
        L65:
            com.google.android.gms.internal.common.zzah r3 = com.google.android.gms.internal.common.zzah.zzj()     // Catch: java.lang.IllegalArgumentException -> La4
        L69:
            boolean r4 = r3.isEmpty()     // Catch: java.lang.IllegalArgumentException -> La4
            if (r4 != 0) goto L9c
            com.google.android.gms.internal.common.zzah r3 = r3.zzh()     // Catch: java.lang.IllegalArgumentException -> La4
            int r4 = r3.size()     // Catch: java.lang.IllegalArgumentException -> La4
            r5 = r0
        L78:
            if (r5 >= r4) goto L9b
            java.lang.Object r6 = r3.get(r5)     // Catch: java.lang.IllegalArgumentException -> La4
            byte[] r6 = (byte[]) r6     // Catch: java.lang.IllegalArgumentException -> La4
            com.google.android.gms.internal.common.zzal r7 = r2.listIterator(r0)     // Catch: java.lang.IllegalArgumentException -> La4
        L84:
            boolean r8 = r7.hasNext()     // Catch: java.lang.IllegalArgumentException -> La4
            int r9 = r5 + 1
            if (r8 == 0) goto L99
            java.lang.Object r8 = r7.next()     // Catch: java.lang.IllegalArgumentException -> La4
            byte[] r8 = (byte[]) r8     // Catch: java.lang.IllegalArgumentException -> La4
            boolean r8 = java.util.Arrays.equals(r6, r8)     // Catch: java.lang.IllegalArgumentException -> La4
            if (r8 == 0) goto L84
            return r1
        L99:
            r5 = r9
            goto L78
        L9b:
            return r0
        L9c:
            java.lang.String r2 = "Unable to obtain package certificate history."
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch: java.lang.IllegalArgumentException -> La4
            r3.<init>(r2)     // Catch: java.lang.IllegalArgumentException -> La4
            throw r3     // Catch: java.lang.IllegalArgumentException -> La4
        La4:
            java.lang.String r2 = "GoogleSignatureVerifier"
            java.lang.String r3 = "package info is not set correctly"
            android.util.Log.i(r2, r3)
            if (r11 == 0) goto Lb4
            com.google.android.gms.common.zzj[] r11 = com.google.android.gms.common.zzn.f72332a
            com.google.android.gms.common.zzj r10 = f(r10, r11)
            goto Lc0
        Lb4:
            com.google.android.gms.common.zzj[] r11 = com.google.android.gms.common.zzn.f72332a
            r11 = r11[r0]
            com.google.android.gms.common.zzj[] r11 = new com.google.android.gms.common.zzj[]{r11}
            com.google.android.gms.common.zzj r10 = f(r10, r11)
        Lc0:
            if (r10 == 0) goto Lc3
            return r1
        Lc3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.d(android.content.pm.PackageInfo, boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.os.StrictMode$ThreadPolicy] */
    /* JADX WARN: Type inference failed for: r8v9, types: [android.content.pm.PackageInfo] */
    private final zzy e(String str, boolean z2, boolean z3) {
        zzy zzyVarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return zzy.c("null pkg");
        }
        if (str.equals(this.f71466b)) {
            return zzy.b();
        }
        zzm zzmVar = zzo.f72335a;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzo.b();
            } finally {
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
        }
        if (zzo.f72341g.zzg()) {
            zzv zzvVar = new zzv(null);
            zzvVar.a(str);
            zzvVar.b(GooglePlayServicesUtilLight.g(this.f71465a));
            zzvVar.c(true);
            zzyVarC = zzo.c(zzvVar.d());
        } else {
            try {
                threadPolicyAllowThreadDiskReads = this.f71465a.getPackageManager().getPackageInfo(str, 134217792);
                boolean zG = GooglePlayServicesUtilLight.g(this.f71465a);
                if (threadPolicyAllowThreadDiskReads == 0) {
                    zzyVarC = zzy.c("null pkg");
                } else {
                    Signature[] signatureArr = ((PackageInfo) threadPolicyAllowThreadDiskReads).signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        zzyVarC = zzy.c("single cert required");
                    } else {
                        zzk zzkVar = new zzk(((PackageInfo) threadPolicyAllowThreadDiskReads).signatures[0].toByteArray());
                        String str2 = ((PackageInfo) threadPolicyAllowThreadDiskReads).packageName;
                        zzy zzyVarD = zzo.d(str2, zzkVar, zG, false);
                        zzyVarC = (!zzyVarD.f72368a || (applicationInfo = ((PackageInfo) threadPolicyAllowThreadDiskReads).applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzo.d(str2, zzkVar, false, true).f72368a) ? zzyVarD : zzy.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e4) {
                return zzy.d("no pkg ".concat(str), e4);
            }
        }
        if (zzyVarC.f72368a) {
            this.f71466b = str;
        }
        return zzyVarC;
    }

    private static zzj f(PackageInfo packageInfo, zzj... zzjVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzkVar = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i3 = 0; i3 < zzjVarArr.length; i3++) {
                if (zzjVarArr[i3].equals(zzkVar)) {
                    return zzjVarArr[i3];
                }
            }
        }
        return null;
    }

    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (d(packageInfo, false)) {
            return true;
        }
        if (d(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.g(this.f71465a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean c(int i3) {
        zzy zzyVarC;
        int length;
        String[] packagesForUid = this.f71465a.getPackageManager().getPackagesForUid(i3);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzyVarC = null;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    Preconditions.m(zzyVarC);
                    break;
                }
                zzyVarC = e(packagesForUid[i4], false, false);
                if (zzyVarC.f72368a) {
                    break;
                }
                i4++;
            }
        } else {
            zzyVarC = zzy.c("no pkgs");
        }
        zzyVarC.e();
        return zzyVarC.f72368a;
    }
}
