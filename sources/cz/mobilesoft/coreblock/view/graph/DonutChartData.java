package cz.mobilesoft.coreblock.view.graph;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DonutChartData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f132736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f132737b;

    public /* synthetic */ DonutChartData(float f3, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, j3);
    }

    public final float a() {
        return this.f132736a;
    }

    public final long b() {
        return this.f132737b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DonutChartData)) {
            return false;
        }
        DonutChartData donutChartData = (DonutChartData) obj;
        return Float.compare(this.f132736a, donutChartData.f132736a) == 0 && Color.t(this.f132737b, donutChartData.f132737b);
    }

    public int hashCode() {
        return (Float.hashCode(this.f132736a) * 31) + Color.z(this.f132737b);
    }

    public String toString() {
        return "DonutChartData(amount=" + this.f132736a + ", color=" + Color.A(this.f132737b) + ")";
    }

    private DonutChartData(float f3, long j3) {
        this.f132736a = f3;
        this.f132737b = j3;
    }
}
