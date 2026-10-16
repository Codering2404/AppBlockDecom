package androidx.media3.common.util;

import android.os.Looper;
import com.google.common.base.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BackgroundThreadStateHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerWrapper f41479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerWrapper f41480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateChangeListener f41481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f41482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f41483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f41484f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StateChangeListener<T> {
        void a(Object obj, Object obj2);
    }

    public BackgroundThreadStateHandler(Object obj, Looper looper, Looper looper2, Clock clock, StateChangeListener stateChangeListener) {
        this.f41479a = clock.d(looper, null);
        this.f41480b = clock.d(looper2, null);
        this.f41482d = obj;
        this.f41483e = obj;
        this.f41481c = stateChangeListener;
    }

    public static /* synthetic */ void a(final BackgroundThreadStateHandler backgroundThreadStateHandler, Function function) {
        final Object objApply = function.apply(backgroundThreadStateHandler.f41483e);
        backgroundThreadStateHandler.f41483e = objApply;
        backgroundThreadStateHandler.f41480b.j(new Runnable() { // from class: androidx.media3.common.util.c
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.c(this.f41630a, objApply);
            }
        });
    }

    public static /* synthetic */ void b(BackgroundThreadStateHandler backgroundThreadStateHandler, Object obj) {
        if (backgroundThreadStateHandler.f41484f == 0) {
            backgroundThreadStateHandler.h(obj);
        }
    }

    public static /* synthetic */ void c(BackgroundThreadStateHandler backgroundThreadStateHandler, Object obj) {
        int i3 = backgroundThreadStateHandler.f41484f - 1;
        backgroundThreadStateHandler.f41484f = i3;
        if (i3 == 0) {
            backgroundThreadStateHandler.h(obj);
        }
    }

    private void h(Object obj) {
        Object obj2 = this.f41482d;
        this.f41482d = obj;
        if (obj2.equals(obj)) {
            return;
        }
        this.f41481c.a(obj2, obj);
    }

    public Object d() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == this.f41480b.g()) {
            return this.f41482d;
        }
        Assertions.g(looperMyLooper == this.f41479a.g());
        return this.f41483e;
    }

    public void e(Runnable runnable) {
        this.f41479a.j(runnable);
    }

    public void f(final Object obj) {
        this.f41483e = obj;
        this.f41480b.j(new Runnable() { // from class: androidx.media3.common.util.a
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.b(this.f41626a, obj);
            }
        });
    }

    public void g(Function function, final Function function2) {
        Assertions.g(Looper.myLooper() == this.f41480b.g());
        this.f41484f++;
        this.f41479a.j(new Runnable() { // from class: androidx.media3.common.util.b
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundThreadStateHandler.a(this.f41628a, function2);
            }
        });
        h(function.apply(this.f41482d));
    }
}
