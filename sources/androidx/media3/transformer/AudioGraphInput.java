package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingAudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.SpeedChangingAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioGraphInput implements GraphInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioProcessor.AudioFormat f47918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Queue f47919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue f47920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f47921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f47922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SilentAudioGenerator f47923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DecoderInputBuffer f47924g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioProcessingPipeline f47925h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f47926i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f47927j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f47928k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f47929l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47930m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f47931n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f47932o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f47933p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MediaItemChange {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditedMediaItem f47934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f47935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f47936c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f47937d;

        public MediaItemChange(EditedMediaItem editedMediaItem, long j3, Format format, boolean z2) {
            this.f47934a = editedMediaItem;
            this.f47935b = j3;
            this.f47936c = format;
            this.f47937d = z2;
        }
    }

    public AudioGraphInput(AudioProcessor.AudioFormat audioFormat, EditedMediaItem editedMediaItem, Format format) throws AudioProcessor.UnhandledAudioFormatException {
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(format);
        Assertions.b(AudioGraph.j(audioFormat2), audioFormat2);
        this.f47919b = new ConcurrentLinkedQueue();
        ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
        for (int i3 = 0; i3 < 10; i3++) {
            DecoderInputBuffer decoderInputBuffer = new DecoderInputBuffer(2);
            decoderInputBuffer.f42138d = byteBufferOrder;
            this.f47919b.add(decoderInputBuffer);
        }
        this.f47920c = new ConcurrentLinkedQueue();
        this.f47921d = new ConcurrentLinkedQueue();
        this.f47923f = new SilentAudioGenerator(audioFormat2);
        AudioProcessingPipeline audioProcessingPipelineN = n(editedMediaItem, format, audioFormat2, audioFormat);
        this.f47925h = audioProcessingPipelineN;
        audioProcessingPipelineN.b();
        AudioProcessor.AudioFormat audioFormatE = this.f47925h.e();
        this.f47918a = audioFormatE;
        Assertions.b(audioFormatE.f41289c == 2, audioFormatE);
        this.f47922e = new AtomicLong(-9223372036854775807L);
        this.f47930m = -9223372036854775807L;
    }

    private void j() {
        this.f47923f.a(this.f47930m - o());
        this.f47932o = true;
        if (this.f47933p) {
            this.f47928k = true;
        }
    }

    private void l(DecoderInputBuffer decoderInputBuffer) {
        decoderInputBuffer.f();
        decoderInputBuffer.f42140g = 0L;
        this.f47919b.add(decoderInputBuffer);
    }

    private void m() {
        AudioProcessor.AudioFormat audioFormat;
        MediaItemChange mediaItemChange = (MediaItemChange) Assertions.i((MediaItemChange) this.f47921d.poll());
        this.f47931n = 0L;
        this.f47933p = mediaItemChange.f47937d;
        this.f47932o = false;
        if (mediaItemChange.f47936c != null) {
            this.f47930m = mediaItemChange.f47935b;
            audioFormat = new AudioProcessor.AudioFormat(mediaItemChange.f47936c);
            this.f47923f = new SilentAudioGenerator(audioFormat);
        } else {
            if (mediaItemChange.f47934a.f48101g.f48126a.isEmpty()) {
                this.f47930m = mediaItemChange.f47934a.b(mediaItemChange.f47935b);
            } else {
                this.f47930m = mediaItemChange.f47935b;
            }
            AudioProcessor.AudioFormat audioFormat2 = this.f47923f.f48444a;
            this.f47922e.compareAndSet(-9223372036854775807L, 0L);
            j();
            audioFormat = audioFormat2;
        }
        if (this.f47926i) {
            this.f47925h = n(mediaItemChange.f47934a, mediaItemChange.f47936c, audioFormat, this.f47918a);
        }
        this.f47925h.b();
        this.f47927j = false;
        this.f47926i = true;
    }

    private static AudioProcessingPipeline n(EditedMediaItem editedMediaItem, Format format, AudioProcessor.AudioFormat audioFormat, AudioProcessor.AudioFormat audioFormat2) throws AudioProcessor.UnhandledAudioFormatException {
        int i3;
        int i4;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (editedMediaItem.f48098d && format != null && format.f40629l != null) {
            builder.a(new SpeedChangingAudioProcessor(new SegmentSpeedProvider(format.f40629l)));
        }
        builder.k(editedMediaItem.f48101g.f48126a);
        if (audioFormat2.f41287a != -1) {
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            sonicAudioProcessor.j(audioFormat2.f41287a);
            builder.a(sonicAudioProcessor);
        }
        int i5 = audioFormat2.f41288b;
        if (i5 == 1 || i5 == 2) {
            ChannelMixingAudioProcessor channelMixingAudioProcessor = new ChannelMixingAudioProcessor();
            channelMixingAudioProcessor.m(ChannelMixingMatrix.b(1, audioFormat2.f41288b));
            channelMixingAudioProcessor.m(ChannelMixingMatrix.b(2, audioFormat2.f41288b));
            builder.a(channelMixingAudioProcessor);
        }
        AudioProcessingPipeline audioProcessingPipeline = new AudioProcessingPipeline(builder.m());
        AudioProcessor.AudioFormat audioFormatA = audioProcessingPipeline.a(audioFormat);
        int i6 = audioFormat2.f41287a;
        if ((i6 == -1 || i6 == audioFormatA.f41287a) && (((i3 = audioFormat2.f41288b) == -1 || i3 == audioFormatA.f41288b) && ((i4 = audioFormat2.f41289c) == -1 || i4 == audioFormatA.f41289c))) {
            return audioProcessingPipeline;
        }
        throw new AudioProcessor.UnhandledAudioFormatException("Audio can not be modified to match downstream format", audioFormat);
    }

    private long o() {
        long j3 = this.f47931n;
        AudioProcessor.AudioFormat audioFormat = this.f47923f.f48444a;
        return Util.Y0(j3 / ((long) audioFormat.f41290d), audioFormat.f41287a);
    }

    private ByteBuffer p() {
        if (this.f47923f.d()) {
            return this.f47923f.c();
        }
        DecoderInputBuffer decoderInputBuffer = this.f47924g;
        if (decoderInputBuffer != null) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.i(decoderInputBuffer.f42138d);
            if (byteBuffer.hasRemaining()) {
                return byteBuffer;
            }
            l((DecoderInputBuffer) Assertions.i(this.f47924g));
            this.f47924g = null;
        }
        DecoderInputBuffer decoderInputBuffer2 = (DecoderInputBuffer) this.f47920c.poll();
        if (decoderInputBuffer2 == null) {
            if (!this.f47921d.isEmpty() && z()) {
                j();
            }
            return AudioProcessor.f41285a;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer2.f42138d;
        this.f47927j = decoderInputBuffer2.i();
        if (byteBuffer2 != null && byteBuffer2.hasRemaining() && !this.f47927j) {
            this.f47924g = decoderInputBuffer2;
            this.f47931n += (long) byteBuffer2.remaining();
            return byteBuffer2;
        }
        l(decoderInputBuffer2);
        if (this.f47927j && z()) {
            j();
        }
        return AudioProcessor.f41285a;
    }

    private boolean q() {
        if (this.f47923f.d()) {
            ByteBuffer byteBufferC = this.f47923f.c();
            this.f47925h.j(byteBufferC);
            if (byteBufferC.hasRemaining()) {
                return false;
            }
            if (this.f47923f.d()) {
                return true;
            }
            this.f47925h.i();
            return false;
        }
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f47920c.peek();
        if (decoderInputBuffer == null) {
            if (!this.f47921d.isEmpty()) {
                if (z()) {
                    j();
                    return true;
                }
                this.f47925h.i();
            }
            return false;
        }
        if (decoderInputBuffer.i()) {
            if (z()) {
                j();
                l((DecoderInputBuffer) this.f47920c.remove());
                return true;
            }
            this.f47925h.i();
            this.f47927j = true;
            l((DecoderInputBuffer) this.f47920c.remove());
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.e(decoderInputBuffer.f42138d);
        long jRemaining = byteBuffer.remaining();
        this.f47925h.j(byteBuffer);
        this.f47931n += jRemaining - ((long) byteBuffer.remaining());
        if (byteBuffer.hasRemaining()) {
            return false;
        }
        l((DecoderInputBuffer) this.f47920c.remove());
        return true;
    }

    private ByteBuffer u() {
        if (!this.f47926i) {
            return AudioProcessor.f41285a;
        }
        if (!this.f47925h.g()) {
            return p();
        }
        while (q()) {
        }
        return this.f47925h.d();
    }

    private boolean w() {
        ByteBuffer byteBuffer;
        if (!this.f47926i) {
            return false;
        }
        DecoderInputBuffer decoderInputBuffer = this.f47924g;
        if ((decoderInputBuffer == null || (byteBuffer = decoderInputBuffer.f42138d) == null || !byteBuffer.hasRemaining()) && !this.f47923f.d() && this.f47920c.isEmpty()) {
            return this.f47925h.g() && !this.f47925h.f();
        }
        return true;
    }

    private boolean z() {
        if (this.f47932o) {
            return false;
        }
        long j3 = this.f47930m;
        return j3 != -9223372036854775807L && j3 - o() > 2000;
    }

    public void A() {
        this.f47929l = false;
    }

    @Override // androidx.media3.transformer.OnMediaItemChangedListener
    public void b(EditedMediaItem editedMediaItem, long j3, Format format, boolean z2) {
        if (format == null) {
            Assertions.h(j3 != -9223372036854775807L, "Could not generate silent audio because duration is unknown.");
        } else {
            Assertions.g(MimeTypes.n(format.f40632o));
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format);
            Assertions.h(AudioGraph.j(audioFormat), audioFormat);
        }
        this.f47921d.add(new MediaItemChange(editedMediaItem, j3, format, z2));
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public boolean c() {
        if (this.f47929l) {
            return false;
        }
        Assertions.g(this.f47921d.isEmpty());
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f47919b.remove();
        this.f47920c.add(decoderInputBuffer);
        this.f47922e.compareAndSet(-9223372036854775807L, decoderInputBuffer.f42140g);
        return true;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public DecoderInputBuffer f() {
        if (this.f47929l || !this.f47921d.isEmpty()) {
            return null;
        }
        return (DecoderInputBuffer) this.f47919b.peek();
    }

    public void k() {
        this.f47929l = true;
    }

    public void r() {
        this.f47921d.clear();
        this.f47926i = true;
        if (!this.f47919b.isEmpty()) {
            l((DecoderInputBuffer) this.f47919b.remove());
        }
        DecoderInputBuffer decoderInputBuffer = this.f47924g;
        if (decoderInputBuffer != null) {
            l(decoderInputBuffer);
            this.f47924g = null;
        }
        while (!this.f47920c.isEmpty()) {
            l((DecoderInputBuffer) this.f47920c.remove());
        }
        Assertions.g(this.f47919b.size() == 10);
        this.f47923f.b();
        this.f47925h.b();
        this.f47927j = false;
        this.f47928k = false;
        this.f47922e.set(-9223372036854775807L);
        this.f47930m = -9223372036854775807L;
        this.f47931n = 0L;
        this.f47932o = false;
        this.f47933p = false;
    }

    public ByteBuffer s() {
        ByteBuffer byteBufferU = u();
        if (byteBufferU.hasRemaining()) {
            return byteBufferU;
        }
        if (!w() && !this.f47921d.isEmpty()) {
            m();
        }
        return AudioProcessor.f41285a;
    }

    public AudioProcessor.AudioFormat t() {
        return this.f47918a;
    }

    public long v() {
        return this.f47922e.get();
    }

    public boolean x() {
        if (!w() && this.f47921d.isEmpty()) {
            return this.f47930m != -9223372036854775807L ? this.f47933p && (this.f47927j || this.f47928k) : this.f47927j || this.f47928k;
        }
        return false;
    }

    public void y() {
        this.f47925h.k();
    }
}
