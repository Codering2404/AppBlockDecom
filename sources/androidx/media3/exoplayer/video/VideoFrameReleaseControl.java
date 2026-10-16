package androidx.media3.exoplayer.video;

import android.content.Context;
import android.view.Surface;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VideoFrameReleaseControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameTimingEvaluator f45825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VideoFrameReleaseHelper f45826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f45827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f45828d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f45831g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f45834j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f45837m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f45838n;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f45829e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f45830f = -9223372036854775807L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f45832h = -9223372036854775807L;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45833i = -9223372036854775807L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f45835k = 1.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Clock f45836l = Clock.f41485a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameReleaseAction {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FrameReleaseInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f45839a = -9223372036854775807L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f45840b = -9223372036854775807L;

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f45839a = -9223372036854775807L;
            this.f45840b = -9223372036854775807L;
        }

        public long f() {
            return this.f45839a;
        }

        public long g() {
            return this.f45840b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FrameTimingEvaluator {
        boolean A(long j3, long j4);

        boolean C(long j3, long j4, long j5, boolean z2, boolean z3);

        boolean M(long j3, long j4, boolean z2);
    }

    public VideoFrameReleaseControl(Context context, FrameTimingEvaluator frameTimingEvaluator, long j3) {
        this.f45825a = frameTimingEvaluator;
        this.f45827c = j3;
        this.f45826b = new VideoFrameReleaseHelper(context);
    }

    private long b(long j3, long j4, long j5) {
        long j6 = (long) ((j5 - j3) / ((double) this.f45835k));
        return this.f45828d ? j6 - (Util.P0(this.f45836l.a()) - j4) : j6;
    }

    private void f(int i3) {
        this.f45829e = Math.min(this.f45829e, i3);
    }

    private boolean s(long j3, long j4, long j5) {
        if (this.f45833i != -9223372036854775807L && !this.f45834j) {
            return false;
        }
        int i3 = this.f45829e;
        if (i3 == 0) {
            return this.f45828d;
        }
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return j3 >= j5;
        }
        if (i3 == 3) {
            return this.f45828d && this.f45825a.A(j4, Util.P0(this.f45836l.a()) - this.f45831g);
        }
        throw new IllegalStateException();
    }

    public void a() {
        if (this.f45829e == 0) {
            this.f45829e = 1;
        }
    }

    public int c(long j3, long j4, long j5, long j6, boolean z2, boolean z3, FrameReleaseInfo frameReleaseInfo) {
        frameReleaseInfo.h();
        if (this.f45830f == -9223372036854775807L) {
            this.f45830f = j4;
        }
        if (this.f45832h != j3) {
            this.f45826b.h(j3);
            this.f45832h = j3;
        }
        frameReleaseInfo.f45839a = b(j4, j5, j3);
        if (z2 && !z3) {
            return 3;
        }
        if (!this.f45837m) {
            this.f45838n = true;
            if (this.f45825a.C(frameReleaseInfo.f45839a, j4, j5, z3, true)) {
                return 4;
            }
            return (!this.f45828d || frameReleaseInfo.f45839a >= 30000) ? 5 : 3;
        }
        if (s(j4, frameReleaseInfo.f45839a, j6)) {
            return 0;
        }
        if (!this.f45828d || j4 == this.f45830f) {
            return 5;
        }
        long jB = this.f45836l.b();
        frameReleaseInfo.f45840b = this.f45826b.b((frameReleaseInfo.f45839a * 1000) + jB);
        frameReleaseInfo.f45839a = (frameReleaseInfo.f45840b - jB) / 1000;
        boolean z4 = (this.f45833i == -9223372036854775807L || this.f45834j) ? false : true;
        if (this.f45825a.C(frameReleaseInfo.f45839a, j4, j5, z3, z4)) {
            return 4;
        }
        return this.f45825a.M(frameReleaseInfo.f45839a, j5, z3) ? z4 ? 3 : 2 : frameReleaseInfo.f45839a > 50000 ? 5 : 1;
    }

    public boolean d(boolean z2) {
        if (z2 && (this.f45829e == 3 || (!this.f45837m && this.f45838n))) {
            this.f45833i = -9223372036854775807L;
            return true;
        }
        if (this.f45833i == -9223372036854775807L) {
            return false;
        }
        if (this.f45836l.a() < this.f45833i) {
            return true;
        }
        this.f45833i = -9223372036854775807L;
        return false;
    }

    public void e(boolean z2) {
        this.f45834j = z2;
        this.f45833i = this.f45827c > 0 ? this.f45836l.a() + this.f45827c : -9223372036854775807L;
    }

    public void g() {
        f(0);
    }

    public void h(boolean z2) {
        this.f45829e = z2 ? 1 : 0;
    }

    public boolean i() {
        boolean z2 = this.f45829e != 3;
        this.f45829e = 3;
        this.f45831g = Util.P0(this.f45836l.a());
        return z2;
    }

    public void j() {
        f(2);
    }

    public void k() {
        this.f45828d = true;
        this.f45831g = Util.P0(this.f45836l.a());
        this.f45826b.k();
    }

    public void l() {
        this.f45828d = false;
        this.f45833i = -9223372036854775807L;
        this.f45826b.l();
    }

    public void m() {
        this.f45826b.j();
        this.f45832h = -9223372036854775807L;
        this.f45830f = -9223372036854775807L;
        f(1);
        this.f45833i = -9223372036854775807L;
    }

    public void n(int i3) {
        this.f45826b.o(i3);
    }

    public void o(Clock clock) {
        this.f45836l = clock;
    }

    public void p(float f3) {
        this.f45826b.g(f3);
    }

    public void q(Surface surface) {
        this.f45837m = surface != null;
        this.f45838n = false;
        this.f45826b.m(surface);
        f(1);
    }

    public void r(float f3) {
        Assertions.a(f3 > 0.0f);
        if (f3 == this.f45835k) {
            return;
        }
        this.f45835k = f3;
        this.f45826b.i(f3);
    }
}
