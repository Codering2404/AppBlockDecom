package androidx.window.area;

import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.window.area.WindowAreaCapability;
import androidx.window.area.WindowAreaControllerImpl;
import androidx.window.area.WindowAreaInfo;
import androidx.window.area.utils.DeviceUtils;
import androidx.window.core.BuildConfig;
import androidx.window.core.VerificationMode;
import androidx.window.extensions.area.ExtensionWindowAreaPresentation;
import androidx.window.extensions.area.ExtensionWindowAreaStatus;
import androidx.window.extensions.area.WindowAreaComponent;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.layout.WindowMetrics;
import androidx.window.layout.WindowMetricsCalculator;
import java.util.HashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowAreaControllerImpl implements WindowAreaController {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f54050g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f54051h = Reflection.b(WindowAreaControllerImpl.class).m();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowAreaComponent f54052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Consumer f54054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WindowAreaCapability.Status f54055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindowAreaCapability.Status f54056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashMap f54057f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RearDisplayPresentationSessionConsumer implements Consumer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f54058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WindowAreaPresentationSessionCallback f54059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindowAreaComponent f54060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f54061d;

        public RearDisplayPresentationSessionConsumer(Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback, WindowAreaComponent windowAreaComponent) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(windowAreaPresentationSessionCallback, "windowAreaPresentationSessionCallback");
            Intrinsics.checkNotNullParameter(windowAreaComponent, "windowAreaComponent");
            this.f54058a = executor;
            this.f54059b = windowAreaPresentationSessionCallback;
            this.f54060c = windowAreaComponent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, int i4, RearDisplayPresentationSessionConsumer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i3 == 0) {
                this$0.f54059b.a(null);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    this$0.f54059b.c(true);
                    return;
                }
                Log.e(WindowAreaControllerImpl.f54051h, "Invalid session state value received: " + i3);
                return;
            }
            if (i4 == 2) {
                this$0.f54059b.c(false);
                return;
            }
            WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback = this$0.f54059b;
            WindowAreaComponent windowAreaComponent = this$0.f54060c;
            ExtensionWindowAreaPresentation rearDisplayPresentation = windowAreaComponent.getRearDisplayPresentation();
            Intrinsics.checkNotNull(rearDisplayPresentation);
            windowAreaPresentationSessionCallback.b(new RearDisplayPresentationSessionPresenterImpl(windowAreaComponent, rearDisplayPresentation));
        }

        @Override // androidx.window.extensions.core.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            b(num.intValue());
        }

        public void b(final int i3) {
            final int i4 = this.f54061d;
            this.f54061d = i3;
            this.f54058a.execute(new Runnable() { // from class: androidx.window.area.b
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplayPresentationSessionConsumer.c(i3, i4, this);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RearDisplaySessionConsumer implements Consumer<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Executor f54062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WindowAreaSessionCallback f54063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WindowAreaComponent f54064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private WindowAreaSession f54065d;

        public RearDisplaySessionConsumer(Executor executor, WindowAreaSessionCallback appCallback, WindowAreaComponent extensionsComponent) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            Intrinsics.checkNotNullParameter(appCallback, "appCallback");
            Intrinsics.checkNotNullParameter(extensionsComponent, "extensionsComponent");
            this.f54062a = executor;
            this.f54063b = appCallback;
            this.f54064c = extensionsComponent;
        }

        private final void d() {
            this.f54065d = null;
            this.f54062a.execute(new Runnable() { // from class: androidx.window.area.d
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplaySessionConsumer.e(this.f54095a);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(RearDisplaySessionConsumer this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f54063b.a(null);
        }

        private final void f() {
            final RearDisplaySessionImpl rearDisplaySessionImpl = new RearDisplaySessionImpl(this.f54064c);
            this.f54065d = rearDisplaySessionImpl;
            this.f54062a.execute(new Runnable() { // from class: androidx.window.area.c
                @Override // java.lang.Runnable
                public final void run() {
                    WindowAreaControllerImpl.RearDisplaySessionConsumer.g(this.f54093a, rearDisplaySessionImpl);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(RearDisplaySessionConsumer this$0, WindowAreaSession it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.f54063b.b(it);
        }

        @Override // androidx.window.extensions.core.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(Integer num) {
            c(num.intValue());
        }

        public void c(int i3) {
            if (i3 == 0) {
                d();
                return;
            }
            if (i3 == 1) {
                f();
                return;
            }
            if (BuildConfig.f54113a.a() == VerificationMode.STRICT) {
                Log.d(WindowAreaControllerImpl.f54051h, "Received an unknown session status value: " + i3);
            }
            d();
        }
    }

    private final boolean j(WindowAreaInfo windowAreaInfo) {
        for (Object obj : windowAreaInfo.a().values()) {
            Intrinsics.checkNotNullExpressionValue(obj, "windowAreaInfo.capabilityMap.values");
            if (!Intrinsics.areEqual(((WindowAreaCapability) obj).a(), WindowAreaCapability.Status.f54042d)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, Executor executor, WindowAreaSessionCallback windowAreaSessionCallback) {
        if (Intrinsics.areEqual(this.f54055d, WindowAreaCapability.Status.f54045g)) {
            windowAreaSessionCallback.a(new IllegalStateException("The WindowArea feature is currently active, WindowAreaInfo#getActiveSessioncan be used to get an instance of the current active session"));
        } else {
            if (!Intrinsics.areEqual(this.f54055d, WindowAreaCapability.Status.f54044f)) {
                windowAreaSessionCallback.a(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
                return;
            }
            RearDisplaySessionConsumer rearDisplaySessionConsumer = new RearDisplaySessionConsumer(executor, windowAreaSessionCallback, this.f54052a);
            this.f54054c = rearDisplaySessionConsumer;
            this.f54052a.startRearDisplaySession(activity, rearDisplaySessionConsumer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Activity activity, Executor executor, WindowAreaPresentationSessionCallback windowAreaPresentationSessionCallback) {
        if (!Intrinsics.areEqual(this.f54056e, WindowAreaCapability.Status.f54044f)) {
            windowAreaPresentationSessionCallback.a(new IllegalStateException("The WindowArea feature is currently not available to be entered"));
        } else {
            WindowAreaComponent windowAreaComponent = this.f54052a;
            windowAreaComponent.startRearDisplayPresentationSession(activity, new RearDisplayPresentationSessionConsumer(executor, windowAreaPresentationSessionCallback, windowAreaComponent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(int i3) {
        WindowMetrics windowMetricsA;
        if (this.f54053b >= 3) {
            WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.f54368a;
            DisplayMetrics rearDisplayMetrics = this.f54052a.getRearDisplayMetrics();
            Intrinsics.checkNotNullExpressionValue(rearDisplayMetrics, "windowAreaComponent.rearDisplayMetrics");
            windowMetricsA = companion.a(rearDisplayMetrics);
        } else {
            DeviceUtils deviceUtils = DeviceUtils.f54104a;
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            String MODEL = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
            DisplayMetrics displayMetricsA = deviceUtils.a(MANUFACTURER, MODEL);
            if (displayMetricsA == null) {
                throw new IllegalArgumentException("DeviceUtils rear display metrics entry should not be null");
            }
            windowMetricsA = WindowMetricsCalculator.f54368a.a(displayMetricsA);
        }
        WindowAreaCapability.Status statusA = WindowAreaAdapter.f54033a.a(i3);
        this.f54055d = statusA;
        o(WindowAreaCapability.Operation.f54037c, statusA, windowMetricsA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(ExtensionWindowAreaStatus extensionWindowAreaStatus) {
        this.f54056e = WindowAreaAdapter.f54033a.a(extensionWindowAreaStatus.getWindowAreaStatus());
        WindowMetricsCalculator.Companion companion = WindowMetricsCalculator.f54368a;
        DisplayMetrics windowAreaDisplayMetrics = extensionWindowAreaStatus.getWindowAreaDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(windowAreaDisplayMetrics, "extensionWindowAreaStatus.windowAreaDisplayMetrics");
        o(WindowAreaCapability.Operation.f54038d, this.f54056e, companion.a(windowAreaDisplayMetrics));
    }

    private final void o(WindowAreaCapability.Operation operation, WindowAreaCapability.Status status, WindowMetrics windowMetrics) {
        WindowAreaInfo windowAreaInfo = (WindowAreaInfo) this.f54057f.get("WINDOW_AREA_REAR_DISPLAY");
        if (!Intrinsics.areEqual(status, WindowAreaCapability.Status.f54042d)) {
            if (windowAreaInfo == null) {
                windowAreaInfo = new WindowAreaInfo(windowMetrics, WindowAreaInfo.Type.f54088c, a.a("WINDOW_AREA_REAR_DISPLAY"), this.f54052a);
            }
            windowAreaInfo.a().put(operation, new WindowAreaCapability(operation, status));
            windowAreaInfo.b(windowMetrics);
            this.f54057f.put("WINDOW_AREA_REAR_DISPLAY", windowAreaInfo);
            return;
        }
        if (windowAreaInfo != null) {
            if (j(windowAreaInfo)) {
                this.f54057f.remove("WINDOW_AREA_REAR_DISPLAY");
            } else {
                windowAreaInfo.a().put(operation, new WindowAreaCapability(operation, status));
            }
        }
    }

    public Flow i() {
        return FlowKt.f(new WindowAreaControllerImpl$windowAreaInfos$1(this, null));
    }
}
