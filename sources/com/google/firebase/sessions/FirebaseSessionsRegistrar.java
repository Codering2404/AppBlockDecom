package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

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
@Metadata
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String LIBRARY_NAME = "fire-sessions";
    private static final Qualified<Context> appContext;
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    private static final Qualified<FirebaseApp> firebaseApp;
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    private static final Qualified<FirebaseSessionsComponent> firebaseSessionsComponent;
    private static final Qualified<TransportFactory> transportFactory;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Qualified<Context> qualifiedB = Qualified.b(Context.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedB, "unqualified(...)");
        appContext = qualifiedB;
        Qualified<FirebaseApp> qualifiedB2 = Qualified.b(FirebaseApp.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedB2, "unqualified(...)");
        firebaseApp = qualifiedB2;
        Qualified<FirebaseInstallationsApi> qualifiedB3 = Qualified.b(FirebaseInstallationsApi.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedB3, "unqualified(...)");
        firebaseInstallationsApi = qualifiedB3;
        Qualified<CoroutineDispatcher> qualifiedA = Qualified.a(Background.class, CoroutineDispatcher.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA, "qualified(...)");
        backgroundDispatcher = qualifiedA;
        Qualified<CoroutineDispatcher> qualifiedA2 = Qualified.a(Blocking.class, CoroutineDispatcher.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedA2, "qualified(...)");
        blockingDispatcher = qualifiedA2;
        Qualified<TransportFactory> qualifiedB4 = Qualified.b(TransportFactory.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedB4, "unqualified(...)");
        transportFactory = qualifiedB4;
        Qualified<FirebaseSessionsComponent> qualifiedB5 = Qualified.b(FirebaseSessionsComponent.class);
        Intrinsics.checkNotNullExpressionValue(qualifiedB5, "unqualified(...)");
        firebaseSessionsComponent = qualifiedB5;
        try {
            MultiProcessDataStoreFactory.f35776a.getClass();
        } catch (NoClassDefFoundError unused) {
            Log.w("FirebaseSessions", "Your app is experiencing a known issue in the Android Gradle plugin, see https://issuetracker.google.com/328687152\n\nIt affects Java-only apps using AGP version 8.3.2 and under. To avoid the issue, either:\n\n1. Upgrade Android Gradle plugin to 8.4.0+\n   Follow the guide at https://developer.android.com/build/agp-upgrade-assistant\n\n2. Or, add the Kotlin plugin to your app\n   Follow the guide at https://developer.android.com/kotlin/add-kotlin\n\n3. Or, do the technical workaround described in https://issuetracker.google.com/issues/328687152#comment3");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        return ((FirebaseSessionsComponent) componentContainer.e(firebaseSessionsComponent)).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseSessionsComponent getComponents$lambda$1(ComponentContainer componentContainer) {
        FirebaseSessionsComponent.Builder builderA = DaggerFirebaseSessionsComponent.a();
        Object objE = componentContainer.e(appContext);
        Intrinsics.checkNotNullExpressionValue(objE, "get(...)");
        FirebaseSessionsComponent.Builder builderF = builderA.f((Context) objE);
        Object objE2 = componentContainer.e(backgroundDispatcher);
        Intrinsics.checkNotNullExpressionValue(objE2, "get(...)");
        FirebaseSessionsComponent.Builder builderC = builderF.c((CoroutineContext) objE2);
        Object objE3 = componentContainer.e(blockingDispatcher);
        Intrinsics.checkNotNullExpressionValue(objE3, "get(...)");
        FirebaseSessionsComponent.Builder builderE = builderC.e((CoroutineContext) objE3);
        Object objE4 = componentContainer.e(firebaseApp);
        Intrinsics.checkNotNullExpressionValue(objE4, "get(...)");
        FirebaseSessionsComponent.Builder builderD = builderE.d((FirebaseApp) objE4);
        Object objE5 = componentContainer.e(firebaseInstallationsApi);
        Intrinsics.checkNotNullExpressionValue(objE5, "get(...)");
        FirebaseSessionsComponent.Builder builderA2 = builderD.a((FirebaseInstallationsApi) objE5);
        Provider providerB = componentContainer.b(transportFactory);
        Intrinsics.checkNotNullExpressionValue(providerB, "getProvider(...)");
        return builderA2.b(providerB).build();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<? extends Object>> getComponents() {
        return CollectionsKt.listOf((Object[]) new Component[]{Component.e(FirebaseSessions.class).h(LIBRARY_NAME).b(Dependency.k(firebaseSessionsComponent)).f(new ComponentFactory() { // from class: com.google.firebase.sessions.g
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return FirebaseSessionsRegistrar.getComponents$lambda$0(componentContainer);
            }
        }).e().d(), Component.e(FirebaseSessionsComponent.class).h("fire-sessions-component").b(Dependency.k(appContext)).b(Dependency.k(backgroundDispatcher)).b(Dependency.k(blockingDispatcher)).b(Dependency.k(firebaseApp)).b(Dependency.k(firebaseInstallationsApi)).b(Dependency.m(transportFactory)).f(new ComponentFactory() { // from class: com.google.firebase.sessions.h
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return FirebaseSessionsRegistrar.getComponents$lambda$1(componentContainer);
            }
        }).d(), LibraryVersionComponent.b(LIBRARY_NAME, "3.0.2")});
    }
}
