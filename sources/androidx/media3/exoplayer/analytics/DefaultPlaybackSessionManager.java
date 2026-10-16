package androidx.media3.exoplayer.analytics;

import android.util.Base64;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Supplier f43366i = new Supplier() { // from class: androidx.media3.exoplayer.analytics.u1
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return DefaultPlaybackSessionManager.n();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Random f43367j = new Random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Timeline.Window f43368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Timeline.Period f43369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap f43370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Supplier f43371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PlaybackSessionManager.Listener f43372e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Timeline f43373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f43374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f43375h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SessionDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f43376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f43377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f43378c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MediaSource.MediaPeriodId f43379d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f43380e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f43381f;

        public SessionDescriptor(String str, int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f43376a = str;
            this.f43377b = i3;
            this.f43378c = mediaPeriodId == null ? -1L : mediaPeriodId.f44757d;
            if (mediaPeriodId == null || !mediaPeriodId.c()) {
                return;
            }
            this.f43379d = mediaPeriodId;
        }

        private int l(Timeline timeline, Timeline timeline2, int i3) {
            if (i3 >= timeline.p()) {
                if (i3 < timeline2.p()) {
                    return i3;
                }
                return -1;
            }
            timeline.n(i3, DefaultPlaybackSessionManager.this.f43368a);
            for (int i4 = DefaultPlaybackSessionManager.this.f43368a.f41148n; i4 <= DefaultPlaybackSessionManager.this.f43368a.f41149o; i4++) {
                int iB = timeline2.b(timeline.m(i4));
                if (iB != -1) {
                    return timeline2.f(iB, DefaultPlaybackSessionManager.this.f43369b).f41116c;
                }
            }
            return -1;
        }

        public boolean i(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i3 == this.f43377b;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.f43379d;
            return mediaPeriodId2 == null ? !mediaPeriodId.c() && mediaPeriodId.f44757d == this.f43378c : mediaPeriodId.f44757d == mediaPeriodId2.f44757d && mediaPeriodId.f44755b == mediaPeriodId2.f44755b && mediaPeriodId.f44756c == mediaPeriodId2.f44756c;
        }

        public boolean j(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
            if (mediaPeriodId == null) {
                return this.f43377b != eventTime.f43341c;
            }
            long j3 = this.f43378c;
            if (j3 == -1) {
                return false;
            }
            if (mediaPeriodId.f44757d > j3) {
                return true;
            }
            if (this.f43379d == null) {
                return false;
            }
            int iB = eventTime.f43340b.b(mediaPeriodId.f44754a);
            int iB2 = eventTime.f43340b.b(this.f43379d.f44754a);
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f43342d;
            if (mediaPeriodId2.f44757d < this.f43379d.f44757d || iB < iB2) {
                return false;
            }
            if (iB > iB2) {
                return true;
            }
            if (!mediaPeriodId2.c()) {
                int i3 = eventTime.f43342d.f44758e;
                return i3 == -1 || i3 > this.f43379d.f44755b;
            }
            MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.f43342d;
            int i4 = mediaPeriodId3.f44755b;
            int i5 = mediaPeriodId3.f44756c;
            MediaSource.MediaPeriodId mediaPeriodId4 = this.f43379d;
            int i6 = mediaPeriodId4.f44755b;
            return i4 > i6 || (i4 == i6 && i5 > mediaPeriodId4.f44756c);
        }

        public void k(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.f43378c != -1 || i3 != this.f43377b || mediaPeriodId == null || mediaPeriodId.f44757d < DefaultPlaybackSessionManager.this.o()) {
                return;
            }
            this.f43378c = mediaPeriodId.f44757d;
        }

        public boolean m(Timeline timeline, Timeline timeline2) {
            int iL = l(timeline, timeline2, this.f43377b);
            this.f43377b = iL;
            if (iL == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.f43379d;
            return mediaPeriodId == null || timeline2.b(mediaPeriodId.f44754a) != -1;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(f43366i);
    }

    private void m(SessionDescriptor sessionDescriptor) {
        if (sessionDescriptor.f43378c != -1) {
            this.f43375h = sessionDescriptor.f43378c;
        }
        this.f43374g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String n() {
        byte[] bArr = new byte[12];
        f43367j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long o() {
        SessionDescriptor sessionDescriptor = (SessionDescriptor) this.f43370c.get(this.f43374g);
        return (sessionDescriptor == null || sessionDescriptor.f43378c == -1) ? this.f43375h + 1 : sessionDescriptor.f43378c;
    }

    private SessionDescriptor p(int i3, MediaSource.MediaPeriodId mediaPeriodId) {
        SessionDescriptor sessionDescriptor = null;
        long j3 = Long.MAX_VALUE;
        for (SessionDescriptor sessionDescriptor2 : this.f43370c.values()) {
            sessionDescriptor2.k(i3, mediaPeriodId);
            if (sessionDescriptor2.i(i3, mediaPeriodId)) {
                long j4 = sessionDescriptor2.f43378c;
                if (j4 == -1 || j4 < j3) {
                    sessionDescriptor = sessionDescriptor2;
                    j3 = j4;
                } else if (j4 == j3 && ((SessionDescriptor) Util.k(sessionDescriptor)).f43379d != null && sessionDescriptor2.f43379d != null) {
                    sessionDescriptor = sessionDescriptor2;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = (String) this.f43371d.get();
        SessionDescriptor sessionDescriptor3 = new SessionDescriptor(str, i3, mediaPeriodId);
        this.f43370c.put(str, sessionDescriptor3);
        return sessionDescriptor3;
    }

    private void q(AnalyticsListener.EventTime eventTime) {
        if (eventTime.f43340b.q()) {
            String str = this.f43374g;
            if (str != null) {
                m((SessionDescriptor) Assertions.e((SessionDescriptor) this.f43370c.get(str)));
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor = (SessionDescriptor) this.f43370c.get(this.f43374g);
        SessionDescriptor sessionDescriptorP = p(eventTime.f43341c, eventTime.f43342d);
        this.f43374g = sessionDescriptorP.f43376a;
        a(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
        if (mediaPeriodId == null || !mediaPeriodId.c()) {
            return;
        }
        if (sessionDescriptor != null && sessionDescriptor.f43378c == eventTime.f43342d.f44757d && sessionDescriptor.f43379d != null && sessionDescriptor.f43379d.f44755b == eventTime.f43342d.f44755b && sessionDescriptor.f43379d.f44756c == eventTime.f43342d.f44756c) {
            return;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f43342d;
        this.f43372e.c(eventTime, p(eventTime.f43341c, new MediaSource.MediaPeriodId(mediaPeriodId2.f44754a, mediaPeriodId2.f44757d)).f43376a, sessionDescriptorP.f43376a);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void a(AnalyticsListener.EventTime eventTime) {
        Assertions.e(this.f43372e);
        if (eventTime.f43340b.q()) {
            return;
        }
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f43342d;
        if (mediaPeriodId != null) {
            if (mediaPeriodId.f44757d < o()) {
                return;
            }
            SessionDescriptor sessionDescriptor = (SessionDescriptor) this.f43370c.get(this.f43374g);
            if (sessionDescriptor != null && sessionDescriptor.f43378c == -1 && sessionDescriptor.f43377b != eventTime.f43341c) {
                return;
            }
        }
        SessionDescriptor sessionDescriptorP = p(eventTime.f43341c, eventTime.f43342d);
        if (this.f43374g == null) {
            this.f43374g = sessionDescriptorP.f43376a;
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f43342d;
        if (mediaPeriodId2 != null && mediaPeriodId2.c()) {
            MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.f43342d;
            MediaSource.MediaPeriodId mediaPeriodId4 = new MediaSource.MediaPeriodId(mediaPeriodId3.f44754a, mediaPeriodId3.f44757d, mediaPeriodId3.f44755b);
            SessionDescriptor sessionDescriptorP2 = p(eventTime.f43341c, mediaPeriodId4);
            if (!sessionDescriptorP2.f43380e) {
                sessionDescriptorP2.f43380e = true;
                eventTime.f43340b.h(eventTime.f43342d.f44754a, this.f43369b);
                this.f43372e.y0(new AnalyticsListener.EventTime(eventTime.f43339a, eventTime.f43340b, eventTime.f43341c, mediaPeriodId4, Math.max(0L, Util.t1(this.f43369b.f(eventTime.f43342d.f44755b)) + this.f43369b.n()), eventTime.f43344f, eventTime.f43345g, eventTime.f43346h, eventTime.f43347i, eventTime.f43348j), sessionDescriptorP2.f43376a);
            }
        }
        if (!sessionDescriptorP.f43380e) {
            sessionDescriptorP.f43380e = true;
            this.f43372e.y0(eventTime, sessionDescriptorP.f43376a);
        }
        if (sessionDescriptorP.f43376a.equals(this.f43374g) && !sessionDescriptorP.f43381f) {
            sessionDescriptorP.f43381f = true;
            this.f43372e.B0(eventTime, sessionDescriptorP.f43376a);
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized String b() {
        return this.f43374g;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized String c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return p(timeline.h(mediaPeriodId.f44754a, this.f43369b).f41116c, mediaPeriodId).f43376a;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized boolean d(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = (SessionDescriptor) this.f43370c.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.k(eventTime.f43341c, eventTime.f43342d);
        return sessionDescriptor.i(eventTime.f43341c, eventTime.f43342d);
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void e(AnalyticsListener.EventTime eventTime) {
        try {
            Assertions.e(this.f43372e);
            Timeline timeline = this.f43373f;
            this.f43373f = eventTime.f43340b;
            Iterator it = this.f43370c.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) it.next();
                if (!sessionDescriptor.m(timeline, this.f43373f) || sessionDescriptor.j(eventTime)) {
                    it.remove();
                    if (sessionDescriptor.f43380e) {
                        if (sessionDescriptor.f43376a.equals(this.f43374g)) {
                            m(sessionDescriptor);
                        }
                        this.f43372e.m0(eventTime, sessionDescriptor.f43376a, false);
                    }
                }
            }
            q(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void f(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        try {
            String str = this.f43374g;
            if (str != null) {
                m((SessionDescriptor) Assertions.e((SessionDescriptor) this.f43370c.get(str)));
            }
            Iterator it = this.f43370c.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) it.next();
                it.remove();
                if (sessionDescriptor.f43380e && (listener = this.f43372e) != null) {
                    listener.m0(eventTime, sessionDescriptor.f43376a, false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public void g(PlaybackSessionManager.Listener listener) {
        this.f43372e = listener;
    }

    @Override // androidx.media3.exoplayer.analytics.PlaybackSessionManager
    public synchronized void h(AnalyticsListener.EventTime eventTime, int i3) {
        try {
            Assertions.e(this.f43372e);
            boolean z2 = i3 == 0;
            Iterator it = this.f43370c.values().iterator();
            while (it.hasNext()) {
                SessionDescriptor sessionDescriptor = (SessionDescriptor) it.next();
                if (sessionDescriptor.j(eventTime)) {
                    it.remove();
                    if (sessionDescriptor.f43380e) {
                        boolean zEquals = sessionDescriptor.f43376a.equals(this.f43374g);
                        boolean z3 = z2 && zEquals && sessionDescriptor.f43381f;
                        if (zEquals) {
                            m(sessionDescriptor);
                        }
                        this.f43372e.m0(eventTime, sessionDescriptor.f43376a, z3);
                    }
                }
            }
            q(eventTime);
        } catch (Throwable th) {
            throw th;
        }
    }

    public DefaultPlaybackSessionManager(Supplier supplier) {
        this.f43371d = supplier;
        this.f43368a = new Timeline.Window();
        this.f43369b = new Timeline.Period();
        this.f43370c = new HashMap();
        this.f43373f = Timeline.f41105a;
        this.f43375h = -1L;
    }
}
