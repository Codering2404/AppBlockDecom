package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TextEmphasisSpan implements LanguageFeatureSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41464d = Util.y0(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f41465e = Util.y0(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f41466f = Util.y0(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41469c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkFill {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MarkShape {
    }

    public TextEmphasisSpan(int i3, int i4, int i5) {
        this.f41467a = i3;
        this.f41468b = i4;
        this.f41469c = i5;
    }

    public static TextEmphasisSpan a(Bundle bundle) {
        return new TextEmphasisSpan(bundle.getInt(f41464d), bundle.getInt(f41465e), bundle.getInt(f41466f));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putInt(f41464d, this.f41467a);
        bundle.putInt(f41465e, this.f41468b);
        bundle.putInt(f41466f, this.f41469c);
        return bundle;
    }
}
