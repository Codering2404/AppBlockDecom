package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class SynchronizedSonicAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f41357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SonicAudioProcessor f41358c;

    public SynchronizedSonicAudioProcessor(Object obj, boolean z2) {
        this.f41357b = obj;
        this.f41358c = new SonicAudioProcessor(z2);
    }

    public final long a(long j3) {
        long jI;
        synchronized (this.f41357b) {
            jI = this.f41358c.i(j3);
        }
        return jI;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean b() {
        boolean zB;
        synchronized (this.f41357b) {
            zB = this.f41358c.b();
        }
        return zB;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final ByteBuffer c() {
        ByteBuffer byteBufferC;
        synchronized (this.f41357b) {
            byteBufferC = this.f41358c.c();
        }
        return byteBufferC;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void d(ByteBuffer byteBuffer) {
        synchronized (this.f41357b) {
            this.f41358c.d(byteBuffer);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e() {
        synchronized (this.f41357b) {
            this.f41358c.e();
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat f(AudioProcessor.AudioFormat audioFormat) {
        AudioProcessor.AudioFormat audioFormatF;
        synchronized (this.f41357b) {
            audioFormatF = this.f41358c.f(audioFormat);
        }
        return audioFormatF;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        synchronized (this.f41357b) {
            this.f41358c.flush();
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public long g(long j3) {
        return a(j3);
    }

    public final void h(float f3) {
        synchronized (this.f41357b) {
            this.f41358c.k(f3);
        }
    }

    public final void i(float f3) {
        synchronized (this.f41357b) {
            this.f41358c.l(f3);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final boolean isActive() {
        boolean zIsActive;
        synchronized (this.f41357b) {
            zIsActive = this.f41358c.isActive();
        }
        return zIsActive;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        synchronized (this.f41357b) {
            this.f41358c.reset();
        }
    }
}
