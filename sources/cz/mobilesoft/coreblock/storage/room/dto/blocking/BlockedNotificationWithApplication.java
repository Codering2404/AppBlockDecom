package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
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
public final class BlockedNotificationWithApplication {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockedNotification f126357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Application f126358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f126359c;

    public BlockedNotificationWithApplication(BlockedNotification notification, Application application, Integer num) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        this.f126357a = notification;
        this.f126358b = application;
        this.f126359c = num;
    }

    public final Application a() {
        return this.f126358b;
    }

    public final BlockedNotification b() {
        return this.f126357a;
    }

    public final Integer c() {
        return this.f126359c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockedNotificationWithApplication)) {
            return false;
        }
        BlockedNotificationWithApplication blockedNotificationWithApplication = (BlockedNotificationWithApplication) obj;
        return Intrinsics.areEqual(this.f126357a, blockedNotificationWithApplication.f126357a) && Intrinsics.areEqual(this.f126358b, blockedNotificationWithApplication.f126358b) && Intrinsics.areEqual(this.f126359c, blockedNotificationWithApplication.f126359c);
    }

    public int hashCode() {
        int iHashCode = this.f126357a.hashCode() * 31;
        Application application = this.f126358b;
        int iHashCode2 = (iHashCode + (application == null ? 0 : application.hashCode())) * 31;
        Integer num = this.f126359c;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "BlockedNotificationWithApplication(notification=" + this.f126357a + ", application=" + this.f126358b + ", totalCount=" + this.f126359c + ")";
    }
}
