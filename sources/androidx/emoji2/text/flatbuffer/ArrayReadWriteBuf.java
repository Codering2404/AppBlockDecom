package androidx.emoji2.text.flatbuffer;

import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f36954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f36955b;

    public ArrayReadWriteBuf(byte[] bArr, int i3) {
        this.f36954a = bArr;
        this.f36955b = i3;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String a(int i3, int i4) {
        return Utf8Safe.b(this.f36954a, i3, i4);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i3) {
        return this.f36954a[i3];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i3) {
        return Double.longBitsToDouble(getLong(i3));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i3) {
        return Float.intBitsToFloat(getInt(i3));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i3) {
        byte[] bArr = this.f36954a;
        return (bArr[i3] & 255) | (bArr[i3 + 3] << Ascii.CAN) | ((bArr[i3 + 2] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i3) {
        byte[] bArr = this.f36954a;
        int i4 = i3 + 6;
        return (((long) bArr[i3]) & 255) | ((((long) bArr[i3 + 1]) & 255) << 8) | ((((long) bArr[i3 + 2]) & 255) << 16) | ((((long) bArr[i3 + 3]) & 255) << 24) | ((((long) bArr[i3 + 4]) & 255) << 32) | ((((long) bArr[i3 + 5]) & 255) << 40) | ((((long) bArr[i4]) & 255) << 48) | (((long) bArr[i3 + 7]) << 56);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i3) {
        byte[] bArr = this.f36954a;
        return (short) ((bArr[i3] & 255) | (bArr[i3 + 1] << 8));
    }
}
