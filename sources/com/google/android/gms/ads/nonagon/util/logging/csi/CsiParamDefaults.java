package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;
import com.google.android.gms.internal.ads.zzbih;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzgua;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CsiParamDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f70800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PackageInfo f70801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f70802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DeviceTierManager f70803f;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel, PackageInfo packageInfo, String str, DeviceTierManager deviceTierManager) {
        this.f70798a = context;
        this.f70799b = context.getPackageName();
        this.f70800c = versionInfoParcel.f70149a;
        this.f70801d = packageInfo;
        this.f70802e = str;
        this.f70803f = deviceTierManager;
    }

    public void a(Map map) {
        PackageInfo packageInfo;
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.g();
        map.put(DeviceRequestsHelper.DEVICE_INFO_DEVICE, zzs.e0());
        map.put("app", this.f70799b);
        zzt.g();
        Context context = this.f70798a;
        boolean zH = zzs.h(context);
        String str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        map.put("is_lite_sdk", true != zH ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        zzbih zzbihVar = zzbiq.zza;
        List listZzf = zzba.b().zzf();
        if (((Boolean) zzba.c().zzd(zzbiq.zzhP)).booleanValue()) {
            listZzf.addAll(zzt.l().zzo().zzi().zzh());
        }
        map.put("e", TextUtils.join(",", listZzf));
        map.put("sdkVersion", this.f70800c);
        if (((Boolean) zzba.c().zzd(zzbiq.zzmL)).booleanValue()) {
            zzt.g();
            if (true != zzs.e(context)) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            map.put("is_bstar", str);
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzkP)).booleanValue()) {
            if (((Boolean) zzba.c().zzd(zzbiq.zzdg)).booleanValue()) {
                map.put("plugin", zzgua.zza(zzt.l().zzu()));
            }
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzmT)).booleanValue()) {
            map.put("uev", zzgua.zza(this.f70802e));
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzcZ)).booleanValue()) {
            map.put("mem_tier", this.f70803f.a().name());
        }
        if (((Boolean) zzba.c().zzd(zzbiq.zzda)).booleanValue()) {
            map.put("proc_tier", this.f70803f.b().name());
        }
        if (!((Boolean) zzba.c().zzd(zzbiq.zzdb)).booleanValue() || (packageInfo = this.f70801d) == null) {
            return;
        }
        map.put("vc", String.valueOf(packageInfo.versionCode));
        map.put("vn", String.valueOf(packageInfo.versionName));
    }
}
