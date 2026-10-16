package androidx.media3.transformer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.audio.AudioSink;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioGraphInputAudioSink implements AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Controller f47938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AudioGraphInput f47939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Format f47940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f47941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EditedMediaItemInfo f47943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47944g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f47945h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Controller {
        AudioGraphInput a(EditedMediaItem editedMediaItem, Format format);

        long c(boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class EditedMediaItemInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditedMediaItem f47946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f47947b;

        public EditedMediaItemInfo(EditedMediaItem editedMediaItem, boolean z2) {
            this.f47946a = editedMediaItem;
            this.f47947b = z2;
        }
    }

    public AudioGraphInputAudioSink(Controller controller) {
        this.f47938a = controller;
    }

    private long A() {
        long jC = this.f47938a.c(this.f47941d);
        return jC != Long.MIN_VALUE ? jC - this.f47944g : jC;
    }

    private boolean B(ByteBuffer byteBuffer, long j3, int i3) {
        Assertions.i(this.f47940c);
        Assertions.g(!this.f47942e);
        AudioGraphInput audioGraphInput = (AudioGraphInput) Assertions.e(this.f47939b);
        DecoderInputBuffer decoderInputBufferF = audioGraphInput.f();
        if (decoderInputBufferF == null) {
            return false;
        }
        decoderInputBufferF.p(byteBuffer.remaining());
        ((ByteBuffer) Assertions.e(decoderInputBufferF.f42138d)).put(byteBuffer).flip();
        decoderInputBufferF.f42140g = j3 != Long.MIN_VALUE ? this.f47944g + j3 : Long.MIN_VALUE;
        decoderInputBufferF.n(i3);
        boolean zC = audioGraphInput.c();
        if (zC) {
            this.f47945h = j3 + Util.Y0(r2 / Util.k0(r9.G, r9.E), ((Format) Assertions.e(this.f47940c)).F);
        }
        return zC;
    }

    public void C(EditedMediaItem editedMediaItem, long j3, boolean z2) {
        this.f47943f = new EditedMediaItemInfo(editedMediaItem, z2);
        this.f47944g = j3;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean a(Format format) {
        return w(format) == 2;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean b() {
        return this.f47940c == null ? this.f47941d : this.f47941d && A() >= this.f47945h;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long c(boolean z2) {
        return b() ? this.f47945h : A();
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public PlaybackParameters d() {
        return PlaybackParameters.f40950d;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void flush() {
        this.f47941d = false;
        this.f47942e = false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean h() {
        return false;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public long j() {
        return -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public boolean n(ByteBuffer byteBuffer, long j3, int i3) throws AudioSink.InitializationException {
        Assertions.g(!this.f47941d);
        EditedMediaItem editedMediaItem = ((EditedMediaItemInfo) Assertions.i(this.f47943f)).f47946a;
        if (this.f47939b == null) {
            try {
                AudioGraphInput audioGraphInputA = this.f47938a.a(editedMediaItem, (Format) Assertions.i(this.f47940c));
                if (audioGraphInputA == null) {
                    return false;
                }
                this.f47939b = audioGraphInputA;
                audioGraphInputA.b(editedMediaItem, -9223372036854775807L, this.f47940c, false);
            } catch (ExportException e3) {
                throw new AudioSink.InitializationException("Error creating AudioGraphInput", 0, this.f47940c, false, e3);
            }
        }
        return B(byteBuffer, j3, 0);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void o(Format format, int i3, int[] iArr) {
        Assertions.a(a(format));
        EditedMediaItem editedMediaItem = ((EditedMediaItemInfo) Assertions.i(this.f47943f)).f47946a;
        Assertions.a(iArr == null);
        this.f47940c = format;
        AudioGraphInput audioGraphInput = this.f47939b;
        if (audioGraphInput != null) {
            audioGraphInput.b(editedMediaItem, -9223372036854775807L, format, false);
        }
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void p() {
        this.f47941d = true;
        if (this.f47940c == null || this.f47942e || !((EditedMediaItemInfo) Assertions.i(this.f47943f)).f47947b) {
            return;
        }
        this.f47942e = B(AudioProcessor.f41285a, Long.MIN_VALUE, 4);
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void reset() {
        flush();
        this.f47940c = null;
        this.f47943f = null;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public int w(Format format) {
        return (Objects.equals(format.f40632o, "audio/raw") && format.G == 2) ? 2 : 0;
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void m() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void pause() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void q() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void u() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void v() {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void e(PlaybackParameters playbackParameters) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void f(AudioAttributes audioAttributes) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void i(int i3) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void k(AudioSink.Listener listener) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void setVolume(float f3) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void x(boolean z2) {
    }

    @Override // androidx.media3.exoplayer.audio.AudioSink
    public void y(AuxEffectInfo auxEffectInfo) {
    }
}
