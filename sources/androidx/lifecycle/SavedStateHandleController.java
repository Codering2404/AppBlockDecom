package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class SavedStateHandleController implements LifecycleEventObserver, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SavedStateHandle f40086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f40087c;

    public SavedStateHandleController(String key, SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.f40085a = key;
        this.f40086b = handle;
    }

    public final void a(SavedStateRegistry registry, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (this.f40087c) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f40087c = true;
        lifecycle.addObserver(this);
        registry.c(this.f40085a, this.f40086b.d());
    }

    public final SavedStateHandle c() {
        return this.f40086b;
    }

    public final boolean f() {
        return this.f40087c;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void j(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f40087c = false;
            source.getLifecycle().removeObserver(this);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }
}
