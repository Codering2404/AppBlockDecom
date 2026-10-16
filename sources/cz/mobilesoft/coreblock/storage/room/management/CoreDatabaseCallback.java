package cz.mobilesoft.coreblock.storage.room.management;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import cz.mobilesoft.coreblock.LockieApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class CoreDatabaseCallback extends RoomDatabase.Callback {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            r21 = this;
            r0 = r22
            boolean r1 = r0 instanceof cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1
            if (r1 == 0) goto L17
            r1 = r0
            cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1 r1 = (cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1) r1
            int r2 = r1.f126673f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f126673f = r2
            r2 = r21
            goto L1e
        L17:
            cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1 r1 = new cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback$setDefaultsForCustomBlockingScreens$1
            r2 = r21
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.f126671c
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r1.f126673f
            r5 = 1
            if (r4 == 0) goto L41
            if (r4 != r5) goto L39
            java.lang.Object r3 = r1.f126670b
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r1 = r1.f126669a
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r1 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao) r1
            kotlin.ResultKt.b(r0)     // Catch: java.lang.Exception -> L37
            goto La2
        L37:
            r0 = move-exception
            goto L9f
        L39:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L41:
            kotlin.ResultKt.b(r0)
            java.lang.Class<cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao> r0 = cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao.class
            r4 = 6
            r6 = 0
            java.lang.Object r0 = org.koin.java.KoinJavaComponent.c(r0, r6, r6, r4, r6)     // Catch: java.lang.Exception -> L37
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao) r0     // Catch: java.lang.Exception -> L37
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r6 = new cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity     // Catch: java.lang.Exception -> L37
            java.lang.String r7 = "1"
            cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType r8 = cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType.DEFAULT     // Catch: java.lang.Exception -> L37
            r18 = 2044(0x7fc, float:2.864E-42)
            r19 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch: java.lang.Exception -> L37
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r7 = new cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity     // Catch: java.lang.Exception -> L37
            java.lang.String r8 = "2"
            cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType r9 = cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType.ROTATING     // Catch: java.lang.Exception -> L37
            r19 = 2044(0x7fc, float:2.864E-42)
            r20 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch: java.lang.Exception -> L37
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity[] r4 = new cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity[]{r6, r7}     // Catch: java.lang.Exception -> L37
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r4)     // Catch: java.lang.Exception -> L37
            r6 = r4
            java.util.Collection r6 = (java.util.Collection) r6     // Catch: java.lang.Exception -> L37
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)     // Catch: java.lang.Exception -> L37
            r1.f126669a = r7     // Catch: java.lang.Exception -> L37
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)     // Catch: java.lang.Exception -> L37
            r1.f126670b = r4     // Catch: java.lang.Exception -> L37
            r1.f126673f = r5     // Catch: java.lang.Exception -> L37
            java.lang.Object r0 = r0.t(r6, r1)     // Catch: java.lang.Exception -> L37
            if (r0 != r3) goto La2
            return r3
        L9f:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r0)
        La2:
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.CoreDatabaseCallback.h(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.room.RoomDatabase.Callback
    public void b(SupportSQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.b(db);
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new CoreDatabaseCallback$onCreate$1(this, null), 3, null);
    }
}
