package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.migrations.SharedPreferencesMigration;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SharedPreferencesMigrationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set f35931a = new LinkedHashSet();

    public static final SharedPreferencesMigration a(Context context, String sharedPreferencesName, Set keysToMigrate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferencesName, "sharedPreferencesName");
        Intrinsics.checkNotNullParameter(keysToMigrate, "keysToMigrate");
        return keysToMigrate == f35931a ? new SharedPreferencesMigration(context, sharedPreferencesName, null, e(keysToMigrate), d(), 4, null) : new SharedPreferencesMigration(context, sharedPreferencesName, keysToMigrate, e(keysToMigrate), d());
    }

    public static /* synthetic */ SharedPreferencesMigration b(Context context, String str, Set set, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            set = f35931a;
        }
        return a(context, str, set);
    }

    public static final Set c() {
        return f35931a;
    }

    private static final Function3 d() {
        return new SharedPreferencesMigrationKt$getMigrationFunction$1(null);
    }

    private static final Function2 e(Set set) {
        return new SharedPreferencesMigrationKt$getShouldRunMigration$1(set, null);
    }
}
