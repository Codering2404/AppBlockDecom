package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$SwipeCard$3$1$3$1", f = "AppFeelLabelingScreen.kt", l = {602}, m = "invokeSuspend", v = 1)
final class AppFeelLabelingScreenKt$SwipeCard$3$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f98715c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelLabelingScreenKt$SwipeCard$3$1$3$1(SwipeCardState swipeCardState, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f98714b = swipeCardState;
        this.f98715c = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelLabelingScreenKt$SwipeCard$3$1$3$1(this.f98714b, this.f98715c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AppFeelLabelingScreenKt$SwipeCard$3$1$3$1 appFeelLabelingScreenKt$SwipeCard$3$1$3$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98713a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatableB = this.f98714b.b();
            Float fC = Boxing.c(0.0f);
            SpringSpec springSpecL = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            this.f98713a = 1;
            appFeelLabelingScreenKt$SwipeCard$3$1$3$1 = this;
            if (Animatable.f(animatableB, fC, springSpecL, null, null, appFeelLabelingScreenKt$SwipeCard$3$1$3$1, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            appFeelLabelingScreenKt$SwipeCard$3$1$3$1 = this;
        }
        appFeelLabelingScreenKt$SwipeCard$3$1$3$1.f98715c.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppFeelLabelingScreenKt$SwipeCard$3$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
