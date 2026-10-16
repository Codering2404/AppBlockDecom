package cz.mobilesoft.coreblock.scene.more.backup.dto;

import java.util.List;
import kotlin.Metadata;
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
public final class HistoryDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f106433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f106434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f106435c;

    public HistoryDTO(List list, List list2, List list3) {
        this.f106433a = list;
        this.f106434b = list2;
        this.f106435c = list3;
    }

    public final List a() {
        return this.f106433a;
    }

    public final List b() {
        return this.f106435c;
    }

    public final List c() {
        return this.f106434b;
    }

    public final boolean d() {
        List list = this.f106433a;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        List list2 = this.f106434b;
        if (list2 != null && !list2.isEmpty()) {
            return false;
        }
        List list3 = this.f106435c;
        return list3 == null || list3.isEmpty();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoryDTO)) {
            return false;
        }
        HistoryDTO historyDTO = (HistoryDTO) obj;
        return Intrinsics.areEqual(this.f106433a, historyDTO.f106433a) && Intrinsics.areEqual(this.f106434b, historyDTO.f106434b) && Intrinsics.areEqual(this.f106435c, historyDTO.f106435c);
    }

    public int hashCode() {
        List list = this.f106433a;
        int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
        List list2 = this.f106434b;
        int iHashCode2 = (iHashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List list3 = this.f106435c;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "HistoryDTO(pause=" + this.f106433a + ", quickBlock=" + this.f106434b + ", pomodoro=" + this.f106435c + ")";
    }
}
