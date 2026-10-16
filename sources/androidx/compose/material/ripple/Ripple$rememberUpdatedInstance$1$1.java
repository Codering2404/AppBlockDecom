package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1$1", f = "Ripple.kt", l = {219}, m = "invokeSuspend")
final class Ripple$rememberUpdatedInstance$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f15345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f15346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ InteractionSource f15347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ RippleIndicationInstance f15348d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Ripple$rememberUpdatedInstance$1$1(InteractionSource interactionSource, RippleIndicationInstance rippleIndicationInstance, Continuation continuation) {
        super(2, continuation);
        this.f15347c = interactionSource;
        this.f15348d = rippleIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Ripple$rememberUpdatedInstance$1$1 ripple$rememberUpdatedInstance$1$1 = new Ripple$rememberUpdatedInstance$1$1(this.f15347c, this.f15348d, continuation);
        ripple$rememberUpdatedInstance$1$1.f15346b = obj;
        return ripple$rememberUpdatedInstance$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f15345a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.f15346b;
            Flow flowC = this.f15347c.c();
            final RippleIndicationInstance rippleIndicationInstance = this.f15348d;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Interaction interaction, Continuation continuation) {
                    if (interaction instanceof PressInteraction.Press) {
                        rippleIndicationInstance.b((PressInteraction.Press) interaction, coroutineScope);
                    } else if (interaction instanceof PressInteraction.Release) {
                        rippleIndicationInstance.g(((PressInteraction.Release) interaction).a());
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        rippleIndicationInstance.g(((PressInteraction.Cancel) interaction).a());
                    } else {
                        rippleIndicationInstance.h(interaction, coroutineScope);
                    }
                    return Unit.f139807a;
                }
            };
            this.f15345a = 1;
            if (flowC.collect(flowCollector, this) == objF) {
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
        return ((Ripple$rememberUpdatedInstance$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
