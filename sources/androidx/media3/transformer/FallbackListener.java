package androidx.media3.transformer;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.transformer.TransformationRequest;
import androidx.media3.transformer.Transformer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FallbackListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Composition f48242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListenerSet f48243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerWrapper f48244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TransformationRequest f48245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f48246e = new AtomicInteger();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TransformationRequest f48247f;

    public FallbackListener(Composition composition, ListenerSet listenerSet, HandlerWrapper handlerWrapper, TransformationRequest transformationRequest) {
        this.f48242a = composition;
        this.f48243b = listenerSet;
        this.f48244c = handlerWrapper;
        this.f48245d = transformationRequest;
        this.f48247f = transformationRequest;
    }

    public synchronized void c(TransformationRequest transformationRequest) {
        try {
            Assertions.g(this.f48246e.getAndDecrement() > 0);
            TransformationRequest.Builder builderA = this.f48247f.a();
            if (!Objects.equals(transformationRequest.f48471b, this.f48245d.f48471b)) {
                builderA.b(transformationRequest.f48471b);
            }
            if (!Objects.equals(transformationRequest.f48472c, this.f48245d.f48472c)) {
                builderA.e(transformationRequest.f48472c);
            }
            int i3 = transformationRequest.f48470a;
            if (i3 != this.f48245d.f48470a) {
                builderA.d(i3);
            }
            int i4 = transformationRequest.f48473d;
            if (i4 != this.f48245d.f48473d) {
                builderA.c(i4);
            }
            final TransformationRequest transformationRequestA = builderA.a();
            this.f48247f = transformationRequestA;
            if (this.f48246e.get() == 0 && !this.f48245d.equals(this.f48247f)) {
                this.f48244c.j(new Runnable() { // from class: androidx.media3.transformer.q1
                    @Override // java.lang.Runnable
                    public final void run() {
                        FallbackListener fallbackListener = this.f48704a;
                        fallbackListener.f48243b.j(-1, new ListenerSet.Event() { // from class: androidx.media3.transformer.r1
                            @Override // androidx.media3.common.util.ListenerSet.Event
                            public final void invoke(Object obj) {
                                FallbackListener fallbackListener2 = fallbackListener;
                                ((Transformer.Listener) obj).b(fallbackListener2.f48242a, fallbackListener2.f48245d, transformationRequest);
                            }
                        });
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void d(int i3) {
        this.f48246e.set(i3);
    }
}
