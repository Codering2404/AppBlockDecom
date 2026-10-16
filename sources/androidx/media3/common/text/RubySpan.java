package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RubySpan implements LanguageFeatureSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f41460c = Util.y0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41461d = Util.y0(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f41463b;

    public RubySpan(String str, int i3) {
        this.f41462a = str;
        this.f41463b = i3;
    }

    public static RubySpan a(Bundle bundle) {
        return new RubySpan((String) Assertions.e(bundle.getString(f41460c)), bundle.getInt(f41461d));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f41460c, this.f41462a);
        bundle.putInt(f41461d, this.f41463b);
        return bundle;
    }
}
