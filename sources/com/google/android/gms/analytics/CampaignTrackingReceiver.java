package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzcv;
import com.google.android.gms.internal.gtm.zzfd;
import com.google.android.gms.internal.gtm.zzfu;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Boolean zza;

    public static boolean zzb(Context context) {
        Preconditions.m(context);
        Boolean bool = zza;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zZzi = zzfu.zzi(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        zza = Boolean.valueOf(zZzi);
        return zZzi;
    }

    protected void zza(Context context, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzbx zzbxVarZzg = zzbx.zzg(context);
        zzfd zzfdVarZzm = zzbxVarZzg.zzm();
        if (intent == null) {
            zzfdVarZzm.zzQ("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzfdVarZzm.zzO("CampaignTrackingReceiver received", action);
        if (MrGIhy.fgcwckklYZnhoKp.equals(action) && !TextUtils.isEmpty(stringExtra)) {
            zza(context, stringExtra);
            zzbxVarZzg.zzj();
            zzbxVarZzg.zzj();
            int iZzf = zzcv.zzf();
            if (stringExtra.length() > iZzf) {
                zzfdVarZzm.zzS("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(iZzf));
                stringExtra = stringExtra.substring(0, iZzf);
            }
            zzbxVarZzg.zzf().zzf(stringExtra, new zzc(this, goAsync()));
            return;
        }
        zzfdVarZzm.zzQ("CampaignTrackingReceiver received unexpected intent without referrer extra");
    }
}
