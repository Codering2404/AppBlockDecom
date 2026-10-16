package androidx.compose.ui.graphics;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CanvasUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CanvasUtils f25706a = new CanvasUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f25707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f25708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f25709d;

    private CanvasUtils() {
    }

    public final void a(android.graphics.Canvas canvas, boolean z2) {
        Method method;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            CanvasZHelper.f25710a.a(canvas, z2);
            return;
        }
        if (!f25709d) {
            try {
                if (i3 == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    f25707b = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertReorderBarrier", new Class[0]);
                    f25708c = (Method) declaredMethod.invoke(android.graphics.Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    f25707b = android.graphics.Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    f25708c = android.graphics.Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = f25707b;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = f25708c;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            f25709d = true;
        }
        if (z2) {
            try {
                Method method4 = f25707b;
                if (method4 != null) {
                    Intrinsics.checkNotNull(method4);
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z2 || (method = f25708c) == null) {
            return;
        }
        Intrinsics.checkNotNull(method);
        method.invoke(canvas, null);
    }
}
