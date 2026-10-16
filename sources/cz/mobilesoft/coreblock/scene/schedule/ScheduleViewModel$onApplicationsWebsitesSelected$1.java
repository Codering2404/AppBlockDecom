package cz.mobilesoft.coreblock.scene.schedule;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onApplicationsWebsitesSelected$1", f = "ScheduleViewModel.kt", l = {2424, 2442, 2497, 2508, 2525, 2532, 2533, 2534, 2538}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onApplicationsWebsitesSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114732d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f114733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f114734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f114735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f114736i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f114737j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ boolean f114738k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114739l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ List f114740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ List f114741n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ List f114742o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ List f114743p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onApplicationsWebsitesSelected$1(boolean z2, ScheduleViewModel scheduleViewModel, List list, List list2, List list3, List list4, Continuation continuation) {
        super(2, continuation);
        this.f114738k = z2;
        this.f114739l = scheduleViewModel;
        this.f114740m = list;
        this.f114741n = list2;
        this.f114742o = list3;
        this.f114743p = list4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO A(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, List list, List list2, ScheduleDTO scheduleDTO) {
        return ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, arrayList, arrayList2, arrayList3, list != null ? new ArrayList(list) : new ArrayList(), null, false, true, false, 0L, 0L, null, false, list2, 263258111, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState J(ScheduleViewState.DetailViewState detailViewState, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, detailViewState, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState K(List list, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, list, null, null, null, false, null, null, null, 130559, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onApplicationsWebsitesSelected$1(this.f114738k, this.f114739l, this.f114740m, this.f114741n, this.f114742o, this.f114743p, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00f6, code lost:
    
        if (r2.N4(r31) != r1) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0249, code lost:
    
        if (r5.O2(r31) == r1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x024d, code lost:
    
        r5 = r2;
        r2 = r9;
        r9 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x02a3, code lost:
    
        if (r5.P0(r13, r31) == r1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x033e, code lost:
    
        if (r5.P0(r13, r31) == r1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0375, code lost:
    
        if (r5.P0(r13, r31) == r1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0399, code lost:
    
        if (r5.P0(r13, r31) == r1) goto L92;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0411 A[LOOP:0: B:95:0x040f->B:96:0x0411, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x042d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1134
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onApplicationsWebsitesSelected$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onApplicationsWebsitesSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleDTO G(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO) {
        String string = scheduleViewModel.A0().getString(R.string.qu);
        Intrinsics.checkNotNullExpressionValue(string, QaXmqxvjHhxVy.miWUJAGjJhjIj);
        return ScheduleDTO.b(scheduleDTO, null, string, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870909, null);
    }
}
