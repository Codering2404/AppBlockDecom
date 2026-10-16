package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import kotlin.Metadata;
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
public final class QuickBlockItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f97867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f97868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebsiteProfileRelation.BlockingType f97869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f97870d;

    public QuickBlockItem(Integer num, String str, WebsiteProfileRelation.BlockingType blockingType, Boolean bool) {
        this.f97867a = num;
        this.f97868b = str;
        this.f97869c = blockingType;
        this.f97870d = bool;
    }

    public final String a() {
        return this.f97868b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockItem)) {
            return false;
        }
        QuickBlockItem quickBlockItem = (QuickBlockItem) obj;
        return Intrinsics.areEqual(this.f97867a, quickBlockItem.f97867a) && Intrinsics.areEqual(this.f97868b, quickBlockItem.f97868b) && this.f97869c == quickBlockItem.f97869c && Intrinsics.areEqual(this.f97870d, quickBlockItem.f97870d);
    }

    public int hashCode() {
        Integer num = this.f97867a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f97868b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        WebsiteProfileRelation.BlockingType blockingType = this.f97869c;
        int iHashCode3 = (iHashCode2 + (blockingType == null ? 0 : blockingType.hashCode())) * 31;
        Boolean bool = this.f97870d;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "QuickBlockItem(typeId=" + this.f97867a + ", name=" + this.f97868b + ", blockingType=" + this.f97869c + ", isAnywhereInUrl=" + this.f97870d + ")";
    }

    public /* synthetic */ QuickBlockItem(Integer num, String str, WebsiteProfileRelation.BlockingType blockingType, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : blockingType, (i3 & 8) != 0 ? null : bool);
    }
}
