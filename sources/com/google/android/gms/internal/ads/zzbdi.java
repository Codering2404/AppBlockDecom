package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbdi {
    public static String zza(Context context, String str, List list, Executor executor) throws ExecutionException, InterruptedException, PackageManager.NameNotFoundException, CertificateEncodingException {
        if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
            return null;
        }
        final zzhcp zzhcpVarZze = zzhcp.zze();
        context.getPackageManager().requestChecksums(str, false, 8, list, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzbdh
            public final /* synthetic */ void onChecksumsReady(List list2) {
                zzhcp zzhcpVar = zzhcpVarZze;
                if (list2 == null) {
                    zzhcpVar.zza((Object) null);
                    return;
                }
                try {
                    int size = list2.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ApkChecksum apkChecksumA = k.a(list2.get(i3));
                        if (apkChecksumA.getType() == 8) {
                            zzhcpVar.zza(zzbbv.zza(apkChecksumA.getValue()));
                            return;
                        }
                    }
                    zzhcpVar.zza((Object) null);
                } catch (Throwable unused) {
                    zzhcpVar.zza((Object) null);
                }
            }
        });
        return (String) zzhcpVarZze.get();
    }
}
