package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@JvmInline
public final class Duration implements Comparable<Duration> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f140631b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f140632c = i(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f140633d = DurationKt.j(4611686018427387903L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f140634f = DurationKt.j(-4611686018427387903L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f140635a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.f140633d;
        }

        public final long b() {
            return Duration.f140634f;
        }

        public final long c() {
            return Duration.f140632c;
        }

        public final long d(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.p(value, true);
            } catch (IllegalArgumentException e3) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e3);
            }
        }

        private Companion() {
        }
    }

    private /* synthetic */ Duration(long j3) {
        this.f140635a = j3;
    }

    private static final boolean A(long j3) {
        return (((int) j3) & 1) == 1;
    }

    private static final boolean B(long j3) {
        return (((int) j3) & 1) == 0;
    }

    public static final boolean C(long j3) {
        return j3 == f140633d || j3 == f140634f;
    }

    public static final boolean D(long j3) {
        return j3 < 0;
    }

    public static final boolean E(long j3) {
        return j3 > 0;
    }

    public static final long F(long j3, long j4) {
        return G(j3, R(j4));
    }

    public static final long G(long j3, long j4) {
        if (C(j3)) {
            if (z(j4) || (j4 ^ j3) >= 0) {
                return j3;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (C(j4)) {
            return j4;
        }
        if ((((int) j3) & 1) != (((int) j4) & 1)) {
            return A(j3) ? d(j3, x(j3), x(j4)) : d(j3, x(j4), x(j3));
        }
        long jX = x(j3) + x(j4);
        return B(j3) ? DurationKt.m(jX) : DurationKt.k(jX);
    }

    public static final long H(long j3, int i3) {
        if (C(j3)) {
            if (i3 != 0) {
                return i3 > 0 ? j3 : R(j3);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (i3 == 0) {
            return f140632c;
        }
        long jX = x(j3);
        long j4 = i3;
        long j5 = jX * j4;
        if (!B(j3)) {
            return j5 / j4 == jX ? DurationKt.j(RangesKt.s(j5, new LongRange(-4611686018427387903L, 4611686018427387903L))) : MathKt.b(jX) * MathKt.a(i3) > 0 ? f140633d : f140634f;
        }
        if (-2147483647L <= jX && jX < 2147483648L) {
            return DurationKt.l(j5);
        }
        if (j5 / j4 == jX) {
            return DurationKt.m(j5);
        }
        long jO = DurationKt.o(jX);
        long j6 = jO * j4;
        long jO2 = DurationKt.o((jX - DurationKt.n(jO)) * j4) + j6;
        return (j6 / j4 != jO || (jO2 ^ j6) < 0) ? MathKt.b(jX) * MathKt.a(i3) > 0 ? f140633d : f140634f : DurationKt.j(RangesKt.s(jO2, new LongRange(-4611686018427387903L, 4611686018427387903L)));
    }

    public static final double I(long j3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j3 == f140633d) {
            return Double.POSITIVE_INFINITY;
        }
        if (j3 == f140634f) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt__DurationUnitJvmKt.a(x(j3), w(j3), unit);
    }

    public static final String O(long j3) {
        StringBuilder sb = new StringBuilder();
        if (D(j3)) {
            sb.append('-');
        }
        sb.append("PT");
        long jL = l(j3);
        long jO = o(jL);
        int iT = t(jL);
        int iV = v(jL);
        int iU = u(jL);
        long j4 = C(j3) ? 9999999999999L : jO;
        boolean z2 = false;
        boolean z3 = j4 != 0;
        boolean z4 = (iV == 0 && iU == 0) ? false : true;
        if (iT != 0 || (z4 && z3)) {
            z2 = true;
        }
        if (z3) {
            sb.append(j4);
            sb.append('H');
        }
        if (z2) {
            sb.append(iT);
            sb.append('M');
        }
        if (z4 || (!z3 && !z2)) {
            e(j3, sb, iV, iU, 9, "S", true);
        }
        return sb.toString();
    }

    public static final long P(long j3, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j3 == f140633d) {
            return Long.MAX_VALUE;
        }
        if (j3 == f140634f) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(x(j3), w(j3), unit);
    }

    public static String Q(long j3) {
        if (j3 == 0) {
            return "0s";
        }
        if (j3 == f140633d) {
            return "Infinity";
        }
        if (j3 == f140634f) {
            return "-Infinity";
        }
        boolean zD = D(j3);
        StringBuilder sb = new StringBuilder();
        if (zD) {
            sb.append('-');
        }
        long jL = l(j3);
        long jN = n(jL);
        int iM = m(jL);
        int iT = t(jL);
        int iV = v(jL);
        int iU = u(jL);
        int i3 = 0;
        boolean z2 = jN != 0;
        boolean z3 = iM != 0;
        boolean z4 = iT != 0;
        boolean z5 = (iV == 0 && iU == 0) ? false : true;
        if (z2) {
            sb.append(jN);
            sb.append('d');
            i3 = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i4 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            sb.append(iM);
            sb.append('h');
            i3 = i4;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i5 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            sb.append(iT);
            sb.append('m');
            i3 = i5;
        }
        if (z5) {
            int i6 = i3 + 1;
            if (i3 > 0) {
                sb.append(' ');
            }
            if (iV != 0 || z2 || z3 || z4) {
                e(j3, sb, iV, iU, 9, "s", false);
            } else if (iU >= 1000000) {
                e(j3, sb, iU / 1000000, iU % 1000000, 6, "ms", false);
            } else if (iU >= 1000) {
                e(j3, sb, iU / 1000, iU % 1000, 3, "us", false);
            } else {
                sb.append(iU);
                sb.append("ns");
            }
            i3 = i6;
        }
        if (zD && i3 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }

    public static final long R(long j3) {
        return DurationKt.i(-x(j3), ((int) j3) & 1);
    }

    private static final long d(long j3, long j4, long j5) {
        long jO = DurationKt.o(j5);
        long j6 = j4 + jO;
        if (-4611686018426L > j6 || j6 >= 4611686018427L) {
            return DurationKt.j(RangesKt.r(j6, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.l(DurationKt.n(j6) + (j5 - DurationKt.n(jO)));
    }

    private static final void e(long j3, StringBuilder sb, int i3, int i4, int i5, String str, boolean z2) {
        sb.append(i3);
        if (i4 != 0) {
            sb.append('.');
            String strC0 = StringsKt.C0(String.valueOf(i4), i5, '0');
            int i6 = -1;
            int length = strC0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i7 = length - 1;
                    if (strC0.charAt(length) != '0') {
                        i6 = length;
                        break;
                    } else if (i7 < 0) {
                        break;
                    } else {
                        length = i7;
                    }
                }
            }
            int i8 = i6 + 1;
            if (z2 || i8 >= 3) {
                sb.append((CharSequence) strC0, 0, ((i6 + 3) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            } else {
                sb.append((CharSequence) strC0, 0, i8);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ Duration f(long j3) {
        return new Duration(j3);
    }

    public static int h(long j3, long j4) {
        long j5 = j3 ^ j4;
        if (j5 < 0 || (((int) j5) & 1) == 0) {
            return Intrinsics.compare(j3, j4);
        }
        int i3 = (((int) j3) & 1) - (((int) j4) & 1);
        return D(j3) ? -i3 : i3;
    }

    public static long i(long j3) {
        if (!DurationJvmKt.a()) {
            return j3;
        }
        if (B(j3)) {
            long jX = x(j3);
            if (-4611686018426999999L <= jX && jX < 4611686018427000000L) {
                return j3;
            }
            throw new AssertionError(x(j3) + " ns is out of nanoseconds range");
        }
        long jX2 = x(j3);
        if (-4611686018427387903L > jX2 || jX2 >= 4611686018427387904L) {
            throw new AssertionError(x(j3) + " ms is out of milliseconds range");
        }
        long jX3 = x(j3);
        if (-4611686018426L > jX3 || jX3 >= 4611686018427L) {
            return j3;
        }
        throw new AssertionError(x(j3) + " ms is denormalized");
    }

    public static boolean j(long j3, Object obj) {
        return (obj instanceof Duration) && j3 == ((Duration) obj).S();
    }

    public static final boolean k(long j3, long j4) {
        return j3 == j4;
    }

    public static final long l(long j3) {
        return D(j3) ? R(j3) : j3;
    }

    public static final int m(long j3) {
        if (C(j3)) {
            return 0;
        }
        return (int) (o(j3) % ((long) 24));
    }

    public static final long n(long j3) {
        return P(j3, DurationUnit.f140644i);
    }

    public static final long o(long j3) {
        return P(j3, DurationUnit.f140643h);
    }

    public static final long p(long j3) {
        return (A(j3) && z(j3)) ? x(j3) : P(j3, DurationUnit.f140640d);
    }

    public static final long q(long j3) {
        return P(j3, DurationUnit.f140642g);
    }

    public static final long r(long j3) {
        long jX = x(j3);
        if (B(j3)) {
            return jX;
        }
        if (jX > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (jX < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.n(jX);
    }

    public static final long s(long j3) {
        return P(j3, DurationUnit.f140641f);
    }

    public static final int t(long j3) {
        if (C(j3)) {
            return 0;
        }
        return (int) (q(j3) % ((long) 60));
    }

    public static final int u(long j3) {
        if (C(j3)) {
            return 0;
        }
        return (int) (A(j3) ? DurationKt.n(x(j3) % ((long) 1000)) : x(j3) % ((long) 1000000000));
    }

    public static final int v(long j3) {
        if (C(j3)) {
            return 0;
        }
        return (int) (s(j3) % ((long) 60));
    }

    private static final DurationUnit w(long j3) {
        return B(j3) ? DurationUnit.f140638b : DurationUnit.f140640d;
    }

    private static final long x(long j3) {
        return j3 >> 1;
    }

    public static int y(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean z(long j3) {
        return !C(j3);
    }

    public final /* synthetic */ long S() {
        return this.f140635a;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return g(duration.S());
    }

    public boolean equals(Object obj) {
        return j(this.f140635a, obj);
    }

    public int g(long j3) {
        return h(this.f140635a, j3);
    }

    public int hashCode() {
        return y(this.f140635a);
    }

    public String toString() {
        return Q(this.f140635a);
    }
}
