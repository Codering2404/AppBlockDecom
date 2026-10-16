package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
public final class OnBackPressedDispatcherKt {
    public static final OnBackPressedCallback a(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, final boolean z2, final Function1 onBackPressed) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "<this>");
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(z2) { // from class: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                onBackPressed.invoke(this);
            }
        };
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.i(lifecycleOwner, onBackPressedCallback);
            return onBackPressedCallback;
        }
        onBackPressedDispatcher.h(onBackPressedCallback);
        return onBackPressedCallback;
    }

    public static /* synthetic */ OnBackPressedCallback b(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return a(onBackPressedDispatcher, lifecycleOwner, z2, function1);
    }
}
