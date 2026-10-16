package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f36956a;

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String a(int i3, int i4) {
        return Utf8Safe.c(this.f36956a, i3, i4);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i3) {
        return this.f36956a.get(i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i3) {
        return this.f36956a.getDouble(i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i3) {
        return this.f36956a.getFloat(i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i3) {
        return this.f36956a.getInt(i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i3) {
        return this.f36956a.getLong(i3);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i3) {
        return this.f36956a.getShort(i3);
    }
}
