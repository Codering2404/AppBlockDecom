package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcw implements Logger {
    private int zza = 2;
    private boolean zzb;

    zzcw() {
    }

    public final void error(Exception exc) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final int getLogLevel() {
        return this.zza;
    }

    public final void setLogLevel(int i3) {
        this.zza = i3;
        if (this.zzb) {
            return;
        }
        zzev zzevVar = zzew.zzc;
        Log.i((String) zzevVar.zzb(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzevVar.zzb()) + " DEBUG");
        this.zzb = true;
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void error(String str) {
    }

    public final void info(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void verbose(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public final void warn(String str) {
    }
}
