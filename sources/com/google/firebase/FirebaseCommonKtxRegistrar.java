package com.google.firebase;

import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        Component componentD = Component.c(Qualified.a(Background.class, CoroutineDispatcher.class)).b(Dependency.k(Qualified.a(Background.class, Executor.class))).f(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$1
            @Override // com.google.firebase.components.ComponentFactory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineDispatcher a(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(Qualified.a(Background.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "get(...)");
                return ExecutorsKt.b((Executor) objE);
            }
        }).d();
        Intrinsics.checkNotNullExpressionValue(componentD, "build(...)");
        Component componentD2 = Component.c(Qualified.a(Lightweight.class, CoroutineDispatcher.class)).b(Dependency.k(Qualified.a(Lightweight.class, Executor.class))).f(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$2
            @Override // com.google.firebase.components.ComponentFactory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineDispatcher a(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(Qualified.a(Lightweight.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "get(...)");
                return ExecutorsKt.b((Executor) objE);
            }
        }).d();
        Intrinsics.checkNotNullExpressionValue(componentD2, "build(...)");
        Component componentD3 = Component.c(Qualified.a(Blocking.class, CoroutineDispatcher.class)).b(Dependency.k(Qualified.a(Blocking.class, Executor.class))).f(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$3
            @Override // com.google.firebase.components.ComponentFactory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineDispatcher a(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(Qualified.a(Blocking.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "get(...)");
                return ExecutorsKt.b((Executor) objE);
            }
        }).d();
        Intrinsics.checkNotNullExpressionValue(componentD3, "build(...)");
        Component componentD4 = Component.c(Qualified.a(UiThread.class, CoroutineDispatcher.class)).b(Dependency.k(Qualified.a(UiThread.class, Executor.class))).f(new ComponentFactory() { // from class: com.google.firebase.FirebaseCommonKtxRegistrar$getComponents$$inlined$coroutineDispatcher$4
            @Override // com.google.firebase.components.ComponentFactory
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CoroutineDispatcher a(ComponentContainer componentContainer) {
                Object objE = componentContainer.e(Qualified.a(UiThread.class, Executor.class));
                Intrinsics.checkNotNullExpressionValue(objE, "get(...)");
                return ExecutorsKt.b((Executor) objE);
            }
        }).d();
        Intrinsics.checkNotNullExpressionValue(componentD4, "build(...)");
        return CollectionsKt.listOf((Object[]) new Component[]{componentD, componentD2, componentD3, componentD4});
    }
}
