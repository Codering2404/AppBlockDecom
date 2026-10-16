package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
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
public final class MoveCursorCommand implements EditCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29391a;

    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        if (editingBuffer.g() == -1) {
            editingBuffer.o(editingBuffer.k());
        }
        int iK = editingBuffer.k();
        String string = editingBuffer.toString();
        int i3 = this.f29391a;
        int i4 = 0;
        if (i3 <= 0) {
            int i5 = -i3;
            while (i4 < i5) {
                int iB = JvmCharHelpers_androidKt.b(string, iK);
                if (iB == -1) {
                    break;
                }
                i4++;
                iK = iB;
            }
        } else {
            while (i4 < i3) {
                int iA = JvmCharHelpers_androidKt.a(string, iK);
                if (iA == -1) {
                    break;
                }
                i4++;
                iK = iA;
            }
        }
        editingBuffer.o(iK);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MoveCursorCommand) && this.f29391a == ((MoveCursorCommand) obj).f29391a;
    }

    public int hashCode() {
        return this.f29391a;
    }

    public String toString() {
        return "MoveCursorCommand(amount=" + this.f29391a + ')';
    }
}
