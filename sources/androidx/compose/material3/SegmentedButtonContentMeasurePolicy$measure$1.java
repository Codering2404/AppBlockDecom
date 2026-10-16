package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.SegmentedButtonContentMeasurePolicy$measure$1", f = "SegmentedButton.kt", l = {378}, m = "invokeSuspend")
final class SegmentedButtonContentMeasurePolicy$measure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f19713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f19714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f19715c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SegmentedButtonContentMeasurePolicy$measure$1(Animatable animatable, int i3, Continuation continuation) {
        super(2, continuation);
        this.f19714b = animatable;
        this.f19715c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SegmentedButtonContentMeasurePolicy$measure$1(this.f19714b, this.f19715c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f19713a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f19714b;
            Integer numD = Boxing.d(this.f19715c);
            TweenSpec tweenSpecN = AnimationSpecKt.n(350, 0, null, 6, null);
            this.f19713a = 1;
            if (Animatable.f(animatable, numD, tweenSpecN, null, null, this, 12, null) == objF) {
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
        return ((SegmentedButtonContentMeasurePolicy$measure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
