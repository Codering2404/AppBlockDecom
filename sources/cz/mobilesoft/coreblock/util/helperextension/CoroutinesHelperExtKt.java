package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.base.fragment.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CoroutinesHelperExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CoroutineExceptionHandler f128471a = new CoroutinesHelperExtKt$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.u8);

    public static final CoroutineScope a(CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        return CoroutineScopeKt.a(dispatcher.plus(SupervisorKt.b(null, 1, null)).plus(f128471a));
    }

    public static final CoroutineExceptionHandler b() {
        return f128471a;
    }

    public static final void c(Lifecycle lifecycle, CoroutineDispatcher dispatcher, Function1 operation) {
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(operation, "operation");
        BuildersKt__Builders_commonKt.d(LifecycleKt.a(lifecycle), dispatcher.plus(SupervisorKt.b(null, 1, null)).plus(f128471a), null, new CoroutinesHelperExtKt$launch$1(operation, null), 2, null);
    }

    public static final void d(Function1 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        CoroutineScope applicationScope = LockieApplication.f95365k;
        Intrinsics.checkNotNullExpressionValue(applicationScope, "applicationScope");
        BuildersKt__Builders_commonKt.d(applicationScope, null, null, new CoroutinesHelperExtKt$launchGlobal$1(operation, null), 3, null);
    }

    public static final void e(LifecycleOwner lifecycleOwner, Function1 operation) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(lifecycleOwner), Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(f128471a), null, new CoroutinesHelperExtKt$launchOnIOUsingLifecycle$2(operation, null), 2, null);
    }

    public static final void f(BaseFragment baseFragment, Function1 operation) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(baseFragment), Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(f128471a), null, new CoroutinesHelperExtKt$launchOnIOUsingLifecycle$1(operation, null), 2, null);
    }

    public static final void g(CoroutineScope scope, Runnable block) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt__Builders_commonKt.d(scope, null, null, new CoroutinesHelperExtKt$launchOnScope$1(block, null), 3, null);
    }

    public static final void h(LifecycleOwner lifecycleOwner, Function1 operation) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        BuildersKt__Builders_commonKt.d(LifecycleOwnerKt.a(lifecycleOwner), SupervisorKt.b(null, 1, null).plus(f128471a), null, new CoroutinesHelperExtKt$launchOnceStarted$1(lifecycleOwner, operation, null), 2, null);
    }
}
