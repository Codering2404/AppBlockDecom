package cz.mobilesoft.coreblock.scene.permission;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.HomeKeyWatcher;
import cz.mobilesoft.coreblock.util.view.ViewHelperExtKt;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class PermissionBaseWizardActivity extends AppCompatActivity implements HomeKeyWatcher.OnKeyPressedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f111788a = CoroutinesHelperExtKt.a(Dispatchers.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ActivityManager f111789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WindowManager f111790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HomeKeyWatcher f111791d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ImageView f111792f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected SwitchMaterial f111793g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f111794h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f111795i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AnimationState f111796j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnimationState implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f111797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f111798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f111799c;

        public AnimationState(float f3, float f4, boolean z2) {
            this.f111797a = f3;
            this.f111798b = f4;
            this.f111799c = z2;
        }

        public final float a() {
            return this.f111797a;
        }

        public final float b() {
            return this.f111798b;
        }

        public final boolean c() {
            return this.f111799c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AnimationState)) {
                return false;
            }
            AnimationState animationState = (AnimationState) obj;
            return Float.compare(this.f111797a, animationState.f111797a) == 0 && Float.compare(this.f111798b, animationState.f111798b) == 0 && this.f111799c == animationState.f111799c;
        }

        public int hashCode() {
            return (((Float.hashCode(this.f111797a) * 31) + Float.hashCode(this.f111798b)) * 31) + Boolean.hashCode(this.f111799c);
        }

        public String toString() {
            return "AnimationState(tapViewX=" + this.f111797a + ", tapViewY=" + this.f111798b + ", isSwitchChecked=" + this.f111799c + ")";
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.PermissionBaseWizardActivity$onCreate$1", f = "PermissionBaseWizardActivity.kt", l = {68}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f111802a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionBaseWizardActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f111802a;
            if (i3 == 0) {
                ResultKt.b(obj);
                this.f111802a = 1;
                if (DelayKt.b(10000L, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            PermissionBaseWizardActivity.this.U();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    private final void T(View view) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2, 262176, 0);
        layoutParams.gravity = 80;
        WindowManager windowManager = this.f111790c;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseWindowManager");
            windowManager = null;
        }
        windowManager.addView(view, layoutParams);
    }

    public final void U() {
        if (isFinishing()) {
            return;
        }
        finish();
        overridePendingTransition(0, 0);
    }

    protected final int V() {
        return this.f111794h;
    }

    protected final SwitchMaterial W() {
        SwitchMaterial switchMaterial = this.f111793g;
        if (switchMaterial != null) {
            return switchMaterial;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hintSwitch");
        return null;
    }

    protected final ImageView X() {
        ImageView imageView = this.f111792f;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tapImageView");
        return null;
    }

    protected final ComponentName Y() {
        try {
            ActivityManager activityManager = this.f111789b;
            if (activityManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityManager");
                activityManager = null;
            }
            return activityManager.getAppTasks().get(0).getTaskInfo().topActivity;
        } catch (NoSuchFieldError e3) {
            e3.printStackTrace();
            U();
            return null;
        }
    }

    protected final FrameLayout Z() {
        return new PermissionBaseWizardActivity$getWrapper$1(this);
    }

    public abstract void a0();

    protected final int b0() {
        try {
            ActivityManager activityManager = this.f111789b;
            if (activityManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityManager");
                activityManager = null;
            }
            return activityManager.getAppTasks().get(0).getTaskInfo().numActivities;
        } catch (NoSuchFieldError e3) {
            e3.printStackTrace();
            U();
            return 0;
        }
    }

    protected final void c0(SwitchMaterial switchMaterial) {
        Intrinsics.checkNotNullParameter(switchMaterial, "<set-?>");
        this.f111793g = switchMaterial;
    }

    protected final void d0(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.f111792f = imageView;
    }

    protected final void f0(View view) {
        this.f111795i = view;
    }

    public abstract void g0(View view, AnimationState animationState);

    public abstract void h0();

    @Override // cz.mobilesoft.coreblock.util.permissions.HomeKeyWatcher.OnKeyPressedListener
    public void m() {
        U();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(new FrameLayout(this));
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f111790c = (WindowManager) systemService;
        Object systemService2 = getSystemService("activity");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
        this.f111789b = (ActivityManager) systemService2;
        HomeKeyWatcher homeKeyWatcher = new HomeKeyWatcher(this, this);
        this.f111791d = homeKeyWatcher;
        homeKeyWatcher.b();
        overridePendingTransition(0, 0);
        this.f111794h = b0();
        getWindow().setFlags(528, 528);
        ViewHelperExtKt.g(this);
        BuildersKt__Builders_commonKt.d(this.f111788a, null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        HomeKeyWatcher homeKeyWatcher = this.f111791d;
        if (homeKeyWatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeKeyWatcher");
            homeKeyWatcher = null;
        }
        homeKeyWatcher.c();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        this.f111796j = (AnimationState) intent.getSerializableExtra("STATE");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        WindowManager windowManager = this.f111790c;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseWindowManager");
            windowManager = null;
        }
        windowManager.removeView(this.f111795i);
        this.f111795i = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        a0();
        View view = this.f111795i;
        if (view != null) {
            T(view);
            g0(view, this.f111796j);
        }
    }

    @Override // cz.mobilesoft.coreblock.util.permissions.HomeKeyWatcher.OnKeyPressedListener
    public void q() {
        U();
    }
}
