package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextFieldDecoratorModifierNode$keyboardActionScope$1 implements KeyboardActionScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextFieldDecoratorModifierNode f10556a;

    TextFieldDecoratorModifierNode$keyboardActionScope$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        this.f10556a = textFieldDecoratorModifierNode;
    }

    private final FocusManager b() {
        return (FocusManager) CompositionLocalConsumerModifierNodeKt.a(this.f10556a, CompositionLocalsKt.g());
    }

    public void a(int i3) {
        ImeAction.Companion companion = ImeAction.f29348b;
        if (ImeAction.m(i3, companion.d())) {
            b().e(FocusDirection.f25444b.e());
        } else if (ImeAction.m(i3, companion.f())) {
            b().e(FocusDirection.f25444b.f());
        } else if (ImeAction.m(i3, companion.b())) {
            this.f10556a.U2().a();
        }
    }
}
