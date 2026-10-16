package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
public final class DefaultApplicationSelectFragmentViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f119921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList f119922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableLiveData f119923k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DefaultApplicationSelectFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119921i = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.DefaultApplicationSelectFragmentViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), qualifier, objArr);
            }
        });
        this.f119922j = new ArrayList();
        this.f119923k = new MutableLiveData(L0());
    }

    private final List L0() {
        return (List) BuildersKt__BuildersKt.b(null, new DefaultApplicationSelectFragmentViewModel$getIgnoredDefaultStatisticsApplications$1(this, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IgnoredStatisticsItemDao M0() {
        return (IgnoredStatisticsItemDao) this.f119921i.getValue();
    }

    public final boolean J0() {
        return ((Boolean) BuildersKt__BuildersKt.b(null, new DefaultApplicationSelectFragmentViewModel$areAllDefaultIgnoredItemsActive$1(this, null), 1, null)).booleanValue();
    }

    public final LiveData K0() {
        return this.f119923k;
    }

    public final ArrayList N0() {
        return this.f119922j;
    }

    public final void O0(ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f119922j = arrayList;
    }

    public final void P0(boolean z2) {
        this.f119922j.clear();
        if (z2) {
            BuildersKt__BuildersKt.b(null, new DefaultApplicationSelectFragmentViewModel$updateSelectedDefaultApplicationsNames$1(this, null), 1, null);
        }
    }
}
