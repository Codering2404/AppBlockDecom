package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.browser.R;
import androidx.core.widget.TextViewCompat;
import com.google.android.gms.common.api.Api;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class BrowserActionsFallbackMenuUi implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f2565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Uri f2566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f2567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    BrowserActionsFallMenuUiListener f2568d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BrowserActionsFallbackMenuDialog f2569f;

    /* JADX INFO: renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BrowserActionsFallbackMenuUi f2570a;

        @Override // java.lang.Runnable
        public void run() {
            ((ClipboardManager) this.f2570a.f2565a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.f2570a.f2566b.toString()));
            Toast.makeText(this.f2570a.f2565a, this.f2570a.f2565a.getString(R.string.f2547a), 0).show();
        }
    }

    /* JADX INFO: renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements DialogInterface.OnShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BrowserActionsFallbackMenuUi f2572b;

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            BrowserActionsFallMenuUiListener browserActionsFallMenuUiListener = this.f2572b.f2568d;
            if (browserActionsFallMenuUiListener == null) {
                Log.e("BrowserActionskMenuUi", "Cannot trigger menu item listener, it is null");
            } else {
                browserActionsFallMenuUiListener.a(this.f2571a);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuUi$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f2573a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextViewCompat.d(this.f2573a) == Integer.MAX_VALUE) {
                this.f2573a.setMaxLines(1);
                this.f2573a.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.f2573a.setMaxLines(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                this.f2573a.setEllipsize(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface BrowserActionsFallMenuUiListener {
        void a(View view);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
        BrowserActionItem browserActionItem = (BrowserActionItem) this.f2567c.get(i3);
        if (browserActionItem.a() != null) {
            try {
                browserActionItem.a().send();
            } catch (PendingIntent.CanceledException e3) {
                Log.e("BrowserActionskMenuUi", "Failed to send custom item action", e3);
            }
        } else if (browserActionItem.d() != null) {
            browserActionItem.d().run();
        }
        BrowserActionsFallbackMenuDialog browserActionsFallbackMenuDialog = this.f2569f;
        if (browserActionsFallbackMenuDialog == null) {
            Log.e("BrowserActionskMenuUi", "Cannot dismiss dialog, it has already been dismissed.");
        } else {
            browserActionsFallbackMenuDialog.dismiss();
        }
    }
}
