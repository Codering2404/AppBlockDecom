package androidx.media3.extractor.avi;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.NoOpExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AviExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f46282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ChunkHeaderHolder f46283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f46284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SubtitleParser.Factory f46285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ExtractorOutput f46287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AviMainHeaderChunk f46288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f46289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ChunkReader[] f46290i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f46291j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ChunkReader f46292k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f46293l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f46294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f46295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f46296o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f46297p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class AviSeekMap implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46298a;

        public AviSeekMap(long j3) {
            this.f46298a = j3;
        }

        @Override // androidx.media3.extractor.SeekMap
        public SeekMap.SeekPoints b(long j3) {
            SeekMap.SeekPoints seekPointsI = AviExtractor.this.f46290i[0].i(j3);
            for (int i3 = 1; i3 < AviExtractor.this.f46290i.length; i3++) {
                SeekMap.SeekPoints seekPointsI2 = AviExtractor.this.f46290i[i3].i(j3);
                if (seekPointsI2.f46211a.f46217b < seekPointsI.f46211a.f46217b) {
                    seekPointsI = seekPointsI2;
                }
            }
            return seekPointsI;
        }

        @Override // androidx.media3.extractor.SeekMap
        public boolean e() {
            return true;
        }

        @Override // androidx.media3.extractor.SeekMap
        public long l() {
            return this.f46298a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ChunkHeaderHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f46300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f46301b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f46302c;

        private ChunkHeaderHolder() {
        }

        public void a(ParsableByteArray parsableByteArray) {
            this.f46300a = parsableByteArray.u();
            this.f46301b = parsableByteArray.u();
            this.f46302c = 0;
        }

        public void b(ParsableByteArray parsableByteArray) throws ParserException {
            a(parsableByteArray);
            if (this.f46300a == 1414744396) {
                this.f46302c = parsableByteArray.u();
                return;
            }
            throw ParserException.a("LIST expected, found: " + this.f46300a, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public AviExtractor(int i3, SubtitleParser.Factory factory) {
        this.f46285d = factory;
        this.f46284c = (i3 & 1) == 0;
        this.f46282a = new ParsableByteArray(12);
        this.f46283b = new ChunkHeaderHolder();
        this.f46287f = new NoOpExtractorOutput();
        this.f46290i = new ChunkReader[0];
        this.f46294m = -1L;
        this.f46295n = -1L;
        this.f46293l = -1;
        this.f46289h = -9223372036854775807L;
    }

    private static void d(ExtractorInput extractorInput) {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.k(1);
        }
    }

    private ChunkReader e(int i3) {
        for (ChunkReader chunkReader : this.f46290i) {
            if (chunkReader.j(i3)) {
                return chunkReader;
            }
        }
        return null;
    }

    private void f(ParsableByteArray parsableByteArray) throws ParserException {
        ListChunk listChunkC = ListChunk.c(1819436136, parsableByteArray);
        if (listChunkC.getType() != 1819436136) {
            throw ParserException.a("Unexpected header list type " + listChunkC.getType(), null);
        }
        AviMainHeaderChunk aviMainHeaderChunk = (AviMainHeaderChunk) listChunkC.b(AviMainHeaderChunk.class);
        if (aviMainHeaderChunk == null) {
            throw ParserException.a("AviHeader not found", null);
        }
        this.f46288g = aviMainHeaderChunk;
        this.f46289h = ((long) aviMainHeaderChunk.f46305c) * ((long) aviMainHeaderChunk.f46303a);
        ArrayList arrayList = new ArrayList();
        UnmodifiableIterator it = listChunkC.f46328a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            AviChunk aviChunk = (AviChunk) it.next();
            if (aviChunk.getType() == 1819440243) {
                int i4 = i3 + 1;
                ChunkReader chunkReaderM = m((ListChunk) aviChunk, i3);
                if (chunkReaderM != null) {
                    arrayList.add(chunkReaderM);
                }
                i3 = i4;
            }
        }
        this.f46290i = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
        this.f46287f.q();
    }

    private void k(ParsableByteArray parsableByteArray) {
        int i3;
        long jL = l(parsableByteArray);
        while (true) {
            if (parsableByteArray.a() < 16) {
                break;
            }
            int iU = parsableByteArray.u();
            int iU2 = parsableByteArray.u();
            long jU = ((long) parsableByteArray.u()) + jL;
            parsableByteArray.X(4);
            ChunkReader chunkReaderE = e(iU);
            if (chunkReaderE != null) {
                chunkReaderE.b(jU, (iU2 & 16) == 16);
            }
        }
        for (ChunkReader chunkReader : this.f46290i) {
            chunkReader.c();
        }
        this.f46297p = true;
        if (this.f46290i.length == 0) {
            this.f46287f.n(new SeekMap.Unseekable(this.f46289h));
        } else {
            this.f46287f.n(new AviSeekMap(this.f46289h));
        }
    }

    private long l(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 16) {
            return 0L;
        }
        int iF = parsableByteArray.f();
        parsableByteArray.X(8);
        long jU = parsableByteArray.u();
        long j3 = this.f46294m;
        long j4 = jU <= j3 ? j3 + 8 : 0L;
        parsableByteArray.W(iF);
        return j4;
    }

    private ChunkReader m(ListChunk listChunk, int i3) {
        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.b(AviStreamHeaderChunk.class);
        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.b(StreamFormatChunk.class);
        if (aviStreamHeaderChunk == null) {
            Log.i("AviExtractor", "Missing Stream Header");
            return null;
        }
        if (streamFormatChunk == null) {
            Log.i("AviExtractor", "Missing Stream Format");
            return null;
        }
        long jA = aviStreamHeaderChunk.a();
        Format format = streamFormatChunk.f46330a;
        Format.Builder builderB = format.b();
        builderB.e0(i3);
        int i4 = aviStreamHeaderChunk.f46312f;
        if (i4 != 0) {
            builderB.k0(i4);
        }
        StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.b(StreamNameChunk.class);
        if (streamNameChunk != null) {
            builderB.h0(streamNameChunk.f46331a);
        }
        int iK = MimeTypes.k(format.f40632o);
        if (iK != 1 && iK != 2) {
            return null;
        }
        TrackOutput trackOutputD = this.f46287f.d(i3, iK);
        trackOutputD.c(builderB.N());
        trackOutputD.e(jA);
        this.f46289h = Math.max(this.f46289h, jA);
        return new ChunkReader(i3, aviStreamHeaderChunk, trackOutputD);
    }

    private int n(ExtractorInput extractorInput) {
        if (extractorInput.getPosition() >= this.f46295n) {
            return -1;
        }
        ChunkReader chunkReader = this.f46292k;
        if (chunkReader == null) {
            d(extractorInput);
            extractorInput.m(this.f46282a.e(), 0, 12);
            this.f46282a.W(0);
            int iU = this.f46282a.u();
            if (iU == 1414744396) {
                this.f46282a.W(8);
                extractorInput.k(this.f46282a.u() != 1769369453 ? 8 : 12);
                extractorInput.f();
                return 0;
            }
            int iU2 = this.f46282a.u();
            if (iU == 1263424842) {
                this.f46291j = extractorInput.getPosition() + ((long) iU2) + 8;
                return 0;
            }
            extractorInput.k(8);
            extractorInput.f();
            ChunkReader chunkReaderE = e(iU);
            if (chunkReaderE == null) {
                this.f46291j = extractorInput.getPosition() + ((long) iU2);
                return 0;
            }
            chunkReaderE.n(iU2);
            this.f46292k = chunkReaderE;
        } else if (chunkReader.m(extractorInput)) {
            this.f46292k = null;
        }
        return 0;
    }

    private boolean o(ExtractorInput extractorInput, PositionHolder positionHolder) {
        boolean z2;
        if (this.f46291j != -1) {
            long position = extractorInput.getPosition();
            long j3 = this.f46291j;
            if (j3 < position || j3 > 262144 + position) {
                positionHolder.f46210a = j3;
                z2 = true;
            } else {
                extractorInput.k((int) (j3 - position));
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.f46291j = -1L;
        return z2;
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46291j = -1L;
        this.f46292k = null;
        for (ChunkReader chunkReader : this.f46290i) {
            chunkReader.o(j3);
        }
        if (j3 != 0) {
            this.f46286e = 6;
        } else if (this.f46290i.length == 0) {
            this.f46286e = 0;
        } else {
            this.f46286e = 3;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        extractorInput.m(this.f46282a.e(), 0, 12);
        this.f46282a.W(0);
        if (this.f46282a.u() != 1179011410) {
            return false;
        }
        this.f46282a.X(4);
        return this.f46282a.u() == 541677121;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        this.f46286e = 0;
        if (this.f46284c) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f46285d);
        }
        this.f46287f = extractorOutput;
        this.f46291j = -1L;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        if (o(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.f46286e) {
            case 0:
                if (!g(extractorInput)) {
                    throw ParserException.a("AVI Header List not found", null);
                }
                extractorInput.k(12);
                this.f46286e = 1;
                return 0;
            case 1:
                extractorInput.readFully(this.f46282a.e(), 0, 12);
                this.f46282a.W(0);
                this.f46283b.b(this.f46282a);
                ChunkHeaderHolder chunkHeaderHolder = this.f46283b;
                if (chunkHeaderHolder.f46302c == 1819436136) {
                    this.f46293l = chunkHeaderHolder.f46301b;
                    this.f46286e = 2;
                    return 0;
                }
                throw ParserException.a("hdrl expected, found: " + this.f46283b.f46302c, null);
            case 2:
                int i3 = this.f46293l - 4;
                ParsableByteArray parsableByteArray = new ParsableByteArray(i3);
                extractorInput.readFully(parsableByteArray.e(), 0, i3);
                f(parsableByteArray);
                this.f46286e = 3;
                return 0;
            case 3:
                if (this.f46294m != -1) {
                    long position = extractorInput.getPosition();
                    long j3 = this.f46294m;
                    if (position != j3) {
                        this.f46291j = j3;
                        return 0;
                    }
                }
                extractorInput.m(this.f46282a.e(), 0, 12);
                extractorInput.f();
                this.f46282a.W(0);
                this.f46283b.a(this.f46282a);
                int iU = this.f46282a.u();
                int i4 = this.f46283b.f46300a;
                if (i4 == 1179011410) {
                    extractorInput.k(12);
                    return 0;
                }
                if (i4 != 1414744396 || iU != 1769369453) {
                    this.f46291j = extractorInput.getPosition() + ((long) this.f46283b.f46301b) + 8;
                    return 0;
                }
                long position2 = extractorInput.getPosition();
                this.f46294m = position2;
                this.f46295n = position2 + ((long) this.f46283b.f46301b) + 8;
                if (!this.f46297p) {
                    if (((AviMainHeaderChunk) Assertions.e(this.f46288g)).a()) {
                        this.f46286e = 4;
                        this.f46291j = this.f46295n;
                        return 0;
                    }
                    this.f46287f.n(new SeekMap.Unseekable(this.f46289h));
                    this.f46297p = true;
                }
                this.f46291j = extractorInput.getPosition() + 12;
                this.f46286e = 6;
                return 0;
            case 4:
                extractorInput.readFully(this.f46282a.e(), 0, 8);
                this.f46282a.W(0);
                int iU2 = this.f46282a.u();
                int iU3 = this.f46282a.u();
                if (iU2 == 829973609) {
                    this.f46286e = 5;
                    this.f46296o = iU3;
                } else {
                    this.f46291j = extractorInput.getPosition() + ((long) iU3);
                }
                return 0;
            case 5:
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.f46296o);
                extractorInput.readFully(parsableByteArray2.e(), 0, this.f46296o);
                k(parsableByteArray2);
                this.f46286e = 6;
                this.f46291j = this.f46294m;
                return 0;
            case 6:
                return n(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }
}
