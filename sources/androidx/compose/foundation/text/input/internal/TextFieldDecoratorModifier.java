package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class TextFieldDecoratorModifier extends ModifierNodeElement<TextFieldDecoratorModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedTextFieldState f10483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextLayoutState f10484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextFieldSelectionState f10485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputTransformation f10486d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f10487f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f10488g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final KeyboardOptions f10489h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final KeyboardActionHandler f10490i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f10491j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableInteractionSource f10492k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f10493l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableSharedFlow f10494m;

    public TextFieldDecoratorModifier(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z2, boolean z3, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z4, MutableInteractionSource mutableInteractionSource, boolean z5, MutableSharedFlow mutableSharedFlow) {
        this.f10483a = transformedTextFieldState;
        this.f10484b = textLayoutState;
        this.f10485c = textFieldSelectionState;
        this.f10486d = inputTransformation;
        this.f10487f = z2;
        this.f10488g = z3;
        this.f10489h = keyboardOptions;
        this.f10490i = keyboardActionHandler;
        this.f10491j = z4;
        this.f10492k = mutableInteractionSource;
        this.f10493l = z5;
        this.f10494m = mutableSharedFlow;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public TextFieldDecoratorModifierNode create() {
        return new TextFieldDecoratorModifierNode(this.f10483a, this.f10484b, this.f10485c, this.f10486d, this.f10487f, this.f10488g, this.f10489h, this.f10490i, this.f10491j, this.f10492k, this.f10493l, this.f10494m);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        textFieldDecoratorModifierNode.X2(this.f10483a, this.f10484b, this.f10485c, this.f10486d, this.f10487f, this.f10488g, this.f10489h, this.f10490i, this.f10491j, this.f10492k, this.f10493l, this.f10494m);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldDecoratorModifier)) {
            return false;
        }
        TextFieldDecoratorModifier textFieldDecoratorModifier = (TextFieldDecoratorModifier) obj;
        return Intrinsics.areEqual(this.f10483a, textFieldDecoratorModifier.f10483a) && Intrinsics.areEqual(this.f10484b, textFieldDecoratorModifier.f10484b) && Intrinsics.areEqual(this.f10485c, textFieldDecoratorModifier.f10485c) && Intrinsics.areEqual(this.f10486d, textFieldDecoratorModifier.f10486d) && this.f10487f == textFieldDecoratorModifier.f10487f && this.f10488g == textFieldDecoratorModifier.f10488g && Intrinsics.areEqual(this.f10489h, textFieldDecoratorModifier.f10489h) && Intrinsics.areEqual(this.f10490i, textFieldDecoratorModifier.f10490i) && this.f10491j == textFieldDecoratorModifier.f10491j && Intrinsics.areEqual(this.f10492k, textFieldDecoratorModifier.f10492k) && this.f10493l == textFieldDecoratorModifier.f10493l && Intrinsics.areEqual(this.f10494m, textFieldDecoratorModifier.f10494m);
    }

    public int hashCode() {
        int iHashCode = ((((this.f10483a.hashCode() * 31) + this.f10484b.hashCode()) * 31) + this.f10485c.hashCode()) * 31;
        InputTransformation inputTransformation = this.f10486d;
        int iHashCode2 = (((((((iHashCode + (inputTransformation == null ? 0 : inputTransformation.hashCode())) * 31) + Boolean.hashCode(this.f10487f)) * 31) + Boolean.hashCode(this.f10488g)) * 31) + this.f10489h.hashCode()) * 31;
        KeyboardActionHandler keyboardActionHandler = this.f10490i;
        int iHashCode3 = (((((((iHashCode2 + (keyboardActionHandler == null ? 0 : keyboardActionHandler.hashCode())) * 31) + Boolean.hashCode(this.f10491j)) * 31) + this.f10492k.hashCode()) * 31) + Boolean.hashCode(this.f10493l)) * 31;
        MutableSharedFlow mutableSharedFlow = this.f10494m;
        return iHashCode3 + (mutableSharedFlow != null ? mutableSharedFlow.hashCode() : 0);
    }

    public String toString() {
        return "TextFieldDecoratorModifier(textFieldState=" + this.f10483a + ", textLayoutState=" + this.f10484b + ", textFieldSelectionState=" + this.f10485c + ", filter=" + this.f10486d + ", enabled=" + this.f10487f + ", readOnly=" + this.f10488g + ", keyboardOptions=" + this.f10489h + ", keyboardActionHandler=" + this.f10490i + ", singleLine=" + this.f10491j + ", interactionSource=" + this.f10492k + ", isPassword=" + this.f10493l + ", stylusHandwritingTrigger=" + this.f10494m + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
