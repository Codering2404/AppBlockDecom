package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioSerializer;
import androidx.datastore.core.okio.OkioStorage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import okio.FileSystem;
import okio.Path;

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
public final class DataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, DataStore<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OkioSerializer f35507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReplaceFileCorruptionHandler f35508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f35509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineScope f35510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f35511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile DataStore f35512g;

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataStore a(Context thisRef, KProperty property) {
        DataStore dataStore;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        DataStore dataStore2 = this.f35512g;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.f35511f) {
            try {
                if (this.f35512g == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    DataStoreFactory dataStoreFactory = DataStoreFactory.f35538a;
                    OkioStorage okioStorage = new OkioStorage(FileSystem.f145034b, this.f35507b, null, new Function0<Path>() { // from class: androidx.datastore.DataStoreSingletonDelegate$getValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public final Path invoke() {
                            Path.Companion companion = Path.f145073b;
                            Context applicationContext2 = applicationContext;
                            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                            String absolutePath = DataStoreFile.a(applicationContext2, this.f35506a).getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "applicationContext.dataS…le(fileName).absolutePath");
                            return Path.Companion.e(companion, absolutePath, false, 1, null);
                        }
                    }, 4, null);
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.f35508c;
                    Function1 function1 = this.f35509d;
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    this.f35512g = dataStoreFactory.b(okioStorage, replaceFileCorruptionHandler, (List) function1.invoke(applicationContext), this.f35510e);
                }
                dataStore = this.f35512g;
                Intrinsics.checkNotNull(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
