package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingPlayer implements Player {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Player f40670a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ForwardingListener implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ForwardingPlayer f40671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Player.Listener f40672b;

        @Override // androidx.media3.common.Player.Listener
        public void B(int i3) {
            this.f40672b.B(i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void C(boolean z2) {
            this.f40672b.b0(z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void F(int i3) {
            this.f40672b.F(i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void G(int i3) {
            this.f40672b.G(i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void J(boolean z2) {
            this.f40672b.J(z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void K(int i3, boolean z2) {
            this.f40672b.K(i3, z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void L(long j3) {
            this.f40672b.L(j3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void M(MediaMetadata mediaMetadata) {
            this.f40672b.M(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void O(TrackSelectionParameters trackSelectionParameters) {
            this.f40672b.O(trackSelectionParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public void P() {
            this.f40672b.P();
        }

        @Override // androidx.media3.common.Player.Listener
        public void Q(MediaItem mediaItem, int i3) {
            this.f40672b.Q(mediaItem, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void T(PlaybackException playbackException) {
            this.f40672b.T(playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public void V(int i3, int i4) {
            this.f40672b.V(i3, i4);
        }

        @Override // androidx.media3.common.Player.Listener
        public void W(Player.Commands commands) {
            this.f40672b.W(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public void a0(int i3) {
            this.f40672b.a0(i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void b(VideoSize videoSize) {
            this.f40672b.b(videoSize);
        }

        @Override // androidx.media3.common.Player.Listener
        public void b0(boolean z2) {
            this.f40672b.b0(z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void c0(Player player, Player.Events events) {
            this.f40672b.c0(this.f40671a, events);
        }

        @Override // androidx.media3.common.Player.Listener
        public void d(boolean z2) {
            this.f40672b.d(z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void e0(float f3) {
            this.f40672b.e0(f3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (this.f40671a.equals(forwardingListener.f40671a)) {
                return this.f40672b.equals(forwardingListener.f40672b);
            }
            return false;
        }

        @Override // androidx.media3.common.Player.Listener
        public void f0(AudioAttributes audioAttributes) {
            this.f40672b.f0(audioAttributes);
        }

        public int hashCode() {
            return (this.f40671a.hashCode() * 31) + this.f40672b.hashCode();
        }

        @Override // androidx.media3.common.Player.Listener
        public void j(PlaybackParameters playbackParameters) {
            this.f40672b.j(playbackParameters);
        }

        @Override // androidx.media3.common.Player.Listener
        public void j0(Timeline timeline, int i3) {
            this.f40672b.j0(timeline, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void l0(boolean z2, int i3) {
            this.f40672b.l0(z2, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void m(List list) {
            this.f40672b.m(list);
        }

        @Override // androidx.media3.common.Player.Listener
        public void m0(MediaMetadata mediaMetadata) {
            this.f40672b.m0(mediaMetadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void n0(long j3) {
            this.f40672b.n0(j3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void o0(Tracks tracks) {
            this.f40672b.o0(tracks);
        }

        @Override // androidx.media3.common.Player.Listener
        public void p0(DeviceInfo deviceInfo) {
            this.f40672b.p0(deviceInfo);
        }

        @Override // androidx.media3.common.Player.Listener
        public void q0(PlaybackException playbackException) {
            this.f40672b.q0(playbackException);
        }

        @Override // androidx.media3.common.Player.Listener
        public void r0(long j3) {
            this.f40672b.r0(j3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void s0(boolean z2, int i3) {
            this.f40672b.s0(z2, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void t(CueGroup cueGroup) {
            this.f40672b.t(cueGroup);
        }

        @Override // androidx.media3.common.Player.Listener
        public void u(Metadata metadata) {
            this.f40672b.u(metadata);
        }

        @Override // androidx.media3.common.Player.Listener
        public void v0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
            this.f40672b.v0(positionInfo, positionInfo2, i3);
        }

        @Override // androidx.media3.common.Player.Listener
        public void w0(boolean z2) {
            this.f40672b.w0(z2);
        }

        @Override // androidx.media3.common.Player.Listener
        public void z(int i3) {
            this.f40672b.z(i3);
        }
    }

    @Override // androidx.media3.common.Player
    public boolean A() {
        return this.f40670a.A();
    }

    @Override // androidx.media3.common.Player
    public int C() {
        return this.f40670a.C();
    }

    @Override // androidx.media3.common.Player
    public int D() {
        return this.f40670a.D();
    }

    @Override // androidx.media3.common.Player
    public Timeline E() {
        return this.f40670a.E();
    }

    @Override // androidx.media3.common.Player
    public TrackSelectionParameters G() {
        return this.f40670a.G();
    }

    @Override // androidx.media3.common.Player
    public void H() {
        this.f40670a.H();
    }

    @Override // androidx.media3.common.Player
    public int I() {
        return this.f40670a.I();
    }

    @Override // androidx.media3.common.Player
    public void J(int i3, long j3) {
        this.f40670a.J(i3, j3);
    }

    @Override // androidx.media3.common.Player
    public Player.Commands K() {
        return this.f40670a.K();
    }

    @Override // androidx.media3.common.Player
    public boolean L() {
        return this.f40670a.L();
    }

    @Override // androidx.media3.common.Player
    public long M() {
        return this.f40670a.M();
    }

    @Override // androidx.media3.common.Player
    public int N() {
        return this.f40670a.N();
    }

    @Override // androidx.media3.common.Player
    public VideoSize O() {
        return this.f40670a.O();
    }

    @Override // androidx.media3.common.Player
    public AudioAttributes Q() {
        return this.f40670a.Q();
    }

    @Override // androidx.media3.common.Player
    public DeviceInfo R() {
        return this.f40670a.R();
    }

    @Override // androidx.media3.common.Player
    public boolean S() {
        return this.f40670a.S();
    }

    @Override // androidx.media3.common.Player
    public int T() {
        return this.f40670a.T();
    }

    @Override // androidx.media3.common.Player
    public void U(List list, int i3, long j3) {
        this.f40670a.U(list, i3, j3);
    }

    @Override // androidx.media3.common.Player
    public long V() {
        return this.f40670a.V();
    }

    @Override // androidx.media3.common.Player
    public long X() {
        return this.f40670a.X();
    }

    @Override // androidx.media3.common.Player
    public long Z() {
        return this.f40670a.Z();
    }

    @Override // androidx.media3.common.Player
    public boolean a() {
        return this.f40670a.a();
    }

    @Override // androidx.media3.common.Player
    public boolean a0() {
        return this.f40670a.a0();
    }

    @Override // androidx.media3.common.Player
    public PlaybackException b() {
        return this.f40670a.b();
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata c0() {
        return this.f40670a.c0();
    }

    @Override // androidx.media3.common.Player
    public PlaybackParameters d() {
        return this.f40670a.d();
    }

    @Override // androidx.media3.common.Player
    public void d0(MediaItem mediaItem, long j3) {
        this.f40670a.d0(mediaItem, j3);
    }

    @Override // androidx.media3.common.Player
    public boolean f() {
        return this.f40670a.f();
    }

    @Override // androidx.media3.common.Player
    public int f0() {
        return this.f40670a.f0();
    }

    @Override // androidx.media3.common.Player
    public long g() {
        return this.f40670a.g();
    }

    @Override // androidx.media3.common.Player
    public boolean g0() {
        return this.f40670a.g0();
    }

    @Override // androidx.media3.common.Player
    public long getCurrentPosition() {
        return this.f40670a.getCurrentPosition();
    }

    @Override // androidx.media3.common.Player
    public float getVolume() {
        return this.f40670a.getVolume();
    }

    @Override // androidx.media3.common.Player
    public boolean h0() {
        return this.f40670a.h0();
    }

    @Override // androidx.media3.common.Player
    public void i() {
        this.f40670a.i();
    }

    @Override // androidx.media3.common.Player
    public long i0() {
        return this.f40670a.i0();
    }

    @Override // androidx.media3.common.Player
    public void j() {
        this.f40670a.j();
    }

    @Override // androidx.media3.common.Player
    public void j0() {
        this.f40670a.j0();
    }

    @Override // androidx.media3.common.Player
    public Size l() {
        return this.f40670a.l();
    }

    @Override // androidx.media3.common.Player
    public void l0() {
        this.f40670a.l0();
    }

    @Override // androidx.media3.common.Player
    public void m() {
        this.f40670a.m();
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata m0() {
        return this.f40670a.m0();
    }

    @Override // androidx.media3.common.Player
    public void n(boolean z2) {
        this.f40670a.n(z2);
    }

    @Override // androidx.media3.common.Player
    public void n0(List list) {
        this.f40670a.n0(list);
    }

    @Override // androidx.media3.common.Player
    public void o(MediaItem mediaItem) {
        this.f40670a.o(mediaItem);
    }

    @Override // androidx.media3.common.Player
    public long o0() {
        return this.f40670a.o0();
    }

    @Override // androidx.media3.common.Player
    public int p() {
        return this.f40670a.p();
    }

    @Override // androidx.media3.common.Player
    public boolean p0() {
        return this.f40670a.p0();
    }

    @Override // androidx.media3.common.Player
    public void r() {
        this.f40670a.r();
    }

    @Override // androidx.media3.common.Player
    public Tracks s() {
        return this.f40670a.s();
    }

    @Override // androidx.media3.common.Player
    public boolean t() {
        return this.f40670a.t();
    }

    @Override // androidx.media3.common.Player
    public CueGroup u() {
        return this.f40670a.u();
    }

    @Override // androidx.media3.common.Player
    public void v(long j3) {
        this.f40670a.v(j3);
    }

    @Override // androidx.media3.common.Player
    public int x() {
        return this.f40670a.x();
    }

    @Override // androidx.media3.common.Player
    public boolean y(int i3) {
        return this.f40670a.y(i3);
    }
}
