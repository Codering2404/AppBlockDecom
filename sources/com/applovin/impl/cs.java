package com.applovin.impl;

import android.content.Context;
import android.net.wifi.WifiManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class cs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WifiManager f59022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WifiManager.WifiLock f59023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f59024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f59025d;

    public cs(Context context) {
        this.f59022a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    public void a(boolean z2) {
        if (z2 && this.f59023b == null) {
            WifiManager wifiManager = this.f59022a;
            if (wifiManager == null) {
                oc.d("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            } else {
                WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                this.f59023b = wifiLockCreateWifiLock;
                wifiLockCreateWifiLock.setReferenceCounted(false);
            }
        }
        this.f59024c = z2;
        a();
    }

    public void b(boolean z2) {
        this.f59025d = z2;
        a();
    }

    private void a() {
        WifiManager.WifiLock wifiLock = this.f59023b;
        if (wifiLock == null) {
            return;
        }
        if (this.f59024c && this.f59025d) {
            wifiLock.acquire();
        } else {
            wifiLock.release();
        }
    }
}
