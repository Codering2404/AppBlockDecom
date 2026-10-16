package cz.mobilesoft.coreblock.scene.app_feel;

import android.content.pm.PackageManager;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.util.PackageManagerHelperKt;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class AppFeelViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f98618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f98619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f98620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PremiumState f98621d;

    public AppFeelViewState(boolean z2, List appList, List labeledAppList, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        Intrinsics.checkNotNullParameter(labeledAppList, "labeledAppList");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f98618a = z2;
        this.f98619b = appList;
        this.f98620c = labeledAppList;
        this.f98621d = premiumState;
    }

    public static /* synthetic */ AppFeelViewState b(AppFeelViewState appFeelViewState, boolean z2, List list, List list2, PremiumState premiumState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = appFeelViewState.f98618a;
        }
        if ((i3 & 2) != 0) {
            list = appFeelViewState.f98619b;
        }
        if ((i3 & 4) != 0) {
            list2 = appFeelViewState.f98620c;
        }
        if ((i3 & 8) != 0) {
            premiumState = appFeelViewState.f98621d;
        }
        return appFeelViewState.a(z2, list, list2, premiumState);
    }

    public final AppFeelViewState a(boolean z2, List appList, List labeledAppList, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        Intrinsics.checkNotNullParameter(labeledAppList, "labeledAppList");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return new AppFeelViewState(z2, appList, labeledAppList, premiumState);
    }

    public final Pair c(PackageManager packageManager, String packageName) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return PackageManagerHelperKt.a(packageManager, packageName);
    }

    public final List d() {
        return this.f98619b;
    }

    public final List e() {
        return this.f98620c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppFeelViewState)) {
            return false;
        }
        AppFeelViewState appFeelViewState = (AppFeelViewState) obj;
        return this.f98618a == appFeelViewState.f98618a && Intrinsics.areEqual(this.f98619b, appFeelViewState.f98619b) && Intrinsics.areEqual(this.f98620c, appFeelViewState.f98620c) && Intrinsics.areEqual(this.f98621d, appFeelViewState.f98621d);
    }

    public final PremiumState f() {
        return this.f98621d;
    }

    public final List g() {
        if (this.f98618a) {
            return CollectionsKt.take(CollectionsKt.sortedWith(this.f98619b, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState$special$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ComparisonsKt.d(Integer.valueOf(((AggregatedItemRecord) obj2).c()), Integer.valueOf(((AggregatedItemRecord) obj).c()));
                }
            }), 5);
        }
        List list = this.f98619b;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) obj;
            List list2 = this.f98620c;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((Pair) it.next()).e(), aggregatedItemRecord.e())) {
                        break;
                    }
                }
            }
            arrayList.add(obj);
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState$special$$inlined$sortedByDescending$2
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ComparisonsKt.d(Integer.valueOf(((AggregatedItemRecord) obj3).c()), Integer.valueOf(((AggregatedItemRecord) obj2).c()));
            }
        });
    }

    public final boolean h() {
        return this.f98618a;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f98618a) * 31) + this.f98619b.hashCode()) * 31) + this.f98620c.hashCode()) * 31) + this.f98621d.hashCode();
    }

    public String toString() {
        return "AppFeelViewState(isForOnboarding=" + this.f98618a + ", appList=" + this.f98619b + ", labeledAppList=" + this.f98620c + ", premiumState=" + this.f98621d + sKeKFMqmvNzY.KMAeAtlZ;
    }

    public /* synthetic */ AppFeelViewState(boolean z2, List list, List list2, PremiumState premiumState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? new ArrayList() : list2, (i3 & 8) != 0 ? PremiumState.None.INSTANCE : premiumState);
    }
}
