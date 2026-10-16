package com.google.android.recaptcha.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbe {
    public zzbe() {
        new ConcurrentHashMap();
        zzb();
    }

    public static final Set zza(Context context) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                linkedHashSet.add(zzqi.TRANSPORT_WIFI);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                linkedHashSet.add(zzqi.TRANSPORT_CELLULAR);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                linkedHashSet.add(zzqi.TRANSPORT_VPN);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                linkedHashSet.add(zzqi.TRANSPORT_ETHERNET);
            }
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                linkedHashSet.add(zzqi.NET_CAPABILITY_VALIDATED);
            }
            return linkedHashSet;
        } catch (Exception unused) {
            return SetsKt.emptySet();
        }
    }

    private static final Map zzb() {
        Map mapMutableMapOf = MapsKt.mutableMapOf(TuplesKt.a(0, zzqi.NET_CAPABILITY_MMS), TuplesKt.a(1, zzqi.NET_CAPABILITY_SUPL), TuplesKt.a(2, zzqi.NET_CAPABILITY_DUN), TuplesKt.a(3, zzqi.NET_CAPABILITY_FOTA), TuplesKt.a(4, zzqi.NET_CAPABILITY_IMS), TuplesKt.a(5, zzqi.NET_CAPABILITY_CBS), TuplesKt.a(6, zzqi.NET_CAPABILITY_WIFI_P2P), TuplesKt.a(7, zzqi.NET_CAPABILITY_IA), TuplesKt.a(8, zzqi.NET_CAPABILITY_RCS), TuplesKt.a(9, zzqi.NET_CAPABILITY_XCAP), TuplesKt.a(10, zzqi.NET_CAPABILITY_EIMS), TuplesKt.a(11, zzqi.NET_CAPABILITY_NOT_METERED), TuplesKt.a(12, zzqi.NET_CAPABILITY_INTERNET), TuplesKt.a(13, zzqi.NET_CAPABILITY_NOT_RESTRICTED), TuplesKt.a(14, zzqi.NET_CAPABILITY_TRUSTED), TuplesKt.a(15, zzqi.NET_CAPABILITY_NOT_VPN));
        int i3 = Build.VERSION.SDK_INT;
        mapMutableMapOf.put(17, zzqi.NET_CAPABILITY_CAPTIVE_PORTAL);
        mapMutableMapOf.put(16, zzqi.NET_CAPABILITY_VALIDATED);
        mapMutableMapOf.put(18, zzqi.NET_CAPABILITY_NOT_ROAMING);
        mapMutableMapOf.put(19, zzqi.NET_CAPABILITY_FOREGROUND);
        mapMutableMapOf.put(20, zzqi.NET_CAPABILITY_NOT_CONGESTED);
        mapMutableMapOf.put(21, zzqi.NET_CAPABILITY_NOT_SUSPENDED);
        if (i3 >= 29) {
            mapMutableMapOf.put(23, zzqi.NET_CAPABILITY_MCX);
        }
        if (i3 >= 30) {
            mapMutableMapOf.put(25, zzqi.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (i3 >= 31) {
            mapMutableMapOf.put(32, zzqi.NET_CAPABILITY_HEAD_UNIT);
            mapMutableMapOf.put(29, zzqi.NET_CAPABILITY_ENTERPRISE);
        }
        if (i3 >= 33) {
            mapMutableMapOf.put(35, zzqi.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            mapMutableMapOf.put(34, zzqi.NET_CAPABILITY_PRIORITIZE_LATENCY);
            mapMutableMapOf.put(33, zzqi.NET_CAPABILITY_MMTEL);
        }
        return mapMutableMapOf;
    }
}
