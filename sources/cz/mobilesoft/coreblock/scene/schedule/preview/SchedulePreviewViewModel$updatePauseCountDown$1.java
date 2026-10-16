package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$updatePauseCountDown$1", f = "SchedulePreviewViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$updatePauseCountDown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f117570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117571c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$updatePauseCountDown$1(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.f117571c = schedulePreviewViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePreviewViewState y(Long l3, SchedulePreviewViewState schedulePreviewViewState) {
        return schedulePreviewViewState.q((63487 & 1) != 0 ? schedulePreviewViewState.f117578a : null, (63487 & 2) != 0 ? schedulePreviewViewState.f117579b : null, (63487 & 4) != 0 ? schedulePreviewViewState.f117580c : false, (63487 & 8) != 0 ? schedulePreviewViewState.f117581d : false, (63487 & 16) != 0 ? schedulePreviewViewState.f117582f : false, (63487 & 32) != 0 ? schedulePreviewViewState.f117583g : false, (63487 & 64) != 0 ? schedulePreviewViewState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? schedulePreviewViewState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? schedulePreviewViewState.f117586j : l3.longValue(), (63487 & 512) != 0 ? schedulePreviewViewState.f117587k : 0L, (63487 & 1024) != 0 ? schedulePreviewViewState.f117588l : null, (63487 & 2048) != 0 ? schedulePreviewViewState.f117589m : null, (63487 & 4096) != 0 ? schedulePreviewViewState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? schedulePreviewViewState.f117591o : 0L, (63487 & 16384) != 0 ? schedulePreviewViewState.f117592p : null, (63487 & 32768) != 0 ? schedulePreviewViewState.f117593q : null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SchedulePreviewViewModel$updatePauseCountDown$1 schedulePreviewViewModel$updatePauseCountDown$1 = new SchedulePreviewViewModel$updatePauseCountDown$1(this.f117571c, continuation);
        schedulePreviewViewModel$updatePauseCountDown$1.f117570b = obj;
        return schedulePreviewViewModel$updatePauseCountDown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f117570b;
        IntrinsicsKt.f();
        if (this.f117569a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (l3 == null || ComparableExtKt.d(l3, Boxing.e(0L))) {
            this.f117571c.N1();
        } else {
            this.f117571c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.s2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SchedulePreviewViewModel$updatePauseCountDown$1.y(l3, (SchedulePreviewViewState) obj2);
                }
            });
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((SchedulePreviewViewModel$updatePauseCountDown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
