package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.adapter.WindowBackend;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackend;
import androidx.window.layout.adapter.sidecar.SidecarWindowBackend;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface WindowInfoTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f54344a = Companion.f54345a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final boolean f54346b = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f54345a = new Companion();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f54347c = Reflection.b(WindowInfoTracker.class).m();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Lazy f54348d = LazyKt.b(new Function0<WindowBackend>() { // from class: androidx.window.layout.WindowInfoTracker$Companion$extensionBackend$2
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final WindowBackend invoke() {
                WindowLayoutComponent windowLayoutComponentG;
                try {
                    ClassLoader loader = WindowInfoTracker.class.getClassLoader();
                    SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = loader != null ? new SafeWindowLayoutComponentProvider(loader, new ConsumerAdapter(loader)) : null;
                    if (safeWindowLayoutComponentProvider == null || (windowLayoutComponentG = safeWindowLayoutComponentProvider.g()) == null) {
                        return null;
                    }
                    ExtensionWindowBackend.Companion companion = ExtensionWindowBackend.f54377b;
                    Intrinsics.checkNotNullExpressionValue(loader, "loader");
                    return companion.a(windowLayoutComponentG, new ConsumerAdapter(loader));
                } catch (Throwable unused) {
                    if (WindowInfoTracker.Companion.f54346b) {
                        Log.d(WindowInfoTracker.Companion.f54347c, "Failed to load WindowExtensions");
                    }
                    return null;
                }
            }
        });

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static WindowInfoTrackerDecorator f54349e = EmptyDecorator.f54316a;

        private Companion() {
        }

        public final WindowBackend c() {
            return (WindowBackend) f54348d.getValue();
        }

        public final WindowInfoTracker d(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WindowBackend windowBackendC = c();
            if (windowBackendC == null) {
                windowBackendC = SidecarWindowBackend.f54419c.a(context);
            }
            return f54349e.a(new WindowInfoTrackerImpl(WindowMetricsCalculatorCompat.f54373b, windowBackendC));
        }
    }

    static WindowInfoTracker a(Context context) {
        return f54344a.d(context);
    }

    Flow b(Activity activity);

    default Flow c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Activity activity = context instanceof Activity ? (Activity) context : null;
        Flow flowB = activity != null ? b(activity) : null;
        if (flowB != null) {
            return flowB;
        }
        throw new NotImplementedError("Must override windowLayoutInfo(context) and provide an implementation.");
    }
}
