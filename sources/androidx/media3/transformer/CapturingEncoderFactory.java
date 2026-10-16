package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.transformer.Codec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class CapturingEncoderFactory implements Codec.EncoderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Codec.EncoderFactory f47965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f47966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f47967c;

    public CapturingEncoderFactory(Codec.EncoderFactory encoderFactory) {
        this.f47965a = encoderFactory;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean a() {
        return this.f47965a.a();
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public Codec b(Format format) {
        Codec codecB = this.f47965a.b(format);
        this.f47966b = codecB.getName();
        return codecB;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public Codec c(Format format) {
        Codec codecC = this.f47965a.c(format);
        this.f47967c = codecC.getName();
        return codecC;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean d() {
        return this.f47965a.d();
    }

    public String e() {
        return this.f47966b;
    }

    public String f() {
        return this.f47967c;
    }
}
