package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingSimpleBasePlayer extends SimpleBasePlayer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Player f40673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LivePositionSuppliers f40674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Metadata f40675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f40676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f40677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f40678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f40679p;

    /* JADX INFO: renamed from: androidx.media3.common.ForwardingSimpleBasePlayer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Player.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Player f40680a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForwardingSimpleBasePlayer f40681b;

        @Override // androidx.media3.common.Player.Listener
        public void P() {
            this.f40681b.f40679p = true;
        }

        @Override // androidx.media3.common.Player.Listener
        public void c0(Player player, Player.Events events) {
            this.f40681b.I1();
        }

        @Override // androidx.media3.common.Player.Listener
        public void s0(boolean z2, int i3) {
            this.f40681b.f40676m = i3;
        }

        @Override // androidx.media3.common.Player.Listener
        public void u(Metadata metadata) {
            this.f40681b.f40675l = metadata;
        }

        @Override // androidx.media3.common.Player.Listener
        public void v0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i3) {
            this.f40681b.f40677n = i3;
            this.f40681b.f40678o = positionInfo2.f40975g;
            this.f40681b.f40674k.a(positionInfo.f40975g, positionInfo.f40976h);
            this.f40681b.f40674k = new LivePositionSuppliers(this.f40680a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class LivePositionSuppliers {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SimpleBasePlayer.LivePositionSupplier f40682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SimpleBasePlayer.LivePositionSupplier f40683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SimpleBasePlayer.LivePositionSupplier f40684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SimpleBasePlayer.LivePositionSupplier f40685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SimpleBasePlayer.LivePositionSupplier f40686e;

        public LivePositionSuppliers(final Player player) {
            Objects.requireNonNull(player);
            this.f40682a = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.common.g
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return player.getCurrentPosition();
                }
            });
            this.f40683b = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.common.h
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return player.Z();
                }
            });
            this.f40684c = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.common.i
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return player.X();
                }
            });
            this.f40685d = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.common.j
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return player.i0();
                }
            });
            this.f40686e = new SimpleBasePlayer.LivePositionSupplier(new SimpleBasePlayer.PositionSupplier() { // from class: androidx.media3.common.k
                @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
                public final long get() {
                    return player.g();
                }
            });
        }

        public void a(long j3, long j4) {
            this.f40682a.e(j3);
            this.f40683b.e(j3);
            this.f40684c.e(j4);
            this.f40685d.e(j4);
            this.f40686e.e(0L);
        }
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected SimpleBasePlayer.State C1() {
        SimpleBasePlayer.State.Builder builder = new SimpleBasePlayer.State.Builder();
        LivePositionSuppliers livePositionSuppliers = this.f40674k;
        if (this.f40673j.y(16)) {
            builder.S(livePositionSuppliers.f40683b);
            builder.T(livePositionSuppliers.f40682a);
        }
        if (this.f40673j.y(21)) {
            builder.U(this.f40673j.Q());
        }
        builder.V(this.f40673j.K());
        if (this.f40673j.y(16)) {
            builder.W(livePositionSuppliers.f40685d);
            builder.Y(livePositionSuppliers.f40684c);
            if (this.f40673j.y(17)) {
                builder.Z(this.f40673j.x(), this.f40673j.T());
            }
        }
        if (this.f40673j.y(28)) {
            builder.a0(this.f40673j.u());
        }
        if (this.f40673j.y(17)) {
            builder.b0(this.f40673j.f0());
        }
        builder.c0(this.f40673j.R());
        if (this.f40673j.y(23)) {
            builder.d0(this.f40673j.I());
            builder.e0(this.f40673j.g0());
        }
        builder.f0(this.f40673j.a());
        builder.g0(this.f40673j.M());
        if (this.f40679p) {
            builder.h0(true);
            this.f40679p = false;
        }
        builder.j0(this.f40673j.d());
        builder.k0(this.f40673j.p());
        builder.l0(this.f40673j.C());
        builder.m0(this.f40673j.b());
        if (this.f40673j.y(17)) {
            builder.n0(this.f40673j.E(), this.f40673j.y(30) ? this.f40673j.s() : Tracks.f41239b, this.f40673j.y(18) ? this.f40673j.m0() : null);
        }
        if (this.f40673j.y(18)) {
            builder.p0(this.f40673j.c0());
        }
        builder.i0(this.f40673j.L(), this.f40676m);
        long j3 = this.f40678o;
        if (j3 != -9223372036854775807L) {
            builder.q0(this.f40677n, j3);
            this.f40678o = -9223372036854775807L;
        }
        builder.r0(this.f40673j.D());
        builder.s0(this.f40673j.o0());
        builder.t0(this.f40673j.V());
        builder.u0(this.f40673j.h0());
        builder.v0(this.f40673j.l());
        builder.w0(this.f40675l);
        if (this.f40673j.y(16)) {
            builder.x0(livePositionSuppliers.f40686e);
        }
        builder.y0(this.f40673j.G());
        builder.z0(this.f40673j.O());
        if (this.f40673j.y(22)) {
            builder.A0(this.f40673j.getVolume());
        }
        return builder.Q();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected ListenableFuture F1(int i3, long j3, int i4) {
        switch (i4) {
            case 4:
                this.f40673j.j();
                break;
            case 5:
                this.f40673j.v(j3);
                break;
            case 6:
                this.f40673j.i();
                break;
            case 7:
                this.f40673j.m();
                break;
            case 8:
                this.f40673j.r();
                break;
            case 9:
                this.f40673j.H();
                break;
            case 10:
                if (i3 != -1) {
                    this.f40673j.J(i3, j3);
                }
                break;
            case 11:
                this.f40673j.l0();
                break;
            case 12:
                this.f40673j.j0();
                break;
            default:
                throw new IllegalStateException();
        }
        return Futures.g();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected ListenableFuture G1(List list, int i3, long j3) {
        boolean z2 = list.size() == 1 && this.f40673j.y(31);
        if (i3 == -1) {
            if (z2) {
                this.f40673j.o((MediaItem) list.get(0));
            } else {
                this.f40673j.n0(list);
            }
        } else if (z2) {
            this.f40673j.d0((MediaItem) list.get(0), j3);
        } else {
            this.f40673j.U(list, i3, j3);
        }
        return Futures.g();
    }

    @Override // androidx.media3.common.SimpleBasePlayer
    protected ListenableFuture H1(boolean z2) {
        this.f40673j.n(z2);
        return Futures.g();
    }
}
