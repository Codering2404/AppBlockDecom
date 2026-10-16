package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile com.google.android.gms.common.internal.zzad f72341g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Context f72343i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final zzm f72335a = new zzd(zzj.i5("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final zzm f72336b = new zze(zzj.i5("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final zzm f72337c = new zzf(zzj.i5("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final zzm f72338d = new zzg(zzj.i5("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final zzm f72339e = new zzh(zzj.i5("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final zzm f72340f = new zzi(zzj.i5("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f72342h = new Object();

    static synchronized void a(Context context) {
        if (f72343i != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f72343i = context.getApplicationContext();
        }
    }

    static void b() {
        if (f72341g != null) {
            return;
        }
        Preconditions.m(f72343i);
        synchronized (f72342h) {
            try {
                if (f72341g == null) {
                    f72341g = com.google.android.gms.common.internal.zzac.x3(DynamiteModule.e(f72343i, DynamiteModule.f72399f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static zzy c(zzw zzwVar) {
        zzy zzyVarD;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.m(f72343i);
            try {
                b();
                Preconditions.m(f72343i);
                zzp zzpVarB = zzwVar.b(f72343i);
                try {
                    zzr zzrVarM4 = zzwVar.a() ? f72341g.m4(zzpVarB) : f72341g.Q4(zzpVarB);
                    if (zzrVarM4.zza()) {
                        zzyVarD = zzy.f(zzrVarM4.N(), zzrVarM4.zzc());
                    } else {
                        String strZzb = zzrVarM4.zzb();
                        PackageManager.NameNotFoundException nameNotFoundException = zzrVarM4.M() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (strZzb == null) {
                            strZzb = "error checking package certificate";
                        }
                        zzyVarD = zzy.g(zzrVarM4.N(), zzrVarM4.M(), strZzb, nameNotFoundException);
                    }
                } catch (RemoteException e3) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                    zzyVarD = zzy.d("module call", e3);
                }
            } catch (DynamiteModule.LoadingException e4) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
                zzyVarD = zzy.d("module init: ".concat(String.valueOf(e4.getMessage())), e4);
            }
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return zzyVarD;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    static zzy d(String str, zzj zzjVar, boolean z2, boolean z3) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, zzjVar, z2, z3);
        } finally {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        }
    }

    static /* synthetic */ String e(boolean z2, String str, zzj zzjVar) {
        String str2 = (z2 || !f(str, zzjVar, true, false).f72368a) ? "not allowed" : "debug cert rejected";
        MessageDigest messageDigestB = AndroidUtilsLight.b("SHA-256");
        Preconditions.m(messageDigestB);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.a(messageDigestB.digest(zzjVar.h5())), Boolean.valueOf(z2), "12451000.false");
    }

    private static zzy f(final String str, final zzj zzjVar, final boolean z2, boolean z3) {
        try {
            b();
            Preconditions.m(f72343i);
            try {
                return f72341g.g2(new zzt(str, zzjVar, z2, z3), ObjectWrapper.i5(f72343i.getPackageManager())) ? zzy.b() : new zzx(new Callable() { // from class: com.google.android.gms.common.zzl
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Object call() {
                        return zzo.e(z2, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                return zzy.d("module call", e3);
            }
        } catch (DynamiteModule.LoadingException e4) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e4);
            return zzy.d("module init: ".concat(String.valueOf(e4.getMessage())), e4);
        }
    }
}
