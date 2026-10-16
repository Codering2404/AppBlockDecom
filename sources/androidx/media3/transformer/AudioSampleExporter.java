package androidx.media3.transformer;

import android.media.MediaCodec;
import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import androidx.media3.transformer.Codec;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioSampleExporter extends SampleExporter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Codec f47948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AudioProcessor.AudioFormat f47949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DecoderInputBuffer f47950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final DecoderInputBuffer f47951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AudioGraph f47952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AudioGraphInput f47953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Format f47954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f47955l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f47956m;

    public AudioSampleExporter(Format format, Format format2, TransformationRequest transformationRequest, EditedMediaItem editedMediaItem, ImmutableList immutableList, AudioMixer.Factory factory, Codec.EncoderFactory encoderFactory, MuxerWrapper muxerWrapper, FallbackListener fallbackListener) throws ExportException {
        super(format, muxerWrapper);
        SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
        AudioGraph audioGraph = new AudioGraph(factory, new ImmutableList.Builder().k(immutableList).a(sonicAudioProcessor).m());
        this.f47952i = audioGraph;
        this.f47954k = format2;
        AudioGraphInput audioGraphInputL = audioGraph.l(editedMediaItem, format2);
        AudioProcessor.AudioFormat audioFormatH = audioGraph.h();
        Assertions.g(!audioFormatH.equals(AudioProcessor.AudioFormat.f41286e));
        Format.Builder builder = new Format.Builder();
        String str = transformationRequest.f48471b;
        Format formatN = builder.u0(str == null ? (String) Assertions.e(format.f40632o) : str).v0(audioFormatH.f41287a).R(audioFormatH.f41288b).o0(audioFormatH.f41289c).S(format2.f40628k).N();
        Codec codecB = encoderFactory.b(formatN.b().u0(SampleExporter.k(formatN, muxerWrapper.i(1))).N());
        this.f47948e = codecB;
        AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(codecB.e());
        if (audioFormat.f41287a != audioFormatH.f41287a) {
            audioGraph.m();
            sonicAudioProcessor.j(audioFormat.f41287a);
            audioGraphInputL = audioGraph.l(editedMediaItem, format2);
            audioFormatH = audioGraph.h();
        }
        this.f47953j = audioGraphInputL;
        this.f47949f = audioFormatH;
        this.f47950g = new DecoderInputBuffer(0);
        this.f47951h = new DecoderInputBuffer(0);
        fallbackListener.c(t(transformationRequest, formatN, codecB.m()));
    }

    private static TransformationRequest t(TransformationRequest transformationRequest, Format format, Format format2) {
        return Objects.equals(format.f40632o, format2.f40632o) ? transformationRequest : transformationRequest.a().b(format2.f40632o).a();
    }

    private void u(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = (ByteBuffer) Assertions.e(this.f47950g.f42138d);
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + byteBuffer2.capacity()));
        byteBuffer2.put(byteBuffer);
        this.f47950g.f42140g = w();
        this.f47956m += (long) byteBuffer2.position();
        this.f47950g.n(0);
        this.f47950g.q();
        byteBuffer.limit(iLimit);
        this.f47948e.d(this.f47950g);
    }

    private long w() {
        long j3 = this.f47956m;
        AudioProcessor.AudioFormat audioFormat = this.f47949f;
        return ((j3 / ((long) audioFormat.f41290d)) * 1000000) / ((long) audioFormat.f41287a);
    }

    private void x() {
        Assertions.g(((ByteBuffer) Assertions.e(this.f47950g.f42138d)).position() == 0);
        this.f47950g.f42140g = w();
        this.f47950g.e(4);
        this.f47950g.q();
        this.f47948e.d(this.f47950g);
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected DecoderInputBuffer m() {
        this.f47951h.f42138d = this.f47948e.j();
        DecoderInputBuffer decoderInputBuffer = this.f47951h;
        if (decoderInputBuffer.f42138d == null) {
            return null;
        }
        decoderInputBuffer.f42140g = ((MediaCodec.BufferInfo) Assertions.e(this.f47948e.g())).presentationTimeUs;
        this.f47951h.n(1);
        return this.f47951h;
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected Format n() {
        return this.f47948e.c();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected boolean o() {
        return this.f47948e.b();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected boolean q() throws ExportException {
        ByteBuffer byteBufferG = this.f47952i.g();
        if (!this.f47948e.l(this.f47950g)) {
            return false;
        }
        if (this.f47952i.i()) {
            DebugTraceUtil.e("AudioGraph", "OutputEnded", Long.MIN_VALUE);
            x();
            return false;
        }
        if (!byteBufferG.hasRemaining()) {
            return false;
        }
        u(byteBufferG);
        return true;
    }

    @Override // androidx.media3.transformer.SampleExporter
    public void r() {
        this.f47952i.m();
        this.f47948e.release();
    }

    @Override // androidx.media3.transformer.SampleExporter
    protected void s() {
        this.f47948e.h(false);
    }

    @Override // androidx.media3.transformer.SampleExporter
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public AudioGraphInput l(EditedMediaItem editedMediaItem, Format format, int i3) {
        if (this.f47955l) {
            return this.f47952i.l(editedMediaItem, format);
        }
        this.f47955l = true;
        Assertions.g(format.equals(this.f47954k));
        return this.f47953j;
    }
}
