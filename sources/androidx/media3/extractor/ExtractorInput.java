package androidx.media3.extractor;

import androidx.media3.common.DataReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ExtractorInput extends DataReader {
    int a(int i3);

    boolean d(byte[] bArr, int i3, int i4, boolean z2);

    void f();

    boolean g(byte[] bArr, int i3, int i4, boolean z2);

    long getLength();

    long getPosition();

    long h();

    void i(int i3);

    int j(byte[] bArr, int i3, int i4);

    void k(int i3);

    boolean l(int i3, boolean z2);

    void m(byte[] bArr, int i3, int i4);

    @Override // androidx.media3.common.DataReader
    int read(byte[] bArr, int i3, int i4);

    void readFully(byte[] bArr, int i3, int i4);
}
