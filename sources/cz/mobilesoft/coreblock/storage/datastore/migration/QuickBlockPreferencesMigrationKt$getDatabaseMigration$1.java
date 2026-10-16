package cz.mobilesoft.coreblock.storage.datastore.migration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.quickblock.QuickBlockProfileDTO;
import cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt;
import cz.mobilesoft.coreblock.storage.greendao.GreendaoDatabase;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
public final class QuickBlockPreferencesMigrationKt$getDatabaseMigration$1 implements DataMigration<Preferences>, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f124794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f124795b;

    /* JADX WARN: Multi-variable type inference failed */
    QuickBlockPreferencesMigrationKt$getDatabaseMigration$1() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f124794a = LazyKt.a(lazyThreadSafetyModeB, new Function0<GreendaoDatabase>() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.QuickBlockPreferencesMigrationKt$getDatabaseMigration$1$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GreendaoDatabase.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f124795b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.QuickBlockPreferencesMigrationKt$getDatabaseMigration$1$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr2, objArr3);
            }
        });
    }

    private final GreendaoDatabase f() {
        return (GreendaoDatabase) this.f124794a.getValue();
    }

    private final QuickBlockRepository g() {
        return (QuickBlockRepository) this.f124795b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean k(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(Cursor tryQuery) {
        Intrinsics.checkNotNullParameter(tryQuery, "$this$tryQuery");
        int columnIndex = tryQuery.getColumnIndex("IS_VISIBLE");
        return columnIndex == -1 || tryQuery.getInt(columnIndex) == 1;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object b(Continuation continuation) {
        return Unit.f139807a;
    }

    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object c(Preferences preferences, Continuation continuation) {
        Profile profileH;
        MutablePreferences mutablePreferencesD = preferences.d();
        SQLiteDatabase sQLiteDatabaseA = f().a();
        boolean z2 = true;
        boolean zJ = sQLiteDatabaseA != null ? j(sQLiteDatabaseA) : true;
        QuickBlockProfileDTO quickBlockProfileDTOQ = g().q();
        boolean z3 = (quickBlockProfileDTOQ == null || (profileH = quickBlockProfileDTOQ.h()) == null || !profileH.G()) ? false : true;
        Preferences.Key keyG1 = DataStoreKeysKt.g1();
        if (!zJ && !z3) {
            z2 = false;
        }
        mutablePreferencesD.k(keyG1, Boxing.a(z2));
        return mutablePreferencesD;
    }

    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Object a(Preferences preferences, Continuation continuation) {
        return Boxing.a(!preferences.b(DataStoreKeysKt.g1()));
    }

    public final boolean j(SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        Boolean bool = (Boolean) DatabaseExtKt.f(sqLiteDatabase, "SELECT * FROM DASHBOARD_CARD WHERE _id = 3", new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(QuickBlockPreferencesMigrationKt$getDatabaseMigration$1.k((Exception) obj));
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(QuickBlockPreferencesMigrationKt$getDatabaseMigration$1.l((Cursor) obj));
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
