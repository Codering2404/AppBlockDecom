package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Looper;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WifiLockManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WifiLockManagerInternal f43328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerWrapper f43329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f43330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f43331d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WifiLockManagerInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f43332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WifiManager.WifiLock f43333b;

        public WifiLockManagerInternal(Context context) {
            this.f43332a = context;
        }

        public void a(boolean z2, boolean z3) {
            if (z2 && this.f43333b == null) {
                WifiManager wifiManager = (WifiManager) this.f43332a.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    Log.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                    return;
                } else {
                    WifiManager.WifiLock wifiLockCreateWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
                    this.f43333b = wifiLockCreateWifiLock;
                    wifiLockCreateWifiLock.setReferenceCounted(false);
                }
            }
            WifiManager.WifiLock wifiLock = this.f43333b;
            if (wifiLock == null) {
                return;
            }
            if (z2 && z3) {
                wifiLock.acquire();
            } else {
                wifiLock.release();
            }
        }
    }

    public WifiLockManager(Context context, Looper looper, Clock clock) {
        this.f43328a = new WifiLockManagerInternal(context.getApplicationContext());
        this.f43329b = clock.d(looper, null);
    }

    public void c(final boolean z2) {
        if (this.f43330c == z2) {
            return;
        }
        this.f43330c = z2;
        final boolean z3 = this.f43331d;
        this.f43329b.j(new Runnable() { // from class: androidx.media3.exoplayer.w2
            @Override // java.lang.Runnable
            public final void run() {
                this.f46012a.f43328a.a(z2, z3);
            }
        });
    }

    public void d(final boolean z2) {
        if (this.f43331d == z2) {
            return;
        }
        this.f43331d = z2;
        if (this.f43330c) {
            this.f43329b.j(new Runnable() { // from class: androidx.media3.exoplayer.v2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45661a.f43328a.a(true, z2);
                }
            });
        }
    }
}
