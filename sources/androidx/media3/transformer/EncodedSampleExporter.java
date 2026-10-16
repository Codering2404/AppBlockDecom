package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EncodedSampleExporter extends SampleExporter implements GraphInput {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final ByteBuffer f48128o = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Format f48129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f48130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicLong f48131g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Queue f48132h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Queue f48133i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f48134j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f48135k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f48136l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f48137m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private DecoderInputBuffer f48138n;

    public EncodedSampleExporter(Format format, TransformationRequest transformationRequest, MuxerWrapper muxerWrapper, FallbackListener fallbackListener, long j3) {
        super(format, muxerWrapper);
        this.f48129e = format;
        this.f48130f = j3;
        this.f48131g = new AtomicLong();
        this.f48132h = new ConcurrentLinkedQueue();
        this.f48133i = new ConcurrentLinkedQueue();
        fallbackListener.c(transformationRequest);
    }

    @Override // androidx.media3.transformer.OnMediaItemChangedListener
    public void b(EditedMediaItem editedMediaItem, long j3, Format format, boolean z2) {
        this.f48135k = this.f48131g.get();
        this.f48131g.addAndGet(j3);
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public boolean c() {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.e(this.f48138n);
        this.f48138n = null;
        if (decoderInputBuffer.i()) {
            this.f48134j = true;
        } else {
            decoderInputBuffer.f42140g += this.f48135k + this.f48130f;
            this.f48133i.add(decoderInputBuffer);
        }
        if (!this.f48136l) {
            int size = this.f48132h.size() + this.f48133i.size();
            long jCapacity = this.f48137m + ((long) ((ByteBuffer) Assertions.e(decoderInputBuffer.f42138d)).capacity());
            this.f48137m = jCapacity;
            this.f48136l = size >= 10 && (size >= 200 || jCapacity >= 2097152);
        }
        return true;
    }

    @Override // androidx.media3.transformer.SampleConsumer
    public DecoderInputBuffer f() {
        if (this.f48138n == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f48132h.poll();
            this.f48138n = decoderInputBuffer;
            if (!this.f48136l) {
                if (decoderInputBuffer == null) {
                    DecoderInputBuffer decoderInputBuffer2 = new DecoderInputBuffer(2);
                    this.f48138n = decoderInputBuffer2;
                    decoderInputBuffer2.f42138d = f48128o;
                } else {
                    this.f48137m -= (long) ((ByteBuffer) Assertions.e(decoderInputBuffer.f42138d)).capacity();
                }
            }
        }
        return this.f48138n;
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected DecoderInputBuffer m() {
        return (DecoderInputBuffer) this.f48133i.peek();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected Format n() {
        return this.f48129e;
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected boolean o() {
        return this.f48134j && this.f48133i.isEmpty();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected void s() {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) this.f48133i.remove();
        decoderInputBuffer.f();
        decoderInputBuffer.f42140g = 0L;
        this.f48132h.add(decoderInputBuffer);
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void r() {
    }

    @Override // androidx.media3.transformer.SampleExporter
    public GraphInput l(EditedMediaItem editedMediaItem, Format format, int i3) {
        return this;
    }
}
