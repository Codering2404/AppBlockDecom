package com.google.android.material.motion;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialBackOrchestrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BackCallbackDelegate f81339a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaterialBackHandler f81340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f81341c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api33BackCallbackDelegate implements BackCallbackDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private OnBackInvokedCallback f81342a;

        private Api33BackCallbackDelegate() {
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void a(View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f81342a);
            this.f81342a = null;
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.BackCallbackDelegate
        public void b(MaterialBackHandler materialBackHandler, View view, boolean z2) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f81342a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(materialBackHandler);
                this.f81342a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z2 ? 1000000 : 0, onBackInvokedCallbackC);
            }
        }

        OnBackInvokedCallback c(final MaterialBackHandler materialBackHandler) {
            Objects.requireNonNull(materialBackHandler);
            return new OnBackInvokedCallback() { // from class: com.google.android.material.motion.b
                public final void onBackInvoked() {
                    materialBackHandler.f();
                }
            };
        }

        boolean d() {
            return this.f81342a != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api34BackCallbackDelegate extends Api33BackCallbackDelegate {
        private Api34BackCallbackDelegate() {
            super();
        }

        @Override // com.google.android.material.motion.MaterialBackOrchestrator.Api33BackCallbackDelegate
        OnBackInvokedCallback c(final MaterialBackHandler materialBackHandler) {
            return new OnBackAnimationCallback() { // from class: com.google.android.material.motion.MaterialBackOrchestrator.Api34BackCallbackDelegate.1
                public void onBackCancelled() {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.a();
                    }
                }

                public void onBackInvoked() {
                    materialBackHandler.f();
                }

                public void onBackProgressed(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.e(new BackEventCompat(backEvent));
                    }
                }

                public void onBackStarted(BackEvent backEvent) {
                    if (Api34BackCallbackDelegate.this.d()) {
                        materialBackHandler.d(new BackEventCompat(backEvent));
                    }
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface BackCallbackDelegate {
        void a(View view);

        void b(MaterialBackHandler materialBackHandler, View view, boolean z2);
    }

    public MaterialBackOrchestrator(MaterialBackHandler materialBackHandler, View view) {
        this.f81340b = materialBackHandler;
        this.f81341c = view;
    }

    private static BackCallbackDelegate a() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            return new Api34BackCallbackDelegate();
        }
        if (i3 >= 33) {
            return new Api33BackCallbackDelegate();
        }
        return null;
    }

    private void d(boolean z2) {
        BackCallbackDelegate backCallbackDelegate = this.f81339a;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.b(this.f81340b, this.f81341c, z2);
        }
    }

    public boolean b() {
        return this.f81339a != null;
    }

    public void c() {
        d(false);
    }

    public void e() {
        d(true);
    }

    public void f() {
        BackCallbackDelegate backCallbackDelegate = this.f81339a;
        if (backCallbackDelegate != null) {
            backCallbackDelegate.a(this.f81341c);
        }
    }
}
