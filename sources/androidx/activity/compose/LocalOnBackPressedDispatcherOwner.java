package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class LocalOnBackPressedDispatcherOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LocalOnBackPressedDispatcherOwner f458a = new LocalOnBackPressedDispatcherOwner();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ProvidableCompositionLocal f459b = CompositionLocalKt.e(null, new Function0<OnBackPressedDispatcherOwner>() { // from class: androidx.activity.compose.LocalOnBackPressedDispatcherOwner$LocalOnBackPressedDispatcherOwner$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final OnBackPressedDispatcherOwner invoke() {
            return null;
        }
    }, 1, null);

    private LocalOnBackPressedDispatcherOwner() {
    }

    public final OnBackPressedDispatcherOwner a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2068013981, i3, -1, "androidx.activity.compose.LocalOnBackPressedDispatcherOwner.<get-current> (BackHandler.kt:50)");
        }
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwnerA = (OnBackPressedDispatcherOwner) composer.q(f459b);
        if (onBackPressedDispatcherOwnerA == null) {
            composer.a0(544166745);
            onBackPressedDispatcherOwnerA = ViewTreeOnBackPressedDispatcherOwner.a((View) composer.q(AndroidCompositionLocals_androidKt.j()));
            composer.U();
        } else {
            composer.a0(544164296);
            composer.U();
        }
        if (onBackPressedDispatcherOwnerA == null) {
            composer.a0(544168748);
            Object baseContext = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof OnBackPressedDispatcherOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            onBackPressedDispatcherOwnerA = (OnBackPressedDispatcherOwner) baseContext;
            composer.U();
        } else {
            composer.a0(544164377);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return onBackPressedDispatcherOwnerA;
    }

    public final ProvidedValue b(OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        return f459b.d(onBackPressedDispatcherOwner);
    }
}
