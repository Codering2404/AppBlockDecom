package androidx.compose.ui.layout;

import androidx.compose.ui.node.MeasureScopeWithLayoutNodeKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MultiContentMeasurePolicyImpl implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MultiContentMeasurePolicy f27179a;

    public MultiContentMeasurePolicyImpl(MultiContentMeasurePolicy multiContentMeasurePolicy) {
        this.f27179a = multiContentMeasurePolicy;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiContentMeasurePolicyImpl) && Intrinsics.areEqual(this.f27179a, ((MultiContentMeasurePolicyImpl) obj).f27179a);
    }

    public int hashCode() {
        return this.f27179a.hashCode();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return this.f27179a.maxIntrinsicHeight(intrinsicMeasureScope, MeasureScopeWithLayoutNodeKt.a(intrinsicMeasureScope), i3);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return this.f27179a.maxIntrinsicWidth(intrinsicMeasureScope, MeasureScopeWithLayoutNodeKt.a(intrinsicMeasureScope), i3);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        return this.f27179a.mo47measure3p2s80s(measureScope, MeasureScopeWithLayoutNodeKt.a(measureScope), j3);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return this.f27179a.minIntrinsicHeight(intrinsicMeasureScope, MeasureScopeWithLayoutNodeKt.a(intrinsicMeasureScope), i3);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return this.f27179a.minIntrinsicWidth(intrinsicMeasureScope, MeasureScopeWithLayoutNodeKt.a(intrinsicMeasureScope), i3);
    }

    public String toString() {
        return "MultiContentMeasurePolicyImpl(measurePolicy=" + this.f27179a + ')';
    }
}
