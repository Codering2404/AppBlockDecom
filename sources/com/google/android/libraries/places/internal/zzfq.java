package com.google.android.libraries.places.internal;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfq {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f77832c = TimeUnit.MINUTES.toMicros(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f77833d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzef f77834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f77835b;

    zzfq(Context context, zzef zzefVar) {
        this.f77835b = context;
        this.f77834a = zzefVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.collect.ImmutableList a(java.lang.String r14) {
        /*
            r13 = this;
            android.content.Context r14 = r13.f77835b
            java.lang.String r0 = "wifi"
            java.lang.Object r14 = r14.getSystemService(r0)
            android.net.wifi.WifiManager r14 = (android.net.wifi.WifiManager) r14
            if (r14 == 0) goto La5
            boolean r0 = r14.isWifiEnabled()
            if (r0 != 0) goto L14
            goto La5
        L14:
            java.util.List r0 = r14.getScanResults()
            if (r0 == 0) goto La0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L22
            goto La0
        L22:
            com.google.android.libraries.places.internal.zzfp r1 = com.google.android.libraries.places.internal.zzfp.f77831a
            com.google.common.collect.Ordering r1 = com.google.common.collect.Ordering.b(r1)
            com.google.common.collect.ImmutableList r0 = r1.c(r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.wifi.WifiInfo r14 = r14.getConnectionInfo()
            int r2 = r0.size()
            r3 = 0
            r4 = r3
        L3b:
            if (r4 >= r2) goto L9b
            java.lang.Object r5 = r0.get(r4)
            android.net.wifi.ScanResult r5 = (android.net.wifi.ScanResult) r5
            if (r5 == 0) goto L98
            java.lang.String r6 = r5.SSID
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L4e
            goto L98
        L4e:
            com.google.android.libraries.places.internal.zzef r6 = r13.f77834a
            long r6 = r6.zzb()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r8
            long r8 = r5.timestamp
            long r6 = r6 - r8
            long r8 = com.google.android.libraries.places.internal.zzfq.f77832c
            java.lang.String r10 = r5.SSID
            if (r10 == 0) goto L90
            r11 = 95
            int r11 = r10.indexOf(r11)
            if (r11 >= 0) goto L6a
        L68:
            r12 = r3
            goto L81
        L6a:
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r10 = r10.toLowerCase(r11)
            java.lang.String r11 = "_nomap"
            boolean r11 = r10.contains(r11)
            r12 = 1
            if (r11 != 0) goto L81
            java.lang.String r11 = "_optout"
            boolean r10 = r10.contains(r11)
            if (r10 == 0) goto L68
        L81:
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 > 0) goto L98
            if (r12 != 0) goto L98
            com.google.android.libraries.places.internal.zzfo r6 = new com.google.android.libraries.places.internal.zzfo
            r6.<init>(r14, r5)
            r1.add(r6)
            goto L98
        L90:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Null SSID."
            r14.<init>(r0)
            throw r14
        L98:
            int r4 = r4 + 1
            goto L3b
        L9b:
            com.google.common.collect.ImmutableList r14 = com.google.common.collect.ImmutableList.t(r1)
            return r14
        La0:
            com.google.common.collect.ImmutableList r14 = com.google.common.collect.ImmutableList.y()
            return r14
        La5:
            com.google.common.collect.ImmutableList r14 = com.google.common.collect.ImmutableList.y()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzfq.a(java.lang.String):com.google.common.collect.ImmutableList");
    }
}
