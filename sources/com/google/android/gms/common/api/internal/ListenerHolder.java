package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ListenerHolder<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f71582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Object f71583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile ListenerKey f71584c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ListenerKey<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f71585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f71586b;

        ListenerKey(Object obj, String str) {
            this.f71585a = obj;
            this.f71586b = str;
        }

        public String a() {
            return this.f71586b + "@" + System.identityHashCode(this.f71585a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.f71585a == listenerKey.f71585a && this.f71586b.equals(listenerKey.f71586b);
        }

        public int hashCode() {
            return (System.identityHashCode(this.f71585a) * 31) + this.f71586b.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Notifier<L> {
        void notifyListener(Object obj);

        void onNotifyListenerFailed();
    }

    ListenerHolder(Looper looper, Object obj, String str) {
        this.f71582a = new HandlerExecutor(looper);
        this.f71583b = Preconditions.n(obj, "Listener must not be null");
        this.f71584c = new ListenerKey(obj, Preconditions.g(str));
    }

    public void a() {
        this.f71583b = null;
        this.f71584c = null;
    }

    public ListenerKey b() {
        return this.f71584c;
    }

    public void c(final Notifier notifier) {
        Preconditions.n(notifier, "Notifier must not be null");
        this.f71582a.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            @Override // java.lang.Runnable
            public final void run() {
                this.f71777a.d(notifier);
            }
        });
    }

    final void d(Notifier notifier) {
        Object obj = this.f71583b;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e3) {
            notifier.onNotifyListenerFailed();
            throw e3;
        }
    }

    ListenerHolder(Executor executor, Object obj, String str) {
        this.f71582a = (Executor) Preconditions.n(executor, "Executor must not be null");
        this.f71583b = Preconditions.n(obj, "Listener must not be null");
        this.f71584c = new ListenerKey(obj, Preconditions.g(str));
    }
}
