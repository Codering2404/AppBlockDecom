package cz.mobilesoft.coreblock.scene.intro;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BlockingTestOverlayService extends Service {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f104462c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f104463d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WindowManager f104464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f104465b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startService(new Intent(context, (Class<?>) BlockingTestOverlayService.class));
        }

        private Companion() {
        }
    }

    private final void b() {
        final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R.style.f95866a);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2038, 40, -3);
        layoutParams.gravity = 8388691;
        layoutParams.x = 0;
        layoutParams.y = 0;
        FrameLayout frameLayout = new FrameLayout(contextThemeWrapper) { // from class: cz.mobilesoft.coreblock.scene.intro.BlockingTestOverlayService$addOverlayView$interceptorLayout$1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() == 0 && event.getKeyCode() == 4) {
                    this.stopSelf();
                }
                return super.dispatchKeyEvent(event);
            }
        };
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        Snackbar snackbarK0 = Snackbar.k0(frameLayout, StringHelper.g(contextThemeWrapper, R.string.s4), 0);
        Intrinsics.checkNotNullExpressionValue(snackbarK0, "make(...)");
        snackbarK0.u(new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: cz.mobilesoft.coreblock.scene.intro.BlockingTestOverlayService$addOverlayView$1
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void a(Snackbar snackbar, int i3) {
                super.a(snackbar, i3);
                this.f104466a.c();
            }
        });
        try {
            d().addView(frameLayout, layoutParams);
            this.f104465b = frameLayout;
            snackbarK0.Y();
        } catch (IllegalStateException unused) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        View view = this.f104465b;
        if (view != null) {
            d().removeView(view);
            this.f104465b = null;
        }
        stopSelf();
    }

    public final WindowManager d() {
        WindowManager windowManager = this.f104464a;
        if (windowManager != null) {
            return windowManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("windowManager");
        return null;
    }

    public final void e(WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(windowManager, "<set-?>");
        this.f104464a = windowManager;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        e((WindowManager) systemService);
        try {
            b();
        } catch (WindowManager.BadTokenException e3) {
            CrashHelper.j(e3);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        return 2;
    }
}
