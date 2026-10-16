package cz.mobilesoft.coreblock.scene.schedule;

import java.io.Serializable;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ItemsDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f114371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f114372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList f114373c;

    public ItemsDTO(ArrayList applications, ArrayList websites, ArrayList keywords) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        this.f114371a = applications;
        this.f114372b = websites;
        this.f114373c = keywords;
    }

    public static /* synthetic */ ItemsDTO b(ItemsDTO itemsDTO, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = itemsDTO.f114371a;
        }
        if ((i3 & 2) != 0) {
            arrayList2 = itemsDTO.f114372b;
        }
        if ((i3 & 4) != 0) {
            arrayList3 = itemsDTO.f114373c;
        }
        return itemsDTO.a(arrayList, arrayList2, arrayList3);
    }

    public final ItemsDTO a(ArrayList applications, ArrayList websites, ArrayList keywords) {
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(keywords, "keywords");
        return new ItemsDTO(applications, websites, keywords);
    }

    public final ArrayList c() {
        return this.f114371a;
    }

    public final ArrayList d() {
        return this.f114373c;
    }

    public final ArrayList e() {
        return this.f114372b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemsDTO)) {
            return false;
        }
        ItemsDTO itemsDTO = (ItemsDTO) obj;
        return Intrinsics.areEqual(this.f114371a, itemsDTO.f114371a) && Intrinsics.areEqual(this.f114372b, itemsDTO.f114372b) && Intrinsics.areEqual(this.f114373c, itemsDTO.f114373c);
    }

    public int hashCode() {
        return (((this.f114371a.hashCode() * 31) + this.f114372b.hashCode()) * 31) + this.f114373c.hashCode();
    }

    public String toString() {
        return "ItemsDTO(applications=" + this.f114371a + ", websites=" + this.f114372b + ", keywords=" + this.f114373c + ")";
    }

    public /* synthetic */ ItemsDTO(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList(0) : arrayList, (i3 & 2) != 0 ? new ArrayList(0) : arrayList2, (i3 & 4) != 0 ? new ArrayList(0) : arrayList3);
    }
}
