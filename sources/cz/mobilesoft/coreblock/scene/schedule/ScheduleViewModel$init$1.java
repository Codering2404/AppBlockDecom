package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1;
import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1", f = "ScheduleViewModel.kt", l = {577, 578, 621}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$init$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f114635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f114636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f114637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f114638d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Long f114640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Long f114641h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1$5", f = "ScheduleViewModel.kt", l = {606, 607}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function5<ScheduleDTO, LockState, PremiumState, List<? extends Pair<? extends Long, ? extends Profile.BlockingMode>>, Continuation<? super ScheduleViewState.DetailViewState>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f114642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f114643b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f114644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f114645d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        /* synthetic */ Object f114646f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f114647g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114648h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(ScheduleViewModel scheduleViewModel, Continuation continuation) {
            super(5, continuation);
            this.f114648h = scheduleViewModel;
        }

        @Override // kotlin.jvm.functions.Function5
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ScheduleDTO scheduleDTO, LockState lockState, PremiumState premiumState, List list, Continuation continuation) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.f114648h, continuation);
            anonymousClass5.f114644c = scheduleDTO;
            anonymousClass5.f114645d = lockState;
            anonymousClass5.f114646f = premiumState;
            anonymousClass5.f114647g = list;
            return anonymousClass5.invokeSuspend(Unit.f139807a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
        
            if (r1 == r9) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r42) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1.AnonymousClass5.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass6<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScheduleViewModel f114649a;

        AnonymousClass6(ScheduleViewModel scheduleViewModel) {
            this.f114649a = scheduleViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ScheduleViewState f(ScheduleViewState.DetailViewState detailViewState, ScheduleViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return ScheduleViewState.b(updateState, detailViewState, null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(final ScheduleViewState.DetailViewState detailViewState, Continuation continuation) {
            this.f114649a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.h3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ScheduleViewModel$init$1.AnonymousClass6.f(detailViewState, (ScheduleViewState) obj);
                }
            });
            return Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$init$1(ScheduleViewModel scheduleViewModel, Long l3, Long l4, Continuation continuation) {
        super(2, continuation);
        this.f114639f = scheduleViewModel;
        this.f114640g = l3;
        this.f114641h = l4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$init$1(this.f114639f, this.f114640g, this.f114641h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0140, code lost:
    
        if (r4.collect(r5, r12) != r0) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$init$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$init$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
