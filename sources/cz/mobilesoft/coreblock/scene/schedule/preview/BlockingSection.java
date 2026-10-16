package cz.mobilesoft.coreblock.scene.schedule.preview;

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
public final class BlockingSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f117334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f117335b;

    public BlockingSection(int i3, List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.f117334a = i3;
        this.f117335b = items;
    }

    public final List a() {
        return this.f117335b;
    }

    public final int b() {
        return this.f117334a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockingSection)) {
            return false;
        }
        BlockingSection blockingSection = (BlockingSection) obj;
        return this.f117334a == blockingSection.f117334a && Intrinsics.areEqual(this.f117335b, blockingSection.f117335b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f117334a) * 31) + this.f117335b.hashCode();
    }

    public String toString() {
        return "BlockingSection(titleResId=" + this.f117334a + ", items=" + this.f117335b + ")";
    }
}
