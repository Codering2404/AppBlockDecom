package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
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
public final class NavArgsLazy<Args extends NavArgs> implements Lazy<Args> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f48767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f48768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NavArgs f48769c;

    @Override // kotlin.Lazy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NavArgs getValue() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        NavArgs navArgs = this.f48769c;
        if (navArgs != null) {
            return navArgs;
        }
        Bundle bundle = (Bundle) this.f48768b.invoke();
        Method method = (Method) NavArgsLazy_androidKt.a().get(this.f48767a);
        if (method == null) {
            Class clsA = JvmClassMappingKt.a(this.f48767a);
            Class[] clsArrB = NavArgsLazy_androidKt.b();
            method = clsA.getMethod("fromBundle", (Class[]) Arrays.copyOf(clsArrB, clsArrB.length));
            NavArgsLazy_androidKt.a().put(this.f48767a, method);
            Intrinsics.checkNotNullExpressionValue(method, "also(...)");
        }
        Object objInvoke = method.invoke(null, bundle);
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy");
        NavArgs navArgs2 = (NavArgs) objInvoke;
        this.f48769c = navArgs2;
        return navArgs2;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f48769c != null;
    }
}
