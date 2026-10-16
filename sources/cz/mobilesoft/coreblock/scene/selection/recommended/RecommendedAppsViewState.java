package cz.mobilesoft.coreblock.scene.selection.recommended;

import cz.mobilesoft.coreblock.base.ViewState;
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
public final class RecommendedAppsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f119230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableList f119231b;

    public RecommendedAppsViewState(ImmutableList applications, ImmutableList websitesForApplications) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websitesForApplications, "websitesForApplications");
        this.f119230a = applications;
        this.f119231b = websitesForApplications;
    }

    public static /* synthetic */ RecommendedAppsViewState b(RecommendedAppsViewState recommendedAppsViewState, ImmutableList immutableList, ImmutableList immutableList2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            immutableList = recommendedAppsViewState.f119230a;
        }
        if ((i3 & 2) != 0) {
            immutableList2 = recommendedAppsViewState.f119231b;
        }
        return recommendedAppsViewState.a(immutableList, immutableList2);
    }

    public final RecommendedAppsViewState a(ImmutableList applications, ImmutableList websitesForApplications) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websitesForApplications, "websitesForApplications");
        return new RecommendedAppsViewState(applications, websitesForApplications);
    }

    public final ImmutableList c() {
        return this.f119230a;
    }

    public final ImmutableList d() {
        return this.f119231b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendedAppsViewState)) {
            return false;
        }
        RecommendedAppsViewState recommendedAppsViewState = (RecommendedAppsViewState) obj;
        return Intrinsics.areEqual(this.f119230a, recommendedAppsViewState.f119230a) && Intrinsics.areEqual(this.f119231b, recommendedAppsViewState.f119231b);
    }

    public int hashCode() {
        return (this.f119230a.hashCode() * 31) + this.f119231b.hashCode();
    }

    public String toString() {
        return "RecommendedAppsViewState(applications=" + this.f119230a + ", websitesForApplications=" + this.f119231b + ")";
    }

    public /* synthetic */ RecommendedAppsViewState(ImmutableList immutableList, ImmutableList immutableList2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? ExtensionsKt.a() : immutableList, (i3 & 2) != 0 ? ExtensionsKt.a() : immutableList2);
    }
}
