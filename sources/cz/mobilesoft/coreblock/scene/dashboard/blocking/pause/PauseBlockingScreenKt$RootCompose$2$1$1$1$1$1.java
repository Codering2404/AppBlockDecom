package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause;

import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingScreenKt$RootCompose$2$1$1$1$1$1", f = "PauseBlockingScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class PauseBlockingScreenKt$RootCompose$2$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PauseBlockingViewState f100109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f100110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TimePickerViewModel f100111d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PauseBlockingScreenKt$RootCompose$2$1$1$1$1$1(PauseBlockingViewState pauseBlockingViewState, long j3, TimePickerViewModel timePickerViewModel, Continuation continuation) {
        super(2, continuation);
        this.f100109b = pauseBlockingViewState;
        this.f100110c = j3;
        this.f100111d = timePickerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PauseBlockingScreenKt$RootCompose$2$1$1$1$1$1(this.f100109b, this.f100110c, this.f100111d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f100108a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        SchedulePauseHistoryEntity schedulePauseHistoryEntity = (SchedulePauseHistoryEntity) CollectionsKt.firstOrNull(this.f100109b.g());
        if (schedulePauseHistoryEntity != null) {
            Integer numD = Boxing.d(schedulePauseHistoryEntity.b());
            if (numD.intValue() >= this.f100110c) {
                numD = null;
            }
            if (numD != null) {
                TimePickerViewModel.p1(this.f100111d, TimePickerConfig.f133036h.b(), Boxing.e(((long) numD.intValue()) * 1000), null, false, 12, null);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PauseBlockingScreenKt$RootCompose$2$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
