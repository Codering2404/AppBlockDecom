package androidx.window.core;

import android.util.Pair;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class PredicateAdapter {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static abstract class BaseHandler<T> implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final KClass f54136a;

        public abstract boolean a(Object obj, Object obj2);

        protected final boolean b(Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(method, "<this>");
            return Intrinsics.areEqual(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        protected final boolean c(Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(method, "<this>");
            return Intrinsics.areEqual(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        protected final boolean d(Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(method, "<this>");
            return Intrinsics.areEqual(method.getName(), "test") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        protected final boolean e(Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(method, "<this>");
            return Intrinsics.areEqual(method.getName(), InAppPurchaseConstants.METHOD_TO_STRING) && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(method, "method");
            if (d(method, objArr)) {
                return Boolean.valueOf(a(obj, KClasses.a(this.f54136a, objArr != null ? objArr[0] : null)));
            }
            if (b(method, objArr)) {
                Object obj2 = objArr != null ? objArr[0] : null;
                Intrinsics.checkNotNull(obj2);
                return Boolean.valueOf(obj == obj2);
            }
            if (c(method, objArr)) {
                return Integer.valueOf(hashCode());
            }
            if (e(method, objArr)) {
                return toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final KClass f54137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final KClass f54138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Function2 f54139d;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean a(Object obj, Pair parameter) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            return ((Boolean) this.f54139d.invoke(KClasses.a(this.f54137b, parameter.first), KClasses.a(this.f54138c, parameter.second))).booleanValue();
        }

        public int hashCode() {
            return this.f54139d.hashCode();
        }

        public String toString() {
            return this.f54139d.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PredicateStubHandler<T> extends BaseHandler<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1 f54140b;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean a(Object obj, Object parameter) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            Intrinsics.checkNotNullParameter(parameter, "parameter");
            return ((Boolean) this.f54140b.invoke(parameter)).booleanValue();
        }

        public int hashCode() {
            return this.f54140b.hashCode();
        }

        public String toString() {
            return this.f54140b.toString();
        }
    }
}
