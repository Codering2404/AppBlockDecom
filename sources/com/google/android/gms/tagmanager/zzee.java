package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzee extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.RESOLUTION.toString();
    private final Context zzb;

    public zzee(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.zzb.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return zzfu.zzb(displayMetrics.widthPixels + "x" + displayMetrics.heightPixels);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
