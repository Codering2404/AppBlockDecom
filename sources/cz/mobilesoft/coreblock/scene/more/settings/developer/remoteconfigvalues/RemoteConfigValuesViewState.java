package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import cz.mobilesoft.coreblock.base.ViewState;
import d.qFm.sECyKyO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class RemoteConfigValuesViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f109302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f109303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f109304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableList f109305d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImmutableList f109306f;

    public RemoteConfigValuesViewState(boolean z2, String str, String searchQuery, ImmutableList remoteConfigValues, ImmutableList filteredRemoteConfigValues) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(remoteConfigValues, "remoteConfigValues");
        Intrinsics.checkNotNullParameter(filteredRemoteConfigValues, "filteredRemoteConfigValues");
        this.f109302a = z2;
        this.f109303b = str;
        this.f109304c = searchQuery;
        this.f109305d = remoteConfigValues;
        this.f109306f = filteredRemoteConfigValues;
    }

    public static /* synthetic */ RemoteConfigValuesViewState b(RemoteConfigValuesViewState remoteConfigValuesViewState, boolean z2, String str, String str2, ImmutableList immutableList, ImmutableList immutableList2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = remoteConfigValuesViewState.f109302a;
        }
        if ((i3 & 2) != 0) {
            str = remoteConfigValuesViewState.f109303b;
        }
        if ((i3 & 4) != 0) {
            str2 = remoteConfigValuesViewState.f109304c;
        }
        if ((i3 & 8) != 0) {
            immutableList = remoteConfigValuesViewState.f109305d;
        }
        if ((i3 & 16) != 0) {
            immutableList2 = remoteConfigValuesViewState.f109306f;
        }
        ImmutableList immutableList3 = immutableList2;
        String str3 = str2;
        return remoteConfigValuesViewState.a(z2, str, str3, immutableList, immutableList3);
    }

    public final RemoteConfigValuesViewState a(boolean z2, String str, String searchQuery, ImmutableList remoteConfigValues, ImmutableList filteredRemoteConfigValues) {
        Intrinsics.checkNotNullParameter(searchQuery, "searchQuery");
        Intrinsics.checkNotNullParameter(remoteConfigValues, "remoteConfigValues");
        Intrinsics.checkNotNullParameter(filteredRemoteConfigValues, "filteredRemoteConfigValues");
        return new RemoteConfigValuesViewState(z2, str, searchQuery, remoteConfigValues, filteredRemoteConfigValues);
    }

    public final String c() {
        return this.f109303b;
    }

    public final ImmutableList d() {
        return this.f109306f;
    }

    public final ImmutableList e() {
        return this.f109305d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteConfigValuesViewState)) {
            return false;
        }
        RemoteConfigValuesViewState remoteConfigValuesViewState = (RemoteConfigValuesViewState) obj;
        return this.f109302a == remoteConfigValuesViewState.f109302a && Intrinsics.areEqual(this.f109303b, remoteConfigValuesViewState.f109303b) && Intrinsics.areEqual(this.f109304c, remoteConfigValuesViewState.f109304c) && Intrinsics.areEqual(this.f109305d, remoteConfigValuesViewState.f109305d) && Intrinsics.areEqual(this.f109306f, remoteConfigValuesViewState.f109306f);
    }

    public final String f() {
        return this.f109304c;
    }

    public final boolean g() {
        return this.f109302a;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.f109302a) * 31;
        String str = this.f109303b;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f109304c.hashCode()) * 31) + this.f109305d.hashCode()) * 31) + this.f109306f.hashCode();
    }

    public String toString() {
        return sECyKyO.PgtYFJDbs + this.f109302a + ", errorMessage=" + this.f109303b + ", searchQuery=" + this.f109304c + ", remoteConfigValues=" + this.f109305d + ", filteredRemoteConfigValues=" + this.f109306f + ")";
    }

    public /* synthetic */ RemoteConfigValuesViewState(boolean z2, String str, String str2, ImmutableList immutableList, ImmutableList immutableList2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 16) != 0 ? ExtensionsKt.a() : immutableList2);
    }
}
