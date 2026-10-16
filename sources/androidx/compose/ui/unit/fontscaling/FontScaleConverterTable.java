package androidx.compose.ui.unit.fontscaling;

import java.util.Arrays;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FontScaleConverterTable implements FontScaleConverter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f30023c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f30024d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f30025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f30026b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(float f3, float[] fArr, float[] fArr2) {
            float f4;
            float f5;
            float f6;
            float fA;
            float fAbs = Math.abs(f3);
            float fSignum = Math.signum(f3);
            int iBinarySearch = Arrays.binarySearch(fArr, fAbs);
            if (iBinarySearch >= 0) {
                fA = fArr2[iBinarySearch];
            } else {
                int i3 = -(iBinarySearch + 1);
                int i4 = i3 - 1;
                float f7 = 0.0f;
                if (i4 >= fArr.length - 1) {
                    float f8 = fArr[fArr.length - 1];
                    float f9 = fArr2[fArr.length - 1];
                    if (f8 == 0.0f) {
                        return 0.0f;
                    }
                    return f3 * (f9 / f8);
                }
                if (i4 == -1) {
                    f4 = fArr[0];
                    f6 = fArr2[0];
                    f5 = 0.0f;
                } else {
                    f7 = fArr[i4];
                    f4 = fArr[i3];
                    f5 = fArr2[i4];
                    f6 = fArr2[i3];
                }
                fA = MathUtils.f30027a.a(f5, f6, f7, f4, fAbs);
            }
            return fSignum * fA;
        }

        private Companion() {
        }
    }

    public FontScaleConverterTable(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.f30025a = fArr;
        this.f30026b = fArr2;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float a(float f3) {
        return f30023c.b(f3, this.f30026b, this.f30025a);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float b(float f3) {
        return f30023c.b(f3, this.f30025a, this.f30026b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FontScaleConverterTable)) {
            return false;
        }
        FontScaleConverterTable fontScaleConverterTable = (FontScaleConverterTable) obj;
        return Arrays.equals(this.f30025a, fontScaleConverterTable.f30025a) && Arrays.equals(this.f30026b, fontScaleConverterTable.f30026b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f30025a) * 31) + Arrays.hashCode(this.f30026b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontScaleConverter{fromSpValues=");
        String string = Arrays.toString(this.f30025a);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.append(string);
        sb.append(", toDpValues=");
        String string2 = Arrays.toString(this.f30026b);
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        sb.append(string2);
        sb.append('}');
        return sb.toString();
    }
}
