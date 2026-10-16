package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class x1 implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set f64779c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final go f64780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f64781b;

    private x1(long j3, final boolean z2, com.applovin.impl.sdk.j jVar, final Runnable runnable) {
        this.f64780a = go.a(j3, z2, jVar, new Runnable() { // from class: com.applovin.impl.e80
            @Override // java.lang.Runnable
            public final void run() {
                this.f59380a.a(z2, runnable);
            }
        });
        this.f64781b = jVar;
        f64779c.add(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public long b() {
        return this.f64780a.c();
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f64780a.d();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f64780a.e();
        }
    }

    public void a() {
        this.f64780a.a();
        AppLovinBroadcastManager.unregisterReceiver(this);
        f64779c.remove(this);
    }

    public static x1 a(long j3, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return a(j3, false, jVar, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z2, Runnable runnable) {
        if (!z2) {
            a();
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static x1 a(long j3, boolean z2, com.applovin.impl.sdk.j jVar, Runnable runnable) {
        return new x1(j3, z2, jVar, runnable);
    }
}
