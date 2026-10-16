package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Size;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExoPlayerImpl f43303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConditionVariable f43304c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Builder {
    }

    private void C0() {
        this.f43304c.c();
    }

    @Override // androidx.media3.common.Player
    public void B(Player.Listener listener) {
        C0();
        this.f43303b.B(listener);
    }

    @Override // androidx.media3.common.Player
    public int C() {
        C0();
        return this.f43303b.C();
    }

    @Override // androidx.media3.common.Player
    public int D() {
        C0();
        return this.f43303b.D();
    }

    @Override // androidx.media3.common.Player
    public Timeline E() {
        C0();
        return this.f43303b.E();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public boolean F() {
        return this.f43303b.F();
    }

    @Override // androidx.media3.common.Player
    public TrackSelectionParameters G() {
        C0();
        return this.f43303b.G();
    }

    @Override // androidx.media3.common.Player
    public int I() {
        C0();
        return this.f43303b.I();
    }

    @Override // androidx.media3.common.Player
    public Player.Commands K() {
        C0();
        return this.f43303b.K();
    }

    @Override // androidx.media3.common.Player
    public boolean L() {
        C0();
        return this.f43303b.L();
    }

    @Override // androidx.media3.common.Player
    public long M() {
        C0();
        return this.f43303b.M();
    }

    @Override // androidx.media3.common.Player
    public int N() {
        C0();
        return this.f43303b.N();
    }

    @Override // androidx.media3.common.Player
    public VideoSize O() {
        C0();
        return this.f43303b.O();
    }

    @Override // androidx.media3.common.Player
    public AudioAttributes Q() {
        C0();
        return this.f43303b.Q();
    }

    @Override // androidx.media3.common.Player
    public DeviceInfo R() {
        C0();
        return this.f43303b.R();
    }

    @Override // androidx.media3.common.Player
    public int T() {
        C0();
        return this.f43303b.T();
    }

    @Override // androidx.media3.common.Player
    public void U(List list, int i3, long j3) {
        C0();
        this.f43303b.U(list, i3, j3);
    }

    @Override // androidx.media3.common.Player
    public long V() {
        C0();
        return this.f43303b.V();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public DecoderCounters W() {
        C0();
        return this.f43303b.W();
    }

    @Override // androidx.media3.common.Player
    public long X() {
        C0();
        return this.f43303b.X();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public Format Y() {
        C0();
        return this.f43303b.Y();
    }

    @Override // androidx.media3.common.Player
    public long Z() {
        C0();
        return this.f43303b.Z();
    }

    @Override // androidx.media3.common.Player
    public boolean a() {
        C0();
        return this.f43303b.a();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public Format c() {
        C0();
        return this.f43303b.c();
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata c0() {
        C0();
        return this.f43303b.c0();
    }

    @Override // androidx.media3.common.Player
    public PlaybackParameters d() {
        C0();
        return this.f43303b.d();
    }

    @Override // androidx.media3.common.Player
    public void e() {
        C0();
        this.f43303b.e();
    }

    @Override // androidx.media3.common.Player
    public boolean f() {
        C0();
        return this.f43303b.f();
    }

    @Override // androidx.media3.common.Player
    public int f0() {
        C0();
        return this.f43303b.f0();
    }

    @Override // androidx.media3.common.Player
    public long g() {
        C0();
        return this.f43303b.g();
    }

    @Override // androidx.media3.common.Player
    public boolean g0() {
        C0();
        return this.f43303b.g0();
    }

    @Override // androidx.media3.common.Player
    public long getCurrentPosition() {
        C0();
        return this.f43303b.getCurrentPosition();
    }

    @Override // androidx.media3.common.Player
    public long getDuration() {
        C0();
        return this.f43303b.getDuration();
    }

    @Override // androidx.media3.common.Player
    public float getVolume() {
        C0();
        return this.f43303b.getVolume();
    }

    @Override // androidx.media3.common.Player
    public boolean h0() {
        C0();
        return this.f43303b.h0();
    }

    @Override // androidx.media3.common.Player
    public long i0() {
        C0();
        return this.f43303b.i0();
    }

    @Override // androidx.media3.common.Player
    public void k(List list, boolean z2) {
        C0();
        this.f43303b.k(list, z2);
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public DecoderCounters k0() {
        C0();
        return this.f43303b.k0();
    }

    @Override // androidx.media3.common.Player
    public Size l() {
        C0();
        return this.f43303b.l();
    }

    @Override // androidx.media3.common.Player
    public MediaMetadata m0() {
        C0();
        return this.f43303b.m0();
    }

    @Override // androidx.media3.common.Player
    public void n(boolean z2) {
        C0();
        this.f43303b.n(z2);
    }

    @Override // androidx.media3.common.Player
    public long o0() {
        C0();
        return this.f43303b.o0();
    }

    @Override // androidx.media3.common.Player
    public int p() {
        C0();
        return this.f43303b.p();
    }

    @Override // androidx.media3.exoplayer.ExoPlayer
    public void release() {
        C0();
        this.f43303b.release();
    }

    @Override // androidx.media3.common.Player
    public Tracks s() {
        C0();
        return this.f43303b.s();
    }

    @Override // androidx.media3.common.Player
    public void stop() {
        C0();
        this.f43303b.stop();
    }

    @Override // androidx.media3.common.Player
    public CueGroup u() {
        C0();
        return this.f43303b.u();
    }

    @Override // androidx.media3.common.BasePlayer
    protected void w0(int i3, long j3, int i4, boolean z2) {
        C0();
        this.f43303b.w0(i3, j3, i4, z2);
    }

    @Override // androidx.media3.common.Player
    public int x() {
        C0();
        return this.f43303b.x();
    }

    @Override // androidx.media3.common.Player
    public ExoPlaybackException b() {
        C0();
        return this.f43303b.b();
    }
}
