package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.SpeedProviderUtil;
import androidx.media3.common.util.TimestampConsumer;
import androidx.media3.common.util.Util;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpeedChangingAudioProcessor implements AudioProcessor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f41345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SpeedProvider f41346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SynchronizedSonicAudioProcessor f41347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LongArrayQueue f41348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Queue f41349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f41350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f41351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f41352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AudioProcessor.AudioFormat f41355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f41356m;

    public SpeedChangingAudioProcessor(SpeedProvider speedProvider) {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41354k = audioFormat;
        this.f41355l = audioFormat;
        this.f41353j = audioFormat;
        this.f41346c = speedProvider;
        Object obj = new Object();
        this.f41345b = obj;
        this.f41347d = new SynchronizedSonicAudioProcessor(obj, true);
        this.f41348e = new LongArrayQueue();
        this.f41349f = new ArrayDeque();
        j(true);
    }

    private static long a(SpeedProvider speedProvider, int i3, long j3) {
        return Util.Y0(h(speedProvider, i3, Util.b1(j3, i3, 1000000L, RoundingMode.HALF_EVEN)), i3);
    }

    public static long h(SpeedProvider speedProvider, int i3, long j3) {
        Assertions.a(speedProvider != null);
        Assertions.a(i3 > 0);
        long j4 = 0;
        Assertions.a(j3 >= 0);
        long jK = 0;
        while (j4 < j3) {
            long jB = SpeedProviderUtil.b(speedProvider, j4, i3);
            if (jB == -1 || jB > j3) {
                jB = j3;
            }
            float fC = SpeedProviderUtil.c(speedProvider, j4, i3);
            jK += Sonic.k(i3, i3, fC, fC, jB - j4);
            j4 = jB;
        }
        return jK;
    }

    private void i() {
        synchronized (this.f41345b) {
            try {
                if (this.f41353j.f41287a == -1) {
                    return;
                }
                while (!this.f41349f.isEmpty()) {
                    ((TimestampConsumer) this.f41349f.remove()).a(a(this.f41346c, this.f41353j.f41287a, this.f41348e.f()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j(boolean z2) {
        if (z2) {
            this.f41350g = 1.0f;
        }
        this.f41351h = 0L;
        this.f41352i = false;
    }

    private void k(float f3) {
        if (f3 != this.f41350g) {
            this.f41350g = f3;
            this.f41347d.i(f3);
            this.f41347d.h(f3);
            this.f41347d.flush();
            this.f41352i = false;
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean b() {
        return this.f41356m && this.f41347d.b();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public ByteBuffer c() {
        return this.f41347d.c();
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        AudioProcessor.AudioFormat audioFormat;
        int i3;
        synchronized (this.f41345b) {
            audioFormat = this.f41353j;
        }
        float fC = SpeedProviderUtil.c(this.f41346c, this.f41351h, audioFormat.f41287a);
        long jB = SpeedProviderUtil.b(this.f41346c, this.f41351h, audioFormat.f41287a);
        k(fC);
        int iLimit = byteBuffer.limit();
        if (jB != -1) {
            i3 = (int) ((jB - this.f41351h) * ((long) audioFormat.f41290d));
            byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + i3));
        } else {
            i3 = -1;
        }
        long jPosition = byteBuffer.position();
        this.f41347d.d(byteBuffer);
        if (i3 != -1 && ((long) byteBuffer.position()) - jPosition == i3) {
            this.f41347d.e();
            this.f41352i = true;
        }
        long jPosition2 = ((long) byteBuffer.position()) - jPosition;
        Assertions.h(jPosition2 % ((long) audioFormat.f41290d) == 0, "A frame was not queued completely.");
        this.f41351h += jPosition2 / ((long) audioFormat.f41290d);
        byteBuffer.limit(iLimit);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void e() {
        this.f41356m = true;
        if (this.f41352i) {
            return;
        }
        this.f41347d.e();
        this.f41352i = true;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public AudioProcessor.AudioFormat f(AudioProcessor.AudioFormat audioFormat) {
        this.f41354k = audioFormat;
        AudioProcessor.AudioFormat audioFormatF = this.f41347d.f(audioFormat);
        this.f41355l = audioFormatF;
        return audioFormatF;
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void flush() {
        this.f41356m = false;
        j(false);
        synchronized (this.f41345b) {
            this.f41353j = this.f41354k;
            this.f41347d.flush();
            i();
        }
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public long g(long j3) {
        return SpeedProviderUtil.a(this.f41346c, j3);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public boolean isActive() {
        return !this.f41355l.equals(AudioProcessor.AudioFormat.f41286e);
    }

    @Override // androidx.media3.common.audio.AudioProcessor
    public void reset() {
        flush();
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f41286e;
        this.f41354k = audioFormat;
        this.f41355l = audioFormat;
        synchronized (this.f41345b) {
            this.f41353j = audioFormat;
            this.f41348e.b();
            this.f41349f.clear();
        }
        j(true);
        this.f41347d.reset();
    }
}
