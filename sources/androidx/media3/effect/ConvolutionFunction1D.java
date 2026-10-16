package androidx.media3.effect;

import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ConvolutionFunction1D {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Provider {
        Size a(Size size);

        ConvolutionFunction1D b(long j3);
    }

    float a(float f3);

    float b();

    float c();

    default float d() {
        return b() - c();
    }
}
