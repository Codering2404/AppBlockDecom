package cz.mobilesoft.coreblock.view.graph;

import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DonutChartDataCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f132738a;

    public DonutChartDataCollection(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f132738a = items;
    }

    public final List a() {
        return this.f132738a;
    }

    public final float b() {
        Iterator it = this.f132738a.iterator();
        double dA = 0.0d;
        while (it.hasNext()) {
            dA += (double) ((DonutChartData) it.next()).a();
        }
        return (float) dA;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DonutChartDataCollection) && Intrinsics.areEqual(this.f132738a, ((DonutChartDataCollection) obj).f132738a);
    }

    public int hashCode() {
        return this.f132738a.hashCode();
    }

    public String toString() {
        return "DonutChartDataCollection(items=" + this.f132738a + ")";
    }
}
