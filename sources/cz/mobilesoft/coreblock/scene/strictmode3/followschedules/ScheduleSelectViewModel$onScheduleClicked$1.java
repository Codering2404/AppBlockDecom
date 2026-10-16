package cz.mobilesoft.coreblock.scene.strictmode3.followschedules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ImmutableList;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$onScheduleClicked$1", f = "ScheduleSelectViewModel.kt", l = {127, 135}, m = "invokeSuspend", v = 1)
final class ScheduleSelectViewModel$onScheduleClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f122103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f122104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f122105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f122106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f122107f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f122108g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f122109h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f122110i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f122111j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f122112k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ ScheduleSelectViewModel f122113l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ long f122114m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleSelectViewModel$onScheduleClicked$1(ScheduleSelectViewModel scheduleSelectViewModel, long j3, Continuation continuation) {
        super(2, continuation);
        this.f122113l = scheduleSelectViewModel;
        this.f122114m = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleSelectViewState q(ImmutableList immutableList, ScheduleSelectViewState scheduleSelectViewState) {
        return ScheduleSelectViewState.b(scheduleSelectViewState, false, immutableList, null, null, null, false, false, 0, 253, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleSelectViewModel$onScheduleClicked$1(this.f122113l, this.f122114m, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x01be, code lost:
    
        if (r11.P0(r12, r27) == r1) goto L42;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewModel$onScheduleClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleSelectViewModel$onScheduleClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
