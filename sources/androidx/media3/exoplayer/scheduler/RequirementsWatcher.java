package androidx.media3.exoplayer.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.scheduler.RequirementsWatcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RequirementsWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f44530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f44531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Requirements f44532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f44533d = Util.E();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private DeviceStatusChangeReceiver f44534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44535f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private NetworkCallback f44536g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            RequirementsWatcher.this.e();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(RequirementsWatcher requirementsWatcher, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class NetworkCallback extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f44538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f44539b;

        private NetworkCallback() {
        }

        public static /* synthetic */ void a(NetworkCallback networkCallback) {
            if (RequirementsWatcher.this.f44536g != null) {
                RequirementsWatcher.this.g();
            }
        }

        public static /* synthetic */ void b(NetworkCallback networkCallback) {
            if (RequirementsWatcher.this.f44536g != null) {
                RequirementsWatcher.this.e();
            }
        }

        private void c() {
            RequirementsWatcher.this.f44533d.post(new Runnable() { // from class: androidx.media3.exoplayer.scheduler.a
                @Override // java.lang.Runnable
                public final void run() {
                    RequirementsWatcher.NetworkCallback.b(this.f44541a);
                }
            });
        }

        private void d() {
            RequirementsWatcher.this.f44533d.post(new Runnable() { // from class: androidx.media3.exoplayer.scheduler.b
                @Override // java.lang.Runnable
                public final void run() {
                    RequirementsWatcher.NetworkCallback.a(this.f44542a);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            c();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z2) {
            if (z2) {
                return;
            }
            d();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            if (this.f44538a && this.f44539b == zHasCapability) {
                if (zHasCapability) {
                    d();
                }
            } else {
                this.f44538a = true;
                this.f44539b = zHasCapability;
                c();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            c();
        }
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.f44530a = context.getApplicationContext();
        this.f44531b = listener;
        this.f44532c = requirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int iD = this.f44532c.d(this.f44530a);
        if (this.f44535f != iD) {
            this.f44535f = iD;
            this.f44531b.a(this, iD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if ((this.f44535f & 3) == 0) {
            return;
        }
        e();
    }

    private void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) Assertions.e((ConnectivityManager) this.f44530a.getSystemService("connectivity"));
        NetworkCallback networkCallback = new NetworkCallback();
        this.f44536g = networkCallback;
        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }

    private void k() {
        ((ConnectivityManager) Assertions.e((ConnectivityManager) this.f44530a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.e(this.f44536g));
        this.f44536g = null;
    }

    public Requirements f() {
        return this.f44532c;
    }

    public int i() {
        this.f44535f = this.f44532c.d(this.f44530a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f44532c.k()) {
            if (Util.f41609a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f44532c.f()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f44532c.i()) {
            if (Util.f41609a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f44532c.m()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.f44534e = deviceStatusChangeReceiver;
        this.f44530a.registerReceiver(deviceStatusChangeReceiver, intentFilter, null, this.f44533d);
        return this.f44535f;
    }

    public void j() {
        this.f44530a.unregisterReceiver((BroadcastReceiver) Assertions.e(this.f44534e));
        this.f44534e = null;
        if (Util.f41609a < 24 || this.f44536g == null) {
            return;
        }
        k();
    }
}
