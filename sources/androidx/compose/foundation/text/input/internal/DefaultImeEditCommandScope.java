package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.collection.MutableVector;
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
public final class DefaultImeEditCommandScope implements ImeEditCommandScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformedTextFieldState f10318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableVector f10320c = new MutableVector(new Function1[16], 0);

    public DefaultImeEditCommandScope(TransformedTextFieldState transformedTextFieldState) {
        this.f10318a = transformedTextFieldState;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public void b(Function1 function1) {
        beginBatchEdit();
        this.f10320c.b(function1);
        endBatchEdit();
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean beginBatchEdit() {
        this.f10319b++;
        return true;
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public long d(long j3) {
        return this.f10318a.s(j3);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public long e(long j3) {
        return this.f10318a.r(j3);
    }

    @Override // androidx.compose.foundation.text.input.internal.ImeEditCommandScope
    public boolean endBatchEdit() {
        int i3 = this.f10319b - 1;
        this.f10319b = i3;
        if (i3 == 0 && this.f10320c.o() != 0) {
            TransformedTextFieldState transformedTextFieldState = this.f10318a;
            TextFieldState textFieldState = transformedTextFieldState.f10664a;
            InputTransformation inputTransformation = transformedTextFieldState.f10665b;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.f10976a;
            textFieldState.f().e().e();
            TextFieldBuffer textFieldBufferF = textFieldState.f();
            MutableVector mutableVector = this.f10320c;
            Object[] objArr = mutableVector.f24389a;
            int iO = mutableVector.o();
            for (int i4 = 0; i4 < iO; i4++) {
                ((Function1) objArr[i4]).invoke(textFieldBufferF);
            }
            transformedTextFieldState.G(textFieldBufferF);
            textFieldState.d(inputTransformation, false, textFieldEditUndoBehavior);
            this.f10320c.i();
        }
        return this.f10319b > 0;
    }
}
