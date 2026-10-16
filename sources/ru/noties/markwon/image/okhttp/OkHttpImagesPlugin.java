package ru.noties.markwon.image.okhttp;

import java.util.Arrays;
import okhttp3.OkHttpClient;
import ru.noties.markwon.AbstractMarkwonPlugin;
import ru.noties.markwon.image.AsyncDrawableLoader;
import ru.noties.markwon.image.ImagesPlugin;
import ru.noties.markwon.priority.Priority;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class OkHttpImagesPlugin extends AbstractMarkwonPlugin {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f147387a;

    OkHttpImagesPlugin(OkHttpClient okHttpClient) {
        this.f147387a = okHttpClient;
    }

    public static OkHttpImagesPlugin a() {
        return new OkHttpImagesPlugin(new OkHttpClient());
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public void configureImages(AsyncDrawableLoader.Builder builder) {
        builder.b(Arrays.asList("http", "https"), new OkHttpSchemeHandler(this.f147387a));
    }

    @Override // ru.noties.markwon.AbstractMarkwonPlugin, ru.noties.markwon.MarkwonPlugin
    public Priority priority() {
        return Priority.b(ImagesPlugin.class);
    }
}
