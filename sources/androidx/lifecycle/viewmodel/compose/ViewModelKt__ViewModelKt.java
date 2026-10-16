package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
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
final /* synthetic */ class ViewModelKt__ViewModelKt {
    public static final ViewModel a(ViewModelStoreOwner viewModelStoreOwner, KClass kClass, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras) {
        ViewModelProvider viewModelProviderA = factory != null ? ViewModelProvider.f40124b.a(viewModelStoreOwner.getViewModelStore(), factory, creationExtras) : viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ViewModelProvider.f40124b.a(viewModelStoreOwner.getViewModelStore(), ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory(), creationExtras) : ViewModelProvider.Companion.d(ViewModelProvider.f40124b, viewModelStoreOwner, null, null, 6, null);
        return str != null ? viewModelProviderA.c(str, kClass) : viewModelProviderA.d(kClass);
    }

    public static final ViewModel b(KClass kClass, ViewModelStoreOwner viewModelStoreOwner, String str, ViewModelProvider.Factory factory, CreationExtras creationExtras, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0 && (viewModelStoreOwner = LocalViewModelStoreOwner.f40240a.c(composer, 6)) == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
        }
        if ((i4 & 4) != 0) {
            str = null;
        }
        if ((i4 & 8) != 0) {
            factory = null;
        }
        if ((i4 & 16) != 0) {
            creationExtras = viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f40230c;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1673618944, i3, -1, "androidx.lifecycle.viewmodel.compose.viewModel (ViewModel.kt:105)");
        }
        ViewModel viewModelA = ViewModelKt.a(viewModelStoreOwner, kClass, str, factory, creationExtras);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return viewModelA;
    }
}
