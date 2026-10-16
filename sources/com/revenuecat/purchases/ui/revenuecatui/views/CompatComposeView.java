package com.revenuecat.purchases.ui.revenuecatui.views;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
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
public abstract class CompatComposeView extends AbstractComposeView implements LifecycleOwner, SavedStateRegistryOwner, ViewModelStoreOwner {
    private static final String KEY_SAVED_INSTANCE_STATE = "com.revenuecat.CompatComposeView.saved_instance_state";
    private boolean isManagingLifecycle;
    private boolean isManagingSavedState;
    private boolean isManagingViewModelStore;
    private final CompatComposeView$lifecycleObserver$1 lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final SavedStateRegistry savedStateRegistry;
    private final SavedStateRegistryController savedStateRegistryController;
    private final ViewModelStore viewModelStore;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ViewLifecycleOwner implements LifecycleOwner {
        private final Activity activity;
        private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

        public ViewLifecycleOwner(final Activity activity) {
            this.activity = activity;
            if (activity != null) {
                Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$ViewLifecycleOwner$1$1
                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(Activity activity2, Bundle bundle) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(Activity destroyedActivity) {
                        Intrinsics.checkNotNullParameter(destroyedActivity, "destroyedActivity");
                        if (destroyedActivity == activity) {
                            this.destroy();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(Activity activity2, Bundle outState) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                        Intrinsics.checkNotNullParameter(outState, "outState");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(Activity activity2) {
                        Intrinsics.checkNotNullParameter(activity2, "activity");
                    }
                };
                Application application = activity.getApplication();
                if (application != null) {
                    application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                this.activityLifecycleCallbacks = activityLifecycleCallbacks;
            }
        }

        public final void destroy() {
            Application application;
            if (this.lifecycleRegistry.getCurrentState() == Lifecycle.State.f39947a) {
                return;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
            if (activityLifecycleCallbacks != null) {
                Activity activity = this.activity;
                if (activity != null && (application = activity.getApplication()) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                this.activityLifecycleCallbacks = null;
            }
            if (this.lifecycleRegistry.getCurrentState().b(Lifecycle.State.f39950d)) {
                this.lifecycleRegistry.g(Lifecycle.Event.ON_STOP);
            }
            this.lifecycleRegistry.g(Lifecycle.Event.ON_DESTROY);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.lifecycleRegistry;
        }

        public final void onAttachedToWindow() {
            this.lifecycleRegistry.g(Lifecycle.Event.ON_CREATE);
            this.lifecycleRegistry.g(Lifecycle.Event.ON_START);
        }

        public final void onDetachedFromWindow() {
            destroy();
        }

        public final void onWindowFocusChanged(boolean z2) {
            if (z2) {
                this.lifecycleRegistry.g(Lifecycle.Event.ON_RESUME);
            } else {
                this.lifecycleRegistry.g(Lifecycle.Event.ON_PAUSE);
            }
        }

        public final void onWindowVisibilityChanged(int i3) {
            if (i3 == 0) {
                this.lifecycleRegistry.g(Lifecycle.Event.ON_START);
            } else {
                this.lifecycleRegistry.g(Lifecycle.Event.ON_STOP);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatComposeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void deinitViewTreeOwners() {
        View viewFindWindowRoot;
        if (isManagingViewTree() && (viewFindWindowRoot = findWindowRoot(this)) != null) {
            if (ViewTreeLifecycleOwner.a(viewFindWindowRoot) == this) {
                ViewTreeLifecycleOwner.b(viewFindWindowRoot, null);
            }
            if (ViewTreeSavedStateRegistryOwner.a(viewFindWindowRoot) == this) {
                ViewTreeSavedStateRegistryOwner.b(viewFindWindowRoot, null);
            }
            if (ViewTreeViewModelStoreOwner.a(viewFindWindowRoot) == this) {
                ViewTreeViewModelStoreOwner.b(viewFindWindowRoot, null);
            }
        }
    }

    private final View findWindowRoot(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = null;
        while (parent != null && (parent instanceof ViewGroup)) {
            viewGroup = (ViewGroup) parent;
            parent = viewGroup.getParent();
        }
        return viewGroup;
    }

    private final void initViewTreeOwners() {
        LifecycleOwner viewLifecycleOwner;
        View viewFindWindowRoot = findWindowRoot(this);
        if (viewFindWindowRoot == null) {
            return;
        }
        LifecycleOwner lifecycleOwnerA = ViewTreeLifecycleOwner.a(viewFindWindowRoot);
        if (this.lifecycleOwner == null) {
            if (lifecycleOwnerA == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLifecycleOwner = new ViewLifecycleOwner(ContextExtensionsKt.getActivity(context));
            } else {
                viewLifecycleOwner = lifecycleOwnerA;
            }
            this.lifecycleOwner = viewLifecycleOwner;
            getLifecycle().addObserver(this.lifecycleObserver);
        }
        if (lifecycleOwnerA == null) {
            ViewTreeLifecycleOwner.b(viewFindWindowRoot, this);
            this.isManagingLifecycle = true;
        }
        if (ViewTreeSavedStateRegistryOwner.a(viewFindWindowRoot) == null) {
            ViewTreeSavedStateRegistryOwner.b(viewFindWindowRoot, this);
            this.isManagingSavedState = true;
        }
        if (ViewTreeViewModelStoreOwner.a(viewFindWindowRoot) == null) {
            ViewTreeViewModelStoreOwner.b(viewFindWindowRoot, this);
            this.isManagingViewModelStore = true;
        }
    }

    private final boolean isManagingViewTree() {
        return this.isManagingLifecycle || this.isManagingSavedState || this.isManagingViewModelStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDestroy() {
        Lifecycle lifecycle;
        if (this.isManagingViewModelStore) {
            getViewModelStore().a();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this.lifecycleObserver);
        }
        this.lifecycleOwner = null;
    }

    private final void performRestore(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SAVED_INSTANCE_STATE, parcelable);
        this.savedStateRegistryController.d(bundle);
    }

    private final Bundle performSave(Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_SAVED_INSTANCE_STATE, parcelable);
        this.savedStateRegistryController.e(bundle);
        return bundle;
    }

    protected final void destroy() {
        Logger.INSTANCE.d("CompatComposeView: Destroying lifecycle owner since destroy() was called.");
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.destroy();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!isManagingViewTree()) {
            return super.dispatchKeyEvent(event);
        }
        if (event.getKeyCode() != 4 || event.getAction() != 1) {
            return super.dispatchKeyEvent(event);
        }
        onBackPressed();
        return true;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        return (lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? new Lifecycle() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycle$1
            @Override // androidx.lifecycle.Lifecycle
            public void addObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                Logger.INSTANCE.e("CompatComposeView: Attempted to add a LifecycleObserver when no LifecycleOwner is set.");
            }

            @Override // androidx.lifecycle.Lifecycle
            public Lifecycle.State getCurrentState() {
                return Lifecycle.State.f39948b;
            }

            @Override // androidx.lifecycle.Lifecycle
            public void removeObserver(LifecycleObserver observer) {
                Intrinsics.checkNotNullParameter(observer, "observer");
                Logger.INSTANCE.e("CompatComposeView: Attempted to remove LifecycleObserver when no LifecycleOwner is set.");
            }
        } : lifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.viewModelStore;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycleOwner instanceof ViewLifecycleOwner)) {
            Logger.INSTANCE.w("Attaching a previously-detached view to a window. Resetting state");
            ((ViewLifecycleOwner) lifecycleOwner).destroy();
            onDestroy();
        }
        initViewTreeOwners();
        if (this.isManagingSavedState) {
            this.savedStateRegistryController.c();
            performRestore(null);
        }
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner2 instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner2 : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onAttachedToWindow();
        }
        super.onAttachedToWindow();
    }

