package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.LocalTime;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakAchievementNotificationPlanner {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f120097e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f120098f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final LocalTime f120099g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakStore f120100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakDataStore f120101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NotificationDataStore f120102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakAvailability f120103d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalTime a() {
            return StreakAchievementNotificationPlanner.f120099g;
        }

        private Companion() {
        }
    }

    static {
        LocalTime localTimeOf = LocalTime.of(8, 0);
        Intrinsics.checkNotNullExpressionValue(localTimeOf, "of(...)");
        f120099g = localTimeOf;
    }

    public StreakAchievementNotificationPlanner(StreakStore streakStore, StreakDataStore streakDataStore, NotificationDataStore notificationDataStore, StreakAvailability availability) {
        Intrinsics.checkNotNullParameter(streakStore, "streakStore");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(notificationDataStore, "notificationDataStore");
        Intrinsics.checkNotNullParameter(availability, "availability");
        this.f120100a = streakStore;
        this.f120101b = streakDataStore;
        this.f120102c = notificationDataStore;
        this.f120103d = availability;
    }

    public static /* synthetic */ Object c(StreakAchievementNotificationPlanner streakAchievementNotificationPlanner, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakAchievementNotificationPlanner.b(j3, zoneId, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d1 A[PHI: r10 r12 r13
      0x00d1: PHI (r10v4 long) = (r10v3 long), (r10v12 long) binds: [B:38:0x00ce, B:18:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x00d1: PHI (r12v4 java.time.ZoneId) = (r12v3 java.time.ZoneId), (r12v21 java.time.ZoneId) binds: [B:38:0x00ce, B:18:0x0051] A[DONT_GENERATE, DONT_INLINE]
      0x00d1: PHI (r13v17 java.lang.Object) = (r13v16 java.lang.Object), (r13v1 java.lang.Object) binds: [B:38:0x00ce, B:18:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0142 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(long r10, java.time.ZoneId r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakAchievementNotificationPlanner.b(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
