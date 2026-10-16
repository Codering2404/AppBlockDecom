package cz.mobilesoft.coreblock.repository;

import cz.mobilesoft.coreblock.dto.RelationDTO;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class QuickBlockAppWebWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private QuickBlockItem f97863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private QuickBlockItem f97864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f97865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelationDTO f97866d;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickBlockAppWebWrapper)) {
            return false;
        }
        QuickBlockAppWebWrapper quickBlockAppWebWrapper = (QuickBlockAppWebWrapper) obj;
        return Intrinsics.areEqual(this.f97863a, quickBlockAppWebWrapper.f97863a) && Intrinsics.areEqual(this.f97864b, quickBlockAppWebWrapper.f97864b) && this.f97865c == quickBlockAppWebWrapper.f97865c && Intrinsics.areEqual(this.f97866d, quickBlockAppWebWrapper.f97866d);
    }

    public int hashCode() {
        QuickBlockItem quickBlockItem = this.f97863a;
        int iHashCode = (quickBlockItem == null ? 0 : quickBlockItem.hashCode()) * 31;
        QuickBlockItem quickBlockItem2 = this.f97864b;
        int iHashCode2 = (((iHashCode + (quickBlockItem2 == null ? 0 : quickBlockItem2.hashCode())) * 31) + Boolean.hashCode(this.f97865c)) * 31;
        RelationDTO relationDTO = this.f97866d;
        return iHashCode2 + (relationDTO != null ? relationDTO.hashCode() : 0);
    }

    public String toString() {
        return "QuickBlockAppWebWrapper(app=" + this.f97863a + ", web=" + this.f97864b + ", isMissingPermission=" + this.f97865c + ", relationDTO=" + this.f97866d + ")";
    }
}
