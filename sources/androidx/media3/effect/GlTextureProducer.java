package androidx.media3.effect;

import androidx.media3.common.GlTextureInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface GlTextureProducer {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void a(GlTextureProducer glTextureProducer, GlTextureInfo glTextureInfo, long j3, long j4);
    }

    void j(long j3);
}
