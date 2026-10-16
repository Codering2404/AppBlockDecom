package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.IndexSeekMap;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SubtitleExtractor implements Extractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SubtitleParser f46943a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Format f46945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f46946d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TrackOutput f46949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long[] f46952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f46953k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CueEncoder f46944b = new CueEncoder();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f46948f = Util.f41614f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ParsableByteArray f46947e = new ParsableByteArray();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Sample implements Comparable<Sample> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f46954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f46955b;

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Sample sample) {
            return Long.compare(this.f46954a, sample.f46954a);
        }

        private Sample(long j3, byte[] bArr) {
            this.f46954a = j3;
            this.f46955b = bArr;
        }
    }

    public SubtitleExtractor(SubtitleParser subtitleParser, Format format) {
        this.f46943a = subtitleParser;
        this.f46945c = format != null ? format.b().u0("application/x-media3-cues").S(format.f40632o).W(subtitleParser.c()).N() : null;
        this.f46946d = new ArrayList();
        this.f46951i = 0;
        this.f46952j = Util.f41615g;
        this.f46953k = -9223372036854775807L;
    }

    public static /* synthetic */ void b(SubtitleExtractor subtitleExtractor, CuesWithTiming cuesWithTiming) {
        subtitleExtractor.getClass();
        Sample sample = new Sample(cuesWithTiming.f46935b, subtitleExtractor.f46944b.a(cuesWithTiming.f46934a, cuesWithTiming.f46936c));
        subtitleExtractor.f46946d.add(sample);
        long j3 = subtitleExtractor.f46953k;
        if (j3 == -9223372036854775807L || cuesWithTiming.f46935b >= j3) {
            subtitleExtractor.l(sample);
        }
    }

    private void d() throws ParserException {
        try {
            long j3 = this.f46953k;
            this.f46943a.a(this.f46948f, 0, this.f46950h, j3 != -9223372036854775807L ? SubtitleParser.OutputOptions.c(j3) : SubtitleParser.OutputOptions.b(), new Consumer() { // from class: androidx.media3.extractor.text.d
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    SubtitleExtractor.b(this.f47065a, (CuesWithTiming) obj);
                }
            });
            Collections.sort(this.f46946d);
            this.f46952j = new long[this.f46946d.size()];
            for (int i3 = 0; i3 < this.f46946d.size(); i3++) {
                this.f46952j[i3] = ((Sample) this.f46946d.get(i3)).f46954a;
            }
            this.f46948f = Util.f41614f;
        } catch (RuntimeException e3) {
            throw ParserException.a("SubtitleParser failed.", e3);
        }
    }

    private boolean e(ExtractorInput extractorInput) {
        byte[] bArr = this.f46948f;
        if (bArr.length == this.f46950h) {
            this.f46948f = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f46948f;
        int i3 = this.f46950h;
        int i4 = extractorInput.read(bArr2, i3, bArr2.length - i3);
        if (i4 != -1) {
            this.f46950h += i4;
        }
        long length = extractorInput.getLength();
        return (length != -1 && ((long) this.f46950h) == length) || i4 == -1;
    }

    private boolean f(ExtractorInput extractorInput) {
        return extractorInput.a((extractorInput.getLength() > (-1L) ? 1 : (extractorInput.getLength() == (-1L) ? 0 : -1)) != 0 ? Ints.d(extractorInput.getLength()) : 1024) == -1;
    }

    private void k() {
        long j3 = this.f46953k;
        for (int iJ = j3 == -9223372036854775807L ? 0 : Util.j(this.f46952j, j3, true, true); iJ < this.f46946d.size(); iJ++) {
            l((Sample) this.f46946d.get(iJ));
        }
    }

    private void l(Sample sample) {
        Assertions.i(this.f46949g);
        int length = sample.f46955b.length;
        this.f46947e.T(sample.f46955b);
        this.f46949g.b(this.f46947e, length);
        this.f46949g.g(sample.f46954a, 1, length, 0, null);
    }

    @Override // androidx.media3.extractor.Extractor
    public void a(long j3, long j4) {
        int i3 = this.f46951i;
        Assertions.g((i3 == 0 || i3 == 5) ? false : true);
        this.f46953k = j4;
        if (this.f46951i == 2) {
            this.f46951i = 1;
        }
        if (this.f46951i == 4) {
            this.f46951i = 3;
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public boolean g(ExtractorInput extractorInput) {
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public void h(ExtractorOutput extractorOutput) {
        Assertions.g(this.f46951i == 0);
        TrackOutput trackOutputD = extractorOutput.d(0, 3);
        this.f46949g = trackOutputD;
        Format format = this.f46945c;
        if (format != null) {
            trackOutputD.c(format);
            extractorOutput.q();
            extractorOutput.n(new IndexSeekMap(new long[]{0}, new long[]{0}, -9223372036854775807L));
        }
        this.f46951i = 1;
    }

    @Override // androidx.media3.extractor.Extractor
    public int j(ExtractorInput extractorInput, PositionHolder positionHolder) throws ParserException {
        int i3 = this.f46951i;
        Assertions.g((i3 == 0 || i3 == 5) ? false : true);
        if (this.f46951i == 1) {
            int iD = extractorInput.getLength() != -1 ? Ints.d(extractorInput.getLength()) : 1024;
            if (iD > this.f46948f.length) {
                this.f46948f = new byte[iD];
            }
            this.f46950h = 0;
            this.f46951i = 2;
        }
        if (this.f46951i == 2 && e(extractorInput)) {
            d();
            this.f46951i = 4;
        }
        if (this.f46951i == 3 && f(extractorInput)) {
            k();
            this.f46951i = 4;
        }
        return this.f46951i == 4 ? -1 : 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public void release() {
        if (this.f46951i == 5) {
            return;
        }
        this.f46943a.reset();
        this.f46951i = 5;
    }
}
