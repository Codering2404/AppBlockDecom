package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Option f66955b = Option.e("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66956a;

    public ResourceDrawableDecoder(Context context) {
        this.f66956a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.f66956a.getPackageName())) {
            return this.f66956a;
        }
        try {
            return this.f66956a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e3) {
            if (str.contains(this.f66956a.getPackageName())) {
                return this.f66956a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e3);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e3) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e3);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Resource b(Uri uri, int i3, int i4, Options options) {
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            Context contextD = d(uri, authority);
            int iG = g(contextD, uri);
            Resources.Theme theme = ((String) Preconditions.e(authority)).equals(this.f66956a.getPackageName()) ? (Resources.Theme) options.c(f66955b) : null;
            return NonOwnedDrawableResource.d(theme == null ? DrawableDecoderCompat.b(this.f66956a, contextD, iG) : DrawableDecoderCompat.a(this.f66956a, iG, theme));
        }
        throw new IllegalStateException("Package name for " + uri + " is null or empty");
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, Options options) {
        String scheme = uri.getScheme();
        return scheme != null && scheme.equals("android.resource");
    }
}
