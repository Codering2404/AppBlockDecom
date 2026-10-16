package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onExtraOptionClicked$1", f = "ScheduleViewModel.kt", l = {1138, 1144, 1158, 1170, 1199}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onExtraOptionClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f114858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114859d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ExtraOption f114861g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onExtraOptionClicked$1(ScheduleViewModel scheduleViewModel, ExtraOption extraOption, Continuation continuation) {
        super(2, continuation);
        this.f114860f = scheduleViewModel;
        this.f114861g = extraOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO G(ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, !scheduleDTO.c(), false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870907, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO J(ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, !scheduleDTO.j(), false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870903, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO K(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO) {
        ScheduleDTO scheduleDTOR2 = scheduleViewModel.R2();
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        answersHelper.V(!scheduleDTO.f(), scheduleDTOR2.o());
        if (scheduleDTO.f()) {
            answersHelper.W(scheduleDTOR2.o());
        }
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, !scheduleDTO.f(), false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870895, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState L(ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, true, ScheduleViewState.DetailBottomSheetType.AdultContentBottomSheet, false, false, false, false, null, null, null, null, null, false, null, null, null, 131059, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO M(ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, !scheduleDTO.g(), false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870879, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onExtraOptionClicked$1(this.f114860f, this.f114861g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00dd, code lost:
    
        if (r2.P0(r3, r12) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0133, code lost:
    
        if (r2.P0(r3, r12) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x018b, code lost:
    
        if (r2.P0(r3, r12) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01e3, code lost:
    
        if (r2.P0(r4, r12) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x025d, code lost:
    
        if (r3.P0(r4, r12) == r0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x025f, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 627
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onExtraOptionClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onExtraOptionClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
