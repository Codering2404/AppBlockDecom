package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class ColorSpace {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f25975d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f25977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f25978c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ColorSpace(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, i3);
    }

    public final float[] a(float f3, float f4, float f5) {
        float[] fArr = new float[ColorModel.g(this.f25977b)];
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f5;
        return b(fArr);
    }

    public abstract float[] b(float[] fArr);

    public final int c() {
        return ColorModel.g(this.f25977b);
    }

    public final int d() {
        return this.f25978c;
    }

    public abstract float e(int i3);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorSpace colorSpace = (ColorSpace) obj;
        if (this.f25978c == colorSpace.f25978c && Intrinsics.areEqual(this.f25976a, colorSpace.f25976a)) {
            return ColorModel.f(this.f25977b, colorSpace.f25977b);
        }
        return false;
    }

    public abstract float f(int i3);

    public final long g() {
        return this.f25977b;
    }

    public final String h() {
        return this.f25976a;
    }

    public int hashCode() {
        return (((this.f25976a.hashCode() * 31) + ColorModel.h(this.f25977b)) * 31) + this.f25978c;
    }

    public boolean i() {
        return false;
    }

    public long j(float f3, float f4, float f5) {
        float[] fArrK = k(f3, f4, f5);
        float f6 = fArrK[0];
        float f7 = fArrK[1];
        return (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f7)) & 4294967295L);
    }

    public final float[] k(float f3, float f4, float f5) {
        return l(new float[]{f3, f4, f5});
    }

    public abstract float[] l(float[] fArr);

    public float m(float f3, float f4, float f5) {
        return k(f3, f4, f5)[2];
    }

    public long n(float f3, float f4, float f5, float f6, ColorSpace colorSpace) {
        float[] fArrA = a(f3, f4, f5);
        return ColorKt.a(fArrA[0], fArrA[1], fArrA[2], f6, colorSpace);
    }

    public String toString() {
        return this.f25976a + " (id=" + this.f25978c + ", model=" + ((Object) ColorModel.i(this.f25977b)) + ')';
    }

    private ColorSpace(String str, long j3, int i3) {
        this.f25976a = str;
        this.f25977b = j3;
        this.f25978c = i3;
        if (str.length() == 0) {
            throw new IllegalArgumentException("The name of a color space cannot be null and must contain at least 1 character");
        }
        if (i3 < -1 || i3 > 63) {
            throw new IllegalArgumentException("The id must be between -1 and 63");
        }
    }
}
