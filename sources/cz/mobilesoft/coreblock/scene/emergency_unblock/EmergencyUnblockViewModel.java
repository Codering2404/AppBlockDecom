package cz.mobilesoft.coreblock.scene.emergency_unblock;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewEvent;
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.EmergencyUnblockingEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockViewModel extends BaseStatefulViewModel<EmergencyUnblockViewState, EmergencyUnblockViewEvent, EmergencyUnblockViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f101762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f101763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f101764q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f101765r;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$1", f = "EmergencyUnblockViewModel.kt", l = {32, 34, 35}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f101766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f101767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f101768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f101769d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f101770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f101771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f101772h;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final EmergencyUnblockViewState q(List list, StrictModeAccessMethod strictModeAccessMethod, long j3, long j4, long j5, long j6, EmergencyUnblockViewState emergencyUnblockViewState) {
            List list2 = list;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                long jA = ((EmergencyUnblockingEntity) obj).a();
                if (j3 <= jA && jA < j4) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                long jA2 = ((EmergencyUnblockingEntity) obj2).a();
                if (j5 <= jA2 && jA2 < j6) {
                    arrayList2.add(obj2);
                }
            }
            return EmergencyUnblockViewState.b(emergencyUnblockViewState, arrayList, false, arrayList2, strictModeAccessMethod, 2, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EmergencyUnblockViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x00ea  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 269
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$2", f = "EmergencyUnblockViewModel.kt", l = {54}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101774a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ EmergencyUnblockViewModel f101776a;

            AnonymousClass1(EmergencyUnblockViewModel emergencyUnblockViewModel) {
                this.f101776a = emergencyUnblockViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final EmergencyUnblockViewState f(boolean z2, EmergencyUnblockViewState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return EmergencyUnblockViewState.b(updateState, null, z2, null, null, 13, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f101776a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EmergencyUnblockViewModel.AnonymousClass2.AnonymousClass1.f(z2, (EmergencyUnblockViewState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return EmergencyUnblockViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101774a;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowZ0 = EmergencyUnblockViewModel.this.W0().z0();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(EmergencyUnblockViewModel.this);
                this.f101774a = 1;
                if (flowZ0.collect(anonymousClass1, this) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmergencyUnblockViewModel(Application application) {
        super(application, new EmergencyUnblockViewState(null, false, null, null, 15, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f101762o = LazyKt.a(lazyThreadSafetyModeB, new Function0<EmergencyUnblockingDao>() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EmergencyUnblockingDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f101763p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f101764q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f101765r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr6, objArr7);
            }
        });
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore W0() {
        return (DevDataStore) this.f101765r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EmergencyUnblockingDao X0() {
        return (EmergencyUnblockingDao) this.f101762o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore Y0() {
        return (StrictModeDataStore) this.f101764q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f101763p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public void O0(EmergencyUnblockViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, EmergencyUnblockViewEvent.OnEmergencyUnblockClicked.f101761a)) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new EmergencyUnblockViewModel$onEvent$1(this, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(event, EmergencyUnblockViewEvent.OnEmergencyUnblockCanceled.f101760a)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.d(C0(), null, null, new EmergencyUnblockViewModel$onEvent$2(this, null), 3, null);
        }
    }
}
