package androidx.media3.transformer;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioMixingUtil;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioMixer implements AudioMixer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f48026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f48027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f48028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioProcessor.AudioFormat f48030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f48031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MixingBuffer[] f48032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f48033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f48034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f48035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f48036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f48037l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements AudioMixer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f48038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f48039b;

        public Factory() {
            this(false, true);
        }

        @Override // androidx.media3.transformer.AudioMixer.Factory
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DefaultAudioMixer create() {
            return new DefaultAudioMixer(this.f48038a, this.f48039b);
        }

        public Factory(boolean z2, boolean z3) {
            this.f48038a = z2;
            this.f48039b = z3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MixingBuffer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f48040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f48041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f48042c;

        public MixingBuffer(ByteBuffer byteBuffer, long j3, long j4) {
            this.f48040a = byteBuffer;
            this.f48041b = j3;
            this.f48042c = j4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SourceInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f48043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioProcessor.AudioFormat f48044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ChannelMixingMatrix f48045c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ChannelMixingMatrix f48046d;

        public SourceInfo(AudioProcessor.AudioFormat audioFormat, ChannelMixingMatrix channelMixingMatrix, long j3) {
            this.f48044b = audioFormat;
            this.f48045c = channelMixingMatrix;
            this.f48043a = j3;
            this.f48046d = channelMixingMatrix;
        }

        public void a(ByteBuffer byteBuffer, long j3) {
            Assertions.a(j3 >= this.f48043a);
            byteBuffer.position(byteBuffer.position() + (((int) (j3 - this.f48043a)) * this.f48044b.f41290d));
            this.f48043a = j3;
        }

        public ChannelMixingMatrix b() {
            return this.f48046d;
        }

        public long c(ByteBuffer byteBuffer) {
            return this.f48043a + ((long) (byteBuffer.remaining() / this.f48044b.f41290d));
        }

        public void d(ByteBuffer byteBuffer, long j3, ByteBuffer byteBuffer2, AudioProcessor.AudioFormat audioFormat) {
            Assertions.a(j3 >= this.f48043a);
            AudioMixingUtil.f(byteBuffer, this.f48044b, byteBuffer2, audioFormat, this.f48046d, (int) (j3 - this.f48043a), true, DefaultAudioMixer.this.f48027b);
            this.f48043a = j3;
        }
    }

    private MixingBuffer i(long j3) {
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(this.f48031f * this.f48030e.f41290d).order(ByteOrder.nativeOrder());
        byteBufferOrder.mark();
        return new MixingBuffer(byteBufferOrder, j3, j3 + ((long) this.f48031f));
    }

    private void j() {
        Assertions.h(!this.f48030e.equals(AudioProcessor.AudioFormat.f41286e), "Audio mixer is not configured.");
    }

    private SourceInfo k(int i3) {
        Assertions.h(Util.t(this.f48028c, i3), "Source not found.");
        return (SourceInfo) this.f48028c.get(i3);
    }

    private void m() {
        this.f48034i = Math.min(this.f48036k, this.f48035j + ((long) this.f48031f));
    }

    @Override // androidx.media3.transformer.AudioMixer
    public int a(AudioProcessor.AudioFormat audioFormat, long j3) throws AudioProcessor.UnhandledAudioFormatException {
        j();
        if (!l(audioFormat)) {
            throw new AudioProcessor.UnhandledAudioFormatException("Can not add source. MixerFormat=" + this.f48030e, audioFormat);
        }
        long jI = Util.I(j3 - this.f48033h, audioFormat.f41287a);
        int i3 = this.f48029d;
        this.f48029d = i3 + 1;
        this.f48028c.append(i3, new SourceInfo(audioFormat, ChannelMixingMatrix.b(audioFormat.f41288b, this.f48030e.f41288b), jI));
        DebugTraceUtil.f("AudioMixer", "RegisterNewInputStream", j3, "source(%s):%s", Integer.valueOf(i3), audioFormat);
        return i3;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public boolean b() {
        j();
        long j3 = this.f48035j;
        if (j3 < this.f48036k) {
            return j3 >= this.f48037l && this.f48028c.size() == 0;
        }
        return true;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public ByteBuffer c() {
        j();
        if (b()) {
            return AudioProcessor.f41285a;
        }
        long jMin = this.f48036k;
        if (this.f48028c.size() == 0) {
            jMin = Math.min(jMin, this.f48037l);
        }
        for (int i3 = 0; i3 < this.f48028c.size(); i3++) {
            jMin = Math.min(jMin, ((SourceInfo) this.f48028c.valueAt(i3)).f48043a);
        }
        if (jMin <= this.f48035j) {
            return AudioProcessor.f41285a;
        }
        MixingBuffer mixingBuffer = this.f48032g[0];
        long jMin2 = Math.min(jMin, mixingBuffer.f48042c);
        ByteBuffer byteBufferDuplicate = mixingBuffer.f48040a.duplicate();
        byteBufferDuplicate.position(((int) (this.f48035j - mixingBuffer.f48041b)) * this.f48030e.f41290d).limit(((int) (jMin2 - mixingBuffer.f48041b)) * this.f48030e.f41290d);
        ByteBuffer byteBufferOrder = byteBufferDuplicate.slice().order(ByteOrder.nativeOrder());
        if (jMin2 == mixingBuffer.f48042c) {
            MixingBuffer[] mixingBufferArr = this.f48032g;
            MixingBuffer mixingBuffer2 = mixingBufferArr[1];
            mixingBufferArr[0] = mixingBuffer2;
            mixingBufferArr[1] = i(mixingBuffer2.f48042c);
        }
        this.f48035j = jMin2;
        m();
        DebugTraceUtil.f("AudioMixer", "ProducedOutput", -9223372036854775807L, "bytesOutput=%s", Integer.valueOf(byteBufferOrder.remaining()));
        return byteBufferOrder;
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void d(int i3) {
        j();
        this.f48037l = Math.max(this.f48037l, k(i3).f48043a);
        this.f48028c.delete(i3);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public boolean e(int i3) {
        j();
        return Util.t(this.f48028c, i3);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void f(int i3, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        j();
        if (byteBuffer.hasRemaining()) {
            SourceInfo sourceInfoK = k(i3);
            if (sourceInfoK.f48043a >= this.f48034i) {
                return;
            }
            long jMin = Math.min(sourceInfoK.c(byteBuffer), this.f48034i);
            if (sourceInfoK.b().j()) {
                sourceInfoK.a(byteBuffer, jMin);
                return;
            }
            long j3 = sourceInfoK.f48043a;
            long j4 = this.f48035j;
            if (j3 < j4) {
                sourceInfoK.a(byteBuffer, Math.min(jMin, j4));
                if (sourceInfoK.f48043a == jMin) {
                    return;
                }
            }
            MixingBuffer[] mixingBufferArr = this.f48032g;
            int length = mixingBufferArr.length;
            int i4 = 0;
            while (i4 < length) {
                MixingBuffer mixingBuffer = mixingBufferArr[i4];
                long j5 = sourceInfoK.f48043a;
                if (j5 >= mixingBuffer.f48042c) {
                    byteBuffer2 = byteBuffer;
                } else {
                    int i5 = ((int) (j5 - mixingBuffer.f48041b)) * this.f48030e.f41290d;
                    ByteBuffer byteBuffer3 = mixingBuffer.f48040a;
                    byteBuffer3.position(byteBuffer3.position() + i5);
                    byteBuffer2 = byteBuffer;
                    sourceInfoK.d(byteBuffer2, Math.min(jMin, mixingBuffer.f48042c), mixingBuffer.f48040a, this.f48030e);
                    mixingBuffer.f48040a.reset();
                    if (sourceInfoK.f48043a == jMin) {
                        return;
                    }
                }
                i4++;
                byteBuffer = byteBuffer2;
            }
        }
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void g(AudioProcessor.AudioFormat audioFormat, int i3, long j3) throws AudioProcessor.UnhandledAudioFormatException {
        Assertions.h(this.f48030e.equals(AudioProcessor.AudioFormat.f41286e), "Audio mixer already configured.");
        if (i3 == -1) {
            i3 = 500;
        }
        Assertions.a(i3 > 0);
        if (!AudioMixingUtil.a(audioFormat)) {
            throw new AudioProcessor.UnhandledAudioFormatException("Can not mix to this AudioFormat.", audioFormat);
        }
        this.f48030e = audioFormat;
        this.f48031f = (i3 * audioFormat.f41287a) / 1000;
        this.f48033h = j3;
        DebugTraceUtil.f("AudioMixer", "OutputFormat", j3, "%s", audioFormat);
        this.f48032g = new MixingBuffer[]{i(0L), i(this.f48031f)};
        m();
    }

    public boolean l(AudioProcessor.AudioFormat audioFormat) {
        j();
        return AudioMixingUtil.b(audioFormat, this.f48030e);
    }

    @Override // androidx.media3.transformer.AudioMixer
    public void reset() {
        this.f48028c.clear();
        this.f48029d = 0;
        this.f48030e = AudioProcessor.AudioFormat.f41286e;
        this.f48031f = -1;
        this.f48032g = new MixingBuffer[0];
        this.f48033h = -9223372036854775807L;
        this.f48034i = -1L;
        this.f48035j = 0L;
        this.f48036k = Long.MAX_VALUE;
        this.f48037l = this.f48026a ? Long.MAX_VALUE : 0L;
    }

    private DefaultAudioMixer(boolean z2, boolean z3) {
        this.f48026a = z2;
        this.f48027b = z3;
        this.f48028c = new SparseArray();
        this.f48030e = AudioProcessor.AudioFormat.f41286e;
        this.f48031f = -1;
        this.f48032g = new MixingBuffer[0];
        this.f48033h = -9223372036854775807L;
        this.f48034i = -1L;
        this.f48036k = Long.MAX_VALUE;
        if (z2) {
            this.f48037l = Long.MAX_VALUE;
        }
    }
}
