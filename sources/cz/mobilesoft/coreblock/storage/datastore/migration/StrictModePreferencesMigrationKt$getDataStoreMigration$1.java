package cz.mobilesoft.coreblock.storage.datastore.migration;

import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt;
import cz.mobilesoft.coreblock.util.StrictModeHelper;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictModePreferencesMigrationKt$getDataStoreMigration$1 implements DataMigration<Preferences>, KoinComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f124802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f124803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f124804c;

        static {
            int[] iArr = new int[StrictModeHelper.StrictnessLevel.values().length];
            try {
                iArr[StrictModeHelper.StrictnessLevel.SETTINGS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeHelper.StrictnessLevel.INSTALLER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeHelper.StrictnessLevel.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f124802a = iArr;
            int[] iArr2 = new int[StrictModeHelper.ActivationCondition.values().length];
            try {
                iArr2[StrictModeHelper.ActivationCondition.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[StrictModeHelper.ActivationCondition.PROFILES.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            f124803b = iArr2;
            int[] iArr3 = new int[StrictModeHelper.DeactivationMethod.values().length];
            try {
                iArr3[StrictModeHelper.DeactivationMethod.PIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[StrictModeHelper.DeactivationMethod.CHARGER.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            f124804c = iArr3;
        }
    }

    StrictModePreferencesMigrationKt$getDataStoreMigration$1() {
    }

    @Override // androidx.datastore.core.DataMigration
    public Object b(Continuation continuation) {
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9  */
    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(androidx.datastore.preferences.core.Preferences r8, kotlin.coroutines.Continuation r9) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.migration.StrictModePreferencesMigrationKt$getDataStoreMigration$1.c(androidx.datastore.preferences.core.Preferences, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Object a(Preferences preferences, Continuation continuation) {
        return Boxing.a(preferences.a().containsKey(DataStoreKeysKt.C4()) || preferences.a().containsKey(DataStoreKeysKt.t4()));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
