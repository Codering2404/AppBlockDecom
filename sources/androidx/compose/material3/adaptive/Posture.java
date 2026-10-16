package androidx.compose.material3.adaptive;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Posture {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f21599b;

    public Posture(boolean z2, List list) {
        this.f21598a = z2;
        this.f21599b = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Posture)) {
            return false;
        }
        Posture posture = (Posture) obj;
        return this.f21598a == posture.f21598a && Intrinsics.areEqual(this.f21599b, posture.f21599b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.f21598a) * 31) + this.f21599b.hashCode();
    }

    public String toString() {
        return "Posture(isTabletop=" + this.f21598a + ", hinges=[" + CollectionsKt.joinToString$default(this.f21599b, ", ", null, null, 0, null, null, 62, null) + "])";
    }
}
