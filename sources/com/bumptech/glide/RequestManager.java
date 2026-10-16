package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final RequestOptions f66112n = (RequestOptions) RequestOptions.u0(Bitmap.class).U();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final RequestOptions f66113o = (RequestOptions) RequestOptions.u0(GifDrawable.class).U();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final RequestOptions f66114p = (RequestOptions) ((RequestOptions) RequestOptions.v0(DiskCacheStrategy.f66407c).d0(Priority.LOW)).l0(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Glide f66115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f66116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Lifecycle f66117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RequestTracker f66118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RequestManagerTreeNode f66119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TargetTracker f66120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f66121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ConnectivityMonitor f66122i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList f66123j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RequestOptions f66124k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f66125l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f66126m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RequestTracker f66128a;

        RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f66128a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void a(boolean z2) {
            if (z2) {
                synchronized (RequestManager.this) {
                    this.f66128a.e();
                }
            }
        }
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        this(glide, lifecycle, requestManagerTreeNode, new RequestTracker(), glide.g(), context);
    }

    private synchronized void m() {
        try {
            Iterator it = this.f66120g.d().iterator();
            while (it.hasNext()) {
                l((Target) it.next());
            }
            this.f66120g.a();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void y(Target target) {
        boolean zX = x(target);
        Request requestB = target.b();
        if (zX || this.f66115a.p(target) || requestB == null) {
            return;
        }
        target.i(null);
        requestB.clear();
    }

    public RequestBuilder a(Class cls) {
        return new RequestBuilder(this.f66115a, this, cls, this.f66116b);
    }

    public RequestBuilder d() {
        return a(Bitmap.class).a(f66112n);
    }

    public RequestBuilder e() {
        return a(Drawable.class);
    }

    public void l(Target target) {
        if (target == null) {
            return;
        }
        y(target);
    }

    List n() {
        return this.f66123j;
    }

    synchronized RequestOptions o() {
        return this.f66124k;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onDestroy() {
        this.f66120g.onDestroy();
        m();
        this.f66118d.b();
        this.f66117c.a(this);
        this.f66117c.a(this.f66122i);
        Util.y(this.f66121h);
        this.f66115a.s(this);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStart() {
        u();
        this.f66120g.onStart();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public synchronized void onStop() {
        try {
            this.f66120g.onStop();
            if (this.f66126m) {
                m();
            } else {
                t();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        if (i3 == 60 && this.f66125l) {
            s();
        }
    }

    TransitionOptions p(Class cls) {
        return this.f66115a.i().e(cls);
    }

    public RequestBuilder q(String str) {
        return e().K0(str);
    }

    public synchronized void r() {
        this.f66118d.c();
    }

    public synchronized void s() {
        r();
        Iterator it = this.f66119f.a().iterator();
        while (it.hasNext()) {
            ((RequestManager) it.next()).r();
        }
    }

    public synchronized void t() {
        this.f66118d.d();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f66118d + ", treeNode=" + this.f66119f + "}";
    }

    public synchronized void u() {
        this.f66118d.f();
    }

    protected synchronized void v(RequestOptions requestOptions) {
        this.f66124k = (RequestOptions) ((RequestOptions) requestOptions.clone()).b();
    }

    synchronized void w(Target target, Request request) {
        this.f66120g.e(target);
        this.f66118d.g(request);
    }

    synchronized boolean x(Target target) {
        Request requestB = target.b();
        if (requestB == null) {
            return true;
        }
        if (!this.f66118d.a(requestB)) {
            return false;
        }
        this.f66120g.l(target);
        target.i(null);
        return true;
    }

    RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory, Context context) {
        this.f66120g = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.f66117c.c(requestManager);
            }
        };
        this.f66121h = runnable;
        this.f66115a = glide;
        this.f66117c = lifecycle;
        this.f66119f = requestManagerTreeNode;
        this.f66118d = requestTracker;
        this.f66116b = context;
        ConnectivityMonitor connectivityMonitorA = connectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.f66122i = connectivityMonitorA;
        glide.o(this);
        if (Util.s()) {
            Util.x(runnable);
        } else {
            lifecycle.c(this);
        }
        lifecycle.c(connectivityMonitorA);
        this.f66123j = new CopyOnWriteArrayList(glide.i().c());
        v(glide.i().d());
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void j(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void l(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void h(Object obj, Transition transition) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
