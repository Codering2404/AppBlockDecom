package cz.mobilesoft.coreblock.scene.more.changelog;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ChangelogViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f106963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f106964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f106965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PremiumState f106966d;

    public ChangelogViewState(boolean z2, List versions, Set expandedVersions, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        Intrinsics.checkNotNullParameter(expandedVersions, "expandedVersions");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f106963a = z2;
        this.f106964b = versions;
        this.f106965c = expandedVersions;
        this.f106966d = premiumState;
    }

    public static /* synthetic */ ChangelogViewState b(ChangelogViewState changelogViewState, boolean z2, List list, Set set, PremiumState premiumState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = changelogViewState.f106963a;
        }
        if ((i3 & 2) != 0) {
            list = changelogViewState.f106964b;
        }
        if ((i3 & 4) != 0) {
            set = changelogViewState.f106965c;
        }
        if ((i3 & 8) != 0) {
            premiumState = changelogViewState.f106966d;
        }
        return changelogViewState.a(z2, list, set, premiumState);
    }

    public final ChangelogViewState a(boolean z2, List versions, Set expandedVersions, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        Intrinsics.checkNotNullParameter(expandedVersions, "expandedVersions");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return new ChangelogViewState(z2, versions, expandedVersions, premiumState);
    }

    public final Set c() {
        return this.f106965c;
    }

    public final PremiumState d() {
        return this.f106966d;
    }

    public final List e() {
        return this.f106964b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChangelogViewState)) {
            return false;
        }
        ChangelogViewState changelogViewState = (ChangelogViewState) obj;
        return this.f106963a == changelogViewState.f106963a && Intrinsics.areEqual(this.f106964b, changelogViewState.f106964b) && Intrinsics.areEqual(this.f106965c, changelogViewState.f106965c) && Intrinsics.areEqual(this.f106966d, changelogViewState.f106966d);
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.f106963a) * 31) + this.f106964b.hashCode()) * 31) + this.f106965c.hashCode()) * 31) + this.f106966d.hashCode();
    }

    public String toString() {
        return "ChangelogViewState(loading=" + this.f106963a + ", versions=" + this.f106964b + ", expandedVersions=" + this.f106965c + ", premiumState=" + this.f106966d + ")";
    }

    public /* synthetic */ ChangelogViewState(boolean z2, List list, Set set, PremiumState premiumState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? SetsKt.emptySet() : set, (i3 & 8) != 0 ? PremiumState.None.INSTANCE : premiumState);
    }
}
