package cz.mobilesoft.coreblock.scene.schedule.preview;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import com.facebook.internal.Utility;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.insights.usecase.FetchAppDataUseCase;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel;
import cz.mobilesoft.coreblock.scene.streaks.StreakPauseTracker;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.service.receiver.PowerConnectionReceiver;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.BatteryChargerHelper;
import cz.mobilesoft.coreblock.util.runnability.JobHelperKtx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class SchedulePreviewViewModel extends BaseStatefulViewModel<SchedulePreviewViewState, SchedulePreviewViewEvent, SchedulePreviewViewCommand> {
    private final Lazy A;
    private final PowerConnectionReceiver B;
    private Job C;
    private Job D;
    private Job E;
    private Job F;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ProfileViewDTO f117406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f117407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f117408q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f117409r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Lazy f117410s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Lazy f117411t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Lazy f117412u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f117413v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f117414w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Lazy f117415x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Lazy f117416y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Lazy f117417z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$1", f = "SchedulePreviewViewModel.kt", l = {101}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117418a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117418a;
            if (i3 == 0) {
                ResultKt.b(obj);
                EventDataStore eventDataStoreT1 = SchedulePreviewViewModel.this.t1();
                boolean zA = BatteryChargerHelper.f129457a.a(SchedulePreviewViewModel.this.A0());
                this.f117418a = 1;
                if (eventDataStoreT1.i2(zA, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$10, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$10", f = "SchedulePreviewViewModel.kt", l = {176, 196}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass10 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f117420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f117421b;

        AnonymousClass10(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SchedulePreviewViewState q(List list, SchedulePreviewViewState schedulePreviewViewState) {
            return schedulePreviewViewState.q((63487 & 1) != 0 ? schedulePreviewViewState.f117578a : null, (63487 & 2) != 0 ? schedulePreviewViewState.f117579b : null, (63487 & 4) != 0 ? schedulePreviewViewState.f117580c : false, (63487 & 8) != 0 ? schedulePreviewViewState.f117581d : false, (63487 & 16) != 0 ? schedulePreviewViewState.f117582f : false, (63487 & 32) != 0 ? schedulePreviewViewState.f117583g : false, (63487 & 64) != 0 ? schedulePreviewViewState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? schedulePreviewViewState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? schedulePreviewViewState.f117586j : 0L, (63487 & 512) != 0 ? schedulePreviewViewState.f117587k : 0L, (63487 & 1024) != 0 ? schedulePreviewViewState.f117588l : null, (63487 & 2048) != 0 ? schedulePreviewViewState.f117589m : list, (63487 & 4096) != 0 ? schedulePreviewViewState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? schedulePreviewViewState.f117591o : 0L, (63487 & 16384) != 0 ? schedulePreviewViewState.f117592p : null, (63487 & 32768) != 0 ? schedulePreviewViewState.f117593q : null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass10(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x00f0, code lost:
        
            if (r2 == r1) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 258
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.AnonymousClass10.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass10) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$11, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$11", f = "SchedulePreviewViewModel.kt", l = {206, 210}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f117423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f117424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f117425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f117426d;

        AnonymousClass11(Continuation continuation) {
            super(1, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SchedulePreviewViewState q(List list, SchedulePreviewViewState schedulePreviewViewState) {
            return schedulePreviewViewState.q((63487 & 1) != 0 ? schedulePreviewViewState.f117578a : null, (63487 & 2) != 0 ? schedulePreviewViewState.f117579b : null, (63487 & 4) != 0 ? schedulePreviewViewState.f117580c : false, (63487 & 8) != 0 ? schedulePreviewViewState.f117581d : false, (63487 & 16) != 0 ? schedulePreviewViewState.f117582f : false, (63487 & 32) != 0 ? schedulePreviewViewState.f117583g : false, (63487 & 64) != 0 ? schedulePreviewViewState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? schedulePreviewViewState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? schedulePreviewViewState.f117586j : 0L, (63487 & 512) != 0 ? schedulePreviewViewState.f117587k : 0L, (63487 & 1024) != 0 ? schedulePreviewViewState.f117588l : null, (63487 & 2048) != 0 ? schedulePreviewViewState.f117589m : null, (63487 & 4096) != 0 ? schedulePreviewViewState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? schedulePreviewViewState.f117591o : 0L, (63487 & 16384) != 0 ? schedulePreviewViewState.f117592p : list, (63487 & 32768) != 0 ? schedulePreviewViewState.f117593q : null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass11(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00c4, code lost:
        
            if (r2 == r1) goto L25;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.AnonymousClass11.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass11) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$12", f = "SchedulePreviewViewModel.kt", l = {230}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass12 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117428a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$12$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117430a;

            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117430a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(boolean z2, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : z2, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : (z2 && updateState.w() == 0) ? TimeHelperExt.c() + 10000 : updateState.w(), (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f117430a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.j2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass12.AnonymousClass1.f(z2, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass12(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117428a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowU2 = SchedulePreviewViewModel.this.s1().u2();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SchedulePreviewViewModel.this);
                this.f117428a = 1;
                if (flowU2.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass12) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2", f = "SchedulePreviewViewModel.kt", l = {105}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117431a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117433a;

            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117433a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(ProfileWithConfiguration profileWithConfiguration, boolean z2, boolean z3, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : profileWithConfiguration, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : z2, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : z3, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(final cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1$emit$1
                    if (r0 == 0) goto L13
                    r0 = r11
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1$emit$1) r0
                    int r1 = r0.f117440h
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f117440h = r1
                    goto L18
                L13:
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$2$1$emit$1
                    r0.<init>(r9, r11)
                L18:
                    java.lang.Object r11 = r0.f117438f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r2 = r0.f117440h
                    r3 = 0
                    r4 = 1
                    if (r2 == 0) goto L3e
                    if (r2 != r4) goto L36
                    java.lang.Object r10 = r0.f117436c
                    cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r10 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r10
                    java.lang.Object r1 = r0.f117435b
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r1 = (cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel) r1
                    java.lang.Object r0 = r0.f117434a
                    cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration r0 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration) r0
                    kotlin.ResultKt.b(r11)
                    goto L6c
                L36:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L3e:
                    kotlin.ResultKt.b(r11)
                    if (r10 == 0) goto La3
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel r11 = r9.f117433a
                    cz.mobilesoft.coreblock.repository.StrictModeRepository r2 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.g1(r11)
                    cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r5 = cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.b1(r11)
                    long r5 = r5.k()
                    java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
                    java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
                    r0.f117434a = r6
                    r0.f117435b = r11
                    r0.f117436c = r10
                    r0.f117437d = r3
                    r0.f117440h = r4
                    java.lang.Object r0 = r2.q(r5, r0)
                    if (r0 != r1) goto L6a
                    return r1
                L6a:
                    r1 = r11
                    r11 = r0
                L6c:
                    java.lang.Boolean r11 = (java.lang.Boolean) r11
                    boolean r11 = r11.booleanValue()
                    cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = r10.p()
                    boolean r0 = r0.L()
                    if (r0 != 0) goto L8c
                    cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = r10.p()
                    long r5 = r0.u()
                    long r7 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
                    int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r0 <= 0) goto L8d
                L8c:
                    r3 = r4
                L8d:
                    cz.mobilesoft.coreblock.scene.schedule.preview.k2 r0 = new cz.mobilesoft.coreblock.scene.schedule.preview.k2
                    r0.<init>()
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.o1(r1, r0)
                    cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r10 = r10.p()
                    long r10 = r10.u()
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.i1(r1, r10)
                    cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.n1(r1)
                La3:
                    kotlin.Unit r10 = kotlin.Unit.f139807a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel.AnonymousClass2.AnonymousClass1.emit(cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117431a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowB1 = SchedulePreviewViewModel.this.y1().b1(SchedulePreviewViewModel.this.f117406o.k());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SchedulePreviewViewModel.this);
                this.f117431a = 1;
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$3", f = "SchedulePreviewViewModel.kt", l = {124}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f117441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f117442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f117443c;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117445a;

            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117445a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(List list, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : list, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final List list, Continuation continuation) {
                this.f117445a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.l2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass3.AnonymousClass1.f(list, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass3(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117443c;
            if (i3 == 0) {
                ResultKt.b(obj);
                Pair pairU = TimeHelperExt.f128663a.u();
                long jLongValue = ((Number) pairU.a()).longValue();
                long jLongValue2 = ((Number) pairU.b()).longValue();
                Flow flowO = SchedulePreviewViewModel.this.z1().O(jLongValue, jLongValue2, SchedulePreviewViewModel.this.f117406o.k());
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SchedulePreviewViewModel.this);
                this.f117441a = jLongValue;
                this.f117442b = jLongValue2;
                this.f117443c = 1;
                if (flowO.collect(anonymousClass1, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$4", f = "SchedulePreviewViewModel.kt", l = {134}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117446a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117448a;

            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117448a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(boolean z2, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : z2, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f117448a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.m2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass4.AnonymousClass1.f(z2, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass4(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117446a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(sKeKFMqmvNzY.MxnhpbQSJa);
                }
            } else {
                ResultKt.b(obj);
                Flow flowQ3 = SchedulePreviewViewModel.this.s1().Q3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SchedulePreviewViewModel.this);
                this.f117446a = 1;
                if (flowQ3.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$5", f = "SchedulePreviewViewModel.kt", l = {144}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117449a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$5$1", f = "SchedulePreviewViewModel.kt", l = {141}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PremiumState, SchedulePreviewViewState, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f117451a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f117452b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117453c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
                super(3, continuation);
                this.f117453c = schedulePreviewViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PremiumState premiumState, SchedulePreviewViewState schedulePreviewViewState, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f117453c, continuation);
                anonymousClass1.f117452b = premiumState;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                PremiumState premiumState = (PremiumState) this.f117452b;
                Object objF = IntrinsicsKt.f();
                int i3 = this.f117451a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ProfileDao profileDaoY1 = this.f117453c.y1();
                    this.f117452b = premiumState;
                    this.f117451a = 1;
                    obj = profileDaoY1.s0(false, false, this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Boxing.a(premiumState.f(Product.PROFILE) || ((List) obj).size() < Limit.PROFILE_LIMIT.getLimitValue());
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$5$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117454a;

            AnonymousClass2(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117454a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(boolean z2, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : z2, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f117454a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.n2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass5.AnonymousClass2.f(z2, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass5(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117449a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(SchedulePreviewViewModel.this.x1().K(), SchedulePreviewViewModel.this.M0(), new AnonymousClass1(SchedulePreviewViewModel.this, null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(SchedulePreviewViewModel.this);
                this.f117449a = 1;
                if (flowJ.collect(anonymousClass2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass5) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$6, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$6", f = "SchedulePreviewViewModel.kt", l = {154}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117455a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$6$1", f = "SchedulePreviewViewModel.kt", l = {151}, m = "invokeSuspend", v = 1)
        static final class AnonymousClass1 extends SuspendLambda implements Function3<PremiumState, SchedulePreviewViewState, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f117457a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f117458b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117459c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
                super(3, continuation);
                this.f117459c = schedulePreviewViewModel;
            }

            @Override // kotlin.jvm.functions.Function3
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(PremiumState premiumState, SchedulePreviewViewState schedulePreviewViewState, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f117459c, continuation);
                anonymousClass1.f117458b = premiumState;
                return anonymousClass1.invokeSuspend(Unit.f139807a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                PremiumState premiumState = (PremiumState) this.f117458b;
                Object objF = IntrinsicsKt.f();
                int i3 = this.f117457a;
                if (i3 == 0) {
                    ResultKt.b(obj);
                    ProfileDao profileDaoY1 = this.f117459c.y1();
                    this.f117458b = premiumState;
                    this.f117457a = 1;
                    obj = profileDaoY1.s0(false, false, this);
                    if (obj == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : (List) obj) {
                    if (!((Profile) obj2).J()) {
                        arrayList.add(obj2);
                    }
                }
                return Boxing.a(premiumState.f(Product.PROFILE) || arrayList.size() < Limit.PROFILE_LIMIT.getLimitValue());
            }
        }

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$6$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass2<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117460a;

            AnonymousClass2(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117460a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(boolean z2, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : z2, (63487 & 64) != 0 ? updateState.f117584h : null, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f117460a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.o2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass6.AnonymousClass2.f(z2, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass6(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass6(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117455a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ = FlowKt.J(SchedulePreviewViewModel.this.x1().K(), SchedulePreviewViewModel.this.M0(), new AnonymousClass1(SchedulePreviewViewModel.this, null));
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(SchedulePreviewViewModel.this);
                this.f117455a = 1;
                if (flowJ.collect(anonymousClass2, this) == objF) {
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$7", f = "SchedulePreviewViewModel.kt", l = {160}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass7 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117461a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$7$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SchedulePreviewViewModel f117463a;

            AnonymousClass1(SchedulePreviewViewModel schedulePreviewViewModel) {
                this.f117463a = schedulePreviewViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SchedulePreviewViewState f(PremiumState premiumState, SchedulePreviewViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return updateState.q((63487 & 1) != 0 ? updateState.f117578a : null, (63487 & 2) != 0 ? updateState.f117579b : null, (63487 & 4) != 0 ? updateState.f117580c : false, (63487 & 8) != 0 ? updateState.f117581d : false, (63487 & 16) != 0 ? updateState.f117582f : false, (63487 & 32) != 0 ? updateState.f117583g : false, (63487 & 64) != 0 ? updateState.f117584h : premiumState, (63487 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? updateState.f117585i : false, (63487 & Function.MAX_NARGS) != 0 ? updateState.f117586j : 0L, (63487 & 512) != 0 ? updateState.f117587k : 0L, (63487 & 1024) != 0 ? updateState.f117588l : null, (63487 & 2048) != 0 ? updateState.f117589m : null, (63487 & 4096) != 0 ? updateState.f117590n : false, (63487 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? updateState.f117591o : 0L, (63487 & 16384) != 0 ? updateState.f117592p : null, (63487 & 32768) != 0 ? updateState.f117593q : null);
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(final PremiumState premiumState, Continuation continuation) {
                this.f117463a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.p2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SchedulePreviewViewModel.AnonymousClass7.AnonymousClass1.f(premiumState, (SchedulePreviewViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
        }

        AnonymousClass7(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f117461a;
            if (i3 == 0) {
                ResultKt.b(obj);
                StateFlow stateFlowK = SchedulePreviewViewModel.this.x1().K();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(SchedulePreviewViewModel.this);
                this.f117461a = 1;
                if (stateFlowK.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass7) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$8", f = "SchedulePreviewViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117464a;

        AnonymousClass8(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f117464a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SchedulePreviewViewModel schedulePreviewViewModel = SchedulePreviewViewModel.this;
            schedulePreviewViewModel.M1(schedulePreviewViewModel.f117406o.l().a());
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass8) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$9", f = "SchedulePreviewViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f117466a;

        AnonymousClass9(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SchedulePreviewViewModel.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f117466a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SchedulePreviewViewModel schedulePreviewViewModel = SchedulePreviewViewModel.this;
            Long lM = schedulePreviewViewModel.f117406o.M();
            schedulePreviewViewModel.O1(lM != null ? lM.longValue() : 0L);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SchedulePreviewViewModel(Application application, ProfileViewDTO profileViewDTO) {
        super(application, new SchedulePreviewViewState(null, profileViewDTO, profileViewDTO.J(), false, false, false, null, false, 0L, 0L, null, null, false, 0L, null, null, 65529, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(profileViewDTO, "profileViewDTO");
        this.f117406o = profileViewDTO;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f117407p = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f117408q = LazyKt.a(lazyThreadSafetyModeB2, new Function0<SchedulePauseHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SchedulePauseHistoryDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f117409r = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StreakPauseTracker>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakPauseTracker.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f117410s = LazyKt.a(lazyThreadSafetyModeB4, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f117411t = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f117412u = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f117413v = LazyKt.a(lazyThreadSafetyModeB7, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f117414w = LazyKt.a(lazyThreadSafetyModeB8, new Function0<JobHelperKtx>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(JobHelperKtx.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        this.f117415x = LazyKt.a(lazyThreadSafetyModeB9, new Function0<InitApplicationsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InitApplicationsUseCase.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        this.f117416y = LazyKt.a(lazyThreadSafetyModeB10, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr18, objArr19);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB11 = koinPlatformTools.b();
        final Object[] objArr20 = 0 == true ? 1 : 0;
        final Object[] objArr21 = 0 == true ? 1 : 0;
        this.f117417z = LazyKt.a(lazyThreadSafetyModeB11, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr20, objArr21);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB12 = koinPlatformTools.b();
        final Object[] objArr22 = 0 == true ? 1 : 0;
        final Object[] objArr23 = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB12, new Function0<FetchAppDataUseCase>() { // from class: cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$special$$inlined$inject$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(FetchAppDataUseCase.class), objArr22, objArr23);
            }
        });
        this.B = new PowerConnectionReceiver();
        H1();
        E1();
        G0(new AnonymousClass1(null));
        G0(new AnonymousClass2(null));
        G0(new AnonymousClass3(null));
        G0(new AnonymousClass4(null));
        G0(new AnonymousClass5(null));
        G0(new AnonymousClass6(null));
        G0(new AnonymousClass7(null));
        G0(new AnonymousClass8(null));
        G0(new AnonymousClass9(null));
        G0(new AnonymousClass10(null));
        G0(new AnonymousClass11(null));
        G0(new AnonymousClass12(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakPauseTracker A1() {
        return (StreakPauseTracker) this.f117409r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore B1() {
        return (StreakStore) this.f117410s.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore C1() {
        return (StrictModeDataStore) this.f117411t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D1(long j3) {
        Job job = this.C;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        long jC = j3 - TimeHelperExt.c();
        if (jC <= 0) {
            return;
        }
        this.C = BuildersKt__Builders_commonKt.d(B0(), null, null, new SchedulePreviewViewModel$observeLockExpiration$1(jC, this, null), 3, null);
    }

    private final void E1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SchedulePreviewViewModel$observePowerConnectionEvent$1(this, null), 3, null);
    }

    private final void G1() {
        if (!((SchedulePreviewViewState) I0()).E().g()) {
            AnswersHelper.f128199a.Y4();
            G0(new SchedulePreviewViewModel$pauseProfileFromCard$1(this, null));
        } else if (((SchedulePreviewViewState) I0()).L()) {
            G0(new SchedulePreviewViewModel$pauseProfileFromCard$2(this, null));
        } else {
            G0(new SchedulePreviewViewModel$pauseProfileFromCard$3(this, new Profile.PausedUntil.Time(TimeHelperExt.c() + TimeUnit.MINUTES.toMillis(10L)), null));
        }
    }

    private final void H1() {
        Context contextA0 = A0();
        PowerConnectionReceiver powerConnectionReceiver = this.B;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        Unit unit = Unit.f139807a;
        contextA0.registerReceiver(powerConnectionReceiver, intentFilter);
    }

    private final void I1() {
        G0(new SchedulePreviewViewModel$resumeProfileManually$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(long j3, String str) {
        Job job = this.F;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.F = BuildersKt__Builders_commonKt.d(C0(), null, null, new SchedulePreviewViewModel$startSummaryTicker$1(j3, this, str, null), 3, null);
    }

    private final void K1(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SchedulePreviewViewModel$stopManually$1(this, profileViewDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SchedulePreviewViewModel$unlockProfileByChargerConnection$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(long j3) {
        Job job = this.D;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        if (j3 <= 0) {
            return;
        }
        this.D = FlowKt.Q(FlowKt.V(FlowKt.g(TimeHelperExt.f128663a.b(j3, 1000L)), new SchedulePreviewViewModel$updatePauseCountDown$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1() {
        G0(new SchedulePreviewViewModel$updateProfileViewDTO$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(long j3) {
        Job job = this.E;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        if (j3 <= 0) {
            return;
        }
        this.E = FlowKt.Q(FlowKt.V(FlowKt.g(TimeHelperExt.f128663a.b(j3, 1000L)), new SchedulePreviewViewModel$updateTemporaryActiveCountDown$1(this, null)), B0());
    }

    public static final /* synthetic */ SchedulePreviewViewState R0(SchedulePreviewViewModel schedulePreviewViewModel) {
        return (SchedulePreviewViewState) schedulePreviewViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q1(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new SchedulePreviewViewModel$deleteProfile$1(this, profileViewDTO, null), 3, null);
    }

    private final void r1(ProfileViewDTO profileViewDTO) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new SchedulePreviewViewModel$duplicateProfile$1(this, profileViewDTO, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore s1() {
        return (CoreDataStore) this.f117412u.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f117417z.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore t1() {
        return (EventDataStore) this.f117413v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FetchAppDataUseCase u1() {
        return (FetchAppDataUseCase) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InitApplicationsUseCase v1() {
        return (InitApplicationsUseCase) this.f117415x.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JobHelperKtx w1() {
        return (JobHelperKtx) this.f117414w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 x1() {
        return (PremiumRepositoryV2) this.f117416y.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao y1() {
        return (ProfileDao) this.f117407p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SchedulePauseHistoryDao z1() {
        return (SchedulePauseHistoryDao) this.f117408q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void O0(SchedulePreviewViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, SchedulePreviewViewEvent.OnEditScheduleClicked.f117398a)) {
            G0(new SchedulePreviewViewModel$onEvent$1(this, null));
            return;
        }
        if (event instanceof SchedulePreviewViewEvent.OnProfilePauseSelected) {
            G0(new SchedulePreviewViewModel$onEvent$2(this, null));
            return;
        }
        if (event instanceof SchedulePreviewViewEvent.OnProfileDeleted) {
            G0(new SchedulePreviewViewModel$onEvent$3(this, event, null));
            return;
        }
        if (event instanceof SchedulePreviewViewEvent.OnProfileDuplicate) {
            r1(((SchedulePreviewViewEvent.OnProfileDuplicate) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, SchedulePreviewViewEvent.OnProfileResumed.f117403a)) {
            I1();
            return;
        }
        if (event instanceof SchedulePreviewViewEvent.OnProfileStoppedManually) {
            K1(((SchedulePreviewViewEvent.OnProfileStoppedManually) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, SchedulePreviewViewEvent.OnProfilePausedFromCard.f117402a)) {
            G1();
        } else if (Intrinsics.areEqual(event, SchedulePreviewViewEvent.OnProfileUpdated.f117405a)) {
            N1();
        } else {
            if (!Intrinsics.areEqual(event, SchedulePreviewViewEvent.OnDisabledByPremiumClicked.f117397a)) {
                throw new NoWhenBranchMatchedException();
            }
            G0(new SchedulePreviewViewModel$onEvent$4(this, null));
        }
    }

    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        A0().unregisterReceiver(this.B);
        super.onCleared();
    }
}
