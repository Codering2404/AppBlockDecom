package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfq implements Logger {
    zzfq() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
        Log.e("GoogleTagManager", str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        int i3 = zzdg.zza;
        if (i3 == 2) {
            return 0;
        }
        if (i3 == 3 || i3 == 4) {
            return 1;
        }
        return i3 != 5 ? 3 : 2;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
        zzdg.zzb.zzd(str);
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
        Log.w("GoogleTagManager", str);
    }
}
