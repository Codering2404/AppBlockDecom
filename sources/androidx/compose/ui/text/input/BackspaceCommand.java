package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BackspaceCommand implements EditCommand {
    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        if (editingBuffer.l()) {
            editingBuffer.b(editingBuffer.f(), editingBuffer.e());
            return;
        }
        if (editingBuffer.g() != -1) {
            if (editingBuffer.g() == 0) {
                return;
            }
            editingBuffer.b(JvmCharHelpers_androidKt.b(editingBuffer.toString(), editingBuffer.g()), editingBuffer.g());
        } else {
            int iK = editingBuffer.k();
            int iJ = editingBuffer.j();
            editingBuffer.o(editingBuffer.k());
            editingBuffer.b(iK, iJ);
        }
    }

    public boolean equals(Object obj) {
        return obj instanceof BackspaceCommand;
    }

    public int hashCode() {
        return Reflection.b(BackspaceCommand.class).hashCode();
    }

    public String toString() {
        return "BackspaceCommand()";
    }
}
