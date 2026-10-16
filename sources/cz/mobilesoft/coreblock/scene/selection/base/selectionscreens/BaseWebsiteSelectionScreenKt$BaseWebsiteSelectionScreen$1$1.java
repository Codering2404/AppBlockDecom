package cz.mobilesoft.coreblock.scene.selection.base.selectionscreens;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.TextRangeKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.selectionscreens.BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1", f = "BaseWebsiteSelectionScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f118751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FocusRequester f118752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f118753d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1(MutableState mutableState, FocusRequester focusRequester, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f118751b = mutableState;
        this.f118752c = focusRequester;
        this.f118753d = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1(this.f118751b, this.f118752c, this.f118753d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f118750a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (((Boolean) this.f118751b.getValue()).booleanValue()) {
            MutableState mutableState = this.f118753d;
            BaseWebsiteSelectionScreenKt.y(mutableState, TextFieldValue.d(BaseWebsiteSelectionScreenKt.q(mutableState), null, TextRangeKt.a(BaseWebsiteSelectionScreenKt.q(this.f118753d).i().length()), null, 5, null));
            FocusRequester.h(this.f118752c, 0, 1, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseWebsiteSelectionScreenKt$BaseWebsiteSelectionScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
