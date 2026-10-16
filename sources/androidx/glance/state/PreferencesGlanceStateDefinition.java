package androidx.glance.state;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import androidx.datastore.preferences.core.PreferenceDataStoreFactory;
import androidx.datastore.preferences.core.Preferences;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
public final class PreferencesGlanceStateDefinition implements GlanceStateDefinition<Preferences> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static CoroutineScope f39726b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreferencesGlanceStateDefinition f39725a = new PreferencesGlanceStateDefinition();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39727c = 8;

    private PreferencesGlanceStateDefinition() {
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public Object a(final Context context, final String str, Continuation continuation) {
        DataStore dataStoreC;
        CoroutineScope coroutineScope = f39726b;
        return (coroutineScope == null || (dataStoreC = PreferenceDataStoreFactory.c(PreferenceDataStoreFactory.f35946a, null, null, coroutineScope, new Function0<File>() { // from class: androidx.glance.state.PreferencesGlanceStateDefinition$getDataStore$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return PreferenceDataStoreFile.a(context, str);
            }
        }, 3, null)) == null) ? PreferenceDataStoreFactory.c(PreferenceDataStoreFactory.f35946a, null, null, null, new Function0<File>() { // from class: androidx.glance.state.PreferencesGlanceStateDefinition$getDataStore$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return PreferenceDataStoreFile.a(context, str);
            }
        }, 7, null) : dataStoreC;
    }

    @Override // androidx.glance.state.GlanceStateDefinition
    public File b(Context context, String str) {
        return PreferenceDataStoreFile.a(context, str);
    }
}
