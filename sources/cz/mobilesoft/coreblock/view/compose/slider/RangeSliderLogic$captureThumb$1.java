package cz.mobilesoft.coreblock.view.compose.slider;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.RangeSliderLogic$captureThumb$1", f = "StyledSlider.kt", l = {685}, m = "invokeSuspend", v = 1)
final class RangeSliderLogic$captureThumb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RangeSliderLogic f132035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f132036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Interaction f132037d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RangeSliderLogic$captureThumb$1(RangeSliderLogic rangeSliderLogic, boolean z2, Interaction interaction, Continuation continuation) {
        super(2, continuation);
        this.f132035b = rangeSliderLogic;
        this.f132036c = z2;
        this.f132037d = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RangeSliderLogic$captureThumb$1(this.f132035b, this.f132036c, this.f132037d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132034a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableInteractionSource mutableInteractionSourceA = this.f132035b.a(this.f132036c);
            Interaction interaction = this.f132037d;
            this.f132034a = 1;
            if (mutableInteractionSourceA.a(interaction, this) == objF) {
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
        return ((RangeSliderLogic$captureThumb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
