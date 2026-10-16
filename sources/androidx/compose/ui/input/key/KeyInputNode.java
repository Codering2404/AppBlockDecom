package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier;
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
final class KeyInputNode extends Modifier.Node implements KeyInputModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Function1 f26738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function1 f26739b;

    public KeyInputNode(Function1 function1, Function1 function12) {
        this.f26738a = function1;
        this.f26739b = function12;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean R0(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.f26739b;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.a(keyEvent))).booleanValue();
        }
        return false;
    }

    public final void m2(Function1 function1) {
        this.f26738a = function1;
    }

    public final void n2(Function1 function1) {
        this.f26739b = function1;
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    public boolean o1(android.view.KeyEvent keyEvent) {
        Function1 function1 = this.f26738a;
        if (function1 != null) {
            return ((Boolean) function1.invoke(KeyEvent.a(keyEvent))).booleanValue();
        }
        return false;
    }
}
