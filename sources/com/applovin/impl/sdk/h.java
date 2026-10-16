package com.applovin.impl.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class h extends BroadcastReceiver implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f63311i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f63312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f63313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j f63314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f63315d = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f63316f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f63317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f63318h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(int i3);
    }

    h(j jVar) {
        this.f63314c = jVar;
        Context contextM = j.m();
        this.f63313b = contextM;
        this.f63312a = (AudioManager) contextM.getSystemService("audio");
    }

    public static boolean a(int i3) {
        return i3 == 0 || i3 == 1;
    }

    private void c() {
        this.f63314c.I();
        if (n.a()) {
            this.f63314c.I().a("AudioSessionManager", "Stopping observation of mute switch state...");
        }
        this.f63313b.unregisterReceiver(this);
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.media.RINGER_MODE_CHANGED".equals(intent.getAction())) {
            b(this.f63312a.getRingerMode());
        }
    }

    public int a() {
        return this.f63312a.getRingerMode();
    }

    public void b(a aVar) {
        synchronized (this.f63316f) {
            try {
                if (this.f63315d.contains(aVar)) {
                    this.f63315d.remove(aVar);
                    if (this.f63315d.isEmpty()) {
                        c();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(a aVar) {
        synchronized (this.f63316f) {
            try {
                if (this.f63315d.contains(aVar)) {
                    return;
                }
                this.f63315d.add(aVar);
                if (this.f63315d.size() == 1) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f63317g = true;
            this.f63318h = this.f63312a.getRingerMode();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f63317g = false;
            if (this.f63318h != this.f63312a.getRingerMode()) {
                this.f63318h = f63311i;
                b(this.f63312a.getRingerMode());
            }
        }
    }

    private void b() {
        this.f63314c.I();
        if (n.a()) {
            this.f63314c.I().a("AudioSessionManager", "Observing ringer mode...");
        }
        this.f63318h = f63311i;
        this.f63313b.registerReceiver(this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    private void b(final int i3) {
        if (this.f63317g) {
            return;
        }
        this.f63314c.I();
        if (n.a()) {
            this.f63314c.I().a("AudioSessionManager", "Ringer mode is " + i3);
        }
        synchronized (this.f63316f) {
            try {
                for (final a aVar : this.f63315d) {
                    AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.i0
                        @Override // java.lang.Runnable
                        public final void run() {
                            aVar.a(i3);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
