package cz.mobilesoft.coreblock.scene.intro.quickblock;

import cz.mobilesoft.coreblock.base.ViewState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class QuickBlockBlockingTestViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableList f104769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f104770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableList f104771c;

    public QuickBlockBlockingTestViewState(ImmutableList immutableList, Boolean bool, ImmutableList immutableList2) {
        this.f104769a = immutableList;
        this.f104770b = bool;
        this.f104771c = immutableList2;
    }

    public final QuickBlockBlockingTestViewState a(ImmutableList immutableList, Boolean bool, ImmutableList immutableList2) {
        return new QuickBlockBlockingTestViewState(immutableList, bool, immutableList2);
    }

    public final Boolean b() {
        return this.f104770b;
    }

    public final ImmutableList c() {
        return this.f104769a;
    }

    public final ImmutableList d() {
        return this.f104771c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockBlockingTestViewState)) {
            return false;
        }
        QuickBlockBlockingTestViewState quickBlockBlockingTestViewState = (QuickBlockBlockingTestViewState) obj;
        return Intrinsics.areEqual(this.f104769a, quickBlockBlockingTestViewState.f104769a) && Intrinsics.areEqual(this.f104770b, quickBlockBlockingTestViewState.f104770b) && Intrinsics.areEqual(this.f104771c, quickBlockBlockingTestViewState.f104771c);
    }

    public int hashCode() {
        ImmutableList immutableList = this.f104769a;
        int iHashCode = (immutableList == null ? 0 : immutableList.hashCode()) * 31;
        Boolean bool = this.f104770b;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        ImmutableList immutableList2 = this.f104771c;
        return iHashCode2 + (immutableList2 != null ? immutableList2.hashCode() : 0);
    }

    public String toString() {
        return "QuickBlockBlockingTestViewState(apps=" + this.f104769a + ", addNewApps=" + this.f104770b + ", websAndKeywords=" + this.f104771c + ")";
    }

    public /* synthetic */ QuickBlockBlockingTestViewState(ImmutableList immutableList, Boolean bool, ImmutableList immutableList2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : immutableList, (i3 & 2) != 0 ? null : bool, (i3 & 4) != 0 ? null : immutableList2);
    }
}
