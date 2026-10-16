package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.Serializer;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.settings.SessionConfigs;
import com.google.firebase.sessions.settings.SessionConfigsSerializer;
import java.io.File;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Component
@Singleton
@Metadata
public interface FirebaseSessionsComponent {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Component.Builder
    @Metadata
    public interface Builder {
        Builder a(FirebaseInstallationsApi firebaseInstallationsApi);

        Builder b(Provider provider);

        FirebaseSessionsComponent build();

        Builder c(CoroutineContext coroutineContext);

        Builder d(FirebaseApp firebaseApp);

        Builder e(CoroutineContext coroutineContext);

        Builder f(Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Module
    public interface MainModule {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f89967a = Companion.f89968a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f89968a = new Companion();

            private Companion() {
            }

            private final DataStore f(Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0) {
                return h() ? MultiProcessDataStoreFactory.f35776a.a(serializer, replaceFileCorruptionHandler, list, coroutineScope, function0) : DataStoreFactory.f35538a.a(serializer, replaceFileCorruptionHandler, list, coroutineScope, function0);
            }

            static /* synthetic */ DataStore g(Companion companion, Serializer serializer, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i3, Object obj) {
                if ((i3 & 4) != 0) {
                    list = CollectionsKt.emptyList();
                }
                return companion.f(serializer, replaceFileCorruptionHandler, list, coroutineScope, function0);
            }

            private final boolean h() {
                try {
                    System.loadLibrary("datastore_shared_counter");
                    return true;
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    return false;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SessionConfigs j(CorruptionException ex) {
                Intrinsics.checkNotNullParameter(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session configs DataStore", ex);
                return SessionConfigsSerializer.f90200a.getDefaultValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final File k(Context context) {
                return DataStoreFile.a(context, "aqs/sessionConfigsDataStore.data");
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final SessionData m(SessionDataSerializer sessionDataSerializer, CorruptionException ex) {
                Intrinsics.checkNotNullParameter(ex, "ex");
                Log.w("FirebaseSessions", "CorruptionException in session data DataStore", ex);
                return sessionDataSerializer.getDefaultValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final File n(Context context) {
                return DataStoreFile.a(context, "aqs/sessionDataStore.data");
            }

            public final ApplicationInfo e(FirebaseApp firebaseApp) {
                Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
                return SessionEvents.f90026a.b(firebaseApp);
            }

            public final DataStore i(final Context appContext, CoroutineContext blockingDispatcher) {
                Intrinsics.checkNotNullParameter(appContext, "appContext");
                Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
                return g(this, SessionConfigsSerializer.f90200a, new ReplaceFileCorruptionHandler(new Function1() { // from class: com.google.firebase.sessions.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FirebaseSessionsComponent.MainModule.Companion.j((CorruptionException) obj);
                    }
                }), null, CoroutineScopeKt.a(blockingDispatcher), new Function0() { // from class: com.google.firebase.sessions.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FirebaseSessionsComponent.MainModule.Companion.k(appContext);
                    }
                }, 4, null);
            }

            public final DataStore l(final Context appContext, CoroutineContext blockingDispatcher, final SessionDataSerializer sessionDataSerializer) {
                Intrinsics.checkNotNullParameter(appContext, "appContext");
                Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
                Intrinsics.checkNotNullParameter(sessionDataSerializer, "sessionDataSerializer");
                return g(this, sessionDataSerializer, new ReplaceFileCorruptionHandler(new Function1() { // from class: com.google.firebase.sessions.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return FirebaseSessionsComponent.MainModule.Companion.m(sessionDataSerializer, (CorruptionException) obj);
                    }
                }), null, CoroutineScopeKt.a(blockingDispatcher), new Function0() { // from class: com.google.firebase.sessions.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FirebaseSessionsComponent.MainModule.Companion.n(appContext);
                    }
                }, 4, null);
            }

            public final TimeProvider o() {
                return TimeProviderImpl.f90120a;
            }

            public final UuidGenerator p() {
                return UuidGeneratorImpl.f90121a;
            }
        }
    }

    SharedSessionRepository a();

    FirebaseSessions b();
}
