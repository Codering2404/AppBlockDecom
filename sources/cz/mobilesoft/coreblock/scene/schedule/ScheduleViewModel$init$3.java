package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$3;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$3", f = "ScheduleViewModel.kt", l = {639}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$init$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114657b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114658a;

        AnonymousClass1(ScheduleViewModel scheduleViewModel) {
            this.f114658a = scheduleViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ScheduleViewState g(boolean z2, ScheduleViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return ScheduleViewState.b(updateState, null, null, false, null, z2, false, false, false, null, null, null, null, null, false, null, null, null, 131055, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ScheduleDTO h(ScheduleDTO updateSchedule) {
            Intrinsics.checkNotNullParameter(updateSchedule, "$this$updateSchedule");
            return ScheduleDTO.b(updateSchedule, null, null, false, false, true, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870895, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return f(((Number) obj).longValue(), continuation);
        }

        public final Object f(long j3, Continuation continuation) {
            final boolean z2 = j3 > 0;
            this.f114658a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.j3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleViewModel$init$3.AnonymousClass1.g(z2, (ScheduleViewState) obj);
                }
            });
            if (z2 && ScheduleViewModel.q1(this.f114658a).e() == ScheduleViewState.DetailBottomSheetType.AdultContentBottomSheet) {
                AnswersHelper.f128199a.W(this.f114658a.R2().o());
                this.f114658a.T4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.k3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScheduleViewModel$init$3.AnonymousClass1.h((ScheduleDTO) obj);
                    }
                });
            }
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$init$3(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114657b = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$init$3(this.f114657b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114656a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowD2 = this.f114657b.Y2().D2();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f114657b);
            this.f114656a = 1;
            if (flowD2.collect(anonymousClass1, this) == objF) {
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
        return ((ScheduleViewModel$init$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
