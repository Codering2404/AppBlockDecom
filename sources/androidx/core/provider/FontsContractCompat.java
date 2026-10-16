package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.c;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FontsContractCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Columns implements BaseColumns {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FontInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f34218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f34219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f34221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f34222e;

        public FontInfo(Uri uri, int i3, int i4, boolean z2, int i5) {
            this.f34218a = (Uri) Preconditions.h(uri);
            this.f34219b = i3;
            this.f34220c = i4;
            this.f34221d = z2;
            this.f34222e = i5;
        }

        static FontInfo a(Uri uri, int i3, int i4, boolean z2, int i5) {
            return new FontInfo(uri, i3, i4, z2, i5);
        }

        public int b() {
            return this.f34222e;
        }

        public int c() {
            return this.f34219b;
        }

        public Uri d() {
            return this.f34218a;
        }

        public int e() {
            return this.f34220c;
        }

        public boolean f() {
            return this.f34221d;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.b(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult b(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        return FontProvider.e(context, c.a(new Object[]{fontRequest}), cancellationSignal);
    }

    public static Typeface c(Context context, FontRequest fontRequest, int i3, boolean z2, int i4, Handler handler, FontRequestCallback fontRequestCallback) {
        return d(context, c.a(new Object[]{fontRequest}), i3, z2, i4, handler, fontRequestCallback);
    }

    public static Typeface d(Context context, List list, int i3, boolean z2, int i4, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(fontRequestCallback, RequestExecutor.b(handler));
        if (!z2) {
            return FontRequestWorker.d(context, list, i3, null, callbackWrapper);
        }
        if (list.size() <= 1) {
            return FontRequestWorker.e(context, (FontRequest) list.get(0), callbackWrapper, i3, i4);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FontFamilyResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f34217b;

        public FontFamilyResult(int i3, FontInfo[] fontInfoArr) {
            this.f34216a = i3;
            this.f34217b = Collections.singletonList(fontInfoArr);
        }

        static FontFamilyResult a(int i3, List list) {
            return new FontFamilyResult(i3, list);
        }

        static FontFamilyResult b(int i3, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i3, fontInfoArr);
        }

        public FontInfo[] c() {
            return (FontInfo[]) this.f34217b.get(0);
        }

        public List d() {
            return this.f34217b;
        }

        public int e() {
            return this.f34216a;
        }

        boolean f() {
            return this.f34217b.size() > 1;
        }

        FontFamilyResult(int i3, List list) {
            this.f34216a = i3;
            this.f34217b = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FontRequestCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface FontRequestFailReason {
        }

        public void a(int i3) {
        }

        public void b(Typeface typeface) {
        }
    }
}
