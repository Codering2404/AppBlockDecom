package cz.mobilesoft.coreblock.scene.schedule.condition.time;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.WifiDTO;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.ImmutableSet;

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
public final class WifiConfigurationViewState implements ConditionConfiguration<ConditionDTO.WifisDTO> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelState f115795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f115798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImmutableSet f115799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableList f115800f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImmutableList f115801g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f115802h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f115803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f115804j;

    public WifiConfigurationViewState(ViewModelState state, boolean z2, boolean z3, String query, ImmutableSet selectedSsids, ImmutableList filteredWifis, ImmutableList allWifis, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(selectedSsids, "selectedSsids");
        Intrinsics.checkNotNullParameter(filteredWifis, "filteredWifis");
        Intrinsics.checkNotNullParameter(allWifis, "allWifis");
        this.f115795a = state;
        this.f115796b = z2;
        this.f115797c = z3;
        this.f115798d = query;
        this.f115799e = selectedSsids;
        this.f115800f = filteredWifis;
        this.f115801g = allWifis;
        this.f115802h = z4;
        this.f115803i = z5;
        this.f115804j = z6;
    }

    public static /* synthetic */ WifiConfigurationViewState d(WifiConfigurationViewState wifiConfigurationViewState, ViewModelState viewModelState, boolean z2, boolean z3, String str, ImmutableSet immutableSet, ImmutableList immutableList, ImmutableList immutableList2, boolean z4, boolean z5, boolean z6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            viewModelState = wifiConfigurationViewState.f115795a;
        }
        if ((i3 & 2) != 0) {
            z2 = wifiConfigurationViewState.f115796b;
        }
        if ((i3 & 4) != 0) {
            z3 = wifiConfigurationViewState.f115797c;
        }
        if ((i3 & 8) != 0) {
            str = wifiConfigurationViewState.f115798d;
        }
        if ((i3 & 16) != 0) {
            immutableSet = wifiConfigurationViewState.f115799e;
        }
        if ((i3 & 32) != 0) {
            immutableList = wifiConfigurationViewState.f115800f;
        }
        if ((i3 & 64) != 0) {
            immutableList2 = wifiConfigurationViewState.f115801g;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z4 = wifiConfigurationViewState.f115802h;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z5 = wifiConfigurationViewState.f115803i;
        }
        if ((i3 & 512) != 0) {
            z6 = wifiConfigurationViewState.f115804j;
        }
        boolean z7 = z5;
        boolean z8 = z6;
        ImmutableList immutableList3 = immutableList2;
        boolean z9 = z4;
        ImmutableSet immutableSet2 = immutableSet;
        ImmutableList immutableList4 = immutableList;
        return wifiConfigurationViewState.c(viewModelState, z2, z3, str, immutableSet2, immutableList4, immutableList3, z9, z7, z8);
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    public boolean a() {
        return !this.f115799e.isEmpty();
    }

    public final WifiConfigurationViewState c(ViewModelState state, boolean z2, boolean z3, String query, ImmutableSet selectedSsids, ImmutableList filteredWifis, ImmutableList allWifis, boolean z4, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(selectedSsids, "selectedSsids");
        Intrinsics.checkNotNullParameter(filteredWifis, "filteredWifis");
        Intrinsics.checkNotNullParameter(allWifis, "allWifis");
        return new WifiConfigurationViewState(state, z2, z3, query, selectedSsids, filteredWifis, allWifis, z4, z5, z6);
    }

    public final ImmutableList e() {
        return this.f115801g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WifiConfigurationViewState)) {
            return false;
        }
        WifiConfigurationViewState wifiConfigurationViewState = (WifiConfigurationViewState) obj;
        return Intrinsics.areEqual(this.f115795a, wifiConfigurationViewState.f115795a) && this.f115796b == wifiConfigurationViewState.f115796b && this.f115797c == wifiConfigurationViewState.f115797c && Intrinsics.areEqual(this.f115798d, wifiConfigurationViewState.f115798d) && Intrinsics.areEqual(this.f115799e, wifiConfigurationViewState.f115799e) && Intrinsics.areEqual(this.f115800f, wifiConfigurationViewState.f115800f) && Intrinsics.areEqual(this.f115801g, wifiConfigurationViewState.f115801g) && this.f115802h == wifiConfigurationViewState.f115802h && this.f115803i == wifiConfigurationViewState.f115803i && this.f115804j == wifiConfigurationViewState.f115804j;
    }

    @Override // cz.mobilesoft.coreblock.scene.schedule.condition.time.ConditionConfiguration
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConditionDTO.WifisDTO b() {
        ImmutableSet immutableSet = this.f115799e;
        ArrayList arrayList = new ArrayList(this.f115799e.size());
        Iterator<E> it = immutableSet.iterator();
        while (it.hasNext()) {
            arrayList.add(new WifiDTO((String) it.next()));
        }
        return new ConditionDTO.WifisDTO(arrayList, null, 2, null);
    }

    public final ImmutableList g() {
        return this.f115800f;
    }

    public final boolean h() {
        return this.f115803i;
    }

    public int hashCode() {
        return (((((((((((((((((this.f115795a.hashCode() * 31) + Boolean.hashCode(this.f115796b)) * 31) + Boolean.hashCode(this.f115797c)) * 31) + this.f115798d.hashCode()) * 31) + this.f115799e.hashCode()) * 31) + this.f115800f.hashCode()) * 31) + this.f115801g.hashCode()) * 31) + Boolean.hashCode(this.f115802h)) * 31) + Boolean.hashCode(this.f115803i)) * 31) + Boolean.hashCode(this.f115804j);
    }

    public final boolean i() {
        return this.f115802h;
    }

    public final String j() {
        return this.f115798d;
    }

    public final ImmutableSet k() {
        return this.f115799e;
    }

    public final ViewModelState l() {
        return this.f115795a;
    }

    public final boolean m() {
        return this.f115804j;
    }

    public final boolean n() {
        return this.f115797c;
    }

    public final boolean o() {
        return this.f115796b;
    }

    public String toString() {
        return "WifiConfigurationViewState(state=" + this.f115795a + ", isSearchOpen=" + this.f115796b + ", isScanning=" + this.f115797c + ", query=" + this.f115798d + ", selectedSsids=" + this.f115799e + ", filteredWifis=" + this.f115800f + ", allWifis=" + this.f115801g + ", permissionsAlreadyRequested=" + this.f115802h + ", locationServicesAlreadyChecked=" + this.f115803i + ", wifiSelectionEnabled=" + this.f115804j + ")";
    }

    public /* synthetic */ WifiConfigurationViewState(ViewModelState viewModelState, boolean z2, boolean z3, String str, ImmutableSet immutableSet, ImmutableList immutableList, ImmutableList immutableList2, boolean z4, boolean z5, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Loading.f127895a : viewModelState, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? ExtensionsKt.c() : immutableSet, (i3 & 32) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 64) != 0 ? ExtensionsKt.a() : immutableList2, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z4, (i3 & Function.MAX_NARGS) != 0 ? false : z5, (i3 & 512) != 0 ? true : z6);
    }
}
