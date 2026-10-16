package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.WindowBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class WindowInfoTrackerImpl implements WindowInfoTracker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WindowMetricsCalculator f54351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WindowBackend f54352c;

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        Intrinsics.checkNotNullParameter(windowMetricsCalculator, "windowMetricsCalculator");
        Intrinsics.checkNotNullParameter(windowBackend, "windowBackend");
        this.f54351b = windowMetricsCalculator;
        this.f54352c = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow b(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return FlowKt.M(FlowKt.f(new WindowInfoTrackerImpl$windowLayoutInfo$2(this, activity, null)), Dispatchers.c());
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public Flow c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowKt.M(FlowKt.f(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, context, null)), Dispatchers.c());
    }
}
