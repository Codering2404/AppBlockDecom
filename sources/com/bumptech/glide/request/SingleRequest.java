package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final boolean E = Log.isLoggable("GlideRequest", 2);
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f67141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f67142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StateVerifier f67143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f67144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RequestListener f67145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RequestCoordinator f67146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f67147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlideContext f67148h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f67149i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Class f67150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final BaseRequestOptions f67151k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f67152l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f67153m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Priority f67154n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Target f67155o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final List f67156p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TransitionFactory f67157q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Executor f67158r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Resource f67159s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Engine.LoadStatus f67160t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f67161u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile Engine f67162v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Status f67163w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f67164x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Drawable f67165y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Drawable f67166z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i3, int i4, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        this.f67142b = E ? String.valueOf(super.hashCode()) : null;
        this.f67143c = StateVerifier.a();
        this.f67144d = obj;
        this.f67147g = context;
        this.f67148h = glideContext;
        this.f67149i = obj2;
        this.f67150j = cls;
        this.f67151k = baseRequestOptions;
        this.f67152l = i3;
        this.f67153m = i4;
        this.f67154n = priority;
        this.f67155o = target;
        this.f67145e = requestListener;
        this.f67156p = list;
        this.f67146f = requestCoordinator;
        this.f67162v = engine;
        this.f67157q = transitionFactory;
        this.f67158r = executor;
        this.f67163w = Status.PENDING;
        if (this.D == null && glideContext.g().a(GlideBuilder.LogRequestOrigins.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    private void A(Resource resource, Object obj, DataSource dataSource, boolean z2) {
        boolean z3;
        boolean z4;
        boolean zS = s();
        this.f67163w = Status.COMPLETE;
        this.f67159s = resource;
        if (this.f67148h.h() <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.f67149i + " with size [" + this.A + "x" + this.B + "] in " + LogTime.a(this.f67161u) + " ms");
        }
        x();
        boolean z5 = true;
        this.C = true;
        try {
            List<RequestListener> list = this.f67156p;
            if (list != null) {
                z3 = false;
                for (RequestListener requestListener : list) {
                    Object obj2 = obj;
                    DataSource dataSource2 = dataSource;
                    boolean zD = requestListener.d(obj2, this.f67149i, this.f67155o, dataSource2, zS) | z3;
                    if (requestListener instanceof ExperimentalRequestListener) {
                        z4 = z2;
                        zD |= ((ExperimentalRequestListener) requestListener).c(obj2, this.f67149i, this.f67155o, dataSource2, zS, z4);
                    } else {
                        z4 = z2;
                    }
                    dataSource = dataSource2;
                    z2 = z4;
                    z3 = zD;
                    obj = obj2;
                }
            } else {
                z3 = false;
            }
            Object obj3 = obj;
            DataSource dataSource3 = dataSource;
            RequestListener requestListener2 = this.f67145e;
            if (requestListener2 == null || !requestListener2.d(obj3, this.f67149i, this.f67155o, dataSource3, zS)) {
                z5 = false;
            }
            if (!(z5 | z3)) {
                this.f67155o.h(obj3, this.f67157q.a(dataSource3, zS));
            }
            this.C = false;
            GlideTrace.f("GlideRequest", this.f67141a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    private void B() {
        if (l()) {
            Drawable drawableQ = this.f67149i == null ? q() : null;
            if (drawableQ == null) {
                drawableQ = p();
            }
            if (drawableQ == null) {
                drawableQ = r();
            }
            this.f67155o.j(drawableQ);
        }
    }

    private void j() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean k() {
        RequestCoordinator requestCoordinator = this.f67146f;
        return requestCoordinator == null || requestCoordinator.j(this);
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f67146f;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f67146f;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    private void n() {
        j();
        this.f67143c.c();
        this.f67155o.c(this);
        Engine.LoadStatus loadStatus = this.f67160t;
        if (loadStatus != null) {
            loadStatus.a();
            this.f67160t = null;
        }
    }

    private void o(Object obj) {
        List<RequestListener> list = this.f67156p;
        if (list == null) {
            return;
        }
        for (RequestListener requestListener : list) {
            if (requestListener instanceof ExperimentalRequestListener) {
                ((ExperimentalRequestListener) requestListener).b(obj);
            }
        }
    }

    private Drawable p() {
        if (this.f67164x == null) {
            Drawable drawableQ = this.f67151k.q();
            this.f67164x = drawableQ;
            if (drawableQ == null && this.f67151k.p() > 0) {
                this.f67164x = t(this.f67151k.p());
            }
        }
        return this.f67164x;
    }

    private Drawable q() {
        if (this.f67166z == null) {
            Drawable drawableR = this.f67151k.r();
            this.f67166z = drawableR;
            if (drawableR == null && this.f67151k.s() > 0) {
                this.f67166z = t(this.f67151k.s());
            }
        }
        return this.f67166z;
    }

    private Drawable r() {
        if (this.f67165y == null) {
            Drawable drawableX = this.f67151k.x();
            this.f67165y = drawableX;
            if (drawableX == null && this.f67151k.y() > 0) {
                this.f67165y = t(this.f67151k.y());
            }
        }
        return this.f67165y;
    }

    private boolean s() {
        RequestCoordinator requestCoordinator = this.f67146f;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    private Drawable t(int i3) {
        return DrawableDecoderCompat.a(this.f67147g, i3, this.f67151k.E() != null ? this.f67151k.E() : this.f67147g.getTheme());
    }

    private void u(String str) {
        Log.v("GlideRequest", str + " this: " + this.f67142b);
    }

    private static int v(int i3, float f3) {
        return i3 == Integer.MIN_VALUE ? i3 : Math.round(f3 * i3);
    }

    private void w() {
        RequestCoordinator requestCoordinator = this.f67146f;
        if (requestCoordinator != null) {
            requestCoordinator.d(this);
        }
    }

    private void x() {
        RequestCoordinator requestCoordinator = this.f67146f;
        if (requestCoordinator != null) {
            requestCoordinator.f(this);
        }
    }

    public static SingleRequest y(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, BaseRequestOptions baseRequestOptions, int i3, int i4, Priority priority, Target target, RequestListener requestListener, List list, RequestCoordinator requestCoordinator, Engine engine, TransitionFactory transitionFactory, Executor executor) {
        return new SingleRequest(context, glideContext, obj, obj2, cls, baseRequestOptions, i3, i4, priority, target, requestListener, list, requestCoordinator, engine, transitionFactory, executor);
    }

    private void z(GlideException glideException, int i3) {
        boolean zA;
        this.f67143c.c();
        synchronized (this.f67144d) {
            try {
                glideException.k(this.D);
                int iH = this.f67148h.h();
                if (iH <= i3) {
                    Log.w("Glide", "Load failed for [" + this.f67149i + "] with dimensions [" + this.A + "x" + this.B + "]", glideException);
                    if (iH <= 4) {
                        glideException.g("Glide");
                    }
                }
                this.f67160t = null;
                this.f67163w = Status.FAILED;
                w();
                boolean z2 = true;
                this.C = true;
                try {
                    List list = this.f67156p;
                    if (list != null) {
                        Iterator it = list.iterator();
                        zA = false;
                        while (it.hasNext()) {
                            zA |= ((RequestListener) it.next()).a(glideException, this.f67149i, this.f67155o, s());
                        }
                    } else {
                        zA = false;
                    }
                    RequestListener requestListener = this.f67145e;
                    if (requestListener == null || !requestListener.a(glideException, this.f67149i, this.f67155o, s())) {
                        z2 = false;
                    }
                    if (!(zA | z2)) {
                        B();
                    }
                    this.C = false;
                    GlideTrace.f("GlideRequest", this.f67141a);
                } catch (Throwable th) {
                    this.C = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean a() {
        boolean z2;
        synchronized (this.f67144d) {
            z2 = this.f67163w == Status.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void b(Resource resource, DataSource dataSource, boolean z2) {
        this.f67143c.c();
        Resource resource2 = null;
        try {
            synchronized (this.f67144d) {
                try {
                    this.f67160t = null;
                    if (resource == null) {
                        c(new GlideException("Expected to receive a Resource<R> with an object of " + this.f67150j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource.get();
                    try {
                        if (obj == null || !this.f67150j.isAssignableFrom(obj.getClass())) {
                            this.f67159s = null;
                            StringBuilder sb = new StringBuilder();
                            sb.append("Expected to receive an object of ");
                            sb.append(this.f67150j);
                            sb.append(" but instead got ");
                            sb.append(obj != null ? obj.getClass() : "");
                            sb.append("{");
                            sb.append(obj);
                            sb.append("} inside Resource{");
                            sb.append(resource);
                            sb.append("}.");
                            sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                            c(new GlideException(sb.toString()));
                        } else if (m()) {
                            A(resource, obj, dataSource, z2);
                            return;
                        } else {
                            this.f67159s = null;
                            this.f67163w = Status.COMPLETE;
                            GlideTrace.f("GlideRequest", this.f67141a);
                        }
                        this.f67162v.k(resource);
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.f67162v.k(resource2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public void c(GlideException glideException) {
        z(glideException, 5);
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f67144d) {
            try {
                j();
                this.f67143c.c();
                Status status = this.f67163w;
                Status status2 = Status.CLEARED;
                if (status == status2) {
                    return;
                }
                n();
                Resource resource = this.f67159s;
                if (resource != null) {
                    this.f67159s = null;
                } else {
                    resource = null;
                }
                if (k()) {
                    this.f67155o.g(r());
                }
                GlideTrace.f("GlideRequest", this.f67141a);
                this.f67163w = status2;
                if (resource != null) {
                    this.f67162v.k(resource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void d(int i3, int i4) throws Throwable {
        Object obj;
        SingleRequest<R> singleRequest = this;
        singleRequest.f67143c.c();
        Object obj2 = singleRequest.f67144d;
        synchronized (obj2) {
            try {
                try {
                    boolean z2 = E;
                    if (z2) {
                        singleRequest.u("Got onSizeReady in " + LogTime.a(singleRequest.f67161u));
                    }
                    if (singleRequest.f67163w == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        singleRequest.f67163w = status;
                        float fD = singleRequest.f67151k.D();
                        singleRequest.A = v(i3, fD);
                        singleRequest.B = v(i4, fD);
                        if (z2) {
                            singleRequest.u("finished setup for calling load in " + LogTime.a(singleRequest.f67161u));
                        }
                        try {
                            Engine engine = singleRequest.f67162v;
                            GlideContext glideContext = singleRequest.f67148h;
                            try {
                                Object obj3 = singleRequest.f67149i;
                                Key keyB = singleRequest.f67151k.B();
                                try {
                                    int i5 = singleRequest.A;
                                    int i6 = singleRequest.B;
                                    Class clsA = singleRequest.f67151k.A();
                                    Class cls = singleRequest.f67150j;
                                    try {
                                        Priority priority = singleRequest.f67154n;
                                        DiskCacheStrategy diskCacheStrategyO = singleRequest.f67151k.o();
                                        Map mapF = singleRequest.f67151k.F();
                                        boolean zQ = singleRequest.f67151k.Q();
                                        boolean zM = singleRequest.f67151k.M();
                                        Options optionsU = singleRequest.f67151k.u();
                                        boolean zK = singleRequest.f67151k.K();
                                        boolean zH = singleRequest.f67151k.H();
                                        boolean zG = singleRequest.f67151k.G();
                                        boolean zT = singleRequest.f67151k.t();
                                        Executor executor = singleRequest.f67158r;
                                        Object obj4 = obj2;
                                        try {
                                            singleRequest.f67160t = engine.f(glideContext, obj3, keyB, i5, i6, clsA, cls, priority, diskCacheStrategyO, mapF, zQ, zM, optionsU, zK, zH, zG, zT, singleRequest, executor);
                                            if (singleRequest.f67163w != status) {
                                                singleRequest.f67160t = null;
                                            }
                                            if (z2) {
                                                singleRequest.u("finished onSizeReady in " + LogTime.a(singleRequest.f67161u));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            obj = obj4;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        obj = obj2;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj = obj2;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                obj = obj2;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            obj = obj2;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = obj2;
                }
            } catch (Throwable th7) {
                th = th7;
                obj = singleRequest;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean e() {
        boolean z2;
        synchronized (this.f67144d) {
            z2 = this.f67163w == Status.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.ResourceCallback
    public Object f() {
        this.f67143c.c();
        return this.f67144d;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean g() {
        boolean z2;
        synchronized (this.f67144d) {
            z2 = this.f67163w == Status.COMPLETE;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean h(Request request) {
        int i3;
        int i4;
        Object obj;
        Class cls;
        BaseRequestOptions baseRequestOptions;
        Priority priority;
        int size;
        int i5;
        int i6;
        Object obj2;
        Class cls2;
        BaseRequestOptions baseRequestOptions2;
        Priority priority2;
        int size2;
        if (!(request instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f67144d) {
            try {
                i3 = this.f67152l;
                i4 = this.f67153m;
                obj = this.f67149i;
                cls = this.f67150j;
                baseRequestOptions = this.f67151k;
                priority = this.f67154n;
                List list = this.f67156p;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        SingleRequest singleRequest = (SingleRequest) request;
        synchronized (singleRequest.f67144d) {
            try {
                i5 = singleRequest.f67152l;
                i6 = singleRequest.f67153m;
                obj2 = singleRequest.f67149i;
                cls2 = singleRequest.f67150j;
                baseRequestOptions2 = singleRequest.f67151k;
                priority2 = singleRequest.f67154n;
                List list2 = singleRequest.f67156p;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        return i3 == i5 && i4 == i6 && Util.d(obj, obj2) && cls.equals(cls2) && Util.c(baseRequestOptions, baseRequestOptions2) && priority == priority2 && size == size2;
    }

    @Override // com.bumptech.glide.request.Request
    public void i() {
        synchronized (this.f67144d) {
            try {
                j();
                this.f67143c.c();
                this.f67161u = LogTime.b();
                Object obj = this.f67149i;
                if (obj == null) {
                    if (Util.v(this.f67152l, this.f67153m)) {
                        this.A = this.f67152l;
                        this.B = this.f67153m;
                    }
                    z(new GlideException("Received null model"), q() == null ? 5 : 3);
                    return;
                }
                Status status = this.f67163w;
                Status status2 = Status.RUNNING;
                if (status == status2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (status == Status.COMPLETE) {
                    b(this.f67159s, DataSource.MEMORY_CACHE, false);
                    return;
                }
                o(obj);
                this.f67141a = GlideTrace.b("GlideRequest");
                Status status3 = Status.WAITING_FOR_SIZE;
                this.f67163w = status3;
                if (Util.v(this.f67152l, this.f67153m)) {
                    d(this.f67152l, this.f67153m);
                } else {
                    this.f67155o.k(this);
                }
                Status status4 = this.f67163w;
                if ((status4 == status2 || status4 == status3) && l()) {
                    this.f67155o.f(r());
                }
                if (E) {
                    u("finished run method in " + LogTime.a(this.f67161u));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z2;
        synchronized (this.f67144d) {
            try {
                Status status = this.f67163w;
                z2 = status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
            } finally {
            }
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public void pause() {
        synchronized (this.f67144d) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        Object obj;
        Class cls;
        synchronized (this.f67144d) {
            obj = this.f67149i;
            cls = this.f67150j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
