package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$handlePossibleFutureStrictModeLock$1", f = "ScheduleViewModel.kt", l = {702}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$handlePossibleFutureStrictModeLock$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f114629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f114631d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$handlePossibleFutureStrictModeLock$1(long j3, ScheduleViewModel scheduleViewModel, long j4, Continuation continuation) {
        super(2, continuation);
        this.f114629b = j3;
        this.f114630c = scheduleViewModel;
        this.f114631d = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockState q(boolean z2, long j3, LockState lockState) {
        Long lValueOf = Long.valueOf(j3 - TimeHelperExt.f128663a.f());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        return LockState.b(lockState, z2, false, lValueOf, null, 10, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$handlePossibleFutureStrictModeLock$1(this.f114629b, this.f114630c, this.f114631d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114628a;
        if (i3 == 0) {
            ResultKt.b(obj);
            long j3 = this.f114629b;
            this.f114628a = 1;
            if (DelayKt.b(j3, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final boolean zN = this.f114630c.t0().n();
        ScheduleViewModel scheduleViewModel = this.f114630c;
        final long j4 = this.f114631d;
        scheduleViewModel.S4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.e3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ScheduleViewModel$handlePossibleFutureStrictModeLock$1.q(zN, j4, (LockState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$handlePossibleFutureStrictModeLock$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
