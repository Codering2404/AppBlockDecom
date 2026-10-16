package androidx.browser.browseractions;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.browser.R;
import androidx.core.content.res.ResourcesCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
class BrowserActionsFallbackMenuAdapter extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f2553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f2554b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ViewHolderItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImageView f2560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TextView f2561b;

        ViewHolderItem(ImageView imageView, TextView textView) {
            this.f2560a = imageView;
            this.f2561b = textView;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2553a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f2553a.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        final ViewHolderItem viewHolderItem;
        BrowserActionItem browserActionItem = (BrowserActionItem) this.f2553a.get(i3);
        if (view == null) {
            view = LayoutInflater.from(this.f2554b).inflate(R.layout.f2546a, (ViewGroup) null);
            ImageView imageView = (ImageView) view.findViewById(R.id.f2544a);
            TextView textView = (TextView) view.findViewById(R.id.f2545b);
            if (imageView == null || textView == null) {
                throw new IllegalStateException("Browser Actions fallback UI does not contain necessary Views.");
            }
            viewHolderItem = new ViewHolderItem(imageView, textView);
            view.setTag(viewHolderItem);
        } else {
            viewHolderItem = (ViewHolderItem) view.getTag();
        }
        final String strE = browserActionItem.e();
        viewHolderItem.f2561b.setText(strE);
        if (browserActionItem.b() != 0) {
            viewHolderItem.f2560a.setImageDrawable(ResourcesCompat.f(this.f2554b.getResources(), browserActionItem.b(), null));
            return view;
        }
        if (browserActionItem.c() != null) {
            final ListenableFuture listenableFutureL = BrowserServiceFileProvider.l(this.f2554b.getContentResolver(), browserActionItem.c());
            listenableFutureL.addListener(new Runnable() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    if (TextUtils.equals(strE, viewHolderItem.f2561b.getText())) {
                        try {
                            bitmap = (Bitmap) listenableFutureL.get();
                        } catch (InterruptedException | ExecutionException unused) {
                            bitmap = null;
                        }
                        if (bitmap != null) {
                            viewHolderItem.f2560a.setVisibility(0);
                            viewHolderItem.f2560a.setImageBitmap(bitmap);
                        } else {
                            viewHolderItem.f2560a.setVisibility(4);
                            viewHolderItem.f2560a.setImageBitmap(null);
                        }
                    }
                }
            }, new Executor() { // from class: androidx.browser.browseractions.BrowserActionsFallbackMenuAdapter.2
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    runnable.run();
                }
            });
            return view;
        }
        viewHolderItem.f2560a.setImageBitmap(null);
        viewHolderItem.f2560a.setVisibility(4);
        return view;
    }
}
