package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class SetSelectionCommand implements EditCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29418b;

    public SetSelectionCommand(int i3, int i4) {
        this.f29417a = i3;
        this.f29418b = i4;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        int iP = RangesKt.p(this.f29417a, 0, editingBuffer.h());
        int iP2 = RangesKt.p(this.f29418b, 0, editingBuffer.h());
        if (iP < iP2) {
            editingBuffer.p(iP, iP2);
        } else {
            editingBuffer.p(iP2, iP);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetSelectionCommand)) {
            return false;
        }
        SetSelectionCommand setSelectionCommand = (SetSelectionCommand) obj;
        return this.f29417a == setSelectionCommand.f29417a && this.f29418b == setSelectionCommand.f29418b;
    }

    public int hashCode() {
        return (this.f29417a * 31) + this.f29418b;
    }

    public String toString() {
        return "SetSelectionCommand(start=" + this.f29417a + ", end=" + this.f29418b + ')';
    }
}
