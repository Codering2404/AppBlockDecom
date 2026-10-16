package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Color {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25715b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f25716c = ColorKt.d(4278190080L);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f25717d = ColorKt.d(4282664004L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f25718e = ColorKt.d(4287137928L);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final long f25719f = ColorKt.d(4291611852L);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f25720g = ColorKt.d(4294967295L);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f25721h = ColorKt.d(4294901760L);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f25722i = ColorKt.d(4278255360L);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f25723j = ColorKt.d(4278190335L);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f25724k = ColorKt.d(4294967040L);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f25725l = ColorKt.d(4278255615L);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f25726m = ColorKt.d(4294902015L);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f25727n = ColorKt.b(0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f25728o = ColorKt.a(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.f25979a.I());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25729a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Color.f25716c;
        }

        public final long b() {
            return Color.f25723j;
        }

        public final long c() {
            return Color.f25725l;
        }

        public final long d() {
            return Color.f25717d;
        }

        public final long e() {
            return Color.f25718e;
        }

        public final long f() {
            return Color.f25722i;
        }

        public final long g() {
            return Color.f25719f;
        }

        public final long h() {
            return Color.f25726m;
        }

        public final long i() {
            return Color.f25721h;
        }

        public final long j() {
            return Color.f25727n;
        }

        public final long k() {
            return Color.f25728o;
        }

        public final long l() {
            return Color.f25720g;
        }

        public final long m() {
            return Color.f25724k;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Color(long j3) {
        this.f25729a = j3;
    }

    public static String A(long j3) {
        return "Color(" + y(j3) + ", " + x(j3) + ", " + v(j3) + ", " + u(j3) + ", " + w(j3).h() + ')';
    }

    public static final /* synthetic */ Color n(long j3) {
        return new Color(j3);
    }

    public static final long p(long j3, ColorSpace colorSpace) {
        return ColorSpaceKt.i(w(j3), colorSpace, 0, 2, null).a(j3);
    }

    public static final long q(long j3, float f3, float f4, float f5, float f6) {
        return ColorKt.a(f4, f5, f6, f3, w(j3));
    }

    public static /* synthetic */ long r(long j3, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = u(j3);
        }
        float f7 = f3;
        if ((i3 & 2) != 0) {
            f4 = y(j3);
        }
        float f8 = f4;
        if ((i3 & 4) != 0) {
            f5 = x(j3);
        }
        float f9 = f5;
        if ((i3 & 8) != 0) {
            f6 = v(j3);
        }
        return q(j3, f7, f8, f9, f6);
    }

    public static boolean s(long j3, Object obj) {
        return (obj instanceof Color) && j3 == ((Color) obj).B();
    }

    public static final boolean t(long j3, long j4) {
        return ULong.d(j3, j4);
    }

    public static final float u(long j3) {
        float fE;
        float f3;
        if (ULong.b(63 & j3) == 0) {
            fE = (float) UnsignedKt.e(ULong.b(ULong.b(j3 >>> 56) & 255));
            f3 = 255.0f;
        } else {
            fE = (float) UnsignedKt.e(ULong.b(ULong.b(j3 >>> 6) & 1023));
            f3 = 1023.0f;
        }
        return fE / f3;
    }

    public static final float v(long j3) {
        int i3;
        int i4;
        int i5;
        if (ULong.b(63 & j3) == 0) {
            return ((float) UnsignedKt.e(ULong.b(ULong.b(j3 >>> 32) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j3 >>> 16) & 65535);
        int i6 = Short.MIN_VALUE & sB;
        int i7 = ((65535 & sB) >>> 10) & 31;
        int i8 = sB & 1023;
        if (i7 != 0) {
            int i9 = i8 << 13;
            if (i7 == 31) {
                i3 = 255;
                if (i9 != 0) {
                    i9 |= 4194304;
                }
            } else {
                i3 = i7 + 112;
            }
            int i10 = i3;
            i4 = i9;
            i5 = i10;
        } else {
            if (i8 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i8 + 1056964608) - Float16Kt.f25761a;
                return i6 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i5 = 0;
            i4 = 0;
        }
        return Float.intBitsToFloat((i5 << 23) | (i6 << 16) | i4);
    }

    public static final ColorSpace w(long j3) {
        ColorSpaces colorSpaces = ColorSpaces.f25979a;
        return colorSpaces.v()[(int) ULong.b(j3 & 63)];
    }

    public static final float x(long j3) {
        int i3;
        int i4;
        int i5;
        if (ULong.b(63 & j3) == 0) {
            return ((float) UnsignedKt.e(ULong.b(ULong.b(j3 >>> 40) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j3 >>> 32) & 65535);
        int i6 = Short.MIN_VALUE & sB;
        int i7 = ((65535 & sB) >>> 10) & 31;
        int i8 = sB & 1023;
        if (i7 != 0) {
            int i9 = i8 << 13;
            if (i7 == 31) {
                i3 = 255;
                if (i9 != 0) {
                    i9 |= 4194304;
                }
            } else {
                i3 = i7 + 112;
            }
            int i10 = i3;
            i4 = i9;
            i5 = i10;
        } else {
            if (i8 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i8 + 1056964608) - Float16Kt.f25761a;
                return i6 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i5 = 0;
            i4 = 0;
        }
        return Float.intBitsToFloat((i5 << 23) | (i6 << 16) | i4);
    }

    public static final float y(long j3) {
        int i3;
        int i4;
        int i5;
        if (ULong.b(63 & j3) == 0) {
            return ((float) UnsignedKt.e(ULong.b(ULong.b(j3 >>> 48) & 255))) / 255.0f;
        }
        short sB = (short) ULong.b(ULong.b(j3 >>> 48) & 65535);
        int i6 = Short.MIN_VALUE & sB;
        int i7 = ((65535 & sB) >>> 10) & 31;
        int i8 = sB & 1023;
        if (i7 != 0) {
            int i9 = i8 << 13;
            if (i7 == 31) {
                i3 = 255;
                if (i9 != 0) {
                    i9 |= 4194304;
                }
            } else {
                i3 = i7 + 112;
            }
            int i10 = i3;
            i4 = i9;
            i5 = i10;
        } else {
            if (i8 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i8 + 1056964608) - Float16Kt.f25761a;
                return i6 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i5 = 0;
            i4 = 0;
        }
        return Float.intBitsToFloat((i5 << 23) | (i6 << 16) | i4);
    }

    public static int z(long j3) {
        return ULong.e(j3);
    }

    public final /* synthetic */ long B() {
        return this.f25729a;
    }

    public boolean equals(Object obj) {
        return s(this.f25729a, obj);
    }

    public int hashCode() {
        return z(this.f25729a);
    }

    public String toString() {
        return A(this.f25729a);
    }

    public static long o(long j3) {
        return j3;
    }
}
