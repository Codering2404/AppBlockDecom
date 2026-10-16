package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class RemoteInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f33806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence[] f33807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f33808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f33809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Bundle f33810f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f33811g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api20Impl {
        public static android.app.RemoteInput a(RemoteInput remoteInput) {
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(remoteInput.i()).setLabel(remoteInput.h()).setChoices(remoteInput.e()).setAllowFreeFormInput(remoteInput.c()).addExtras(remoteInput.g());
            Set setD = remoteInput.d();
            if (setD != null) {
                Iterator it = setD.iterator();
                while (it.hasNext()) {
                    Api26Impl.a(builderAddExtras, (String) it.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                Api29Impl.a(builderAddExtras, remoteInput.f());
            }
            return builderAddExtras.build();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static RemoteInput.Builder a(RemoteInput.Builder builder, String str, boolean z2) {
            return builder.setAllowDataType(str, z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static RemoteInput.Builder a(RemoteInput.Builder builder, int i3) {
            return builder.setEditChoicesBeforeSending(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    static android.app.RemoteInput a(RemoteInput remoteInput) {
        return Api20Impl.a(remoteInput);
    }

    static android.app.RemoteInput[] b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i3 = 0; i3 < remoteInputArr.length; i3++) {
            remoteInputArr2[i3] = a(remoteInputArr[i3]);
        }
        return remoteInputArr2;
    }

    public boolean c() {
        return this.f33808d;
    }

    public Set d() {
        return this.f33811g;
    }

    public CharSequence[] e() {
        return this.f33807c;
    }

    public int f() {
        return this.f33809e;
    }

    public Bundle g() {
        return this.f33810f;
    }

    public CharSequence h() {
        return this.f33806b;
    }

    public String i() {
        return this.f33805a;
    }

    public boolean j() {
        if (c()) {
            return false;
        }
        return ((e() != null && e().length != 0) || d() == null || d().isEmpty()) ? false : true;
    }
}
