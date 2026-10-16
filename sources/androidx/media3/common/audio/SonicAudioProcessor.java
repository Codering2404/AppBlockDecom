package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SonicAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f41329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f41330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f41331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f41332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f41337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Sonic f41338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ByteBuffer f41339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ShortBuffer f41340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ByteBuffer f41341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f41342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f41343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f41344q;

    public SonicAudioProcessor() {
        this(false);
    }

    private boolean a() {
        return Math.abs(this.f41331d - 1.0f) < 1.0E-4f && Math.abs(this.f41332e - 1.0f) < 1.0E-4f && this.f41334g.f41287a == this.f41333f.f41287a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean b() {
        if (!this.f41344q) {
            return false;
        }
        Sonic sonic = this.f41338k;
        return sonic == null || sonic.m() == 0;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer c() {
        int iM;
        Sonic sonic = this.f41338k;
        if (sonic != null && (iM = sonic.m()) > 0) {
            if (this.f41339l.capacity() < iM) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iM).order(ByteOrder.nativeOrder());
                this.f41339l = byteBufferOrder;
                this.f41340m = byteBufferOrder.asShortBuffer();
            } else {
                this.f41339l.clear();
                this.f41340m.clear();
            }
            sonic.l(this.f41340m);
            this.f41343p += (long) iM;
            this.f41339l.limit(iM);
            this.f41341n = this.f41339l;
        }
        ByteBuffer byteBuffer = this.f41341n;
        this.f41341n = AudioProcessor.f41285a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            Sonic sonic = (Sonic) Assertions.e(this.f41338k);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f41342o += (long) iRemaining;
            sonic.v(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void e() {
        Sonic sonic = this.f41338k;
        if (sonic != null) {
            sonic.u();
        }
        this.f41344q = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.AudioFormat f(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f41289c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        int i3 = this.f41330c;
        if (i3 == -1) {
            i3 = audioFormat.f41287a;
        }
        this.f41333f = audioFormat;
        AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i3, audioFormat.f41288b, 2);
        this.f41334g = audioFormat2;
        this.f41337j = true;
        return audioFormat2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        if (isActive()) {
            AudioProcessor.AudioFormat audioFormat = this.f41333f;
            this.f41335h = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f41334g;
            this.f41336i = audioFormat2;
            if (this.f41337j) {
                this.f41338k = new Sonic(audioFormat.f41287a, audioFormat.f41288b, this.f41331d, this.f41332e, audioFormat2.f41287a);
            } else {
                Sonic sonic = this.f41338k;
                if (sonic != null) {
                    sonic.j();
                }
            }
        }
        this.f41341n = AudioProcessor.f41285a;
        this.f41342o = 0L;
        this.f41343p = 0L;
        this.f41344q = false;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public long g(long j3) {
        return i(j3);
    }

    public long h(long j3) {
        if (this.f41343p < 1024) {
            return (long) (((double) this.f41331d) * j3);
        }
        long jN = this.f41342o - ((long) ((Sonic) Assertions.e(this.f41338k)).n());
        int i3 = this.f41336i.f41287a;
        int i4 = this.f41335h.f41287a;
        return i3 == i4 ? Util.Z0(j3, jN, this.f41343p) : Util.Z0(j3, jN * ((long) i3), this.f41343p * ((long) i4));
    }

    public long i(long j3) {
        if (this.f41343p < 1024) {
            return (long) (j3 / ((double) this.f41331d));
        }
        long jN = this.f41342o - ((long) ((Sonic) Assertions.e(this.f41338k)).n());
        int i3 = this.f41336i.f41287a;
        int i4 = this.f41335h.f41287a;
        return i3 == i4 ? Util.Z0(j3, this.f41343p, jN) : Util.Z0(j3, this.f41343p * ((long) i4), jN * ((long) i3));
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        if (this.f41334g.f41287a != -1) {
            return this.f41329b || !a();
        }
        return false;
    }

    public void j(int i3) {
        Assertions.a(i3 == -1 || i3 > 0);
        this.f41330c = i3;
    }

    public void k(float f3) {
        Assertions.a(f3 > 0.0f);
        if (this.f41332e != f3) {
            this.f41332e = f3;
            this.f41337j = true;
        }
    }

    public void l(float f3) {
        Assertions.a(f3 > 0.0f);
        if (this.f41331d != f3) {
            this.f41331d = f3;
            this.f41337j = true;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        this.f41331d = 1.0f;
        this.f41332e = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41333f = audioFormat;
        this.f41334g = audioFormat;
        this.f41335h = audioFormat;
        this.f41336i = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f41285a;
        this.f41339l = byteBuffer;
        this.f41340m = byteBuffer.asShortBuffer();
        this.f41341n = byteBuffer;
        this.f41330c = -1;
        this.f41337j = false;
        this.f41338k = null;
        this.f41342o = 0L;
        this.f41343p = 0L;
        this.f41344q = false;
    }

    SonicAudioProcessor(boolean z2) {
        this.f41331d = 1.0f;
        this.f41332e = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41333f = audioFormat;
        this.f41334g = audioFormat;
        this.f41335h = audioFormat;
        this.f41336i = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f41285a;
        this.f41339l = byteBuffer;
        this.f41340m = byteBuffer.asShortBuffer();
        this.f41341n = byteBuffer;
        this.f41330c = -1;
        this.f41329b = z2;
    }
}
