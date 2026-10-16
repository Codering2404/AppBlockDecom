package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onRemoveConditionClicked$1;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onRemoveConditionClicked$1", f = "ScheduleViewModel.kt", l = {1837, 1839, 1841}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onRemoveConditionClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f114893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114894d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ProfileType f114895f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onRemoveConditionClicked$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onRemoveConditionClicked$1$1", f = "ScheduleViewModel.kt", l = {1845}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f114896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f114897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f114898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f114899d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114900f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
            super(2, continuation);
            this.f114900f = scheduleViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ScheduleViewState q(List list, ScheduleViewState scheduleViewState) {
            return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, list, null, null, null, false, null, null, null, 130559, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f114900f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            ScheduleViewModel scheduleViewModel;
            Object objF = IntrinsicsKt.f();
            int i3 = this.f114899d;
            if (i3 == 0) {
                ResultKt.b(obj);
                ScheduleDTO scheduleDTOR2 = this.f114900f.R2();
                ScheduleViewModel scheduleViewModel2 = this.f114900f;
                SchedulingConflictUseCase schedulingConflictUseCaseM3 = scheduleViewModel2.m3();
                SchedulingConflictUseCase.Params params = new SchedulingConflictUseCase.Params(scheduleDTOR2.o(), scheduleDTOR2.k(), scheduleDTOR2.e(), scheduleDTOR2.C(), scheduleDTOR2.p(), false, scheduleDTOR2.x(), scheduleDTOR2.q(), scheduleDTOR2.A(), 32, null);
                this.f114896a = scheduleViewModel2;
                this.f114897b = SpillingKt.a(scheduleDTOR2);
                this.f114898c = 0;
                this.f114899d = 1;
                objC = schedulingConflictUseCaseM3.c(params, this);
                if (objC == objF) {
                    return objF;
                }
                scheduleViewModel = scheduleViewModel2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                scheduleViewModel = (ScheduleViewModel) this.f114896a;
                ResultKt.b(obj);
                objC = obj;
            }
            final List list = (List) objC;
            scheduleViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.o4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ScheduleViewModel$onRemoveConditionClicked$1.AnonymousClass1.q(list, (ScheduleViewState) obj2);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onRemoveConditionClicked$1(ScheduleViewModel scheduleViewModel, ProfileType profileType, Continuation continuation) {
        super(2, continuation);
        this.f114894d = scheduleViewModel;
        this.f114895f = profileType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$onRemoveConditionClicked$1 scheduleViewModel$onRemoveConditionClicked$1 = new ScheduleViewModel$onRemoveConditionClicked$1(this.f114894d, this.f114895f, continuation);
        scheduleViewModel$onRemoveConditionClicked$1.f114893c = obj;
        return scheduleViewModel$onRemoveConditionClicked$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
    
        if (r11.P0(r3, r10) == r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c4, code lost:
    
        if (r11 == r0) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onRemoveConditionClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onRemoveConditionClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
