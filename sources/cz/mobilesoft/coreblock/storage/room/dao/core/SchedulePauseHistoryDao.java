package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.SchedulePauseHistoryEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public abstract class SchedulePauseHistoryDao implements BaseDao<SchedulePauseHistoryEntity> {
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r7.t(r8, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object K(cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao r6, java.util.List r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao$restoreBackup$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao$restoreBackup$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao$restoreBackup$1) r0
            int r1 = r0.f126115g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f126115g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao$restoreBackup$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao$restoreBackup$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f126113d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f126115g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f126111b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f126110a
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao) r6
            kotlin.ResultKt.b(r8)
            goto L9a
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            java.lang.Object r6 = r0.f126111b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.f126110a
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao) r7
            kotlin.ResultKt.b(r8)
            goto L82
        L4b:
            java.lang.Object r6 = r0.f126112c
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao) r6
            java.lang.Object r7 = r0.f126111b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r2 = r0.f126110a
            cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao) r2
            kotlin.ResultKt.b(r8)
            goto L6e
        L5b:
            kotlin.ResultKt.b(r8)
            r0.f126110a = r6
            r0.f126111b = r7
            r0.f126112c = r6
            r0.f126115g = r5
            java.lang.Object r8 = r6.L(r0)
            if (r8 != r1) goto L6d
            goto L99
        L6d:
            r2 = r6
        L6e:
            java.util.List r8 = (java.util.List) r8
            r0.f126110a = r2
            r0.f126111b = r7
            r5 = 0
            r0.f126112c = r5
            r0.f126115g = r4
            java.lang.Object r6 = r6.h(r8, r0)
            if (r6 != r1) goto L80
            goto L99
        L80:
            r6 = r7
            r7 = r2
        L82:
            r8 = r6
            java.util.Collection r8 = (java.util.Collection) r8
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f126110a = r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f126111b = r6
            r0.f126115g = r3
            java.lang.Object r6 = r7.t(r8, r0)
            if (r6 != r1) goto L9a
        L99:
            return r1
        L9a:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao.K(cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object J(List list, Continuation continuation) {
        return K(this, list, continuation);
    }

    public abstract Object L(Continuation continuation);

    public abstract Object M(long j3, long j4, Continuation continuation);

    public abstract Object N(long j3, long j4, Continuation continuation);

    public abstract Flow O(long j3, long j4, long j5);
}
