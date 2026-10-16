package androidx.datastore.core;

import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
public final class DataStoreFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DataStoreFactory f35538a = new DataStoreFactory();

    private DataStoreFactory() {
    }

    public static /* synthetic */ DataStore c(DataStoreFactory dataStoreFactory, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i3 & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i3 & 8) != 0) {
            coroutineScope = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)));
        }
        return dataStoreFactory.a(serializer, replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    public final DataStore a(Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope, Function0 produceFile) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return b(new FileStorage(serializer, null, produceFile, 2, null), replaceFileCorruptionHandler, migrations, scope);
    }

    public final DataStore b(Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        CorruptionHandler noOpCorruptionHandler = replaceFileCorruptionHandler;
        if (replaceFileCorruptionHandler == null) {
            noOpCorruptionHandler = new NoOpCorruptionHandler();
        }
        return new DataStoreImpl(storage, CollectionsKt.listOf(DataMigrationInitializer.f35520a.b(migrations)), noOpCorruptionHandler, scope);
    }
}
