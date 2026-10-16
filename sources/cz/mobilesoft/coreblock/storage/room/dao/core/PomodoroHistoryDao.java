package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory;
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
public abstract class PomodoroHistoryDao implements BaseDao<PomodoroHistory> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f126032a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0129, code lost:
    
        if (r3.n(r2, r6) != r7) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x015c, code lost:
    
        if (r2.p(r1, r6) == r7) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010e A[PHI: r0 r2 r3
      0x010e: PHI (r0v16 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory) = 
      (r0v10 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
      (r0v13 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
      (r0v23 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
     binds: [B:30:0x00dc, B:35:0x010b, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x010e: PHI (r2v15 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory) = 
      (r2v9 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
      (r2v12 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
      (r2v17 cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory)
     binds: [B:30:0x00dc, B:35:0x010b, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x010e: PHI (r3v9 cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao) = 
      (r3v3 cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao)
      (r3v6 cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao)
      (r3v11 cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao)
     binds: [B:30:0x00dc, B:35:0x010b, B:15:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object K(cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r19, cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao.K(cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao, cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r7.t(r8, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object N(cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r6, java.util.List r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao$restoreBackup$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao$restoreBackup$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao$restoreBackup$1) r0
            int r1 = r0.f126045g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f126045g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao$restoreBackup$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao$restoreBackup$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f126043d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f126045g
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5b
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r6 = r0.f126041b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f126040a
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao) r6
            kotlin.ResultKt.b(r8)
            goto L9a
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            java.lang.Object r6 = r0.f126041b
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.f126040a
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao) r7
            kotlin.ResultKt.b(r8)
            goto L82
        L4b:
            java.lang.Object r6 = r0.f126042c
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao) r6
            java.lang.Object r7 = r0.f126041b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r2 = r0.f126040a
            cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao r2 = (cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao) r2
            kotlin.ResultKt.b(r8)
            goto L6e
        L5b:
            kotlin.ResultKt.b(r8)
            r0.f126040a = r6
            r0.f126041b = r7
            r0.f126042c = r6
            r0.f126045g = r5
            java.lang.Object r8 = r6.O(r0)
            if (r8 != r1) goto L6d
            goto L99
        L6d:
            r2 = r6
        L6e:
            java.util.List r8 = (java.util.List) r8
            r0.f126040a = r2
            r0.f126041b = r7
            r5 = 0
            r0.f126042c = r5
            r0.f126045g = r4
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
            r0.f126040a = r2
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f126041b = r6
            r0.f126045g = r3
            java.lang.Object r6 = r7.t(r8, r0)
            if (r6 != r1) goto L9a
        L99:
            return r1
        L9a:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao.N(cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object J(PomodoroHistory pomodoroHistory, Continuation continuation) {
        return K(this, pomodoroHistory, continuation);
    }

    public abstract Object L(Continuation continuation);

    public Object M(List list, Continuation continuation) {
        return N(this, list, continuation);
    }

    public abstract Object O(Continuation continuation);

    public abstract Object P(long j3, long j4, int i3, Continuation continuation);

    public abstract Object Q(Continuation continuation);

    public abstract Object R(Continuation continuation);

    public abstract void b();
}
