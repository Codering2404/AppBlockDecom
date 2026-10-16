package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.GeoAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class GeoAddressDao_Impl extends GeoAddressDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f125032g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f125033h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f125034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f125035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f125037d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f125038f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List a() {
            return CollectionsKt.emptyList();
        }

        private Companion() {
        }
    }

    public GeoAddressDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f125034a = __db;
        this.f125035b = new EntityInsertAdapter<GeoAddress>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `GeoAddress` (`id`,`profileId`,`geofenceId`,`geofenceRadius`,`latitude`,`longitude`,`isInverted`,`locale`,`featureName`,`adminArea`,`subAdminArea`,`locality`,`subLocality`,`thoroughfare`,`subThoroughfare`,`premises`,`postalCode`,`countryCode`,`countryName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, GeoAddress entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.n());
                statement.A(2, entity.r());
                statement.p0(3, entity.a());
                statement.A(4, entity.i());
                statement.t(5, entity.b());
                statement.t(6, entity.f());
                statement.A(7, entity.t() ? 1L : 0L);
                String strO = entity.o();
                if (strO == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strO);
                }
                String strH = entity.h();
                if (strH == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strH);
                }
                String strK = entity.k();
                if (strK == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strK);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(11);
                } else {
                    statement.p0(11, strC);
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(12);
                } else {
                    statement.p0(12, strG);
                }
                String strE = entity.e();
                if (strE == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strE);
                }
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strJ);
                }
                String strS = entity.s();
                if (strS == null) {
                    statement.D(15);
                } else {
                    statement.p0(15, strS);
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(16);
                } else {
                    statement.p0(16, strD);
                }
                String strQ = entity.q();
                if (strQ == null) {
                    statement.D(17);
                } else {
                    statement.p0(17, strQ);
                }
                String strL = entity.l();
                if (strL == null) {
                    statement.D(18);
                } else {
                    statement.p0(18, strL);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(19);
                } else {
                    statement.p0(19, strM);
                }
            }
        };
        this.f125036c = new EntityDeleteOrUpdateAdapter<GeoAddress>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `GeoAddress` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, GeoAddress entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.n());
            }
        };
        this.f125037d = new EntityDeleteOrUpdateAdapter<GeoAddress>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `GeoAddress` SET `id` = ?,`profileId` = ?,`geofenceId` = ?,`geofenceRadius` = ?,`latitude` = ?,`longitude` = ?,`isInverted` = ?,`locale` = ?,`featureName` = ?,`adminArea` = ?,`subAdminArea` = ?,`locality` = ?,`subLocality` = ?,`thoroughfare` = ?,`subThoroughfare` = ?,`premises` = ?,`postalCode` = ?,`countryCode` = ?,`countryName` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, GeoAddress entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.n());
                statement.A(2, entity.r());
                statement.p0(3, entity.a());
                statement.A(4, entity.i());
                statement.t(5, entity.b());
                statement.t(6, entity.f());
                statement.A(7, entity.t() ? 1L : 0L);
                String strO = entity.o();
                if (strO == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strO);
                }
                String strH = entity.h();
                if (strH == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strH);
                }
                String strK = entity.k();
                if (strK == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strK);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(11);
                } else {
                    statement.p0(11, strC);
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(12);
                } else {
                    statement.p0(12, strG);
                }
                String strE = entity.e();
                if (strE == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strE);
                }
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strJ);
                }
                String strS = entity.s();
                if (strS == null) {
                    statement.D(15);
                } else {
                    statement.p0(15, strS);
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(16);
                } else {
                    statement.p0(16, strD);
                }
                String strQ = entity.q();
                if (strQ == null) {
                    statement.D(17);
                } else {
                    statement.p0(17, strQ);
                }
                String strL = entity.l();
                if (strL == null) {
                    statement.D(18);
                } else {
                    statement.p0(18, strL);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(19);
                } else {
                    statement.p0(19, strM);
                }
                statement.A(20, entity.n());
            }
        };
        this.f125038f = new EntityUpsertAdapter(new EntityInsertAdapter<GeoAddress>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `GeoAddress` (`id`,`profileId`,`geofenceId`,`geofenceRadius`,`latitude`,`longitude`,`isInverted`,`locale`,`featureName`,`adminArea`,`subAdminArea`,`locality`,`subLocality`,`thoroughfare`,`subThoroughfare`,`premises`,`postalCode`,`countryCode`,`countryName`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, GeoAddress entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.n());
                statement.A(2, entity.r());
                statement.p0(3, entity.a());
                statement.A(4, entity.i());
                statement.t(5, entity.b());
                statement.t(6, entity.f());
                statement.A(7, entity.t() ? 1L : 0L);
                String strO = entity.o();
                if (strO == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strO);
                }
                String strH = entity.h();
                if (strH == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strH);
                }
                String strK = entity.k();
                if (strK == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strK);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(11);
                } else {
                    statement.p0(11, strC);
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(12);
                } else {
                    statement.p0(12, strG);
                }
                String strE = entity.e();
                if (strE == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strE);
                }
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strJ);
                }
                String strS = entity.s();
                if (strS == null) {
                    statement.D(15);
                } else {
                    statement.p0(15, strS);
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(16);
                } else {
                    statement.p0(16, strD);
                }
                String strQ = entity.q();
                if (strQ == null) {
                    statement.D(17);
                } else {
                    statement.p0(17, strQ);
                }
                String strL = entity.l();
                if (strL == null) {
                    statement.D(18);
                } else {
                    statement.p0(18, strL);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(19);
                } else {
                    statement.p0(19, strM);
                }
            }
        }, new EntityDeleteOrUpdateAdapter<GeoAddress>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `GeoAddress` SET `id` = ?,`profileId` = ?,`geofenceId` = ?,`geofenceRadius` = ?,`latitude` = ?,`longitude` = ?,`isInverted` = ?,`locale` = ?,`featureName` = ?,`adminArea` = ?,`subAdminArea` = ?,`locality` = ?,`subLocality` = ?,`thoroughfare` = ?,`subThoroughfare` = ?,`premises` = ?,`postalCode` = ?,`countryCode` = ?,`countryName` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, GeoAddress entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.n());
                statement.A(2, entity.r());
                statement.p0(3, entity.a());
                statement.A(4, entity.i());
                statement.t(5, entity.b());
                statement.t(6, entity.f());
                statement.A(7, entity.t() ? 1L : 0L);
                String strO = entity.o();
                if (strO == null) {
                    statement.D(8);
                } else {
                    statement.p0(8, strO);
                }
                String strH = entity.h();
                if (strH == null) {
                    statement.D(9);
                } else {
                    statement.p0(9, strH);
                }
                String strK = entity.k();
                if (strK == null) {
                    statement.D(10);
                } else {
                    statement.p0(10, strK);
                }
                String strC = entity.c();
                if (strC == null) {
                    statement.D(11);
                } else {
                    statement.p0(11, strC);
                }
                String strG = entity.g();
                if (strG == null) {
                    statement.D(12);
                } else {
                    statement.p0(12, strG);
                }
                String strE = entity.e();
                if (strE == null) {
                    statement.D(13);
                } else {
                    statement.p0(13, strE);
                }
                String strJ = entity.j();
                if (strJ == null) {
                    statement.D(14);
                } else {
                    statement.p0(14, strJ);
                }
                String strS = entity.s();
                if (strS == null) {
                    statement.D(15);
                } else {
                    statement.p0(15, strS);
                }
                String strD = entity.d();
                if (strD == null) {
                    statement.D(16);
                } else {
                    statement.p0(16, strD);
                }
                String strQ = entity.q();
                if (strQ == null) {
                    statement.D(17);
                } else {
                    statement.p0(17, strQ);
                }
                String strL = entity.l();
                if (strL == null) {
                    statement.D(18);
                } else {
                    statement.p0(18, strL);
                }
                String strM = entity.m();
                if (strM == null) {
                    statement.D(19);
                } else {
                    statement.p0(19, strM);
                }
                statement.A(20, entity.n());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(GeoAddressDao_Impl geoAddressDao_Impl, GeoAddress geoAddress, SQLiteConnection _connection) throws Exception {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        geoAddressDao_Impl.f125036c.c(_connection, geoAddress);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            sQLiteStatementG2.B2();
            sQLiteStatementG2.close();
            return Unit.f139807a;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Y(String str, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceRadius");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "latitude");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "longitude");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInverted");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "locale");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "featureName");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "adminArea");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "subAdminArea");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "locality");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "subLocality");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "thoroughfare");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "subThoroughfare");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "premises");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "postalCode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryCode");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryName");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                long j4 = sQLiteStatementG2.getLong(iD2);
                String strF2 = sQLiteStatementG2.f2(iD3);
                int i3 = iD2;
                int i4 = iD3;
                int i5 = (int) sQLiteStatementG2.getLong(iD4);
                double d3 = sQLiteStatementG2.getDouble(iD5);
                double d4 = sQLiteStatementG2.getDouble(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                String strF22 = sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8);
                String strF23 = sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9);
                String strF24 = sQLiteStatementG2.isNull(iD10) ? null : sQLiteStatementG2.f2(iD10);
                String strF25 = sQLiteStatementG2.isNull(iD11) ? null : sQLiteStatementG2.f2(iD11);
                String strF26 = sQLiteStatementG2.isNull(iD12) ? null : sQLiteStatementG2.f2(iD12);
                String strF27 = sQLiteStatementG2.isNull(iD13) ? null : sQLiteStatementG2.f2(iD13);
                String strF28 = sQLiteStatementG2.isNull(iD14) ? null : sQLiteStatementG2.f2(iD14);
                int i6 = iD15;
                String strF29 = sQLiteStatementG2.isNull(i6) ? null : sQLiteStatementG2.f2(i6);
                int i7 = iD16;
                String strF210 = sQLiteStatementG2.isNull(i7) ? null : sQLiteStatementG2.f2(i7);
                int i8 = iD;
                int i9 = iD17;
                String strF211 = sQLiteStatementG2.isNull(i9) ? null : sQLiteStatementG2.f2(i9);
                iD17 = i9;
                int i10 = iD18;
                String strF212 = sQLiteStatementG2.isNull(i10) ? null : sQLiteStatementG2.f2(i10);
                iD18 = i10;
                int i11 = iD19;
                iD19 = i11;
                arrayList.add(new GeoAddress(j3, j4, strF2, i5, d3, d4, z2, strF22, strF23, strF24, strF25, strF26, strF27, strF28, strF29, strF210, strF211, strF212, sQLiteStatementG2.isNull(i11) ? null : sQLiteStatementG2.f2(i11)));
                iD = i8;
                iD15 = i6;
                iD16 = i7;
                iD2 = i3;
                iD3 = i4;
            }
            return arrayList;
        } finally {
            sQLiteStatementG2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List Z(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.p0(i3, (String) it.next());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceRadius");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "latitude");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "longitude");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInverted");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "locale");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "featureName");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "adminArea");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "subAdminArea");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "locality");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "subLocality");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "thoroughfare");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "subThoroughfare");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "premises");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "postalCode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryCode");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryName");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                long j4 = sQLiteStatementG2.getLong(iD2);
                String strF2 = sQLiteStatementG2.f2(iD3);
                int i4 = iD2;
                int i5 = iD3;
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                double d3 = sQLiteStatementG2.getDouble(iD5);
                double d4 = sQLiteStatementG2.getDouble(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                String strF22 = sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8);
                String strF23 = sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9);
                String strF24 = sQLiteStatementG2.isNull(iD10) ? null : sQLiteStatementG2.f2(iD10);
                String strF25 = sQLiteStatementG2.isNull(iD11) ? null : sQLiteStatementG2.f2(iD11);
                String strF26 = sQLiteStatementG2.isNull(iD12) ? null : sQLiteStatementG2.f2(iD12);
                String strF27 = sQLiteStatementG2.isNull(iD13) ? null : sQLiteStatementG2.f2(iD13);
                String strF28 = sQLiteStatementG2.isNull(iD14) ? null : sQLiteStatementG2.f2(iD14);
                int i7 = iD15;
                String strF29 = sQLiteStatementG2.isNull(i7) ? null : sQLiteStatementG2.f2(i7);
                int i8 = iD16;
                String strF210 = sQLiteStatementG2.isNull(i8) ? null : sQLiteStatementG2.f2(i8);
                int i9 = iD;
                int i10 = iD17;
                String strF211 = sQLiteStatementG2.isNull(i10) ? null : sQLiteStatementG2.f2(i10);
                iD17 = i10;
                int i11 = iD18;
                String strF212 = sQLiteStatementG2.isNull(i11) ? null : sQLiteStatementG2.f2(i11);
                iD18 = i11;
                int i12 = iD19;
                iD19 = i12;
                arrayList.add(new GeoAddress(j3, j4, strF2, i6, d3, d4, z2, strF22, strF23, strF24, strF25, strF26, strF27, strF28, strF29, strF210, strF211, strF212, sQLiteStatementG2.isNull(i12) ? null : sQLiteStatementG2.f2(i12)));
                iD = i9;
                iD15 = i7;
                iD16 = i8;
                iD2 = i4;
                iD3 = i5;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List a0(String str, long j3, SQLiteConnection _connection) throws Throwable {
        SQLiteStatement sQLiteStatement;
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            sQLiteStatementG2.A(1, j3);
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceRadius");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "latitude");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "longitude");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInverted");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "locale");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "featureName");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "adminArea");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "subAdminArea");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "locality");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "subLocality");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "thoroughfare");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "subThoroughfare");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "premises");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "postalCode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryCode");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryName");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j4 = sQLiteStatementG2.getLong(iD);
                long j5 = sQLiteStatementG2.getLong(iD2);
                String strF2 = sQLiteStatementG2.f2(iD3);
                int i3 = iD;
                int i4 = iD2;
                int i5 = (int) sQLiteStatementG2.getLong(iD4);
                double d3 = sQLiteStatementG2.getDouble(iD5);
                double d4 = sQLiteStatementG2.getDouble(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                String strF22 = sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8);
                String strF23 = sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9);
                String strF24 = sQLiteStatementG2.isNull(iD10) ? null : sQLiteStatementG2.f2(iD10);
                String strF25 = sQLiteStatementG2.isNull(iD11) ? null : sQLiteStatementG2.f2(iD11);
                String strF26 = sQLiteStatementG2.isNull(iD12) ? null : sQLiteStatementG2.f2(iD12);
                String strF27 = sQLiteStatementG2.isNull(iD13) ? null : sQLiteStatementG2.f2(iD13);
                String strF28 = sQLiteStatementG2.isNull(iD14) ? null : sQLiteStatementG2.f2(iD14);
                int i6 = iD15;
                String strF29 = sQLiteStatementG2.isNull(i6) ? null : sQLiteStatementG2.f2(i6);
                int i7 = iD16;
                String strF210 = sQLiteStatementG2.isNull(i7) ? null : sQLiteStatementG2.f2(i7);
                int i8 = iD17;
                String strF211 = sQLiteStatementG2.isNull(i8) ? null : sQLiteStatementG2.f2(i8);
                iD17 = i8;
                int i9 = iD18;
                String strF212 = sQLiteStatementG2.isNull(i9) ? null : sQLiteStatementG2.f2(i9);
                iD18 = i9;
                int i10 = iD19;
                sQLiteStatement = sQLiteStatementG2;
                try {
                    arrayList.add(new GeoAddress(j4, j5, strF2, i5, d3, d4, z2, strF22, strF23, strF24, strF25, strF26, strF27, strF28, strF29, strF210, strF211, strF212, sQLiteStatementG2.isNull(i10) ? null : sQLiteStatementG2.f2(i10)));
                    iD15 = i6;
                    iD16 = i7;
                    sQLiteStatementG2 = sQLiteStatement;
                    iD2 = i4;
                    iD19 = i10;
                    iD = i3;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement.close();
                    throw th;
                }
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            sQLiteStatement = sQLiteStatementG2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List b0(String str, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        SQLiteStatement sQLiteStatementG2 = _connection.G2(str);
        try {
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                sQLiteStatementG2.A(i3, ((Number) it.next()).longValue());
                i3++;
            }
            int iD = SQLiteStatementUtil.d(sQLiteStatementG2, "id");
            int iD2 = SQLiteStatementUtil.d(sQLiteStatementG2, "profileId");
            int iD3 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceId");
            int iD4 = SQLiteStatementUtil.d(sQLiteStatementG2, "geofenceRadius");
            int iD5 = SQLiteStatementUtil.d(sQLiteStatementG2, "latitude");
            int iD6 = SQLiteStatementUtil.d(sQLiteStatementG2, "longitude");
            int iD7 = SQLiteStatementUtil.d(sQLiteStatementG2, "isInverted");
            int iD8 = SQLiteStatementUtil.d(sQLiteStatementG2, "locale");
            int iD9 = SQLiteStatementUtil.d(sQLiteStatementG2, "featureName");
            int iD10 = SQLiteStatementUtil.d(sQLiteStatementG2, "adminArea");
            int iD11 = SQLiteStatementUtil.d(sQLiteStatementG2, "subAdminArea");
            int iD12 = SQLiteStatementUtil.d(sQLiteStatementG2, "locality");
            int iD13 = SQLiteStatementUtil.d(sQLiteStatementG2, "subLocality");
            int iD14 = SQLiteStatementUtil.d(sQLiteStatementG2, "thoroughfare");
            int iD15 = SQLiteStatementUtil.d(sQLiteStatementG2, "subThoroughfare");
            int iD16 = SQLiteStatementUtil.d(sQLiteStatementG2, "premises");
            int iD17 = SQLiteStatementUtil.d(sQLiteStatementG2, "postalCode");
            int iD18 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryCode");
            int iD19 = SQLiteStatementUtil.d(sQLiteStatementG2, "countryName");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementG2.B2()) {
                long j3 = sQLiteStatementG2.getLong(iD);
                long j4 = sQLiteStatementG2.getLong(iD2);
                String strF2 = sQLiteStatementG2.f2(iD3);
                int i4 = iD2;
                int i5 = iD3;
                int i6 = (int) sQLiteStatementG2.getLong(iD4);
                double d3 = sQLiteStatementG2.getDouble(iD5);
                double d4 = sQLiteStatementG2.getDouble(iD6);
                boolean z2 = ((int) sQLiteStatementG2.getLong(iD7)) != 0;
                String strF22 = sQLiteStatementG2.isNull(iD8) ? null : sQLiteStatementG2.f2(iD8);
                String strF23 = sQLiteStatementG2.isNull(iD9) ? null : sQLiteStatementG2.f2(iD9);
                String strF24 = sQLiteStatementG2.isNull(iD10) ? null : sQLiteStatementG2.f2(iD10);
                String strF25 = sQLiteStatementG2.isNull(iD11) ? null : sQLiteStatementG2.f2(iD11);
                String strF26 = sQLiteStatementG2.isNull(iD12) ? null : sQLiteStatementG2.f2(iD12);
                String strF27 = sQLiteStatementG2.isNull(iD13) ? null : sQLiteStatementG2.f2(iD13);
                String strF28 = sQLiteStatementG2.isNull(iD14) ? null : sQLiteStatementG2.f2(iD14);
                int i7 = iD15;
                String strF29 = sQLiteStatementG2.isNull(i7) ? null : sQLiteStatementG2.f2(i7);
                int i8 = iD16;
                String strF210 = sQLiteStatementG2.isNull(i8) ? null : sQLiteStatementG2.f2(i8);
                int i9 = iD;
                int i10 = iD17;
                String strF211 = sQLiteStatementG2.isNull(i10) ? null : sQLiteStatementG2.f2(i10);
                iD17 = i10;
                int i11 = iD18;
                String strF212 = sQLiteStatementG2.isNull(i11) ? null : sQLiteStatementG2.f2(i11);
                iD18 = i11;
                int i12 = iD19;
                iD19 = i12;
                arrayList.add(new GeoAddress(j3, j4, strF2, i6, d3, d4, z2, strF22, strF23, strF24, strF25, strF26, strF27, strF28, strF29, strF210, strF211, strF212, sQLiteStatementG2.isNull(i12) ? null : sQLiteStatementG2.f2(i12)));
                iD = i9;
                iD15 = i7;
                iD16 = i8;
                iD2 = i4;
                iD3 = i5;
            }
            sQLiteStatementG2.close();
            return arrayList;
        } catch (Throwable th) {
            sQLiteStatementG2.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long d0(GeoAddressDao_Impl geoAddressDao_Impl, GeoAddress geoAddress, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return geoAddressDao_Impl.f125035b.d(_connection, geoAddress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List e0(GeoAddressDao_Impl geoAddressDao_Impl, Collection collection, SQLiteConnection _connection) {
        Intrinsics.checkNotNullParameter(_connection, "_connection");
        return geoAddressDao_Impl.f125035b.e(_connection, collection);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao
    public Object J(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM GeoAddress WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objG = DBUtil.g(this.f125034a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.q1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.X(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao
    public Object K(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM GeoAddress WHERE geofenceId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125034a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.l1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.Z(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao
    public Object L(final long j3, Continuation continuation) {
        final String str = "SELECT * FROM GeoAddress WHERE profileId = ?";
        return DBUtil.g(this.f125034a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.p1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.a0(str, j3, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao
    public Object M(final Collection collection, Continuation continuation) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM GeoAddress WHERE profileId IN (");
        StringUtil.a(sb, collection.size());
        sb.append(")");
        final String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return DBUtil.g(this.f125034a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.n1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.b0(string, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public Object q(final GeoAddress geoAddress, Continuation continuation) {
        Object objG = DBUtil.g(this.f125034a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.o1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.W(this.f125577a, geoAddress, (SQLiteConnection) obj);
            }
        }, continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public Object n(final GeoAddress geoAddress, Continuation continuation) {
        return DBUtil.g(this.f125034a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Long.valueOf(GeoAddressDao_Impl.d0(this.f125629a, geoAddress, (SQLiteConnection) obj));
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao
    public Object k(Continuation continuation) {
        final String str = "SELECT * FROM GeoAddress";
        return DBUtil.g(this.f125034a, true, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.m1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.Y(str, (SQLiteConnection) obj);
            }
        }, continuation);
    }

    @Override // cz.mobilesoft.coreblock.storage.room.dao.BaseDao
    public Object t(final Collection collection, Continuation continuation) {
        return DBUtil.g(this.f125034a, false, true, new Function1() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.s1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GeoAddressDao_Impl.e0(this.f125647a, collection, (SQLiteConnection) obj);
            }
        }, continuation);
    }
}
