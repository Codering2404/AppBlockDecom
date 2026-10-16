package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class EmojiEditableFactory extends Editable.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f36998a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f36999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Class f37000c;

    private EmojiEditableFactory() {
        try {
            f37000c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, EmojiEditableFactory.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f36999b == null) {
            synchronized (f36998a) {
                try {
                    if (f36999b == null) {
                        f36999b = new EmojiEditableFactory();
                    }
                } finally {
                }
            }
        }
        return f36999b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = f37000c;
        return cls != null ? SpannableBuilder.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
