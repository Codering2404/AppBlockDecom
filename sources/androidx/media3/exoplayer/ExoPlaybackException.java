package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlaybackException extends PlaybackException {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f42956k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f42957l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f42958m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Format f42959n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f42960o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final MediaSource.MediaPeriodId f42961p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final boolean f42962q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i3, Throwable th, int i4) {
        this(i3, th, null, i4, null, -1, null, 4, false);
    }

    public static ExoPlaybackException d(Throwable th, String str, int i3, Format format, int i4, boolean z2, int i5) {
        if (format == null) {
            i4 = 4;
        }
        return new ExoPlaybackException(1, th, null, i5, str, i3, format, i4, z2);
    }

    public static ExoPlaybackException e(IOException iOException, int i3) {
        return new ExoPlaybackException(0, iOException, i3);
    }

    public static ExoPlaybackException f(RuntimeException runtimeException, int i3) {
        return new ExoPlaybackException(2, runtimeException, i3);
    }

    private static String g(int i3, String str, String str2, int i4, Format format, int i5) {
        String str3;
        if (i3 == 0) {
            str3 = "Source error";
        } else if (i3 != 1) {
            str3 = i3 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i4 + ", format=" + format + ", format_supported=" + Util.c0(i5);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    ExoPlaybackException c(MediaSource.MediaPeriodId mediaPeriodId) {
        return new ExoPlaybackException((String) Util.k(getMessage()), getCause(), this.f40947a, this.f42956k, this.f42957l, this.f42958m, this.f42959n, this.f42960o, mediaPeriodId, this.f40948b, this.f42962q);
    }

    private ExoPlaybackException(int i3, Throwable th, String str, int i4, String str2, int i5, Format format, int i6, boolean z2) {
        this(g(i3, str, str2, i5, format, i6), th, i4, i3, str2, i5, format, i6, null, SystemClock.elapsedRealtime(), z2);
    }

    private ExoPlaybackException(String str, Throwable th, int i3, int i4, String str2, int i5, Format format, int i6, MediaSource.MediaPeriodId mediaPeriodId, long j3, boolean z2) {
        super(str, th, i3, Bundle.EMPTY, j3);
        Assertions.a(!z2 || i4 == 1);
        Assertions.a(th != null || i4 == 3);
        this.f42956k = i4;
        this.f42957l = str2;
        this.f42958m = i5;
        this.f42959n = format;
        this.f42960o = i6;
        this.f42961p = mediaPeriodId;
        this.f42962q = z2;
    }
}
