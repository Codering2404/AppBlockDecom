package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.lifecycle.LiveData;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public interface AcademyLessonDao extends BaseDao<AcademyLessonEntity> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0096, code lost:
    
        if (r7.r(r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object F(cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao$clearAllUserData$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao$clearAllUserData$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao$clearAllUserData$1) r0
            int r1 = r0.f125820f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125820f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao$clearAllUserData$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao$clearAllUserData$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f125818c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125820f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f125817b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r7 = r0.f125816a
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao) r7
            kotlin.ResultKt.b(r8)
            goto L99
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.f125816a
            cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao) r7
            kotlin.ResultKt.b(r8)
            goto L52
        L44:
            kotlin.ResultKt.b(r8)
            r0.f125816a = r7
            r0.f125820f = r4
            java.lang.Object r8 = r7.k(r0)
            if (r8 != r1) goto L52
            goto L98
        L52:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r4)
            r2.<init>(r4)
            java.util.Iterator r8 = r8.iterator()
        L63:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L84
            java.lang.Object r4 = r8.next()
            cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse r4 = (cz.mobilesoft.coreblock.storage.room.academy.AcademyLessonWithCourse) r4
            cz.mobilesoft.coreblock.storage.room.entity.core.AcademyLessonEntity r4 = r4.b()
            cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState r5 = cz.mobilesoft.coreblock.scene.more.academy.AcademyLessonState.AVAILABLE
            r4.m(r5)
            r5 = 0
            r4.p(r5)
            r4.k(r5)
            r2.add(r4)
            goto L63
        L84:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125816a = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f125817b = r8
            r0.f125820f = r3
            java.lang.Object r7 = r7.r(r2, r0)
            if (r7 != r1) goto L99
        L98:
            return r1
        L99:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao.F(cz.mobilesoft.coreblock.storage.room.dao.core.AcademyLessonDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object x(AcademyLessonDao academyLessonDao, Collection collection, Collection collection2, Collection collection3, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getByStates");
        }
        if ((i3 & 2) != 0) {
            collection2 = SetsKt.emptySet();
        }
        if ((i3 & 4) != 0) {
            collection3 = SetsKt.emptySet();
        }
        return academyLessonDao.l(collection, collection2, collection3, continuation);
    }

    Object a(Collection collection, Continuation continuation);

    LiveData c(long j3);

    default Object d(Continuation continuation) {
        return F(this, continuation);
    }

    Object deleteAll(Continuation continuation);

    Object e(long j3, Continuation continuation);

    Object k(Continuation continuation);

    Object l(Collection collection, Collection collection2, Collection collection3, Continuation continuation);

    Flow o(long j3);
}
