package androidx.media3.exoplayer.audio;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioMixingUtil;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.audio.TeeAudioProcessor;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WaveformAudioBufferSink implements TeeAudioProcessor.AudioBufferSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f43906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f43907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f43908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteBuffer f43909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioProcessor.AudioFormat f43910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AudioProcessor.AudioFormat f43911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ChannelMixingMatrix f43912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f43913h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(int i3, WaveformBar waveformBar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class WaveformBar {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f43914a = 1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f43915b = -1.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f43916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f43917d;

        public void a(float f3) {
            Preconditions.d(f3 >= -1.0f && f3 <= 1.0f);
            this.f43914a = Math.min(this.f43914a, f3);
            this.f43915b = Math.max(this.f43915b, f3);
            double d3 = f3;
            this.f43916c += d3 * d3;
            this.f43917d++;
        }

        public int b() {
            return this.f43917d;
        }
    }

    @Override // androidx.media3.exoplayer.audio.TeeAudioProcessor.AudioBufferSink
    public void a(ByteBuffer byteBuffer) {
        Assertions.i(this.f43910e);
        Assertions.i(this.f43911f);
        Assertions.i(this.f43912g);
        while (byteBuffer.hasRemaining()) {
            this.f43909d.rewind();
            ByteBuffer byteBuffer2 = byteBuffer;
            AudioMixingUtil.f(byteBuffer2, this.f43910e, this.f43909d, this.f43911f, this.f43912g, 1, false, true);
            this.f43909d.rewind();
            for (int i3 = 0; i3 < this.f43908c.size(); i3++) {
                WaveformBar waveformBar = (WaveformBar) this.f43908c.get(i3);
                waveformBar.a(this.f43909d.getFloat());
                if (waveformBar.b() >= this.f43913h) {
                    this.f43907b.a(i3, waveformBar);
                    this.f43908c.put(i3, new WaveformBar());
                }
            }
            byteBuffer = byteBuffer2;
        }
    }

    @Override // androidx.media3.exoplayer.audio.TeeAudioProcessor.AudioBufferSink
    public void b(int i3, int i4, int i5) {
        this.f43913h = i3 / this.f43906a;
        this.f43910e = new AudioProcessor.AudioFormat(i3, i4, i5);
        this.f43911f = new AudioProcessor.AudioFormat(i3, this.f43908c.size(), 4);
        this.f43912g = ChannelMixingMatrix.b(i4, this.f43908c.size());
    }
}
