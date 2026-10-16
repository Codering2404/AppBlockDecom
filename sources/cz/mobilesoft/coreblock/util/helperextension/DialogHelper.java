package cz.mobilesoft.coreblock.util.helperextension;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ProductHelper;
import cz.mobilesoft.coreblock.util.notifications.NotificationChannelHelper;
import cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class DialogHelper {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnDialogClosedListener {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnInputListener<T> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProfileDeletedCallback {
    }

    public static /* synthetic */ void a(WeakReference weakReference, DialogInterface dialogInterface, int i3) {
        Activity activity = (Activity) weakReference.get();
        if (activity == null) {
            return;
        }
        NotificationChannelHelper.c(activity);
    }

    public static /* synthetic */ void b(OnDialogClosedListener onDialogClosedListener, DialogInterface dialogInterface, int i3) {
        if (onDialogClosedListener != null) {
            onDialogClosedListener.b();
        }
    }

    public static /* synthetic */ void c(OnDialogClosedListener onDialogClosedListener, DialogInterface dialogInterface, int i3) {
        if (onDialogClosedListener != null) {
            onDialogClosedListener.a();
        }
    }

    public static /* synthetic */ void d(OnDialogClosedListener onDialogClosedListener, DialogInterface dialogInterface, int i3) {
        if (onDialogClosedListener != null) {
            onDialogClosedListener.b();
        }
    }

    public static /* synthetic */ void e(OnDialogClosedListener onDialogClosedListener, DialogInterface dialogInterface, int i3) {
        if (onDialogClosedListener != null) {
            onDialogClosedListener.a();
        }
    }

    public static void f(Dialog dialog) {
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) dialog.getContext()).getBaseContext();
        if (!(baseContext instanceof Activity)) {
            g(dialog);
            return;
        }
        Activity activity = (Activity) baseContext;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        g(dialog);
    }

    private static void g(Dialog dialog) {
        try {
            dialog.dismiss();
        } catch (IllegalArgumentException unused) {
        }
    }

    public static void h(final AppCompatActivity appCompatActivity, final DialogInterface.OnClickListener onClickListener) {
        PrefManager.f126839a.U1();
        InfoDialogFragment.f132708b.b(appCompatActivity.getSupportFragmentManager(), new InfoDialogFragment.InfoDialogSetupDTO(appCompatActivity.getString(R.string.XE), appCompatActivity.getString(R.string.f95817m), Integer.valueOf(R.string.GE), Integer.valueOf(R.string.kl), true), new InfoDialogFragment.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.DialogHelper.2
            @Override // cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment.OnDialogClosedListener
            public void a(int i3, boolean z2) {
                if (i3 == -1) {
                    onClickListener.onClick(null, i3);
                }
                if (z2) {
                    PrefManager.f126839a.A2(false);
                }
            }

            @Override // cz.mobilesoft.coreblock.view.dialog.InfoDialogFragment.OnDialogClosedListener
            public LifecycleOwner b() {
                return appCompatActivity;
            }
        });
    }

    public static void i(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        int i3 = R.string.Dq;
        int i4 = R.string.f95790f1;
        new MaterialAlertDialogBuilder(activity).t(activity.getString(R.string.Fq, activity.getString(i4))).h(StringHelper.h(activity.getString(i3, activity.getString(i4)))).L(R.string.Eq, onClickListener).G(android.R.string.cancel, onClickListener2).d(false).v();
    }

    public static void j(Activity activity, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        new MaterialAlertDialogBuilder(activity).P(R.string.Ob).h(activity.getString(R.string.Nb)).L(android.R.string.yes, onClickListener).G(android.R.string.no, onClickListener2).v();
    }

    public static void k(Activity activity, String str, final OnDialogClosedListener onDialogClosedListener) {
        new MaterialAlertDialogBuilder(activity).h(str).L(R.string.NE, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelper.e(onDialogClosedListener, dialogInterface, i3);
            }
        }).G(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelper.b(onDialogClosedListener, dialogInterface, i3);
            }
        }).v();
    }

    public static void l(Activity activity, boolean z2, DialogInterface.OnClickListener onClickListener) {
        final WeakReference weakReference = new WeakReference(activity);
        MaterialAlertDialogBuilder materialAlertDialogBuilderH = new MaterialAlertDialogBuilder(activity).h(activity.getString(R.string.Xb, activity.getString(R.string.fA)));
        if (onClickListener == null) {
            onClickListener = new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.i
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    DialogHelper.a(weakReference, dialogInterface, i3);
                }
            };
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilderL = materialAlertDialogBuilderH.L(android.R.string.ok, onClickListener);
        if (z2) {
            materialAlertDialogBuilderL.G(android.R.string.cancel, null);
        }
        materialAlertDialogBuilderL.v();
    }

    public static void m(Activity activity, DialogInterface.OnClickListener onClickListener) {
        new MaterialAlertDialogBuilder(activity).h(activity.getString(R.string.wl)).L(android.R.string.ok, onClickListener).v();
    }

    public static boolean n(Activity activity, int i3, Product product, PremiumFeature premiumFeature) {
        if (premiumFeature.getLimit() != null) {
            premiumFeature.getLimit().getLimitValue();
            return true;
        }
        ProductHelper.a(product);
        return true;
    }

    public static void o(Activity activity) {
        new MaterialAlertDialogBuilder(activity).P(R.string.dr).h(StringHelper.h(activity.getString(R.string.cr, activity.getString(R.string.f95790f1)))).L(android.R.string.ok, null).v();
    }

    public static void p(Activity activity, CharSequence charSequence, final OnDialogClosedListener onDialogClosedListener) {
        new MaterialAlertDialogBuilder(activity).h(charSequence).L(R.string.Nl, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelper.c(onDialogClosedListener, dialogInterface, i3);
            }
        }).G(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: cz.mobilesoft.coreblock.util.helperextension.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DialogHelper.d(onDialogClosedListener, dialogInterface, i3);
            }
        }).v();
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.helperextension.DialogHelper$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f128518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f128519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AlertDialog f128520c;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f128520c.j(-1).setEnabled((this.f128518a && editable.toString().isEmpty()) || (editable.toString().length() > 0 && (this.f128519b || WebsiteProfileRelation.f126514h.a(editable.toString()))));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }
}
