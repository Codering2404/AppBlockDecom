package cz.mobilesoft.coreblock.scene.streaks;

import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
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
public final class StreakNudgePlanner {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f120372f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f120373g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final LocalTime f120374h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StreakStore f120375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakEvaluator f120376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NotificationDataStore f120377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreakAvailability f120378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProfileDao f120379e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalTime a() {
            return StreakNudgePlanner.f120374h;
        }

        private Companion() {
        }
    }

    static {
        LocalTime localTimeOf = LocalTime.of(22, 0);
        Intrinsics.checkNotNullExpressionValue(localTimeOf, "of(...)");
        f120374h = localTimeOf;
    }

    public StreakNudgePlanner(StreakStore streakStore, StreakEvaluator streakEvaluator, NotificationDataStore notificationDataStore, StreakAvailability availability, ProfileDao profileDao) {
        Intrinsics.checkNotNullParameter(streakStore, "streakStore");
        Intrinsics.checkNotNullParameter(streakEvaluator, "streakEvaluator");
        Intrinsics.checkNotNullParameter(notificationDataStore, "notificationDataStore");
        Intrinsics.checkNotNullParameter(availability, "availability");
        Intrinsics.checkNotNullParameter(profileDao, "profileDao");
        this.f120375a = streakStore;
        this.f120376b = streakEvaluator;
        this.f120377c = notificationDataStore;
        this.f120378d = availability;
        this.f120379e = profileDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner$hasPausedSchedule$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner$hasPausedSchedule$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner$hasPausedSchedule$1) r0
            int r1 = r0.f120382c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120382c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner$hasPausedSchedule$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner$hasPausedSchedule$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f120380a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120382c
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r6)
            goto L40
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L32:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r6 = r5.f120379e
            r0.f120382c = r3
            java.lang.Object r6 = r6.s0(r4, r4, r0)
            if (r6 != r1) goto L40
            return r1
        L40:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L51
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L51
        L4f:
            r3 = r4
            goto L67
        L51:
            java.util.Iterator r6 = r6.iterator()
        L55:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L4f
            java.lang.Object r0 = r6.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r0 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r0
            boolean r0 = r0.H()
            if (r0 == 0) goto L55
        L67:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object e(StreakNudgePlanner streakNudgePlanner, long j3, ZoneId zoneId, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        if ((i3 & 2) != 0) {
            zoneId = ZoneId.systemDefault();
            Intrinsics.checkNotNullExpressionValue(zoneId, "systemDefault(...)");
        }
        return streakNudgePlanner.d(j3, zoneId, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0109, code lost:
    
        if (r9 != r1) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00de A[PHI: r6 r8 r9
      0x00de: PHI (r6v9 long) = (r6v7 long), (r6v10 long) binds: [B:40:0x00db, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r8v13 java.time.ZoneId) = (r8v10 java.time.ZoneId), (r8v15 java.time.ZoneId) binds: [B:40:0x00db, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]
      0x00de: PHI (r9v22 java.lang.Object) = (r9v21 java.lang.Object), (r9v1 java.lang.Object) binds: [B:40:0x00db, B:13:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(long r6, java.time.ZoneId r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.StreakNudgePlanner.d(long, java.time.ZoneId, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
