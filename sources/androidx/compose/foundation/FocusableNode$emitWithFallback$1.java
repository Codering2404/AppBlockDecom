package androidx.compose.foundation;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;

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
@DebugMetadata(c = "androidx.compose.foundation.FocusableNode$emitWithFallback$1", f = "Focusable.kt", l = {314}, m = "invokeSuspend")
final class FocusableNode$emitWithFallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f4932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Interaction f4933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DisposableHandle f4934d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusableNode$emitWithFallback$1(MutableInteractionSource mutableInteractionSource, Interaction interaction, DisposableHandle disposableHandle, Continuation continuation) {
        super(2, continuation);
        this.f4932b = mutableInteractionSource;
        this.f4933c = interaction;
        this.f4934d = disposableHandle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FocusableNode$emitWithFallback$1(this.f4932b, this.f4933c, this.f4934d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4931a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableInteractionSource mutableInteractionSource = this.f4932b;
            Interaction interaction = this.f4933c;
            this.f4931a = 1;
            if (mutableInteractionSource.a(interaction, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        DisposableHandle disposableHandle = this.f4934d;
        if (disposableHandle != null) {
            disposableHandle.dispose();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((FocusableNode$emitWithFallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
