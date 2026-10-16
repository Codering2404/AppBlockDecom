package androidx.media3.exoplayer.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.facebook.ads.AdError;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultDrmSessionManager implements DrmSessionManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UUID f44007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExoMediaDrm.Provider f44008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MediaDrmCallback f44009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HashMap f44010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f44011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f44012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f44013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ProvisioningManagerImpl f44014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LoadErrorHandlingPolicy f44015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ReferenceCountListenerImpl f44016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f44017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final List f44018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Set f44019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Set f44020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f44021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ExoMediaDrm f44022q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private DefaultDrmSession f44023r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DefaultDrmSession f44024s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Looper f44025t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Handler f44026u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f44027v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private byte[] f44028w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private PlayerId f44029x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    volatile MediaDrmHandler f44030y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44034d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HashMap f44031a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private UUID f44032b = C.f40544d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ExoMediaDrm.Provider f44033c = FrameworkMediaDrm.f44074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f44035e = new int[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f44036f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private LoadErrorHandlingPolicy f44037g = new DefaultLoadErrorHandlingPolicy();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f44038h = 300000;

        public DefaultDrmSessionManager a(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f44032b, this.f44033c, mediaDrmCallback, this.f44031a, this.f44034d, this.f44035e, this.f44036f, this.f44037g, this.f44038h);
        }

        public Builder b(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f44037g = (LoadErrorHandlingPolicy) Assertions.e(loadErrorHandlingPolicy);
            return this;
        }

        public Builder c(boolean z2) {
            this.f44034d = z2;
            return this;
        }

        public Builder d(boolean z2) {
            this.f44036f = z2;
            return this;
        }

        public Builder e(int... iArr) {
            for (int i3 : iArr) {
                boolean z2 = true;
                if (i3 != 2 && i3 != 1) {
                    z2 = false;
                }
                Assertions.a(z2);
            }
            this.f44035e = (int[]) iArr.clone();
            return this;
        }

        public Builder f(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f44032b = (UUID) Assertions.e(uuid);
            this.f44033c = (ExoMediaDrm.Provider) Assertions.e(provider);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.OnEventListener
        public void a(ExoMediaDrm exoMediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2) {
            ((MediaDrmHandler) Assertions.e(DefaultDrmSessionManager.this.f44030y)).obtainMessage(i3, bArr).sendToTarget();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f44018m) {
                if (defaultDrmSession.t(bArr)) {
                    defaultDrmSession.z(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DrmSessionEventListener.EventDispatcher f44041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private DrmSession f44042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f44043d;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.f44041b = eventDispatcher;
        }

        public static /* synthetic */ void b(PreacquiredSessionReference preacquiredSessionReference, Format format) {
            if (DefaultDrmSessionManager.this.f44021p == 0 || preacquiredSessionReference.f44043d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            preacquiredSessionReference.f44042c = defaultDrmSessionManager.t((Looper) Assertions.e(defaultDrmSessionManager.f44025t), preacquiredSessionReference.f44041b, format, false);
            DefaultDrmSessionManager.this.f44019n.add(preacquiredSessionReference);
        }

        public static /* synthetic */ void c(PreacquiredSessionReference preacquiredSessionReference) {
            if (preacquiredSessionReference.f44043d) {
                return;
            }
            DrmSession drmSession = preacquiredSessionReference.f44042c;
            if (drmSession != null) {
                drmSession.g(preacquiredSessionReference.f44041b);
            }
            DefaultDrmSessionManager.this.f44019n.remove(preacquiredSessionReference);
            preacquiredSessionReference.f44043d = true;
        }

        public void d(final Format format) {
            ((Handler) Assertions.e(DefaultDrmSessionManager.this.f44026u)).post(new Runnable() { // from class: androidx.media3.exoplayer.drm.f
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.PreacquiredSessionReference.b(this.f44093a, format);
                }
            });
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
        public void release() {
            Util.W0((Handler) Assertions.e(DefaultDrmSessionManager.this.f44026u), new Runnable() { // from class: androidx.media3.exoplayer.drm.g
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.PreacquiredSessionReference.c(this.f44095a);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set f44045a = new HashSet();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private DefaultDrmSession f44046b;

        public ProvisioningManagerImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public void a(Exception exc, boolean z2) {
            this.f44046b = null;
            ImmutableList immutableListT = ImmutableList.t(this.f44045a);
            this.f44045a.clear();
            UnmodifiableIterator it = immutableListT.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).B(exc, z2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public void b() {
            this.f44046b = null;
            ImmutableList immutableListT = ImmutableList.t(this.f44045a);
            this.f44045a.clear();
            UnmodifiableIterator it = immutableListT.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).A();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public void c(DefaultDrmSession defaultDrmSession) {
            this.f44045a.add(defaultDrmSession);
            if (this.f44046b != null) {
                return;
            }
            this.f44046b = defaultDrmSession;
            defaultDrmSession.F();
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.f44045a.remove(defaultDrmSession);
            if (this.f44046b == defaultDrmSession) {
                this.f44046b = null;
                if (this.f44045a.isEmpty()) {
                    return;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) this.f44045a.iterator().next();
                this.f44046b = defaultDrmSession2;
                defaultDrmSession2.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        private ReferenceCountListenerImpl() {
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ReferenceCountListener
        public void a(DefaultDrmSession defaultDrmSession, int i3) {
            if (DefaultDrmSessionManager.this.f44017l != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f44020o.remove(defaultDrmSession);
                ((Handler) Assertions.e(DefaultDrmSessionManager.this.f44026u)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ReferenceCountListener
        public void b(final DefaultDrmSession defaultDrmSession, int i3) {
            if (i3 == 1 && DefaultDrmSessionManager.this.f44021p > 0 && DefaultDrmSessionManager.this.f44017l != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f44020o.add(defaultDrmSession);
                ((Handler) Assertions.e(DefaultDrmSessionManager.this.f44026u)).postAtTime(new Runnable() { // from class: androidx.media3.exoplayer.drm.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.g(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f44017l);
            } else if (i3 == 0) {
                DefaultDrmSessionManager.this.f44018m.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f44023r == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f44023r = null;
                }
                if (DefaultDrmSessionManager.this.f44024s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f44024s = null;
                }
                DefaultDrmSessionManager.this.f44014i.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f44017l != -9223372036854775807L) {
                    ((Handler) Assertions.e(DefaultDrmSessionManager.this.f44026u)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f44020o.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.C();
        }
    }

    private DrmSession A(int i3, boolean z2) {
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.e(this.f44022q);
        if ((exoMediaDrm.g() == 2 && FrameworkCryptoConfig.f44070d) || Util.J0(this.f44012g, i3) == -1 || exoMediaDrm.g() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f44023r;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionX = x(ImmutableList.y(), true, null, z2);
            this.f44018m.add(defaultDrmSessionX);
            this.f44023r = defaultDrmSessionX;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f44023r;
    }

    private void B(Looper looper) {
        if (this.f44030y == null) {
            this.f44030y = new MediaDrmHandler(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (this.f44022q != null && this.f44021p == 0 && this.f44018m.isEmpty() && this.f44019n.isEmpty()) {
            ((ExoMediaDrm) Assertions.e(this.f44022q)).release();
            this.f44022q = null;
        }
    }

    private void D() {
        UnmodifiableIterator it = ImmutableSet.u(this.f44020o).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).g(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void E() {
        UnmodifiableIterator it = ImmutableSet.u(this.f44019n).iterator();
        while (it.hasNext()) {
            ((PreacquiredSessionReference) it.next()).release();
        }
    }

    private void G(DrmSession drmSession, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.g(eventDispatcher);
        if (this.f44017l != -9223372036854775807L) {
            drmSession.g(null);
        }
    }

    private void H(boolean z2) {
        if (z2 && this.f44025t == null) {
            Log.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) Assertions.e(this.f44025t)).getThread()) {
            Log.j("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f44025t.getThread().getName(), new IllegalStateException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public DrmSession t(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z2) {
        List listY;
        B(looper);
        DrmInitData drmInitData = format.f40636s;
        if (drmInitData == null) {
            return A(MimeTypes.k(format.f40632o), z2);
        }
        DefaultDrmSession defaultDrmSession = null;
        Object[] objArr = 0;
        if (this.f44028w == null) {
            listY = y((DrmInitData) Assertions.e(drmInitData), this.f44007b, false);
            if (listY.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f44007b);
                Log.e("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.l(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, AdError.AD_ASSETS_UNSUPPORTED_TYPE_ERROR_CODE));
            }
        } else {
            listY = null;
        }
        if (this.f44011f) {
            Iterator it = this.f44018m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) it.next();
                if (Objects.equals(defaultDrmSession2.f43974a, listY)) {
                    defaultDrmSession = defaultDrmSession2;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f44024s;
        }
        if (defaultDrmSession != null) {
            defaultDrmSession.e(eventDispatcher);
            return defaultDrmSession;
        }
        DefaultDrmSession defaultDrmSessionX = x(listY, false, eventDispatcher, z2);
        if (!this.f44011f) {
            this.f44024s = defaultDrmSessionX;
        }
        this.f44018m.add(defaultDrmSessionX);
        return defaultDrmSessionX;
    }

    private static boolean u(DrmSession drmSession) {
        if (drmSession.getState() != 1) {
            return false;
        }
        Throwable cause = ((DrmSession.DrmSessionException) Assertions.e(drmSession.getError())).getCause();
        return (cause instanceof ResourceBusyException) || DrmUtil.e(cause);
    }

    private boolean v(DrmInitData drmInitData) {
        if (this.f44028w != null) {
            return true;
        }
        if (y(drmInitData, this.f44007b, true).isEmpty()) {
            if (drmInitData.f40584d != 1 || !drmInitData.f(0).d(C.f40542b)) {
                return false;
            }
            Log.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f44007b);
        }
        String str = drmInitData.f40583c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? Util.f41609a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private DefaultDrmSession w(List list, boolean z2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.e(this.f44022q);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f44007b, this.f44022q, this.f44014i, this.f44016k, list, this.f44027v, this.f44013h | z2, z2, this.f44028w, this.f44010e, this.f44009d, (Looper) Assertions.e(this.f44025t), this.f44015j, (PlayerId) Assertions.e(this.f44029x));
        defaultDrmSession.e(eventDispatcher);
        if (this.f44017l != -9223372036854775807L) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession x(List list, boolean z2, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z3) {
        DefaultDrmSession defaultDrmSessionW = w(list, z2, eventDispatcher);
        if (u(defaultDrmSessionW) && !this.f44020o.isEmpty()) {
            D();
            G(defaultDrmSessionW, eventDispatcher);
            defaultDrmSessionW = w(list, z2, eventDispatcher);
        }
        if (!u(defaultDrmSessionW) || !z3 || this.f44019n.isEmpty()) {
            return defaultDrmSessionW;
        }
        E();
        if (!this.f44020o.isEmpty()) {
            D();
        }
        G(defaultDrmSessionW, eventDispatcher);
        return w(list, z2, eventDispatcher);
    }

    private static List y(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.f40584d);
        for (int i3 = 0; i3 < drmInitData.f40584d; i3++) {
            DrmInitData.SchemeData schemeDataF = drmInitData.f(i3);
            if ((schemeDataF.d(uuid) || (C.f40543c.equals(uuid) && schemeDataF.d(C.f40542b))) && (schemeDataF.f40589f != null || z2)) {
                arrayList.add(schemeDataF);
            }
        }
        return arrayList;
    }

    private synchronized void z(Looper looper) {
        try {
            Looper looper2 = this.f44025t;
            if (looper2 == null) {
                this.f44025t = looper;
                this.f44026u = new Handler(looper);
            } else {
                Assertions.g(looper2 == looper);
                Assertions.e(this.f44026u);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void F(int i3, byte[] bArr) {
        Assertions.g(this.f44018m.isEmpty());
        if (i3 == 1 || i3 == 3) {
            Assertions.e(bArr);
        }
        this.f44027v = i3;
        this.f44028w = bArr;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public void a(Looper looper, PlayerId playerId) {
        z(looper);
        this.f44029x = playerId;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        H(false);
        Assertions.g(this.f44021p > 0);
        Assertions.i(this.f44025t);
        return t(this.f44025t, eventDispatcher, format, true);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public int c(Format format) {
        H(false);
        int iG = ((ExoMediaDrm) Assertions.e(this.f44022q)).g();
        DrmInitData drmInitData = format.f40636s;
        if (drmInitData == null) {
            if (Util.J0(this.f44012g, MimeTypes.k(format.f40632o)) == -1) {
                return 0;
            }
        } else if (!v(drmInitData)) {
            return 1;
        }
        return iG;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public DrmSessionManager.DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        Assertions.g(this.f44021p > 0);
        Assertions.i(this.f44025t);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        preacquiredSessionReference.d(format);
        return preacquiredSessionReference;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void e() {
        H(true);
        int i3 = this.f44021p;
        this.f44021p = i3 + 1;
        if (i3 != 0) {
            return;
        }
        if (this.f44022q == null) {
            ExoMediaDrm exoMediaDrmA = this.f44008c.a(this.f44007b);
            this.f44022q = exoMediaDrmA;
            exoMediaDrmA.l(new MediaDrmEventListener());
        } else if (this.f44017l != -9223372036854775807L) {
            for (int i4 = 0; i4 < this.f44018m.size(); i4++) {
                ((DefaultDrmSession) this.f44018m.get(i4)).e(null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void release() {
        H(true);
        int i3 = this.f44021p - 1;
        this.f44021p = i3;
        if (i3 != 0) {
            return;
        }
        if (this.f44017l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f44018m);
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                ((DefaultDrmSession) arrayList.get(i4)).g(null);
            }
        }
        E();
        C();
    }

    private DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap map, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j3) {
        Assertions.e(uuid);
        Assertions.b(!C.f40542b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f44007b = uuid;
        this.f44008c = provider;
        this.f44009d = mediaDrmCallback;
        this.f44010e = map;
        this.f44011f = z2;
        this.f44012g = iArr;
        this.f44013h = z3;
        this.f44015j = loadErrorHandlingPolicy;
        this.f44014i = new ProvisioningManagerImpl();
        this.f44016k = new ReferenceCountListenerImpl();
        this.f44027v = 0;
        this.f44018m = new ArrayList();
        this.f44019n = Sets.k();
        this.f44020o = Sets.k();
        this.f44017l = j3;
    }
}
