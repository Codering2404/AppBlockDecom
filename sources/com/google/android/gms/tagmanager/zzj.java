package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzj extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.APP_NAME.toString();
    private final Context zzb;

    public zzj(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        try {
            PackageManager packageManager = this.zzb.getPackageManager();
            return zzfu.zzb(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.zzb.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e3) {
            Log.e("GoogleTagManager", "App name is not found.", e3);
            return zzfu.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
