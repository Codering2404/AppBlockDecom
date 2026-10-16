package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

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
public final class DeleteSurroundingTextCommand implements EditCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29330b;

    public DeleteSurroundingTextCommand(int i3, int i4) {
        this.f29329a = i3;
        this.f29330b = i4;
        if (i3 >= 0 && i4 >= 0) {
            return;
        }
        InlineClassHelperKt.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i4 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        int iJ = editingBuffer.j();
        int i3 = this.f29330b;
        int iH = iJ + i3;
        if (((iJ ^ iH) & (i3 ^ iH)) < 0) {
            iH = editingBuffer.h();
        }
        editingBuffer.b(editingBuffer.j(), Math.min(iH, editingBuffer.h()));
        int iK = editingBuffer.k();
        int i4 = this.f29329a;
        int i5 = iK - i4;
        if (((iK ^ i5) & (i4 ^ iK)) < 0) {
            i5 = 0;
        }
        editingBuffer.b(Math.max(0, i5), editingBuffer.k());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextCommand)) {
            return false;
        }
        DeleteSurroundingTextCommand deleteSurroundingTextCommand = (DeleteSurroundingTextCommand) obj;
        return this.f29329a == deleteSurroundingTextCommand.f29329a && this.f29330b == deleteSurroundingTextCommand.f29330b;
    }

    public int hashCode() {
        return (this.f29329a * 31) + this.f29330b;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.f29329a + ", lengthAfterCursor=" + this.f29330b + ')';
    }
}
