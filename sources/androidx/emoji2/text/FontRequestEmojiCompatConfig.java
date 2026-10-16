package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final FontProviderHelper f36908k = new FontProviderHelper();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f36909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f36910b;

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long a() {
            if (this.f36910b == 0) {
                this.f36910b = SystemClock.uptimeMillis();
                return 0L;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f36910b;
            if (jUptimeMillis > this.f36909a) {
                return -1L;
            }
            return Math.min(Math.max(jUptimeMillis, 1000L), this.f36909a - jUptimeMillis);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FontProviderHelper {
        public Typeface a(Context context, FontsContractCompat.FontInfo fontInfo) {
            return FontsContractCompat.a(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public FontsContractCompat.FontFamilyResult b(Context context, FontRequest fontRequest) {
            return FontsContractCompat.b(context, null, fontRequest);
        }

        public void c(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FontRequest f36912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FontProviderHelper f36913c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f36914d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handler f36915e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Executor f36916f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f36917g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private RetryPolicy f36918h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        EmojiCompat.MetadataRepoLoaderCallback f36919i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private ContentObserver f36920j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Runnable f36921k;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.i(context, "Context cannot be null");
            Preconditions.i(fontRequest, "FontRequest cannot be null");
            this.f36911a = context.getApplicationContext();
            this.f36912b = fontRequest;
            this.f36913c = fontProviderHelper;
        }

        private void b() {
            synchronized (this.f36914d) {
                try {
                    this.f36919i = null;
                    ContentObserver contentObserver = this.f36920j;
                    if (contentObserver != null) {
                        this.f36913c.d(this.f36911a, contentObserver);
                        this.f36920j = null;
                    }
                    Handler handler = this.f36915e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f36921k);
                    }
                    this.f36915e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f36917g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f36916f = null;
                    this.f36917g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private FontsContractCompat.FontInfo e() {
            try {
                FontsContractCompat.FontFamilyResult fontFamilyResultB = this.f36913c.b(this.f36911a, this.f36912b);
                if (fontFamilyResultB.e() == 0) {
                    FontsContractCompat.FontInfo[] fontInfoArrC = fontFamilyResultB.c();
                    if (fontInfoArrC == null || fontInfoArrC.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return fontInfoArrC[0];
                }
                throw new RuntimeException("fetchFonts failed (" + fontFamilyResultB.e() + ")");
            } catch (PackageManager.NameNotFoundException e3) {
                throw new RuntimeException("provider not found", e3);
            }
        }

        private void f(Uri uri, long j3) {
            synchronized (this.f36914d) {
                try {
                    Handler handlerC = this.f36915e;
                    if (handlerC == null) {
                        handlerC = ConcurrencyHelpers.c();
                        this.f36915e = handlerC;
                    }
                    if (this.f36920j == null) {
                        ContentObserver contentObserver = new ContentObserver(handlerC) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                            @Override // android.database.ContentObserver
                            public void onChange(boolean z2, Uri uri2) {
                                FontRequestMetadataLoader.this.d();
                            }
                        };
                        this.f36920j = contentObserver;
                        this.f36913c.c(this.f36911a, uri, contentObserver);
                    }
                    if (this.f36921k == null) {
                        this.f36921k = new Runnable() { // from class: androidx.emoji2.text.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f36953a.d();
                            }
                        };
                    }
                    handlerC.postDelayed(this.f36921k, j3);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.i(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.f36914d) {
                this.f36919i = metadataRepoLoaderCallback;
            }
            d();
        }

        void c() {
            synchronized (this.f36914d) {
                try {
                    if (this.f36919i == null) {
                        return;
                    }
                    try {
                        FontsContractCompat.FontInfo fontInfoE = e();
                        int iB = fontInfoE.b();
                        if (iB == 2) {
                            synchronized (this.f36914d) {
                                try {
                                    RetryPolicy retryPolicy = this.f36918h;
                                    if (retryPolicy != null) {
                                        long jA = retryPolicy.a();
                                        if (jA >= 0) {
                                            f(fontInfoE.d(), jA);
                                            return;
                                        }
                                    }
                                } finally {
                                }
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            TraceCompat.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f36913c.a(this.f36911a, fontInfoE);
                            ByteBuffer byteBufferF = TypefaceCompatUtil.f(this.f36911a, null, fontInfoE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            MetadataRepo metadataRepoB = MetadataRepo.b(typefaceA, byteBufferF);
                            TraceCompat.b();
                            synchronized (this.f36914d) {
                                try {
                                    EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = this.f36919i;
                                    if (metadataRepoLoaderCallback != null) {
                                        metadataRepoLoaderCallback.b(metadataRepoB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            TraceCompat.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.f36914d) {
                            try {
                                EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = this.f36919i;
                                if (metadataRepoLoaderCallback2 != null) {
                                    metadataRepoLoaderCallback2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.f36914d) {
                try {
                    if (this.f36919i == null) {
                        return;
                    }
                    if (this.f36916f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = ConcurrencyHelpers.b("emojiCompat");
                        this.f36917g = threadPoolExecutorB;
                        this.f36916f = threadPoolExecutorB;
                    }
                    this.f36916f.execute(new Runnable() { // from class: androidx.emoji2.text.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f36952a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g(Executor executor) {
            synchronized (this.f36914d) {
                this.f36916f = executor;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class RetryPolicy {
        public abstract long a();
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, f36908k));
    }

    public FontRequestEmojiCompatConfig c(Executor executor) {
        ((FontRequestMetadataLoader) a()).g(executor);
        return this;
    }
}
