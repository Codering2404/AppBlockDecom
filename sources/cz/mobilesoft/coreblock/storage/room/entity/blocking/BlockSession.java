package cz.mobilesoft.coreblock.storage.room.entity.blocking;

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
public final class BlockSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126400c;

    public BlockSession(long j3, String name, long j4) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f126398a = j3;
        this.f126399b = name;
        this.f126400c = j4;
    }

    public final long a() {
        return this.f126398a;
    }

    public final String b() {
        return this.f126399b;
    }

    public final long c() {
        return this.f126400c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockSession)) {
            return false;
        }
        BlockSession blockSession = (BlockSession) obj;
        return this.f126398a == blockSession.f126398a && Intrinsics.areEqual(this.f126399b, blockSession.f126399b) && this.f126400c == blockSession.f126400c;
    }

    public int hashCode() {
        return (((Long.hashCode(this.f126398a) * 31) + this.f126399b.hashCode()) * 31) + Long.hashCode(this.f126400c);
    }

    public String toString() {
        return "BlockSession(id=" + this.f126398a + ", name=" + this.f126399b + ", timestamp=" + this.f126400c + ")";
    }

    public /* synthetic */ BlockSession(long j3, String str, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, str, j4);
    }
}
