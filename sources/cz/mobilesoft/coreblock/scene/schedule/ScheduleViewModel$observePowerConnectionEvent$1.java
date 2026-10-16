package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$observePowerConnectionEvent$1;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$observePowerConnectionEvent$1", f = "ScheduleViewModel.kt", l = {681}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$observePowerConnectionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114709b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$observePowerConnectionEvent$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114710a;

        AnonymousClass1(ScheduleViewModel scheduleViewModel) {
            this.f114710a = scheduleViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final LockState f(boolean z2, LockState updateLockState) {
            Intrinsics.checkNotNullParameter(updateLockState, "$this$updateLockState");
            return LockState.b(updateLockState, false, z2, null, null, 13, null);
        }

        public final Object b(final boolean z2, Continuation continuation) {
            this.f114710a.S4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.r3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleViewModel$observePowerConnectionEvent$1.AnonymousClass1.f(z2, (LockState) obj);
                }
            });
            if (z2) {
                this.f114710a.A4();
            }
            return Unit.f139807a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return b(((Boolean) obj).booleanValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$observePowerConnectionEvent$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114709b = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$observePowerConnectionEvent$1(this.f114709b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114708a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowB1 = this.f114709b.b3().b1();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f114709b);
            this.f114708a = 1;
            if (flowB1.collect(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$observePowerConnectionEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
