package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PoolingContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f35455a = R.id.f35459b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f35456b = R.id.f35458a;

    public static final void a(View view, PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        d(view).a(listener);
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Iterator it = ViewKt.b(view).iterator();
        while (it.hasNext()) {
            d((View) it.next()).b();
        }
    }

    public static final void c(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Iterator it = ViewGroupKt.a(viewGroup).iterator();
        while (it.hasNext()) {
            d((View) it.next()).b();
        }
    }

    private static final PoolingContainerListenerHolder d(View view) {
        int i3 = f35455a;
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(i3);
        if (poolingContainerListenerHolder != null) {
            return poolingContainerListenerHolder;
        }
        PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
        view.setTag(i3, poolingContainerListenerHolder2);
        return poolingContainerListenerHolder2;
    }

    public static final boolean e(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object tag = view.getTag(f35456b);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean f(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        for (Object obj : ViewKt.c(view)) {
            if ((obj instanceof View) && e((View) obj)) {
                return true;
            }
        }
        return false;
    }

    public static final void g(View view, PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        d(view).c(listener);
    }

    public static final void h(View view, boolean z2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(f35456b, Boolean.valueOf(z2));
    }
}
