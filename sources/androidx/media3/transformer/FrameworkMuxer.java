package androidx.media3.transformer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Pair;
import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.Muxer;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class FrameworkMuxer implements Muxer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f48248h = "android.media:" + Util.f41609a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final ImmutableList f48249i = h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ImmutableList f48250j = ImmutableList.B("audio/mp4a-latm", "audio/3gpp", "audio/amr-wb");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaMuxer f48251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f48252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray f48253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray f48254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f48255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f48256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f48257g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Factory implements Muxer.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f48258a = -9223372036854775807L;

        @Override // androidx.media3.transformer.Muxer.Factory
        public ImmutableList b(int i3) {
            return i3 == 2 ? FrameworkMuxer.f48249i : i3 == 1 ? FrameworkMuxer.f48250j : ImmutableList.y();
        }

        @Override // androidx.media3.transformer.Muxer.Factory
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public FrameworkMuxer a(String str) throws MuxerException {
            try {
                return new FrameworkMuxer(new MediaMuxer(str, 0), this.f48258a);
            } catch (IOException e3) {
                throw new MuxerException("Error creating muxer", e3);
            }
        }
    }

    private static int f(Format format) {
        if (format.f40628k != null) {
            return ((Integer) ((Pair) Assertions.e(CodecSpecificDataUtil.o(format))).second).intValue();
        }
        int iMax = Integer.max(format.f40639v, format.f40640w);
        Assertions.g(iMax <= 7680);
        float f3 = format.f40639v * format.f40640w * format.f40641x;
        if (iMax <= 1280) {
            return f3 <= 2.21184E7f ? 1 : 2;
        }
        if (iMax <= 1920 && f3 <= 4.97664E7f) {
            return 4;
        }
        if (iMax <= 2560 && f3 <= 6.2208E7f) {
            return 8;
        }
        if (iMax > 3840) {
            if (iMax <= 7680) {
                return f3 <= 9.95328E8f ? 1024 : 2048;
            }
            return -1;
        }
        if (f3 <= 1.24416E8f) {
            return 16;
        }
        if (f3 <= 1.990656E8f) {
            return 32;
        }
        if (f3 <= 2.48832E8f) {
            return 64;
        }
        if (f3 <= 3.981312E8f) {
            return ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (f3 <= 4.97664E8f) {
            return Function.MAX_NARGS;
        }
        return 512;
    }

    private static int g() {
        return Function.MAX_NARGS;
    }

    private static ImmutableList h() {
        ImmutableList.Builder builderJ = new ImmutableList.Builder().j("video/avc", "video/3gpp", "video/mp4v-es");
        int i3 = Util.f41609a;
        if (i3 >= 24) {
            builderJ.a("video/hevc");
        }
        if (i3 >= 33) {
            builderJ.a("video/dolby-vision");
        }
        if (i3 >= 34) {
            builderJ.a("video/av01");
        }
        return builderJ.m();
    }

    private void i() throws MuxerException {
        try {
            this.f48251a.start();
            this.f48256f = true;
        } catch (RuntimeException e3) {
            throw new MuxerException("Failed to start the muxer", e3);
        }
    }

    private static void j(MediaMuxer mediaMuxer) {
        try {
            mediaMuxer.stop();
        } catch (RuntimeException e3) {
            if (Util.f41609a < 30) {
                try {
                    Field declaredField = MediaMuxer.class.getDeclaredField("MUXER_STATE_STOPPED");
                    declaredField.setAccessible(true);
                    Integer num = (Integer) Util.k((Integer) declaredField.get(mediaMuxer));
                    num.intValue();
                    Field declaredField2 = MediaMuxer.class.getDeclaredField("mState");
                    declaredField2.setAccessible(true);
                    declaredField2.set(mediaMuxer, num);
                } catch (Exception unused) {
                }
            }
            throw e3;
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void a(Metadata.Entry entry) {
        if (entry instanceof Mp4LocationData) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) entry;
            this.f48251a.setLocation(mp4LocationData.f41668a, mp4LocationData.f41669b);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void b(int i3, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) throws MuxerException {
        long j3 = bufferInfo.presentationTimeUs;
        long j4 = this.f48252b;
        if (j4 != -9223372036854775807L && i3 == this.f48255e && j3 > j4) {
            Log.i("FrameworkMuxer", String.format(Locale.US, "Skipped sample with presentation time (%d) > video duration (%d)", Long.valueOf(j3), Long.valueOf(this.f48252b)));
            return;
        }
        if (!this.f48256f) {
            if (Util.f41609a < 30 && j3 < 0) {
                this.f48254d.put(i3, Long.valueOf(-j3));
            }
            i();
        }
        long jLongValue = ((Long) this.f48254d.get(i3, 0L)).longValue();
        long j5 = j3 + jLongValue;
        long jLongValue2 = Util.t(this.f48253c, i3) ? ((Long) this.f48253c.get(i3)).longValue() : 0L;
        boolean z2 = true;
        Assertions.h(Util.f41609a > 24 || j5 >= jLongValue2, "Samples not in presentation order (" + j5 + " < " + jLongValue2 + ") unsupported on this API version");
        this.f48253c.put(i3, Long.valueOf(j5));
        if (jLongValue != 0 && j5 < 0) {
            z2 = false;
        }
        Assertions.h(z2, String.format(Locale.US, "Sample presentation time (%d) < first sample presentation time (%d). Ensure the first sample has the smallest timestamp when using the negative PTS workaround.", Long.valueOf(j5 - jLongValue), Long.valueOf(-jLongValue)));
        bufferInfo.set(bufferInfo.offset, bufferInfo.size, j5, bufferInfo.flags);
        try {
            this.f48251a.writeSampleData(i3, byteBuffer, bufferInfo);
        } catch (RuntimeException e3) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + j5 + ", size=" + bufferInfo.size, e3);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public int c(Format format) throws MuxerException {
        MediaFormat mediaFormatCreateAudioFormat;
        String str = (String) Assertions.e(format.f40632o);
        boolean zQ = MimeTypes.q(str);
        if (zQ) {
            mediaFormatCreateAudioFormat = MediaFormat.createVideoFormat(str, format.f40639v, format.f40640w);
            MediaFormatUtil.n(mediaFormatCreateAudioFormat, format.C);
            if (str.equals("video/dolby-vision") && Util.f41609a >= 33) {
                mediaFormatCreateAudioFormat.setInteger("profile", g());
                mediaFormatCreateAudioFormat.setInteger(AppLovinEventTypes.USER_COMPLETED_LEVEL, f(format));
            }
            try {
                this.f48251a.setOrientationHint(format.f40642y);
            } catch (RuntimeException e3) {
                throw new MuxerException("Failed to set orientation hint with rotationDegrees=" + format.f40642y, e3);
            }
        } else {
            mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(str, format.F, format.E);
            MediaFormatUtil.s(mediaFormatCreateAudioFormat, "language", format.f40621d);
        }
        MediaFormatUtil.u(mediaFormatCreateAudioFormat, format.f40635r);
        try {
            int iAddTrack = this.f48251a.addTrack(mediaFormatCreateAudioFormat);
            if (zQ) {
                this.f48255e = iAddTrack;
            }
            return iAddTrack;
        } catch (RuntimeException e4) {
            throw new MuxerException("Failed to add track with format=" + format, e4);
        }
    }

    @Override // androidx.media3.transformer.Muxer
    public void close() throws MuxerException {
        if (this.f48257g) {
            return;
        }
        if (!this.f48256f) {
            i();
        }
        if (this.f48252b != -9223372036854775807L && this.f48255e != -1) {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            bufferInfo.set(0, 0, this.f48252b, TransformerUtil.e(4));
            b(this.f48255e, ByteBuffer.allocateDirect(0), bufferInfo);
        }
        this.f48256f = false;
        try {
            try {
                j(this.f48251a);
            } catch (RuntimeException e3) {
                throw new MuxerException("Failed to stop the MediaMuxer", e3);
            }
        } finally {
            this.f48251a.release();
            this.f48257g = true;
        }
    }

    private FrameworkMuxer(MediaMuxer mediaMuxer, long j3) {
        this.f48251a = mediaMuxer;
        this.f48252b = j3;
        this.f48253c = new SparseArray();
        this.f48254d = new SparseArray();
        this.f48255e = -1;
    }
}
