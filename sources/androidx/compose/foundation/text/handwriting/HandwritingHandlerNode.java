package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager;
import androidx.compose.foundation.text.input.internal.ComposeInputMethodManager_androidKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
final class HandwritingHandlerNode extends Modifier.Node implements FocusEventModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private FocusState f10102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f10103b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<ComposeInputMethodManager>() { // from class: androidx.compose.foundation.text.handwriting.HandwritingHandlerNode$composeImm$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ComposeInputMethodManager invoke() {
            return ComposeInputMethodManager_androidKt.a(DelegatableNode_androidKt.a(this.f10104a));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ComposeInputMethodManager n2() {
        return (ComposeInputMethodManager) this.f10103b.getValue();
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        if (Intrinsics.areEqual(this.f10102a, focusState)) {
            return;
        }
        this.f10102a = focusState;
        if (focusState.b()) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new HandwritingHandlerNode$onFocusEvent$1(this, null), 3, null);
        }
    }
}
