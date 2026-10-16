package androidx.media3.common;

import androidx.media3.common.Timeline;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePlayer implements Player {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Timeline.Window f40538a = new Timeline.Window();

    protected BasePlayer() {
    }

    private void A0(long j3, int i3) {
        long currentPosition = getCurrentPosition() + j3;
        long duration = getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        x0(Math.max(currentPosition, 0L), i3);
    }

    private void B0(int i3) {
        int iS0 = s0();
        if (iS0 == -1) {
            u0(i3);
        } else if (iS0 == f0()) {
            v0(i3);
        } else {
            y0(iS0, i3);
        }
    }

    private int t0() {
        int iD = D();
        if (iD == 1) {
            return 0;
        }
        return iD;
    }

    private void u0(int i3) {
        w0(-1, -9223372036854775807L, i3, false);
    }

    private void v0(int i3) {
        w0(f0(), -9223372036854775807L, i3, true);
    }

    private void x0(long j3, int i3) {
        w0(f0(), j3, i3, false);
    }

    private void y0(int i3, int i4) {
        w0(i3, -9223372036854775807L, i4, false);
    }

    private void z0(int i3) {
        int iR0 = r0();
        if (iR0 == -1) {
            u0(i3);
        } else if (iR0 == f0()) {
            v0(i3);
        } else {
            y0(iR0, i3);
        }
    }

    @Override // androidx.media3.common.Player
    public final boolean A() {
        Timeline timelineE = E();
        return !timelineE.q() && timelineE.n(f0(), this.f40538a).f41143i;
    }

    @Override // androidx.media3.common.Player
    public final void H() {
        if (E().q() || f()) {
            u0(9);
            return;
        }
        if (t()) {
            z0(9);
        } else if (p0() && A()) {
            y0(f0(), 9);
        } else {
            u0(9);
        }
    }

    @Override // androidx.media3.common.Player
    public final void J(int i3, long j3) {
        w0(i3, j3, 10, false);
    }

    @Override // androidx.media3.common.Player
    public final boolean S() {
        return s0() != -1;
    }

    @Override // androidx.media3.common.Player
    public final boolean a0() {
        Timeline timelineE = E();
        return !timelineE.q() && timelineE.n(f0(), this.f40538a).f41142h;
    }

    @Override // androidx.media3.common.Player
    public final void d0(MediaItem mediaItem, long j3) {
        U(ImmutableList.z(mediaItem), 0, j3);
    }

    @Override // androidx.media3.common.Player
    public final MediaItem h() {
        Timeline timelineE = E();
        if (timelineE.q()) {
            return null;
        }
        return timelineE.n(f0(), this.f40538a).f41137c;
    }

    @Override // androidx.media3.common.Player
    public final void i() {
        B0(6);
    }

    @Override // androidx.media3.common.Player
    public final void j() {
        y0(f0(), 4);
    }

    @Override // androidx.media3.common.Player
    public final void j0() {
        A0(V(), 12);
    }

    @Override // androidx.media3.common.Player
    public final void l0() {
        A0(-o0(), 11);
    }

    @Override // androidx.media3.common.Player
    public final void m() {
        if (E().q() || f()) {
            u0(7);
            return;
        }
        boolean zS = S();
        if (p0() && !a0()) {
            if (zS) {
                B0(7);
                return;
            } else {
                u0(7);
                return;
            }
        }
        if (!zS || getCurrentPosition() > M()) {
            x0(0L, 7);
        } else {
            B0(7);
        }
    }

    @Override // androidx.media3.common.Player
    public final void n0(List list) {
        k(list, true);
    }

    @Override // androidx.media3.common.Player
    public final void o(MediaItem mediaItem) {
        n0(ImmutableList.z(mediaItem));
    }

    @Override // androidx.media3.common.Player
    public final boolean p0() {
        Timeline timelineE = E();
        return !timelineE.q() && timelineE.n(f0(), this.f40538a).f();
    }

    @Override // androidx.media3.common.Player
    public final void q() {
        n(true);
    }

    public final long q0() {
        Timeline timelineE = E();
        if (timelineE.q()) {
            return -9223372036854775807L;
        }
        return timelineE.n(f0(), this.f40538a).d();
    }

    @Override // androidx.media3.common.Player
    public final void r() {
        z0(8);
    }

    public final int r0() {
        Timeline timelineE = E();
        if (timelineE.q()) {
            return -1;
        }
        return timelineE.e(f0(), t0(), h0());
    }

    public final int s0() {
        Timeline timelineE = E();
        if (timelineE.q()) {
            return -1;
        }
        return timelineE.l(f0(), t0(), h0());
    }

    @Override // androidx.media3.common.Player
    public final boolean t() {
        return r0() != -1;
    }

    @Override // androidx.media3.common.Player
    public final void v(long j3) {
        x0(j3, 5);
    }

    protected abstract void w0(int i3, long j3, int i4, boolean z2);

    @Override // androidx.media3.common.Player
    public final boolean y(int i3) {
        return K().b(i3);
    }
}
