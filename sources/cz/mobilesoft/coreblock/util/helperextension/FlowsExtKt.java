package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;

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
public final class FlowsExtKt {
    public static final void a(LifecycleOwner lifecycleOwner, Flow flow1, Flow flow2, Function2 function) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(flow1, "flow1");
        Intrinsics.checkNotNullParameter(flow2, "flow2");
        Intrinsics.checkNotNullParameter(function, "function");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.i(LifecycleOwnerKt.a(lifecycleOwner), CoroutinesHelperExtKt.b()), null, null, new FlowsExtKt$collectCombinedWhenStarted$1(lifecycleOwner, flow1, flow2, function, null), 3, null);
    }

    public static final void b(LifecycleOwner lifecycleOwner, Flow flow1, Flow flow2, Flow flow3, Function3 function) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(flow1, "flow1");
        Intrinsics.checkNotNullParameter(flow2, "flow2");
        Intrinsics.checkNotNullParameter(flow3, "flow3");
        Intrinsics.checkNotNullParameter(function, "function");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.i(LifecycleOwnerKt.a(lifecycleOwner), CoroutinesHelperExtKt.b()), null, null, new FlowsExtKt$collectCombinedWhenStarted$2(lifecycleOwner, flow1, flow2, flow3, function, null), 3, null);
    }

    public static final void c(LifecycleOwner lifecycleOwner, Flow flow, Function1 function) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(function, "function");
        BuildersKt__Builders_commonKt.d(CoroutineScopeKt.i(LifecycleOwnerKt.a(lifecycleOwner), CoroutinesHelperExtKt.b()), null, null, new FlowsExtKt$collectWhenStarted$1(lifecycleOwner, flow, function, null), 3, null);
    }
}
