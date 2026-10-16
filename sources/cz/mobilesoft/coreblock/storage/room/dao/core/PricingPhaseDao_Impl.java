package cz.mobilesoft.coreblock.storage.room.dao.core;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.EntityUpsertAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.SQLiteStatement;
import cz.mobilesoft.coreblock.storage.room.premium.PricingPhaseEntity;
import cz.mobilesoft.coreblock.storage.room.premium.PricingPhaseTypeTypeConverter;
import cz.mobilesoft.coreblock.storage.room.premium.RecurrenceModeTypeConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class PricingPhaseDao_Impl implements PricingPhaseDao {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f126059g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f126060h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RoomDatabase f126061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EntityInsertAdapter f126062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EntityDeleteOrUpdateAdapter f126064d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final EntityUpsertAdapter f126065f;

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

    public PricingPhaseDao_Impl(RoomDatabase __db) {
        Intrinsics.checkNotNullParameter(__db, "__db");
        this.f126061a = __db;
        this.f126062b = new EntityInsertAdapter<PricingPhaseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl.1
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT OR REPLACE INTO `PricingPhaseEntity` (`id`,`optionId`,`phaseIndex`,`phaseType`,`formattedPrice`,`priceAmount`,`priceCurrencyCode`,`billingPeriod`,`billingCycleCount`,`recurrenceMode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PricingPhaseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.e());
                statement.A(3, entity.f());
                statement.A(4, PricingPhaseTypeTypeConverter.f126820a.a(entity.g()));
                statement.p0(5, entity.c());
                statement.t(6, entity.h());
                statement.p0(7, entity.i());
                statement.p0(8, entity.b());
                statement.A(9, entity.a());
                statement.A(10, RecurrenceModeTypeConverter.f126823a.a(entity.j()));
            }
        };
        this.f126063c = new EntityDeleteOrUpdateAdapter<PricingPhaseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl.2
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "DELETE FROM `PricingPhaseEntity` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PricingPhaseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
            }
        };
        this.f126064d = new EntityDeleteOrUpdateAdapter<PricingPhaseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl.3
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE OR ABORT `PricingPhaseEntity` SET `id` = ?,`optionId` = ?,`phaseIndex` = ?,`phaseType` = ?,`formattedPrice` = ?,`priceAmount` = ?,`priceCurrencyCode` = ?,`billingPeriod` = ?,`billingCycleCount` = ?,`recurrenceMode` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PricingPhaseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.e());
                statement.A(3, entity.f());
                statement.A(4, PricingPhaseTypeTypeConverter.f126820a.a(entity.g()));
                statement.p0(5, entity.c());
                statement.t(6, entity.h());
                statement.p0(7, entity.i());
                statement.p0(8, entity.b());
                statement.A(9, entity.a());
                statement.A(10, RecurrenceModeTypeConverter.f126823a.a(entity.j()));
                statement.A(11, entity.d());
            }
        };
        this.f126065f = new EntityUpsertAdapter(new EntityInsertAdapter<PricingPhaseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl.4
            @Override // androidx.room.EntityInsertAdapter
            protected String b() {
                return "INSERT INTO `PricingPhaseEntity` (`id`,`optionId`,`phaseIndex`,`phaseType`,`formattedPrice`,`priceAmount`,`priceCurrencyCode`,`billingPeriod`,`billingCycleCount`,`recurrenceMode`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PricingPhaseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.e());
                statement.A(3, entity.f());
                statement.A(4, PricingPhaseTypeTypeConverter.f126820a.a(entity.g()));
                statement.p0(5, entity.c());
                statement.t(6, entity.h());
                statement.p0(7, entity.i());
                statement.p0(8, entity.b());
                statement.A(9, entity.a());
                statement.A(10, RecurrenceModeTypeConverter.f126823a.a(entity.j()));
            }
        }, new EntityDeleteOrUpdateAdapter<PricingPhaseEntity>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.core.PricingPhaseDao_Impl.5
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            protected String b() {
                return "UPDATE `PricingPhaseEntity` SET `id` = ?,`optionId` = ?,`phaseIndex` = ?,`phaseType` = ?,`formattedPrice` = ?,`priceAmount` = ?,`priceCurrencyCode` = ?,`billingPeriod` = ?,`billingCycleCount` = ?,`recurrenceMode` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeleteOrUpdateAdapter
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void a(SQLiteStatement statement, PricingPhaseEntity entity) {
                Intrinsics.checkNotNullParameter(statement, "statement");
                Intrinsics.checkNotNullParameter(entity, "entity");
                statement.A(1, entity.d());
                statement.A(2, entity.e());
                statement.A(3, entity.f());
                statement.A(4, PricingPhaseTypeTypeConverter.f126820a.a(entity.g()));
                statement.p0(5, entity.c());
                statement.t(6, entity.h());
                statement.p0(7, entity.i());
                statement.p0(8, entity.b());
                statement.A(9, entity.a());
                statement.A(10, RecurrenceModeTypeConverter.f126823a.a(entity.j()));
                statement.A(11, entity.d());
            }
        });
    }
}
