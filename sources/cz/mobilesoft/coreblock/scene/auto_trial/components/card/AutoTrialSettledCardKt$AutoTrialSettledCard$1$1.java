package cz.mobilesoft.coreblock.scene.auto_trial.components.card;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialSettledCardKt$AutoTrialSettledCard$1$1", f = "AutoTrialSettledCard.kt", l = {37}, m = "invokeSuspend", v = 1)
final class AutoTrialSettledCardKt$AutoTrialSettledCard$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f98940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f98941b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AutoTrialSettledCardKt$AutoTrialSettledCard$1$1(Animatable animatable, Continuation continuation) {
        super(2, continuation);
        this.f98941b = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AutoTrialSettledCardKt$AutoTrialSettledCard$1$1(this.f98941b, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AutoTrialSettledCardKt$AutoTrialSettledCard$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f98940a;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException(KrzujOtzIk.jixDPg);
            }
        } else {
            ResultKt.b(obj);
            Animatable animatable = this.f98941b;
            Float fC = Boxing.c(1.0f);
            TweenSpec tweenSpecN = AnimationSpecKt.n(525, 0, EasingKt.d(), 2, null);
            this.f98940a = 1;
            if (Animatable.f(animatable, fC, tweenSpecN, null, null, this, 12, null) == objF) {
                return objF;
            }
        }
        return Unit.f139807a;
    }
}
