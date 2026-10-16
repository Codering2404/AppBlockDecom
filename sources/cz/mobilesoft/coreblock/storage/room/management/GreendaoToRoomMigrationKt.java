package cz.mobilesoft.coreblock.storage.room.management;

import android.content.Context;
import android.database.Cursor;
import com.facebook.share.internal.ShareConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.enums.Category;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.AppWebsiteCategoryRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WifiNetwork;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import cz.mobilesoft.coreblock.storage.room.entity.core.LaunchTimeEntity;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.MissingRelatedEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class GreendaoToRoomMigrationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List A(Context context, Set set, Cursor cursor) {
        int i3;
        String str;
        Cursor tryQuery = cursor;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex(ShareConstants.TITLE);
        int columnIndex3 = tryQuery.getColumnIndex("DAY_FLAGS");
        int columnIndex4 = tryQuery.getColumnIndex("BLOCK_NOTIFICATIONS");
        int columnIndex5 = tryQuery.getColumnIndex("BLOCK_APPLICATIONS");
        int columnIndex6 = tryQuery.getColumnIndex("ADD_NEW_APPLICATIONS");
        int columnIndex7 = tryQuery.getColumnIndex("ACTIVE");
        int columnIndex8 = tryQuery.getColumnIndex("LOCKED");
        int columnIndex9 = tryQuery.getColumnIndex("LAST_START_TIME");
        int columnIndex10 = tryQuery.getColumnIndex("ON_UNTIL");
        int columnIndex11 = tryQuery.getColumnIndex("LOCKED_UNTIL");
        int columnIndex12 = tryQuery.getColumnIndex("LOCK_AT");
        int columnIndex13 = tryQuery.getColumnIndex("TYPE_COMBINATIONS");
        int columnIndex14 = tryQuery.getColumnIndex("ON_CONDITIONS");
        int columnIndex15 = tryQuery.getColumnIndex("OPERATOR");
        while (tryQuery.moveToNext()) {
            long j3 = tryQuery.getLong(columnIndex);
            String string = tryQuery.getString(columnIndex2);
            int i4 = columnIndex;
            if (string == null) {
                i3 = columnIndex2;
                String string2 = context.getString(R.string.Ek);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                str = string2;
            } else {
                i3 = columnIndex2;
                str = string;
            }
            int i5 = !tryQuery.isNull(columnIndex3) ? tryQuery.getInt(columnIndex3) : 0;
            boolean z2 = (tryQuery.isNull(columnIndex4) || tryQuery.getInt(columnIndex4) == 0) ? false : true;
            boolean z3 = (tryQuery.isNull(columnIndex5) || tryQuery.getInt(columnIndex5) == 0) ? false : true;
            boolean z4 = (columnIndex6 == -1 || tryQuery.isNull(columnIndex6) || tryQuery.getInt(columnIndex6) == 0) ? false : true;
            Profile.PausedUntil pausedUntil = tryQuery.getInt(columnIndex7) != 0 ? Profile.PausedUntil.NotPaused.f126480b : Profile.PausedUntil.DisabledByUser.f126479b;
            arrayList.add(new Profile(j3, str, tryQuery.getInt(columnIndex13), tryQuery.getInt(columnIndex14), tryQuery.getInt(columnIndex15), i5, z2, z3, z4, false, tryQuery.getInt(columnIndex8) != 0, !tryQuery.isNull(columnIndex9) ? tryQuery.getLong(columnIndex9) : 0L, tryQuery.getLong(columnIndex10), tryQuery.getLong(columnIndex11), tryQuery.getLong(columnIndex12), pausedUntil, null, null, false, false, false, 0, null, 8323584, null));
            set.add(Long.valueOf(j3));
            tryQuery = cursor;
            columnIndex = i4;
            columnIndex2 = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List B(Set set, Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("APPLICATION_PACKAGE");
        int columnIndex3 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex4 = tryQuery.getColumnIndex("ENABLED");
        int columnIndex5 = tryQuery.getColumnIndex("FLAGS");
        int i3 = 0;
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex2)) {
                long j3 = tryQuery.getLong(columnIndex3);
                if (set.contains(Long.valueOf(j3))) {
                    long j4 = tryQuery.getLong(columnIndex);
                    String string = tryQuery.getString(columnIndex2);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    arrayList.add(new ApplicationProfileRelation(j4, string, j3, columnIndex4 == -1 || tryQuery.isNull(columnIndex4) || tryQuery.getInt(columnIndex4) != 0, columnIndex5 != -1 ? tryQuery.getInt(columnIndex5) : 0));
                } else {
                    i3++;
                }
            }
        }
        if (i3 > 0) {
            CrashHelper.j(new MissingRelatedEntityException("ApplicationProfileRelation", "Profile", i3));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List C(Set set, Cursor tryQuery) {
        int i3;
        WebsiteProfileRelation.BlockingType blockingTypeB;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("URL");
        int columnIndex3 = tryQuery.getColumnIndex("BLOCKING_TYPE");
        int columnIndex4 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex5 = tryQuery.getColumnIndex("ENABLED");
        int columnIndex6 = tryQuery.getColumnIndex("IS_ANYWHERE_IN_URL");
        int i4 = 0;
        while (tryQuery.moveToNext()) {
            if (tryQuery.isNull(columnIndex2)) {
                i3 = columnIndex;
            } else {
                long j3 = tryQuery.getLong(columnIndex4);
                if (set.contains(Long.valueOf(j3))) {
                    long j4 = tryQuery.getLong(columnIndex);
                    String string = tryQuery.getString(columnIndex2);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    if (tryQuery.isNull(columnIndex3)) {
                        i3 = columnIndex;
                        blockingTypeB = WebsiteProfileRelation.BlockingType.DOMAIN;
                    } else {
                        i3 = columnIndex;
                        blockingTypeB = WebsiteProfileRelation.BlockingType.Companion.b(tryQuery.getInt(columnIndex3));
                    }
                    WebsiteProfileRelation websiteProfileRelation = new WebsiteProfileRelation(j4, j3, string, blockingTypeB, (columnIndex6 == -1 || tryQuery.isNull(columnIndex6) || tryQuery.getInt(columnIndex6) == 0) ? false : true, columnIndex5 == -1 || tryQuery.isNull(columnIndex5) || tryQuery.getInt(columnIndex5) != 0);
                    if (i4 > 0) {
                        CrashHelper.j(new MissingRelatedEntityException("WebsiteProfileRelation", "Profile", i4));
                    }
                    arrayList.add(websiteProfileRelation);
                } else {
                    i4++;
                }
            }
            columnIndex = i3;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List D(Set set, Cursor cursor) {
        int i3;
        int i4;
        int i5;
        ArrayList arrayList;
        int i6;
        Cursor tryQuery = cursor;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList2 = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex3 = tryQuery.getColumnIndex("GEOFENCE_ID");
        int columnIndex4 = tryQuery.getColumnIndex("GEOFENCE_RADIUS");
        int columnIndex5 = tryQuery.getColumnIndex("LATITUDE");
        int columnIndex6 = tryQuery.getColumnIndex("LONGITUDE");
        int columnIndex7 = tryQuery.getColumnIndex("IS_INVERTED");
        int columnIndex8 = tryQuery.getColumnIndex("LOCALE");
        int columnIndex9 = tryQuery.getColumnIndex("FEATURE_NAME");
        int columnIndex10 = tryQuery.getColumnIndex("ADMIN_AREA");
        int columnIndex11 = tryQuery.getColumnIndex("SUB_ADMIN_AREA");
        int columnIndex12 = tryQuery.getColumnIndex("LOCALITY");
        int columnIndex13 = tryQuery.getColumnIndex("SUB_LOCALITY");
        int columnIndex14 = tryQuery.getColumnIndex("THOROUGHFARE");
        ArrayList arrayList3 = arrayList2;
        int columnIndex15 = tryQuery.getColumnIndex("SUB_THOROUGHFARE");
        int columnIndex16 = tryQuery.getColumnIndex("PREMISES");
        int columnIndex17 = tryQuery.getColumnIndex("POSTAL_CODE");
        int columnIndex18 = tryQuery.getColumnIndex("COUNTRY_CODE");
        int columnIndex19 = tryQuery.getColumnIndex("COUNTRY_NAME");
        int i7 = 0;
        while (tryQuery.moveToNext()) {
            if (tryQuery.isNull(columnIndex3)) {
                i3 = columnIndex;
                i4 = columnIndex2;
                i5 = columnIndex3;
                arrayList = arrayList3;
                i6 = i7;
            } else {
                long j3 = tryQuery.getLong(columnIndex2);
                i4 = columnIndex2;
                int i8 = i7;
                if (set.contains(Long.valueOf(j3))) {
                    long j4 = tryQuery.getLong(columnIndex);
                    String string = tryQuery.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    int i9 = tryQuery.getInt(columnIndex4);
                    double d3 = tryQuery.getDouble(columnIndex5);
                    double d4 = tryQuery.getDouble(columnIndex6);
                    boolean z2 = tryQuery.getInt(columnIndex7) != 0;
                    String string2 = tryQuery.getString(columnIndex8);
                    String string3 = tryQuery.getString(columnIndex9);
                    String string4 = tryQuery.getString(columnIndex10);
                    String string5 = tryQuery.getString(columnIndex11);
                    String string6 = tryQuery.getString(columnIndex12);
                    String string7 = tryQuery.getString(columnIndex13);
                    String string8 = tryQuery.getString(columnIndex14);
                    String string9 = tryQuery.getString(columnIndex15);
                    String string10 = tryQuery.getString(columnIndex16);
                    String string11 = tryQuery.getString(columnIndex17);
                    String string12 = tryQuery.getString(columnIndex18);
                    int i10 = columnIndex19;
                    GeoAddress geoAddress = new GeoAddress(j4, j3, string, i9, d3, d4, z2, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, tryQuery.getString(i10));
                    if (i8 > 0) {
                        columnIndex19 = i10;
                        i3 = columnIndex;
                        i5 = columnIndex3;
                        i6 = i8;
                        CrashHelper.j(new MissingRelatedEntityException("GeoAddress", "Profile", i6));
                    } else {
                        columnIndex19 = i10;
                        i3 = columnIndex;
                        i5 = columnIndex3;
                        i6 = i8;
                    }
                    arrayList = arrayList3;
                    arrayList.add(geoAddress);
                } else {
                    i7 = i8 + 1;
                    columnIndex2 = i4;
                }
            }
            arrayList3 = arrayList;
            i7 = i6;
            columnIndex2 = i4;
            columnIndex = i3;
            columnIndex3 = i5;
            tryQuery = cursor;
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List E(Set set, Cursor tryQuery) {
        boolean z2;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("FROM_IN_MINUTES");
        int columnIndex3 = tryQuery.getColumnIndex("TO_IN_MINUTES");
        int columnIndex4 = tryQuery.getColumnIndex("PARENT_ID");
        int columnIndex5 = tryQuery.getColumnIndex("GENERATED");
        int columnIndex6 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex7 = tryQuery.getColumnIndex("ENABLED");
        int i3 = 0;
        while (tryQuery.moveToNext()) {
            long j3 = tryQuery.getLong(columnIndex6);
            if (set.contains(Long.valueOf(j3))) {
                long j4 = tryQuery.getLong(columnIndex);
                long j5 = tryQuery.getLong(columnIndex2);
                long j6 = tryQuery.getLong(columnIndex3);
                Long lValueOf = tryQuery.isNull(columnIndex4) ? null : Long.valueOf(tryQuery.getLong(columnIndex4));
                boolean z3 = true;
                if (tryQuery.isNull(columnIndex5) || tryQuery.getInt(columnIndex5) == 0) {
                    z2 = true;
                    z3 = false;
                } else {
                    z2 = true;
                }
                Interval interval = new Interval(j4, j3, j5, j6, lValueOf, z3, (columnIndex7 == -1 || tryQuery.isNull(columnIndex7) || tryQuery.getInt(columnIndex7) != 0) ? z2 : false);
                if (i3 > 0) {
                    CrashHelper.j(new MissingRelatedEntityException("Interval", "Profile", i3));
                }
                arrayList.add(interval);
            } else {
                i3++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List F(Set set, Cursor tryQuery) {
        int i3;
        UsageLimit.PeriodType periodTypeB;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("CREATED");
        int columnIndex3 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex4 = tryQuery.getColumnIndex("ALLOWED_TIME");
        int columnIndex5 = tryQuery.getColumnIndex("USED_TIME");
        int columnIndex6 = tryQuery.getColumnIndex("PERIOD_TYPE");
        int columnIndex7 = tryQuery.getColumnIndex("LIMIT_TYPE");
        int columnIndex8 = tryQuery.getColumnIndex("ALLOWED_TIME_ORIGINAL");
        int i4 = 0;
        while (tryQuery.moveToNext()) {
            long j3 = tryQuery.getLong(columnIndex3);
            if (set.contains(Long.valueOf(j3))) {
                long j4 = tryQuery.getLong(columnIndex);
                long j5 = tryQuery.getLong(columnIndex2);
                long j6 = tryQuery.getLong(columnIndex4);
                long j7 = tryQuery.getLong(columnIndex5);
                if (tryQuery.isNull(columnIndex6)) {
                    i3 = columnIndex;
                    periodTypeB = UsageLimit.PeriodType.DAILY;
                } else {
                    i3 = columnIndex;
                    periodTypeB = UsageLimit.PeriodType.Companion.b(tryQuery.getInt(columnIndex6));
                }
                UsageLimit usageLimit = new UsageLimit(j4, j3, periodTypeB, !tryQuery.isNull(columnIndex7) ? UsageLimit.LimitType.Companion.b(tryQuery.getInt(columnIndex7)) : UsageLimit.LimitType.TIME, j5, j6, j7, columnIndex8 != -1 ? tryQuery.getLong(columnIndex8) : 0L);
                if (i4 > 0) {
                    CrashHelper.j(new MissingRelatedEntityException("UsageLimit", "Profile", i4));
                }
                arrayList.add(usageLimit);
                columnIndex = i3;
            } else {
                i4++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List G(Set set, Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex3 = tryQuery.getColumnIndex("SSID");
        int i3 = 0;
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex3)) {
                long j3 = tryQuery.getLong(columnIndex2);
                if (set.contains(Long.valueOf(j3))) {
                    long j4 = tryQuery.getLong(columnIndex);
                    String string = tryQuery.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    WifiNetwork wifiNetwork = new WifiNetwork(j4, j3, string);
                    if (i3 > 0) {
                        CrashHelper.j(new MissingRelatedEntityException("WifiNetwork", "Profile", i3));
                    }
                    arrayList.add(wifiNetwork);
                } else {
                    i3++;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (t(r5, r7, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object H(android.database.sqlite.SQLiteDatabase r5, android.content.Context r6, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateToBlocking$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateToBlocking$1 r0 = (cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateToBlocking$1) r0
            int r1 = r0.f126758f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f126758f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateToBlocking$1 r0 = new cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt$migrateToBlocking$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f126757d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f126758f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L52
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r5 = r0.f126756c
            cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r5 = (cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase) r5
            java.lang.Object r5 = r0.f126755b
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Object r5 = r0.f126754a
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5
            kotlin.ResultKt.b(r8)
            goto L83
        L38:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L40:
            java.lang.Object r5 = r0.f126756c
            r7 = r5
            cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r7 = (cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase) r7
            java.lang.Object r5 = r0.f126755b
            r6 = r5
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Object r5 = r0.f126754a
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5
            kotlin.ResultKt.b(r8)
            goto L68
        L52:
            kotlin.ResultKt.b(r8)
            r0.f126754a = r5
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f126755b = r8
            r0.f126756c = r7
            r0.f126758f = r4
            java.lang.Object r8 = z(r5, r6, r7, r0)
            if (r8 != r1) goto L68
            goto L82
        L68:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f126754a = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f126755b = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f126756c = r6
            r0.f126758f = r3
            java.lang.Object r5 = t(r5, r7, r0)
            if (r5 != r1) goto L83
        L82:
            return r1
        L83:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt.H(android.database.sqlite.SQLiteDatabase, android.content.Context, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f7, code lost:
    
        if (r2.t(r6, r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object I(android.database.sqlite.SQLiteDatabase r11, cz.mobilesoft.coreblock.storage.room.management.CoreDatabase r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt.I(android.database.sqlite.SQLiteDatabase, cz.mobilesoft.coreblock.storage.room.management.CoreDatabase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List J(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        int columnIndex = tryQuery.getColumnIndex("_id");
        ArrayList arrayList = new ArrayList();
        while (tryQuery.moveToNext()) {
            arrayList.add(new LaunchTimeEntity(tryQuery.getLong(columnIndex)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List K(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        int columnIndex = tryQuery.getColumnIndex("NAME");
        int columnIndex2 = tryQuery.getColumnIndex("TYPE_ID");
        int columnIndex3 = tryQuery.getColumnIndex("ITEM_SOURCE_TYPE");
        int columnIndex4 = tryQuery.getColumnIndex("IS_ACTIVE");
        int columnIndex5 = tryQuery.getColumnIndex("IS_INSTALLED");
        ArrayList arrayList = new ArrayList();
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex)) {
                String string = tryQuery.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new IgnoredStatisticsItem(0L, string, UsageAccess.Type.Companion.b(tryQuery.getInt(columnIndex2)), !tryQuery.isNull(columnIndex3) ? IgnoredStatisticsItem.ItemSourceType.Companion.b(tryQuery.getInt(columnIndex3)) : IgnoredStatisticsItem.ItemSourceType.DEFAULT, tryQuery.getInt(columnIndex4) != 0, tryQuery.getInt(columnIndex5) != 0, 1, null));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object s(android.content.Context r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt.s(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x029e, code lost:
    
        if (r5.t(r0, r1) == r2) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0221 A[PHI: r3 r4 r7 r8 r9 r10 r11
      0x0221: PHI (r3v11 java.util.List) = (r3v9 java.util.List), (r3v12 java.util.List) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r4v6 java.util.List) = (r4v4 java.util.List), (r4v7 java.util.List) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r7v6 java.util.List) = (r7v3 java.util.List), (r7v8 java.util.List) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r8v12 java.util.List) = (r8v9 java.util.List), (r8v14 java.util.List) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r9v20 java.util.List) = (r9v17 java.util.List), (r9v22 java.util.List) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r10v21 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase) = 
      (r10v18 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase)
      (r10v23 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase)
     binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0221: PHI (r11v15 android.database.sqlite.SQLiteDatabase) = (r11v12 android.database.sqlite.SQLiteDatabase), (r11v18 android.database.sqlite.SQLiteDatabase) binds: [B:57:0x01f1, B:62:0x0220] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0260 A[PHI: r3 r4 r6 r7 r8 r9 r10
      0x0260: PHI (r3v13 java.util.List) = (r3v11 java.util.List), (r3v16 java.util.List) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r4v8 java.util.List) = (r4v6 java.util.List), (r4v10 java.util.List) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r6v4 java.util.List) = (r6v2 java.util.List), (r6v6 java.util.List) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r7v9 java.util.List) = (r7v7 java.util.List), (r7v11 java.util.List) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r8v15 java.util.List) = (r8v13 java.util.List), (r8v17 java.util.List) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r9v23 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase) = 
      (r9v21 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase)
      (r9v25 cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase)
     binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r10v24 android.database.sqlite.SQLiteDatabase) = (r10v22 android.database.sqlite.SQLiteDatabase), (r10v26 android.database.sqlite.SQLiteDatabase) binds: [B:64:0x022d, B:69:0x025f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object t(android.database.sqlite.SQLiteDatabase r20, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt.t(android.database.sqlite.SQLiteDatabase, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List u(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("LABEL");
        int columnIndex2 = tryQuery.getColumnIndex("LABEL_FOR_SEARCH");
        int columnIndex3 = tryQuery.getColumnIndex("PACKAGE_NAME");
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex) && !tryQuery.isNull(columnIndex2) && !tryQuery.isNull(columnIndex3)) {
                String string = tryQuery.getString(columnIndex3);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = tryQuery.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String string3 = tryQuery.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                arrayList.add(new Application(string, string2, string3, false, null, 24, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List v(Cursor tryQuery) {
        Category categoryB;
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("PACKAGE_NAME");
        int columnIndex2 = tryQuery.getColumnIndex("HOSTNAME");
        int columnIndex3 = tryQuery.getColumnIndex("CATEGORY_STRING");
        int columnIndex4 = tryQuery.getColumnIndex("IS_PRESET");
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex)) {
                String string = tryQuery.getString(columnIndex);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = tryQuery.getString(columnIndex2);
                if (tryQuery.isNull(columnIndex3)) {
                    categoryB = Category.NONE;
                } else {
                    Category.Companion companion = Category.Companion;
                    String string3 = tryQuery.getString(columnIndex3);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    categoryB = companion.b(string3);
                }
                arrayList.add(new AppWebsiteCategoryRelation(string, string2, categoryB, tryQuery.getInt(columnIndex4) != 0));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List w(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("PACKAGE_NAME");
        int columnIndex3 = tryQuery.getColumnIndex("VIEW_ID");
        int columnIndex4 = tryQuery.getColumnIndex("VIEW_TYPE");
        int columnIndex5 = tryQuery.getColumnIndex("CLEAR_URL");
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex2) && !tryQuery.isNull(columnIndex3)) {
                long j3 = tryQuery.getLong(columnIndex);
                String string = tryQuery.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String string2 = tryQuery.getString(columnIndex3);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                arrayList.add(new BrowserViewId(j3, string, string2, tryQuery.isNull(columnIndex3) ? BrowserViewId.ViewType.URL_BAR : BrowserViewId.ViewType.Companion.b(tryQuery.getInt(columnIndex4)), columnIndex5 == -1 || tryQuery.isNull(columnIndex5) || tryQuery.getInt(columnIndex5) != 0, false, null, null, null, 480, null));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List x(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("PACKAGE_NAME");
        int columnIndex3 = tryQuery.getColumnIndex("DATE");
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex2) && !tryQuery.isNull(columnIndex3)) {
                long j3 = tryQuery.getLong(columnIndex);
                String string = tryQuery.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new BlockSession(j3, string, tryQuery.getLong(columnIndex3)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List y(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        ArrayList arrayList = new ArrayList();
        int columnIndex = tryQuery.getColumnIndex("_id");
        int columnIndex2 = tryQuery.getColumnIndex("PACKAGE_NAME");
        int columnIndex3 = tryQuery.getColumnIndex("DATE");
        int columnIndex4 = tryQuery.getColumnIndex("PROFILE_ID");
        int columnIndex5 = tryQuery.getColumnIndex(ShareConstants.TITLE);
        int columnIndex6 = tryQuery.getColumnIndex("CONTENT_TEXT");
        while (tryQuery.moveToNext()) {
            if (!tryQuery.isNull(columnIndex2) && !tryQuery.isNull(columnIndex3)) {
                long j3 = tryQuery.getLong(columnIndex);
                String string = tryQuery.getString(columnIndex2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                arrayList.add(new BlockedNotification(j3, string, tryQuery.getLong(columnIndex3), tryQuery.getLong(columnIndex4), tryQuery.getString(columnIndex5), tryQuery.getString(columnIndex6)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0814, code lost:
    
        if (r3.t(r0, r1) == r2) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x07ac  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0616  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0623  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0713  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x07a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object z(android.database.sqlite.SQLiteDatabase r25, android.content.Context r26, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase r27, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2102
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.management.GreendaoToRoomMigrationKt.z(android.database.sqlite.SQLiteDatabase, android.content.Context, cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
