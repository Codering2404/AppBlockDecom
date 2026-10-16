package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2", f = "TextFieldDecoratorModifier.kt", l = {220}, m = "invokeSuspend")
final class TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextFieldDecoratorModifierNode f10574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionState f10575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PointerInputScope f10576d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f10577f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f10574b = textFieldDecoratorModifierNode;
        this.f10575c = textFieldSelectionState;
        this.f10576d = pointerInputScope;
        this.f10577f = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(this.f10574b, this.f10575c, this.f10576d, this.f10577f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10573a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableInteractionSource mutableInteractionSourceI2 = this.f10574b.I2();
            TextFieldSelectionState textFieldSelectionState = this.f10575c;
            PointerInputScope pointerInputScope = this.f10576d;
            Function0 function0 = this.f10577f;
            final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.f10574b;
            Function0<Unit> function02 = new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m82invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m82invoke() {
                    if (textFieldDecoratorModifierNode.f10518y != null) {
                        textFieldDecoratorModifierNode.U2().show();
                    } else {
                        textFieldDecoratorModifierNode.W2(true);
                    }
                }
            };
            this.f10573a = 1;
            if (textFieldSelectionState.Q(pointerInputScope, mutableInteractionSourceI2, function0, function02, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
