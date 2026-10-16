package cz.mobilesoft.coreblock.scene.schedule;

import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSummaryRequested$1", f = "ScheduleViewModel.kt", l = {1961, 1965, 1977, AdError.INTERNAL_ERROR_2003, 2005}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onSummaryRequested$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f114938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f114940d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f114941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f114942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f114943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f114944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f114945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f114946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f114947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114948m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onSummaryRequested$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114948m = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(ProfileWithConfiguration profileWithConfiguration, List list, boolean z2, ScheduleViewState.MainCardSummaryData mainCardSummaryData, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, null, null, profileWithConfiguration, list, z2, mainCardSummaryData, null, null, 100351, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleViewModel$onSummaryRequested$1(this.f114948m, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onSummaryRequested$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((ScheduleViewModel$onSummaryRequested$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
