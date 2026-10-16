package coil.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.EventListener;
import coil.base.R;
import coil.decode.DataSource;
import coil.disk.DiskCache;
import coil.intercept.Interceptor;
import coil.intercept.RealInterceptorChain;
import coil.request.Parameters;
import coil.request.Tags;
import coil.request.ViewTargetRequestManager;
import coil.size.Dimension;
import coil.size.Scale;
import com.google.android.gms.common.api.Api;
import com.sun.jna.Function;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: coil.util.-Utils, reason: invalid class name */
/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Utils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config[] f56215a = {Bitmap.Config.ARGB_8888, Bitmap.Config.RGBA_F16};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config f56216b = Bitmap.Config.HARDWARE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Headers f56217c = new Headers.Builder().f();

    /* JADX INFO: renamed from: coil.util.-Utils$WhenMappings */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f56219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f56220c;

        static {
            int[] iArr = new int[DataSource.values().length];
            try {
                iArr[DataSource.MEMORY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataSource.MEMORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataSource.DISK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataSource.NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f56218a = iArr;
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            try {
                iArr2[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            f56219b = iArr2;
            int[] iArr3 = new int[Scale.values().length];
            try {
                iArr3[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            f56220c = iArr3;
        }
    }

    public static final int A(String str, int i3) {
        Long lW = StringsKt.w(str);
        if (lW == null) {
            return i3;
        }
        long jLongValue = lW.longValue();
        if (jLongValue > 2147483647L) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (jLongValue < 0) {
            return 0;
        }
        return (int) jLongValue;
    }

    public static final int B(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).f56163a;
        }
        int i3 = WhenMappings.f56220c[scale.ordinal()];
        if (i3 == 1) {
            return Integer.MIN_VALUE;
        }
        if (i3 == 2) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void a(DiskCache.Editor editor) {
        try {
            editor.abort();
        } catch (Exception unused) {
        }
    }

    public static final Headers.Builder b(Headers.Builder builder, String str) {
        int iM0 = StringsKt.m0(str, ':', 0, false, 6, null);
        if (iM0 == -1) {
            throw new IllegalArgumentException(("Unexpected header: " + str).toString());
        }
        String strSubstring = str.substring(0, iM0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String string = StringsKt.t1(strSubstring).toString();
        String strSubstring2 = str.substring(iM0 + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        builder.e(string, strSubstring2);
        return builder;
    }

    public static final int c(Context context, double d3) {
        int largeMemoryClass;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            largeMemoryClass = (context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass();
        } catch (Exception unused) {
            largeMemoryClass = Function.MAX_NARGS;
        }
        double d4 = 1024;
        return (int) (d3 * ((double) largeMemoryClass) * d4 * d4);
    }

    public static final void d(Closeable closeable) {
        try {
            closeable.close();
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception unused) {
        }
    }

    public static final double e(Context context) {
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.checkNotNull(systemService);
            return ((ActivityManager) systemService).isLowRamDevice() ? 0.15d : 0.2d;
        } catch (Exception unused) {
            return 0.2d;
        }
    }

    public static final Bitmap.Config f() {
        return f56216b;
    }

    public static final String g(DataSource dataSource) {
        int i3 = WhenMappings.f56218a[dataSource.ordinal()];
        if (i3 == 1 || i3 == 2) {
            return "🧠";
        }
        if (i3 == 3) {
            return "💾";
        }
        if (i3 == 4) {
            return "☁️ ";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final EventListener h(Interceptor.Chain chain) {
        return chain instanceof RealInterceptorChain ? ((RealInterceptorChain) chain).e() : EventListener.f55421b;
    }

    public static final String i(Uri uri) {
        return (String) CollectionsKt.firstOrNull((List) uri.getPathSegments());
    }

    public static final int j(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicHeight() : bitmap.getHeight();
    }

    public static final String k(MimeTypeMap mimeTypeMap, String str) {
        if (str == null || StringsKt.p0(str)) {
            return null;
        }
        return mimeTypeMap.getMimeTypeFromExtension(StringsKt.g1(StringsKt.i1(StringsKt.q1(StringsKt.q1(str, '#', null, 2, null), '?', null, 2, null), '/', null, 2, null), '.', ""));
    }

    public static final int l(Configuration configuration) {
        return configuration.uiMode & 48;
    }

    public static final ViewTargetRequestManager m(View view) {
        ViewTargetRequestManager viewTargetRequestManager;
        int i3 = R.id.f55482a;
        Object tag = view.getTag(i3);
        ViewTargetRequestManager viewTargetRequestManager2 = tag instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag : null;
        if (viewTargetRequestManager2 != null) {
            return viewTargetRequestManager2;
        }
        synchronized (view) {
            try {
                Object tag2 = view.getTag(i3);
                viewTargetRequestManager = tag2 instanceof ViewTargetRequestManager ? (ViewTargetRequestManager) tag2 : null;
                if (viewTargetRequestManager == null) {
                    viewTargetRequestManager = new ViewTargetRequestManager(view);
                    view.addOnAttachStateChangeListener(viewTargetRequestManager);
                    view.setTag(i3, viewTargetRequestManager);
                }
            } finally {
            }
        }
        return viewTargetRequestManager;
    }

    public static final File n(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            throw new IllegalStateException("cacheDir == null");
        }
        cacheDir.mkdirs();
        return cacheDir;
    }

    public static final Scale o(ImageView imageView) {
        ImageView.ScaleType scaleType = imageView.getScaleType();
        int i3 = scaleType == null ? -1 : WhenMappings.f56219b[scaleType.ordinal()];
        return (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) ? Scale.FIT : Scale.FILL;
    }

    public static final Bitmap.Config[] p() {
        return f56215a;
    }

    public static final int q(Drawable drawable) {
        Bitmap bitmap;
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        return (bitmapDrawable == null || (bitmap = bitmapDrawable.getBitmap()) == null) ? drawable.getIntrinsicWidth() : bitmap.getWidth();
    }

    public static final boolean r(Uri uri) {
        return Intrinsics.areEqual(uri.getScheme(), "file") && Intrinsics.areEqual(i(uri), "android_asset");
    }

    public static final boolean s() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    public static final boolean t(int i3) {
        return i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE;
    }

    public static final boolean u(Interceptor.Chain chain) {
        return (chain instanceof RealInterceptorChain) && ((RealInterceptorChain) chain).f();
    }

    public static final boolean v(Drawable drawable) {
        return (drawable instanceof VectorDrawable) || (drawable instanceof VectorDrawableCompat);
    }

    public static final Parameters w(Parameters parameters) {
        return parameters == null ? Parameters.f56131c : parameters;
    }

    public static final Tags x(Tags tags) {
        return tags == null ? Tags.f56147c : tags;
    }

    public static final Headers y(Headers headers) {
        return headers == null ? f56217c : headers;
    }

    public static final ResponseBody z(Response response) {
        ResponseBody responseBodyA = response.a();
        if (responseBodyA != null) {
            return responseBodyA;
        }
        throw new IllegalStateException("response body == null");
    }
}
