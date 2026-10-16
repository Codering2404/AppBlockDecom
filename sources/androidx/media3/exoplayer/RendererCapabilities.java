package androidx.media3.exoplayer;

import androidx.media3.common.Format;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface RendererCapabilities {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdaptiveSupport {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioOffloadSupport {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Capabilities {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DecoderSupport {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HardwareAccelerationSupport {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(Renderer renderer);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TunnelingSupport {
    }

    static int D(int i3, int i4, int i5, int i6, int i7, int i8) {
        return i3 | i4 | i5 | i6 | i7 | i8;
    }

    static int G(int i3) {
        return i3 & 64;
    }

    static int J(int i3, int i4, int i5) {
        return D(i3, i4, i5, 0, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 0);
    }

    static int R(int i3) {
        return i3 & 7;
    }

    static int l(int i3) {
        return i3 & 384;
    }

    static boolean n(int i3, boolean z2) {
        int iR = R(i3);
        if (iR != 4) {
            return z2 && iR == 3;
        }
        return true;
    }

    static int q(int i3, int i4, int i5, int i6, int i7) {
        return D(i3, i4, i5, i6, i7, 0);
    }

    static int r(int i3, int i4, int i5, int i6) {
        return D(i3, i4, i5, 0, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, i6);
    }

    static int s(int i3) {
        return i3 & 32;
    }

    static int t(int i3) {
        return i3 & 24;
    }

    static int u(int i3) {
        return r(i3, 0, 0, 0);
    }

    static int z(int i3) {
        return i3 & 3584;
    }

    int N();

    int a(Format format);

    int g();

    String getName();

    default void j() {
    }

    default void I(Listener listener) {
    }
}
