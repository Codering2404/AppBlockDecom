package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.sqlite.db.SupportSQLiteQuery;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class WebsiteProfileRelationDao implements BaseDao<WebsiteProfileRelation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f125303a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object J(boolean r11, boolean r12, kotlin.coroutines.Continuation r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r11 != 0) goto L22
            cz.mobilesoft.coreblock.enums.ProfileType r11 = cz.mobilesoft.coreblock.enums.ProfileType.QUICK_BLOCK
            int r11 = r11.mask()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "p.typeCombinations != "
            r12.append(r1)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r0.add(r11)
            goto L43
        L22:
            if (r12 == 0) goto L43
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r11 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r11 = r11.f()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "(p.typeCombinations = p.onConditions OR p.onUntil > "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = ")"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.add(r11)
        L43:
            boolean r11 = r0.isEmpty()
            r12 = 0
            if (r11 != 0) goto L4c
            r1 = r0
            goto L4d
        L4c:
            r1 = r12
        L4d:
            if (r1 == 0) goto L5d
            r8 = 62
            r9 = 0
            java.lang.String r2 = " AND "
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            java.lang.String r12 = kotlin.collections.CollectionsKt.joinToString$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
        L5d:
            if (r12 == 0) goto L72
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "AND "
            r11.append(r0)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            if (r11 != 0) goto L74
        L72:
            java.lang.String r11 = ""
        L74:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "SELECT COUNT(*) FROM WebsiteProfileRelation w JOIN Profile p ON w.profileId = p.id "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = ";"
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            androidx.sqlite.db.SimpleSQLiteQuery r12 = new androidx.sqlite.db.SimpleSQLiteQuery
            r12.<init>(r11)
            java.lang.Object r11 = r10.K(r12, r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao.J(boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public abstract Flow L();

    public abstract Object M(long j3, Continuation continuation);

    public abstract Object N(Collection collection, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(boolean r5, boolean r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyBlocked$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyBlocked$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyBlocked$1) r0
            int r1 = r0.f125308f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125308f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyBlocked$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyBlocked$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f125306c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125308f
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            r0.f125304a = r5
            r0.f125305b = r6
            r0.f125308f = r3
            java.lang.Object r7 = r4.J(r5, r6, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            java.lang.Number r7 = (java.lang.Number) r7
            long r5 = r7.longValue()
            r0 = 0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L4e
            goto L4f
        L4e:
            r3 = 0
        L4f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao.O(boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object P(long r5, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyByProfileId$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyByProfileId$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyByProfileId$1) r0
            int r1 = r0.f125312d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125312d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyByProfileId$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao$existAnyByProfileId$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f125310b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125312d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            r0.f125309a = r5
            r0.f125312d = r3
            java.lang.Object r7 = r4.M(r5, r0)
            if (r7 != r1) goto L3f
            return r1
        L3f:
            java.lang.Number r7 = (java.lang.Number) r7
            long r5 = r7.longValue()
            r0 = 0
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 <= 0) goto L4c
            goto L4d
        L4c:
            r3 = 0
        L4d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao.P(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object Q(Collection collection, Continuation continuation);

    public abstract Object R(long j3, Continuation continuation);

    public abstract Object S(Collection collection, Continuation continuation);

    public abstract Object T(Collection collection, Collection collection2, Continuation continuation);
}
