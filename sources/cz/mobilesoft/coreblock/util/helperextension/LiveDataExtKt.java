package cz.mobilesoft.coreblock.util.helperextension;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
public final class LiveDataExtKt {
    public static final void c(Fragment fragment, LiveData liveData, final Function1 observeFun) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(observeFun, "observeFun");
        liveData.j(fragment.getViewLifecycleOwner(), new LiveDataExtKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.x
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LiveDataExtKt.d(observeFun, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function1 function1, Object obj) {
        if (obj != null) {
            function1.invoke(obj);
        }
        return Unit.f139807a;
    }

    public static final LiveData e(LiveData liveData, final CoroutineScope coroutineScope, final Function2 transformation) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(transformation, "transformation");
        return Transformations.f(liveData, new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.y
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LiveDataExtKt.f(coroutineScope, transformation, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData f(CoroutineScope coroutineScope, Function2 function2, Object obj) {
        return CoroutineLiveDataKt.c(coroutineScope.getCoroutineContext(), 0L, new LiveDataExtKt$switchMapAsync$1$1(function2, obj, null), 2, null);
    }
}
