package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.core.ConsumerAdapter;
import androidx.window.core.ExtensionsUtil;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
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
public final class SafeWindowLayoutComponentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f54337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f54338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SafeWindowExtensionsProvider f54339c;

    public SafeWindowLayoutComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        this.f54337a = loader;
        this.f54338b = consumerAdapter;
        this.f54339c = new SafeWindowExtensionsProvider(loader);
    }

    private final boolean e() {
        if (!n()) {
            return false;
        }
        int iA = ExtensionsUtil.f54127a.a();
        if (iA == 1) {
            return i();
        }
        if (2 > iA || iA > Integer.MAX_VALUE) {
            return false;
        }
        return j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class f() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54337a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return clsLoadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class h() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54337a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return clsLoadClass;
    }

    private final boolean k() {
        return ReflectionUtils.f("FoldingFeature class is not valid", new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
                /*
                    r5 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = r5.f54340a
                    java.lang.Class r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.b(r0)
                    java.lang.String r1 = "getBounds"
                    r2 = 0
                    java.lang.reflect.Method r1 = r0.getMethod(r1, r2)
                    java.lang.String r3 = "getType"
                    java.lang.reflect.Method r3 = r0.getMethod(r3, r2)
                    java.lang.String r4 = "getState"
                    java.lang.reflect.Method r0 = r0.getMethod(r4, r2)
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.f54439a
                    java.lang.String r4 = "getBoundsMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                    java.lang.Class<android.graphics.Rect> r4 = android.graphics.Rect.class
                    kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r4)
                    boolean r4 = r2.c(r1, r4)
                    if (r4 == 0) goto L60
                    boolean r1 = r2.e(r1)
                    if (r1 == 0) goto L60
                    java.lang.String r1 = "getTypeMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
                    java.lang.Class r1 = java.lang.Integer.TYPE
                    kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.b(r1)
                    boolean r4 = r2.c(r3, r4)
                    if (r4 == 0) goto L60
                    boolean r3 = r2.e(r3)
                    if (r3 == 0) goto L60
                    java.lang.String r3 = "getStateMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
                    kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.b(r1)
                    boolean r1 = r2.c(r0, r1)
                    if (r1 == 0) goto L60
                    boolean r0 = r2.e(r0)
                    if (r0 == 0) goto L60
                    r0 = 1
                    goto L61
                L60:
                    r0 = 0
                L61:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean l() {
        return ReflectionUtils.f("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerJavaConsumerValid$1
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
                /*
                    r4 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = r4.f54341a
                    androidx.window.core.ConsumerAdapter r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.a(r0)
                    java.lang.Class r0 = r0.b()
                    if (r0 != 0) goto Lf
                    java.lang.Boolean r0 = java.lang.Boolean.FALSE
                    return r0
                Lf:
                    androidx.window.layout.SafeWindowLayoutComponentProvider r1 = r4.f54341a
                    java.lang.Class r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.d(r1)
                    java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
                    java.lang.Class[] r2 = new java.lang.Class[]{r2, r0}
                    java.lang.String r3 = "addWindowLayoutInfoListener"
                    java.lang.reflect.Method r2 = r1.getMethod(r3, r2)
                    java.lang.String r3 = "removeWindowLayoutInfoListener"
                    java.lang.Class[] r0 = new java.lang.Class[]{r0}
                    java.lang.reflect.Method r0 = r1.getMethod(r3, r0)
                    androidx.window.reflection.ReflectionUtils r1 = androidx.window.reflection.ReflectionUtils.f54439a
                    java.lang.String r3 = "addListenerMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                    boolean r2 = r1.e(r2)
                    if (r2 == 0) goto L45
                    java.lang.String r2 = "removeListenerMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                    boolean r0 = r1.e(r0)
                    if (r0 == 0) goto L45
                    r0 = 1
                    goto L46
                L45:
                    r0 = 0
                L46:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerJavaConsumerValid$1.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean m() {
        return ReflectionUtils.f("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerWindowConsumerValid$1
            {
                super(0);
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.ClassNotFoundException {
                /*
                    r4 = this;
                    androidx.window.layout.SafeWindowLayoutComponentProvider r0 = r4.f54342a
                    java.lang.Class r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.d(r0)
                    java.lang.Class<android.content.Context> r1 = android.content.Context.class
                    java.lang.Class<androidx.window.extensions.core.util.function.Consumer> r2 = androidx.window.extensions.core.util.function.Consumer.class
                    java.lang.Class[] r1 = new java.lang.Class[]{r1, r2}
                    java.lang.String r3 = "addWindowLayoutInfoListener"
                    java.lang.reflect.Method r1 = r0.getMethod(r3, r1)
                    java.lang.String r3 = "removeWindowLayoutInfoListener"
                    java.lang.Class[] r2 = new java.lang.Class[]{r2}
                    java.lang.reflect.Method r0 = r0.getMethod(r3, r2)
                    androidx.window.reflection.ReflectionUtils r2 = androidx.window.reflection.ReflectionUtils.f54439a
                    java.lang.String r3 = "addListenerMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                    boolean r1 = r2.e(r1)
                    if (r1 == 0) goto L38
                    java.lang.String r1 = "removeListenerMethod"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    boolean r0 = r2.e(r0)
                    if (r0 == 0) goto L38
                    r0 = 1
                    goto L39
                L38:
                    r0 = 0
                L39:
                    java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerWindowConsumerValid$1.invoke():java.lang.Boolean");
            }
        });
    }

    private final boolean o() {
        return ReflectionUtils.f("WindowExtensions#getWindowLayoutComponent is not valid", new Function0<Boolean>() { // from class: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() throws NoSuchMethodException, ClassNotFoundException {
                Method getWindowLayoutComponentMethod = this.f54343a.f54339c.c().getMethod("getWindowLayoutComponent", null);
                Class clsH = this.f54343a.h();
                ReflectionUtils reflectionUtils = ReflectionUtils.f54439a;
                Intrinsics.checkNotNullExpressionValue(getWindowLayoutComponentMethod, "getWindowLayoutComponentMethod");
                return Boolean.valueOf(reflectionUtils.e(getWindowLayoutComponentMethod) && reflectionUtils.b(getWindowLayoutComponentMethod, clsH));
            }
        });
    }

    public final WindowLayoutComponent g() {
        if (!e()) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final boolean i() {
        return l();
    }

    public final boolean j() {
        return i() && m();
    }

    public final boolean n() {
        return this.f54339c.f() && o() && k();
    }
}
