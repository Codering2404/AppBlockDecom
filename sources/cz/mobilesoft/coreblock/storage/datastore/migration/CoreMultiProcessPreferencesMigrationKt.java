package cz.mobilesoft.coreblock.storage.datastore.migration;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import com.facebook.appevents.AppEventsConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
public final class CoreMultiProcessPreferencesMigrationKt {
    public static final SharedPreferencesMigration a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return SharedPreferencesMigrationKt.a(context, "prop_setting", SetsKt.setOf((Object[]) new String[]{"pref_location_profiles_always_on", "RECREATE_GEOFENCES_WHEN_POSSIBLE", "LAST_GEOFENCES_RECREATION_TIME", "DAY_BEGINNING_HOUR"}));
    }

    public static final DataMigration b() {
        return new DataMigration<Preferences>() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.CoreMultiProcessPreferencesMigrationKt$getSelectedBlockingConfigIdMigration$1
            @Override // androidx.datastore.core.DataMigration
            public Object b(Continuation continuation) {
                return Unit.f139807a;
            }

            @Override // androidx.datastore.core.DataMigration
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Object c(Preferences preferences, Continuation continuation) {
                String strValueOf;
                Preferences.Key keyF = PreferencesKeys.f("selected_blocking_config_id");
                Preferences.Key keyG = PreferencesKeys.g("selected_blocking_config_string_id");
                Long l3 = (Long) preferences.c(keyF);
                if (l3 == null || (strValueOf = String.valueOf(l3.longValue())) == null) {
                    strValueOf = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                }
                MutablePreferences mutablePreferencesD = preferences.d();
                mutablePreferencesD.j(keyF);
                mutablePreferencesD.k(keyG, strValueOf);
                return mutablePreferencesD.e();
            }

            @Override // androidx.datastore.core.DataMigration
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Object a(Preferences preferences, Continuation continuation) {
                return Boxing.a(preferences.b(PreferencesKeys.f("selected_blocking_config_id")) && !preferences.b(PreferencesKeys.g("selected_blocking_config_string_id")));
            }
        };
    }
}
