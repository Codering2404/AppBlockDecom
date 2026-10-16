package cz.mobilesoft.coreblock.storage.datastore.migration;

import android.content.Context;
import androidx.datastore.core.DataMigration;
import androidx.datastore.migrations.SharedPreferencesMigration;
import androidx.datastore.preferences.SharedPreferencesMigrationKt;
import androidx.glance.session.ecY.lisODU;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
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
public final class DiscountPreferencesMigrationKt {
    private static final DataMigration a() {
        return new DiscountPreferencesMigrationKt$getDataStoreMigration$1();
    }

    public static final List b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf((Object[]) new DataMigration[]{a(), c(context), d(context)});
    }

    private static final SharedPreferencesMigration c(Context context) {
        return SharedPreferencesMigrationKt.b(context, "prop_discounts", null, 4, null);
    }

    private static final SharedPreferencesMigration d(Context context) {
        return SharedPreferencesMigrationKt.a(context, "prop_setting", SetsKt.setOf((Object[]) new String[]{"pref_earliest_discount_hours", "pref_last_campaign_id", lisODU.vnNebWXXQUQI, "pref_campaign_validity_hours"}));
    }
}
