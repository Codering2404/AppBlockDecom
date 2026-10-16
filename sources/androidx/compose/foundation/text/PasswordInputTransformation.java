package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class PasswordInputTransformation implements InputTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f9864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableIntState f9865c = SnapshotIntStateKt.a(-1);

    public PasswordInputTransformation(Function0 function0) {
        this.f9864b = function0;
    }

    private final void c(int i3) {
        this.f9865c.a(i3);
    }

    @Override // androidx.compose.foundation.text.input.InputTransformation
    public void O(TextFieldBuffer textFieldBuffer) {
        if (textFieldBuffer.f().b() != 1 || TextRange.j(textFieldBuffer.f().c(0)) != 1 || TextRange.j(textFieldBuffer.f().a(0)) != 0 || textFieldBuffer.n()) {
            c(-1);
            return;
        }
        int iL = TextRange.l(textFieldBuffer.f().c(0));
        if (a() != iL) {
            this.f9864b.invoke();
            c(iL);
        }
    }

    public final int a() {
        return this.f9865c.g();
    }

    public final void b() {
        c(-1);
    }
}
