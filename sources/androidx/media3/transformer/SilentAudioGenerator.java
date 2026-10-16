package androidx.media3.transformer;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SilentAudioGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioProcessor.AudioFormat f48444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteBuffer f48445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f48446c;

    public SilentAudioGenerator(AudioProcessor.AudioFormat audioFormat) {
        this.f48444a = audioFormat;
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(audioFormat.f41290d * 1024).order(ByteOrder.nativeOrder());
        this.f48445b = byteBufferOrder;
        byteBufferOrder.flip();
        this.f48446c = new AtomicLong();
    }

    public void a(long j3) {
        this.f48446c.addAndGet(((long) this.f48444a.f41290d) * Util.I(j3, this.f48444a.f41287a));
    }

    public void b() {
        this.f48446c.set(0L);
        this.f48445b.position(0);
        this.f48445b.limit(0);
    }

    public ByteBuffer c() {
        long j3 = this.f48446c.get();
        if (!this.f48445b.hasRemaining()) {
            this.f48445b.clear();
            if (j3 < this.f48445b.capacity()) {
                this.f48445b.limit((int) j3);
            }
            this.f48446c.addAndGet(-this.f48445b.remaining());
        }
        return this.f48445b;
    }

    public boolean d() {
        return this.f48445b.hasRemaining() || this.f48446c.get() > 0;
    }
}
