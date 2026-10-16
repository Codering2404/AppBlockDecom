package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionsManager;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
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
public final class TimeNudgeSettingsViewModel extends BaseStatefulViewModel<TimeNudgeSettingsViewState, TimeNudgeSettingsViewEvent, TimeNudgeSettingsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f110283o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f110284p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f110285q;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$1", f = "TimeNudgeSettingsViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, Set<? extends String>, Continuation<? super Pair<? extends Boolean, ? extends Set<? extends String>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f110286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f110287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f110288c;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        public final Object h(boolean z2, Set set, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f110287b = z2;
            anonymousClass1.f110288c = set;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h(((Boolean) obj).booleanValue(), (Set) obj2, (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z2 = this.f110287b;
            Set set = (Set) this.f110288c;
            IntrinsicsKt.f();
            if (this.f110286a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return TuplesKt.a(Boxing.a(z2), set);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TimeNudgeSettingsViewState f(boolean z2, Set set, TimeNudgeSettingsViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return TimeNudgeSettingsViewState.b(updateState, z2, CollectionsKt.sorted(set), null, false, 12, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.Pair r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2$emit$1 r0 = (cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2$emit$1) r0
                int r1 = r0.f110294f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f110294f = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2$emit$1 r0 = new cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$2$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f110292c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f110294f
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                boolean r7 = r0.f110290a
                java.lang.Object r0 = r0.f110291b
                java.util.Set r0 = (java.util.Set) r0
                kotlin.ResultKt.b(r8)
                goto L68
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                kotlin.ResultKt.b(r8)
                java.lang.Object r8 = r7.a()
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                java.lang.Object r7 = r7.b()
                java.util.Set r7 = (java.util.Set) r7
                if (r7 != 0) goto L6d
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r2 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.this
                cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase r2 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.T0(r2)
                cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params r4 = cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params.f127634a
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                r0.f110291b = r7
                r0.f110290a = r8
                r0.f110294f = r3
                java.lang.Object r7 = r2.l(r4, r0)
                if (r7 != r1) goto L65
                return r1
            L65:
                r5 = r8
                r8 = r7
                r7 = r5
            L68:
                java.util.Set r8 = (java.util.Set) r8
                r5 = r8
                r8 = r7
                r7 = r5
            L6d:
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel r0 = cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.this
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.x r1 = new cz.mobilesoft.coreblock.scene.more.settings.timenudge.x
                r1.<init>()
                cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.X0(r0, r1)
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel.AnonymousClass2.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeNudgeSettingsViewModel(Application app) {
        super(app, new TimeNudgeSettingsViewState(false, null, null, false, 15, null));
        Intrinsics.checkNotNullParameter(app, "app");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f110283o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f110284p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f110285q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GetTimeNudgeAppsUseCase>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTimeNudgeAppsUseCase.class), objArr4, objArr5);
            }
        });
        e1();
        FlowExtKt.i(FlowKt.m(Y0().t0(), Y0().w0(), new AnonymousClass1(null)), C0(), new AnonymousClass2());
    }

    public static final /* synthetic */ TimeNudgeSettingsViewState R0(TimeNudgeSettingsViewModel timeNudgeSettingsViewModel) {
        return (TimeNudgeSettingsViewState) timeNudgeSettingsViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore Y0() {
        return (CoreMultiProcessDataStore) this.f110283o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetTimeNudgeAppsUseCase Z0() {
        return (GetTimeNudgeAppsUseCase) this.f110285q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatisticsDataStore a1() {
        return (StatisticsDataStore) this.f110284p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List b1() {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (!PermissionHelper.k(A0())) {
            listCreateListBuilder.add(new PermissionDTO(new Permission.USAGE_ACCESS(null, 1, null), false, false, 6, null));
        }
        if (!PermissionsManager.f129021a.C(A0())) {
            listCreateListBuilder.add(new PermissionDTO(Permission.ALARM_EXACT.f96997d, false, false, 6, null));
        }
        if (!PermissionHelper.o(A0())) {
            listCreateListBuilder.add(new PermissionDTO(new Permission.POST_NOTIFICATIONS(true), false, false, 6, null));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    private final void c1() {
        G0(new TimeNudgeSettingsViewModel$onEnabledClicked$1(this, !((TimeNudgeSettingsViewState) I0()).f(), null));
    }

    private final void e1() {
        G0(new TimeNudgeSettingsViewModel$refreshEnvironment$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void O0(TimeNudgeSettingsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, TimeNudgeSettingsViewEvent.OnEnabledClick.f110281a)) {
            c1();
        } else if (Intrinsics.areEqual(event, TimeNudgeSettingsViewEvent.OnAppsClick.f110280a)) {
            G0(new TimeNudgeSettingsViewModel$onEvent$1(this, null));
        } else {
            if (!Intrinsics.areEqual(event, TimeNudgeSettingsViewEvent.OnResumed.f110282a)) {
                throw new NoWhenBranchMatchedException();
            }
            e1();
        }
    }
}
