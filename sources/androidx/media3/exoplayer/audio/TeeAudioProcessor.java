package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.WavUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TeeAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AudioBufferSink f43888i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AudioBufferSink {
        void a(ByteBuffer byteBuffer);

        void b(int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class WavFileAudioBufferSink implements AudioBufferSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f43889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f43890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ByteBuffer f43891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f43892d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f43893e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f43894f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private RandomAccessFile f43895g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f43896h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f43897i;

        private String c() {
            String str = this.f43889a;
            int i3 = this.f43896h;
            this.f43896h = i3 + 1;
            return Util.J("%s-%04d.wav", str, Integer.valueOf(i3));
        }

        private void d() throws IOException {
            if (this.f43895g != null) {
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
            g(randomAccessFile);
            this.f43895g = randomAccessFile;
            this.f43897i = 44;
        }

        private void e() {
            RandomAccessFile randomAccessFile = this.f43895g;
            if (randomAccessFile == null) {
                return;
            }
            try {
                this.f43891c.clear();
                this.f43891c.putInt(this.f43897i - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(this.f43890b, 0, 4);
                this.f43891c.clear();
                this.f43891c.putInt(this.f43897i - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(this.f43890b, 0, 4);
            } catch (IOException e3) {
                Log.j("WaveFileAudioBufferSink", "Error updating file size", e3);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.f43895g = null;
            }
        }

        private void f(ByteBuffer byteBuffer) throws IOException {
            RandomAccessFile randomAccessFile = (RandomAccessFile) Assertions.e(this.f43895g);
            while (byteBuffer.hasRemaining()) {
                int iMin = Math.min(byteBuffer.remaining(), this.f43890b.length);
                byteBuffer.get(this.f43890b, 0, iMin);
                randomAccessFile.write(this.f43890b, 0, iMin);
                this.f43897i += iMin;
            }
        }

        private void g(RandomAccessFile randomAccessFile) throws IOException {
            randomAccessFile.writeInt(1380533830);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(1463899717);
            randomAccessFile.writeInt(1718449184);
            this.f43891c.clear();
            this.f43891c.putInt(16);
            this.f43891c.putShort((short) WavUtil.b(this.f43894f));
            this.f43891c.putShort((short) this.f43893e);
            this.f43891c.putInt(this.f43892d);
            int iK0 = Util.k0(this.f43894f, this.f43893e);
            this.f43891c.putInt(this.f43892d * iK0);
            this.f43891c.putShort((short) iK0);
            this.f43891c.putShort((short) ((iK0 * 8) / this.f43893e));
            randomAccessFile.write(this.f43890b, 0, this.f43891c.position());
            randomAccessFile.writeInt(1684108385);
            randomAccessFile.writeInt(-1);
        }

        @Override // androidx.media3.exoplayer.audio.TeeAudioProcessor.AudioBufferSink
        public void a(ByteBuffer byteBuffer) {
            try {
                d();
                f(byteBuffer);
            } catch (IOException e3) {
                Log.e("WaveFileAudioBufferSink", "Error writing data", e3);
            }
        }

        @Override // androidx.media3.exoplayer.audio.TeeAudioProcessor.AudioBufferSink
        public void b(int i3, int i4, int i5) {
            try {
                e();
            } catch (IOException e3) {
                Log.e("WaveFileAudioBufferSink", "Error resetting", e3);
            }
            this.f43892d = i3;
            this.f43893e = i4;
            this.f43894f = i5;
        }
    }

    private void m() {
        if (isActive()) {
            AudioBufferSink audioBufferSink = this.f43888i;
            AudioProcessor.AudioFormat audioFormat = this.f41292b;
            audioBufferSink.b(audioFormat.f41287a, audioFormat.f41288b, audioFormat.f41289c);
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        this.f43888i.a(Util.H(byteBuffer));
        l(iRemaining).put(byteBuffer).flip();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void i() {
        m();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void j() {
        m();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void k() {
        m();
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }
}
