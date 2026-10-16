package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.transformer.AudioMixer;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioGraph {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioMixer f47908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AudioProcessingPipeline f47909c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f47911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f47912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47913g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47915i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f47907a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioProcessor.AudioFormat f47910d = AudioProcessor.AudioFormat.f41286e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f47914h = AudioProcessor.f41285a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioGraphInput f47916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f47917b = -1;

        public InputInfo(AudioGraphInput audioGraphInput) {
            this.f47916a = audioGraphInput;
        }
    }

    public AudioGraph(AudioMixer.Factory factory, ImmutableList immutableList) {
        this.f47908b = factory.create();
        this.f47909c = new AudioProcessingPipeline(immutableList);
    }

    private boolean b() throws ExportException {
        if (this.f47912f) {
            return true;
        }
        if (!this.f47911e) {
            try {
                this.f47908b.g(this.f47910d, -1, this.f47913g);
                this.f47911e = true;
            } catch (AudioProcessor.UnhandledAudioFormatException e3) {
                throw ExportException.b(e3, "Error while configuring mixer");
            }
        }
        this.f47912f = true;
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            InputInfo inputInfo = (InputInfo) this.f47907a.get(i3);
            if (inputInfo.f47917b == -1) {
                AudioGraphInput audioGraphInput = inputInfo.f47916a;
                try {
                    audioGraphInput.s();
                    long jV = audioGraphInput.v();
                    if (jV == -9223372036854775807L) {
                        this.f47912f = false;
                    } else if (jV != Long.MIN_VALUE) {
                        inputInfo.f47917b = this.f47908b.a(audioGraphInput.t(), jV);
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e4) {
                    throw ExportException.b(e4, "Unhandled format while adding source " + inputInfo.f47917b);
                }
            }
        }
        return this.f47912f;
    }

    private void c() throws ExportException {
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            d((InputInfo) this.f47907a.get(i3));
        }
    }

    private void d(InputInfo inputInfo) throws ExportException {
        int i3 = inputInfo.f47917b;
        if (this.f47908b.e(i3)) {
            AudioGraphInput audioGraphInput = inputInfo.f47916a;
            if (audioGraphInput.x()) {
                this.f47908b.d(i3);
                inputInfo.f47917b = -1;
                this.f47915i++;
                return;
            }
            try {
                this.f47908b.f(i3, audioGraphInput.s());
            } catch (AudioProcessor.UnhandledAudioFormatException e3) {
                throw ExportException.b(e3, "AudioGraphInput (sourceId=" + i3 + ") reconfiguration");
            }
        }
    }

    private void e() {
        if (k()) {
            this.f47909c.i();
        } else {
            this.f47909c.j(this.f47914h);
        }
    }

    public static boolean j(AudioProcessor.AudioFormat audioFormat) {
        return (audioFormat.f41289c == -1 || audioFormat.f41287a == -1 || audioFormat.f41288b == -1) ? false : true;
    }

    private boolean k() {
        return !this.f47914h.hasRemaining() && this.f47915i >= this.f47907a.size() && this.f47908b.b();
    }

    public void a() {
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            ((InputInfo) this.f47907a.get(i3)).f47916a.k();
        }
    }

    public void f() {
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            InputInfo inputInfo = (InputInfo) this.f47907a.get(i3);
            inputInfo.f47917b = -1;
            inputInfo.f47916a.r();
        }
        this.f47908b.reset();
        this.f47911e = false;
        this.f47912f = false;
        this.f47914h = AudioProcessor.f41285a;
        this.f47909c.b();
        this.f47915i = 0;
    }

    public ByteBuffer g() throws ExportException {
        if (!b()) {
            return AudioProcessor.f41285a;
        }
        if (!this.f47908b.b()) {
            c();
        }
        if (!this.f47914h.hasRemaining()) {
            this.f47914h = this.f47908b.c();
        }
        if (!this.f47909c.g()) {
            return this.f47914h;
        }
        e();
        return this.f47909c.d();
    }

    public AudioProcessor.AudioFormat h() {
        return this.f47909c.e();
    }

    public boolean i() {
        return this.f47909c.g() ? this.f47909c.f() : k();
    }

    public AudioGraphInput l(EditedMediaItem editedMediaItem, Format format) throws ExportException {
        Assertions.a(format.G != -1);
        try {
            AudioGraphInput audioGraphInput = new AudioGraphInput(this.f47910d, editedMediaItem, format);
            if (Objects.equals(this.f47910d, AudioProcessor.AudioFormat.f41286e)) {
                AudioProcessor.AudioFormat audioFormatT = audioGraphInput.t();
                this.f47910d = audioFormatT;
                this.f47909c.a(audioFormatT);
                this.f47909c.b();
            }
            this.f47907a.add(new InputInfo(audioGraphInput));
            DebugTraceUtil.f("AudioGraph", "RegisterNewInputStream", -9223372036854775807L, "%s", format);
            return audioGraphInput;
        } catch (AudioProcessor.UnhandledAudioFormatException e3) {
            throw ExportException.b(e3, "Error while registering input " + this.f47907a.size());
        }
    }

    public void m() {
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            ((InputInfo) this.f47907a.get(i3)).f47916a.y();
        }
        this.f47907a.clear();
        this.f47908b.reset();
        this.f47909c.k();
        this.f47915i = 0;
        this.f47914h = AudioProcessor.f41285a;
        this.f47910d = AudioProcessor.AudioFormat.f41286e;
    }

    public void n(long j3) {
        this.f47913g = j3;
    }

    public void o() {
        for (int i3 = 0; i3 < this.f47907a.size(); i3++) {
            ((InputInfo) this.f47907a.get(i3)).f47916a.A();
        }
    }
}
