package androidx.media3.transformer;

import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.PlaybackVideoGraphWrapper;
import com.facebook.ads.AdError;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CompositionPlayerInternal implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerWrapper f48010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PlaybackAudioGraphWrapper f48011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PlaybackVideoGraphWrapper f48012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Listener f48013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HandlerWrapper f48014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f48015g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void P(String str, Exception exc, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class OutputSurfaceInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Surface f48016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Size f48017b;

        public OutputSurfaceInfo(Surface surface, Size size) {
            this.f48016a = surface;
            this.f48017b = size;
        }
    }

    public static /* synthetic */ void a(CompositionPlayerInternal compositionPlayerInternal, String str, Exception exc, int i3) {
        if (compositionPlayerInternal.f48015g) {
            return;
        }
        compositionPlayerInternal.f48013d.P(str, exc, i3);
    }

    private void c() {
        try {
            this.f48012c.E();
        } catch (RuntimeException e3) {
            e("error clearing video output", e3, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
        }
    }

    private void e(final String str, final Exception exc, final int i3) {
        try {
            this.f48014f.j(new Runnable() { // from class: androidx.media3.transformer.a0
                @Override // java.lang.Runnable
                public final void run() {
                    CompositionPlayerInternal.a(this.f48651a, str, exc, i3);
                }
            });
        } catch (RuntimeException e3) {
            Log.e("CompPlayerInternal", "error", e3);
        }
    }

    private void f(ConditionVariable conditionVariable) {
        try {
            this.f48011b.k();
            this.f48012c.E();
            this.f48012c.N();
        } catch (RuntimeException e3) {
            Log.e("CompPlayerInternal", "error while releasing the player", e3);
        } finally {
            conditionVariable.f();
        }
    }

    private void h(OutputSurfaceInfo outputSurfaceInfo) {
        try {
            this.f48012c.Q(outputSurfaceInfo.f48016a, outputSurfaceInfo.f48017b);
        } catch (RuntimeException e3) {
            e("error setting surface view", e3, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
        }
    }

    public void b() {
        this.f48010a.b(2).a();
    }

    public void d() {
        this.f48010a.b(4).a();
    }

    public void g(Surface surface, Size size) {
        this.f48010a.e(1, new OutputSurfaceInfo(surface, size)).a();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i3 = message.what;
            if (i3 == 1) {
                h((OutputSurfaceInfo) message.obj);
            } else if (i3 == 2) {
                c();
            } else if (i3 == 3) {
                this.f48011b.l(Util.P0(((Long) message.obj).longValue()));
            } else if (i3 == 4) {
                this.f48011b.h();
            } else if (i3 != 5) {
                e("Unknown message", new IllegalStateException(String.valueOf(message.what)), 1000);
            } else {
                f((ConditionVariable) message.obj);
            }
        } catch (RuntimeException e3) {
            e("Unknown error", e3, 1000);
        }
        return true;
    }

    public void i(long j3) {
        this.f48010a.e(3, Long.valueOf(j3)).a();
    }
}
