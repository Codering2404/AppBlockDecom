package androidx.media3.exoplayer;

import android.os.Looper;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PlayerMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Target f43258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Sender f43259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f43260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Timeline f43261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f43263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Looper f43264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f43266i = -9223372036854775807L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43267j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43268k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f43269l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f43270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f43271n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Sender {
        void f(PlayerMessage playerMessage);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Target {
        void w(int i3, Object obj);
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i3, Clock clock, Looper looper) {
        this.f43259b = sender;
        this.f43258a = target;
        this.f43261d = timeline;
        this.f43264g = looper;
        this.f43260c = clock;
        this.f43265h = i3;
    }

    public boolean a() {
        return this.f43267j;
    }

    public Looper b() {
        return this.f43264g;
    }

    public int c() {
        return this.f43265h;
    }

    public Object d() {
        return this.f43263f;
    }

    public long e() {
        return this.f43266i;
    }

    public Target f() {
        return this.f43258a;
    }

    public Timeline g() {
        return this.f43261d;
    }

    public int h() {
        return this.f43262e;
    }

    public synchronized boolean i() {
        return this.f43271n;
    }

    public synchronized void j(boolean z2) {
        this.f43269l = z2 | this.f43269l;
        this.f43270m = true;
        notifyAll();
    }

    public PlayerMessage k() {
        Assertions.g(!this.f43268k);
        if (this.f43266i == -9223372036854775807L) {
            Assertions.a(this.f43267j);
        }
        this.f43268k = true;
        this.f43259b.f(this);
        return this;
    }

    public PlayerMessage l(Object obj) {
        Assertions.g(!this.f43268k);
        this.f43263f = obj;
        return this;
    }

    public PlayerMessage m(int i3) {
        Assertions.g(!this.f43268k);
        this.f43262e = i3;
        return this;
    }
}
