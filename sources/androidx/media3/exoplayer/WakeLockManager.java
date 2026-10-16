package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import android.os.PowerManager;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WakeLockManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WakeLockManagerInternal f43322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerWrapper f43323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f43324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f43325d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WakeLockManagerInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f43326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PowerManager.WakeLock f43327b;

        public WakeLockManagerInternal(Context context) {
            this.f43326a = context;
        }

        public void a(boolean z2, boolean z3) {
            if (z2 && this.f43327b == null) {
                PowerManager powerManager = (PowerManager) this.f43326a.getSystemService("power");
                if (powerManager == null) {
                    Log.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                    return;
                } else {
                    PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
                    this.f43327b = wakeLockNewWakeLock;
                    wakeLockNewWakeLock.setReferenceCounted(false);
                }
            }
            PowerManager.WakeLock wakeLock = this.f43327b;
            if (wakeLock == null) {
                return;
            }
            if (z2 && z3) {
                wakeLock.acquire();
            } else {
                wakeLock.release();
            }
        }
    }

    public WakeLockManager(Context context, Looper looper, Clock clock) {
        this.f43322a = new WakeLockManagerInternal(context.getApplicationContext());
        this.f43323b = clock.d(looper, null);
    }

    public void c(final boolean z2) {
        if (this.f43324c == z2) {
            return;
        }
        this.f43324c = z2;
        final boolean z3 = this.f43325d;
        this.f43323b.j(new Runnable() { // from class: androidx.media3.exoplayer.u2
            @Override // java.lang.Runnable
            public final void run() {
                this.f45477a.f43322a.a(z2, z3);
            }
        });
    }

    public void d(final boolean z2) {
        if (this.f43325d == z2) {
            return;
        }
        this.f43325d = z2;
        if (this.f43324c) {
            this.f43323b.j(new Runnable() { // from class: androidx.media3.exoplayer.t2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45299a.f43322a.a(true, z2);
                }
            });
        }
    }
}
