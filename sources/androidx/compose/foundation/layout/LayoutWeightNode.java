package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

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
public final class LayoutWeightNode extends Modifier.Node implements ParentDataModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7003b;

    public LayoutWeightNode(float f3, boolean z2) {
        this.f7002a = f3;
        this.f7003b = z2;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] */
    public RowColumnParentData H(Density density, Object obj) {
        RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0.0f, false, null, null, 15, null);
        }
        rowColumnParentData.h(this.f7002a);
        rowColumnParentData.f(this.f7003b);
        return rowColumnParentData;
    }

    public final void n2(boolean z2) {
        this.f7003b = z2;
    }

    public final void o2(float f3) {
        this.f7002a = f3;
    }
}
