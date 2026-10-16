package cz.mobilesoft.coreblock.scene.insights.settings;

import cz.mobilesoft.coreblock.base.ViewState;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class ExcludedAppsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f103465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f103466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f103467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f103468d;

    public ExcludedAppsViewState(List ignoredItemsCustom, List ignoredItemsDefault, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(ignoredItemsCustom, "ignoredItemsCustom");
        Intrinsics.checkNotNullParameter(ignoredItemsDefault, "ignoredItemsDefault");
        this.f103465a = ignoredItemsCustom;
        this.f103466b = ignoredItemsDefault;
        this.f103467c = i3;
        this.f103468d = z2;
    }

    public static /* synthetic */ ExcludedAppsViewState b(ExcludedAppsViewState excludedAppsViewState, List list, List list2, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = excludedAppsViewState.f103465a;
        }
        if ((i4 & 2) != 0) {
            list2 = excludedAppsViewState.f103466b;
        }
        if ((i4 & 4) != 0) {
            i3 = excludedAppsViewState.f103467c;
        }
        if ((i4 & 8) != 0) {
            z2 = excludedAppsViewState.f103468d;
        }
        return excludedAppsViewState.a(list, list2, i3, z2);
    }

    public final ExcludedAppsViewState a(List ignoredItemsCustom, List ignoredItemsDefault, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(ignoredItemsCustom, "ignoredItemsCustom");
        Intrinsics.checkNotNullParameter(ignoredItemsDefault, "ignoredItemsDefault");
        return new ExcludedAppsViewState(ignoredItemsCustom, ignoredItemsDefault, i3, z2);
    }

    public final List c() {
        return this.f103465a;
    }

    public final List d() {
        return this.f103466b;
    }

    public final int e() {
        return this.f103467c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExcludedAppsViewState)) {
            return false;
        }
        ExcludedAppsViewState excludedAppsViewState = (ExcludedAppsViewState) obj;
        return Intrinsics.areEqual(this.f103465a, excludedAppsViewState.f103465a) && Intrinsics.areEqual(this.f103466b, excludedAppsViewState.f103466b) && this.f103467c == excludedAppsViewState.f103467c && this.f103468d == excludedAppsViewState.f103468d;
    }

    public final boolean f() {
        return this.f103468d;
    }

    public int hashCode() {
        return (((((this.f103465a.hashCode() * 31) + this.f103466b.hashCode()) * 31) + Integer.hashCode(this.f103467c)) * 31) + Boolean.hashCode(this.f103468d);
    }

    public String toString() {
        return "ExcludedAppsViewState(ignoredItemsCustom=" + this.f103465a + ", ignoredItemsDefault=" + this.f103466b + ", selectedTabIndex=" + this.f103467c + ", isSubscriber=" + this.f103468d + ")";
    }

    public /* synthetic */ ExcludedAppsViewState(List list, List list2, int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? CollectionsKt.emptyList() : list, (i4 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? true : z2);
    }
}
