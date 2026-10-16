package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ContentInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Compat f34383a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BuilderCompat f34384a;

        public Builder(ClipData clipData, int i3) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f34384a = new BuilderCompat31Impl(clipData, i3);
            } else {
                this.f34384a = new BuilderCompatImpl(clipData, i3);
            }
        }

        public ContentInfoCompat a() {
            return this.f34384a.build();
        }

        public Builder b(Bundle bundle) {
            this.f34384a.setExtras(bundle);
            return this;
        }

        public Builder c(int i3) {
            this.f34384a.b(i3);
            return this;
        }

        public Builder d(Uri uri) {
            this.f34384a.a(uri);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface BuilderCompat {
        void a(Uri uri);

        void b(int i3);

        ContentInfoCompat build();

        void setExtras(Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BuilderCompat31Impl implements BuilderCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f34385a;

        BuilderCompat31Impl(ClipData clipData, int i3) {
            this.f34385a = f.a(clipData, i3);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void a(Uri uri) {
            this.f34385a.setLinkUri(uri);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void b(int i3) {
            this.f34385a.setFlags(i3);
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new Compat31Impl(this.f34385a.build()));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f34385a.setExtras(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BuilderCompatImpl implements BuilderCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ClipData f34386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f34387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f34388c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Uri f34389d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Bundle f34390e;

        BuilderCompatImpl(ClipData clipData, int i3) {
            this.f34386a = clipData;
            this.f34387b = i3;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void a(Uri uri) {
            this.f34389d = uri;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void b(int i3) {
            this.f34388c = i3;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.f34390e = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Compat {
        int C();

        ClipData a();

        ContentInfo b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Compat31Impl implements Compat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo f34391a;

        Compat31Impl(ContentInfo contentInfo) {
            this.f34391a = a.a(Preconditions.h(contentInfo));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int C() {
            return this.f34391a.getFlags();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData a() {
            return this.f34391a.getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo b() {
            return this.f34391a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int c() {
            return this.f34391a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f34391a + "}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class CompatImpl implements Compat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClipData f34392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f34395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f34396e;

        CompatImpl(BuilderCompatImpl builderCompatImpl) {
            this.f34392a = (ClipData) Preconditions.h(builderCompatImpl.f34386a);
            this.f34393b = Preconditions.d(builderCompatImpl.f34387b, 0, 5, "source");
            this.f34394c = Preconditions.g(builderCompatImpl.f34388c, 1);
            this.f34395d = builderCompatImpl.f34389d;
            this.f34396e = builderCompatImpl.f34390e;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int C() {
            return this.f34394c;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData a() {
            return this.f34392a;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo b() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int c() {
            return this.f34393b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f34392a.getDescription());
            sb.append(", source=");
            sb.append(ContentInfoCompat.e(this.f34393b));
            sb.append(", flags=");
            sb.append(ContentInfoCompat.a(this.f34394c));
            if (this.f34395d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f34395d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.f34396e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    ContentInfoCompat(Compat compat) {
        this.f34383a = compat;
    }

    static String a(int i3) {
        return (i3 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i3);
    }

    static String e(int i3) {
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? String.valueOf(i3) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static ContentInfoCompat g(ContentInfo contentInfo) {
        return new ContentInfoCompat(new Compat31Impl(contentInfo));
    }

    public ClipData b() {
        return this.f34383a.a();
    }

    public int c() {
        return this.f34383a.C();
    }

    public int d() {
        return this.f34383a.c();
    }

    public ContentInfo f() {
        ContentInfo contentInfoB = this.f34383a.b();
        Objects.requireNonNull(contentInfoB);
        return a.a(contentInfoB);
    }

    public String toString() {
        return this.f34383a.toString();
    }
}
