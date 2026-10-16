package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SpannableBuilder extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f36936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f36937b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class WatcherWrapper implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f36938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f36939b = new AtomicInteger(0);

        WatcherWrapper(Object obj) {
            this.f36938a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof EmojiSpan;
        }

        final void a() {
            this.f36939b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f36938a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f36938a).beforeTextChanged(charSequence, i3, i4, i5);
        }

        final void c() {
            this.f36939b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f36939b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f36938a).onSpanAdded(spannable, obj, i3, i4);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i3, int i4, int i5, int i6) {
            if (this.f36939b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f36938a).onSpanChanged(spannable, obj, i3, i4, i5, i6);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i4) {
            if (this.f36939b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f36938a).onSpanRemoved(spannable, obj, i3, i4);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            ((TextWatcher) this.f36938a).onTextChanged(charSequence, i3, i4, i5);
        }
    }

    SpannableBuilder(Class cls, CharSequence charSequence) {
        super(charSequence);
        this.f36937b = new ArrayList();
        Preconditions.i(cls, "watcherClass cannot be null");
        this.f36936a = cls;
    }

    private void b() {
        for (int i3 = 0; i3 < this.f36937b.size(); i3++) {
            ((WatcherWrapper) this.f36937b.get(i3)).a();
        }
    }

    public static SpannableBuilder c(Class cls, CharSequence charSequence) {
        return new SpannableBuilder(cls, charSequence);
    }

    private void e() {
        for (int i3 = 0; i3 < this.f36937b.size(); i3++) {
            ((WatcherWrapper) this.f36937b.get(i3)).onTextChanged(this, 0, length(), length());
        }
    }

    private WatcherWrapper f(Object obj) {
        for (int i3 = 0; i3 < this.f36937b.size(); i3++) {
            WatcherWrapper watcherWrapper = (WatcherWrapper) this.f36937b.get(i3);
            if (watcherWrapper.f36938a == obj) {
                return watcherWrapper;
            }
        }
        return null;
    }

    private boolean g(Class cls) {
        return this.f36936a == cls;
    }

    private boolean h(Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i3 = 0; i3 < this.f36937b.size(); i3++) {
            ((WatcherWrapper) this.f36937b.get(i3)).c();
        }
    }

    public void a() {
        b();
    }

    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(Object obj) {
        WatcherWrapper watcherWrapperF;
        if (h(obj) && (watcherWrapperF = f(obj)) != null) {
            obj = watcherWrapperF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(Object obj) {
        WatcherWrapper watcherWrapperF;
        if (h(obj) && (watcherWrapperF = f(obj)) != null) {
            obj = watcherWrapperF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(Object obj) {
        WatcherWrapper watcherWrapperF;
        if (h(obj) && (watcherWrapperF = f(obj)) != null) {
            obj = watcherWrapperF;
        }
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        if (!g(cls)) {
            return super.getSpans(i3, i4, cls);
        }
        WatcherWrapper[] watcherWrapperArr = (WatcherWrapper[]) super.getSpans(i3, i4, WatcherWrapper.class);
        Object[] objArr = (Object[]) Array.newInstance((Class<?>) cls, watcherWrapperArr.length);
        for (int i5 = 0; i5 < watcherWrapperArr.length; i5++) {
            objArr[i5] = watcherWrapperArr[i5].f36938a;
        }
        return objArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        if (cls == null || g(cls)) {
            cls = WatcherWrapper.class;
        }
        return super.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(Object obj) {
        WatcherWrapper watcherWrapperF;
        if (h(obj)) {
            watcherWrapperF = f(obj);
            if (watcherWrapperF != null) {
                obj = watcherWrapperF;
            }
        } else {
            watcherWrapperF = null;
        }
        super.removeSpan(obj);
        if (watcherWrapperF != null) {
            this.f36937b.remove(watcherWrapperF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        if (h(obj)) {
            WatcherWrapper watcherWrapper = new WatcherWrapper(obj);
            this.f36937b.add(watcherWrapper);
            obj = watcherWrapper;
        }
        super.setSpan(obj, i3, i4, i5);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return new SpannableBuilder(this.f36936a, this, i3, i4);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder delete(int i3, int i4) {
        super.delete(i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence) {
        super.insert(i3, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence) {
        b();
        super.replace(i3, i4, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder insert(int i3, CharSequence charSequence, int i4, int i5) {
        super.insert(i3, charSequence, i4, i5);
        return this;
    }

    SpannableBuilder(Class cls, CharSequence charSequence, int i3, int i4) {
        super(charSequence, i3, i4);
        this.f36937b = new ArrayList();
        Preconditions.i(cls, "watcherClass cannot be null");
        this.f36936a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i4, CharSequence charSequence, int i5, int i6) {
        b();
        super.replace(i3, i4, charSequence, i5, i6);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(char c3) {
        super.append(c3);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    public SpannableStringBuilder append(CharSequence charSequence, int i3, int i4) {
        super.append(charSequence, i3, i4);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i3) {
        super.append(charSequence, obj, i3);
        return this;
    }
}
