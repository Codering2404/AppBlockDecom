package androidx.window;

import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SafeWindowExtensionsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f54018a;

    public SafeWindowExtensionsProvider(ClassLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.f54018a = loader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54018a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return clsLoadClass;
    }

    private final boolean e() {
        return ReflectionUtils.f54439a.a(new Function0<Class<?>>() { // from class: androidx.window.SafeWindowExtensionsProvider$isWindowExtensionsPresent$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Class invoke() throws ClassNotFoundException {
                Class<?> clsLoadClass = this.f54019a.f54018a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
                Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
                return clsLoadClass;
            }
        });
    }

    public final Class c() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54018a.loadClass("androidx.window.extensions.WindowExtensions");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return clsLoadClass;
    }

    public final boolean f() {
        return e() && ReflectionUtils.f("WindowExtensionsProvider#getWindowExtensions is not valid", new Function0<Boolean>() { // from class: androidx.window.SafeWindowExtensionsProvider$isWindowExtensionsValid$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                Method getWindowExtensionsMethod = this.f54020a.d().getDeclaredMethod("getWindowExtensions", null);
                Class clsC = this.f54020a.c();
                ReflectionUtils reflectionUtils = ReflectionUtils.f54439a;
                Intrinsics.checkNotNullExpressionValue(getWindowExtensionsMethod, "getWindowExtensionsMethod");
                return Boolean.valueOf(reflectionUtils.b(getWindowExtensionsMethod, clsC) && reflectionUtils.e(getWindowExtensionsMethod));
            }
        });
    }
}
