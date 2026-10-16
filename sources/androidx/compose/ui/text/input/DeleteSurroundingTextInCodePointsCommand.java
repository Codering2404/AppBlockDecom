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
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29332b;

    public DeleteSurroundingTextInCodePointsCommand(int i3, int i4) {
        this.f29331a = i3;
        this.f29332b = i4;
        if (i3 >= 0 && i4 >= 0) {
            return;
        }
        InlineClassHelperKt.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i3 + " and " + i4 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        int i3 = this.f29331a;
        int i4 = 0;
        int i5 = 0;
        int iK = 0;
        while (true) {
            if (i5 < i3) {
                int i6 = iK + 1;
                if (editingBuffer.k() <= i6) {
                    iK = editingBuffer.k();
                    break;
                } else {
                    iK = EditCommandKt.b(editingBuffer.c((editingBuffer.k() - i6) + (-1)), editingBuffer.c(editingBuffer.k() - i6)) ? iK + 2 : i6;
                    i5++;
                }
            } else {
                break;
            }
        }
        int i7 = this.f29332b;
        int iH = 0;
        while (true) {
            if (i4 >= i7) {
                break;
            }
            int i8 = iH + 1;
            if (editingBuffer.j() + i8 >= editingBuffer.h()) {
                iH = editingBuffer.h() - editingBuffer.j();
                break;
            } else {
                iH = EditCommandKt.b(editingBuffer.c((editingBuffer.j() + i8) + (-1)), editingBuffer.c(editingBuffer.j() + i8)) ? iH + 2 : i8;
                i4++;
            }
        }
        editingBuffer.b(editingBuffer.j(), editingBuffer.j() + iH);
        editingBuffer.b(editingBuffer.k() - iK, editingBuffer.k());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        return this.f29331a == deleteSurroundingTextInCodePointsCommand.f29331a && this.f29332b == deleteSurroundingTextInCodePointsCommand.f29332b;
    }

    public int hashCode() {
        return (this.f29331a * 31) + this.f29332b;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.f29331a + ", lengthAfterCursor=" + this.f29332b + ')';
    }
}
