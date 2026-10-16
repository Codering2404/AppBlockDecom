package androidx.media3.transformer;

import android.content.Context;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class Mp4Info {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f48297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f48298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f48299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f48300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f48301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Format f48302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Format f48303g;

    private Mp4Info(long j3, long j4, long j5, long j6, boolean z2, Format format, Format format2) {
        this.f48297a = j3;
        this.f48298b = j4;
        this.f48299c = j5;
        this.f48300d = j6;
        this.f48301e = z2;
        this.f48302f = format;
        this.f48303g = format2;
    }

    public static Mp4Info a(Context context, String str) {
        return b(context, str, -9223372036854775807L);
    }

    public static Mp4Info b(Context context, String str, long j3) {
        long j4;
        long j5;
        long j6;
        long j7;
        Format format;
        Mp4Extractor mp4Extractor = new Mp4Extractor(SubtitleParser.Factory.f46959a, 16);
        ExtractorOutputImpl extractorOutputImpl = new ExtractorOutputImpl();
        boolean z2 = false;
        DefaultDataSource defaultDataSource = new DefaultDataSource(context, false);
        try {
            long jB = defaultDataSource.b(new DataSpec.Builder().j(str).a());
            Assertions.g(jB != 0);
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(defaultDataSource, 0L, jB);
            Assertions.h(mp4Extractor.g(defaultExtractorInput), "The MP4 file is invalid");
            mp4Extractor.h(extractorOutputImpl);
            PositionHolder positionHolder = new PositionHolder();
            while (!extractorOutputImpl.f48306c) {
                int iJ = mp4Extractor.j(defaultExtractorInput, positionHolder);
                if (iJ == 1) {
                    defaultDataSource.close();
                    long jB2 = defaultDataSource.b(new DataSpec.Builder().j(str).h(positionHolder.f46210a).a());
                    if (jB2 != -1) {
                        jB2 += positionHolder.f46210a;
                    }
                    defaultExtractorInput = new DefaultExtractorInput(defaultDataSource, positionHolder.f46210a, jB2);
                } else if (iJ == -1 && !extractorOutputImpl.f48306c) {
                    throw new IllegalStateException("The MP4 file is invalid");
                }
            }
            long jL = mp4Extractor.l();
            if (extractorOutputImpl.f48304a != -1) {
                format = (Format) Assertions.e(((ExtractorOutputImpl.TrackOutputImpl) Assertions.e((ExtractorOutputImpl.TrackOutputImpl) extractorOutputImpl.f48307d.get(2))).f48308a);
                Assertions.g(jL != -9223372036854775807L);
                j6 = mp4Extractor.v(jL, extractorOutputImpl.f48304a).f46211a.f46216a;
                if (j3 != -9223372036854775807L) {
                    SeekMap.SeekPoints seekPointsV = mp4Extractor.v(j3, extractorOutputImpl.f48304a);
                    j4 = jL;
                    j5 = seekPointsV.f46211a.f46216a;
                    if (j3 != j5) {
                        j5 = seekPointsV.f46212b.f46216a;
                        if (j3 > j5) {
                            j5 = Long.MIN_VALUE;
                        }
                    }
                    long[] jArrU = mp4Extractor.u(extractorOutputImpl.f48304a);
                    j7 = jArrU.length > 0 ? jArrU[0] : -9223372036854775807L;
                    int iF = Util.f(jArrU, j3, true, false);
                    if (iF < jArrU.length && jArrU[iF] == j5) {
                        z2 = true;
                    }
                } else {
                    j4 = jL;
                    j5 = -9223372036854775807L;
                    j7 = -9223372036854775807L;
                }
            } else {
                j4 = jL;
                j5 = -9223372036854775807L;
                j6 = -9223372036854775807L;
                j7 = -9223372036854775807L;
                format = null;
            }
            Mp4Info mp4Info = new Mp4Info(j4, j6, j7, j5, z2, format, extractorOutputImpl.f48305b != -1 ? (Format) Assertions.e(((ExtractorOutputImpl.TrackOutputImpl) Assertions.e((ExtractorOutputImpl.TrackOutputImpl) extractorOutputImpl.f48307d.get(1))).f48308a) : null);
            DataSourceUtil.a(defaultDataSource);
            mp4Extractor.release();
            return mp4Info;
        } catch (Throwable th) {
            DataSourceUtil.a(defaultDataSource);
            mp4Extractor.release();
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ExtractorOutputImpl implements ExtractorOutput {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f48306c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f48304a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f48305b = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Map f48307d = new HashMap();

        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput d(int i3, int i4) {
            if (i4 == 2) {
                this.f48304a = i3;
            } else if (i4 == 1) {
                this.f48305b = i3;
            }
            TrackOutputImpl trackOutputImpl = (TrackOutputImpl) this.f48307d.get(Integer.valueOf(i4));
            if (trackOutputImpl != null) {
                return trackOutputImpl;
            }
            TrackOutputImpl trackOutputImpl2 = new TrackOutputImpl();
            this.f48307d.put(Integer.valueOf(i4), trackOutputImpl2);
            return trackOutputImpl2;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void n(SeekMap seekMap) {
            this.f48306c = true;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void q() {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class TrackOutputImpl implements TrackOutput {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Format f48308a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final byte[] f48309b = new byte[16000];

            @Override // androidx.media3.extractor.TrackOutput
            public void a(ParsableByteArray parsableByteArray, int i3, int i4) {
                while (i3 > 0) {
                    int iMin = Math.min(i3, this.f48309b.length);
                    parsableByteArray.l(this.f48309b, 0, iMin);
                    i3 -= iMin;
                }
            }

            @Override // androidx.media3.extractor.TrackOutput
            public void c(Format format) {
                this.f48308a = format;
            }

            @Override // androidx.media3.extractor.TrackOutput
            public int f(DataReader dataReader, int i3, boolean z2, int i4) {
                int i5 = i3;
                while (i5 > 0) {
                    boolean z3 = false;
                    int i6 = dataReader.read(this.f48309b, 0, Math.min(i5, this.f48309b.length));
                    if (i6 != -1) {
                        z3 = true;
                    }
                    Assertions.g(z3);
                    i5 -= i6;
                }
                return i3;
            }

            @Override // androidx.media3.extractor.TrackOutput
            public void g(long j3, int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
            }
        }
    }
}
