package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.paging.PagingSource;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

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
public abstract class BlockedNotificationDao implements BaseDao<BlockedNotification> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence O(BlockedNotificationWithApplication it) {
        String strB;
        Intrinsics.checkNotNullParameter(it, "it");
        Application applicationA = it.a();
        return (applicationA == null || (strB = applicationA.b()) == null) ? it.b().c() : strB;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object P(cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao r10, long r11, long r13, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            boolean r0 = r15 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao$getAppNamesSeparateByComma$1
            if (r0 == 0) goto L14
            r0 = r15
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao$getAppNamesSeparateByComma$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao$getAppNamesSeparateByComma$1) r0
            int r1 = r0.f124975g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f124975g = r1
        L12:
            r15 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao$getAppNamesSeparateByComma$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao$getAppNamesSeparateByComma$1
            r0.<init>(r10, r15)
            goto L12
        L1a:
            java.lang.Object r0 = r15.f124973d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r15.f124975g
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r10 = r15.f124970a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao r10 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao) r10
            kotlin.ResultKt.b(r0)
            goto L4d
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            kotlin.ResultKt.b(r0)
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r15.f124970a = r0
            r15.f124971b = r11
            r15.f124972c = r13
            r15.f124975g = r3
            java.lang.Object r0 = r10.K(r11, r13, r15)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r11 = r0.iterator()
        L5d:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L7c
            java.lang.Object r12 = r11.next()
            r13 = r12
            cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication r13 = (cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication) r13
            cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification r13 = r13.b()
            java.lang.String r13 = r13.c()
            boolean r13 = r10.add(r13)
            if (r13 == 0) goto L5d
            r1.add(r12)
            goto L5d
        L7c:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.z0 r7 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.z0
            r7.<init>()
            r8 = 31
            r9 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r10 = kotlin.collections.CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao.P(cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object K(long j3, long j4, Continuation continuation);

    public abstract Flow L(int i3);

    public abstract PagingSource M();

    public Object N(long j3, long j4, Continuation continuation) {
        return P(this, j3, j4, continuation);
    }

    public abstract Object deleteAll(Continuation continuation);
}
