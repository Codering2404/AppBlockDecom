package cz.mobilesoft.coreblock.util.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.KeyframesSpec;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.compose.ComposableExtKt$shake$1$1$1", f = "ComposableExt.kt", l = {122}, m = "invokeSuspend", v = 1)
final class ComposableExtKt$shake$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f128221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f128222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Animatable f128223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ KeyframesSpec f128224d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposableExtKt$shake$1$1$1(boolean z2, Animatable animatable, KeyframesSpec keyframesSpec, Continuation continuation) {
        super(2, continuation);
        this.f128222b = z2;
        this.f128223c = animatable;
        this.f128224d = keyframesSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposableExtKt$shake$1$1$1(this.f128222b, this.f128223c, this.f128224d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f128221a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f128222b) {
                Animatable animatable = this.f128223c;
                Float fC = Boxing.c(0.0f);
                KeyframesSpec keyframesSpec = this.f128224d;
                this.f128221a = 1;
                if (Animatable.f(animatable, fC, keyframesSpec, null, null, this, 12, null) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposableExtKt$shake$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
