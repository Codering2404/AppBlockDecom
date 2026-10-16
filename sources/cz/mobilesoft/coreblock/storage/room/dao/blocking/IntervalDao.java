package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

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
public abstract class IntervalDao implements BaseDao<Interval> {
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d5, code lost:
    
        if (r4.X(r11, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object O(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r11, cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao.O(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao, cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x017f, code lost:
    
        if (r0.r(r6, r2) == r3) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object Q(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r18, java.util.Collection r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao.Q(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        if (r6.r(r8, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object S(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r6, java.util.Collection r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$enableAllByProfileIds$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$enableAllByProfileIds$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$enableAllByProfileIds$1) r0
            int r1 = r0.f125056g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125056g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$enableAllByProfileIds$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$enableAllByProfileIds$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f125054d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125056g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f125053c
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.f125052b
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r6 = r0.f125051a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r6
            kotlin.ResultKt.b(r8)
            goto L98
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            java.lang.Object r6 = r0.f125052b
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            java.lang.Object r6 = r0.f125051a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r6 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r6
            kotlin.ResultKt.b(r8)
            goto L61
        L4d:
            kotlin.ResultKt.b(r8)
            r0.f125051a = r6
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125052b = r8
            r0.f125056g = r4
            java.lang.Object r8 = r6.V(r7, r0)
            if (r8 != r1) goto L61
            goto L97
        L61:
            java.util.List r8 = (java.util.List) r8
            r2 = r8
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L6a:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L7a
            java.lang.Object r5 = r2.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r5 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r5
            r5.j(r4)
            goto L6a
        L7a:
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f125051a = r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125052b = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f125053c = r7
            r0.f125056g = r3
            java.lang.Object r6 = r6.r(r2, r0)
            if (r6 != r1) goto L98
        L97:
            return r1
        L98:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao.S(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object Y(IntervalDao intervalDao, long j3, Continuation continuation) {
        Object objN = intervalDao.n(new Interval(0L, j3, 0L, 1439L, null, true, false, 65, null), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object a0(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r7, cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$insertAndDeleteAuto$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$insertAndDeleteAuto$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$insertAndDeleteAuto$1) r0
            int r1 = r0.f125061f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125061f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$insertAndDeleteAuto$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao$insertAndDeleteAuto$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f125059c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125061f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f125058b
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r7 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r7
            java.lang.Object r7 = r0.f125057a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r7
            kotlin.ResultKt.b(r9)
            return r9
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.f125058b
            r8 = r7
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval r8 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval) r8
            java.lang.Object r7 = r0.f125057a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao) r7
            kotlin.ResultKt.b(r9)
            goto L63
        L49:
            kotlin.ResultKt.b(r9)
            boolean r9 = r8.h()
            if (r9 != 0) goto L63
            long r5 = r8.g()
            r0.f125057a = r7
            r0.f125058b = r8
            r0.f125061f = r4
            java.lang.Object r9 = r7.K(r5, r0)
            if (r9 != r1) goto L63
            goto L77
        L63:
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125057a = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f125058b = r9
            r0.f125061f = r3
            java.lang.Object r7 = r7.n(r8, r0)
            if (r7 != r1) goto L78
        L77:
            return r1
        L78:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao.a0(cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao, cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object J(long j3, Continuation continuation);

    public abstract Object K(long j3, Continuation continuation);

    public abstract Object L(long j3, Continuation continuation);

    public abstract Object M(Collection collection, Continuation continuation);

    public Object N(Interval interval, Continuation continuation) {
        return O(this, interval, continuation);
    }

    public Object P(Collection collection, Continuation continuation) {
        return Q(this, collection, continuation);
    }

    public Object R(Collection collection, Continuation continuation) {
        return S(this, collection, continuation);
    }

    public abstract Object T(long j3, Continuation continuation);

    public abstract Object U(long j3, Continuation continuation);

    public abstract Object V(Collection collection, Continuation continuation);

    public abstract Object W(long j3, Continuation continuation);

    public Object X(long j3, Continuation continuation) {
        return Y(this, j3, continuation);
    }

    public Object Z(Interval interval, Continuation continuation) {
        return a0(this, interval, continuation);
    }

    public abstract Object e(long j3, Continuation continuation);

    public abstract Object k(Continuation continuation);
}
