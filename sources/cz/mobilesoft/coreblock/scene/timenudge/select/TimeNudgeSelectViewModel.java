package cz.mobilesoft.coreblock.scene.timenudge.select;

import android.app.Application;
import com.google.common.cache.LSNn.vfptEEmYY;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class TimeNudgeSelectViewModel extends BaseSelectionViewModel {
    private final Lazy D;
    private final boolean E;

    public static final /* synthetic */ BaseSelectionViewState N2(TimeNudgeSelectViewModel timeNudgeSelectViewModel) {
        return (BaseSelectionViewState) timeNudgeSelectViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore X1() {
        return (CoreMultiProcessDataStore) this.D.getValue();
    }

    @Override // cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel
    public void B2(boolean z2) {
        G0(new TimeNudgeSelectViewModel$onSave$1(this, null));
    }

    @Override // cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel
    public boolean p2() {
        return this.E;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TimeNudgeSelectViewModel(Application application, BaseSelectionViewModel.ApplicationWebsiteSelectDTO appsWebsSelectDTO, InitApplicationsUseCase initApplicationsUseCase) {
        super(application, appsWebsSelectDTO, initApplicationsUseCase);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(appsWebsSelectDTO, "appsWebsSelectDTO");
        Intrinsics.checkNotNullParameter(initApplicationsUseCase, vfptEEmYY.VhqINE);
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.D = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.timenudge.select.TimeNudgeSelectViewModel$special$$inlined$inject$default$1
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
        this.E = true;
    }
}
