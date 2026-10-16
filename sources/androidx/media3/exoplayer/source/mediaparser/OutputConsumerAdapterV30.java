package androidx.media3.exoplayer.source.mediaparser;

import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.MediaParser$InputReader;
import android.media.MediaParser$OutputConsumer;
import android.util.Pair;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.NoOpExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class OutputConsumerAdapterV30 implements MediaParser$OutputConsumer {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Pair f45178u = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Pattern f45179v = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f45180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f45181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f45182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList f45183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataReaderAdapter f45184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f45185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f45186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Format f45187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ExtractorOutput f45188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaParser.SeekMap f45189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MediaParser.SeekMap f45190k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f45191l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ChunkIndex f45192m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TimestampAdjuster f45193n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List f45194o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f45195p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f45196q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f45197r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f45198s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f45199t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DataReaderAdapter implements DataReader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaParser$InputReader f45200a;

        private DataReaderAdapter() {
        }

        @Override // androidx.media3.common.DataReader
        public int read(byte[] bArr, int i3, int i4) {
            return m.a(Util.k(this.f45200a)).read(bArr, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SeekMapAdapter implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaParser.SeekMap f45201a;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.f45201a = seekMap;
        }

        private static SeekPoint a(MediaParser.SeekPoint seekPoint) {
            return new SeekPoint(seekPoint.timeMicros, seekPoint.position);
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekMap.SeekPoints b(long j3) {
            Pair seekPoints = this.f45201a.getSeekPoints(j3);
            Object obj = seekPoints.first;
            return obj == seekPoints.second ? new SeekMap.SeekPoints(a(androidx.media3.exoplayer.source.m.a(obj))) : new SeekMap.SeekPoints(a(androidx.media3.exoplayer.source.m.a(obj)), a(androidx.media3.exoplayer.source.m.a(seekPoints.second)));
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean e() {
            return this.f45201a.isSeekable();
        }

        @Override // androidx.media3.extractor.SeekMap
        public long l() {
            long durationMicros = this.f45201a.getDurationMicros();
            if (durationMicros != -2147483648L) {
                return durationMicros;
            }
            return -9223372036854775807L;
        }
    }

    public OutputConsumerAdapterV30() {
        this(null, -2, false);
    }

    private void b(int i3) {
        for (int size = this.f45180a.size(); size <= i3; size++) {
            this.f45180a.add(null);
            this.f45181b.add(null);
            this.f45182c.add(null);
            this.f45183d.add(null);
        }
    }

    private static int e(MediaFormat mediaFormat, String str, int i3) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i3;
        }
        return 0;
    }

    private static List f(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append("csd-");
            int i4 = i3 + 1;
            sb.append(i3);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb.toString());
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(MediaFormatUtil.c(byteBuffer));
            i3 = i4;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static String g(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    b3 = 0;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    b3 = 1;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    b3 = 2;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    b3 = 3;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    b3 = 4;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    b3 = 5;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    b3 = 6;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    b3 = 7;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    b3 = 8;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    b3 = 9;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    b3 = 10;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    b3 = Ascii.VT;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    b3 = Ascii.FF;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    b3 = Ascii.CR;
                }
                break;
        }
        switch (b3) {
            case 0:
            case 6:
                return "video/mp4";
            case 1:
                return "audio/ogg";
            case 2:
                return "video/mp2t";
            case 3:
                return "audio/mp4a-latm";
            case 4:
                return "audio/raw";
            case 5:
                return "video/mp2p";
            case 7:
                return "audio/ac3";
            case 8:
                return "audio/amr";
            case 9:
                return "audio/flac";
            case 10:
                return "video/webm";
            case 11:
                return "audio/ac4";
            case 12:
                return "audio/mpeg";
            case 13:
                return "video/x-flv";
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    private static int j(MediaFormat mediaFormat) {
        return e(mediaFormat, "is-forced-subtitle", 2) | e(mediaFormat, "is-autoselect", 4) | e(mediaFormat, "is-default", 1);
    }

    private void k() {
        if (!this.f45197r || this.f45198s) {
            return;
        }
        int size = this.f45180a.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f45180a.get(i3) == null) {
                return;
            }
        }
        this.f45188i.q();
        this.f45198s = true;
    }

    private boolean l(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("chunk-index-int-sizes");
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer intBufferAsIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer longBufferAsLongBuffer = ((ByteBuffer) Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-offsets"))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer2 = ((ByteBuffer) Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-us-durations"))).asLongBuffer();
        LongBuffer longBufferAsLongBuffer3 = ((ByteBuffer) Assertions.e(mediaFormat.getByteBuffer("chunk-index-long-us-times"))).asLongBuffer();
        int[] iArr = new int[intBufferAsIntBuffer.remaining()];
        long[] jArr = new long[longBufferAsLongBuffer.remaining()];
        long[] jArr2 = new long[longBufferAsLongBuffer2.remaining()];
        long[] jArr3 = new long[longBufferAsLongBuffer3.remaining()];
        intBufferAsIntBuffer.get(iArr);
        longBufferAsLongBuffer.get(jArr);
        longBufferAsLongBuffer2.get(jArr2);
        longBufferAsLongBuffer3.get(jArr3);
        ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
        this.f45192m = chunkIndex;
        this.f45188i.n(chunkIndex);
        return true;
    }

    private TrackOutput.CryptoData p(int i3, MediaCodec.CryptoInfo cryptoInfo) {
        int i4;
        int i5;
        if (cryptoInfo == null) {
            return null;
        }
        if (((MediaCodec.CryptoInfo) this.f45182c.get(i3)) == cryptoInfo) {
            return (TrackOutput.CryptoData) Assertions.e((TrackOutput.CryptoData) this.f45183d.get(i3));
        }
        try {
            Matcher matcher = f45179v.matcher(cryptoInfo.toString());
            matcher.find();
            i4 = Integer.parseInt((String) Util.k(matcher.group(1)));
            i5 = Integer.parseInt((String) Util.k(matcher.group(2)));
        } catch (RuntimeException e3) {
            Log.e("OConsumerAdapterV30", "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e3);
            i4 = 0;
            i5 = 0;
        }
        TrackOutput.CryptoData cryptoData = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i4, i5);
        this.f45182c.set(i3, cryptoInfo);
        this.f45183d.set(i3, cryptoData);
        return cryptoData;
    }

    private static DrmInitData q(String str, android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i3 = 0; i3 < schemeInitDataCount; i3++) {
            DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i3);
            schemeDataArr[i3] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new androidx.media3.common.DrmInitData(str, schemeDataArr);
    }

    private Format r(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString("mime");
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        int i3 = 0;
        Format.Builder builderO = new Format.Builder().Y(q(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).U(this.f45191l).p0(mediaFormat.getInteger("bitrate", -1)).R(mediaFormat.getInteger("channel-count", -1)).T(MediaFormatUtil.e(mediaFormat)).u0(string).S(mediaFormat.getString("codecs-string")).b0(mediaFormat.getFloat("frame-rate", -1.0f)).B0(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1)).d0(mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1)).g0(f(mediaFormat)).j0(mediaFormat.getString("language")).k0(mediaFormat.getInteger("max-input-size", -1)).o0(mediaFormat.getInteger("exo-pcm-encoding", -1)).t0(mediaFormat.getInteger("rotation-degrees", 0)).v0(mediaFormat.getInteger("sample-rate", -1)).w0(j(mediaFormat)).Z(mediaFormat.getInteger("encoder-delay", 0)).a0(mediaFormat.getInteger("encoder-padding", 0)).q0(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).y0(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).O(integer);
        while (true) {
            if (i3 >= this.f45194o.size()) {
                break;
            }
            Format format = (Format) this.f45194o.get(i3);
            if (Objects.equals(format.f40632o, string) && format.J == integer) {
                builderO.j0(format.f40621d).s0(format.f40623f).w0(format.f40622e).h0(format.f40619b).i0(format.f40620c).n0(format.f40629l);
                break;
            }
            i3++;
        }
        return builderO.N();
    }

    private static int s(String str) {
        if (str == null) {
            return -1;
        }
        switch (str) {
            case "metadata":
                return 5;
            case "unknown":
                return -1;
            case "text":
                return 3;
            case "audio":
                return 1;
            case "video":
                return 2;
            default:
                return MimeTypes.k(str);
        }
    }

    public void a() {
        this.f45199t = true;
    }

    public ChunkIndex c() {
        return this.f45192m;
    }

    public MediaParser.SeekMap d() {
        return this.f45189j;
    }

    public Format[] h() {
        if (!this.f45197r) {
            return null;
        }
        Format[] formatArr = new Format[this.f45181b.size()];
        for (int i3 = 0; i3 < this.f45181b.size(); i3++) {
            formatArr[i3] = (Format) Assertions.e((Format) this.f45181b.get(i3));
        }
        return formatArr;
    }

    public Pair i(long j3) {
        MediaParser.SeekMap seekMap = this.f45190k;
        return seekMap != null ? seekMap.getSeekPoints(j3) : f45178u;
    }

    public void m(ExtractorOutput extractorOutput) {
        this.f45188i = extractorOutput;
    }

    public void n(long j3) {
        this.f45196q = j3;
    }

    public void o(String str) {
        this.f45191l = g(str);
    }

    public void onSampleCompleted(int i3, long j3, int i4, int i5, int i6, MediaCodec.CryptoInfo cryptoInfo) {
        long j4 = this.f45196q;
        if (j4 == -9223372036854775807L || j3 < j4) {
            TimestampAdjuster timestampAdjuster = this.f45193n;
            if (timestampAdjuster != null) {
                j3 = timestampAdjuster.a(j3);
            }
            ((TrackOutput) Assertions.e((TrackOutput) this.f45180a.get(i3))).g(j3, i4, i5, i6, p(i3, cryptoInfo));
        }
    }

    public void onSampleDataFound(int i3, MediaParser$InputReader mediaParser$InputReader) {
        b(i3);
        this.f45184e.f45200a = mediaParser$InputReader;
        TrackOutput trackOutputD = (TrackOutput) this.f45180a.get(i3);
        if (trackOutputD == null) {
            trackOutputD = this.f45188i.d(i3, -1);
            this.f45180a.set(i3, trackOutputD);
        }
        trackOutputD.d(this.f45184e, (int) mediaParser$InputReader.getLength(), true);
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMapAdapter;
        if (this.f45185f && this.f45189j == null) {
            this.f45189j = seekMap;
            return;
        }
        this.f45190k = seekMap;
        long durationMicros = seekMap.getDurationMicros();
        ExtractorOutput extractorOutput = this.f45188i;
        if (this.f45199t) {
            if (durationMicros == -2147483648L) {
                durationMicros = -9223372036854775807L;
            }
            seekMapAdapter = new SeekMap.Unseekable(durationMicros);
        } else {
            seekMapAdapter = new SeekMapAdapter(seekMap);
        }
        extractorOutput.n(seekMapAdapter);
    }

    public void onTrackCountFound(int i3) {
        this.f45197r = true;
        k();
    }

    public void onTrackDataFound(int i3, MediaParser.TrackData trackData) {
        if (l(trackData.mediaFormat)) {
            return;
        }
        b(i3);
        TrackOutput trackOutput = (TrackOutput) this.f45180a.get(i3);
        if (trackOutput == null) {
            String string = trackData.mediaFormat.getString("track-type-string");
            int iS = s(string != null ? string : trackData.mediaFormat.getString("mime"));
            if (iS == this.f45186g) {
                this.f45195p = i3;
            }
            TrackOutput trackOutputD = this.f45188i.d(i3, iS);
            this.f45180a.set(i3, trackOutputD);
            if (string != null) {
                return;
            } else {
                trackOutput = trackOutputD;
            }
        }
        Format formatR = r(trackData);
        Format format = this.f45187h;
        trackOutput.c((format == null || i3 != this.f45195p) ? formatR : formatR.i(format));
        this.f45181b.set(i3, formatR);
        k();
    }

    public OutputConsumerAdapterV30(Format format, int i3, boolean z2) {
        this.f45185f = z2;
        this.f45187h = format;
        this.f45186g = i3;
        this.f45180a = new ArrayList();
        this.f45181b = new ArrayList();
        this.f45182c = new ArrayList();
        this.f45183d = new ArrayList();
        this.f45184e = new DataReaderAdapter();
        this.f45188i = new NoOpExtractorOutput();
        this.f45196q = -9223372036854775807L;
        this.f45194o = ImmutableList.y();
    }
}
