package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
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
final class FocusChangedNode extends Modifier.Node implements FocusEventModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f25442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FocusState f25443b;

    public FocusChangedNode(Function1 function1) {
        this.f25442a = function1;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        if (Intrinsics.areEqual(this.f25443b, focusState)) {
            return;
        }
        this.f25443b = focusState;
        this.f25442a.invoke(focusState);
    }

    public final void m2(Function1 function1) {
        this.f25442a = function1;
    }
}
