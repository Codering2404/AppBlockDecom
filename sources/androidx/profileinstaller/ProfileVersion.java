package androidx.profileinstaller;

import com.facebook.stetho.dumpapp.Framer;
import com.revenuecat.purchases.common.Constants;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ProfileVersion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f51419a = {48, Framer.STDOUT_FRAME_PREFIX, 53, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final byte[] f51420b = {48, Framer.STDOUT_FRAME_PREFIX, 48, 0};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte[] f51421c = {48, 48, 57, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final byte[] f51422d = {48, 48, 53, 0};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final byte[] f51423e = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final byte[] f51424f = {48, 48, Framer.STDOUT_FRAME_PREFIX, 0};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final byte[] f51425g = {48, 48, Framer.STDERR_FRAME_PREFIX, 0};

    static String a(byte[] bArr) {
        return (Arrays.equals(bArr, f51423e) || Arrays.equals(bArr, f51422d)) ? Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR : "!";
    }
}
