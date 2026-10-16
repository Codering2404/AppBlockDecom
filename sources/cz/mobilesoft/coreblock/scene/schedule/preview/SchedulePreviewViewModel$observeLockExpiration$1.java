package cz.mobilesoft.coreblock.scene.schedule.preview;

import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$observeLockExpiration$1", f = "SchedulePreviewViewModel.kt", l = {476}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$observeLockExpiration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f117483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117484c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$observeLockExpiration$1(long j3, SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(2, continuation);
        this.f117483b = j3;
        this.f117484c = schedulePreviewViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SchedulePreviewViewState q(SchedulePreviewViewState schedulePreviewViewState) {
        Profile profileP;
        ProfileWithConfiguration profileWithConfigurationI = schedulePreviewViewState.I();
        return schedulePreviewViewState.q((63487 & 1) != 0 ? schedulePreviewViewState.f117578a : null, (63487 & 2) != 0 ? schedulePreviewViewState.f117579b : null, (63487 & 4) != 0 ? schedulePreviewViewState.f117580c : (profileWithConfigurationI == null || (profileP = profileWithConfigurationI.p()) == null || !profileP.L()) ? false : true, (63487 & 8) != 0 ? schedulePreviewViewState.f117581d : false, (63487 & 16) != 0 ? schedulePreviewViewState.f117582f : false, (63487 & 32) != 0 ? schedulePreviewViewState.f117583g : false, (63487 & 64) != 0 ? schedulePreviewViewState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? schedulePreviewViewState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? schedulePreviewViewState.f117586j : 0L, (63487 & 512) != 0 ? schedulePreviewViewState.f117587k : 0L, (63487 & 1024) != 0 ? schedulePreviewViewState.f117588l : null, (63487 & 2048) != 0 ? schedulePreviewViewState.f117589m : null, (63487 & 4096) != 0 ? schedulePreviewViewState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? schedulePreviewViewState.f117591o : 0L, (63487 & 16384) != 0 ? schedulePreviewViewState.f117592p : null, (63487 & 32768) != 0 ? schedulePreviewViewState.f117593q : null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SchedulePreviewViewModel$observeLockExpiration$1(this.f117483b, this.f117484c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f117482a;
        if (i3 == 0) {
            ResultKt.b(obj);
            long j3 = this.f117483b;
            this.f117482a = 1;
            if (DelayKt.b(j3, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        this.f117484c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.q2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return SchedulePreviewViewModel$observeLockExpiration$1.q((SchedulePreviewViewState) obj2);
            }
        });
        this.f117484c.N1();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SchedulePreviewViewModel$observeLockExpiration$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
