package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class LocalViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalViewModelStoreOwner f40240a = new LocalViewModelStoreOwner();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f40241b = CompositionLocalKt.e(null, new Function0() { // from class: androidx.lifecycle.viewmodel.compose.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return LocalViewModelStoreOwner.b();
        }
    }, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40242c = 0;

    private LocalViewModelStoreOwner() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelStoreOwner b() {
        return null;
    }

    public final ViewModelStoreOwner c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-584162872, i3, -1, "androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner.<get-current> (LocalViewModelStoreOwner.kt:34)");
        }
        ViewModelStoreOwner viewModelStoreOwnerA = (ViewModelStoreOwner) composer.q(f40241b);
        if (viewModelStoreOwnerA == null) {
            composer.a0(1260197609);
            viewModelStoreOwnerA = LocalViewModelStoreOwner_androidKt.a(composer, 0);
        } else {
            composer.a0(1260196493);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return viewModelStoreOwnerA;
    }

    public final ProvidedValue d(ViewModelStoreOwner viewModelStoreOwner) {
        return f40241b.d(viewModelStoreOwner);
    }
}
