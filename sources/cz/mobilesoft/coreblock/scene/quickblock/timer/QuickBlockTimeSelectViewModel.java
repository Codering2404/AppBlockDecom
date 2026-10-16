package cz.mobilesoft.coreblock.scene.quickblock.timer;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class QuickBlockTimeSelectViewModel extends BaseStatefulViewModel<QuickBlockTimeSelectViewState, QuickBlockTimeSelectViewEvent, QuickBlockTimeSelectViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f114268o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f114269p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f114270q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f114271r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuickBlockTimeSelectViewModel(Application application, List history) {
        super(application, new QuickBlockTimeSelectViewState(history));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(history, "history");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f114268o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f114269p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f114270q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockTimerHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockTimerHistoryDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f114271r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), objArr6, objArr7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z0(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.Z0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(long j3) {
        G0(new QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1(this, j3, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConsentHelper b1() {
        return (ConsentHelper) this.f114271r.getValue();
    }

    private final QuickBlockRepository c1() {
        return (QuickBlockRepository) this.f114269p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockTimerHistoryDao d1() {
        return (QuickBlockTimerHistoryDao) this.f114270q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimeSelectViewState g1(QuickBlockTimeSelectViewEvent quickBlockTimeSelectViewEvent, QuickBlockTimeSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return QuickBlockTimeSelectViewState.b(updateState, 0L, null, false, ((QuickBlockTimeSelectViewEvent.TimePickerTypeSelected) quickBlockTimeSelectViewEvent).a(), null, 23, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final QuickBlockTimeSelectViewState h1(QuickBlockTimeSelectViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return QuickBlockTimeSelectViewState.b(updateState, 0L, null, false, QuickBlockTimeSelectViewState.TimePickerType.Custom, null, 23, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i1(long j3) {
        c1().M(Long.valueOf(TimeHelperExt.f128663a.f() + j3));
        G0(new QuickBlockTimeSelectViewModel$startBlocking$1(j3, this, null));
        G0(new QuickBlockTimeSelectViewModel$startBlocking$2(this, null));
    }

    private final StrictModeRepository t0() {
        return (StrictModeRepository) this.f114268o.getValue();
    }

    public final boolean e1() {
        return t0().n();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] */
    public void O0(final QuickBlockTimeSelectViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QuickBlockTimeSelectViewEvent.TimePickerTypeSelected) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QuickBlockTimeSelectViewModel.g1(event, (QuickBlockTimeSelectViewState) obj);
                }
            });
            if (((QuickBlockTimeSelectViewEvent.TimePickerTypeSelected) event).a() != QuickBlockTimeSelectViewState.TimePickerType.Custom) {
                G0(new QuickBlockTimeSelectViewModel$onEvent$2(this, event, null));
                return;
            }
            return;
        }
        if (event instanceof QuickBlockTimeSelectViewEvent.TimeUpdated) {
            QuickBlockTimeSelectViewState quickBlockTimeSelectViewState = (QuickBlockTimeSelectViewState) I0();
            if (quickBlockTimeSelectViewState.d() == QuickBlockTimeSelectViewState.TimePickerType.Custom) {
                return;
            }
            Long time = quickBlockTimeSelectViewState.d().getTime();
            long jA = ((QuickBlockTimeSelectViewEvent.TimeUpdated) event).a();
            if (time != null && time.longValue() == jA) {
                return;
            }
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.s
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return QuickBlockTimeSelectViewModel.h1((QuickBlockTimeSelectViewState) obj);
                }
            });
            return;
        }
        if (event instanceof QuickBlockTimeSelectViewEvent.OnConfirmClicked) {
            if (e1()) {
                G0(new QuickBlockTimeSelectViewModel$onEvent$4(this, null));
                return;
            } else {
                a1(((QuickBlockTimeSelectViewEvent.OnConfirmClicked) event).a());
                return;
            }
        }
        if (event instanceof QuickBlockTimeSelectViewEvent.OnStrictModeConfirmedClicked) {
            G0(new QuickBlockTimeSelectViewModel$onEvent$5(this, event, null));
        } else {
            if (!(event instanceof QuickBlockTimeSelectViewEvent.OnPermissionsGranted)) {
                throw new NoWhenBranchMatchedException();
            }
            i1(((QuickBlockTimeSelectViewEvent.OnPermissionsGranted) event).a());
        }
    }
}
