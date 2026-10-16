package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableFloatState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$SmoothSnapSlider$3$1", f = "InsightsScreenComponents.kt", l = {1723}, m = "invokeSuspend", v = 1)
final class InsightsScreenComponentsKt$SmoothSnapSlider$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Integer f102622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f102623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f102624d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsScreenComponentsKt$SmoothSnapSlider$3$1(Integer num, Animatable animatable, MutableFloatState mutableFloatState, Continuation continuation) {
        super(2, continuation);
        this.f102622b = num;
        this.f102623c = animatable;
        this.f102624d = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InsightsScreenComponentsKt$SmoothSnapSlider$3$1(this.f102622b, this.f102623c, this.f102624d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102621a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f102622b != null) {
                Animatable animatable = this.f102623c;
                Float fC = Boxing.c(r4.intValue());
                this.f102621a = 1;
                if (animatable.u(fC, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        InsightsScreenComponentsKt.n2(this.f102624d, this.f102622b.intValue());
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InsightsScreenComponentsKt$SmoothSnapSlider$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
