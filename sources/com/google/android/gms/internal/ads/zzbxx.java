package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbxx extends zzbyg {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbxx(zzcku zzckuVar, Map map) {
        super(zzckuVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzckuVar.zzj();
        this.zzc = zzd("description");
        this.zzf = zzd("summary");
        this.zzd = zze("start_ticks");
        this.zze = zze("end_ticks");
        this.zzg = zzd("location");
    }

    private final String zzd(String str) {
        Map map = this.zza;
        return TextUtils.isEmpty((CharSequence) map.get(str)) ? "" : (String) map.get(str);
    }

    private final long zze(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.g();
        if (!new zzbhx(context).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.g();
        AlertDialog.Builder builderN = com.google.android.gms.ads.internal.util.zzs.n(context);
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        builderN.setTitle(resourcesZzf != null ? resourcesZzf.getString(R.string.f69763r) : "Create calendar event");
        builderN.setMessage(resourcesZzf != null ? resourcesZzf.getString(R.string.f69764s) : "Allow Ad to create a calendar event?");
        builderN.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f69761p) : "Accept", new zzbxv(this));
        builderN.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R.string.f69762q) : "Decline", new zzbxw(this));
        builderN.create().show();
    }

    final Intent zzb() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.zzc);
        data.putExtra("eventLocation", this.zzg);
        data.putExtra("description", this.zzf);
        long j3 = this.zzd;
        if (j3 > -1) {
            data.putExtra("beginTime", j3);
        }
        long j4 = this.zze;
        if (j4 > -1) {
            data.putExtra(SDKConstants.PARAM_END_TIME, j4);
        }
        data.setFlags(268435456);
        return data;
    }

    final /* synthetic */ Context zzc() {
        return this.zzb;
    }
}
