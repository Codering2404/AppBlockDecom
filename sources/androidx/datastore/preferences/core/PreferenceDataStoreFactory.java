package androidx.datastore.preferences.core;

import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.FileStorage;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
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
public final class PreferenceDataStoreFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreferenceDataStoreFactory f35946a = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static /* synthetic */ DataStore c(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i3 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i3 & 4) != 0) {
            coroutineScope = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)));
        }
        return preferenceDataStoreFactory.b(replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    public final DataStore a(Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return new PreferenceDataStore(DataStoreFactory.f35538a.b(storage, replaceFileCorruptionHandler, migrations, scope));
    }

    public final DataStore b(ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List migrations, CoroutineScope scope, final Function0 produceFile) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(produceFile, "produceFile");
        return new PreferenceDataStore(a(new FileStorage(PreferencesFileSerializer.f35952a, null, new Function0<File>() { // from class: androidx.datastore.preferences.core.PreferenceDataStoreFactory$create$delegate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                File file = (File) produceFile.invoke();
                if (Intrinsics.areEqual(FilesKt.q(file), "preferences_pb")) {
                    File absoluteFile = file.getAbsoluteFile();
                    Intrinsics.checkNotNullExpressionValue(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
            }
        }, 2, null), replaceFileCorruptionHandler, migrations, scope));
    }
}
