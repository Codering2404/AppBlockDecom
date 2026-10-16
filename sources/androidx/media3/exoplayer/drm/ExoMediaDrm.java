package androidx.media3.exoplayer.drm;

import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoMediaDrm {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AppManagedProvider implements Provider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExoMediaDrm f44064a;

        @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
        public ExoMediaDrm a(UUID uuid) {
            this.f44064a.a();
            return this.f44064a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class KeyRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f44065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f44066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f44067c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RequestType {
        }

        public KeyRequest(byte[] bArr, String str, int i3) {
            this.f44065a = bArr;
            this.f44066b = str;
            this.f44067c = i3;
        }

        public byte[] a() {
            return this.f44065a;
        }

        public String b() {
            return this.f44066b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class KeyStatus {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnEventListener {
        void a(ExoMediaDrm exoMediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnExpirationUpdateListener {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnKeyStatusChangeListener {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Provider {
        ExoMediaDrm a(UUID uuid);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ProvisionRequest {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f44068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f44069b;

        public ProvisionRequest(byte[] bArr, String str) {
            this.f44068a = bArr;
            this.f44069b = str;
        }

        public byte[] a() {
            return this.f44068a;
        }

        public String b() {
            return this.f44069b;
        }
    }

    void a();

    Map b(byte[] bArr);

    ProvisionRequest c();

    byte[] d();

    void e(byte[] bArr, byte[] bArr2);

    void f(byte[] bArr);

    int g();

    CryptoConfig h(byte[] bArr);

    boolean i(byte[] bArr, String str);

    void j(byte[] bArr);

    byte[] k(byte[] bArr, byte[] bArr2);

    void l(OnEventListener onEventListener);

    KeyRequest m(byte[] bArr, List list, int i3, HashMap map);

    void release();

    default void n(byte[] bArr, PlayerId playerId) {
    }
}
