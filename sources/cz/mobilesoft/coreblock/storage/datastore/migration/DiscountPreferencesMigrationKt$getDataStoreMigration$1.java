package cz.mobilesoft.coreblock.storage.datastore.migration;

import androidx.datastore.core.DataMigration;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKt;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
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
public final class DiscountPreferencesMigrationKt$getDataStoreMigration$1 implements DataMigration<Preferences>, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f124778a;

    /* JADX WARN: Multi-variable type inference failed */
    DiscountPreferencesMigrationKt$getDataStoreMigration$1() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f124778a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
    }

    @Override // androidx.datastore.core.DataMigration
    public Object b(Continuation continuation) {
        Object objA = PreferencesKt.a(d().l(), new DiscountPreferencesMigrationKt$getDataStoreMigration$1$cleanUp$2(null), continuation);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final CoreDataStore d() {
        return (CoreDataStore) this.f124778a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(androidx.datastore.preferences.core.Preferences r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$migrate$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$migrate$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$migrate$1) r0
            int r1 = r0.f124784d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124784d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$migrate$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$migrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124782b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124784d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f124781a
            androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
            kotlin.ResultKt.b(r6)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = r4.d()
            androidx.datastore.core.DataStore r6 = r6.l()
            kotlinx.coroutines.flow.Flow r6 = r6.getData()
            r0.f124781a = r5
            r0.f124784d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L4f
            return r1
        L4f:
            androidx.datastore.preferences.core.Preferences r6 = (androidx.datastore.preferences.core.Preferences) r6
            java.util.Map r6 = r6.a()
            androidx.datastore.preferences.core.MutablePreferences r5 = r5.d()
            androidx.datastore.preferences.core.Preferences$Key r0 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Z0()
            java.lang.Object r0 = r6.get(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            androidx.datastore.preferences.core.Preferences$Key r1 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.H2()
            java.lang.Object r6 = r6.get(r1)
            java.lang.Long r6 = (java.lang.Long) r6
            if (r0 == 0) goto L7e
            boolean r0 = r0.booleanValue()
            androidx.datastore.preferences.core.Preferences$Key r1 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Z0()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            r5.k(r1, r0)
        L7e:
            if (r6 == 0) goto L8f
            long r0 = r6.longValue()
            androidx.datastore.preferences.core.Preferences$Key r6 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.H2()
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.e(r0)
            r5.k(r6, r0)
        L8f:
            androidx.datastore.preferences.core.Preferences r5 = r5.e()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1.c(androidx.datastore.preferences.core.Preferences, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(androidx.datastore.preferences.core.Preferences r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$shouldMigrate$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$shouldMigrate$1 r0 = (cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$shouldMigrate$1) r0
            int r1 = r0.f124788d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f124788d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$shouldMigrate$1 r0 = new cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f124786b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f124788d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f124785a
            androidx.datastore.preferences.core.Preferences r5 = (androidx.datastore.preferences.core.Preferences) r5
            kotlin.ResultKt.b(r6)
            goto L53
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = r4.d()
            androidx.datastore.core.DataStore r6 = r6.l()
            kotlinx.coroutines.flow.Flow r6 = r6.getData()
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f124785a = r5
            r0.f124788d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.D(r6, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            androidx.datastore.preferences.core.Preferences r6 = (androidx.datastore.preferences.core.Preferences) r6
            java.util.Map r5 = r6.a()
            androidx.datastore.preferences.core.Preferences$Key r6 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.Z0()
            boolean r6 = r5.containsKey(r6)
            if (r6 != 0) goto L6f
            androidx.datastore.preferences.core.Preferences$Key r6 = cz.mobilesoft.coreblock.storage.datastore.DataStoreKeysKt.H2()
            boolean r5 = r5.containsKey(r6)
            if (r5 == 0) goto L6e
            goto L6f
        L6e:
            r3 = 0
        L6f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.datastore.migration.DiscountPreferencesMigrationKt$getDataStoreMigration$1.a(androidx.datastore.preferences.core.Preferences, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
