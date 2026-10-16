package cz.mobilesoft.coreblock.scene.streaks.intro;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StreakDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
public final class StreakIntroAvailability {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Companion f120887d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f120888e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoreDataStore f120889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StreakDataStore f120890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AppVersionDao f120891c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public StreakIntroAvailability(CoreDataStore coreDataStore, StreakDataStore streakDataStore, AppVersionDao appVersionDao) {
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        Intrinsics.checkNotNullParameter(streakDataStore, "streakDataStore");
        Intrinsics.checkNotNullParameter(appVersionDao, "appVersionDao");
        this.f120889a = coreDataStore;
        this.f120890b = streakDataStore;
        this.f120891c = appVersionDao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$wasUpdatedFromBeforeStreaks$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$wasUpdatedFromBeforeStreaks$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$wasUpdatedFromBeforeStreaks$1) r0
            int r1 = r0.f120897c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120897c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$wasUpdatedFromBeforeStreaks$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$wasUpdatedFromBeforeStreaks$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f120895a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120897c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.room.dao.core.AppVersionDao r7 = r6.f120891c
            r0.f120897c = r3
            java.lang.Object r7 = r7.y(r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity r7 = (cz.mobilesoft.coreblock.storage.room.entity.core.AppVersionEntity) r7
            r0 = 0
            if (r7 != 0) goto L49
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            return r7
        L49:
            long r1 = r7.d()
            r4 = 577(0x241, double:2.85E-321)
            int r7 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r7 >= 0) goto L5a
            int r7 = cz.mobilesoft.coreblock.LockieApplication.f95359d
            r1 = 577(0x241, float:8.09E-43)
            if (r7 < r1) goto L5a
            goto L5b
        L5a:
            r3 = r0
        L5b:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$isDue$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$isDue$1 r0 = (cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$isDue$1) r0
            int r1 = r0.f120894c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f120894c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$isDue$1 r0 = new cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability$isDue$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f120892a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f120894c
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L40
            if (r2 == r6) goto L3c
            if (r2 == r5) goto L38
            if (r2 != r4) goto L30
            kotlin.ResultKt.b(r8)
            return r8
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            kotlin.ResultKt.b(r8)
            goto L6e
        L3c:
            kotlin.ResultKt.b(r8)
            goto L52
        L40:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.StreakDataStore r8 = r7.f120890b
            kotlinx.coroutines.flow.Flow r8 = r8.T()
            r0.f120894c = r6
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L52
            goto L83
        L52:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L5f
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r8
        L5f:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r8 = r7.f120889a
            kotlinx.coroutines.flow.Flow r8 = r8.w3()
            r0.f120894c = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L6e
            goto L83
        L6e:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L7b
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r8
        L7b:
            r0.f120894c = r4
            java.lang.Object r8 = r7.d(r0)
            if (r8 != r1) goto L84
        L83:
            return r1
        L84:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroAvailability.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object c(Continuation continuation) {
        Object objG0 = this.f120890b.g0(continuation);
        return objG0 == IntrinsicsKt.f() ? objG0 : Unit.f139807a;
    }
}
