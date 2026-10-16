package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$startSummaryTicker$1", f = "SchedulePreviewViewModel.kt", l = {353}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$startSummaryTicker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f117553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f117554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f117555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f117556d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f117557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f117558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f117559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ String f117561j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$startSummaryTicker$1(long j3, SchedulePreviewViewModel schedulePreviewViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f117559h = j3;
        this.f117560i = schedulePreviewViewModel;
        this.f117561j = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePreviewViewState q(String str, SchedulePreviewViewState schedulePreviewViewState) {
        ScheduleViewState.MainCardSummaryData mainCardSummaryDataK = schedulePreviewViewState.K();
        return schedulePreviewViewState.q((63487 & 1) != 0 ? schedulePreviewViewState.f117578a : null, (63487 & 2) != 0 ? schedulePreviewViewState.f117579b : null, (63487 & 4) != 0 ? schedulePreviewViewState.f117580c : false, (63487 & 8) != 0 ? schedulePreviewViewState.f117581d : false, (63487 & 16) != 0 ? schedulePreviewViewState.f117582f : false, (63487 & 32) != 0 ? schedulePreviewViewState.f117583g : false, (63487 & 64) != 0 ? schedulePreviewViewState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? schedulePreviewViewState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? schedulePreviewViewState.f117586j : 0L, (63487 & 512) != 0 ? schedulePreviewViewState.f117587k : 0L, (63487 & 1024) != 0 ? schedulePreviewViewState.f117588l : null, (63487 & 2048) != 0 ? schedulePreviewViewState.f117589m : null, (63487 & 4096) != 0 ? schedulePreviewViewState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? schedulePreviewViewState.f117591o : 0L, (63487 & 16384) != 0 ? schedulePreviewViewState.f117592p : null, (63487 & 32768) != 0 ? schedulePreviewViewState.f117593q : mainCardSummaryDataK != null ? ScheduleViewState.MainCardSummaryData.b(mainCardSummaryDataK, null, null, null, 0, null, null, null, str, null, null, false, null, 3967, null) : null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewViewModel$startSummaryTicker$1(this.f117559h, this.f117560i, this.f117561j, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f117558g;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.b(obj);
        do {
            Calendar calendarA = TimeHelperExt.A();
            long j3 = (((long) calendarA.get(11)) * 3600) + (((long) calendarA.get(12)) * 60) + ((long) calendarA.get(13));
            long j4 = this.f117559h * 60;
            long j5 = j4 - j3;
            final String string = (1 > j5 || j5 >= 3601) ? j5 <= 0 ? this.f117560i.A0().getString(R.string.G) : this.f117561j : this.f117560i.A0().getString(R.string.dA, DateHelperExtKt.e(j5, true, false, true));
            Intrinsics.checkNotNull(string);
            ScheduleViewState.MainCardSummaryData mainCardSummaryDataK = SchedulePreviewViewModel.R0(this.f117560i).K();
            if (!Intrinsics.areEqual(mainCardSummaryDataK != null ? mainCardSummaryDataK.d() : null, string)) {
                this.f117560i.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.r2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SchedulePreviewViewModel$startSummaryTicker$1.q(string, (SchedulePreviewViewState) obj2);
                    }
                });
            }
            if (j5 <= 0) {
                return Unit.f139807a;
            }
            this.f117553a = SpillingKt.a(calendarA);
            this.f117554b = SpillingKt.a(string);
            this.f117555c = j3;
            this.f117556d = j4;
            this.f117557f = j5;
            this.f117558g = 1;
        } while (DelayKt.b(1000L, this) != objF);
        return objF;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewViewModel$startSummaryTicker$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
