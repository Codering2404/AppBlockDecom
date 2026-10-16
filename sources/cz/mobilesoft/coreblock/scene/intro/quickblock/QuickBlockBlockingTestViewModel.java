package cz.mobilesoft.coreblock.scene.intro.quickblock;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewEvent;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
public final class QuickBlockBlockingTestViewModel extends BaseStatefulViewModel<QuickBlockBlockingTestViewState, QuickBlockBlockingTestViewEvent, QuickBlockBlockingTestViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Lazy f104755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Lazy f104756p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QuickBlockBlockingTestViewModel(Application application) {
        super(application, new QuickBlockBlockingTestViewState(null, null, null, 7, null));
        Intrinsics.checkNotNullParameter(application, "application");
        final Qualifier qualifier = null;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f104755o = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f104756p = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.scene.intro.quickblock.QuickBlockBlockingTestViewModel$special$$inlined$inject$default$2
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore V0() {
        return (CoreDataStore) this.f104755o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository W0() {
        return (QuickBlockRepository) this.f104756p.getValue();
    }

    private final void Y0() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new QuickBlockBlockingTestViewModel$updateAppList$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public void O0(QuickBlockBlockingTestViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, QuickBlockBlockingTestViewEvent.OnResume.f104752a)) {
            Y0();
        } else if (Intrinsics.areEqual(event, QuickBlockBlockingTestViewEvent.OnTestStarted.f104754a)) {
            H0(new QuickBlockBlockingTestViewModel$onEvent$1(this, null));
        } else {
            if (!Intrinsics.areEqual(event, QuickBlockBlockingTestViewEvent.OnTestSkipped.f104753a)) {
                throw new NoWhenBranchMatchedException();
            }
            H0(new QuickBlockBlockingTestViewModel$onEvent$2(this, null));
        }
    }
}
