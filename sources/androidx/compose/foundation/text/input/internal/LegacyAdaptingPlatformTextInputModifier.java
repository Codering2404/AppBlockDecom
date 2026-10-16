package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
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
final class LegacyAdaptingPlatformTextInputModifier extends ModifierNodeElement<LegacyAdaptingPlatformTextInputModifierNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LegacyPlatformTextInputServiceAdapter f10360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LegacyTextFieldState f10361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextFieldSelectionManager f10362c;

    public LegacyAdaptingPlatformTextInputModifier(LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter, LegacyTextFieldState legacyTextFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        this.f10360a = legacyPlatformTextInputServiceAdapter;
        this.f10361b = legacyTextFieldState;
        this.f10362c = textFieldSelectionManager;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LegacyAdaptingPlatformTextInputModifierNode create() {
        return new LegacyAdaptingPlatformTextInputModifierNode(this.f10360a, this.f10361b, this.f10362c);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode) {
        legacyAdaptingPlatformTextInputModifierNode.o2(this.f10360a);
        legacyAdaptingPlatformTextInputModifierNode.n2(this.f10361b);
        legacyAdaptingPlatformTextInputModifierNode.p2(this.f10362c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LegacyAdaptingPlatformTextInputModifier)) {
            return false;
        }
        LegacyAdaptingPlatformTextInputModifier legacyAdaptingPlatformTextInputModifier = (LegacyAdaptingPlatformTextInputModifier) obj;
        return Intrinsics.areEqual(this.f10360a, legacyAdaptingPlatformTextInputModifier.f10360a) && Intrinsics.areEqual(this.f10361b, legacyAdaptingPlatformTextInputModifier.f10361b) && Intrinsics.areEqual(this.f10362c, legacyAdaptingPlatformTextInputModifier.f10362c);
    }

    public int hashCode() {
        return (((this.f10360a.hashCode() * 31) + this.f10361b.hashCode()) * 31) + this.f10362c.hashCode();
    }

    public String toString() {
        return "LegacyAdaptingPlatformTextInputModifier(serviceAdapter=" + this.f10360a + ", legacyTextFieldState=" + this.f10361b + ", textFieldSelectionManager=" + this.f10362c + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
    }
}
