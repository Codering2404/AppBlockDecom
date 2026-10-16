package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt$autoScroll$2", f = "SchedulesSection.kt", l = {277}, m = "invokeSuspend", v = 1)
final class SchedulesSectionKt$autoScroll$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f100013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f100014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f100015d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulesSectionKt$autoScroll$2(AnimationSpec animationSpec, Ref.FloatRef floatRef, Continuation continuation) {
        super(2, continuation);
        this.f100014c = animationSpec;
        this.f100015d = floatRef;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Ref.FloatRef floatRef, ScrollScope scrollScope, float f3, float f4) {
        float f5 = floatRef.f140141a;
        floatRef.f140141a = f5 + scrollScope.d(f3 - f5);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SchedulesSectionKt$autoScroll$2 schedulesSectionKt$autoScroll$2 = new SchedulesSectionKt$autoScroll$2(this.f100014c, this.f100015d, continuation);
        schedulesSectionKt$autoScroll$2.f100013b = obj;
        return schedulesSectionKt$autoScroll$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final ScrollScope scrollScope = (ScrollScope) this.f100013b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f100012a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnimationSpec animationSpec = this.f100014c;
            final Ref.FloatRef floatRef = this.f100015d;
            Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.blocking.z1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SchedulesSectionKt$autoScroll$2.y(floatRef, scrollScope, ((Float) obj2).floatValue(), ((Float) obj3).floatValue());
                }
            };
            this.f100013b = SpillingKt.a(scrollScope);
            this.f100012a = 1;
            if (SuspendAnimationKt.e(0.0f, 24.0f, 0.0f, animationSpec, function2, this, 4, null) == objF) {
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
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ScrollScope scrollScope, Continuation continuation) {
        return ((SchedulesSectionKt$autoScroll$2) create(scrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
