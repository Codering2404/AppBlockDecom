package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.graphics.Brush;
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
public final class TextFieldCoreModifier extends ModifierNodeElement<TextFieldCoreModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextLayoutState f10441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TransformedTextFieldState f10442d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextFieldSelectionState f10443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Brush f10444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f10445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ScrollState f10446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Orientation f10447j;

    public TextFieldCoreModifier(boolean z2, boolean z3, TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextFieldSelectionState textFieldSelectionState, Brush brush, boolean z4, ScrollState scrollState, Orientation orientation) {
        this.f10439a = z2;
        this.f10440b = z3;
        this.f10441c = textLayoutState;
        this.f10442d = transformedTextFieldState;
        this.f10443f = textFieldSelectionState;
        this.f10444g = brush;
        this.f10445h = z4;
        this.f10446i = scrollState;
        this.f10447j = orientation;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextFieldCoreModifierNode create() {
        return new TextFieldCoreModifierNode(this.f10439a, this.f10440b, this.f10441c, this.f10442d, this.f10443f, this.f10444g, this.f10445h, this.f10446i, this.f10447j);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TextFieldCoreModifierNode textFieldCoreModifierNode) {
        textFieldCoreModifierNode.G2(this.f10439a, this.f10440b, this.f10441c, this.f10442d, this.f10443f, this.f10444g, this.f10445h, this.f10446i, this.f10447j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldCoreModifier)) {
            return false;
        }
        TextFieldCoreModifier textFieldCoreModifier = (TextFieldCoreModifier) obj;
        return this.f10439a == textFieldCoreModifier.f10439a && this.f10440b == textFieldCoreModifier.f10440b && Intrinsics.areEqual(this.f10441c, textFieldCoreModifier.f10441c) && Intrinsics.areEqual(this.f10442d, textFieldCoreModifier.f10442d) && Intrinsics.areEqual(this.f10443f, textFieldCoreModifier.f10443f) && Intrinsics.areEqual(this.f10444g, textFieldCoreModifier.f10444g) && this.f10445h == textFieldCoreModifier.f10445h && Intrinsics.areEqual(this.f10446i, textFieldCoreModifier.f10446i) && this.f10447j == textFieldCoreModifier.f10447j;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.f10439a) * 31) + Boolean.hashCode(this.f10440b)) * 31) + this.f10441c.hashCode()) * 31) + this.f10442d.hashCode()) * 31) + this.f10443f.hashCode()) * 31) + this.f10444g.hashCode()) * 31) + Boolean.hashCode(this.f10445h)) * 31) + this.f10446i.hashCode()) * 31) + this.f10447j.hashCode();
    }

    public String toString() {
        return "TextFieldCoreModifier(isFocused=" + this.f10439a + ", isDragHovered=" + this.f10440b + ", textLayoutState=" + this.f10441c + ", textFieldState=" + this.f10442d + ", textFieldSelectionState=" + this.f10443f + ", cursorBrush=" + this.f10444g + ", writeable=" + this.f10445h + ", scrollState=" + this.f10446i + ", orientation=" + this.f10447j + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
