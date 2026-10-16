package androidx.savedstate.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class LocalSavedStateRegistryOwnerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f53006a;

    static {
        Object objB;
        ProvidableCompositionLocal providableCompositionLocal;
        try {
            Result.Companion companion = Result.f139772b;
            ClassLoader classLoader = SavedStateRegistryOwner.class.getClassLoader();
            Intrinsics.checkNotNull(classLoader);
            Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalSavedStateRegistryOwner", null);
            Annotation[] annotations = method.getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "getAnnotations(...)");
            int length = annotations.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    Object objInvoke = method.invoke(null, null);
                    if (objInvoke instanceof ProvidableCompositionLocal) {
                        providableCompositionLocal = (ProvidableCompositionLocal) objInvoke;
                    }
                } else if (annotations[i3] instanceof Deprecated) {
                    break;
                } else {
                    i3++;
                }
            }
            providableCompositionLocal = null;
            objB = Result.b(providableCompositionLocal);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        ProvidableCompositionLocal providableCompositionLocalG = (ProvidableCompositionLocal) (Result.g(objB) ? null : objB);
        if (providableCompositionLocalG == null) {
            providableCompositionLocalG = CompositionLocalKt.g(new Function0() { // from class: h.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LocalSavedStateRegistryOwnerKt.b();
                }
            });
        }
        f53006a = providableCompositionLocalG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateRegistryOwner b() {
        throw new IllegalStateException("CompositionLocal LocalSavedStateRegistryOwner not present");
    }

    public static final ProvidableCompositionLocal c() {
        return f53006a;
    }
}
