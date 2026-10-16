package coil.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.Coil;
import coil.ImageLoader;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
@Metadata
@JvmInline
public final class ImageLoaderProvidableCompositionLocal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProvidableCompositionLocal f55580a;

    public static /* synthetic */ ProvidableCompositionLocal b(ProvidableCompositionLocal providableCompositionLocal, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            providableCompositionLocal = CompositionLocalKt.g(new Function0<ImageLoader>() { // from class: coil.compose.ImageLoaderProvidableCompositionLocal.1
                @Override // kotlin.jvm.functions.Function0
                public final ImageLoader invoke() {
                    return null;
                }
            });
        }
        return a(providableCompositionLocal);
    }

    public static boolean c(ProvidableCompositionLocal providableCompositionLocal, Object obj) {
        return (obj instanceof ImageLoaderProvidableCompositionLocal) && Intrinsics.areEqual(providableCompositionLocal, ((ImageLoaderProvidableCompositionLocal) obj).g());
    }

    public static final ImageLoader d(ProvidableCompositionLocal providableCompositionLocal, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-617597678, i3, -1, "coil.compose.ImageLoaderProvidableCompositionLocal.<get-current> (LocalImageLoader.kt:49)");
        }
        ImageLoader imageLoaderA = (ImageLoader) composer.q(providableCompositionLocal);
        if (imageLoaderA == null) {
            imageLoaderA = Coil.a((Context) composer.q(AndroidCompositionLocals_androidKt.g()));
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return imageLoaderA;
    }

    public static int e(ProvidableCompositionLocal providableCompositionLocal) {
        return providableCompositionLocal.hashCode();
    }

    public static String f(ProvidableCompositionLocal providableCompositionLocal) {
        return "ImageLoaderProvidableCompositionLocal(delegate=" + providableCompositionLocal + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f55580a, obj);
    }

    public final /* synthetic */ ProvidableCompositionLocal g() {
        return this.f55580a;
    }

    public int hashCode() {
        return e(this.f55580a);
    }

    public String toString() {
        return f(this.f55580a);
    }

    public static ProvidableCompositionLocal a(ProvidableCompositionLocal providableCompositionLocal) {
        return providableCompositionLocal;
    }
}
