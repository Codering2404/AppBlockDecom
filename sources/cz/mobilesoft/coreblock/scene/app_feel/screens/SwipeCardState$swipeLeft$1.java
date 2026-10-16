package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState$swipeLeft$1", f = "AppFeelLabelingScreen.kt", l = {731}, m = "invokeSuspend", v = 1)
final class SwipeCardState$swipeLeft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f98745c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SwipeCardState$swipeLeft$1(SwipeCardState swipeCardState, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f98744b = swipeCardState;
        this.f98745c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SwipeCardState$swipeLeft$1(this.f98744b, this.f98745c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SwipeCardState$swipeLeft$1 swipeCardState$swipeLeft$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98743a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatableB = this.f98744b.b();
            Float fC = Boxing.c((-this.f98744b.c()) * 1.5f);
            SpringSpec springSpecE = this.f98744b.e();
            this.f98743a = 1;
            swipeCardState$swipeLeft$1 = this;
            if (Animatable.f(animatableB, fC, springSpecE, null, null, swipeCardState$swipeLeft$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            swipeCardState$swipeLeft$1 = this;
        }
        swipeCardState$swipeLeft$1.f98745c.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SwipeCardState$swipeLeft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
