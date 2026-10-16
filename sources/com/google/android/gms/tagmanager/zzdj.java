package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdj extends BroadcastReceiver {
    static final String zza = "com.google.android.gms.tagmanager.zzdj";
    private final zzex zzb;

    zzdj(zzex zzexVar) {
        this.zzb = zzexVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (!"com.google.analytics.RADIO_POWERED".equals(action) || intent.hasExtra(zza)) {
                return;
            }
            this.zzb.zzb();
            return;
        }
        Bundle extras = intent.getExtras();
        Boolean boolValueOf = Boolean.FALSE;
        if (extras != null) {
            boolValueOf = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
        }
        this.zzb.zzc(!boolValueOf.booleanValue());
    }
}
