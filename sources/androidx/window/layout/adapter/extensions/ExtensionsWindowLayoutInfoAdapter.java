package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.HardwareFoldingFeature;
import androidx.window.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculatorCompat;
import java.util.ArrayList;
import java.util.List;
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
public final class ExtensionsWindowLayoutInfoAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtensionsWindowLayoutInfoAdapter f54389a = new ExtensionsWindowLayoutInfoAdapter();

    private ExtensionsWindowLayoutInfoAdapter() {
    }

    private final boolean d(WindowMetrics windowMetrics, Bounds bounds) {
        Rect rectA = windowMetrics.a();
        if (bounds.e()) {
            return false;
        }
        if (bounds.d() != rectA.width() && bounds.a() != rectA.height()) {
            return false;
        }
        if (bounds.d() >= rectA.width() || bounds.a() >= rectA.height()) {
            return (bounds.d() == rectA.width() && bounds.a() == rectA.height()) ? false : true;
        }
        return false;
    }

    public final FoldingFeature a(WindowMetrics windowMetrics, androidx.window.extensions.layout.FoldingFeature oemFeature) {
        HardwareFoldingFeature.Type typeA;
        FoldingFeature.State state;
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        Intrinsics.checkNotNullParameter(oemFeature, "oemFeature");
        int type = oemFeature.getType();
        if (type == 1) {
            typeA = HardwareFoldingFeature.Type.f54333b.a();
        } else {
            if (type != 2) {
                return null;
            }
            typeA = HardwareFoldingFeature.Type.f54333b.b();
        }
        int state2 = oemFeature.getState();
        if (state2 == 1) {
            state = FoldingFeature.State.f54326c;
        } else {
            if (state2 != 2) {
                return null;
            }
            state = FoldingFeature.State.f54327d;
        }
        Rect bounds = oemFeature.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "oemFeature.bounds");
        if (!d(windowMetrics, new Bounds(bounds))) {
            return null;
        }
        Rect bounds2 = oemFeature.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds2, "oemFeature.bounds");
        return new HardwareFoldingFeature(new Bounds(bounds2), typeA, state);
    }

    public final WindowLayoutInfo b(Context context, androidx.window.extensions.layout.WindowLayoutInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            return c(WindowMetricsCalculatorCompat.f54373b.a(context), info);
        }
        if (i3 < 29 || !(context instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
        }
        return c(WindowMetricsCalculatorCompat.f54373b.b((Activity) context), info);
    }

    public final WindowLayoutInfo c(WindowMetrics windowMetrics, androidx.window.extensions.layout.WindowLayoutInfo info) {
        FoldingFeature foldingFeatureA;
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        Intrinsics.checkNotNullParameter(info, "info");
        List<androidx.window.extensions.layout.FoldingFeature> displayFeatures = info.getDisplayFeatures();
        Intrinsics.checkNotNullExpressionValue(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (androidx.window.extensions.layout.FoldingFeature feature : displayFeatures) {
            if (feature instanceof androidx.window.extensions.layout.FoldingFeature) {
                ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = f54389a;
                Intrinsics.checkNotNullExpressionValue(feature, "feature");
                foldingFeatureA = extensionsWindowLayoutInfoAdapter.a(windowMetrics, feature);
            } else {
                foldingFeatureA = null;
            }
            if (foldingFeatureA != null) {
                arrayList.add(foldingFeatureA);
            }
        }
        return new WindowLayoutInfo(arrayList);
    }
}
