package cz.mobilesoft.coreblock.storage.room.dao.core;

import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.LaunchTimeEntity;
import java.util.Calendar;
import java.util.TimeZone;
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
public abstract class LaunchTimeDao implements BaseDao<LaunchTimeEntity> {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object L(cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao r7, long r8, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao$existAnyLaunchesAfter$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao$existAnyLaunchesAfter$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao$existAnyLaunchesAfter$1) r0
            int r1 = r0.f126007h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f126007h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao$existAnyLaunchesAfter$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao$existAnyLaunchesAfter$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f126005f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f126007h
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.f126003c
            java.util.Calendar r7 = (java.util.Calendar) r7
            java.lang.Object r7 = r0.f126002b
            java.util.TimeZone r7 = (java.util.TimeZone) r7
            java.lang.Object r7 = r0.f126001a
            cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao) r7
            kotlin.ResultKt.b(r10)
            goto L75
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.b(r10)
            java.util.TimeZone r10 = java.util.TimeZone.getDefault()
            java.util.Calendar r2 = java.util.Calendar.getInstance()
            r2.setTimeInMillis(r8)
            r4 = 14
            int r5 = r10.getOffset(r8)
            r2.add(r4, r5)
            long r4 = r2.getTimeInMillis()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f126001a = r6
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f126002b = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f126003c = r10
            r0.f126004d = r8
            r0.f126007h = r3
            java.lang.Object r10 = r7.J(r4, r0)
            if (r10 != r1) goto L75
            return r1
        L75:
            java.lang.Number r10 = (java.lang.Number) r10
            long r7 = r10.longValue()
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L82
            goto L83
        L82:
            r3 = 0
        L83:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao.L(cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object N(LaunchTimeDao launchTimeDao, Continuation continuation) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Object objN = launchTimeDao.n(new LaunchTimeEntity(calendar.getTimeInMillis()), continuation);
        return objN == IntrinsicsKt.f() ? objN : Unit.f139807a;
    }

    public abstract Object J(long j3, Continuation continuation);

    public Object K(long j3, Continuation continuation) {
        return L(this, j3, continuation);
    }

    public Object M(Continuation continuation) {
        return N(this, continuation);
    }
}
