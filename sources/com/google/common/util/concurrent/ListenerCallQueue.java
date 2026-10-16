package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LazyLogger f85880b = new LazyLogger(ListenerCallQueue.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f85881a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Event<L> {
        void a(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PerListenerQueue<L> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f85882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f85883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Queue f85884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Queue f85885d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f85886f;

        synchronized void a(Event event, Object obj) {
            this.f85884c.add(event);
            this.f85885d.add(obj);
        }

        void b() throws Exception {
            boolean z2;
            synchronized (this) {
                try {
                    if (this.f85886f) {
                        z2 = false;
                    } else {
                        z2 = true;
                        this.f85886f = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                try {
                    this.f85883b.execute(this);
                } catch (Exception e3) {
                    synchronized (this) {
                        this.f85886f = false;
                        ListenerCallQueue.f85880b.a().log(Level.SEVERE, "Exception while running callbacks for " + this.f85882a + " on " + this.f85883b, (Throwable) e3);
                        throw e3;
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        
            r2.a(r9.f85882a);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
        
            r2 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        
            com.google.common.util.concurrent.ListenerCallQueue.f85880b.a().log(java.util.logging.Level.SEVERE, "Exception while executing callback: " + r9.f85882a + " " + r3, (java.lang.Throwable) r2);
         */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                r9 = this;
            L0:
                r0 = 0
                r1 = 1
                monitor-enter(r9)     // Catch: java.lang.Throwable -> L2b
                boolean r2 = r9.f85886f     // Catch: java.lang.Throwable -> L1f
                com.google.common.base.Preconditions.z(r2)     // Catch: java.lang.Throwable -> L1f
                java.util.Queue r2 = r9.f85884c     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r2 = r2.poll()     // Catch: java.lang.Throwable -> L1f
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch: java.lang.Throwable -> L1f
                java.util.Queue r3 = r9.f85885d     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1f
                if (r2 != 0) goto L24
                r9.f85886f = r0     // Catch: java.lang.Throwable -> L1f
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1c
                return
            L1c:
                r1 = move-exception
                r2 = r0
                goto L57
            L1f:
                r2 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L57
            L24:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L1f
                java.lang.Object r4 = r9.f85882a     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                r2.a(r4)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L2d
                goto L0
            L2b:
                r2 = move-exception
                goto L60
            L2d:
                r2 = move-exception
                com.google.common.util.concurrent.LazyLogger r4 = com.google.common.util.concurrent.ListenerCallQueue.a()     // Catch: java.lang.Throwable -> L2b
                java.util.logging.Logger r4 = r4.a()     // Catch: java.lang.Throwable -> L2b
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L2b
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2b
                r6.<init>()     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = "Exception while executing callback: "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                java.lang.Object r7 = r9.f85882a     // Catch: java.lang.Throwable -> L2b
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r7 = " "
                r6.append(r7)     // Catch: java.lang.Throwable -> L2b
                r6.append(r3)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L2b
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L2b
                goto L0
            L57:
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L5e
                throw r1     // Catch: java.lang.Throwable -> L59
            L59:
                r1 = move-exception
                r8 = r2
                r2 = r1
                r1 = r8
                goto L60
            L5e:
                r1 = move-exception
                goto L57
            L60:
                if (r1 == 0) goto L6a
                monitor-enter(r9)
                r9.f85886f = r0     // Catch: java.lang.Throwable -> L67
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L67
                goto L6a
            L67:
                r0 = move-exception
                monitor-exit(r9)     // Catch: java.lang.Throwable -> L67
                throw r0
            L6a:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }

    private void d(Event event, Object obj) {
        Preconditions.u(event, "event");
        Preconditions.u(obj, "label");
        synchronized (this.f85881a) {
            try {
                Iterator it = this.f85881a.iterator();
                while (it.hasNext()) {
                    ((PerListenerQueue) it.next()).a(event, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b() throws Exception {
        for (int i3 = 0; i3 < this.f85881a.size(); i3++) {
            ((PerListenerQueue) this.f85881a.get(i3)).b();
        }
    }

    public void c(Event event) {
        d(event, event);
    }
}
