package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onConditionSet$1", f = "ScheduleViewModel.kt", l = {1296, 1356, 1382, 1384}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onConditionSet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114781d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ConditionDTO f114783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ boolean f114784h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onConditionSet$1(ScheduleViewModel scheduleViewModel, ConditionDTO conditionDTO, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114782f = scheduleViewModel;
        this.f114783g = conditionDTO;
        this.f114784h = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO G(ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, scheduleDTO.z() & ProfileType.STRICT_MODE.mask(), null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536807167, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO J(Ref.IntRef intRef, ConditionDTO conditionDTO, ScheduleDTO scheduleDTO) {
        int i3 = intRef.f140142a;
        ConditionDTO.CombinationDTO combinationDTO = (ConditionDTO.CombinationDTO) conditionDTO;
        ConditionDTO.TimeDTO timeDTOF = combinationDTO.f();
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, i3, null, null, combinationDTO.e(), combinationDTO.g(), combinationDTO.d(), timeDTOF, combinationDTO.h(), null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536807167, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO K(ConditionDTO conditionDTO, int i3, ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, conditionDTO.a() == ProfileType.COMBINED ? ScheduleEmoji.AppBLock : ScheduleEmoji.Companion.f(i3), false, null, 469762047, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState L(List list, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, list, null, null, null, false, null, null, null, 130559, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(ScheduleViewModel scheduleViewModel) {
        BuildersKt__Builders_commonKt.d(scheduleViewModel.C0(), null, null, new ScheduleViewModel$onConditionSet$1$6$1(scheduleViewModel, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onConditionSet$1(this.f114782f, this.f114783g, this.f114784h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01ce, code lost:
    
        if (r3.P0(r7, r20) == r1) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01e9, code lost:
    
        if (r4.P0(r7, r20) == r1) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onConditionSet$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onConditionSet$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
