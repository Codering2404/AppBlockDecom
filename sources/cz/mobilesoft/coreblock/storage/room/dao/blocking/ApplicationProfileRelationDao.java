package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public abstract class ApplicationProfileRelationDao implements BaseDao<ApplicationProfileRelation> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence N(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it + "'";
    }

    public static /* synthetic */ Object P(ApplicationProfileRelationDao applicationProfileRelationDao, long j3, Collection collection, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllByProfileId");
        }
        if ((i3 & 2) != 0) {
            collection = null;
        }
        Collection collection2 = collection;
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return applicationProfileRelationDao.O(j3, collection2, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence R(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it + "'";
    }

    public static /* synthetic */ Object a0(ApplicationProfileRelationDao applicationProfileRelationDao, long j3, Collection collection, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: existAnyByProfileId");
        }
        if ((i3 & 2) != 0) {
            collection = null;
        }
        Collection collection2 = collection;
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return applicationProfileRelationDao.Z(j3, collection2, z2, continuation);
    }

    public static /* synthetic */ Object f0(ApplicationProfileRelationDao applicationProfileRelationDao, Collection collection, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllByProfileIds");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return applicationProfileRelationDao.e0(collection, z2, continuation);
    }

    public static /* synthetic */ Object h0(ApplicationProfileRelationDao applicationProfileRelationDao, Collection collection, Collection collection2, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllByProfileIdsAndPackageNames");
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return applicationProfileRelationDao.g0(collection, collection2, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence i0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "'" + it + "'";
    }

    public static /* synthetic */ Object l0(ApplicationProfileRelationDao applicationProfileRelationDao, Collection collection, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPackageNamesByProfileIds");
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return applicationProfileRelationDao.k0(collection, z2, continuation);
    }

    public final Object M(Collection collection, Collection collection2, Collection collection3, boolean z2, Continuation continuation) {
        String str = z2 ? "" : "AND flags = 0";
        String strJoinToString$default = CollectionsKt.joinToString$default(collection3, null, null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.d0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao.N((String) obj);
            }
        }, 31, null);
        return S(new SimpleSQLiteQuery(StringsKt.n("\n            SELECT COUNT(*) FROM ApplicationProfileRelation \n            WHERE (\n                (\n                    profileId IN (" + CollectionsKt.joinToString$default(collection, null, null, null, 0, null, null, 63, null) + ") AND packageName IN (" + strJoinToString$default + ")\n                ) OR (\n                    profileId IN (" + CollectionsKt.joinToString$default(collection2, null, null, null, 0, null, null, 63, null) + ") AND packageName NOT IN (" + strJoinToString$default + ")\n                )\n            )\n            " + str + ";\n            ")), continuation);
    }

    public final Object O(long j3, Collection collection, boolean z2, Continuation continuation) {
        return Q(CollectionsKt.listOf(Boxing.e(j3)), collection, z2, continuation);
    }

    public final Object Q(Collection collection, Collection collection2, boolean z2, Continuation continuation) {
        String str;
        if (collection2 != null) {
            str = "AND packageName IN (" + CollectionsKt.joinToString$default(collection2, null, null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.e0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ApplicationProfileRelationDao.R((String) obj);
                }
            }, 31, null) + ")";
        } else {
            str = "";
        }
        String str2 = z2 ? "" : "AND flags = 0";
        return S(new SimpleSQLiteQuery("SELECT COUNT(*) FROM ApplicationProfileRelation WHERE profileId IN (" + CollectionsKt.joinToString$default(collection, null, null, null, 0, null, null, 63, null) + ") " + str + " " + str2 + ";"), continuation);
    }

    public abstract Object S(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public abstract Object T(int i3, Continuation continuation);

    public abstract Object U(Collection collection, Continuation continuation);

    public abstract Object V(long j3, int i3, Continuation continuation);

    public abstract Object W(long j3, Collection collection, Continuation continuation);

    public abstract Object X(Collection collection, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Y(java.util.Collection r9, java.util.Collection r10, java.util.Collection r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByBlockAndAllowlistProfileIds$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByBlockAndAllowlistProfileIds$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByBlockAndAllowlistProfileIds$1) r0
            int r1 = r0.f124935h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f124935h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByBlockAndAllowlistProfileIds$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByBlockAndAllowlistProfileIds$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f124933f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f124935h
            r7 = 1
            if (r1 == 0) goto L3f
            if (r1 != r7) goto L37
            java.lang.Object r9 = r6.f124931c
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r9 = r6.f124930b
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r9 = r6.f124929a
            java.util.Collection r9 = (java.util.Collection) r9
            kotlin.ResultKt.b(r13)
            goto L64
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r6.f124929a = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r6.f124930b = r13
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f124931c = r13
            r6.f124932d = r12
            r6.f124935h = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            java.lang.Object r13 = r1.M(r2, r3, r4, r5, r6)
            if (r13 != r0) goto L64
            return r0
        L64:
            java.lang.Number r13 = (java.lang.Number) r13
            long r9 = r13.longValue()
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L71
            goto L72
        L71:
            r7 = 0
        L72:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao.Y(java.util.Collection, java.util.Collection, java.util.Collection, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z(long r9, java.util.Collection r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileId$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileId$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileId$1) r0
            int r1 = r0.f124941g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f124941g = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileId$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileId$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f124939d
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f124941g
            r7 = 1
            if (r1 == 0) goto L37
            if (r1 != r7) goto L2f
            java.lang.Object r9 = r6.f124937b
            java.util.Collection r9 = (java.util.Collection) r9
            kotlin.ResultKt.b(r13)
            goto L51
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r6.f124937b = r13
            r6.f124936a = r9
            r6.f124938c = r12
            r6.f124941g = r7
            r1 = r8
            r2 = r9
            r4 = r11
            r5 = r12
            java.lang.Object r13 = r1.O(r2, r4, r5, r6)
            if (r13 != r0) goto L51
            return r0
        L51:
            java.lang.Number r13 = (java.lang.Number) r13
            long r9 = r13.longValue()
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L5e
            goto L5f
        L5e:
            r7 = 0
        L5f:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao.Z(long, java.util.Collection, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b0(java.util.Collection r5, java.util.Collection r6, boolean r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileIds$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileIds$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileIds$1) r0
            int r1 = r0.f124947g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124947g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileIds$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao$existAnyByProfileIds$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f124945d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124947g
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r5 = r0.f124943b
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r5 = r0.f124942a
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.ResultKt.b(r8)
            goto L53
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124942a = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f124943b = r8
            r0.f124944c = r7
            r0.f124947g = r3
            java.lang.Object r8 = r4.Q(r5, r6, r7, r0)
            if (r8 != r1) goto L53
            return r1
        L53:
            java.lang.Number r8 = (java.lang.Number) r8
            long r5 = r8.longValue()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L60
            goto L61
        L60:
            r3 = 0
        L61:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao.b0(java.util.Collection, java.util.Collection, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object c0(String str, Continuation continuation);

    public abstract Object d0(long j3, Continuation continuation);

    public final Object e0(Collection collection, boolean z2, Continuation continuation) {
        return j0(new SimpleSQLiteQuery("SELECT * FROM ApplicationProfileRelation WHERE " + ("profileId IN (" + CollectionsKt.joinToString$default(collection, null, null, null, 0, null, null, 63, null) + ")") + " " + (z2 ? "" : "AND flags = 0") + ";"), continuation);
    }

    public final Object g0(Collection collection, Collection collection2, boolean z2, Continuation continuation) {
        return j0(new SimpleSQLiteQuery("SELECT * FROM ApplicationProfileRelation WHERE " + ("profileId IN (" + CollectionsKt.joinToString$default(collection, null, null, null, 0, null, null, 63, null) + ")") + " " + ("AND packageName IN (" + CollectionsKt.joinToString$default(collection2, null, null, null, 0, null, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.f0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ApplicationProfileRelationDao.i0((String) obj);
            }
        }, 31, null) + ")") + " " + (z2 ? "" : "AND flags = 0") + ";"), continuation);
    }

    public abstract Object j0(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k0(java.util.Collection r17, boolean r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao.k0(java.util.Collection, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
