package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DoubleArrayBuilder extends PrimitiveArrayBuilder<double[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f142793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f142794b;

    public DoubleArrayBuilder(double[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        this.f142793a = bufferWithData;
        this.f142794b = bufferWithData.length;
        b(10);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void b(int i3) {
        double[] dArr = this.f142793a;
        if (dArr.length < i3) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, RangesKt.f(i3, dArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
            this.f142793a = dArrCopyOf;
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int d() {
        return this.f142794b;
    }

    public final void e(double d3) {
        PrimitiveArrayBuilder.c(this, 0, 1, null);
        double[] dArr = this.f142793a;
        int iD = d();
        this.f142794b = iD + 1;
        dArr[iD] = d3;
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f142793a, d());
        Intrinsics.checkNotNullExpressionValue(dArrCopyOf, "copyOf(...)");
        return dArrCopyOf;
    }
}
