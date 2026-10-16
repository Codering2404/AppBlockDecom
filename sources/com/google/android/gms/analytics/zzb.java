package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzax;
import com.google.android.gms.internal.gtm.zzbg;
import com.google.android.gms.internal.gtm.zzbt;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzbx;
import com.google.android.gms.internal.gtm.zzbz;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfu;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb extends zzbt implements zzt {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static DecimalFormat f70889d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbx f70890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f70892c;

    public zzb(zzbx zzbxVar, String str) {
        super(zzbxVar);
        Preconditions.g(str);
        this.f70890a = zzbxVar;
        this.f70891b = str;
        this.f70892c = b(str);
    }

    static Uri b(String str) {
        Preconditions.g(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String c(double d3) {
        if (f70889d == null) {
            f70889d = new DecimalFormat("0.######");
        }
        return f70889d.format(d3);
    }

    private static void i(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static void j(Map map, String str, boolean z2) {
        if (z2) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    @Override // com.google.android.gms.analytics.zzt
    public final Uri zzb() {
        return this.f70892c;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map f(com.google.android.gms.analytics.zzh r10) {
        /*
            Method dump skipped, instruction units count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzb.f(com.google.android.gms.analytics.zzh):java.util.Map");
    }

    @Override // com.google.android.gms.analytics.zzt
    public final void a(zzh zzhVar) {
        Preconditions.m(zzhVar);
        Preconditions.b(zzhVar.m(), "Can't deliver not submitted measurement");
        Preconditions.l(jlWo.EhgDaQJellIWvHX);
        zzh zzhVar2 = new zzh(zzhVar);
        zzbg zzbgVar = (zzbg) zzhVar2.b(zzbg.class);
        if (TextUtils.isEmpty(zzbgVar.zzf())) {
            zzz().zzc(f(zzhVar2), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzbgVar.zze())) {
            zzz().zzc(f(zzhVar2), "Ignoring measurement without client id");
            return;
        }
        if (!this.f70890a.zzc().i()) {
            if (zzfu.zzj(0.0d, zzbgVar.zze())) {
                zzF("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(0.0d));
                return;
            }
            Map mapF = f(zzhVar2);
            mapF.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            mapF.put("_v", zzbv.zzb);
            mapF.put("tid", this.f70891b);
            if (this.f70890a.zzc().k()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry entry : mapF.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append((String) entry.getKey());
                    sb.append("=");
                    sb.append((String) entry.getValue());
                }
                zzM("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
                return;
            }
            HashMap map = new HashMap();
            zzfu.zzg(map, "uid", zzbgVar.zzg());
            zzax zzaxVar = (zzax) zzhVar.c(zzax.class);
            if (zzaxVar != null) {
                zzfu.zzg(map, "an", zzaxVar.zzf());
                zzfu.zzg(map, "aid", zzaxVar.zzd());
                zzfu.zzg(map, "av", zzaxVar.zzg());
                zzfu.zzg(map, "aiid", zzaxVar.zze());
            }
            mapF.put("_s", String.valueOf(zzs().zza(new zzbz(0L, zzbgVar.zze(), this.f70891b, !TextUtils.isEmpty(zzbgVar.zzd()), 0L, map))));
            zzs().zzh(new zzez(zzz(), mapF, zzhVar.a(), true));
        }
    }
}
