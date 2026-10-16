package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public abstract class QuickBlockTimerHistoryDao implements BaseDao<QuickBlockTimerHistory> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f126083a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0115, code lost:
    
        if (r2.n(r12, r0) != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0141, code lost:
    
        if (r11.p(r13, r0) == r1) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fa A[PHI: r2 r11 r12
      0x00fa: PHI (r2v9 cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao) = 
      (r2v3 cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao)
      (r2v6 cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao)
      (r2v11 cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao)
     binds: [B:28:0x00c8, B:33:0x00f7, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r11v13 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory) = 
      (r11v7 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
      (r11v10 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
      (r11v20 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
     binds: [B:28:0x00c8, B:33:0x00f7, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r12v13 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory) = 
      (r12v7 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
      (r12v10 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
      (r12v15 cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory)
     binds: [B:28:0x00c8, B:33:0x00f7, B:14:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object K(cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r11, cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao.K(cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao, cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r7.t(r8, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object N(cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r6, java.util.List r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao$restoreBackup$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao$restoreBackup$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao$restoreBackup$1) r0
            int r1 = r0.f126096g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f126096g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao$restoreBackup$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao$restoreBackup$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f126094d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f126096g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f126092b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f126091a
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao) r6
            kotlin.ResultKt.b(r8)
            goto L9a
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            java.lang.Object r6 = r0.f126092b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.f126091a
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao) r7
            kotlin.ResultKt.b(r8)
            goto L82
        L4b:
            java.lang.Object r6 = r0.f126093c
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao) r6
            java.lang.Object r7 = r0.f126092b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r2 = r0.f126091a
            cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao) r2
            kotlin.ResultKt.b(r8)
            goto L6e
        L5b:
            kotlin.ResultKt.b(r8)
            r0.f126091a = r6
            r0.f126092b = r7
            r0.f126093c = r6
            r0.f126096g = r5
            java.lang.Object r8 = r6.O(r0)
            if (r8 != r1) goto L6d
            goto L99
        L6d:
            r2 = r6
        L6e:
            java.util.List r8 = (java.util.List) r8
            r0.f126091a = r2
            r0.f126092b = r7
            r5 = 0
            r0.f126093c = r5
            r0.f126096g = r4
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
            r0.f126091a = r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f126092b = r6
            r0.f126096g = r3
            java.lang.Object r6 = r7.t(r8, r0)
            if (r6 != r1) goto L9a
        L99:
            return r1
        L9a:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao.N(cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object J(QuickBlockTimerHistory quickBlockTimerHistory, Continuation continuation) {
        return K(this, quickBlockTimerHistory, continuation);
    }

    public abstract Object L(Continuation continuation);

    public Object M(List list, Continuation continuation) {
        return N(this, list, continuation);
    }

    public abstract Object O(Continuation continuation);

    public abstract Object P(long j3, Continuation continuation);

    public abstract Object Q(Continuation continuation);

    public abstract Object R(Continuation continuation);

    public abstract void b();
}
