package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.Calendar;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$startSummaryTicker$1", f = "ScheduleViewModel.kt", l = {2045}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$startSummaryTicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f115021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f115022d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f115023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f115024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f115025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f115026i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f115027j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$startSummaryTicker$1(long j3, ScheduleViewModel scheduleViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f115025h = j3;
        this.f115026i = scheduleViewModel;
        this.f115027j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(String str, ScheduleViewState scheduleViewState) {
        ScheduleViewState.MainCardSummaryData mainCardSummaryDataR = scheduleViewState.r();
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, null, null, null, null, false, mainCardSummaryDataR != null ? ScheduleViewState.MainCardSummaryData.b(mainCardSummaryDataR, null, null, null, 0, null, null, null, str, null, null, false, null, 3967, null) : null, null, null, 114687, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$startSummaryTicker$1(this.f115025h, this.f115026i, this.f115027j, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115024g;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.b(obj);
        do {
            Calendar calendarA = TimeHelperExt.A();
            long j3 = (((long) calendarA.get(11)) * 3600) + (((long) calendarA.get(12)) * 60) + ((long) calendarA.get(13));
            long j4 = this.f115025h * 60;
            long j5 = j4 - j3;
            final String string = (1 > j5 || j5 >= 3601) ? j5 <= 0 ? this.f115026i.A0().getString(R.string.G) : this.f115027j : this.f115026i.A0().getString(R.string.dA, DateHelperExtKt.e(j5, true, false, true));
            Intrinsics.checkNotNull(string);
            ScheduleViewState.MainCardSummaryData mainCardSummaryDataR = ScheduleViewModel.q1(this.f115026i).r();
            if (!Intrinsics.areEqual(mainCardSummaryDataR != null ? mainCardSummaryDataR.d() : null, string)) {
                this.f115026i.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.u4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ScheduleViewModel$startSummaryTicker$1.q(string, (ScheduleViewState) obj2);
                    }
                });
            }
            if (j5 <= 0) {
                return Unit.f139807a;
            }
            this.f115019a = SpillingKt.a(calendarA);
            this.f115020b = SpillingKt.a(string);
            this.f115021c = j3;
            this.f115022d = j4;
            this.f115023f = j5;
            this.f115024g = 1;
        } while (DelayKt.b(1000L, this) != objF);
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$startSummaryTicker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
