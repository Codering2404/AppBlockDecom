package androidx.media3.transformer;

import android.media.MediaCodec;
import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.effect.DebugTraceUtil;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.Muxer;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.io.File;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MuxerWrapper {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f48310u = Util.P0(500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f48311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Muxer.Factory f48312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Listener f48313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f48314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SparseArray f48315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Format f48316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MediaCodec.BufferInfo f48317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f48318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f48319i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f48320j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f48321k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f48322l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f48323m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Muxer f48324n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f48325o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f48326p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48327q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f48328r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private volatile int f48329s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile int f48330t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AppendTrackFormatException extends Exception {
        public AppendTrackFormatException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(int i3, Format format, int i4, int i5);

        void b();

        void e(long j3, long j4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MuxerMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MuxerReleaseReason {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class TrackInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f48331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f48332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f48333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f48334d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f48335e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f48336f;

        public TrackInfo(Format format, int i3) {
            this.f48331a = format;
            this.f48332b = i3;
        }

        public int a() {
            long j3 = this.f48336f;
            if (j3 <= 0) {
                return -2147483647;
            }
            long j4 = this.f48334d;
            if (j4 <= 0) {
                return -2147483647;
            }
            long j5 = this.f48333c;
            if (j3 == j5) {
                return -2147483647;
            }
            return (int) Util.Z0(j4, 8000000L, j3 - j5);
        }
    }

    public MuxerWrapper(String str, Muxer.Factory factory, Listener listener, int i3, boolean z2, Format format) {
        this.f48311a = str;
        this.f48312b = factory;
        this.f48313c = listener;
        boolean z3 = false;
        Assertions.a(i3 == 0 || i3 == 1);
        this.f48325o = i3;
        this.f48314d = z2;
        if ((i3 == 0 && format == null) || (i3 == 1 && format != null)) {
            z3 = true;
        }
        Assertions.b(z3, "appendVideoFormat must be present if and only if muxerMode is MUXER_MODE_MUX_PARTIAL.");
        this.f48316f = format;
        this.f48315e = new SparseArray();
        this.f48320j = -2;
        this.f48328r = -9223372036854775807L;
        this.f48322l = Long.MAX_VALUE;
        this.f48317g = new MediaCodec.BufferInfo();
    }

    private boolean b(int i3, long j3) {
        if ((this.f48314d && i3 != 2 && Util.t(this.f48315e, 2) && this.f48328r == -9223372036854775807L) || !this.f48318h) {
            return false;
        }
        if (this.f48315e.size() == 1) {
            return true;
        }
        long j4 = j3 - ((TrackInfo) this.f48315e.get(i3)).f48336f;
        long j5 = f48310u;
        if (j4 > j5 && MimeTypes.k(((TrackInfo) Assertions.e(j(this.f48315e))).f48331a.f40632o) == i3) {
            return true;
        }
        if (i3 != this.f48320j) {
            this.f48321k = ((TrackInfo) Assertions.e(j(this.f48315e))).f48336f;
        }
        return j3 - this.f48321k <= j5;
    }

    private void e() {
        if (this.f48324n == null) {
            this.f48324n = this.f48312b.a(this.f48311a);
        }
    }

    private long g() {
        long length = new File(this.f48311a).length();
        if (length > 0) {
            return length;
        }
        return -1L;
    }

    public static List h(Format format, Format format2) {
        if (format.f(format2)) {
            return format.f40635r;
        }
        if (!Objects.equals(format2.f40632o, "video/avc") || !Objects.equals(format.f40632o, "video/avc") || format2.f40635r.size() != 2 || format.f40635r.size() != 2 || !Arrays.equals((byte[]) format2.f40635r.get(1), (byte[]) format.f40635r.get(1))) {
            return null;
        }
        int i3 = 0;
        byte[] bArr = (byte[]) format2.f40635r.get(0);
        byte[] bArr2 = (byte[]) format.f40635r.get(0);
        int length = NalUnitUtil.f41674a.length + 3;
        if (length >= bArr.length || bArr.length != bArr2.length) {
            return null;
        }
        for (int i4 = 0; i4 < bArr.length; i4++) {
            if (i4 != length && bArr[i4] != bArr2[i4]) {
                return null;
            }
        }
        while (true) {
            byte[] bArr3 = NalUnitUtil.f41674a;
            if (i3 >= bArr3.length) {
                if ((bArr[bArr3.length] & Ascii.US) == 7 && bArr[bArr3.length + 1] != 0) {
                    return bArr2[length] >= bArr[length] ? format.f40635r : format2.f40635r;
                }
                return null;
            }
            if (bArr[i3] != bArr3[i3]) {
                return null;
            }
            i3++;
        }
    }

    private static TrackInfo j(SparseArray sparseArray) {
        if (sparseArray.size() == 0) {
            return null;
        }
        TrackInfo trackInfo = (TrackInfo) sparseArray.valueAt(0);
        for (int i3 = 1; i3 < sparseArray.size(); i3++) {
            TrackInfo trackInfo2 = (TrackInfo) sparseArray.valueAt(i3);
            if (trackInfo2.f48336f < trackInfo.f48336f) {
                trackInfo = trackInfo2;
            }
        }
        return trackInfo;
    }

    public void a(Format format) throws AppendTrackFormatException {
        String str = format.f40632o;
        int iK = MimeTypes.k(str);
        Assertions.b(iK == 1 || iK == 2, "Unsupported track format: " + str);
        if (iK == 2) {
            format = format.b().t0((format.f40642y + this.f48329s) % 360).N();
            if (this.f48325o == 1) {
                List listH = h(format, (Format) Assertions.e(this.f48316f));
                if (listH == null) {
                    throw new AppendTrackFormatException("Switching to MUXER_MODE_APPEND will fail.");
                }
                format = format.b().g0(listH).N();
            }
        }
        if (this.f48325o != 2) {
            int i3 = this.f48330t;
            Assertions.h(i3 > 0, "The track count should be set before the formats are added.");
            Assertions.h(this.f48315e.size() < i3, "All track formats have already been added.");
            Assertions.h(!Util.t(this.f48315e, iK), "There is already a track of type " + iK);
            e();
            this.f48315e.put(iK, new TrackInfo(format, this.f48324n.c(format)));
            DebugTraceUtil.f("Muxer", "InputFormat", -9223372036854775807L, "%s:%s", Util.s0(iK), format);
            if (format.f40629l != null) {
                for (int i4 = 0; i4 < format.f40629l.e(); i4++) {
                    this.f48324n.a(format.f40629l.d(i4));
                }
            }
            if (this.f48315e.size() == i3) {
                this.f48318h = true;
                return;
            }
            return;
        }
        if (iK != 2) {
            if (iK == 1) {
                Assertions.g(Util.t(this.f48315e, 1));
                Format format2 = ((TrackInfo) this.f48315e.get(1)).f48331a;
                if (!Objects.equals(format2.f40632o, format.f40632o)) {
                    throw new AppendTrackFormatException("Audio format mismatch - sampleMimeType: " + format2.f40632o + " != " + format.f40632o);
                }
                if (format2.E != format.E) {
                    throw new AppendTrackFormatException("Audio format mismatch - channelCount: " + format2.E + " != " + format.E);
                }
                if (format2.F == format.F) {
                    if (!format2.f(format)) {
                        throw new AppendTrackFormatException("Audio format mismatch - initializationData.");
                    }
                    return;
                }
                throw new AppendTrackFormatException("Audio format mismatch - sampleRate: " + format2.F + " != " + format.F);
            }
            return;
        }
        Assertions.g(Util.t(this.f48315e, 2));
        Format format3 = ((TrackInfo) this.f48315e.get(2)).f48331a;
        if (!Objects.equals(format3.f40632o, format.f40632o)) {
            throw new AppendTrackFormatException("Video format mismatch - sampleMimeType: " + format3.f40632o + " != " + format.f40632o);
        }
        if (format3.f40639v != format.f40639v) {
            throw new AppendTrackFormatException("Video format mismatch - width: " + format3.f40639v + " != " + format.f40639v);
        }
        if (format3.f40640w != format.f40640w) {
            throw new AppendTrackFormatException("Video format mismatch - height: " + format3.f40640w + " != " + format.f40640w);
        }
        if (format3.f40642y == format.f40642y) {
            if (!format.f((Format) Assertions.e(this.f48316f))) {
                throw new AppendTrackFormatException("The initialization data of the newly added track format doesn't match appendVideoFormat.");
            }
            return;
        }
        throw new AppendTrackFormatException("Video format mismatch - rotationDegrees: " + format3.f40642y + " != " + format.f40642y);
    }

    public void c() {
        Assertions.g(this.f48325o == 1);
        this.f48325o = 2;
    }

    public void d(int i3) {
        if (this.f48318h && Util.t(this.f48315e, i3)) {
            TrackInfo trackInfo = (TrackInfo) this.f48315e.get(i3);
            this.f48322l = Math.max(0L, Math.min(this.f48322l, trackInfo.f48333c));
            this.f48323m = Math.max(this.f48323m, trackInfo.f48336f);
            this.f48313c.a(i3, trackInfo.f48331a, trackInfo.a(), trackInfo.f48335e);
            DebugTraceUtil.f("Muxer", "InputEnded", trackInfo.f48336f, "%s", Util.s0(i3));
            if (this.f48325o != 1) {
                this.f48315e.delete(i3);
                if (this.f48315e.size() == 0) {
                    this.f48319i = true;
                    DebugTraceUtil.e("Muxer", "OutputEnded", this.f48323m);
                }
            } else if (i3 == 2) {
                this.f48326p = true;
            } else if (i3 == 1) {
                this.f48327q = true;
            }
            long jT1 = Util.t1(this.f48323m - this.f48322l);
            if (this.f48325o == 1 && this.f48326p && (this.f48327q || this.f48330t == 1)) {
                this.f48313c.e(jT1, g());
            } else if (this.f48319i) {
                this.f48313c.e(jT1, g());
            }
        }
    }

    public void f(int i3) throws MuxerException {
        if (i3 == 0 && this.f48325o == 1) {
            return;
        }
        this.f48318h = false;
        Muxer muxer = this.f48324n;
        if (muxer != null) {
            try {
                muxer.close();
            } catch (MuxerException e3) {
                if (i3 != 1 || !((String) Assertions.e(e3.getMessage())).equals("Failed to stop the MediaMuxer")) {
                    throw e3;
                }
            }
        }
    }

    public ImmutableList i(int i3) {
        return this.f48312b.b(i3);
    }

    public boolean k() {
        if (!this.f48319i) {
            if (this.f48325o != 1 || !this.f48326p) {
                return false;
            }
            if (!this.f48327q && this.f48330t != 1) {
                return false;
            }
        }
        return true;
    }

    public void l(int i3) {
        Assertions.h(this.f48315e.size() == 0 || this.f48329s == i3, "The additional rotation cannot be changed after adding track formats.");
        this.f48329s = i3;
    }

    public void m(int i3) {
        if (this.f48325o == 2) {
            return;
        }
        Assertions.h(this.f48315e.size() == 0, "The track count cannot be changed after adding track formats.");
        this.f48330t = i3;
    }

    public boolean n(String str) {
        return i(MimeTypes.k(str)).contains(str);
    }

    public boolean o(int i3, ByteBuffer byteBuffer, boolean z2, long j3) {
        long j4;
        long j5;
        Assertions.a(Util.t(this.f48315e, i3));
        TrackInfo trackInfo = (TrackInfo) this.f48315e.get(i3);
        boolean zB = b(i3, j3);
        DebugTraceUtil.f("Muxer", "CanWriteSample", j3, "%s:%s", Util.s0(i3), Boolean.valueOf(zB));
        if (i3 == 2) {
            if (this.f48328r == -9223372036854775807L) {
                this.f48328r = j3;
            }
        } else if (i3 == 1 && this.f48314d && Util.t(this.f48315e, 2)) {
            long j6 = this.f48328r;
            if (j6 != -9223372036854775807L && j3 < j6) {
                this.f48313c.b();
                return true;
            }
        }
        if (!zB) {
            return false;
        }
        if (trackInfo.f48335e == 0) {
            if (i3 == 2 && Util.t(this.f48315e, 1) && !this.f48314d) {
                Assertions.g(this.f48328r != -9223372036854775807L);
                Log.i("MuxerWrapper", "Applying workarounds for edit list: shifting only the first video timestamp to zero.");
                j5 = 0;
            } else {
                j5 = j3;
            }
            trackInfo.f48333c = j5;
            j4 = j5;
        } else {
            j4 = j3;
        }
        trackInfo.f48335e++;
        trackInfo.f48334d += (long) byteBuffer.remaining();
        trackInfo.f48336f = Math.max(trackInfo.f48336f, j4);
        this.f48313c.b();
        Assertions.i(this.f48324n);
        long j7 = j4;
        this.f48317g.set(byteBuffer.position(), byteBuffer.remaining(), j7, TransformerUtil.e(z2 ? 1 : 0));
        this.f48324n.b(trackInfo.f48332b, byteBuffer, this.f48317g);
        DebugTraceUtil.f("Muxer", "AcceptedInput", j7, "%s", Util.s0(i3));
        this.f48320j = i3;
        return true;
    }
}
