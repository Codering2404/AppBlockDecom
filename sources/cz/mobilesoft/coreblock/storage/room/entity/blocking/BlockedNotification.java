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
public final class BlockedNotification {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f126403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f126404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f126405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f126406f;

    public BlockedNotification(long j3, String packageName, long j4, long j5, String str, String str2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f126401a = j3;
        this.f126402b = packageName;
        this.f126403c = j4;
        this.f126404d = j5;
        this.f126405e = str;
        this.f126406f = str2;
    }

    public final long a() {
        return this.f126401a;
    }

    public final String b() {
        return this.f126406f;
    }

    public final String c() {
        return this.f126402b;
    }

    public final long d() {
        return this.f126404d;
    }

    public final long e() {
        return this.f126403c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedNotification)) {
            return false;
        }
        BlockedNotification blockedNotification = (BlockedNotification) obj;
        return this.f126401a == blockedNotification.f126401a && Intrinsics.areEqual(this.f126402b, blockedNotification.f126402b) && this.f126403c == blockedNotification.f126403c && this.f126404d == blockedNotification.f126404d && Intrinsics.areEqual(this.f126405e, blockedNotification.f126405e) && Intrinsics.areEqual(this.f126406f, blockedNotification.f126406f);
    }

    public final String f() {
        return this.f126405e;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f126401a) * 31) + this.f126402b.hashCode()) * 31) + Long.hashCode(this.f126403c)) * 31) + Long.hashCode(this.f126404d)) * 31;
        String str = this.f126405e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f126406f;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "BlockedNotification(id=" + this.f126401a + ", packageName=" + this.f126402b + ", timestamp=" + this.f126403c + ", profileId=" + this.f126404d + ", title=" + this.f126405e + ", message=" + this.f126406f + ")";
    }

    public /* synthetic */ BlockedNotification(long j3, String str, long j4, long j5, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, str, j4, j5, str2, str3);
    }
}
