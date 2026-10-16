package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.util.HandlerWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SystemHandlerWrapper implements HandlerWrapper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f41597b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f41598a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SystemMessage implements HandlerWrapper.Message {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Message f41599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SystemHandlerWrapper f41600b;

        private SystemMessage() {
        }

        private void b() {
            this.f41599a = null;
            this.f41600b = null;
            SystemHandlerWrapper.p(this);
        }

        @Override // androidx.media3.common.util.HandlerWrapper.Message
        public void a() {
            ((Message) Assertions.e(this.f41599a)).sendToTarget();
            b();
        }

        public boolean c(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) Assertions.e(this.f41599a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        public SystemMessage d(Message message, SystemHandlerWrapper systemHandlerWrapper) {
            this.f41599a = message;
            this.f41600b = systemHandlerWrapper;
            return this;
        }
    }

    public SystemHandlerWrapper(Handler handler) {
        this.f41598a = handler;
    }

    private static SystemMessage o() {
        SystemMessage systemMessage;
        List list = f41597b;
        synchronized (list) {
            try {
                systemMessage = list.isEmpty() ? new SystemMessage() : (SystemMessage) list.remove(list.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return systemMessage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(SystemMessage systemMessage) {
        List list = f41597b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(systemMessage);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean a(int i3, int i4) {
        return this.f41598a.sendEmptyMessageDelayed(i3, i4);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public HandlerWrapper.Message b(int i3) {
        return o().d(this.f41598a.obtainMessage(i3), this);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean c(int i3) {
        Assertions.a(i3 != 0);
        return this.f41598a.hasMessages(i3);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public HandlerWrapper.Message d(int i3, int i4, int i5, Object obj) {
        return o().d(this.f41598a.obtainMessage(i3, i4, i5, obj), this);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public HandlerWrapper.Message e(int i3, Object obj) {
        return o().d(this.f41598a.obtainMessage(i3, obj), this);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public void f(Object obj) {
        this.f41598a.removeCallbacksAndMessages(obj);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public Looper g() {
        return this.f41598a.getLooper();
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public HandlerWrapper.Message h(int i3, int i4, int i5) {
        return o().d(this.f41598a.obtainMessage(i3, i4, i5), this);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean i(HandlerWrapper.Message message) {
        return ((SystemMessage) message).c(this.f41598a);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean j(Runnable runnable) {
        return this.f41598a.post(runnable);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean k(int i3) {
        return this.f41598a.sendEmptyMessage(i3);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean l(int i3, long j3) {
        return this.f41598a.sendEmptyMessageAtTime(i3, j3);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public void m(int i3) {
        Assertions.a(i3 != 0);
        this.f41598a.removeMessages(i3);
    }

    @Override // androidx.media3.common.util.HandlerWrapper
    public boolean postDelayed(Runnable runnable, long j3) {
        return this.f41598a.postDelayed(runnable, j3);
    }
}
