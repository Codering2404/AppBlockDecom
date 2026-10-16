package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.TripleState;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$4", f = "ScheduleViewModel.kt", l = {660}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$init$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114660b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$init$4(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114660b = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(boolean z2, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, z2, false, false, null, null, null, null, null, false, null, null, null, 131039, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$init$4(this.f114660b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114659a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowA0 = this.f114660b.g3().a0();
            this.f114659a = 1;
            obj = FlowKt.D(flowA0, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final boolean z2 = obj == TripleState.Unset;
        this.f114660b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.l3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ScheduleViewModel$init$4.q(z2, (ScheduleViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$init$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
