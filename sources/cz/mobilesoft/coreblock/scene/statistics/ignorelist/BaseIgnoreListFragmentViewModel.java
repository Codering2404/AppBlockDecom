package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.app.Application;
import androidx.lifecycle.LiveData;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BaseIgnoreListFragmentViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f119881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f119882j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseIgnoreListFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f119881i = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$special$$inlined$inject$default$1
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
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f119882j = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr2, objArr3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object N0(java.lang.String r9, cz.mobilesoft.coreblock.dto.UsageAccess.Type r10, kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r11 instanceof cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$getItemSourceType$1
            if (r0 == 0) goto L14
            r0 = r11
            cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$getItemSourceType$1 r0 = (cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$getItemSourceType$1) r0
            int r1 = r0.f119889f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f119889f = r1
        L12:
            r5 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$getItemSourceType$1 r0 = new cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel$getItemSourceType$1
            r0.<init>(r8, r11)
            goto L12
        L1a:
            java.lang.Object r11 = r5.f119887c
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f119889f
            r2 = 1
            if (r1 == 0) goto L3b
            if (r1 != r2) goto L33
            java.lang.Object r9 = r5.f119886b
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r9 = (cz.mobilesoft.coreblock.dto.UsageAccess.Type) r9
            java.lang.Object r9 = r5.f119885a
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r11)
            goto L5c
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r1 = r8.M0()
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r5.f119885a = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r5.f119886b = r11
            r5.f119889f = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r9
            r3 = r10
            java.lang.Object r11 = cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao.W(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L5c
            return r0
        L5c:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r11 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r11
            if (r11 == 0) goto L68
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r9 = r11.b()
            if (r9 != 0) goto L67
            goto L68
        L67:
            return r9
        L68:
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r9 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel.N0(java.lang.String, cz.mobilesoft.coreblock.dto.UsageAccess$Type, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean J0() {
        return ((Boolean) BuildersKt__BuildersKt.b(null, new BaseIgnoreListFragmentViewModel$areAllDefaultIgnoredItemsActive$1(this, null), 1, null)).booleanValue();
    }

    protected final ApplicationDao K0() {
        return (ApplicationDao) this.f119882j.getValue();
    }

    public abstract LiveData L0();

    protected final IgnoredStatisticsItemDao M0() {
        return (IgnoredStatisticsItemDao) this.f119881i.getValue();
    }

    public final void O0(Collection items) {
        Intrinsics.checkNotNullParameter(items, "items");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseIgnoreListFragmentViewModel$ignoreStatisticsItems$1(items, this, null), 3, null);
    }

    public final void P0(String name, UsageAccess.Type type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseIgnoreListFragmentViewModel$unignoreStatisticsItem$1(this, name, type, null), 3, null);
    }

    public final void Q0(Collection names, UsageAccess.Type type) {
        Intrinsics.checkNotNullParameter(names, "names");
        Intrinsics.checkNotNullParameter(type, "type");
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BaseIgnoreListFragmentViewModel$unignoreStatisticsItems$1(this, names, type, null), 3, null);
    }

    public abstract void R0();
}
