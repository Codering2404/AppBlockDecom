package androidx.media3.exoplayer.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f43974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExoMediaDrm f43975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProvisioningManager f43976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceCountListener f43977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f43978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f43979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f43980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final HashMap f43981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CopyOnWriteMultiset f43982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f43983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PlayerId f43984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MediaDrmCallback f43985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final UUID f43986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Looper f43987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ResponseHandler f43988o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f43989p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f43990q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private HandlerThread f43991r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private RequestHandler f43992s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private CryptoConfig f43993t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private DrmSession.DrmSessionException f43994u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte[] f43995v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private byte[] f43996w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ExoMediaDrm.KeyRequest f43997x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ExoMediaDrm.ProvisionRequest f43998y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProvisioningManager {
        void a(Exception exc, boolean z2);

        void b();

        void c(DefaultDrmSession defaultDrmSession);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ReferenceCountListener {
        void a(DefaultDrmSession defaultDrmSession, int i3);

        void b(DefaultDrmSession defaultDrmSession, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class RequestHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f43999a;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.f44002b) {
                return false;
            }
            int i3 = requestTask.f44005e + 1;
            requestTask.f44005e = i3;
            if (i3 > DefaultDrmSession.this.f43983j.b(3)) {
                return false;
            }
            long jA = DefaultDrmSession.this.f43983j.a(new LoadErrorHandlingPolicy.LoadErrorInfo(new LoadEventInfo(requestTask.f44001a, mediaDrmCallbackException.f44083a, mediaDrmCallbackException.f44084b, mediaDrmCallbackException.f44085c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.f44003c, mediaDrmCallbackException.f44086d), new MediaLoadData(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), requestTask.f44005e));
            if (jA == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f43999a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), jA);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b(int i3, Object obj, boolean z2) {
            obtainMessage(i3, new RequestTask(LoadEventInfo.a(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f43999a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objB;
            RequestTask requestTask = (RequestTask) message.obj;
            try {
                int i3 = message.what;
                if (i3 == 1) {
                    objB = DefaultDrmSession.this.f43985l.b(DefaultDrmSession.this.f43986m, (ExoMediaDrm.ProvisionRequest) requestTask.f44004d);
                } else {
                    if (i3 != 2) {
                        throw new RuntimeException();
                    }
                    objB = DefaultDrmSession.this.f43985l.a(DefaultDrmSession.this.f43986m, (ExoMediaDrm.KeyRequest) requestTask.f44004d);
                }
            } catch (MediaDrmCallbackException e3) {
                boolean zA = a(message, e3);
                objB = e3;
                if (zA) {
                    return;
                }
            } catch (Exception e4) {
                Log.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e4);
                objB = e4;
            }
            DefaultDrmSession.this.f43983j.c(requestTask.f44001a);
            synchronized (this) {
                try {
                    if (!this.f43999a) {
                        DefaultDrmSession.this.f43988o.obtainMessage(message.what, Pair.create(requestTask.f44004d, objB)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class RequestTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f44001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f44002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f44003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f44004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f44005e;

        public RequestTask(long j3, boolean z2, long j4, Object obj) {
            this.f44001a = j3;
            this.f44002b = z2;
            this.f44003c = j4;
            this.f44004d = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i3 = message.what;
            if (i3 == 1) {
                DefaultDrmSession.this.C(obj, obj2);
            } else {
                if (i3 != 2) {
                    return;
                }
                DefaultDrmSession.this.w(obj, obj2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, List list, int i3, boolean z2, boolean z3, byte[] bArr, HashMap map, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy, PlayerId playerId) {
        if (i3 == 1 || i3 == 3) {
            Assertions.e(bArr);
        }
        this.f43986m = uuid;
        this.f43976c = provisioningManager;
        this.f43977d = referenceCountListener;
        this.f43975b = exoMediaDrm;
        this.f43978e = i3;
        this.f43979f = z2;
        this.f43980g = z3;
        if (bArr != null) {
            this.f43996w = bArr;
            this.f43974a = null;
        } else {
            this.f43974a = Collections.unmodifiableList((List) Assertions.e(list));
        }
        this.f43981h = map;
        this.f43985l = mediaDrmCallback;
        this.f43982i = new CopyOnWriteMultiset();
        this.f43983j = loadErrorHandlingPolicy;
        this.f43984k = playerId;
        this.f43989p = 2;
        this.f43987n = looper;
        this.f43988o = new ResponseHandler(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj, Object obj2) {
        if (obj == this.f43998y) {
            if (this.f43989p == 2 || u()) {
                this.f43998y = null;
                if (obj2 instanceof Exception) {
                    this.f43976c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f43975b.f((byte[]) obj2);
                    this.f43976c.b();
                } catch (Exception e3) {
                    this.f43976c.a(e3, true);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean D() {
        /*
            r4 = this;
            boolean r0 = r4.u()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            androidx.media3.exoplayer.drm.ExoMediaDrm r0 = r4.f43975b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r0 = r0.d()     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.f43995v = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.ExoMediaDrm r2 = r4.f43975b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.analytics.PlayerId r3 = r4.f43984k     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r2.n(r0, r3)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.ExoMediaDrm r0 = r4.f43975b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r2 = r4.f43995v     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.decoder.CryptoConfig r0 = r0.h(r2)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.f43993t = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r0 = 3
            r4.f43989p = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.a r2 = new androidx.media3.exoplayer.drm.a     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r2.<init>()     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.q(r2)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r0 = r4.f43995v     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.common.util.Assertions.e(r0)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            return r1
        L32:
            r0 = move-exception
            goto L35
        L34:
            r0 = move-exception
        L35:
            boolean r2 = androidx.media3.exoplayer.drm.DrmUtil.d(r0)
            if (r2 == 0) goto L41
            androidx.media3.exoplayer.drm.DefaultDrmSession$ProvisioningManager r0 = r4.f43976c
            r0.c(r4)
            goto L4a
        L41:
            r4.v(r0, r1)
            goto L4a
        L45:
            androidx.media3.exoplayer.drm.DefaultDrmSession$ProvisioningManager r0 = r4.f43976c
            r0.c(r4)
        L4a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.D():boolean");
    }

    private void E(byte[] bArr, int i3, boolean z2) {
        try {
            this.f43997x = this.f43975b.m(bArr, this.f43974a, i3, this.f43981h);
            ((RequestHandler) Util.k(this.f43992s)).b(2, Assertions.e(this.f43997x), z2);
        } catch (Exception | NoSuchMethodError e3) {
            x(e3, true);
        }
    }

    private boolean G() {
        try {
            this.f43975b.e(this.f43995v, this.f43996w);
            return true;
        } catch (Exception | NoSuchMethodError e3) {
            v(e3, 1);
            return false;
        }
    }

    private void H() {
        if (Thread.currentThread() != this.f43987n.getThread()) {
            Log.j("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f43987n.getThread().getName(), new IllegalStateException());
        }
    }

    private void q(Consumer consumer) {
        Iterator it = this.f43982i.i().iterator();
        while (it.hasNext()) {
            consumer.accept((DrmSessionEventListener.EventDispatcher) it.next());
        }
    }

    private void r(boolean z2) {
        if (this.f43980g) {
            return;
        }
        byte[] bArr = (byte[]) Util.k(this.f43995v);
        int i3 = this.f43978e;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                if (this.f43996w == null || G()) {
                    E(bArr, 2, z2);
                    return;
                }
                return;
            }
            if (i3 != 3) {
                return;
            }
            Assertions.e(this.f43996w);
            Assertions.e(this.f43995v);
            E(this.f43996w, 3, z2);
            return;
        }
        if (this.f43996w == null) {
            E(bArr, 1, z2);
            return;
        }
        if (this.f43989p == 4 || G()) {
            long jS = s();
            if (this.f43978e != 0 || jS > 60) {
                if (jS <= 0) {
                    v(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f43989p = 4;
                    q(new Consumer() { // from class: androidx.media3.exoplayer.drm.e
                        @Override // androidx.media3.common.util.Consumer
                        public final void accept(Object obj) {
                            ((DrmSessionEventListener.EventDispatcher) obj).j();
                        }
                    });
                    return;
                }
            }
            Log.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jS);
            E(bArr, 2, z2);
        }
    }

    private long s() {
        if (!C.f40544d.equals(this.f43986m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.e(WidevineUtil.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private boolean u() {
        int i3 = this.f43989p;
        return i3 == 3 || i3 == 4;
    }

    private void v(final Throwable th, int i3) {
        this.f43994u = new DrmSession.DrmSessionException(th, DrmUtil.b(th, i3));
        Log.e("DefaultDrmSession", "DRM session error", th);
        if (th instanceof Exception) {
            q(new Consumer() { // from class: androidx.media3.exoplayer.drm.d
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    ((DrmSessionEventListener.EventDispatcher) obj).l((Exception) th);
                }
            });
        } else {
            if (!(th instanceof Error)) {
                throw new IllegalStateException("Unexpected Throwable subclass", th);
            }
            if (!DrmUtil.e(th) && !DrmUtil.d(th)) {
                throw ((Error) th);
            }
        }
        if (this.f43989p != 4) {
            this.f43989p = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj, Object obj2) {
        if (obj == this.f43997x && u()) {
            this.f43997x = null;
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                x((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f43978e == 3) {
                    this.f43975b.k((byte[]) Util.k(this.f43996w), bArr);
                    q(new Consumer() { // from class: androidx.media3.exoplayer.drm.b
                        @Override // androidx.media3.common.util.Consumer
                        public final void accept(Object obj3) {
                            ((DrmSessionEventListener.EventDispatcher) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrK = this.f43975b.k(this.f43995v, bArr);
                int i3 = this.f43978e;
                if ((i3 == 2 || (i3 == 0 && this.f43996w != null)) && bArrK != null && bArrK.length != 0) {
                    this.f43996w = bArrK;
                }
                this.f43989p = 4;
                q(new Consumer() { // from class: androidx.media3.exoplayer.drm.c
                    @Override // androidx.media3.common.util.Consumer
                    public final void accept(Object obj3) {
                        ((DrmSessionEventListener.EventDispatcher) obj3).h();
                    }
                });
            } catch (Exception e3) {
                e = e3;
                x(e, true);
            } catch (NoSuchMethodError e4) {
                e = e4;
                x(e, true);
            }
        }
    }

    private void x(Throwable th, boolean z2) {
        if ((th instanceof NotProvisionedException) || DrmUtil.d(th)) {
            this.f43976c.c(this);
        } else {
            v(th, z2 ? 1 : 2);
        }
    }

    private void y() {
        if (this.f43978e == 0 && this.f43989p == 4) {
            Util.k(this.f43995v);
            r(false);
        }
    }

    void A() {
        if (D()) {
            r(true);
        }
    }

    void B(Exception exc, boolean z2) {
        v(exc, z2 ? 1 : 3);
    }

    void F() {
        this.f43998y = this.f43975b.c();
        ((RequestHandler) Util.k(this.f43992s)).b(1, Assertions.e(this.f43998y), true);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        H();
        return this.f43986m;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean b() {
        H();
        return this.f43979f;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final CryptoConfig d() {
        H();
        return this.f43993t;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void e(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        H();
        if (this.f43990q < 0) {
            Log.d("DefaultDrmSession", "Session reference count less than zero: " + this.f43990q);
            this.f43990q = 0;
        }
        if (eventDispatcher != null) {
            this.f43982i.a(eventDispatcher);
        }
        int i3 = this.f43990q + 1;
        this.f43990q = i3;
        if (i3 == 1) {
            Assertions.g(this.f43989p == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f43991r = handlerThread;
            handlerThread.start();
            this.f43992s = new RequestHandler(this.f43991r.getLooper());
            if (D()) {
                r(true);
            }
        } else if (eventDispatcher != null && u() && this.f43982i.Y1(eventDispatcher) == 1) {
            eventDispatcher.k(this.f43989p);
        }
        this.f43977d.a(this, this.f43990q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public Map f() {
        H();
        byte[] bArr = this.f43995v;
        if (bArr == null) {
            return null;
        }
        return this.f43975b.b(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void g(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        H();
        int i3 = this.f43990q;
        if (i3 <= 0) {
            Log.d("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i4 = i3 - 1;
        this.f43990q = i4;
        if (i4 == 0) {
            this.f43989p = 0;
            ((ResponseHandler) Util.k(this.f43988o)).removeCallbacksAndMessages(null);
            ((RequestHandler) Util.k(this.f43992s)).c();
            this.f43992s = null;
            ((HandlerThread) Util.k(this.f43991r)).quit();
            this.f43991r = null;
            this.f43993t = null;
            this.f43994u = null;
            this.f43997x = null;
            this.f43998y = null;
            byte[] bArr = this.f43995v;
            if (bArr != null) {
                this.f43975b.j(bArr);
                this.f43995v = null;
            }
        }
        if (eventDispatcher != null) {
            this.f43982i.b(eventDispatcher);
            if (this.f43982i.Y1(eventDispatcher) == 0) {
                eventDispatcher.m();
            }
        }
        this.f43977d.b(this, this.f43990q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        H();
        if (this.f43989p == 1) {
            return this.f43994u;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        H();
        return this.f43989p;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean h(String str) {
        H();
        return this.f43975b.i((byte[]) Assertions.i(this.f43995v), str);
    }

    public boolean t(byte[] bArr) {
        H();
        return Arrays.equals(this.f43995v, bArr);
    }

    void z(int i3) {
        if (i3 != 2) {
            return;
        }
        y();
    }
}
