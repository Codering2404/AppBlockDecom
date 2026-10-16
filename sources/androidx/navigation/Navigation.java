package androidx.navigation;

import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

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
public final class Navigation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Navigation f48981a = new Navigation();

    private Navigation() {
    }

    public static final NavController c(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        NavController navControllerD = f48981a.d(view);
        if (navControllerD != null) {
            return navControllerD;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private final NavController d(View view) {
        return (NavController) SequencesKt.E(SequencesKt.N(SequencesKt.h(view, new Function1() { // from class: androidx.navigation.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Navigation.e((View) obj);
            }
        }), new Function1() { // from class: androidx.navigation.c0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Navigation.f((View) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View e(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object parent = it.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavController f(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return f48981a.g(it);
    }

    private final NavController g(View view) {
        Object tag = view.getTag(R.id.f48996a);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static final void h(View view, NavController navController) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(R.id.f48996a, navController);
    }
}
