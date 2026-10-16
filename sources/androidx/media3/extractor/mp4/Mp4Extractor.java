package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory G = new ExtractorsFactory() { // from class: androidx.media3.extractor.mp4.e
        @Override // androidx.media3.extractor.ExtractorsFactory
        public final Extractor[] f() {
            return Mp4Extractor.n();
        }
    };
    private Mp4Track[] A;
    private long[][] B;
    private int C;
    private long D;
    private int E;
    private MotionPhotoMetadata F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubtitleParser.Factory f46774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f46775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f46776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f46777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableByteArray f46778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ParsableByteArray f46779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f46780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SefReader f46781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f46782i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImmutableList f46783j = ImmutableList.y();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46784k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f46785l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f46786m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f46787n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ParsableByteArray f46788o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f46789p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f46790q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f46791r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f46792s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f46793t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f46794u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f46795v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f46796w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f46797x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f46798y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ExtractorOutput f46799z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Mp4Track {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Track f46800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TrackSampleTable f46801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TrackOutput f46802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TrueHdSampleRechunker f46803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f46804e;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f46800a = track;
            this.f46801b = trackSampleTable;
            this.f46802c = trackOutput;
            this.f46803d = "audio/true-hd".equals(track.f46825g.f40632o) ? new TrueHdSampleRechunker() : null;
        }
    }

    public Mp4Extractor(SubtitleParser.Factory factory, int i3) {
        this.f46774a = factory;
        this.f46775b = i3;
        this.f46784k = (i3 & 4) != 0 ? 3 : 0;
        this.f46781h = new SefReader();
        this.f46782i = new ArrayList();
        this.f46779f = new ParsableByteArray(16);
        this.f46780g = new ArrayDeque();
        this.f46776c = new ParsableByteArray(NalUnitUtil.f41674a);
        this.f46777d = new ParsableByteArray(6);
        this.f46778e = new ParsableByteArray();
        this.f46789p = -1;
        this.f46799z = ExtractorOutput.m8;
        this.A = new Mp4Track[0];
    }

    private void A(Metadata metadata) {
        MdtaMetadataEntry mdtaMetadataEntryA = MetadataUtil.a(metadata, "auxiliary.tracks.interleaved");
        if (mdtaMetadataEntryA == null || mdtaMetadataEntryA.f41659b[0] != 0) {
            return;
        }
        this.f46798y = this.f46796w + 16;
    }

    private void B(ExtractorInput extractorInput) {
        this.f46778e.S(8);
        extractorInput.m(this.f46778e.e(), 0, 8);
        BoxParser.f(this.f46778e);
        extractorInput.k(this.f46778e.f());
        extractorInput.f();
    }

    private void C(long j3) {
        while (!this.f46780g.isEmpty() && ((Mp4Box.ContainerBox) this.f46780g.peek()).f41664b == j3) {
            Mp4Box.ContainerBox containerBox = (Mp4Box.ContainerBox) this.f46780g.pop();
            if (containerBox.f41663a == 1836019574) {
                F(containerBox);
                this.f46780g.clear();
                if (!this.f46795v) {
                    this.f46784k = 2;
                }
            } else if (!this.f46780g.isEmpty()) {
                ((Mp4Box.ContainerBox) this.f46780g.peek()).b(containerBox);
            }
        }
        if (this.f46784k != 2) {
            s();
        }
    }

    private void D() {
        if (this.E != 2 || (this.f46775b & 2) == 0) {
            return;
        }
        TrackOutput trackOutputD = this.f46799z.d(0, 4);
        MotionPhotoMetadata motionPhotoMetadata = this.F;
        trackOutputD.c(new Format.Builder().n0(motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata)).N());
        this.f46799z.q();
        this.f46799z.n(new SeekMap.Unseekable(-9223372036854775807L));
    }

    private static int E(ParsableByteArray parsableByteArray) {
        parsableByteArray.W(8);
        int iO = o(parsableByteArray.q());
        if (iO != 0) {
            return iO;
        }
        parsableByteArray.X(4);
        while (parsableByteArray.a() > 0) {
            int iO2 = o(parsableByteArray.q());
            if (iO2 != 0) {
                return iO2;
            }
        }
        return 0;
    }

    private void F(Mp4Box.ContainerBox containerBox) {
        List list;
        Metadata metadata;
        Metadata metadata2;
        List list2;
        Metadata metadata3;
        Metadata metadata4;
        GaplessInfoHolder gaplessInfoHolder;
        String str;
        ArrayList arrayList;
        Mp4Box.ContainerBox containerBoxD = containerBox.d(1835365473);
        List arrayList2 = new ArrayList();
        if (containerBoxD != null) {
            Metadata metadataT = BoxParser.t(containerBoxD);
            if (this.f46797x) {
                Assertions.i(metadataT);
                A(metadataT);
                arrayList2 = t(metadataT);
            } else if (N(metadataT)) {
                this.f46795v = true;
                return;
            }
            metadata = metadataT;
            list = arrayList2;
        } else {
            list = arrayList2;
            metadata = null;
        }
        ArrayList arrayList3 = new ArrayList();
        boolean z2 = this.E == 1;
        GaplessInfoHolder gaplessInfoHolder2 = new GaplessInfoHolder();
        Mp4Box.LeafBox leafBoxE = containerBox.e(1969517665);
        if (leafBoxE != null) {
            Metadata metadataH = BoxParser.H(leafBoxE);
            gaplessInfoHolder2.c(metadataH);
            metadata2 = metadataH;
        } else {
            metadata2 = null;
        }
        Metadata metadata5 = new Metadata(BoxParser.v(((Mp4Box.LeafBox) Assertions.e(containerBox.e(1836476516))).f41667b));
        List listG = BoxParser.G(containerBox, gaplessInfoHolder2, -9223372036854775807L, null, (this.f46775b & 1) != 0, z2, new Function() { // from class: androidx.media3.extractor.mp4.d
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Mp4Extractor.m((Track) obj);
            }
        });
        if (this.f46797x) {
            Assertions.h(list.size() == listG.size(), String.format(Locale.US, "The number of auxiliary track types from metadata (%d) is not same as the number of auxiliary tracks (%d)", Integer.valueOf(list.size()), Integer.valueOf(listG.size())));
        }
        String strB = MimeTypeResolver.b(listG);
        int i3 = 0;
        int i4 = 0;
        long jMax = -9223372036854775807L;
        int size = -1;
        while (i3 < listG.size()) {
            TrackSampleTable trackSampleTable = (TrackSampleTable) listG.get(i3);
            if (trackSampleTable.f46855b == 0) {
                list2 = listG;
                gaplessInfoHolder = gaplessInfoHolder2;
                str = strB;
                metadata3 = metadata;
                arrayList = arrayList3;
            } else {
                Track track = trackSampleTable.f46854a;
                list2 = listG;
                ArrayList arrayList4 = arrayList3;
                int i5 = i4 + 1;
                String str2 = strB;
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, this.f46799z.d(i4, track.f46820b));
                metadata3 = metadata;
                long j3 = track.f46823e;
                if (j3 == -9223372036854775807L) {
                    j3 = trackSampleTable.f46861h;
                }
                mp4Track.f46802c.e(j3);
                jMax = Math.max(jMax, j3);
                int i6 = "audio/true-hd".equals(track.f46825g.f40632o) ? trackSampleTable.f46858e * 16 : trackSampleTable.f46858e + 30;
                Format.Builder builderB = track.f46825g.b();
                builderB.k0(i6);
                if (track.f46820b == 2) {
                    int i7 = track.f46825g.f40623f;
                    if ((this.f46775b & 8) != 0) {
                        i7 |= size == -1 ? 1 : 2;
                    }
                    if (this.f46797x) {
                        i7 |= 32768;
                        builderB.P(((Integer) list.get(i3)).intValue());
                    }
                    builderB.s0(i7);
                }
                MetadataUtil.l(track.f46820b, gaplessInfoHolder2, builderB);
                int i8 = track.f46820b;
                Metadata metadata6 = track.f46825g.f40629l;
                if (this.f46782i.isEmpty()) {
                    gaplessInfoHolder = gaplessInfoHolder2;
                    metadata4 = null;
                } else {
                    gaplessInfoHolder = gaplessInfoHolder2;
                    metadata4 = new Metadata(this.f46782i);
                }
                MetadataUtil.m(i8, metadata3, builderB, metadata6, metadata4, metadata2, metadata5);
                str = str2;
                builderB.U(str);
                mp4Track.f46802c.c(builderB.N());
                if (track.f46820b == 2 && size == -1) {
                    size = arrayList4.size();
                }
                arrayList = arrayList4;
                arrayList.add(mp4Track);
                i4 = i5;
            }
            i3++;
            metadata = metadata3;
            arrayList3 = arrayList;
            listG = list2;
            strB = str;
            gaplessInfoHolder2 = gaplessInfoHolder;
        }
        this.C = size;
        this.D = jMax;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList3.toArray(new Mp4Track[0]);
        this.A = mp4TrackArr;
        this.B = p(mp4TrackArr);
        this.f46799z.q();
        this.f46799z.n(this);
    }

    private void G(long j3) {
        if (this.f46785l == 1836086884) {
            int i3 = this.f46787n;
            this.F = new MotionPhotoMetadata(0L, j3, -9223372036854775807L, j3 + ((long) i3), this.f46786m - ((long) i3));
        }
    }

    private boolean H(ExtractorInput extractorInput) throws ParserException {
        Mp4Box.ContainerBox containerBox;
        if (this.f46787n == 0) {
            if (!extractorInput.g(this.f46779f.e(), 0, 8, true)) {
                D();
                return false;
            }
            this.f46787n = 8;
            this.f46779f.W(0);
            this.f46786m = this.f46779f.J();
            this.f46785l = this.f46779f.q();
        }
        long j3 = this.f46786m;
        if (j3 == 1) {
            extractorInput.readFully(this.f46779f.e(), 8, 8);
            this.f46787n += 8;
            this.f46786m = this.f46779f.O();
        } else if (j3 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (containerBox = (Mp4Box.ContainerBox) this.f46780g.peek()) != null) {
                length = containerBox.f41664b;
            }
            if (length != -1) {
                this.f46786m = (length - extractorInput.getPosition()) + ((long) this.f46787n);
            }
        }
        if (this.f46786m < this.f46787n) {
            throw ParserException.c("Atom size less than header length (unsupported).");
        }
        if (L(this.f46785l)) {
            long position = extractorInput.getPosition();
            long j4 = this.f46786m;
            int i3 = this.f46787n;
            long j5 = (position + j4) - ((long) i3);
            if (j4 != i3 && this.f46785l == 1835365473) {
                B(extractorInput);
            }
            this.f46780g.push(new Mp4Box.ContainerBox(this.f46785l, j5));
            if (this.f46786m == this.f46787n) {
                C(j5);
            } else {
                s();
            }
        } else if (M(this.f46785l)) {
            Assertions.g(this.f46787n == 8);
            Assertions.g(this.f46786m <= 2147483647L);
            ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.f46786m);
            System.arraycopy(this.f46779f.e(), 0, parsableByteArray.e(), 0, 8);
            this.f46788o = parsableByteArray;
            this.f46784k = 1;
        } else {
            G(extractorInput.getPosition() - ((long) this.f46787n));
            this.f46788o = null;
            this.f46784k = 1;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean I(androidx.media3.extractor.ExtractorInput r10, androidx.media3.extractor.PositionHolder r11) {
        /*
            r9 = this;
            long r0 = r9.f46786m
            int r2 = r9.f46787n
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            androidx.media3.common.util.ParsableByteArray r4 = r9.f46788o
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L46
            byte[] r7 = r4.e()
            int r8 = r9.f46787n
            int r0 = (int) r0
            r10.readFully(r7, r8, r0)
            int r10 = r9.f46785l
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r0) goto L2b
            r9.f46794u = r5
            int r10 = E(r4)
            r9.E = r10
            goto L5e
        L2b:
            java.util.ArrayDeque r10 = r9.f46780g
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L5e
            java.util.ArrayDeque r10 = r9.f46780g
            java.lang.Object r10 = r10.peek()
            androidx.media3.container.Mp4Box$ContainerBox r10 = (androidx.media3.container.Mp4Box.ContainerBox) r10
            androidx.media3.container.Mp4Box$LeafBox r0 = new androidx.media3.container.Mp4Box$LeafBox
            int r1 = r9.f46785l
            r0.<init>(r1, r4)
            r10.c(r0)
            goto L5e
        L46:
            boolean r4 = r9.f46794u
            if (r4 != 0) goto L53
            int r4 = r9.f46785l
            r7 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r4 != r7) goto L53
            r9.E = r5
        L53:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L60
            int r0 = (int) r0
            r10.k(r0)
        L5e:
            r10 = r6
            goto L68
        L60:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.f46210a = r7
            r10 = r5
        L68:
            r9.C(r2)
            boolean r0 = r9.f46795v
            if (r0 == 0) goto L78
            r9.f46797x = r5
            long r0 = r9.f46796w
            r11.f46210a = r0
            r9.f46795v = r6
            r10 = r5
        L78:
            if (r10 == 0) goto L80
            int r10 = r9.f46784k
            r11 = 2
            if (r10 == r11) goto L80
            return r5
        L80:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.I(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [boolean, int] */
    private int J(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        TrackOutput.CryptoData cryptoData;
        ?? r12;
        int iO;
        long position = extractorInput.getPosition();
        if (this.f46789p == -1) {
            int iY = y(position);
            this.f46789p = iY;
            if (iY == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = this.A[this.f46789p];
        TrackOutput trackOutput = mp4Track.f46802c;
        int i3 = mp4Track.f46804e;
        TrackSampleTable trackSampleTable = mp4Track.f46801b;
        long j3 = trackSampleTable.f46856c[i3] + this.f46798y;
        int i4 = trackSampleTable.f46857d[i3];
        TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f46803d;
        long j4 = (j3 - position) + ((long) this.f46790q);
        if (j4 < 0 || j4 >= 262144) {
            positionHolder.f46210a = j3;
            return 1;
        }
        if (mp4Track.f46800a.f46826h == 1) {
            j4 += 8;
            i4 -= 8;
        }
        extractorInput.k((int) j4);
        if (!q(mp4Track.f46800a.f46825g)) {
            this.f46793t = true;
        }
        Track track = mp4Track.f46800a;
        if (track.f46829k == 0) {
            cryptoData = null;
            if ("audio/ac4".equals(track.f46825g.f40632o)) {
                if (this.f46791r == 0) {
                    Ac4Util.a(i4, this.f46778e);
                    trackOutput.b(this.f46778e, 7);
                    this.f46791r += 7;
                }
                i4 += 7;
            } else if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.d(extractorInput);
            }
            while (true) {
                int i5 = this.f46791r;
                if (i5 >= i4) {
                    break;
                }
                int iD = trackOutput.d(extractorInput, i4 - i5, false);
                this.f46790q += iD;
                this.f46791r += iD;
                this.f46792s -= iD;
            }
        } else {
            byte[] bArrE = this.f46777d.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i6 = 4 - mp4Track.f46800a.f46829k;
            i4 += i6;
            while (this.f46791r < i4) {
                int i7 = this.f46792s;
                if (i7 == 0) {
                    Track track2 = mp4Track.f46800a;
                    int i8 = track2.f46829k;
                    if (this.f46793t || NalUnitUtil.o(track2.f46825g) + i8 > mp4Track.f46801b.f46857d[i3] - this.f46790q) {
                        iO = 0;
                    } else {
                        iO = NalUnitUtil.o(mp4Track.f46800a.f46825g);
                        i8 = mp4Track.f46800a.f46829k + iO;
                    }
                    extractorInput.readFully(bArrE, i6, i8);
                    this.f46790q += i8;
                    this.f46777d.W(0);
                    int iQ = this.f46777d.q();
                    if (iQ < 0) {
                        throw ParserException.a("Invalid NAL length", null);
                    }
                    this.f46792s = iQ - iO;
                    this.f46776c.W(0);
                    trackOutput.b(this.f46776c, 4);
                    this.f46791r += 4;
                    if (iO > 0) {
                        trackOutput.b(this.f46777d, iO);
                        this.f46791r += iO;
                        if (NalUnitUtil.k(bArrE, 4, iO, mp4Track.f46800a.f46825g)) {
                            this.f46793t = true;
                        }
                    }
                } else {
                    int iD2 = trackOutput.d(extractorInput, i7, false);
                    this.f46790q += iD2;
                    this.f46791r += iD2;
                    this.f46792s -= iD2;
                }
            }
            cryptoData = null;
        }
        int i9 = i4;
        TrackSampleTable trackSampleTable2 = mp4Track.f46801b;
        long j5 = trackSampleTable2.f46859f[i3];
        int i10 = trackSampleTable2.f46860g[i3];
        if (!this.f46793t) {
            i10 |= 67108864;
        }
        if (trueHdSampleRechunker != null) {
            int i11 = i10;
            boolean z2 = false;
            trueHdSampleRechunker.c(trackOutput, j5, i11, i9, 0, null);
            r12 = z2;
            if (i3 + 1 == mp4Track.f46801b.f46855b) {
                trueHdSampleRechunker.a(trackOutput, cryptoData);
                r12 = z2;
            }
        } else {
            int i12 = i10;
            r12 = 0;
            trackOutput.g(j5, i12, i9, 0, null);
        }
        mp4Track.f46804e++;
        this.f46789p = -1;
        this.f46790q = r12;
        this.f46791r = r12;
        this.f46792s = r12;
        this.f46793t = r12;
        return r12;
    }

    private int K(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        int iC = this.f46781h.c(extractorInput, positionHolder, this.f46782i);
        if (iC == 1 && positionHolder.f46210a == 0) {
            s();
        }
        return iC;
    }

    private static boolean L(int i3) {
        return i3 == 1836019574 || i3 == 1953653099 || i3 == 1835297121 || i3 == 1835626086 || i3 == 1937007212 || i3 == 1701082227 || i3 == 1835365473 || i3 == 1635284069;
    }

    private static boolean M(int i3) {
        return i3 == 1835296868 || i3 == 1836476516 || i3 == 1751411826 || i3 == 1937011556 || i3 == 1937011827 || i3 == 1937011571 || i3 == 1668576371 || i3 == 1701606260 || i3 == 1937011555 || i3 == 1937011578 || i3 == 1937013298 || i3 == 1937007471 || i3 == 1668232756 || i3 == 1953196132 || i3 == 1718909296 || i3 == 1969517665 || i3 == 1801812339 || i3 == 1768715124;
    }

    private boolean N(Metadata metadata) {
        MdtaMetadataEntry mdtaMetadataEntryA;
        if (metadata != null && (this.f46775b & 64) != 0 && (mdtaMetadataEntryA = MetadataUtil.a(metadata, "auxiliary.tracks.offset")) != null) {
            long jO = new ParsableByteArray(mdtaMetadataEntryA.f41659b).O();
            if (jO > 0) {
                this.f46796w = jO;
                return true;
            }
        }
        return false;
    }

    private void O(Mp4Track mp4Track, long j3) {
        TrackSampleTable trackSampleTable = mp4Track.f46801b;
        int iA = trackSampleTable.a(j3);
        if (iA == -1) {
            iA = trackSampleTable.b(j3);
        }
        mp4Track.f46804e = iA;
    }

    public static /* synthetic */ Extractor[] n() {
        return new Extractor[]{new Mp4Extractor(SubtitleParser.Factory.f46959a, 16)};
    }

    private static int o(int i3) {
        if (i3 != 1751476579) {
            return i3 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] p(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i3 = 0; i3 < mp4TrackArr.length; i3++) {
            jArr[i3] = new long[mp4TrackArr[i3].f46801b.f46855b];
            jArr2[i3] = mp4TrackArr[i3].f46801b.f46859f[0];
        }
        long j3 = 0;
        int i4 = 0;
        while (i4 < mp4TrackArr.length) {
            long j4 = Long.MAX_VALUE;
            int i5 = -1;
            for (int i6 = 0; i6 < mp4TrackArr.length; i6++) {
                if (!zArr[i6]) {
                    long j5 = jArr2[i6];
                    if (j5 <= j4) {
                        i5 = i6;
                        j4 = j5;
                    }
                }
            }
            int i7 = iArr[i5];
            long[] jArr3 = jArr[i5];
            jArr3[i7] = j3;
            TrackSampleTable trackSampleTable = mp4TrackArr[i5].f46801b;
            j3 += (long) trackSampleTable.f46857d[i7];
            int i8 = i7 + 1;
            iArr[i5] = i8;
            if (i8 < jArr3.length) {
                jArr2[i5] = trackSampleTable.f46859f[i8];
            } else {
                zArr[i5] = true;
                i4++;
            }
        }
        return jArr;
    }

    private boolean q(Format format) {
        return Objects.equals(format.f40632o, "video/avc") ? (this.f46775b & 32) != 0 : Objects.equals(format.f40632o, "video/hevc") && (this.f46775b & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
    }

    public static int r(int i3) {
        int i4 = (i3 & 1) != 0 ? 32 : 0;
        return (i3 & 2) != 0 ? i4 | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : i4;
    }

    private void s() {
        this.f46784k = 0;
        this.f46787n = 0;
    }

    private List t(Metadata metadata) {
        List listD = ((MdtaMetadataEntry) Assertions.i(MetadataUtil.a(metadata, "auxiliary.tracks.map"))).d();
        ArrayList arrayList = new ArrayList(listD.size());
        for (int i3 = 0; i3 < listD.size(); i3++) {
            int iIntValue = ((Integer) listD.get(i3)).intValue();
            int i4 = 1;
            if (iIntValue != 0) {
                if (iIntValue != 1) {
                    i4 = 3;
                    if (iIntValue != 2) {
                        i4 = iIntValue != 3 ? 0 : 4;
                    }
                } else {
                    i4 = 2;
                }
            }
            arrayList.add(Integer.valueOf(i4));
        }
        return arrayList;
    }

    private static int x(TrackSampleTable trackSampleTable, long j3) {
        int iA = trackSampleTable.a(j3);
        return iA == -1 ? trackSampleTable.b(j3) : iA;
    }

    private int y(long j3) {
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        long j4 = Long.MAX_VALUE;
        boolean z2 = true;
        long j5 = Long.MAX_VALUE;
        boolean z3 = true;
        long j6 = Long.MAX_VALUE;
        while (true) {
            Mp4Track[] mp4TrackArr = this.A;
            if (i5 >= mp4TrackArr.length) {
                break;
            }
            Mp4Track mp4Track = mp4TrackArr[i5];
            int i6 = mp4Track.f46804e;
            TrackSampleTable trackSampleTable = mp4Track.f46801b;
            if (i6 != trackSampleTable.f46855b) {
                long j7 = trackSampleTable.f46856c[i6];
                long j8 = ((long[][]) Util.k(this.B))[i5][i6];
                long j9 = j7 - j3;
                boolean z4 = j9 < 0 || j9 >= 262144;
                if ((!z4 && z3) || (z4 == z3 && j9 < j6)) {
                    j5 = j8;
                    z3 = z4;
                    i4 = i5;
                    j6 = j9;
                }
                if (j8 < j4) {
                    j4 = j8;
                    z2 = z4;
                    i3 = i5;
                }
            }
            i5++;
        }
        return (j4 == Long.MAX_VALUE || !z2 || j5 < j4 + 10485760) ? i4 : i3;
    }

    private static long z(TrackSampleTable trackSampleTable, long j3, long j4) {
        int iX = x(trackSampleTable, j3);
        return iX == -1 ? j4 : Math.min(trackSampleTable.f46856c[iX], j4);
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        this.f46780g.clear();
        this.f46787n = 0;
        this.f46789p = -1;
        this.f46790q = 0;
        this.f46791r = 0;
        this.f46792s = 0;
        this.f46793t = false;
        if (j3 == 0) {
            if (this.f46784k != 3) {
                s();
                return;
            } else {
                this.f46781h.g();
                this.f46782i.clear();
                return;
            }
        }
        for (Mp4Track mp4Track : this.A) {
            O(mp4Track, j4);
            TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f46803d;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.b();
            }
        }
    }

    @Override // androidx.media3.extractor.SeekMap
    public SeekMap.SeekPoints b(long j3) {
        return v(j3, -1);
    }

    @Override // androidx.media3.extractor.SeekMap
    public boolean e() {
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        SniffFailure sniffFailureD = Sniffer.d(extractorInput, (this.f46775b & 2) != 0);
        this.f46783j = sniffFailureD != null ? ImmutableList.z(sniffFailureD) : ImmutableList.y();
        return sniffFailureD == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        if ((this.f46775b & 16) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f46774a);
        }
        this.f46799z = extractorOutput;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) {
        while (true) {
            int i3 = this.f46784k;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        return J(extractorInput, positionHolder);
                    }
                    if (i3 == 3) {
                        return K(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                }
                if (I(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!H(extractorInput)) {
                return -1;
            }
        }
    }

    @Override // androidx.media3.extractor.SeekMap
    public long l() {
        return this.D;
    }

    public long[] u(int i3) {
        Mp4Track[] mp4TrackArr = this.A;
        return mp4TrackArr.length <= i3 ? new long[0] : mp4TrackArr[i3].f46801b.f46859f;
    }

    public SeekMap.SeekPoints v(long j3, int i3) {
        long j4;
        long jZ;
        long j5;
        long j6;
        int iB;
        long j7 = j3;
        Mp4Track[] mp4TrackArr = this.A;
        if (mp4TrackArr.length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.f46215c);
        }
        int i4 = i3 != -1 ? i3 : this.C;
        if (i4 != -1) {
            TrackSampleTable trackSampleTable = mp4TrackArr[i4].f46801b;
            int iX = x(trackSampleTable, j7);
            if (iX == -1) {
                return new SeekMap.SeekPoints(SeekPoint.f46215c);
            }
            long j8 = trackSampleTable.f46859f[iX];
            j4 = trackSampleTable.f46856c[iX];
            if (j8 >= j7 || iX >= trackSampleTable.f46855b - 1 || (iB = trackSampleTable.b(j7)) == -1 || iB == iX) {
                j6 = -1;
                j5 = -9223372036854775807L;
            } else {
                j5 = trackSampleTable.f46859f[iB];
                j6 = trackSampleTable.f46856c[iB];
            }
            jZ = j6;
            j7 = j8;
        } else {
            j4 = Long.MAX_VALUE;
            jZ = -1;
            j5 = -9223372036854775807L;
        }
        if (i3 == -1) {
            int i5 = 0;
            while (true) {
                Mp4Track[] mp4TrackArr2 = this.A;
                if (i5 >= mp4TrackArr2.length) {
                    break;
                }
                if (i5 != this.C) {
                    TrackSampleTable trackSampleTable2 = mp4TrackArr2[i5].f46801b;
                    long jZ2 = z(trackSampleTable2, j7, j4);
                    if (j5 != -9223372036854775807L) {
                        jZ = z(trackSampleTable2, j5, jZ);
                    }
                    j4 = jZ2;
                }
                i5++;
            }
        }
        SeekPoint seekPoint = new SeekPoint(j7, j4);
        return j5 == -9223372036854775807L ? new SeekMap.SeekPoints(seekPoint) : new SeekMap.SeekPoints(seekPoint, new SeekPoint(j5, jZ));
    }

    @Override // androidx.media3.extractor.Extractor
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImmutableList i() {
        return this.f46783j;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
    }

    public static /* synthetic */ Track m(Track track) {
        return track;
    }
}
