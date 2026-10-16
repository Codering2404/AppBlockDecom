package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class EventBus implements Subscriber, Publisher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f88130a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue f88131b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f88132c;

    EventBus(Executor executor) {
        this.f88132c = executor;
    }

    private synchronized Set e(Event event) {
        Map map;
        try {
            map = (Map) this.f88130a.get(event.b());
        } catch (Throwable th) {
            throw th;
        }
        return map == null ? Collections.EMPTY_SET : map.entrySet();
    }

    @Override // com.google.firebase.events.Subscriber
    public void a(Class cls, EventHandler eventHandler) {
        b(cls, this.f88132c, eventHandler);
    }

    @Override // com.google.firebase.events.Subscriber
    public synchronized void b(Class cls, Executor executor, EventHandler eventHandler) {
        try {
            Preconditions.b(cls);
            Preconditions.b(eventHandler);
            Preconditions.b(executor);
            if (!this.f88130a.containsKey(cls)) {
                this.f88130a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f88130a.get(cls)).put(eventHandler, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    void d() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f88131b;
                if (queue != null) {
                    this.f88131b = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                f((Event) it.next());
            }
        }
    }

    public void f(final Event event) {
        Preconditions.b(event);
        synchronized (this) {
            try {
                Queue queue = this.f88131b;
                if (queue != null) {
                    queue.add(event);
                    return;
                }
                for (final Map.Entry entry : e(event)) {
                    ((Executor) entry.getValue()).execute(new Runnable() { // from class: com.google.firebase.components.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            ((EventHandler) entry.getKey()).a(event);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
