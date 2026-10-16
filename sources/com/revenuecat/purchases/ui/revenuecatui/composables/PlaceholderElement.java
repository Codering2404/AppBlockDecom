package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.ui.Modifier;
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
final class PlaceholderElement extends ModifierNodeElement<PlaceholderNode> {
    private Placeholder placeholder;

    public PlaceholderElement(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.placeholder = placeholder;
    }

    public static /* synthetic */ PlaceholderElement copy$default(PlaceholderElement placeholderElement, Placeholder placeholder, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            placeholder = placeholderElement.placeholder;
        }
        return placeholderElement.copy(placeholder);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ boolean all(Function1 function1) {
        return super.all(function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ boolean any(Function1 function1) {
        return super.any(function1);
    }

    public final Placeholder component1() {
        return this.placeholder;
    }

    public final PlaceholderElement copy(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        return new PlaceholderElement(placeholder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlaceholderElement) && Intrinsics.areEqual(this.placeholder, ((PlaceholderElement) obj).placeholder);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return super.foldIn(obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element
    public /* bridge */ /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return super.foldOut(obj, function2);
    }

    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }

    public int hashCode() {
        return this.placeholder.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.d("placeholder");
        inspectorInfo.b().c("placeholder", this.placeholder);
        inspectorInfo.b().c("loadingDescription", "Loading..");
    }

    public final void setPlaceholder(Placeholder placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "<set-?>");
        this.placeholder = placeholder;
    }

    @Override // androidx.compose.ui.Modifier
    public /* bridge */ /* synthetic */ Modifier then(Modifier modifier) {
        return super.then(modifier);
    }

    public String toString() {
        return "PlaceholderElement(placeholder=" + this.placeholder + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public PlaceholderNode create() {
        return new PlaceholderNode(this.placeholder);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(PlaceholderNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setPlaceholder(this.placeholder);
    }
}
