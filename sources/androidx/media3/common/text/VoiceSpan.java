package androidx.media3.common.text;

import android.os.Bundle;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class VoiceSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f41470b = Util.y0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41471a;

    public VoiceSpan(String str) {
        this.f41471a = str;
    }

    public static VoiceSpan a(Bundle bundle) {
        return new VoiceSpan((String) Assertions.e(bundle.getString(f41470b)));
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        bundle.putString(f41470b, this.f41471a);
        return bundle;
    }
}
