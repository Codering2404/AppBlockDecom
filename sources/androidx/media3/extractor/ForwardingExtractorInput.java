package androidx.media3.extractor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ForwardingExtractorInput implements ExtractorInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExtractorInput f46170a;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.f46170a = extractorInput;
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int a(int i3) {
        return this.f46170a.a(i3);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean d(byte[] bArr, int i3, int i4, boolean z2) {
        return this.f46170a.d(bArr, i3, i4, z2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void f() {
        this.f46170a.f();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean g(byte[] bArr, int i3, int i4, boolean z2) {
        return this.f46170a.g(bArr, i3, i4, z2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getLength() {
        return this.f46170a.getLength();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long getPosition() {
        return this.f46170a.getPosition();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public long h() {
        return this.f46170a.h();
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void i(int i3) {
        this.f46170a.i(i3);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public int j(byte[] bArr, int i3, int i4) {
        return this.f46170a.j(bArr, i3, i4);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void k(int i3) {
        this.f46170a.k(i3);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public boolean l(int i3, boolean z2) {
        return this.f46170a.l(i3, z2);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void m(byte[] bArr, int i3, int i4) {
        this.f46170a.m(bArr, i3, i4);
    }

    @Override // androidx.media3.extractor.ExtractorInput, androidx.media3.common.DataReader
    public int read(byte[] bArr, int i3, int i4) {
        return this.f46170a.read(bArr, i3, i4);
    }

    @Override // androidx.media3.extractor.ExtractorInput
    public void readFully(byte[] bArr, int i3, int i4) {
        this.f46170a.readFully(bArr, i3, i4);
    }
}
