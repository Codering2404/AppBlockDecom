package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfcv implements zzfck {
    private final zzhcg zza;
    private final Context zzb;
    private final zzeeb zzc;
    private final String zzd;

    zzfcv(zzhcg zzhcgVar, Context context, zzeeb zzeebVar, String str) {
        this.zza = zzhcgVar;
        this.zzb = context;
        this.zzc = zzeebVar;
        this.zzd = str;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfcu
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 38;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0131 A[PHI: r1
      0x0131: PHI (r1v17 java.lang.String) = (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v7 java.lang.String), (r1v8 java.lang.String) binds: [B:34:0x012f, B:37:0x014d, B:38:0x014f, B:77:0x0131] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ com.google.android.gms.internal.ads.zzfct zzc() {
        /*
            Method dump skipped, instruction units count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfcv.zzc():com.google.android.gms.internal.ads.zzfct");
    }
}
