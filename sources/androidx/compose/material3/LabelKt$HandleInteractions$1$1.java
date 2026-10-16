package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1", f = "Label.kt", l = {112}, m = "invokeSuspend")
final class LabelKt$HandleInteractions$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f18006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableInteractionSource f18007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TooltipState f18008c;

    /* JADX INFO: renamed from: androidx.compose.material3.LabelKt$HandleInteractions$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.LabelKt$HandleInteractions$1$1$1", f = "Label.kt", l = {117}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Interaction, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f18010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TooltipState f18011c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TooltipState tooltipState, Continuation continuation) {
            super(2, continuation);
            this.f18011c = tooltipState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f18011c, continuation);
            anonymousClass1.f18010b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Interaction interaction, Continuation continuation) {
            return ((AnonymousClass1) create(interaction, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f18009a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Interaction interaction = (Interaction) this.f18010b;
                if (interaction instanceof PressInteraction.Press ? true : interaction instanceof DragInteraction.Start ? true : interaction instanceof HoverInteraction.Enter) {
                    TooltipState tooltipState = this.f18011c;
                    MutatePriority mutatePriority = MutatePriority.f5072b;
                    this.f18009a = 1;
                    if (tooltipState.c(mutatePriority, this) == objF) {
                        return objF;
                    }
                } else {
                    if (interaction instanceof PressInteraction.Release ? true : interaction instanceof DragInteraction.Stop ? true : interaction instanceof HoverInteraction.Exit) {
                        this.f18011c.dismiss();
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LabelKt$HandleInteractions$1$1(MutableInteractionSource mutableInteractionSource, TooltipState tooltipState, Continuation continuation) {
        super(2, continuation);
        this.f18007b = mutableInteractionSource;
        this.f18008c = tooltipState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LabelKt$HandleInteractions$1$1(this.f18007b, this.f18008c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f18006a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowC = this.f18007b.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f18008c, null);
            this.f18006a = 1;
            if (FlowKt.l(flowC, anonymousClass1, this) == objF) {
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
        return ((LabelKt$HandleInteractions$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
