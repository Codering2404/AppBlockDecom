package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$StyledSlider$3$drag$1$1", f = "StyledSlider.kt", l = {}, m = "invokeSuspend", v = 1)
final class StyledSliderKt$StyledSlider$3$drag$1$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ float f132064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ State f132065c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StyledSliderKt$StyledSlider$3$drag$1$1(State state, Continuation continuation) {
        super(3, continuation);
        this.f132065c = state;
    }

    public final Object h(CoroutineScope coroutineScope, float f3, Continuation continuation) {
        StyledSliderKt$StyledSlider$3$drag$1$1 styledSliderKt$StyledSlider$3$drag$1$1 = new StyledSliderKt$StyledSlider$3$drag$1$1(this.f132065c, continuation);
        styledSliderKt$StyledSlider$3$drag$1$1.f132064b = f3;
        return styledSliderKt$StyledSlider$3$drag$1$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        float f3 = this.f132064b;
        IntrinsicsKt.f();
        if (this.f132063a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        ((Function1) this.f132065c.getValue()).invoke(Boxing.c(f3));
        return Unit.f139807a;
    }
}
