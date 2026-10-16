package cz.mobilesoft.coreblock.storage.datastore.migration;

import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class StrictModePreferencesMigrationKt$getStrictModeUninstallOptionMigration$1 implements DataMigration<Preferences>, KoinComponent {
    StrictModePreferencesMigrationKt$getStrictModeUninstallOptionMigration$1() {
    }

    @Override // androidx.datastore.core.DataMigration
    public Object b(Continuation continuation) {
        return Unit.f139807a;
    }

    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Object c(Preferences preferences, Continuation continuation) {
        MutablePreferences mutablePreferencesD = preferences.d();
        Integer num = (Integer) preferences.c(DataStoreKeysKt.x4());
        int iIntValue = num != null ? num.intValue() : StrictModeOption.BlockEditing.getMask();
        if (StrictModeOption.Companion.c(iIntValue).contains(StrictModeOption.BlockUninstalling)) {
            iIntValue |= StrictModeOption.BlockReinstalledApps.getMask();
        }
        mutablePreferencesD.k(DataStoreKeysKt.y4(), Boxing.d(iIntValue));
        mutablePreferencesD.j(DataStoreKeysKt.x4());
        return mutablePreferencesD.e();
    }

    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object a(Preferences preferences, Continuation continuation) {
        return Boxing.a(preferences.a().containsKey(DataStoreKeysKt.x4()));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
