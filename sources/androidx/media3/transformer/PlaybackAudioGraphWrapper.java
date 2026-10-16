package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.transformer.AudioGraphInputAudioSink;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class PlaybackAudioGraphWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioSink f48339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioGraph f48340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f48343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioProcessor.AudioFormat f48344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f48345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f48346h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class SinkController implements AudioGraphInputAudioSink.Controller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f48347a;

        public SinkController(int i3) {
            this.f48347a = i3 == 0;
            PlaybackAudioGraphWrapper.a(PlaybackAudioGraphWrapper.this);
        }

        @Override // androidx.media3.transformer.AudioGraphInputAudioSink.Controller
        public AudioGraphInput a(EditedMediaItem editedMediaItem, Format format) throws ExportException {
            if (!this.f48347a && !PlaybackAudioGraphWrapper.this.f48343e) {
                return null;
            }
            AudioGraphInput audioGraphInputL = PlaybackAudioGraphWrapper.this.f48340b.l(editedMediaItem, format);
            PlaybackAudioGraphWrapper.e(PlaybackAudioGraphWrapper.this);
            if (this.f48347a) {
                PlaybackAudioGraphWrapper.this.f48343e = true;
            }
            return audioGraphInputL;
        }

        @Override // androidx.media3.transformer.AudioGraphInputAudioSink.Controller
        public long c(boolean z2) {
            return PlaybackAudioGraphWrapper.this.f48339a.c(z2);
        }
    }

    static /* synthetic */ int a(PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
        int i3 = playbackAudioGraphWrapper.f48342d;
        playbackAudioGraphWrapper.f48342d = i3 + 1;
        return i3;
    }

    static /* synthetic */ int e(PlaybackAudioGraphWrapper playbackAudioGraphWrapper) {
        int i3 = playbackAudioGraphWrapper.f48341c;
        playbackAudioGraphWrapper.f48341c = i3 + 1;
        return i3;
    }

    private long i() {
        return this.f48346h + Util.Y0(this.f48345g, this.f48344f.f41287a);
    }

    public AudioGraphInputAudioSink g(int i3) {
        return new AudioGraphInputAudioSink(new SinkController(i3));
    }

    public void h() {
        this.f48340b.o();
    }

    public boolean j() throws ExportException {
        int i3 = this.f48342d;
        if (i3 == 0 || i3 != this.f48341c) {
            return false;
        }
        AudioProcessor.AudioFormat audioFormat = this.f48344f;
        AudioProcessor.AudioFormat audioFormat2 = AudioProcessor.AudioFormat.f41286e;
        if (Objects.equals(audioFormat, audioFormat2)) {
            AudioProcessor.AudioFormat audioFormatH = this.f48340b.h();
            if (Objects.equals(audioFormatH, audioFormat2)) {
                return false;
            }
            this.f48339a.o(Util.j0(audioFormatH), 0, null);
            this.f48344f = audioFormatH;
        }
        if (this.f48340b.i()) {
            if (this.f48339a.b()) {
                return false;
            }
            this.f48339a.p();
            return false;
        }
        ByteBuffer byteBufferG = this.f48340b.g();
        if (!byteBufferG.hasRemaining()) {
            return false;
        }
        int iRemaining = byteBufferG.remaining();
        boolean zN = this.f48339a.n(byteBufferG, i(), 1);
        this.f48345g += (long) ((iRemaining - byteBufferG.remaining()) / this.f48344f.f41290d);
        return zN;
    }

    public void k() {
        this.f48340b.m();
        this.f48339a.reset();
        this.f48339a.release();
        this.f48341c = 0;
        this.f48342d = 0;
    }

    public void l(long j3) {
        if (j3 == -9223372036854775807L) {
            j3 = 0;
        }
        this.f48339a.pause();
        this.f48340b.a();
        this.f48340b.n(j3);
        this.f48340b.f();
        this.f48339a.flush();
        this.f48345g = 0L;
        this.f48346h = j3;
    }
}
