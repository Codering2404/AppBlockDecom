package androidx.recyclerview.widget;

import android.os.Handler;
import android.util.Log;
import androidx.recyclerview.widget.ThreadUtil;
import androidx.recyclerview.widget.TileList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MessageThreadUtil<T> implements ThreadUtil<T> {

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements ThreadUtil.MainThreadCallback<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageQueue f51797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f51798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f51799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ThreadUtil.MainThreadCallback f51800d;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class RunnableC00831 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AnonymousClass1 f51801a;

            @Override // java.lang.Runnable
            public void run() {
                SyncQueueItem syncQueueItemA = this.f51801a.f51797a.a();
                while (syncQueueItemA != null) {
                    int i3 = syncQueueItemA.f51813b;
                    if (i3 == 1) {
                        this.f51801a.f51800d.c(syncQueueItemA.f51814c, syncQueueItemA.f51815d);
                    } else if (i3 == 2) {
                        this.f51801a.f51800d.b(syncQueueItemA.f51814c, (TileList.Tile) syncQueueItemA.f51819h);
                    } else if (i3 != 3) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + syncQueueItemA.f51813b);
                    } else {
                        this.f51801a.f51800d.a(syncQueueItemA.f51814c, syncQueueItemA.f51815d);
                    }
                    syncQueueItemA = this.f51801a.f51797a.a();
                }
            }
        }

        private void d(SyncQueueItem syncQueueItem) {
            this.f51797a.c(syncQueueItem);
            this.f51798b.post(this.f51799c);
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void a(int i3, int i4) {
            d(SyncQueueItem.a(3, i3, i4));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void b(int i3, TileList.Tile tile) {
            d(SyncQueueItem.c(2, i3, tile));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.MainThreadCallback
        public void c(int i3, int i4) {
            d(SyncQueueItem.a(1, i3, i4));
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements ThreadUtil.BackgroundCallback<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageQueue f51802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Executor f51803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AtomicBoolean f51804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f51805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ThreadUtil.BackgroundCallback f51806e;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.MessageThreadUtil$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AnonymousClass2 f51807a;

            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    SyncQueueItem syncQueueItemA = this.f51807a.f51802a.a();
                    if (syncQueueItemA == null) {
                        this.f51807a.f51804c.set(false);
                        return;
                    }
                    int i3 = syncQueueItemA.f51813b;
                    if (i3 == 1) {
                        this.f51807a.f51802a.b(1);
                        this.f51807a.f51806e.c(syncQueueItemA.f51814c);
                    } else if (i3 == 2) {
                        this.f51807a.f51802a.b(2);
                        this.f51807a.f51802a.b(3);
                        this.f51807a.f51806e.a(syncQueueItemA.f51814c, syncQueueItemA.f51815d, syncQueueItemA.f51816e, syncQueueItemA.f51817f, syncQueueItemA.f51818g);
                    } else if (i3 == 3) {
                        this.f51807a.f51806e.b(syncQueueItemA.f51814c, syncQueueItemA.f51815d);
                    } else if (i3 != 4) {
                        Log.e("ThreadUtil", "Unsupported message, what=" + syncQueueItemA.f51813b);
                    } else {
                        this.f51807a.f51806e.d((TileList.Tile) syncQueueItemA.f51819h);
                    }
                }
            }
        }

        private void e() {
            if (this.f51804c.compareAndSet(false, true)) {
                this.f51803b.execute(this.f51805d);
            }
        }

        private void f(SyncQueueItem syncQueueItem) {
            this.f51802a.c(syncQueueItem);
            e();
        }

        private void g(SyncQueueItem syncQueueItem) {
            this.f51802a.d(syncQueueItem);
            e();
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void a(int i3, int i4, int i5, int i6, int i7) {
            g(SyncQueueItem.b(2, i3, i4, i5, i6, i7, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void b(int i3, int i4) {
            f(SyncQueueItem.a(3, i3, i4));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void c(int i3) {
            g(SyncQueueItem.c(1, i3, null));
        }

        @Override // androidx.recyclerview.widget.ThreadUtil.BackgroundCallback
        public void d(TileList.Tile tile) {
            f(SyncQueueItem.c(4, 0, tile));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MessageQueue {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SyncQueueItem f51808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f51809b;

        SyncQueueItem a() {
            synchronized (this.f51809b) {
                try {
                    SyncQueueItem syncQueueItem = this.f51808a;
                    if (syncQueueItem == null) {
                        return null;
                    }
                    this.f51808a = syncQueueItem.f51812a;
                    return syncQueueItem;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b(int i3) {
            SyncQueueItem syncQueueItem;
            synchronized (this.f51809b) {
                while (true) {
                    try {
                        syncQueueItem = this.f51808a;
                        if (syncQueueItem == null || syncQueueItem.f51813b != i3) {
                            break;
                        }
                        this.f51808a = syncQueueItem.f51812a;
                        syncQueueItem.d();
                    } finally {
                    }
                }
                if (syncQueueItem != null) {
                    SyncQueueItem syncQueueItem2 = syncQueueItem.f51812a;
                    while (syncQueueItem2 != null) {
                        SyncQueueItem syncQueueItem3 = syncQueueItem2.f51812a;
                        if (syncQueueItem2.f51813b == i3) {
                            syncQueueItem.f51812a = syncQueueItem3;
                            syncQueueItem2.d();
                        } else {
                            syncQueueItem = syncQueueItem2;
                        }
                        syncQueueItem2 = syncQueueItem3;
                    }
                }
            }
        }

        void c(SyncQueueItem syncQueueItem) {
            synchronized (this.f51809b) {
                try {
                    SyncQueueItem syncQueueItem2 = this.f51808a;
                    if (syncQueueItem2 == null) {
                        this.f51808a = syncQueueItem;
                        return;
                    }
                    while (true) {
                        SyncQueueItem syncQueueItem3 = syncQueueItem2.f51812a;
                        if (syncQueueItem3 == null) {
                            syncQueueItem2.f51812a = syncQueueItem;
                            return;
                        }
                        syncQueueItem2 = syncQueueItem3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void d(SyncQueueItem syncQueueItem) {
            synchronized (this.f51809b) {
                syncQueueItem.f51812a = this.f51808a;
                this.f51808a = syncQueueItem;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SyncQueueItem {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static SyncQueueItem f51810i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final Object f51811j = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SyncQueueItem f51812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f51813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f51814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f51815d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f51816e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f51817f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f51818g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Object f51819h;

        SyncQueueItem() {
        }

        static SyncQueueItem a(int i3, int i4, int i5) {
            return b(i3, i4, i5, 0, 0, 0, null);
        }

        static SyncQueueItem b(int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
            SyncQueueItem syncQueueItem;
            synchronized (f51811j) {
                try {
                    syncQueueItem = f51810i;
                    if (syncQueueItem == null) {
                        syncQueueItem = new SyncQueueItem();
                    } else {
                        f51810i = syncQueueItem.f51812a;
                        syncQueueItem.f51812a = null;
                    }
                    syncQueueItem.f51813b = i3;
                    syncQueueItem.f51814c = i4;
                    syncQueueItem.f51815d = i5;
                    syncQueueItem.f51816e = i6;
                    syncQueueItem.f51817f = i7;
                    syncQueueItem.f51818g = i8;
                    syncQueueItem.f51819h = obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return syncQueueItem;
        }

        static SyncQueueItem c(int i3, int i4, Object obj) {
            return b(i3, i4, 0, 0, 0, 0, obj);
        }

        void d() {
            this.f51812a = null;
            this.f51818g = 0;
            this.f51817f = 0;
            this.f51816e = 0;
            this.f51815d = 0;
            this.f51814c = 0;
            this.f51813b = 0;
            this.f51819h = null;
            synchronized (f51811j) {
                try {
                    SyncQueueItem syncQueueItem = f51810i;
                    if (syncQueueItem != null) {
                        this.f51812a = syncQueueItem;
                    }
                    f51810i = this;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