    public void onBackPressed() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onDetachedFromWindow();
        }
        deinitViewTreeOwners();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
        if (this.isManagingSavedState) {
            performRestore(parcelable);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (this.isManagingSavedState) {
            performSave(parcelableOnSaveInstanceState);
        }
        return parcelableOnSaveInstanceState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2 && isManagingViewTree()) {
            setFocusableInTouchMode(true);
            setFocusable(true);
            requestFocus();
        }
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onWindowFocusChanged(z2);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        ViewLifecycleOwner viewLifecycleOwner = lifecycleOwner instanceof ViewLifecycleOwner ? (ViewLifecycleOwner) lifecycleOwner : null;
        if (viewLifecycleOwner != null) {
            viewLifecycleOwner.onWindowVisibilityChanged(i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompatComposeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CompatComposeView(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycleObserver$1] */
    public CompatComposeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.lifecycleObserver = new DefaultLifecycleObserver() { // from class: com.revenuecat.purchases.ui.revenuecatui.views.CompatComposeView$lifecycleObserver$1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                super.onCreate(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                this.this$0.onDestroy();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                super.onPause(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                super.onResume(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                super.onStart(lifecycleOwner);
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public /* bridge */ /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                super.onStop(lifecycleOwner);
            }
        };
        SavedStateRegistryController savedStateRegistryControllerB = SavedStateRegistryController.f53001c.b(this);
        this.savedStateRegistryController = savedStateRegistryControllerB;
        this.savedStateRegistry = savedStateRegistryControllerB.b();
        this.viewModelStore = new ViewModelStore();
    }
}
