package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public final class ViewModelProviderImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelStore f40236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewModelProvider.Factory f40237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CreationExtras f40238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SynchronizedObject f40239d;

    public ViewModelProviderImpl(ViewModelStore store, ViewModelProvider.Factory factory, CreationExtras defaultExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultExtras, "defaultExtras");
        this.f40236a = store;
        this.f40237b = factory;
        this.f40238c = defaultExtras;
        this.f40239d = new SynchronizedObject();
    }

    public static /* synthetic */ ViewModel e(ViewModelProviderImpl viewModelProviderImpl, KClass kClass, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = ViewModelProviders.f40253a.e(kClass);
        }
        return viewModelProviderImpl.d(kClass, str);
    }

    public final ViewModel d(KClass modelClass, String key) {
        ViewModel viewModelB;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f40239d) {
            try {
                viewModelB = this.f40236a.b(key);
                if (modelClass.e(viewModelB)) {
                    if (this.f40237b instanceof ViewModelProvider.OnRequeryFactory) {
                        ViewModelProvider.OnRequeryFactory onRequeryFactory = (ViewModelProvider.OnRequeryFactory) this.f40237b;
                        Intrinsics.checkNotNull(viewModelB);
                        onRequeryFactory.a(viewModelB);
                    }
                    Intrinsics.checkNotNull(viewModelB, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.f40238c);
                    mutableCreationExtras.c(ViewModelProvider.f40125c, key);
                    viewModelB = ViewModelProviderImpl_androidKt.a(this.f40237b, modelClass, mutableCreationExtras);
                    this.f40236a.d(key, viewModelB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return viewModelB;
    }
}
