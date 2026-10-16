package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class InputContentInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputContentInfoCompatImpl f34607a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface InputContentInfoCompatImpl {
        Object a();

        Uri b();

        void c();

        Uri d();

        ClipDescription getDescription();
    }

    public InputContentInfoCompat(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f34607a = new InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
    }

    public static InputContentInfoCompat f(Object obj) {
        if (obj == null) {
            return null;
        }
        return new InputContentInfoCompat(new InputContentInfoCompatApi25Impl(obj));
    }

    public Uri a() {
        return this.f34607a.b();
    }

    public ClipDescription b() {
        return this.f34607a.getDescription();
    }

    public Uri c() {
        return this.f34607a.d();
    }

    public void d() {
        this.f34607a.c();
    }

    public Object e() {
        return this.f34607a.a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputContentInfoCompatApi25Impl implements InputContentInfoCompatImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputContentInfo f34608a;

        InputContentInfoCompatApi25Impl(Object obj) {
            this.f34608a = (InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object a() {
            return this.f34608a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri b() {
            return this.f34608a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void c() {
            this.f34608a.requestPermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri d() {
            return this.f34608a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.f34608a.getDescription();
        }

        InputContentInfoCompatApi25Impl(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f34608a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.f34607a = inputContentInfoCompatImpl;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputContentInfoCompatBaseImpl implements InputContentInfoCompatImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f34609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ClipDescription f34610b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f34611c;

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Object a() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri b() {
            return this.f34609a;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public Uri d() {
            return this.f34611c;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public ClipDescription getDescription() {
            return this.f34610b;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void c() {
        }
    }
}
