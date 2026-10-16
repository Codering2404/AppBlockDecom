package androidx.compose.ui.input.key;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class KeyInputElement extends ModifierNodeElement<KeyInputNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f26736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f26737b;

    public KeyInputElement(Function1 function1, Function1 function12) {
        this.f26736a = function1;
        this.f26737b = function12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public KeyInputNode create() {
        return new KeyInputNode(this.f26736a, this.f26737b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(KeyInputNode keyInputNode) {
        keyInputNode.m2(this.f26736a);
        keyInputNode.n2(this.f26737b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyInputElement)) {
            return false;
        }
        KeyInputElement keyInputElement = (KeyInputElement) obj;
        return this.f26736a == keyInputElement.f26736a && this.f26737b == keyInputElement.f26737b;
    }

    public int hashCode() {
        Function1 function1 = this.f26736a;
        int iHashCode = (function1 != null ? function1.hashCode() : 0) * 31;
        Function1 function12 = this.f26737b;
        return iHashCode + (function12 != null ? function12.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Function1 function1 = this.f26736a;
        if (function1 != null) {
            inspectorInfo.d("onKeyEvent");
            inspectorInfo.b().c("onKeyEvent", function1);
        }
        Function1 function12 = this.f26737b;
        if (function12 != null) {
            inspectorInfo.d("onPreviewKeyEvent");
            inspectorInfo.b().c("onPreviewKeyEvent", function12);
        }
    }
}
