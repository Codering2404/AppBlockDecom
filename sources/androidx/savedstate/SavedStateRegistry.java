package androidx.savedstate;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import androidx.savedstate.internal.SavedStateRegistryImpl;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SavedStateRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistryImpl f52999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Recreator.SavedStateProvider f53000b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface AutoRecreated {
        void a(SavedStateRegistryOwner savedStateRegistryOwner);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface SavedStateProvider {
        Bundle a();
    }

    public SavedStateRegistry(SavedStateRegistryImpl impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.f52999a = impl;
    }

    public final Bundle a(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f52999a.c(key);
    }

    public final SavedStateProvider b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f52999a.d(key);
    }

    public final void c(String key, SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f52999a.j(key, provider);
    }

    public final void d(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!this.f52999a.e()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.SavedStateProvider savedStateProvider = this.f53000b;
        if (savedStateProvider == null) {
            savedStateProvider = new Recreator.SavedStateProvider(this);
        }
        this.f53000b = savedStateProvider;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.SavedStateProvider savedStateProvider2 = this.f53000b;
            if (savedStateProvider2 != null) {
                String name = clazz.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                savedStateProvider2.b(name);
            }
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }

    public final void e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f52999a.k(key);
    }
}
