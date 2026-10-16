package cz.mobilesoft.coreblock.scene.schedule.detail;

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
public final class LabelWithIcon {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f116575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f116576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f116577c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LabelWithIcon)) {
            return false;
        }
        LabelWithIcon labelWithIcon = (LabelWithIcon) obj;
        return Intrinsics.areEqual(this.f116575a, labelWithIcon.f116575a) && Intrinsics.areEqual(this.f116576b, labelWithIcon.f116576b) && this.f116577c == labelWithIcon.f116577c;
    }

    public int hashCode() {
        return (((this.f116575a.hashCode() * 31) + this.f116576b.hashCode()) * 31) + Boolean.hashCode(this.f116577c);
    }

    public String toString() {
        return "LabelWithIcon(label=" + this.f116575a + ", icon=" + this.f116576b + ", isUninstalled=" + this.f116577c + ")";
    }
}
