package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldTextLayoutModifier extends ModifierNodeElement<TextFieldTextLayoutModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextLayoutState f10644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TransformedTextFieldState f10645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextStyle f10646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f10647d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function2 f10648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final KeyboardOptions f10649g;

    public TextFieldTextLayoutModifier(TextLayoutState textLayoutState, TransformedTextFieldState transformedTextFieldState, TextStyle textStyle, boolean z2, Function2 function2, KeyboardOptions keyboardOptions) {
        this.f10644a = textLayoutState;
        this.f10645b = transformedTextFieldState;
        this.f10646c = textStyle;
        this.f10647d = z2;
        this.f10648f = function2;
        this.f10649g = keyboardOptions;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextFieldTextLayoutModifierNode create() {
        return new TextFieldTextLayoutModifierNode(this.f10644a, this.f10645b, this.f10646c, this.f10647d, this.f10648f, this.f10649g);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TextFieldTextLayoutModifierNode textFieldTextLayoutModifierNode) {
        textFieldTextLayoutModifierNode.m2(this.f10644a, this.f10645b, this.f10646c, this.f10647d, this.f10648f, this.f10649g);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldTextLayoutModifier)) {
            return false;
        }
        TextFieldTextLayoutModifier textFieldTextLayoutModifier = (TextFieldTextLayoutModifier) obj;
        return Intrinsics.areEqual(this.f10644a, textFieldTextLayoutModifier.f10644a) && Intrinsics.areEqual(this.f10645b, textFieldTextLayoutModifier.f10645b) && Intrinsics.areEqual(this.f10646c, textFieldTextLayoutModifier.f10646c) && this.f10647d == textFieldTextLayoutModifier.f10647d && Intrinsics.areEqual(this.f10648f, textFieldTextLayoutModifier.f10648f) && Intrinsics.areEqual(this.f10649g, textFieldTextLayoutModifier.f10649g);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f10644a.hashCode() * 31) + this.f10645b.hashCode()) * 31) + this.f10646c.hashCode()) * 31) + Boolean.hashCode(this.f10647d)) * 31;
        Function2 function2 = this.f10648f;
        return ((iHashCode + (function2 == null ? 0 : function2.hashCode())) * 31) + this.f10649g.hashCode();
    }

    public String toString() {
        return "TextFieldTextLayoutModifier(textLayoutState=" + this.f10644a + ", textFieldState=" + this.f10645b + ", textStyle=" + this.f10646c + ", singleLine=" + this.f10647d + ", onTextLayout=" + this.f10648f + ", keyboardOptions=" + this.f10649g + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
