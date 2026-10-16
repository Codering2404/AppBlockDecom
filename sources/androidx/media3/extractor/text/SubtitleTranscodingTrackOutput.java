package androidx.media3.extractor.text;

import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class SubtitleTranscodingTrackOutput implements TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TrackOutput f46970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SubtitleParser.Factory f46971b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SubtitleParser f46977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Format f46978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f46979j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CueEncoder f46972c = new CueEncoder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46974e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46975f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f46976g = Util.f41614f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ParsableByteArray f46973d = new ParsableByteArray();

    public SubtitleTranscodingTrackOutput(TrackOutput trackOutput, SubtitleParser.Factory factory) {
        this.f46970a = trackOutput;
        this.f46971b = factory;
    }

    private void i(int i3) {
        int length = this.f46976g.length;
        int i4 = this.f46975f;
        if (length - i4 >= i3) {
            return;
        }
        int i5 = i4 - this.f46974e;
        int iMax = Math.max(i5 * 2, i3 + i5);
        byte[] bArr = this.f46976g;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f46974e, bArr2, 0, i5);
        this.f46974e = 0;
        this.f46975f = i5;
        this.f46976g = bArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(CuesWithTiming cuesWithTiming, long j3, int i3) {
        Assertions.i(this.f46978i);
        byte[] bArrA = this.f46972c.a(cuesWithTiming.f46934a, cuesWithTiming.f46936c);
        this.f46973d.T(bArrA);
        this.f46970a.b(this.f46973d, bArrA.length);
        long j4 = cuesWithTiming.f46935b;
        if (j4 == -9223372036854775807L) {
            Assertions.g(this.f46978i.f40637t == Long.MAX_VALUE);
        } else {
            long j5 = this.f46978i.f40637t;
            j3 = j5 == Long.MAX_VALUE ? j3 + j4 : j4 + j5;
        }
        this.f46970a.g(j3, i3 | 1, bArrA.length, 0, null);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void a(ParsableByteArray parsableByteArray, int i3, int i4) {
        if (this.f46977h == null) {
            this.f46970a.a(parsableByteArray, i3, i4);
            return;
        }
        i(i3);
        parsableByteArray.l(this.f46976g, this.f46975f, i3);
        this.f46975f += i3;
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void c(Format format) {
        Assertions.e(format.f40632o);
        Assertions.a(MimeTypes.k(format.f40632o) == 3);
        if (!format.equals(this.f46978i)) {
            this.f46978i = format;
            this.f46977h = this.f46971b.a(format) ? this.f46971b.c(format) : null;
        }
        if (this.f46977h == null) {
            this.f46970a.c(format);
        } else {
            this.f46970a.c(format.b().u0("application/x-media3-cues").S(format.f40632o).y0(Long.MAX_VALUE).W(this.f46971b.b(format)).N());
        }
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int f(DataReader dataReader, int i3, boolean z2, int i4) throws EOFException {
        if (this.f46977h == null) {
            return this.f46970a.f(dataReader, i3, z2, i4);
        }
        i(i3);
        int i5 = dataReader.read(this.f46976g, this.f46975f, i3);
        if (i5 != -1) {
            this.f46975f += i5;
            return i5;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void g(final long j3, final int i3, int i4, int i5, TrackOutput.CryptoData cryptoData) {
        if (this.f46977h == null) {
            this.f46970a.g(j3, i3, i4, i5, cryptoData);
            return;
        }
        Assertions.b(cryptoData == null, "DRM on subtitles is not supported");
        int i6 = (this.f46975f - i5) - i4;
        try {
            this.f46977h.a(this.f46976g, i6, i4, SubtitleParser.OutputOptions.b(), new Consumer() { // from class: androidx.media3.extractor.text.f
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f47123a.j((CuesWithTiming) obj, j3, i3);
                }
            });
        } catch (RuntimeException e3) {
            if (!this.f46979j) {
                throw e3;
            }
            Log.j("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e3);
        }
        int i7 = i6 + i4;
        this.f46974e = i7;
        if (i7 == this.f46975f) {
            this.f46974e = 0;
            this.f46975f = 0;
        }
    }

    public void k() {
        SubtitleParser subtitleParser = this.f46977h;
        if (subtitleParser != null) {
            subtitleParser.reset();
        }
    }

    public void l(boolean z2) {
        this.f46979j = z2;
    }
}
