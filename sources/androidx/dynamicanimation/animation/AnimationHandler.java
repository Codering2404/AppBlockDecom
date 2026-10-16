package androidx.dynamicanimation.animation;

import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class AnimationHandler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f36780g = new ThreadLocal();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimationFrameCallbackProvider f36784d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap f36781a = new SimpleArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList f36782b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimationCallbackDispatcher f36783c = new AnimationCallbackDispatcher();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f36785e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f36786f = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnimationCallbackDispatcher {
        AnimationCallbackDispatcher() {
        }

        void a() {
            AnimationHandler.this.f36785e = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.c(animationHandler.f36785e);
            if (AnimationHandler.this.f36782b.size() > 0) {
                AnimationHandler.this.e().a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface AnimationFrameCallback {
        boolean a(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AnimationCallbackDispatcher f36788a;

        AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.f36788a = animationCallbackDispatcher;
        }

        abstract void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Runnable f36789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Handler f36790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f36791d;

        /* JADX INFO: renamed from: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider14$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FrameCallbackProvider14 f36792a;

            @Override // java.lang.Runnable
            public void run() {
                this.f36792a.f36791d = SystemClock.uptimeMillis();
                this.f36792a.f36788a.a();
            }
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void a() {
            this.f36790c.postDelayed(this.f36789b, Math.max(10 - (SystemClock.uptimeMillis() - this.f36791d), 0L));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Choreographer f36793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f36794c;

        FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.f36793b = Choreographer.getInstance();
            this.f36794c = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j3) {
                    FrameCallbackProvider16.this.f36788a.a();
                }
            };
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.AnimationFrameCallbackProvider
        void a() {
            this.f36793b.postFrameCallback(this.f36794c);
        }
    }

    AnimationHandler() {
    }

    private void b() {
        if (this.f36786f) {
            for (int size = this.f36782b.size() - 1; size >= 0; size--) {
                if (this.f36782b.get(size) == null) {
                    this.f36782b.remove(size);
                }
            }
            this.f36786f = false;
        }
    }

    public static AnimationHandler d() {
        ThreadLocal threadLocal = f36780g;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return (AnimationHandler) threadLocal.get();
    }

    private boolean f(AnimationFrameCallback animationFrameCallback, long j3) {
        Long l3 = (Long) this.f36781a.get(animationFrameCallback);
        if (l3 == null) {
            return true;
        }
        if (l3.longValue() >= j3) {
            return false;
        }
        this.f36781a.remove(animationFrameCallback);
        return true;
    }

    public void a(AnimationFrameCallback animationFrameCallback, long j3) {
        if (this.f36782b.size() == 0) {
            e().a();
        }
        if (!this.f36782b.contains(animationFrameCallback)) {
            this.f36782b.add(animationFrameCallback);
        }
        if (j3 > 0) {
            this.f36781a.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j3));
        }
    }

    void c(long j3) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i3 = 0; i3 < this.f36782b.size(); i3++) {
            AnimationFrameCallback animationFrameCallback = (AnimationFrameCallback) this.f36782b.get(i3);
            if (animationFrameCallback != null && f(animationFrameCallback, jUptimeMillis)) {
                animationFrameCallback.a(j3);
            }
        }
        b();
    }

    AnimationFrameCallbackProvider e() {
        if (this.f36784d == null) {
            this.f36784d = new FrameCallbackProvider16(this.f36783c);
        }
        return this.f36784d;
    }

    public void g(AnimationFrameCallback animationFrameCallback) {
        this.f36781a.remove(animationFrameCallback);
        int iIndexOf = this.f36782b.indexOf(animationFrameCallback);
        if (iIndexOf >= 0) {
            this.f36782b.set(iIndexOf, null);
            this.f36786f = true;
        }
    }
}
