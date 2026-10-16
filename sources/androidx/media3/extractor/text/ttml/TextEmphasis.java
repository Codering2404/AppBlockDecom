package androidx.media3.extractor.text.ttml;

import android.text.TextUtils;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TextEmphasis {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f47183d = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ImmutableSet f47184e = ImmutableSet.B("auto", IntegrityManager.INTEGRITY_TYPE_NONE);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ImmutableSet f47185f = ImmutableSet.C("dot", "sesame", "circle");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ImmutableSet f47186g = ImmutableSet.B("filled", "open");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final ImmutableSet f47187h = ImmutableSet.C("after", "before", "outside");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47190c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextEmphasis(int i3, int i4, int i5) {
        this.f47188a = i3;
        this.f47189b = i4;
        this.f47190c = i5;
    }

    public static TextEmphasis a(String str) {
        if (str == null) {
            return null;
        }
        String strE = Ascii.e(str.trim());
        if (strE.isEmpty()) {
            return null;
        }
        return b(ImmutableSet.w(TextUtils.split(strE, f47183d)));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static androidx.media3.extractor.text.ttml.TextEmphasis b(com.google.common.collect.ImmutableSet r7) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TextEmphasis.b(com.google.common.collect.ImmutableSet):androidx.media3.extractor.text.ttml.TextEmphasis");
    }
}
