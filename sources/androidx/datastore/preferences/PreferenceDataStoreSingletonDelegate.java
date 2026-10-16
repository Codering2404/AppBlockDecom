package androidx.datastore.preferences;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;

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
public final class PreferenceDataStoreSingletonDelegate implements ReadOnlyProperty<Context, DataStore<Preferences>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReplaceFileCorruptionHandler f35910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f35911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CoroutineScope f35912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f35913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile DataStore f35914f;

    public PreferenceDataStoreSingletonDelegate(String name, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, Function1 produceMigrations, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f35909a = name;
        this.f35910b = replaceFileCorruptionHandler;
        this.f35911c = produceMigrations;
        this.f35912d = scope;
        this.f35913e = new Object();
    }

    @Override // kotlin.properties.ReadOnlyProperty
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public DataStore a(Context thisRef, KProperty property) {
        DataStore dataStore;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        DataStore dataStore2 = this.f35914f;
        if (dataStore2 != null) {
            return dataStore2;
        }
        synchronized (this.f35913e) {
            try {
                if (this.f35914f == null) {
                    final Context applicationContext = thisRef.getApplicationContext();
                    PreferenceDataStoreFactory preferenceDataStoreFactory = PreferenceDataStoreFactory.f35946a;
                    ReplaceFileCorruptionHandler replaceFileCorruptionHandler = this.f35910b;
                    Function1 function1 = this.f35911c;
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                    this.f35914f = preferenceDataStoreFactory.b(replaceFileCorruptionHandler, (List) function1.invoke(applicationContext), this.f35912d, new Function0<File>() { // from class: androidx.datastore.preferences.PreferenceDataStoreSingletonDelegate$getValue$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final File invoke() {
                            Context applicationContext2 = applicationContext;
                            Intrinsics.checkNotNullExpressionValue(applicationContext2, "applicationContext");
                            return PreferenceDataStoreFile.a(applicationContext2, this.f35909a);
                        }
                    });
                }
                dataStore = this.f35914f;
                Intrinsics.checkNotNull(dataStore);
            } catch (Throwable th) {
                throw th;
            }
        }
        return dataStore;
    }
}
