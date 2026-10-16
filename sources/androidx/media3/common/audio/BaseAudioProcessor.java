package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected AudioProcessor.AudioFormat f41292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected AudioProcessor.AudioFormat f41293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f41296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f41297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f41298h;

    public BaseAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.f41285a;
        this.f41296f = byteBuffer;
        this.f41297g = byteBuffer;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41294d = audioFormat;
        this.f41295e = audioFormat;
        this.f41292b = audioFormat;
        this.f41293c = audioFormat;
    }

    protected final boolean a() {
        return this.f41297g.hasRemaining();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean b() {
        return this.f41298h && this.f41297g == AudioProcessor.f41285a;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.f41297g;
        this.f41297g = AudioProcessor.f41285a;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void e() {
        this.f41298h = true;
        j();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final AudioProcessor.AudioFormat f(AudioProcessor.AudioFormat audioFormat) {
        this.f41294d = audioFormat;
        this.f41295e = h(audioFormat);
        return isActive() ? this.f41295e : AudioProcessor.AudioFormat.f41286e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void flush() {
        this.f41297g = AudioProcessor.f41285a;
        this.f41298h = false;
        this.f41292b = this.f41294d;
        this.f41293c = this.f41295e;
        i();
    }

    protected AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) {
        return AudioProcessor.AudioFormat.f41286e;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return this.f41295e != AudioProcessor.AudioFormat.f41286e;
    }

    protected final ByteBuffer l(int i3) {
        if (this.f41296f.capacity() < i3) {
            this.f41296f = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.f41296f.clear();
        }
        ByteBuffer byteBuffer = this.f41296f;
        this.f41297g = byteBuffer;
        return byteBuffer;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public final void reset() {
        flush();
        this.f41296f = AudioProcessor.f41285a;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41294d = audioFormat;
        this.f41295e = audioFormat;
        this.f41292b = audioFormat;
        this.f41293c = audioFormat;
        k();
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void k() {
    }
}
