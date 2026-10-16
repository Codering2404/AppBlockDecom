package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExtractorsFactory f44550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Extractor f44551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExtractorInput f44552c;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory) {
        this.f44550a = extractorsFactory;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void a(long j3, long j4) {
        ((Extractor) Assertions.e(this.f44551b)).a(j3, j4);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void b() {
        Extractor extractor = this.f44551b;
        if (extractor == null) {
            return;
        }
        Extractor extractorC = extractor.c();
        if (extractorC instanceof Mp3Extractor) {
            ((Mp3Extractor) extractorC).l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(androidx.media3.common.DataReader r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, androidx.media3.extractor.ExtractorOutput r15) throws androidx.media3.exoplayer.source.UnrecognizedInputFormatException {
        /*
            r7 = this;
            androidx.media3.extractor.DefaultExtractorInput r1 = new androidx.media3.extractor.DefaultExtractorInput
            r2 = r8
            r3 = r11
            r5 = r13
            r1.<init>(r2, r3, r5)
            r7.f44552c = r1
            androidx.media3.extractor.Extractor r8 = r7.f44551b
            if (r8 == 0) goto Lf
            return
        Lf:
            androidx.media3.extractor.ExtractorsFactory r8 = r7.f44550a
            androidx.media3.extractor.Extractor[] r8 = r8.d(r9, r10)
            int r10 = r8.length
            com.google.common.collect.ImmutableList$Builder r10 = com.google.common.collect.ImmutableList.p(r10)
            int r11 = r8.length
            r12 = 0
            r13 = 1
            if (r11 != r13) goto L25
            r8 = r8[r12]
            r7.f44551b = r8
            goto L83
        L25:
            int r11 = r8.length
            r14 = r12
        L27:
            if (r14 >= r11) goto L7f
            r0 = r8[r14]
            boolean r2 = r0.g(r1)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            if (r2 == 0) goto L3d
            r7.f44551b = r0     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            androidx.media3.common.util.Assertions.g(r13)
            r1.f()
            goto L7f
        L3a:
            r0 = move-exception
            r8 = r0
            goto L5b
        L3d:
            java.util.List r0 = r0.i()     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            r10.k(r0)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6f
            androidx.media3.extractor.Extractor r0 = r7.f44551b
            if (r0 != 0) goto L53
            long r5 = r1.getPosition()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L53
        L51:
            r0 = r12
            goto L54
        L53:
            r0 = r13
        L54:
            androidx.media3.common.util.Assertions.g(r0)
            r1.f()
            goto L7c
        L5b:
            androidx.media3.extractor.Extractor r9 = r7.f44551b
            if (r9 != 0) goto L67
            long r9 = r1.getPosition()
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L68
        L67:
            r12 = r13
        L68:
            androidx.media3.common.util.Assertions.g(r12)
            r1.f()
            throw r8
        L6f:
            androidx.media3.extractor.Extractor r0 = r7.f44551b
            if (r0 != 0) goto L53
            long r5 = r1.getPosition()
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 != 0) goto L51
            goto L53
        L7c:
            int r14 = r14 + 1
            goto L27
        L7f:
            androidx.media3.extractor.Extractor r11 = r7.f44551b
            if (r11 == 0) goto L89
        L83:
            androidx.media3.extractor.Extractor r8 = r7.f44551b
            r8.h(r15)
            return
        L89:
            androidx.media3.exoplayer.source.UnrecognizedInputFormatException r11 = new androidx.media3.exoplayer.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "None of the available extractors ("
            r12.append(r13)
            java.lang.String r13 = ", "
            com.google.common.base.Joiner r13 = com.google.common.base.Joiner.i(r13)
            com.google.common.collect.ImmutableList r8 = com.google.common.collect.ImmutableList.v(r8)
            androidx.media3.exoplayer.source.a r14 = new androidx.media3.exoplayer.source.a
            r14.<init>()
            java.util.List r8 = com.google.common.collect.Lists.p(r8, r14)
            java.lang.String r8 = r13.e(r8)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.Object r9 = androidx.media3.common.util.Assertions.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            com.google.common.collect.ImmutableList r10 = r10.m()
            r11.<init>(r8, r9, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.BundledExtractorsAdapter.c(androidx.media3.common.DataReader, android.net.Uri, java.util.Map, long, long, androidx.media3.extractor.ExtractorOutput):void");
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public long d() {
        ExtractorInput extractorInput = this.f44552c;
        if (extractorInput != null) {
            return extractorInput.getPosition();
        }
        return -1L;
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public int e(PositionHolder positionHolder) {
        return ((Extractor) Assertions.e(this.f44551b)).j((ExtractorInput) Assertions.e(this.f44552c), positionHolder);
    }

    @Override // androidx.media3.exoplayer.source.ProgressiveMediaExtractor
    public void release() {
        Extractor extractor = this.f44551b;
        if (extractor != null) {
            extractor.release();
            this.f44551b = null;
        }
        this.f44552c = null;
    }
}
