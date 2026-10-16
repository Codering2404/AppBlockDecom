package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbk;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbz;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfu;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f70923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f70924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f70925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f70926d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f70927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f70928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f70929h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Tracker f70930i;

    zzu(Tracker tracker, Map map, boolean z2, String str, long j3, boolean z3, boolean z4, String str2) {
        this.f70930i = tracker;
        this.f70923a = map;
        this.f70924b = z2;
        this.f70925c = str;
        this.f70926d = j3;
        this.f70927f = z3;
        this.f70928g = z4;
        this.f70929h = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        double d3;
        if (this.f70930i.f70882f.zzf()) {
            this.f70923a.put("sc", "start");
        }
        Map map = this.f70923a;
        GoogleAnalytics googleAnalyticsZzp = this.f70930i.zzp();
        Preconditions.l("getClientId can not be called from the main thread");
        String strZzb = googleAnalyticsZzp.e().zzi().zzb();
        if (strZzb != null && TextUtils.isEmpty((CharSequence) map.get("cid"))) {
            map.put("cid", strZzb);
        }
        String str = (String) this.f70923a.get("sf");
        if (str != null) {
            try {
                d3 = Double.parseDouble(str);
            } catch (NumberFormatException unused) {
                d3 = 100.0d;
            }
            if (zzfu.zzj(d3, (String) this.f70923a.get("cid"))) {
                this.f70930i.zzF("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d3));
                return;
            }
        }
        Tracker tracker = this.f70930i;
        boolean z2 = this.f70924b;
        zzbk zzbkVarZzr = tracker.zzr();
        if (z2) {
            Map map2 = this.f70923a;
            boolean zZzb = zzbkVarZzr.zzb();
            if (!map2.containsKey("ate")) {
                map2.put("ate", true != zZzb ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
            }
            zzfu.zzg(this.f70923a, "adid", zzbkVarZzr.zza());
        } else {
            this.f70923a.remove("ate");
            this.f70923a.remove("adid");
        }
        zzax zzaxVarZza = this.f70930i.zzu().zza();
        zzfu.zzg(this.f70923a, "an", zzaxVarZza.zzf());
        zzfu.zzg(this.f70923a, "av", zzaxVarZza.zzg());
        zzfu.zzg(this.f70923a, "aid", zzaxVarZza.zzd());
        zzfu.zzg(this.f70923a, "aiid", zzaxVarZza.zze());
        this.f70923a.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        this.f70923a.put("_v", zzbv.zzb);
        zzfu.zzg(this.f70923a, "ul", this.f70930i.zzx().zza().zzd());
        zzfu.zzg(this.f70923a, "sr", this.f70930i.zzx().zzb());
        if (!this.f70925c.equals("transaction") && !this.f70925c.equals("item") && !this.f70930i.f70881d.zza()) {
            this.f70930i.zzz().zzc(this.f70923a, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long jZza = zzfu.zza((String) this.f70923a.get("ht"));
        if (jZza == 0) {
            jZza = this.f70926d;
        }
        long j3 = jZza;
        if (this.f70927f) {
            this.f70930i.zzz().zzM("Dry run enabled. Would have sent hit", new zzez(this.f70930i, this.f70923a, j3, this.f70928g));
            return;
        }
        String str2 = (String) this.f70923a.get("cid");
        HashMap map3 = new HashMap();
        zzfu.zzh(map3, "uid", this.f70923a);
        zzfu.zzh(map3, "an", this.f70923a);
        zzfu.zzh(map3, "aid", this.f70923a);
        zzfu.zzh(map3, "av", this.f70923a);
        zzfu.zzh(map3, "aiid", this.f70923a);
        Preconditions.m(str2);
        this.f70923a.put("_s", String.valueOf(this.f70930i.zzs().zza(new zzbz(0L, str2, this.f70929h, !TextUtils.isEmpty((CharSequence) this.f70923a.get("adid")), 0L, map3))));
        this.f70930i.zzs().zzh(new zzez(this.f70930i, this.f70923a, j3, this.f70928g));
    }
}
