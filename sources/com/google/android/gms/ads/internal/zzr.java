package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.zzft;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbkc;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f70433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f70434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f70435c = new TreeMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f70436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f70437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f70438f;

    public zzr(Context context, String str) {
        String strConcat;
        this.f70433a = context.getApplicationContext();
        this.f70434b = str;
        String packageName = context.getPackageName();
        try {
            String str2 = Wrappers.a(context).f(context.getPackageName(), 0).versionName;
            StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 1 + String.valueOf(str2).length());
            sb.append(packageName);
            sb.append("-");
            sb.append(str2);
            strConcat = sb.toString();
        } catch (PackageManager.NameNotFoundException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Unable to get package version name for reporting", e3);
            strConcat = String.valueOf(packageName).concat("-missing");
        }
        this.f70438f = strConcat;
    }

    public final String a() {
        return this.f70437e;
    }

    public final String b() {
        return this.f70436d;
    }

    public final String c() {
        return this.f70434b;
    }

    public final String d() {
        return this.f70438f;
    }

    public final Map e() {
        return this.f70435c;
    }

    public final void f(com.google.android.gms.ads.internal.client.zzm zzmVar, VersionInfoParcel versionInfoParcel) {
        zzft zzftVar = zzmVar.f69973k;
        if (zzftVar != null) {
            this.f70436d = zzftVar.f69954a;
        }
        Bundle bundle = zzmVar.f69976n;
        Bundle bundle2 = bundle != null ? bundle.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle2 == null) {
            return;
        }
        String str = (String) zzbkc.zzc.zze();
        for (String str2 : bundle2.keySet()) {
            if (str.equals(str2)) {
                this.f70437e = bundle2.getString(str2);
            } else if (str2.startsWith("csa_")) {
                this.f70435c.put(str2.substring(4), bundle2.getString(str2));
            }
        }
        Map map = this.f70435c;
        map.put("SDKVersion", versionInfoParcel.f70149a);
        if (((Boolean) zzbkc.zza.zze()).booleanValue()) {
            Bundle bundleB = zzac.b(this.f70433a, (String) zzbkc.zzb.zze());
            for (String str3 : bundleB.keySet()) {
                map.put(str3, bundleB.get(str3).toString());
            }
        }
    }
}
