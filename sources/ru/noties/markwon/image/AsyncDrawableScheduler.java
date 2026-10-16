package ru.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spanned;
import android.text.style.DynamicDrawableSpan;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ru.noties.markwon.renderer.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AsyncDrawableScheduler {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DrawableCallbackImpl implements Drawable.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextView f147360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Rect f147361b;

        DrawableCallbackImpl(TextView textView, Rect rect) {
            this.f147360a = textView;
            this.f147361b = new Rect(rect);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(final Drawable drawable) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f147360a.post(new Runnable() { // from class: ru.noties.markwon.image.AsyncDrawableScheduler.DrawableCallbackImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DrawableCallbackImpl.this.invalidateDrawable(drawable);
                    }
                });
                return;
            }
            Rect bounds = drawable.getBounds();
            if (this.f147361b.equals(bounds)) {
                this.f147360a.postInvalidate();
                return;
            }
            TextView textView = this.f147360a;
            textView.setText(textView.getText());
            this.f147361b = new Rect(bounds);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            this.f147360a.postDelayed(runnable, j3 - SystemClock.uptimeMillis());
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f147360a.removeCallbacks(runnable);
        }
    }

    private static List a(TextView textView) {
        CharSequence text = textView.getText();
        int length = text != null ? text.length() : 0;
        if (length == 0 || !(text instanceof Spanned)) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(2);
        Spanned spanned = (Spanned) text;
        AsyncDrawableSpan[] asyncDrawableSpanArr = (AsyncDrawableSpan[]) spanned.getSpans(0, length, AsyncDrawableSpan.class);
        if (asyncDrawableSpanArr != null && asyncDrawableSpanArr.length > 0) {
            for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArr) {
                arrayList.add(asyncDrawableSpan.a());
            }
        }
        DynamicDrawableSpan[] dynamicDrawableSpanArr = (DynamicDrawableSpan[]) spanned.getSpans(0, length, DynamicDrawableSpan.class);
        if (dynamicDrawableSpanArr != null && dynamicDrawableSpanArr.length > 0) {
            for (DynamicDrawableSpan dynamicDrawableSpan : dynamicDrawableSpanArr) {
                Drawable drawable = dynamicDrawableSpan.getDrawable();
                if (drawable != null && (drawable instanceof AsyncDrawable)) {
                    arrayList.add((AsyncDrawable) drawable);
                }
            }
        }
        return arrayList.size() == 0 ? Collections.EMPTY_LIST : arrayList;
    }

    public static void b(final TextView textView) {
        List<AsyncDrawable> listA = a(textView);
        if (listA.size() > 0) {
            int i3 = R.id.f147393a;
            if (textView.getTag(i3) == null) {
                View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: ru.noties.markwon.image.AsyncDrawableScheduler.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                        AsyncDrawableScheduler.c(textView);
                        view.removeOnAttachStateChangeListener(this);
                        view.setTag(R.id.f147393a, null);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                    }
                };
                textView.addOnAttachStateChangeListener(onAttachStateChangeListener);
                textView.setTag(i3, onAttachStateChangeListener);
            }
            for (AsyncDrawable asyncDrawable : listA) {
                asyncDrawable.f(new DrawableCallbackImpl(textView, asyncDrawable.getBounds()));
            }
        }
    }

    public static void c(TextView textView) {
        Iterator it = a(textView).iterator();
        while (it.hasNext()) {
            ((AsyncDrawable) it.next()).f(null);
        }
    }
}
