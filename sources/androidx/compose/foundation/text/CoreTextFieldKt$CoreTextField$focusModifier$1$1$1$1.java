package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1", f = "CoreTextField.kt", l = {330}, m = "invokeSuspend")
final class CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BringIntoViewRequester f9645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TextFieldValue f9646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LegacyTextFieldState f9647d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TextLayoutResultProxy f9648f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ OffsetMapping f9649g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, LegacyTextFieldState legacyTextFieldState, TextLayoutResultProxy textLayoutResultProxy, OffsetMapping offsetMapping, Continuation continuation) {
        super(2, continuation);
        this.f9645b = bringIntoViewRequester;
        this.f9646c = textFieldValue;
        this.f9647d = legacyTextFieldState;
        this.f9648f = textLayoutResultProxy;
        this.f9649g = offsetMapping;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(this.f9645b, this.f9646c, this.f9647d, this.f9648f, this.f9649g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f9644a;
        if (i3 == 0) {
            ResultKt.b(obj);
            BringIntoViewRequester bringIntoViewRequester = this.f9645b;
            TextFieldValue textFieldValue = this.f9646c;
            TextDelegate textDelegateX = this.f9647d.x();
            TextLayoutResult textLayoutResultF = this.f9648f.f();
            OffsetMapping offsetMapping = this.f9649g;
            this.f9644a = 1;
            if (CoreTextFieldKt.l(bringIntoViewRequester, textFieldValue, textDelegateX, textLayoutResultF, offsetMapping, this) == objF) {
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
        return ((CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
