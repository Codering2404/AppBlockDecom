package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TrimmingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f43900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f43901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f43902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f43903m = Util.f41614f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f43905o;

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public boolean b() {
        return super.b() && this.f43904n == 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public ByteBuffer c() {
        int i3;
        if (super.b() && (i3 = this.f43904n) > 0) {
            l(i3).put(this.f43903m, 0, this.f43904n).flip();
            this.f43904n = 0;
        }
        return super.c();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        if (i3 == 0) {
            return;
        }
        int iMin = Math.min(i3, this.f43902l);
        this.f43905o += (long) (iMin / this.f41292b.f41290d);
        this.f43902l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f43902l > 0) {
            return;
        }
        int i4 = i3 - iMin;
        int length = (this.f43904n + i4) - this.f43903m.length;
        ByteBuffer byteBufferL = l(length);
        int iR = Util.r(length, 0, this.f43904n);
        byteBufferL.put(this.f43903m, 0, iR);
        int iR2 = Util.r(length - iR, 0, i4);
        byteBuffer.limit(byteBuffer.position() + iR2);
        byteBufferL.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i5 = i4 - iR2;
        int i6 = this.f43904n - iR;
        this.f43904n = i6;
        byte[] bArr = this.f43903m;
        System.arraycopy(bArr, iR, bArr, 0, i6);
        byteBuffer.get(this.f43903m, this.f43904n, i5);
        this.f43904n += i5;
        byteBufferL.flip();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public long g(long j3) {
        return j3 - Util.Y0(this.f43900j + this.f43899i, this.f41292b.f41287a);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i3 = audioFormat.f41289c;
        if (i3 != 2 && i3 != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
        }
        this.f43901k = true;
        return (this.f43899i == 0 && this.f43900j == 0) ? AudioProcessor.AudioFormat.f41286e : audioFormat;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void i() {
        if (this.f43901k) {
            this.f43901k = false;
            int i3 = this.f43900j;
            int i4 = this.f41292b.f41290d;
            this.f43903m = new byte[i3 * i4];
            this.f43902l = this.f43899i * i4;
        }
        this.f43904n = 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void j() {
        if (this.f43901k) {
            int i3 = this.f43904n;
            if (i3 > 0) {
                this.f43905o += (long) (i3 / this.f41292b.f41290d);
            }
            this.f43904n = 0;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected void k() {
        this.f43903m = Util.f41614f;
    }

    public long m() {
        return this.f43905o;
    }

    public void n() {
        this.f43905o = 0L;
    }

    public void o(int i3, int i4) {
        this.f43899i = i3;
        this.f43900j = i4;
    }
}
