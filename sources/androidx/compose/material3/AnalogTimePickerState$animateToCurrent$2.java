package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2", f = "TimePicker.kt", l = {738}, m = "invokeSuspend")
final class AnalogTimePickerState$animateToCurrent$2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AnalogTimePickerState f15551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f15552c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnalogTimePickerState$animateToCurrent$2(AnalogTimePickerState analogTimePickerState, float f3, Continuation continuation) {
        super(1, continuation);
        this.f15551b = analogTimePickerState;
        this.f15552c = f3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AnalogTimePickerState$animateToCurrent$2(this.f15551b, this.f15552c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f15550a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Animatable animatable = this.f15551b.f15548d;
        Float fC = Boxing.c(this.f15552c);
        SpringSpec springSpecL = AnimationSpecKt.l(1.0f, 700.0f, null, 4, null);
        this.f15550a = 1;
        Object objF2 = Animatable.f(animatable, fC, springSpecL, null, null, this, 12, null);
        return objF2 == objF ? objF : objF2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AnalogTimePickerState$animateToCurrent$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
