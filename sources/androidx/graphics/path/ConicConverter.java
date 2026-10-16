package androidx.graphics.path;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ConicConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f39794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f39795c = new float[130];

    private final native int internalConicToQuadratics(float[] fArr, int i3, float[] fArr2, float f3, float f4);

    public final void a(float[] points, float f3, float f4, int i3) {
        Intrinsics.checkNotNullParameter(points, "points");
        int iInternalConicToQuadratics = internalConicToQuadratics(points, i3, this.f39795c, f3, f4);
        this.f39793a = iInternalConicToQuadratics;
        int i4 = (iInternalConicToQuadratics * 4) + 2;
        if (i4 > this.f39795c.length) {
            float[] fArr = new float[i4];
            this.f39795c = fArr;
            this.f39793a = internalConicToQuadratics(points, i3, fArr, f3, f4);
        }
        this.f39794b = 0;
    }

    public final int b() {
        return this.f39794b;
    }

    public final int c() {
        return this.f39793a;
    }

    public final boolean d(float[] points, int i3) {
        Intrinsics.checkNotNullParameter(points, "points");
        int i4 = this.f39794b;
        if (i4 >= this.f39793a) {
            return false;
        }
        int i5 = i4 * 4;
        float[] fArr = this.f39795c;
        points[i3] = fArr[i5];
        points[i3 + 1] = fArr[i5 + 1];
        points[i3 + 2] = fArr[i5 + 2];
        points[i3 + 3] = fArr[i5 + 3];
        points[i3 + 4] = fArr[i5 + 4];
        points[i3 + 5] = fArr[i5 + 5];
        this.f39794b = i4 + 1;
        return true;
    }
}
