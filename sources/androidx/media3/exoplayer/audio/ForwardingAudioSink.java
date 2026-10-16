package androidx.media3.exoplayer.audio;

import android.media.AudioDeviceInfo;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioSink;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingAudioSink implements AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioSink f43867a;

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean a(Format format) {
        return this.f43867a.a(format);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean b() {
        return this.f43867a.b();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long c(boolean z2) {
        return this.f43867a.c(z2);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public PlaybackParameters d() {
        return this.f43867a.d();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void e(PlaybackParameters playbackParameters) {
        this.f43867a.e(playbackParameters);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void f(AudioAttributes audioAttributes) {
        this.f43867a.f(audioAttributes);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        this.f43867a.flush();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public AudioOffloadSupport g(Format format) {
        return this.f43867a.g(format);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean h() {
        return this.f43867a.h();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void i(int i3) {
        this.f43867a.i(i3);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long j() {
        return this.f43867a.j();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void k(AudioSink.Listener listener) {
        this.f43867a.k(listener);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void l(int i3) {
        this.f43867a.l(i3);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void m() {
        this.f43867a.m();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean n(ByteBuffer byteBuffer, long j3, int i3) {
        return this.f43867a.n(byteBuffer, j3, i3);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void o(Format format, int i3, int[] iArr) {
        this.f43867a.o(format, i3, iArr);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void p() {
        this.f43867a.p();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
        this.f43867a.pause();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void q() {
        this.f43867a.q();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void r(int i3, int i4) {
        this.f43867a.r(i3, i4);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void release() {
        this.f43867a.release();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        this.f43867a.reset();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void s(PlayerId playerId) {
        this.f43867a.s(playerId);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        this.f43867a.setPreferredDevice(audioDeviceInfo);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f3) {
        this.f43867a.setVolume(f3);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void t(long j3) {
        this.f43867a.t(j3);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void u() {
        this.f43867a.u();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void v() {
        this.f43867a.v();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int w(Format format) {
        return this.f43867a.w(format);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void x(boolean z2) {
        this.f43867a.x(z2);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void y(AuxEffectInfo auxEffectInfo) {
        this.f43867a.y(auxEffectInfo);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void z(Clock clock) {
        this.f43867a.z(clock);
    }
}
