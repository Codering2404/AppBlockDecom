package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f77827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzfn f77828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f77829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f77830e;

    public zzfo(WifiInfo wifiInfo, ScanResult scanResult) {
        zzfn zzfnVar;
        String str = scanResult.BSSID;
        String str2 = scanResult.capabilities;
        int i3 = scanResult.level;
        int i4 = scanResult.frequency;
        if (TextUtils.isEmpty(str2)) {
            zzfnVar = zzfn.OTHER;
        } else {
            String upperCase = str2.toUpperCase(Locale.getDefault());
            zzfnVar = (upperCase.equals("[ESS]") || upperCase.equals("[IBSS]")) ? zzfn.NONE : upperCase.matches(".*WPA[0-9]*-PSK.*") ? zzfn.PSK : upperCase.matches(".*WPA[0-9]*-EAP.*") ? zzfn.EAP : zzfn.OTHER;
        }
        boolean z2 = false;
        if (wifiInfo != null && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(wifiInfo.getBSSID())) {
            z2 = true;
        }
        this.f77826a = str;
        this.f77827b = i3;
        this.f77828c = zzfnVar;
        this.f77829d = z2;
        this.f77830e = i4;
    }

    public final String a() {
        return this.f77826a;
    }

    public final int b() {
        return this.f77827b;
    }

    public final zzfn c() {
        return this.f77828c;
    }

    public final boolean d() {
        return this.f77829d;
    }

    public final int e() {
        return this.f77830e;
    }
}
