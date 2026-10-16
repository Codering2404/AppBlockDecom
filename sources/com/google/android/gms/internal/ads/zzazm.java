package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazm {
    private final ListenableFuture zza;
    private final zzbas zzb;
    private final zzaxf zzc;

    public zzazm(final Context context, Executor executor, zzaxf zzaxfVar, zzbas zzbasVar) {
        this.zzb = zzbasVar;
        this.zzc = zzaxfVar;
        this.zza = zzhbw.zzd(new Callable() { // from class: com.google.android.gms.internal.ads.zzazl
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzb(context);
            }
        }, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzb(android.content.Context r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazm.zzb(android.content.Context):java.lang.String");
    }

    private static String zzd(Context context) {
        File file = new File(context.getPackageResourcePath());
        if (!file.exists() || !file.canRead()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[16384];
                MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
                for (int i3 = fileInputStream.read(bArr); i3 != -1; i3 = fileInputStream.read(bArr)) {
                    messageDigest.update(bArr, 0, i3);
                }
                zzgzh zzgzhVarZzi = zzgzh.zzn().zzi();
                byte[] bArrDigest = messageDigest.digest();
                String strZzj = zzgzhVarZzi.zzj(bArrDigest, 0, bArrDigest.length);
                fileInputStream.close();
                return strZzj;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | UnsupportedOperationException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public final ListenableFuture zza() {
        return this.zza;
    }
}
