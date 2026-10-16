package androidx.media3.common.text;

import android.os.Bundle;
import android.text.Spannable;
import android.text.Spanned;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CustomSpanBundler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f41455a = Util.y0(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f41456b = Util.y0(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f41457c = Util.y0(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f41458d = Util.y0(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f41459e = Util.y0(4);

    public static ArrayList a(Spanned spanned) {
        ArrayList arrayList = new ArrayList();
        for (RubySpan rubySpan : (RubySpan[]) spanned.getSpans(0, spanned.length(), RubySpan.class)) {
            arrayList.add(b(spanned, rubySpan, 1, rubySpan.b()));
        }
        for (TextEmphasisSpan textEmphasisSpan : (TextEmphasisSpan[]) spanned.getSpans(0, spanned.length(), TextEmphasisSpan.class)) {
            arrayList.add(b(spanned, textEmphasisSpan, 2, textEmphasisSpan.b()));
        }
        for (HorizontalTextInVerticalContextSpan horizontalTextInVerticalContextSpan : (HorizontalTextInVerticalContextSpan[]) spanned.getSpans(0, spanned.length(), HorizontalTextInVerticalContextSpan.class)) {
            arrayList.add(b(spanned, horizontalTextInVerticalContextSpan, 3, null));
        }
        for (VoiceSpan voiceSpan : (VoiceSpan[]) spanned.getSpans(0, spanned.length(), VoiceSpan.class)) {
            arrayList.add(b(spanned, voiceSpan, 4, voiceSpan.b()));
        }
        return arrayList;
    }

    private static Bundle b(Spanned spanned, Object obj, int i3, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt(f41455a, spanned.getSpanStart(obj));
        bundle2.putInt(f41456b, spanned.getSpanEnd(obj));
        bundle2.putInt(f41457c, spanned.getSpanFlags(obj));
        bundle2.putInt(f41458d, i3);
        if (bundle != null) {
            bundle2.putBundle(f41459e, bundle);
        }
        return bundle2;
    }

    public static void c(Bundle bundle, Spannable spannable) {
        int i3 = bundle.getInt(f41455a);
        int i4 = bundle.getInt(f41456b);
        int i5 = bundle.getInt(f41457c);
        int i6 = bundle.getInt(f41458d, -1);
        Bundle bundle2 = bundle.getBundle(f41459e);
        if (i6 == 1) {
            spannable.setSpan(RubySpan.a((Bundle) Assertions.e(bundle2)), i3, i4, i5);
            return;
        }
        if (i6 == 2) {
            spannable.setSpan(TextEmphasisSpan.a((Bundle) Assertions.e(bundle2)), i3, i4, i5);
        } else if (i6 == 3) {
            spannable.setSpan(new HorizontalTextInVerticalContextSpan(), i3, i4, i5);
        } else {
            if (i6 != 4) {
                return;
            }
            spannable.setSpan(VoiceSpan.a((Bundle) Assertions.e(bundle2)), i3, i4, i5);
        }
    }
}
