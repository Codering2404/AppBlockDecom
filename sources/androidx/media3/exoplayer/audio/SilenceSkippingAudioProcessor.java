package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SilenceSkippingAudioProcessor extends androidx.media3.common.audio.BaseAudioProcessor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f43874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final short f43875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f43876k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f43877l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f43878m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f43879n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43880o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f43881p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f43882q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f43883r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private byte[] f43884s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f43885t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f43886u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte[] f43887v;

    public SilenceSkippingAudioProcessor() {
        this(100000L, 0.2f, 2000000L, 10, (short) 1024);
    }

    private void A(int i3, int i4) {
        if (i3 == 0) {
            return;
        }
        Assertions.a(this.f43886u >= i3);
        if (i4 == 2) {
            int i5 = this.f43885t;
            int i6 = this.f43886u;
            int i7 = i5 + i6;
            byte[] bArr = this.f43884s;
            if (i7 <= bArr.length) {
                System.arraycopy(bArr, (i5 + i6) - i3, this.f43887v, 0, i3);
            } else {
                int length = i6 - (bArr.length - i5);
                if (length >= i3) {
                    System.arraycopy(bArr, length - i3, this.f43887v, 0, i3);
                } else {
                    int i8 = i3 - length;
                    System.arraycopy(bArr, bArr.length - i8, this.f43887v, 0, i8);
                    System.arraycopy(this.f43884s, 0, this.f43887v, i8, length);
                }
            }
        } else {
            int i9 = this.f43885t;
            int i10 = i9 + i3;
            byte[] bArr2 = this.f43884s;
            if (i10 <= bArr2.length) {
                System.arraycopy(bArr2, i9, this.f43887v, 0, i3);
            } else {
                int length2 = bArr2.length - i9;
                System.arraycopy(bArr2, i9, this.f43887v, 0, length2);
                System.arraycopy(this.f43884s, 0, this.f43887v, length2, i3 - length2);
            }
        }
        Assertions.b(i3 % this.f43879n == 0, "sizeToOutput is not aligned to frame size: " + i3);
        Assertions.g(this.f43885t < this.f43884s.length);
        y(this.f43887v, i3, i4);
    }

    private void B(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f43884s.length));
        int iS = s(byteBuffer);
        if (iS == byteBuffer.position()) {
            this.f43881p = 1;
        } else {
            byteBuffer.limit(Math.min(iS, byteBuffer.capacity()));
            x(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private static void C(byte[] bArr, int i3, int i4) {
        if (i4 >= 32767) {
            bArr[i3] = -1;
            bArr[i3 + 1] = Ascii.DEL;
        } else if (i4 <= -32768) {
            bArr[i3] = 0;
            bArr[i3 + 1] = -128;
        } else {
            bArr[i3] = (byte) (i4 & 255);
            bArr[i3 + 1] = (byte) (i4 >> 8);
        }
    }

    private void E(ByteBuffer byteBuffer) {
        int length;
        int i3;
        Assertions.g(this.f43885t < this.f43884s.length);
        int iLimit = byteBuffer.limit();
        int iT = t(byteBuffer);
        int iPosition = iT - byteBuffer.position();
        int i4 = this.f43885t;
        int i5 = this.f43886u;
        int i6 = i4 + i5;
        byte[] bArr = this.f43884s;
        if (i6 < bArr.length) {
            length = bArr.length - (i5 + i4);
            i3 = i4 + i5;
        } else {
            int length2 = i5 - (bArr.length - i4);
            length = i4 - length2;
            i3 = length2;
        }
        boolean z2 = iT < iLimit;
        int iMin = Math.min(iPosition, length);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f43884s, i3, iMin);
        int i7 = this.f43886u + iMin;
        this.f43886u = i7;
        Assertions.g(i7 <= this.f43884s.length);
        boolean z3 = z2 && iPosition < length;
        z(z3);
        if (z3) {
            this.f43881p = 0;
            this.f43883r = 0;
        }
        byteBuffer.limit(iLimit);
    }

    private static int F(byte b3, byte b4) {
        return (b3 << 8) | (b4 & 255);
    }

    private int m(float f3) {
        return n((int) f3);
    }

    private int n(int i3) {
        int i4 = this.f43879n;
        return (i3 / i4) * i4;
    }

    private int o(int i3, int i4) {
        int i5 = this.f43876k;
        return i5 + ((((100 - i5) * (i3 * 1000)) / i4) / 1000);
    }

    private int p(int i3, int i4) {
        return (((this.f43876k - 100) * ((i3 * 1000) / i4)) / 1000) + 100;
    }

    private int q(int i3) {
        int iR = ((r(this.f43878m) - this.f43883r) * this.f43879n) - (this.f43884s.length / 2);
        Assertions.g(iR >= 0);
        return m(Math.min((i3 * this.f43874i) + 0.5f, iR));
    }

    private int r(long j3) {
        return (int) ((j3 * ((long) this.f41292b.f41287a)) / 1000000);
    }

    private int s(ByteBuffer byteBuffer) {
        for (int iLimit = byteBuffer.limit() - 1; iLimit >= byteBuffer.position(); iLimit -= 2) {
            if (v(byteBuffer.get(iLimit), byteBuffer.get(iLimit - 1))) {
                int i3 = this.f43879n;
                return ((iLimit / i3) * i3) + i3;
            }
        }
        return byteBuffer.position();
    }

    private int t(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position() + 1; iPosition < byteBuffer.limit(); iPosition += 2) {
            if (v(byteBuffer.get(iPosition), byteBuffer.get(iPosition - 1))) {
                int i3 = this.f43879n;
                return i3 * (iPosition / i3);
            }
        }
        return byteBuffer.limit();
    }

    private boolean v(byte b3, byte b4) {
        return Math.abs(F(b3, b4)) > this.f43875j;
    }

    private void w(byte[] bArr, int i3, int i4) {
        if (i4 == 3) {
            return;
        }
        for (int i5 = 0; i5 < i3; i5 += 2) {
            C(bArr, i5, (F(bArr[i5 + 1], bArr[i5]) * (i4 == 0 ? p(i5, i3 - 1) : i4 == 2 ? o(i5, i3 - 1) : this.f43876k)) / 100);
        }
    }

    private void x(ByteBuffer byteBuffer) {
        l(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    private void y(byte[] bArr, int i3, int i4) {
        Assertions.b(i3 % this.f43879n == 0, "byteOutput size is not aligned to frame size " + i3);
        w(bArr, i3, i4);
        l(i3).put(bArr, 0, i3).flip();
    }

    private void z(boolean z2) {
        int length;
        int iQ;
        int i3 = this.f43886u;
        byte[] bArr = this.f43884s;
        if (i3 == bArr.length || z2) {
            if (this.f43883r == 0) {
                if (z2) {
                    A(i3, 3);
                    length = i3;
                } else {
                    Assertions.g(i3 >= bArr.length / 2);
                    length = this.f43884s.length / 2;
                    A(length, 0);
                }
                iQ = length;
            } else if (z2) {
                int length2 = i3 - (bArr.length / 2);
                int length3 = (bArr.length / 2) + length2;
                int iQ2 = q(length2) + (this.f43884s.length / 2);
                A(iQ2, 2);
                iQ = iQ2;
                length = length3;
            } else {
                length = i3 - (bArr.length / 2);
                iQ = q(length);
                A(iQ, 1);
            }
            Assertions.h(length % this.f43879n == 0, "bytesConsumed is not aligned to frame size: %s" + length);
            Assertions.g(i3 >= iQ);
            this.f43886u -= length;
            int i4 = this.f43885t + length;
            this.f43885t = i4;
            this.f43885t = i4 % this.f43884s.length;
            int i5 = this.f43883r;
            int i6 = this.f43879n;
            this.f43883r = i5 + (iQ / i6);
            this.f43882q += (long) ((length - iQ) / i6);
        }
    }

    public void D(boolean z2) {
        this.f43880o = z2;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i3 = this.f43881p;
            if (i3 == 0) {
                B(byteBuffer);
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException();
                }
                E(byteBuffer);
            }
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    protected AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f41289c == 2) {
            return audioFormat.f41287a == -1 ? AudioProcessor.AudioFormat.f41286e : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public void i() {
        if (isActive()) {
            this.f43879n = this.f41292b.f41288b * 2;
            int iN = n(r(this.f43877l) / 2) * 2;
            if (this.f43884s.length != iN) {
                this.f43884s = new byte[iN];
                this.f43887v = new byte[iN];
            }
        }
        this.f43881p = 0;
        this.f43882q = 0L;
        this.f43883r = 0;
        this.f43885t = 0;
        this.f43886u = 0;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor, androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return super.isActive() && this.f43880o;
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public void j() {
        if (this.f43886u > 0) {
            z(true);
            this.f43883r = 0;
        }
    }

    @Override // androidx.media3.common.audio.BaseAudioProcessor
    public void k() {
        this.f43880o = false;
        byte[] bArr = Util.f41614f;
        this.f43884s = bArr;
        this.f43887v = bArr;
    }

    public long u() {
        return this.f43882q;
    }

    public SilenceSkippingAudioProcessor(long j3, float f3, long j4, int i3, short s2) {
        boolean z2 = false;
        this.f43883r = 0;
        this.f43885t = 0;
        this.f43886u = 0;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            z2 = true;
        }
        Assertions.a(z2);
        this.f43877l = j3;
        this.f43874i = f3;
        this.f43878m = j4;
        this.f43876k = i3;
        this.f43875j = s2;
        byte[] bArr = Util.f41614f;
        this.f43884s = bArr;
        this.f43887v = bArr;
    }
}
