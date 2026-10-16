package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            b(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36880a;

        BackgroundDefaultLoader(Context context) {
            this.f36880a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void a(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            final ThreadPoolExecutor threadPoolExecutorB = ConcurrencyHelpers.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f36949a.c(metadataRepoLoaderCallback, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig fontRequestEmojiCompatConfigA = DefaultEmojiCompatConfig.a(this.f36880a);
                if (fontRequestEmojiCompatConfigA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                fontRequestEmojiCompatConfigA.c(threadPoolExecutor);
                fontRequestEmojiCompatConfigA.a().a(new EmojiCompat.MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void a(Throwable th) {
                        try {
                            metadataRepoLoaderCallback.a(th);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void b(MetadataRepo metadataRepo) {
                        try {
                            metadataRepoLoaderCallback.b(metadataRepo);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }
                });
            } catch (Throwable th) {
                metadataRepoLoaderCallback.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.k()) {
                    EmojiCompat.c().n();
                }
            } finally {
                TraceCompat.b();
            }
        }
    }

    @Override // androidx.startup.Initializer
    public List a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // androidx.startup.Initializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean create(Context context) {
        EmojiCompat.j(new BackgroundDefaultConfig(context));
        c(context);
        return Boolean.TRUE;
    }

    void c(Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onResume(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.d();
                lifecycle.removeObserver(this);
            }
        });
    }

    void d() {
        ConcurrencyHelpers.c().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }
}
