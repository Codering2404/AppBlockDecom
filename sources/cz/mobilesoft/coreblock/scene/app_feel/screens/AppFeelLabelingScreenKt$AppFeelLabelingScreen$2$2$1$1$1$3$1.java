package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.runtime.MutableIntState;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1", f = "AppFeelLabelingScreen.kt", l = {RCHTTPStatusCodes.BAD_REQUEST}, m = "invokeSuspend", v = 1)
final class AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SwipeCardState f98694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f98695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f98696d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableIntState f98697f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1(SwipeCardState swipeCardState, Function2 function2, Function0 function0, MutableIntState mutableIntState, Continuation continuation) {
        super(2, continuation);
        this.f98694b = swipeCardState;
        this.f98695c = function2;
        this.f98696d = function0;
        this.f98697f = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1(this.f98694b, this.f98695c, this.f98696d, this.f98697f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98693a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatableB = this.f98694b.b();
            Float fC = Boxing.c(0.0f);
            this.f98693a = 1;
            if (animatableB.u(fC, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f98695c.invoke(Boxing.d(AppFeelLabelingScreenKt.o0(this.f98697f)), AppDistractionType.Neutral);
        this.f98696d.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
