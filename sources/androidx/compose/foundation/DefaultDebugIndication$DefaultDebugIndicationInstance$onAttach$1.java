package androidx.compose.foundation;

import androidx.compose.foundation.DefaultDebugIndication;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.node.DrawModifierNodeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
@DebugMetadata(c = "androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1", f = "Indication.kt", l = {228}, m = "invokeSuspend")
final class DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance f4896b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance, Continuation continuation) {
        super(2, continuation);
        this.f4896b = defaultDebugIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this.f4896b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4895a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Ref.IntRef intRef = new Ref.IntRef();
            final Ref.IntRef intRef2 = new Ref.IntRef();
            final Ref.IntRef intRef3 = new Ref.IntRef();
            Flow flowC = this.f4896b.f4891a.c();
            final DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance = this.f4896b;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Interaction interaction, Continuation continuation) {
                    boolean z2 = true;
                    if (interaction instanceof PressInteraction.Press) {
                        intRef.f140142a++;
                    } else if (interaction instanceof PressInteraction.Release) {
                        Ref.IntRef intRef4 = intRef;
                        intRef4.f140142a--;
                    } else if (interaction instanceof PressInteraction.Cancel) {
                        Ref.IntRef intRef5 = intRef;
                        intRef5.f140142a--;
                    } else if (interaction instanceof HoverInteraction.Enter) {
                        intRef2.f140142a++;
                    } else if (interaction instanceof HoverInteraction.Exit) {
                        Ref.IntRef intRef6 = intRef2;
                        intRef6.f140142a--;
                    } else if (interaction instanceof FocusInteraction.Focus) {
                        intRef3.f140142a++;
                    } else if (interaction instanceof FocusInteraction.Unfocus) {
                        Ref.IntRef intRef7 = intRef3;
                        intRef7.f140142a--;
                    }
                    boolean z3 = false;
                    boolean z4 = intRef.f140142a > 0;
                    boolean z5 = intRef2.f140142a > 0;
                    boolean z6 = intRef3.f140142a > 0;
                    if (defaultDebugIndicationInstance.f4892b != z4) {
                        defaultDebugIndicationInstance.f4892b = z4;
                        z3 = true;
                    }
                    if (defaultDebugIndicationInstance.f4893c != z5) {
                        defaultDebugIndicationInstance.f4893c = z5;
                        z3 = true;
                    }
                    if (defaultDebugIndicationInstance.f4894d != z6) {
                        defaultDebugIndicationInstance.f4894d = z6;
                    } else {
                        z2 = z3;
                    }
                    if (z2) {
                        DrawModifierNodeKt.a(defaultDebugIndicationInstance);
                    }
                    return Unit.f139807a;
                }
            };
            this.f4895a = 1;
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
        return ((DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
