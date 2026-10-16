package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LegacyDragAndDropSourceWithDefaultShadowElement extends ModifierNodeElement<LegacyDragSourceNodeWithDefaultPainter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f5364a;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LegacyDragSourceNodeWithDefaultPainter create() {
        return new LegacyDragSourceNodeWithDefaultPainter(this.f5364a);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LegacyDragSourceNodeWithDefaultPainter legacyDragSourceNodeWithDefaultPainter) {
        legacyDragSourceNodeWithDefaultPainter.t2(this.f5364a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LegacyDragAndDropSourceWithDefaultShadowElement) {
            return Intrinsics.areEqual(this.f5364a, ((LegacyDragAndDropSourceWithDefaultShadowElement) obj).f5364a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5364a.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d(CbYNFSEGaQj.xoJKZF);
        inspectorInfo.b().c("dragAndDropSourceHandler", this.f5364a);
    }
}
