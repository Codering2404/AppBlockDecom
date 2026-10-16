package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class ThumbElement extends ModifierNodeElement<ThumbNode> {
    private final boolean checked;
    private final InteractionSource interactionSource;

    public ThumbElement(InteractionSource interactionSource, boolean z2) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        this.interactionSource = interactionSource;
        this.checked = z2;
    }

    public static /* synthetic */ ThumbElement copy$default(ThumbElement thumbElement, InteractionSource interactionSource, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            interactionSource = thumbElement.interactionSource;
        }
        if ((i3 & 2) != 0) {
            z2 = thumbElement.checked;
        }
        return thumbElement.copy(interactionSource, z2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ boolean all(Function1 function1) {
        return super.all(function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ boolean any(Function1 function1) {
        return super.any(function1);
    }

    public final InteractionSource component1() {
        return this.interactionSource;
    }

    public final boolean component2() {
        return this.checked;
    }

    public final ThumbElement copy(InteractionSource interactionSource, boolean z2) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        return new ThumbElement(interactionSource, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThumbElement)) {
            return false;
        }
        ThumbElement thumbElement = (ThumbElement) obj;
        return Intrinsics.areEqual(this.interactionSource, thumbElement.interactionSource) && this.checked == thumbElement.checked;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return super.foldIn(obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element
    public /* bridge */ /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return super.foldOut(obj, function2);
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public int hashCode() {
        return (this.interactionSource.hashCode() * 31) + Boolean.hashCode(this.checked);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.d("switchThumb");
        inspectorInfo.b().c("interactionSource", this.interactionSource);
        inspectorInfo.b().c("checked", Boolean.valueOf(this.checked));
    }

    @Override // androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Modifier then(Modifier modifier) {
        return super.then(modifier);
    }

    public String toString() {
        return "ThumbElement(interactionSource=" + this.interactionSource + ", checked=" + this.checked + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ThumbNode create() {
        return new ThumbNode(this.interactionSource, this.checked);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(ThumbNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setInteractionSource(this.interactionSource);
        if (node.getChecked() != this.checked) {
            LayoutModifierNodeKt.b(node);
        }
        node.setChecked(this.checked);
        node.update();
    }
}
