package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2", f = "TextFieldSelectionState.kt", l = {489}, m = "invokeSuspend")
final class TextFieldSelectionState$detectTextFieldTapGestures$2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ long f10872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f10873d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionState f10874f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectTextFieldTapGestures$2(MutableInteractionSource mutableInteractionSource, TextFieldSelectionState textFieldSelectionState, Continuation continuation) {
        super(3, continuation);
        this.f10873d = mutableInteractionSource;
        this.f10874f = textFieldSelectionState;
    }

    public final Object h(PressGestureScope pressGestureScope, long j3, Continuation continuation) {
        TextFieldSelectionState$detectTextFieldTapGestures$2 textFieldSelectionState$detectTextFieldTapGestures$2 = new TextFieldSelectionState$detectTextFieldTapGestures$2(this.f10873d, this.f10874f, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$2.f10871b = pressGestureScope;
        textFieldSelectionState$detectTextFieldTapGestures$2.f10872c = j3;
        return textFieldSelectionState$detectTextFieldTapGestures$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((PressGestureScope) obj, ((Offset) obj2).u(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10870a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PressGestureScope pressGestureScope = (PressGestureScope) this.f10871b;
            long j3 = this.f10872c;
            MutableInteractionSource mutableInteractionSource = this.f10873d;
            if (mutableInteractionSource != null) {
                TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(pressGestureScope, this.f10874f, j3, mutableInteractionSource, null);
                this.f10870a = 1;
                if (CoroutineScopeKt.f(textFieldSelectionState$detectTextFieldTapGestures$2$1$1, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
