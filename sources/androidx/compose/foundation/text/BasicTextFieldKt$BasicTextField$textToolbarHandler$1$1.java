package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

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
public final class BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 implements TextToolbarHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextToolbar f9292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f9293b;

    BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(TextToolbar textToolbar, CoroutineScope coroutineScope) {
        this.f9292a = textToolbar;
        this.f9293b = coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r17, androidx.compose.ui.geometry.Rect r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1.a(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.ui.geometry.Rect, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public void b() {
        if (this.f9292a.getStatus() == TextToolbarStatus.f28212a) {
            this.f9292a.a();
        }
    }
}
