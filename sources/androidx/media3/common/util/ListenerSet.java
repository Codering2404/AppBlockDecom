package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ListenerSet<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f41540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerWrapper f41541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IterationFinishedEvent f41542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet f41543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque f41544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f41545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f41546g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f41547h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f41548i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Event<T> {
        void invoke(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface IterationFinishedEvent<T> {
        void a(Object obj, FlagSet flagSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ListenerHolder<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f41549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private FlagSet.Builder f41550b = new FlagSet.Builder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f41551c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f41552d;

        public ListenerHolder(Object obj) {
            this.f41549a = obj;
        }

        public void a(int i3, Event event) {
            if (this.f41552d) {
                return;
            }
            if (i3 != -1) {
                this.f41550b.a(i3);
            }
            this.f41551c = true;
            event.invoke(this.f41549a);
        }

        public void b(IterationFinishedEvent iterationFinishedEvent) {
            if (this.f41552d || !this.f41551c) {
                return;
            }
            FlagSet flagSetE = this.f41550b.e();
            this.f41550b = new FlagSet.Builder();
            this.f41551c = false;
            iterationFinishedEvent.a(this.f41549a, flagSetE);
        }

        public void c(IterationFinishedEvent iterationFinishedEvent) {
            this.f41552d = true;
            if (this.f41551c) {
                this.f41551c = false;
                iterationFinishedEvent.a(this.f41549a, this.f41550b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.f41549a.equals(((ListenerHolder) obj).f41549a);
        }

        public int hashCode() {
            return this.f41549a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent, true);
    }

    public static /* synthetic */ void a(CopyOnWriteArraySet copyOnWriteArraySet, int i3, Event event) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).a(i3, event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator it = this.f41543d.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).b(this.f41542c);
            if (this.f41541b.c(1)) {
                break;
            }
        }
        return true;
    }

    private void k() {
        if (this.f41548i) {
            Assertions.g(Thread.currentThread() == this.f41541b.g().getThread());
        }
    }

    public void c(Object obj) {
        Assertions.e(obj);
        synchronized (this.f41546g) {
            try {
                if (this.f41547h) {
                    return;
                }
                this.f41543d.add(new ListenerHolder(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public ListenerSet d(Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent) {
        return new ListenerSet(this.f41543d, looper, clock, iterationFinishedEvent, this.f41548i);
    }

    public ListenerSet e(Looper looper, IterationFinishedEvent iterationFinishedEvent) {
        return d(looper, this.f41540a, iterationFinishedEvent);
    }

    public void f() {
        k();
        if (this.f41545f.isEmpty()) {
            return;
        }
        if (!this.f41541b.c(1)) {
            HandlerWrapper handlerWrapper = this.f41541b;
            handlerWrapper.i(handlerWrapper.b(1));
        }
        boolean zIsEmpty = this.f41544e.isEmpty();
        this.f41544e.addAll(this.f41545f);
        this.f41545f.clear();
        if (zIsEmpty) {
            while (!this.f41544e.isEmpty()) {
                ((Runnable) this.f41544e.peekFirst()).run();
                this.f41544e.removeFirst();
            }
        }
    }

    public void h(final int i3, final Event event) {
        k();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f41543d);
        this.f41545f.add(new Runnable() { // from class: androidx.media3.common.util.d
            @Override // java.lang.Runnable
            public final void run() {
                ListenerSet.a(copyOnWriteArraySet, i3, event);
            }
        });
    }

    public void i() {
        k();
        synchronized (this.f41546g) {
            this.f41547h = true;
        }
        Iterator it = this.f41543d.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).c(this.f41542c);
        }
        this.f41543d.clear();
    }

    public void j(int i3, Event event) {
        h(i3, event);
        f();
    }

    private ListenerSet(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent, boolean z2) {
        this.f41540a = clock;
        this.f41543d = copyOnWriteArraySet;
        this.f41542c = iterationFinishedEvent;
        this.f41546g = new Object();
        this.f41544e = new ArrayDeque();
        this.f41545f = new ArrayDeque();
        this.f41541b = clock.d(looper, new Handler.Callback() { // from class: androidx.media3.common.util.e
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f41635a.g(message);
            }
        });
        this.f41548i = z2;
    }
}
