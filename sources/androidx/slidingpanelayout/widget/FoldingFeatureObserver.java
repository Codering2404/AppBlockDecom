package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FoldingFeatureObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowInfoTracker f53105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f53106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Job f53107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private OnFoldingFeatureChangeListener f53108d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnFoldingFeatureChangeListener {
        void a(FoldingFeature foldingFeature);
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker, Executor executor) {
        Intrinsics.checkNotNullParameter(windowInfoTracker, "windowInfoTracker");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f53105a = windowInfoTracker;
        this.f53106b = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FoldingFeature d(WindowLayoutInfo windowLayoutInfo) {
        Object next;
        Iterator it = windowLayoutInfo.a().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplayFeature) next) instanceof FoldingFeature) {
                break;
            }
        }
        if (next instanceof FoldingFeature) {
            return (FoldingFeature) next;
        }
        return null;
    }

    public final void e(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Job job = this.f53107c;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f53107c = BuildersKt__Builders_commonKt.d(CoroutineScopeKt.a(ExecutorsKt.b(this.f53106b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, null), 3, null);
    }

    public final void f(OnFoldingFeatureChangeListener onFoldingFeatureChangeListener) {
        Intrinsics.checkNotNullParameter(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        this.f53108d = onFoldingFeatureChangeListener;
    }

    public final void g() {
        Job job = this.f53107c;
        if (job == null) {
            return;
        }
        Job.DefaultImpls.b(job, null, 1, null);
    }
}
