package androidx.window.core;

import android.app.Activity;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClasses;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ConsumerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClassLoader f54115a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ConsumerHandler<T> implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KClass f54116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1 f54117b;

        public ConsumerHandler(KClass clazz, Function1 consumer) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(consumer, "consumer");
            this.f54116a = clazz;
            this.f54117b = consumer;
        }

        private final boolean b(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        private final boolean c(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        private final boolean d(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean e(Method method, Object[] objArr) {
            return Intrinsics.areEqual(method.getName(), InAppPurchaseConstants.METHOD_TO_STRING) && method.getReturnType().equals(String.class) && objArr == null;
        }

        public final void a(Object parameter) {
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            this.f54117b.invoke(parameter);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(method, "method");
            if (b(method, objArr)) {
                a(KClasses.a(this.f54116a, objArr != null ? objArr[0] : null));
                return Unit.f139807a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f54117b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f54117b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Subscription {
        void dispose();
    }

    public ConsumerAdapter(ClassLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.f54115a = loader;
    }

    private final Object a(KClass kClass, Function1 function1) {
        Object objNewProxyInstance = Proxy.newProxyInstance(this.f54115a, new Class[]{d()}, new ConsumerHandler(kClass, function1));
        Intrinsics.checkNotNullExpressionValue(objNewProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return objNewProxyInstance;
    }

    private final Class d() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.f54115a.loadClass("java.util.function.Consumer");
        Intrinsics.checkNotNullExpressionValue(clsLoadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return clsLoadClass;
    }

    public final Class b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final Subscription c(final Object obj, KClass clazz, String addMethodName, String removeMethodName, Activity activity, Function1 consumer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(addMethodName, "addMethodName");
        Intrinsics.checkNotNullParameter(removeMethodName, "removeMethodName");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        final Object objA = a(clazz, consumer);
        obj.getClass().getMethod(addMethodName, Activity.class, d()).invoke(obj, activity, objA);
        final Method method = obj.getClass().getMethod(removeMethodName, d());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter$createSubscription$1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void dispose() throws IllegalAccessException, InvocationTargetException {
                method.invoke(obj, objA);
            }
        };
    }
}
