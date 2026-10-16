package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioProcessingPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f41279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f41280b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f41281c = new ByteBuffer[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f41284f;

    public AudioProcessingPipeline(ImmutableList immutableList) {
        this.f41279a = immutableList;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41282d = audioFormat;
        this.f41283e = audioFormat;
        this.f41284f = false;
    }

    private int c() {
        return this.f41281c.length - 1;
    }

    private void h(ByteBuffer byteBuffer) {
        boolean z2;
        for (boolean z3 = true; z3; z3 = z2) {
            z2 = false;
            int i3 = 0;
            while (i3 <= c()) {
                if (!this.f41281c[i3].hasRemaining()) {
                    AudioProcessor audioProcessor = (AudioProcessor) this.f41280b.get(i3);
                    if (!audioProcessor.b()) {
                        ByteBuffer byteBuffer2 = i3 > 0 ? this.f41281c[i3 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f41285a;
                        long jRemaining = byteBuffer2.remaining();
                        audioProcessor.d(byteBuffer2);
                        this.f41281c[i3] = audioProcessor.c();
                        z2 |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.f41281c[i3].hasRemaining();
                    } else if (!this.f41281c[i3].hasRemaining() && i3 < c()) {
                        ((AudioProcessor) this.f41280b.get(i3 + 1)).e();
                    }
                }
                i3++;
            }
        }
    }

    public AudioProcessor.AudioFormat a(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.equals(AudioProcessor.AudioFormat.f41286e)) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        for (int i3 = 0; i3 < this.f41279a.size(); i3++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f41279a.get(i3);
            AudioProcessor.AudioFormat audioFormatF = audioProcessor.f(audioFormat);
            if (audioProcessor.isActive()) {
                Assertions.g(!audioFormatF.equals(AudioProcessor.AudioFormat.f41286e));
                audioFormat = audioFormatF;
            }
        }
        this.f41283e = audioFormat;
        return audioFormat;
    }

    public void b() {
        this.f41280b.clear();
        this.f41282d = this.f41283e;
        this.f41284f = false;
        for (int i3 = 0; i3 < this.f41279a.size(); i3++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f41279a.get(i3);
            audioProcessor.flush();
            if (audioProcessor.isActive()) {
                this.f41280b.add(audioProcessor);
            }
        }
        this.f41281c = new ByteBuffer[this.f41280b.size()];
        for (int i4 = 0; i4 <= c(); i4++) {
            this.f41281c[i4] = ((AudioProcessor) this.f41280b.get(i4)).c();
        }
    }

    public ByteBuffer d() {
        if (!g()) {
            return AudioProcessor.f41285a;
        }
        ByteBuffer byteBuffer = this.f41281c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        h(AudioProcessor.f41285a);
        return this.f41281c[c()];
    }

    public AudioProcessor.AudioFormat e() {
        return this.f41282d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioProcessingPipeline)) {
            return false;
        }
        AudioProcessingPipeline audioProcessingPipeline = (AudioProcessingPipeline) obj;
        if (this.f41279a.size() != audioProcessingPipeline.f41279a.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f41279a.size(); i3++) {
            if (this.f41279a.get(i3) != audioProcessingPipeline.f41279a.get(i3)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return this.f41284f && ((AudioProcessor) this.f41280b.get(c())).b() && !this.f41281c[c()].hasRemaining();
    }

    public boolean g() {
        return !this.f41280b.isEmpty();
    }

    public int hashCode() {
        return this.f41279a.hashCode();
    }

    public void i() {
        if (!g() || this.f41284f) {
            return;
        }
        this.f41284f = true;
        ((AudioProcessor) this.f41280b.get(0)).e();
    }

    public void j(ByteBuffer byteBuffer) {
        if (!g() || this.f41284f) {
            return;
        }
        h(byteBuffer);
    }

    public void k() {
        for (int i3 = 0; i3 < this.f41279a.size(); i3++) {
            AudioProcessor audioProcessor = (AudioProcessor) this.f41279a.get(i3);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f41281c = new ByteBuffer[0];
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41282d = audioFormat;
        this.f41283e = audioFormat;
        this.f41284f = false;
    }
}
