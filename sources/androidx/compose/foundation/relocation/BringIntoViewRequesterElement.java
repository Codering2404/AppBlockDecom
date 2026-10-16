package androidx.compose.foundation.relocation;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
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
final class BringIntoViewRequesterElement extends ModifierNodeElement<BringIntoViewRequesterNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BringIntoViewRequester f8919a;

    public BringIntoViewRequesterElement(BringIntoViewRequester bringIntoViewRequester) {
        this.f8919a = bringIntoViewRequester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BringIntoViewRequesterNode create() {
        return new BringIntoViewRequesterNode(this.f8919a);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(BringIntoViewRequesterNode bringIntoViewRequesterNode) {
        bringIntoViewRequesterNode.n2(this.f8919a);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof BringIntoViewRequesterElement) && Intrinsics.areEqual(this.f8919a, ((BringIntoViewRequesterElement) obj).f8919a);
        }
        return true;
    }

    public int hashCode() {
        return this.f8919a.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("bringIntoViewRequester");
        inspectorInfo.b().c("bringIntoViewRequester", this.f8919a);
    }
}
