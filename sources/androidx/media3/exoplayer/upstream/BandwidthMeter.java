package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface BandwidthMeter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventListener {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class EventDispatcher {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f45482a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static final class HandlerAndListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Handler f45483a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final EventListener f45484b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private boolean f45485c;

                public HandlerAndListener(Handler handler, EventListener eventListener) {
                    this.f45483a = handler;
                    this.f45484b = eventListener;
                }

                public void d() {
                    this.f45485c = true;
                }
            }

            public void b(Handler handler, EventListener eventListener) {
                Assertions.e(handler);
                Assertions.e(eventListener);
                d(eventListener);
                this.f45482a.add(new HandlerAndListener(handler, eventListener));
            }

            public void c(int i3, long j3, long j4) {
                final int i4;
                final long j5;
                final long j6;
                for (final HandlerAndListener handlerAndListener : this.f45482a) {
                    if (handlerAndListener.f45485c) {
                        i4 = i3;
                        j5 = j3;
                        j6 = j4;
                    } else {
                        i4 = i3;
                        j5 = j3;
                        j6 = j4;
                        handlerAndListener.f45483a.post(new Runnable() { // from class: androidx.media3.exoplayer.upstream.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                handlerAndListener.f45484b.H(i4, j5, j6);
                            }
                        });
                    }
                    i3 = i4;
                    j3 = j5;
                    j4 = j6;
                }
            }

            public void d(EventListener eventListener) {
                for (HandlerAndListener handlerAndListener : this.f45482a) {
                    if (handlerAndListener.f45484b == eventListener) {
                        handlerAndListener.d();
                        this.f45482a.remove(handlerAndListener);
                    }
                }
            }
        }

        void H(int i3, long j3, long j4);
    }

    void a(EventListener eventListener);

    void b(Handler handler, EventListener eventListener);

    TransferListener d();
}
