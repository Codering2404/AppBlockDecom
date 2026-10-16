package androidx.media3.common.util;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface HandlerWrapper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Message {
        void a();
    }

    boolean a(int i3, int i4);

    Message b(int i3);

    boolean c(int i3);

    Message d(int i3, int i4, int i5, Object obj);

    Message e(int i3, Object obj);

    void f(Object obj);

    Looper g();

    Message h(int i3, int i4, int i5);

    boolean i(Message message);

    boolean j(Runnable runnable);

    boolean k(int i3);

    boolean l(int i3, long j3);

    void m(int i3);

    boolean postDelayed(Runnable runnable, long j3);
}
