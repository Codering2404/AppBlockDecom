package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
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
public final class CoreTextFieldSemanticsModifier extends ModifierNodeElement<CoreTextFieldSemanticsModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedText f10255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextFieldValue f10256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LegacyTextFieldState f10257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f10258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f10259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f10260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OffsetMapping f10261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextFieldSelectionManager f10262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImeOptions f10263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final FocusRequester f10264k;

    public CoreTextFieldSemanticsModifier(TransformedText transformedText, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, boolean z2, boolean z3, boolean z4, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, ImeOptions imeOptions, FocusRequester focusRequester) {
        this.f10255a = transformedText;
        this.f10256b = textFieldValue;
        this.f10257c = legacyTextFieldState;
        this.f10258d = z2;
        this.f10259f = z3;
        this.f10260g = z4;
        this.f10261h = offsetMapping;
        this.f10262i = textFieldSelectionManager;
        this.f10263j = imeOptions;
        this.f10264k = focusRequester;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoreTextFieldSemanticsModifierNode create() {
        return new CoreTextFieldSemanticsModifierNode(this.f10255a, this.f10256b, this.f10257c, this.f10258d, this.f10259f, this.f10260g, this.f10261h, this.f10262i, this.f10263j, this.f10264k);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode) {
        coreTextFieldSemanticsModifierNode.B2(this.f10255a, this.f10256b, this.f10257c, this.f10258d, this.f10259f, this.f10260g, this.f10261h, this.f10262i, this.f10263j, this.f10264k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoreTextFieldSemanticsModifier)) {
            return false;
        }
        CoreTextFieldSemanticsModifier coreTextFieldSemanticsModifier = (CoreTextFieldSemanticsModifier) obj;
        return Intrinsics.areEqual(this.f10255a, coreTextFieldSemanticsModifier.f10255a) && Intrinsics.areEqual(this.f10256b, coreTextFieldSemanticsModifier.f10256b) && Intrinsics.areEqual(this.f10257c, coreTextFieldSemanticsModifier.f10257c) && this.f10258d == coreTextFieldSemanticsModifier.f10258d && this.f10259f == coreTextFieldSemanticsModifier.f10259f && this.f10260g == coreTextFieldSemanticsModifier.f10260g && Intrinsics.areEqual(this.f10261h, coreTextFieldSemanticsModifier.f10261h) && Intrinsics.areEqual(this.f10262i, coreTextFieldSemanticsModifier.f10262i) && Intrinsics.areEqual(this.f10263j, coreTextFieldSemanticsModifier.f10263j) && Intrinsics.areEqual(this.f10264k, coreTextFieldSemanticsModifier.f10264k);
    }

    public int hashCode() {
        return (((((((((((((((((this.f10255a.hashCode() * 31) + this.f10256b.hashCode()) * 31) + this.f10257c.hashCode()) * 31) + Boolean.hashCode(this.f10258d)) * 31) + Boolean.hashCode(this.f10259f)) * 31) + Boolean.hashCode(this.f10260g)) * 31) + this.f10261h.hashCode()) * 31) + this.f10262i.hashCode()) * 31) + this.f10263j.hashCode()) * 31) + this.f10264k.hashCode();
    }

    public String toString() {
        return "CoreTextFieldSemanticsModifier(transformedText=" + this.f10255a + ", value=" + this.f10256b + ", state=" + this.f10257c + ", readOnly=" + this.f10258d + ", enabled=" + this.f10259f + ", isPassword=" + this.f10260g + ", offsetMapping=" + this.f10261h + ", manager=" + this.f10262i + ", imeOptions=" + this.f10263j + ", focusRequester=" + this.f10264k + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
