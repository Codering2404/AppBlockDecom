package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UnlockAllAppsViewModel extends BaseStatefulViewModel<UnlockAllAppsViewState, UnlockAllAppsViewEvent, UnlockAllAppsViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f101490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f101491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f101492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Lazy f101493r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UnlockAllAppsViewModel(Application application) {
        super(application, new UnlockAllAppsViewState(null, false, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f101490o = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel$special$$inlined$inject$default$1
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
        this.f101491p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel$special$$inlined$inject$default$2
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
        this.f101492q = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f101493r = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewModel$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr6, objArr7);
            }
        });
        d1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore Y0() {
        return (CoreDataStore) this.f101493r.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileDao Z0() {
        return (ProfileDao) this.f101492q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository a1() {
        return (QuickBlockRepository) this.f101491p.getValue();
    }

    private final void c1() {
        H0(new UnlockAllAppsViewModel$performUnlock$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UnlockAllAppsViewState e1(UnlockAllAppsViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return new UnlockAllAppsViewState(null, false, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t0() {
        return (StrictModeRepository) this.f101490o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void O0(UnlockAllAppsViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof UnlockAllAppsViewEvent.ConfirmUnlock) {
            c1();
        } else if (event instanceof UnlockAllAppsViewEvent.RequestEmergencyUnlock) {
            H0(new UnlockAllAppsViewModel$onEvent$1(this, null));
        } else {
            if (!(event instanceof UnlockAllAppsViewEvent.Dismiss)) {
                throw new NoWhenBranchMatchedException();
            }
            H0(new UnlockAllAppsViewModel$onEvent$2(this, null));
        }
    }

    public final void d1() {
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnlockAllAppsViewModel.e1((UnlockAllAppsViewState) obj);
            }
        });
        G0(new UnlockAllAppsViewModel$refreshBlockingState$2(this, null));
    }
}
