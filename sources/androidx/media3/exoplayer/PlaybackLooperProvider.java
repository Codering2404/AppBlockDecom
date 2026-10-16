package androidx.media3.exoplayer;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackLooperProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f43254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f43255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HandlerThread f43256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43257d;

    public PlaybackLooperProvider() {
        this(null);
    }

    public Looper a() {
        Looper looper;
        synchronized (this.f43254a) {
            try {
                if (this.f43255b == null) {
                    Assertions.g(this.f43257d == 0 && this.f43256c == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f43256c = handlerThread;
                    handlerThread.start();
                    this.f43255b = this.f43256c.getLooper();
                }
                this.f43257d++;
                looper = this.f43255b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void b() {
        HandlerThread handlerThread;
        synchronized (this.f43254a) {
            try {
                Assertions.g(this.f43257d > 0);
                int i3 = this.f43257d - 1;
                this.f43257d = i3;
                if (i3 == 0 && (handlerThread = this.f43256c) != null) {
                    handlerThread.quit();
                    this.f43256c = null;
                    this.f43255b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PlaybackLooperProvider(Looper looper) {
        this.f43254a = new Object();
        this.f43255b = looper;
        this.f43256c = null;
        this.f43257d = 0;
    }
}
