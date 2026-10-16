package androidx.compose.ui.input.rotary;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class RotaryInputElement extends ModifierNodeElement<RotaryInputNode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f27001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f27002b;

    public RotaryInputElement(Function1 function1, Function1 function12) {
        this.f27001a = function1;
        this.f27002b = function12;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RotaryInputNode create() {
        return new RotaryInputNode(this.f27001a, this.f27002b);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(RotaryInputNode rotaryInputNode) {
        rotaryInputNode.m2(this.f27001a);
        rotaryInputNode.n2(this.f27002b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RotaryInputElement)) {
            return false;
        }
        RotaryInputElement rotaryInputElement = (RotaryInputElement) obj;
        return Intrinsics.areEqual(this.f27001a, rotaryInputElement.f27001a) && Intrinsics.areEqual(this.f27002b, rotaryInputElement.f27002b);
    }

    public int hashCode() {
        Function1 function1 = this.f27001a;
        int iHashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
        Function1 function12 = this.f27002b;
        return iHashCode + (function12 != null ? function12.hashCode() : 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Function1 function1 = this.f27001a;
        if (function1 != null) {
            inspectorInfo.d("onRotaryScrollEvent");
            inspectorInfo.b().c("onRotaryScrollEvent", function1);
        }
        Function1 function12 = this.f27002b;
        if (function12 != null) {
            inspectorInfo.d("onPreRotaryScrollEvent");
            inspectorInfo.b().c("onPreRotaryScrollEvent", function12);
        }
    }

    public String toString() {
        return "RotaryInputElement(onRotaryScrollEvent=" + this.f27001a + ", onPreRotaryScrollEvent=" + this.f27002b + ')';
    }
}
