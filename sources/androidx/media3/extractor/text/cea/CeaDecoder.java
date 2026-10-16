package androidx.media3.extractor.text.cea;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderOutputBuffer;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import androidx.media3.extractor.text.cea.CeaDecoder;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class CeaDecoder implements SubtitleDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayDeque f47054a = new ArrayDeque();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayDeque f47055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayDeque f47056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CeaInputBuffer f47057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f47058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f47059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f47060g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f47061l;

        private CeaInputBuffer() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public int compareTo(CeaInputBuffer ceaInputBuffer) {
            if (i() != ceaInputBuffer.i()) {
                return i() ? 1 : -1;
            }
            long j3 = this.f42140g - ceaInputBuffer.f42140g;
            if (j3 == 0) {
                j3 = this.f47061l - ceaInputBuffer.f47061l;
                if (j3 == 0) {
                    return 0;
                }
            }
            return j3 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CeaOutputBuffer extends SubtitleOutputBuffer {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private DecoderOutputBuffer.Owner f47062h;

        public CeaOutputBuffer(DecoderOutputBuffer.Owner owner) {
            this.f47062h = owner;
        }

        @Override // androidx.media3.decoder.DecoderOutputBuffer
        public final void o() {
            this.f47062h.a(this);
        }
    }

    public CeaDecoder() {
        for (int i3 = 0; i3 < 10; i3++) {
            this.f47054a.add(new CeaInputBuffer());
        }
        this.f47055b = new ArrayDeque();
        for (int i4 = 0; i4 < 2; i4++) {
            this.f47055b.add(new CeaOutputBuffer(new DecoderOutputBuffer.Owner() { // from class: androidx.media3.extractor.text.cea.b
                @Override // androidx.media3.decoder.DecoderOutputBuffer.Owner
                public final void a(DecoderOutputBuffer decoderOutputBuffer) {
                    this.f47064a.p((CeaDecoder.CeaOutputBuffer) decoderOutputBuffer);
                }
            }));
        }
        this.f47056c = new ArrayDeque();
        this.f47060g = -9223372036854775807L;
    }

    private void o(CeaInputBuffer ceaInputBuffer) {
        ceaInputBuffer.f();
        this.f47054a.add(ceaInputBuffer);
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public void c(long j3) {
        this.f47058e = j3;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void e(long j3) {
        this.f47060g = j3;
    }

    @Override // androidx.media3.decoder.Decoder
    public void flush() {
        this.f47059f = 0L;
        this.f47058e = 0L;
        while (!this.f47056c.isEmpty()) {
            o((CeaInputBuffer) Util.k((CeaInputBuffer) this.f47056c.poll()));
        }
        CeaInputBuffer ceaInputBuffer = this.f47057d;
        if (ceaInputBuffer != null) {
            o(ceaInputBuffer);
            this.f47057d = null;
        }
    }

    protected abstract Subtitle g();

    protected abstract void h(SubtitleInputBuffer subtitleInputBuffer);

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public SubtitleInputBuffer f() {
        Assertions.g(this.f47057d == null);
        if (this.f47054a.isEmpty()) {
            return null;
        }
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) this.f47054a.pollFirst();
        this.f47057d = ceaInputBuffer;
        return ceaInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public SubtitleOutputBuffer a() {
        if (this.f47055b.isEmpty()) {
            return null;
        }
        while (!this.f47056c.isEmpty() && ((CeaInputBuffer) Util.k((CeaInputBuffer) this.f47056c.peek())).f42140g <= this.f47058e) {
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) Util.k((CeaInputBuffer) this.f47056c.poll());
            if (ceaInputBuffer.i()) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) Util.k((SubtitleOutputBuffer) this.f47055b.pollFirst());
                subtitleOutputBuffer.e(4);
                o(ceaInputBuffer);
                return subtitleOutputBuffer;
            }
            h(ceaInputBuffer);
            if (m()) {
                Subtitle subtitleG = g();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) Util.k((SubtitleOutputBuffer) this.f47055b.pollFirst());
                subtitleOutputBuffer2.p(ceaInputBuffer.f42140g, subtitleG, Long.MAX_VALUE);
                o(ceaInputBuffer);
                return subtitleOutputBuffer2;
            }
            o(ceaInputBuffer);
        }
        return null;
    }

    protected final SubtitleOutputBuffer k() {
        return (SubtitleOutputBuffer) this.f47055b.pollFirst();
    }

    protected final long l() {
        return this.f47058e;
    }

    protected abstract boolean m();

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    @Override // androidx.media3.decoder.Decoder
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(androidx.media3.extractor.text.SubtitleInputBuffer r7) {
        /*
            r6 = this;
            androidx.media3.extractor.text.cea.CeaDecoder$CeaInputBuffer r0 = r6.f47057d
            if (r7 != r0) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            androidx.media3.common.util.Assertions.a(r0)
            androidx.media3.extractor.text.cea.CeaDecoder$CeaInputBuffer r7 = (androidx.media3.extractor.text.cea.CeaDecoder.CeaInputBuffer) r7
            boolean r0 = r7.i()
            if (r0 != 0) goto L2d
            long r0 = r7.f42140g
            r2 = -9223372036854775808
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L2d
            long r2 = r6.f47060g
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L2d
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L2d
            r6.o(r7)
            goto L3c
        L2d:
            long r0 = r6.f47059f
            r2 = 1
            long r2 = r2 + r0
            r6.f47059f = r2
            androidx.media3.extractor.text.cea.CeaDecoder.CeaInputBuffer.u(r7, r0)
            java.util.ArrayDeque r0 = r6.f47056c
            r0.add(r7)
        L3c:
            r7 = 0
            r6.f47057d = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.CeaDecoder.b(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    protected void p(SubtitleOutputBuffer subtitleOutputBuffer) {
        subtitleOutputBuffer.f();
        this.f47055b.add(subtitleOutputBuffer);
    }

    @Override // androidx.media3.decoder.Decoder
    public void release() {
    }
}
