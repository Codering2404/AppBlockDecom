package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.lifecycle.LiveData;
import cz.mobilesoft.coreblock.scene.more.academy.AcademyCourseState;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyCourseEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;

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
public interface AcademyCourseDao extends BaseDao<AcademyCourseEntity> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x039f, code lost:
    
        if (r12.r(r2, r3) != r4) goto L89;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01df A[LOOP:0: B:43:0x01d9->B:45:0x01df, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x035f A[PHI: r0 r1 r5 r6 r8 r9 r10 r11 r12
      0x035f: PHI (r0v18 java.util.List) = (r0v17 java.util.List), (r0v31 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r1v18 java.util.List) = (r1v17 java.util.List), (r1v28 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r5v11 java.util.List) = (r5v10 java.util.List), (r5v21 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r6v7 java.util.Map) = (r6v6 java.util.Map), (r6v12 java.util.Map) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r8v12 java.util.Map) = (r8v11 java.util.Map), (r8v15 java.util.Map) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r9v12 java.util.List) = (r9v11 java.util.List), (r9v17 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r10v6 java.util.List) = (r10v5 java.util.List), (r10v13 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r11v6 java.util.List) = (r11v5 java.util.List), (r11v15 java.util.List) binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x035f: PHI (r12v9 cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao) = 
      (r12v8 cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao)
      (r12v14 cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao)
     binds: [B:84:0x035c, B:18:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object A(cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao r23, java.util.List r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 933
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao.A(cz.mobilesoft.coreblock.storage.room.dao.core.AcademyCourseDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object u(AcademyCourseDao academyCourseDao, Continuation continuation) {
        Object objW = academyCourseDao.w(AcademyCourseState.AVAILABLE, continuation);
        return objW == IntrinsicsKt.f() ? objW : Unit.f139807a;
    }

    Object a(Collection collection, Continuation continuation);

    LiveData c(long j3);

    default Object d(Continuation continuation) {
        return u(this, continuation);
    }

    Object deleteAll(Continuation continuation);

    Object e(long j3, Continuation continuation);

    Flow getAll();

    default Object m(List list, Continuation continuation) {
        return A(this, list, continuation);
    }

    Object w(AcademyCourseState academyCourseState, Continuation continuation);
}
