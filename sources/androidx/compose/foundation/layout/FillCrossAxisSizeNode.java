package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
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
public final class FillCrossAxisSizeNode extends Modifier.Node implements ParentDataModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6765a;

    public FillCrossAxisSizeNode(float f3) {
        this.f6765a = f3;
    }

    public final float m2() {
        return this.f6765a;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    /* JADX INFO: renamed from: n2, reason: merged with bridge method [inline-methods] */
    public RowColumnParentData H(Density density, Object obj) {
        RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0.0f, false, null, null, 15, null);
        }
        FlowLayoutData flowLayoutDataC = rowColumnParentData.c();
        if (flowLayoutDataC == null) {
            flowLayoutDataC = new FlowLayoutData(this.f6765a);
        }
        rowColumnParentData.g(flowLayoutDataC);
        FlowLayoutData flowLayoutDataC2 = rowColumnParentData.c();
        Intrinsics.checkNotNull(flowLayoutDataC2);
        flowLayoutDataC2.b(this.f6765a);
        return rowColumnParentData;
    }

    public final void o2(float f3) {
        this.f6765a = f3;
    }
}
