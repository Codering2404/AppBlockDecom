package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$8", f = "ScheduleViewModel.kt", l = {930, 933, 936, 936, 938}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114838d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f114839f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f114840g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f114841h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f114842i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f114843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f114844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f114845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f114846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f114847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f114848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f114849p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114850q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$8(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114850q = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(List list, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, true, ScheduleViewState.DetailBottomSheetType.CopyBlockingBottomSheet, false, false, false, false, ExtensionsKt.k(list), null, null, null, null, false, null, null, null, 130803, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$onEvent$8(this.f114850q, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00e5, code lost:
    
        if (r4.P0(r5, r24) == r1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0121, code lost:
    
        if (r4.P0(r5, r24) == r1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x015e, code lost:
    
        if (r3 != r1) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02d2 A[LOOP:2: B:76:0x02d0->B:77:0x02d2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02ff  */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x022c -> B:58:0x0232). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$8.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$onEvent$8) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
