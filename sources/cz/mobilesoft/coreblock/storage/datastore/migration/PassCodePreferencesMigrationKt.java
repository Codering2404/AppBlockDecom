package cz.mobilesoft.coreblock.storage.datastore.migration;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class PassCodePreferencesMigrationKt {
    public static final DataMigration a(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DataMigration<Preferences>(context) { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.PassCodePreferencesMigrationKt$getPassCodePreferencesMigration$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final SharedPreferences f124792a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final SharedPreferences f124793b;

            {
                this.f124792a = PreferenceManager.getDefaultSharedPreferences(context);
                this.f124793b = context.getSharedPreferences("prop_setting", 0);
            }

            @Override // androidx.datastore.core.DataMigration
            public Object b(Continuation continuation) {
                SharedPreferences.Editor editorEdit = this.f124792a.edit();
                editorEdit.remove("PASSCODE");
                editorEdit.remove("LAST_ACTIVE_MILLIS");
                editorEdit.remove("pref_checkbox_use_password");
                editorEdit.apply();
                this.f124793b.edit().remove("pref_checkbox_use_password").apply();
                return Unit.f139807a;
            }

            @Override // androidx.datastore.core.DataMigration
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Object c(Preferences preferences, Continuation continuation) {
                MutablePreferences mutablePreferencesD = preferences.d();
                if (this.f124793b.contains("pref_checkbox_use_password") ? this.f124793b.getBoolean("pref_checkbox_use_password", false) : this.f124792a.getBoolean("pref_checkbox_use_password", false)) {
                    String string = this.f124792a.getString("PASSCODE", null);
                    long j3 = this.f124792a.getLong("LAST_ACTIVE_MILLIS", 0L);
                    if (string != null) {
                        mutablePreferencesD.k(DataStoreKeysKt.X1(), string);
                        mutablePreferencesD.k(DataStoreKeysKt.a2(), Boxing.e(j3));
                    }
                }
                return mutablePreferencesD.e();
            }

            @Override // androidx.datastore.core.DataMigration
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public Object a(Preferences preferences, Continuation continuation) {
                return Boxing.a(this.f124793b.contains("pref_checkbox_use_password"));
            }
        };
    }
}
