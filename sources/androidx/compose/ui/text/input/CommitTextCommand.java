package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class CommitTextCommand implements EditCommand {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f29305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29306b;

    public CommitTextCommand(AnnotatedString annotatedString, int i3) {
        this.f29305a = annotatedString;
        this.f29306b = i3;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void a(EditingBuffer editingBuffer) {
        if (editingBuffer.l()) {
            editingBuffer.m(editingBuffer.f(), editingBuffer.e(), c());
        } else {
            editingBuffer.m(editingBuffer.k(), editingBuffer.j(), c());
        }
        int iG = editingBuffer.g();
        int i3 = this.f29306b;
        editingBuffer.o(RangesKt.p(i3 > 0 ? (iG + i3) - 1 : (iG + i3) - c().length(), 0, editingBuffer.h()));
    }

    public final int b() {
        return this.f29306b;
    }

    public final String c() {
        return this.f29305a.k();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitTextCommand)) {
            return false;
        }
        CommitTextCommand commitTextCommand = (CommitTextCommand) obj;
        return Intrinsics.areEqual(c(), commitTextCommand.c()) && this.f29306b == commitTextCommand.f29306b;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.f29306b;
    }

    public String toString() {
        return "CommitTextCommand(text='" + c() + "', newCursorPosition=" + this.f29306b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommitTextCommand(String str, int i3) {
        this(new AnnotatedString(str, null, 2, 0 == true ? 1 : 0), i3);
    }
}
