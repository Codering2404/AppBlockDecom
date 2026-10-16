package androidx.compose.runtime.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImpl;
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
public final class ComposableLambdaKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f24799a = new Object();

    public static final int a(int i3, int i4) {
        return i3 << (((i4 % 10) * 3) + 1);
    }

    public static final ComposableLambda b(Composer composer, int i3, boolean z2, Object obj) {
        ComposableLambdaImpl composableLambdaImpl;
        composer.K(Integer.rotateLeft(i3, 1), f24799a);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            composableLambdaImpl = new ComposableLambdaImpl(i3, z2, obj);
            composer.w(composableLambdaImpl);
        } else {
            Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.runtime.internal.ComposableLambdaImpl");
            composableLambdaImpl = (ComposableLambdaImpl) objG;
            composableLambdaImpl.P(obj);
        }
        composer.X();
        return composableLambdaImpl;
    }

    public static final ComposableLambda c(int i3, boolean z2, Object obj) {
        return new ComposableLambdaImpl(i3, z2, obj);
    }

    public static final int d(int i3) {
        return a(2, i3);
    }

    public static final ComposableLambda e(int i3, boolean z2, Object obj, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1573003438, i4, -1, "androidx.compose.runtime.internal.rememberComposableLambda (ComposableLambda.kt:1366)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new ComposableLambdaImpl(i3, z2, obj);
            composer.w(objG);
        }
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) objG;
        composableLambdaImpl.P(obj);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return composableLambdaImpl;
    }

    public static final boolean f(RecomposeScope recomposeScope, RecomposeScope recomposeScope2) {
        if (recomposeScope == null) {
            return true;
        }
        if (!(recomposeScope instanceof RecomposeScopeImpl) || !(recomposeScope2 instanceof RecomposeScopeImpl)) {
            return false;
        }
        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) recomposeScope;
        return !recomposeScopeImpl.u() || Intrinsics.areEqual(recomposeScope, recomposeScope2) || Intrinsics.areEqual(recomposeScopeImpl.i(), ((RecomposeScopeImpl) recomposeScope2).i());
    }

    public static final int g(int i3) {
        return a(1, i3);
    }
}
