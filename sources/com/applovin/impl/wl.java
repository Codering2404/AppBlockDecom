package com.applovin.impl;

import android.os.Handler;
import android.os.Message;
import com.applovin.impl.ia;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class wl implements ia {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f64687b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f64688a;

    public wl(Handler handler) {
        this.f64688a = handler;
    }

    @Override // com.applovin.impl.ia
    public void b(int i3) {
        this.f64688a.removeMessages(i3);
    }

    @Override // com.applovin.impl.ia
    public boolean c(int i3) {
        return this.f64688a.sendEmptyMessage(i3);
    }

    @Override // com.applovin.impl.ia
    public ia.a d(int i3) {
        return a().a(this.f64688a.obtainMessage(i3), this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b implements ia.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Message f64689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private wl f64690b;

        private b() {
        }

        private void b() {
            this.f64689a = null;
            this.f64690b = null;
            wl.b(this);
        }

        public boolean a(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) b1.a(this.f64689a));
            b();
            return zSendMessageAtFrontOfQueue;
        }

        @Override // com.applovin.impl.ia.a
        public void a() {
            ((Message) b1.a(this.f64689a)).sendToTarget();
            b();
        }

        public b a(Message message, wl wlVar) {
            this.f64689a = message;
            this.f64690b = wlVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b bVar) {
        List list = f64687b;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(bVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.applovin.impl.ia
    public boolean a(int i3) {
        return this.f64688a.hasMessages(i3);
    }

    @Override // com.applovin.impl.ia
    public boolean a(Runnable runnable) {
        return this.f64688a.post(runnable);
    }

    @Override // com.applovin.impl.ia
    public void a(Object obj) {
        this.f64688a.removeCallbacksAndMessages(obj);
    }

    @Override // com.applovin.impl.ia
    public boolean a(int i3, long j3) {
        return this.f64688a.sendEmptyMessageAtTime(i3, j3);
    }

    @Override // com.applovin.impl.ia
    public boolean a(ia.a aVar) {
        return ((b) aVar).a(this.f64688a);
    }

    @Override // com.applovin.impl.ia
    public ia.a a(int i3, Object obj) {
        return a().a(this.f64688a.obtainMessage(i3, obj), this);
    }

    @Override // com.applovin.impl.ia
    public ia.a a(int i3, int i4, int i5) {
        return a().a(this.f64688a.obtainMessage(i3, i4, i5), this);
    }

    @Override // com.applovin.impl.ia
    public ia.a a(int i3, int i4, int i5, Object obj) {
        return a().a(this.f64688a.obtainMessage(i3, i4, i5, obj), this);
    }

    private static b a() {
        b bVar;
        List list = f64687b;
        synchronized (list) {
            try {
                if (list.isEmpty()) {
                    bVar = new b();
                } else {
                    bVar = (b) list.remove(list.size() - 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }
}
