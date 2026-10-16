package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.ApplicationBlockingType;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
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
public abstract class ProfileDao implements BaseDao<Profile> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f125084a;

        static {
            int[] iArr = new int[ApplicationBlockingType.values().length];
            try {
                iArr[ApplicationBlockingType.Launch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApplicationBlockingType.Notification.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f125084a = iArr;
        }
    }

    public static /* synthetic */ Object C0(ProfileDao profileDao, int i3, long j3, Continuation continuation, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllByTypeAndEnabled");
        }
        if ((i4 & 2) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileDao.B0(i3, j3, continuation);
    }

    public static /* synthetic */ Object E0(ProfileDao profileDao, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllCurrentlyOn");
        }
        if ((i3 & 1) != 0) {
            bool = null;
        }
        if ((i3 & 2) != 0) {
            bool2 = null;
        }
        if ((i3 & 4) != 0) {
            bool3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        if ((i3 & 16) != 0) {
            urlDto = null;
        }
        if ((i3 & 32) != 0) {
            bool4 = null;
        }
        if ((i3 & 64) != 0) {
            bool5 = null;
        }
        return profileDao.D0(bool, bool2, bool3, str, urlDto, bool4, bool5, continuation);
    }

    static /* synthetic */ Object F0(ProfileDao profileDao, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return profileDao.y0(H0(profileDao, "SELECT * FROM Profile T", bool, bool2, bool3, str, urlDto, bool4, bool5, 0L, Function.MAX_NARGS, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.sqlite.db.SimpleSQLiteQuery G0(java.lang.String r17, java.lang.Boolean r18, java.lang.Boolean r19, java.lang.Boolean r20, java.lang.String r21, cz.mobilesoft.coreblock.dto.UrlDto r22, java.lang.Boolean r23, java.lang.Boolean r24, long r25) {
        /*
            Method dump skipped, instruction units count: 732
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.G0(java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, cz.mobilesoft.coreblock.dto.UrlDto, java.lang.Boolean, java.lang.Boolean, long):androidx.sqlite.db.SimpleSQLiteQuery");
    }

    static /* synthetic */ SimpleSQLiteQuery H0(ProfileDao profileDao, String str, Boolean bool, Boolean bool2, Boolean bool3, String str2, UrlDto urlDto, Boolean bool4, Boolean bool5, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllCurrentlyOnQuery");
        }
        if ((i3 & 2) != 0) {
            bool = null;
        }
        if ((i3 & 4) != 0) {
            bool2 = null;
        }
        if ((i3 & 8) != 0) {
            bool3 = null;
        }
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        if ((i3 & 32) != 0) {
            urlDto = null;
        }
        if ((i3 & 64) != 0) {
            bool4 = null;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            bool5 = null;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileDao.G0(str, bool, bool2, bool3, str2, urlDto, bool4, bool5, j3);
    }

    public static /* synthetic */ Object J0(ProfileDao profileDao, long j3, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllEnabled");
        }
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileDao.I0(j3, continuation);
    }

    public static /* synthetic */ Object M(ProfileDao profileDao, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllCurrentlyOn");
        }
        if ((i3 & 1) != 0) {
            bool = null;
        }
        if ((i3 & 2) != 0) {
            bool2 = null;
        }
        if ((i3 & 4) != 0) {
            bool3 = null;
        }
        if ((i3 & 8) != 0) {
            str = null;
        }
        if ((i3 & 16) != 0) {
            urlDto = null;
        }
        if ((i3 & 32) != 0) {
            bool4 = null;
        }
        if ((i3 & 64) != 0) {
            bool5 = null;
        }
        return profileDao.L(bool, bool2, bool3, str, urlDto, bool4, bool5, continuation);
    }

    public static /* synthetic */ Object M0(ProfileDao profileDao, ProfileType profileType, List list, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllIndefinitelyOn");
        }
        if ((i3 & 1) != 0) {
            profileType = null;
        }
        if ((i3 & 2) != 0) {
            list = null;
        }
        return profileDao.L0(profileType, list, continuation);
    }

    static /* synthetic */ Object N(ProfileDao profileDao, Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return profileDao.K(H0(profileDao, "SELECT COUNT(*) FROM Profile T", bool, bool2, bool3, str, urlDto, bool4, bool5, 0L, Function.MAX_NARGS, null), continuation);
    }

    static /* synthetic */ Object N0(ProfileDao profileDao, ProfileType profileType, List list, Continuation continuation) {
        String str = "\n            SELECT * FROM Profile p\n            WHERE (\n                (\n                    p.operator = 0\n                    AND p.typeCombinations = p.onConditions\n                ) OR (\n                    p.operator = 1\n                    AND p.typeCombinations & p.onConditions <> 0\n                )\n            )\n            ";
        if (profileType != null) {
            str = "\n            SELECT * FROM Profile p\n            WHERE (\n                (\n                    p.operator = 0\n                    AND p.typeCombinations = p.onConditions\n                ) OR (\n                    p.operator = 1\n                    AND p.typeCombinations & p.onConditions <> 0\n                )\n            )\n             AND p.typeCombinations & " + profileType.mask() + " <> 0";
        }
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            str = str + " AND p.id NOT IN (" + StringHelperExtKt.s(list, null, null, 3, null) + ")";
        }
        return profileDao.y0(new SimpleSQLiteQuery(StringsKt.n(str)), continuation);
    }

    public static /* synthetic */ Object Q(ProfileDao profileDao, long j3, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllNonHiddenByEnabled");
        }
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileDao.P(j3, continuation);
    }

    public static /* synthetic */ Object S0(ProfileDao profileDao, long j3, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllPaused");
        }
        if ((i3 & 1) != 0) {
            j3 = TimeHelperExt.f128663a.f();
        }
        return profileDao.R0(j3, continuation);
    }

    public static /* synthetic */ Object W(ProfileDao profileDao, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: countAllWithInAppPurchaseBlocking");
        }
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return profileDao.V(z2, continuation);
    }

    static /* synthetic */ Object X(ProfileDao profileDao, boolean z2, Continuation continuation) {
        List listMutableListOf = CollectionsKt.mutableListOf("p.blockInAppPurchases = 1");
        if (!z2) {
            listMutableListOf.add("p.typeCombinations != 64");
        }
        return profileDao.K(new SimpleSQLiteQuery("SELECT COUNT(*) FROM Profile p WHERE " + StringHelperExtKt.s(listMutableListOf, " AND ", null, 2, null) + ";"), continuation);
    }

    private final String a0(boolean z2, boolean z3) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (!z2) {
            arrayList.add("p.typeCombinations != " + ProfileType.STRICT_MODE.mask());
        }
        if (!z3) {
            arrayList.add("p.typeCombinations != " + ProfileType.QUICK_BLOCK.mask());
        }
        if (arrayList.isEmpty()) {
            str = "";
        } else {
            str = "WHERE " + StringHelperExtKt.s(arrayList, " AND ", null, 2, null);
        }
        return "SELECT * FROM Profile p " + str + ";";
    }

    static /* synthetic */ Object d0(ProfileDao profileDao, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, Continuation continuation) {
        int limitValue = Limit.APP_LIMIT.getLimitValue();
        int limitValue2 = Limit.WEBSITE_LIMIT.getLimitValue();
        int limitValue3 = Limit.TIMES_LIMIT.getLimitValue();
        Limit limit = Limit.USAGE_LIMIT;
        Object objN1 = profileDao.n1(new SimpleSQLiteQuery(StringsKt.n("\n            UPDATE Profile SET pausedUntil = -2\n            WHERE typeCombinations != 64\n            AND typeCombinations != -2147483648\n            AND (\n                blockingMode = 1\n                OR (" + z2 + " = 0 AND addNewApplications = 1)\n                OR (" + z3 + " = 0 AND blockUnsupportedBrowsers = 1)\n                OR (" + z9 + " = 0 AND blockAdultContent = 1)\n                OR (" + z10 + " = 0 AND blockInAppPurchases = 1)\n                OR (\n                    " + z4 + " = 0 AND (\n                        SELECT COUNT(*) FROM ApplicationProfileRelation\n                        WHERE ApplicationProfileRelation.profileId = Profile.id\n                        AND ApplicationProfileRelation.flags = 0\n                    ) > " + limitValue + "\n                ) OR (\n                    " + z5 + " = 0 AND (\n                        SELECT COUNT(*) FROM WebsiteProfileRelation\n                        WHERE profileId = Profile.id\n                    ) > " + limitValue2 + "\n                ) OR (\n                    " + z6 + " = 0 AND (\n                        SELECT COUNT(*) FROM Interval\n                        WHERE Interval.profileId = Profile.id\n                        AND Interval.parentId IS NULL\n                    ) > " + limitValue3 + "\n                ) OR (\n                    " + z7 + " = 0 AND EXISTS (\n                        SELECT profileId FROM UsageLimit\n                        WHERE limitType = 0\n                        AND profileId = Profile.id\n                        AND allowedCount > (" + limit.getLimitValue() + " * 60 * 1000)\n                    )\n                ) OR ( \n                    " + z8 + " = 0 AND EXISTS (\n                        SELECT profileId FROM UsageLimit\n                        WHERE limitType = 1\n                        AND profileId = Profile.id\n                        AND allowedCount > " + limit.getLimitValue() + "\n                    )\n                ) OR (\n                    " + z12 + " = 1 AND onConditions & 1 != 0 AND (dayFlags & (dayFlags - 1)) != 0\n                ) OR ( \n                    " + z11 + " = 0 AND (\n                        SELECT 1 FROM SubAppRelation\n                        WHERE profileId = Profile.id\n                    ) > 0\n                )\n            )\n            ")), continuation);
        return objN1 == IntrinsicsKt.f() ? objN1 : Unit.f139807a;
    }

    static /* synthetic */ Object f0(ProfileDao profileDao, Continuation continuation) {
        Object objN1 = profileDao.n1(new SimpleSQLiteQuery(StringsKt.n("\n            UPDATE Profile SET pausedUntil = -2\n            WHERE id NOT IN (\n                /*\n                 * Nested select because we must use limit and order only on non-QB and non-SM profiles, \n                 * while UNION requires ORDER BY and LIMIT to be set to the whole result, after UNION,\n                 * which we use to also exclude QB and SM from the top-level UPDATE.\n                 */\n                SELECT * FROM (\n                    SELECT id FROM Profile\n                    WHERE typeCombinations != 64\n                    AND typeCombinations != -2147483648\n                    AND pausedUntil >= 0\n                    ORDER BY id \n                    LIMIT " + Limit.PROFILE_LIMIT.getLimitValue() + "\n                ) UNION\n                SELECT id FROM Profile\n                WHERE typeCombinations = 64\n                OR typeCombinations = -2147483648\n                OR pausedUntil <= -1\n            )\n            ")), continuation);
        return objN1 == IntrinsicsKt.f() ? objN1 : Unit.f139807a;
    }

    public static /* synthetic */ Object h0(ProfileDao profileDao, int i3, long j3, long j4, Continuation continuation, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableOrApplyStrictModeLimit");
        }
        if ((i4 & 4) != 0) {
            j4 = TimeHelperExt.f128663a.f() + TimeUnit.HOURS.toMillis(Limit.STRICT_MODE_LIMIT.getLimitValue());
        }
        return profileDao.g0(i3, j3, j4, continuation);
    }

    static /* synthetic */ Object k1(ProfileDao profileDao, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Continuation continuation) {
        Limit limit = Limit.APP_WEB_LIMIT_QUICK_BLOCK;
        Object objN1 = profileDao.n1(new SimpleSQLiteQuery(StringsKt.n("\n            UPDATE Profile\n            SET onConditions = 0, onUntil = -2\n            WHERE typeCombinations = 64\n            AND (\n                blockingMode = 1\n                OR (" + z2 + " = 0 AND addNewApplications = 1)\n                OR (" + z3 + " = 0 AND blockUnsupportedBrowsers = 1)\n                OR (" + z6 + " = 0 AND blockAdultContent = 1)\n                OR (" + z7 + " = 0 AND blockInAppPurchases = 1)\n                OR (\n                    " + z4 + " = 0 AND (\n                        SELECT COUNT(*) FROM ApplicationProfileRelation\n                        WHERE profileId = Profile.id\n                        AND ApplicationProfileRelation.flags = 0\n                    ) > " + limit.getLimitValue() + "\n                ) OR (\n                    " + z5 + " = 0 AND (\n                        SELECT COUNT(*) FROM WebsiteProfileRelation\n                        WHERE profileId = Profile.id\n                    ) > " + limit.getLimitValue() + "\n                ) OR (\n                    " + z8 + " = 0 AND (\n                        SELECT COUNT(*) FROM SubAppRelation\n                        WHERE profileId = Profile.id\n                    ) > 0\n                )\n            )\n            ")), continuation);
        return objN1 == IntrinsicsKt.f() ? objN1 : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
    
        if (r7.r(r2, r0) == r1) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object m1(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$unlockAll$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$unlockAll$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$unlockAll$1) r0
            int r1 = r0.f125111f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125111f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$unlockAll$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$unlockAll$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f125109c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125111f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r7 = r0.f125108b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r7 = r0.f125107a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r7
            kotlin.ResultKt.b(r8)
            goto L8a
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            java.lang.Object r7 = r0.f125107a
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao r7 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) r7
            kotlin.ResultKt.b(r8)
            goto L56
        L44:
            kotlin.ResultKt.b(r8)
            long r5 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
            r0.f125107a = r7
            r0.f125111f = r4
            java.lang.Object r8 = r7.O0(r5, r0)
            if (r8 != r1) goto L56
            goto L89
        L56:
            java.util.List r8 = (java.util.List) r8
            java.util.Iterator r2 = r8.iterator()
        L5c:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L72
            java.lang.Object r4 = r2.next()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r4 = (cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile) r4
            r5 = 0
            r4.j0(r5)
            r5 = 0
            r4.k0(r5)
            goto L5c
        L72:
            r2 = r8
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f125107a = r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f125108b = r8
            r0.f125111f = r3
            java.lang.Object r7 = r7.r(r2, r0)
            if (r7 != r1) goto L8a
        L89:
            return r1
        L8a:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.m1(cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object n0(ProfileDao profileDao, ApplicationBlockingType applicationBlockingType, boolean z2, boolean z3, boolean z4, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: existAnyWithBlockedApplications");
        }
        if ((i3 & 1) != 0) {
            applicationBlockingType = null;
        }
        return profileDao.m0(applicationBlockingType, z2, z3, z4, continuation);
    }

    static /* synthetic */ Object q0(ProfileDao profileDao, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Continuation continuation) {
        Object objN1 = profileDao.n1(new SimpleSQLiteQuery(StringsKt.n("\n            UPDATE Profile SET pausedUntil = 0\n            WHERE pausedUntil = -2\n            AND typeCombinations != 64\n            AND typeCombinations != -2147483648\n            AND blockingMode = 0            \n            AND (" + z2 + " = 1 OR addNewApplications = 0)\n            AND (\n                " + z3 + " = 1 OR (\n                    SELECT COUNT(*) FROM ApplicationProfileRelation\n                    WHERE ApplicationProfileRelation.profileId = Profile.id\n                    AND ApplicationProfileRelation.flags = 0\n                ) <= " + Limit.APP_LIMIT.getLimitValue() + "\n            ) AND (\n                " + z4 + " = 1 OR (\n                    SELECT COUNT(*) FROM WebsiteProfileRelation\n                    WHERE profileId = Profile.id\n                ) <= " + Limit.WEBSITE_LIMIT.getLimitValue() + "\n            ) AND (\n                " + z5 + " = 1 OR (\n                    SELECT COUNT(*) FROM Interval\n                    WHERE Interval.profileId = Profile.id\n                    AND Interval.parentId IS NULL\n                ) <= " + Limit.TIMES_LIMIT.getLimitValue() + "\n            ) AND (\n                " + z6 + " = 1 OR NOT EXISTS (\n                    SELECT profileId FROM UsageLimit\n                    WHERE limitType = 0\n                    AND profileId = Profile.id\n                    AND allowedCount > (" + Limit.USAGE_LIMIT.getLimitValue() + " * 60 * 1000)\n                )\n            ) AND ( \n                " + z7 + " = 1 OR NOT EXISTS (\n                    SELECT profileId FROM UsageLimit\n                    WHERE limitType = 1\n                    AND profileId = Profile.id\n                    AND allowedCount > " + Limit.LAUNCH_COUNT.getLimitValue() + "\n                )\n            )\n            ")), continuation);
        return objN1 == IntrinsicsKt.f() ? objN1 : Unit.f139807a;
    }

    public static /* synthetic */ Object u0(ProfileDao profileDao, ProfileType profileType, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAll");
        }
        if ((i3 & 1) != 0) {
            profileType = null;
        }
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return profileDao.r0(profileType, z2, continuation);
    }

    public static /* synthetic */ Object v0(ProfileDao profileDao, boolean z2, boolean z3, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAll");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return profileDao.s0(z2, z3, continuation);
    }

    static /* synthetic */ Object w0(ProfileDao profileDao, boolean z2, boolean z3, Continuation continuation) {
        return profileDao.y0(new SimpleSQLiteQuery(StringsKt.n(profileDao.a0(z2, z3))), continuation);
    }

    public abstract Object A0(int i3, Continuation continuation);

    public abstract Object B0(int i3, long j3, Continuation continuation);

    public Object D0(Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return F0(this, bool, bool2, bool3, str, urlDto, bool4, bool5, continuation);
    }

    public abstract Object I0(long j3, Continuation continuation);

    public final Object J(ProfileType profileType, boolean z2, Continuation continuation) {
        return (profileType != null || z2) ? (profileType == null && z2) ? Q(this, 0L, continuation, 1, null) : (profileType == null || z2) ? (profileType == null || !z2) ? Boxing.e(0L) : R(profileType.mask(), continuation) : R(profileType.mask(), continuation) : O(continuation);
    }

    public abstract Object K(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public abstract Object K0(Continuation continuation);

    public Object L(Boolean bool, Boolean bool2, Boolean bool3, String str, UrlDto urlDto, Boolean bool4, Boolean bool5, Continuation continuation) {
        return N(this, bool, bool2, bool3, str, urlDto, bool4, bool5, continuation);
    }

    public Object L0(ProfileType profileType, List list, Continuation continuation) {
        return N0(this, profileType, list, continuation);
    }

    public abstract Object O(Continuation continuation);

    public abstract Object O0(long j3, Continuation continuation);

    public abstract Object P(long j3, Continuation continuation);

    public abstract Object P0(Continuation continuation);

    public abstract Flow Q0();

    public abstract Object R(int i3, Continuation continuation);

    public abstract Object R0(long j3, Continuation continuation);

    public abstract Object S(Continuation continuation);

    public abstract Object T(Continuation continuation);

    public abstract Object T0(Continuation continuation);

    public final Object U(ApplicationBlockingType applicationBlockingType, boolean z2, boolean z3, boolean z4, Continuation continuation) {
        int i3 = applicationBlockingType == null ? -1 : WhenMappings.f125084a[applicationBlockingType.ordinal()];
        List listMutableListOf = CollectionsKt.mutableListOf(i3 != 1 ? i3 != 2 ? "(p.blockLaunch = 1 OR p.blockNotifications = 1)" : "p.blockNotifications = 1" : "p.blockLaunch = 1");
        if (!z2) {
            listMutableListOf.add("p.typeCombinations != " + ProfileType.STRICT_MODE.mask());
        }
        if (!z3) {
            listMutableListOf.add("p.typeCombinations != " + ProfileType.QUICK_BLOCK.mask());
        } else if (z4) {
            listMutableListOf.add("(p.typeCombinations != " + ProfileType.QUICK_BLOCK.mask() + " OR p.typeCombinations = p.onConditions OR p.onUntil > " + TimeHelperExt.f128663a.f() + ")");
        }
        return K(new SimpleSQLiteQuery(StringsKt.n("\n            SELECT COUNT(*) FROM Profile p\n            WHERE " + StringHelperExtKt.s(listMutableListOf, " AND ", null, 2, null) + "\n            AND (\n                p.blockingMode = " + Profile.BlockingMode.Allowlist.getId() + "\n                OR (\n                    p.blockingMode = " + Profile.BlockingMode.Blocklist.getId() + "\n                    AND (\n                        p.addNewApplications = 1\n                        OR p.blockUnsupportedBrowsers = 1\n                        OR EXISTS (\n                            SELECT * FROM ApplicationProfileRelation ar\n                            WHERE ar.profileId = p.id\n                        )\n                    )\n                )\n            )\n            ")), continuation);
    }

    public abstract Object U0(Continuation continuation);

    public Object V(boolean z2, Continuation continuation) {
        return X(this, z2, continuation);
    }

    public abstract Flow V0();

    public abstract Object W0(Continuation continuation);

    public abstract Object X0(Continuation continuation);

    public abstract Object Y(long j3, Continuation continuation);

    public abstract Flow Y0();

    public abstract Object Z(long j3, Continuation continuation);

    public Flow Z0(boolean z2, boolean z3) {
        return z0(new SimpleSQLiteQuery(StringsKt.n(a0(z2, z3))));
    }

    public abstract Object a(Collection collection, Continuation continuation);

    public abstract Object a1(Continuation continuation);

    public abstract Object b0(Continuation continuation);

    public abstract Flow b1(long j3);

    public Object c0(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, Continuation continuation) {
        return d0(this, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, continuation);
    }

    public abstract Flow c1();

    public abstract Object d1(Continuation continuation);

    public abstract Object e(long j3, Continuation continuation);

    public Object e0(Continuation continuation) {
        return f0(this, continuation);
    }

    public abstract Object e1(Continuation continuation);

    public abstract Flow f1();

    public abstract Object g0(int i3, long j3, long j4, Continuation continuation);

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isAnyStrictModeEnabled$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isAnyStrictModeEnabled$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isAnyStrictModeEnabled$1) r0
            int r1 = r0.f125103c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125103c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isAnyStrictModeEnabled$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isAnyStrictModeEnabled$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f125101a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125103c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r7 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r4 = r7.f()
            r0.f125103c = r3
            java.lang.Object r7 = r6.Z(r4, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = 0
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 <= 0) goto L50
            goto L51
        L50:
            r3 = 0
        L51:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.g1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isQuickBlockCurrentlyOn$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isQuickBlockCurrentlyOn$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isQuickBlockCurrentlyOn$1) r0
            int r1 = r0.f125106c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125106c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isQuickBlockCurrentlyOn$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$isQuickBlockCurrentlyOn$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f125104a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125106c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L41
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            long r4 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.c()
            r0.f125106c = r3
            java.lang.Object r7 = r6.Y(r4, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = 0
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 <= 0) goto L4e
            goto L4f
        L4e:
            r3 = 0
        L4f:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.h1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object i0(boolean z2, Continuation continuation);

    public abstract Object i1(Continuation continuation);

    public abstract Object j0(List list, Continuation continuation);

    public Object j1(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, Continuation continuation) {
        return k1(this, z2, z3, z4, z5, z6, z7, z8, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k0(cz.mobilesoft.coreblock.enums.ProfileType[] r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyByTypes$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyByTypes$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyByTypes$1) r0
            int r1 = r0.f125089f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125089f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyByTypes$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyByTypes$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f125087c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125089f
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r8 = r0.f125085a
            cz.mobilesoft.coreblock.enums.ProfileType[] r8 = (cz.mobilesoft.coreblock.enums.ProfileType[]) r8
            kotlin.ResultKt.b(r9)
            goto L59
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.b(r9)
            int r9 = r8.length
            r2 = r3
            r5 = r2
        L3c:
            if (r2 >= r9) goto L48
            r6 = r8[r2]
            int r6 = r6.mask()
            r5 = r5 | r6
            int r2 = r2 + 1
            goto L3c
        L48:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f125085a = r8
            r0.f125086b = r5
            r0.f125089f = r4
            java.lang.Object r9 = r7.R(r5, r0)
            if (r9 != r1) goto L59
            return r1
        L59:
            java.lang.Number r9 = (java.lang.Number) r9
            long r8 = r9.longValue()
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 <= 0) goto L66
            r3 = r4
        L66:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.k0(cz.mobilesoft.coreblock.enums.ProfileType[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l0(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyForLocationPermission$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyForLocationPermission$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyForLocationPermission$1) r0
            int r1 = r0.f125093d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f125093d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyForLocationPermission$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyForLocationPermission$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f125091b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f125093d
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L40
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            r7 = 6
            r0.f125090a = r7
            r0.f125093d = r3
            java.lang.Object r7 = r6.R(r7, r0)
            if (r7 != r1) goto L40
            return r1
        L40:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = 0
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 <= 0) goto L4d
            goto L4e
        L4d:
            r3 = 0
        L4e:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.l0(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object l1(Continuation continuation) {
        return m1(this, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m0(cz.mobilesoft.coreblock.enums.ApplicationBlockingType r9, boolean r10, boolean r11, boolean r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyWithBlockedApplications$1
            if (r0 == 0) goto L14
            r0 = r13
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyWithBlockedApplications$1 r0 = (cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyWithBlockedApplications$1) r0
            int r1 = r0.f125100h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f125100h = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyWithBlockedApplications$1 r0 = new cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao$existAnyWithBlockedApplications$1
            r0.<init>(r8, r13)
            goto L12
        L1a:
            java.lang.Object r13 = r6.f125098f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f125100h
            r7 = 1
            if (r1 == 0) goto L37
            if (r1 != r7) goto L2f
            java.lang.Object r9 = r6.f125094a
            cz.mobilesoft.coreblock.enums.ApplicationBlockingType r9 = (cz.mobilesoft.coreblock.enums.ApplicationBlockingType) r9
            kotlin.ResultKt.b(r13)
            goto L54
        L2f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            kotlin.ResultKt.b(r13)
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r6.f125094a = r13
            r6.f125095b = r10
            r6.f125096c = r11
            r6.f125097d = r12
            r6.f125100h = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            java.lang.Object r13 = r1.U(r2, r3, r4, r5, r6)
            if (r13 != r0) goto L54
            return r0
        L54:
            java.lang.Number r13 = (java.lang.Number) r13
            long r9 = r13.longValue()
            r11 = 0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 <= 0) goto L61
            goto L62
        L61:
            r7 = 0
        L62:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao.m0(cz.mobilesoft.coreblock.enums.ApplicationBlockingType, boolean, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object n1(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public final Object o0(PremiumState premiumState, Continuation continuation) {
        if (AccessPolicyKt.a(premiumState, Capability.PremiumAccess)) {
            return Unit.f139807a;
        }
        Object objP0 = p0(premiumState.f(Product.ANIA), premiumState.f(Product.APPLICATIONS), premiumState.f(Product.WEBSITES), premiumState.f(Product.TIMES), premiumState.f(Product.USAGE_LIMIT), premiumState.f(Product.LAUNCH_COUNT), continuation);
        return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
    }

    public Object p0(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Continuation continuation) {
        return q0(this, z2, z3, z4, z5, z6, z7, continuation);
    }

    public final Object r0(ProfileType profileType, boolean z2, Continuation continuation) {
        return (profileType == null && z2) ? J0(this, 0L, continuation, 1, null) : (profileType != null || z2) ? (profileType == null || !z2) ? (profileType == null || z2) ? CollectionsKt.emptyList() : A0(profileType.mask(), continuation) : C0(this, profileType.mask(), 0L, continuation, 2, null) : t0(continuation);
    }

    public Object s0(boolean z2, boolean z3, Continuation continuation) {
        return w0(this, z2, z3, continuation);
    }

    public abstract Object t0(Continuation continuation);

    public abstract Object x0(List list, List list2, Continuation continuation);

    public abstract Object y0(SupportSQLiteQuery supportSQLiteQuery, Continuation continuation);

    public abstract Flow z0(SupportSQLiteQuery supportSQLiteQuery);
}
