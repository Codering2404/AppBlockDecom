package androidx.media3.extractor.avi;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SeekPoint;
import androidx.media3.extractor.TrackOutput;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ChunkReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AviStreamHeaderChunk f46314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TrackOutput f46315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f46316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f46317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f46318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f46320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f46321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f46324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f46325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long[] f46326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int[] f46327n;

    public ChunkReader(int i3, AviStreamHeaderChunk aviStreamHeaderChunk, TrackOutput trackOutput) {
        this.f46314a = aviStreamHeaderChunk;
        int iB = aviStreamHeaderChunk.b();
        boolean z2 = true;
        if (iB != 1 && iB != 2) {
            z2 = false;
        }
        Assertions.a(z2);
        this.f46316c = d(i3, iB == 2 ? 1667497984 : 1651965952);
        this.f46318e = aviStreamHeaderChunk.a();
        this.f46315b = trackOutput;
        this.f46317d = iB == 2 ? d(i3, 1650720768) : -1;
        this.f46325l = -1L;
        this.f46326m = new long[512];
        this.f46327n = new int[512];
        this.f46319f = aviStreamHeaderChunk.f46311e;
    }

    private static int d(int i3, int i4) {
        return (((i3 % 10) + 48) << 8) | ((i3 / 10) + 48) | i4;
    }

    private long e(int i3) {
        return (this.f46318e * ((long) i3)) / ((long) this.f46319f);
    }

    private SeekPoint h(int i3) {
        return new SeekPoint(((long) this.f46327n[i3]) * g(), this.f46326m[i3]);
    }

    public void a() {
        this.f46322i++;
    }

    public void b(long j3, boolean z2) {
        if (this.f46325l == -1) {
            this.f46325l = j3;
        }
        if (z2) {
            if (this.f46324k == this.f46327n.length) {
                long[] jArr = this.f46326m;
                this.f46326m = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.f46327n;
                this.f46327n = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.f46326m;
            int i3 = this.f46324k;
            jArr2[i3] = j3;
            this.f46327n[i3] = this.f46323j;
            this.f46324k = i3 + 1;
        }
        this.f46323j++;
    }

    public void c() {
        int i3;
        this.f46326m = Arrays.copyOf(this.f46326m, this.f46324k);
        this.f46327n = Arrays.copyOf(this.f46327n, this.f46324k);
        if (!k() || this.f46314a.f46313g == 0 || (i3 = this.f46324k) <= 0) {
            return;
        }
        this.f46319f = i3;
    }

    public long f() {
        return e(this.f46322i);
    }

    public long g() {
        return e(1);
    }

    public SeekMap.SeekPoints i(long j3) {
        if (this.f46324k == 0) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.f46325l));
        }
        int iG = (int) (j3 / g());
        int i3 = Util.i(this.f46327n, iG, true, true);
        if (this.f46327n[i3] == iG) {
            return new SeekMap.SeekPoints(h(i3));
        }
        SeekPoint seekPointH = h(i3);
        int i4 = i3 + 1;
        return i4 < this.f46326m.length ? new SeekMap.SeekPoints(seekPointH, h(i4)) : new SeekMap.SeekPoints(seekPointH);
    }

    public boolean j(int i3) {
        return this.f46316c == i3 || this.f46317d == i3;
    }

    public boolean k() {
        return (this.f46316c & 1651965952) == 1651965952;
    }

    public boolean l() {
        return Arrays.binarySearch(this.f46327n, this.f46322i) >= 0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public boolean m(ExtractorInput extractorInput) {
        int i3 = this.f46321h;
        int iD = i3 - this.f46315b.d(extractorInput, i3, false);
        this.f46321h = iD;
        boolean z2 = iD == 0;
        if (z2) {
            if (this.f46320g > 0) {
                this.f46315b.g(f(), l() ? 1 : 0, this.f46320g, 0, null);
            }
            a();
        }
        return z2;
    }

    public void n(int i3) {
        this.f46320g = i3;
        this.f46321h = i3;
    }

    public void o(long j3) {
        if (this.f46324k == 0) {
            this.f46322i = 0;
        } else {
            this.f46322i = this.f46327n[Util.j(this.f46326m, j3, true, true)];
        }
    }
}
