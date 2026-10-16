package com.sun.jna;

import com.sun.jna.internal.Cleaner;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Memory extends Pointer implements Closeable {
    private static final Map<Long, Reference<Memory>> allocatedMemory = new ConcurrentHashMap();
    private static final WeakMemoryHolder buffers = new WeakMemoryHolder();
    private final Cleaner.Cleanable cleanable;
    protected long size;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class MemoryDisposer implements Runnable {
        private long peer;

        public MemoryDisposer(long j3) {
            this.peer = j3;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Memory.free(this.peer);
            } finally {
                Memory.allocatedMemory.remove(Long.valueOf(this.peer));
                this.peer = 0L;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class SharedMemory extends Memory {
        public SharedMemory(long j3, long j4) {
            this.size = j4;
            this.peer = Memory.this.peer + j3;
        }

        @Override // com.sun.jna.Memory
        protected void boundsCheck(long j3, long j4) {
            Memory memory = Memory.this;
            memory.boundsCheck((this.peer - memory.peer) + j3, j4);
        }

        @Override // com.sun.jna.Memory
        protected synchronized void dispose() {
            this.peer = 0L;
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return super.toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }

    public Memory(long j3) {
        this.size = j3;
        if (j3 <= 0) {
            throw new IllegalArgumentException("Allocation size must be greater than zero");
        }
        long jMalloc = malloc(j3);
        this.peer = jMalloc;
        if (jMalloc != 0) {
            allocatedMemory.put(Long.valueOf(jMalloc), new WeakReference(this));
            this.cleanable = Cleaner.getCleaner().register(this, new MemoryDisposer(this.peer));
        } else {
            throw new OutOfMemoryError("Cannot allocate " + j3 + " bytes");
        }
    }

    public static void disposeAll() {
        ArrayList arrayList = new ArrayList(allocatedMemory.values());
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Memory memory = (Memory) ((Reference) obj).get();
            if (memory != null) {
                memory.close();
            }
        }
    }

    protected static void free(long j3) {
        if (j3 != 0) {
            Native.free(j3);
        }
    }

    protected static long malloc(long j3) {
        return Native.malloc(j3);
    }

    public static void purge() {
        buffers.clean();
    }

    private Pointer shareReferenceIfInBounds(Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        long j3 = pointer.peer - this.peer;
        return (j3 < 0 || j3 >= this.size) ? pointer : share(j3);
    }

    public Memory align(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + i3);
        }
        for (int i4 = 0; i4 < 32; i4++) {
            if (i3 == (1 << i4)) {
                long j3 = i3;
                long j4 = ~(j3 - 1);
                long j5 = this.peer;
                if ((j5 & j4) == j5) {
                    return this;
                }
                long j6 = ((j3 + j5) - 1) & j4;
                long j7 = (this.size + j5) - j6;
                if (j7 > 0) {
                    return (Memory) share(j6 - j5, j7);
                }
                throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
            }
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void boundsCheck(long j3, long j4) {
        if (j3 < 0) {
            throw new IndexOutOfBoundsException("Invalid offset: " + j3);
        }
        long j5 = j3 + j4;
        if (j5 <= this.size) {
            return;
        }
        throw new IndexOutOfBoundsException("Bounds exceeds available space : size=" + this.size + ", offset=" + j5);
    }

    public void clear() {
        clear(this.size);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peer = 0L;
        Cleaner.Cleanable cleanable = this.cleanable;
        if (cleanable != null) {
            cleanable.clean();
        }
    }

    @Deprecated
    protected void dispose() {
        close();
    }

    public String dump() {
        return dump(0L, (int) size());
    }

    @Override // com.sun.jna.Pointer
    public byte getByte(long j3) {
        boundsCheck(j3, 1L);
        return super.getByte(j3);
    }

    @Override // com.sun.jna.Pointer
    public ByteBuffer getByteBuffer(long j3, long j4) {
        boundsCheck(j3, j4);
        ByteBuffer byteBuffer = super.getByteBuffer(j3, j4);
        buffers.put(byteBuffer, this);
        return byteBuffer;
    }

    @Override // com.sun.jna.Pointer
    public char getChar(long j3) {
        boundsCheck(j3, Native.WCHAR_SIZE);
        return super.getChar(j3);
    }

    @Override // com.sun.jna.Pointer
    public double getDouble(long j3) {
        boundsCheck(j3, 8L);
        return super.getDouble(j3);
    }

    @Override // com.sun.jna.Pointer
    public float getFloat(long j3) {
        boundsCheck(j3, 4L);
        return super.getFloat(j3);
    }

    @Override // com.sun.jna.Pointer
    public int getInt(long j3) {
        boundsCheck(j3, 4L);
        return super.getInt(j3);
    }

    @Override // com.sun.jna.Pointer
    public long getLong(long j3) {
        boundsCheck(j3, 8L);
        return super.getLong(j3);
    }

    @Override // com.sun.jna.Pointer
    public Pointer getPointer(long j3) {
        boundsCheck(j3, Native.POINTER_SIZE);
        return shareReferenceIfInBounds(super.getPointer(j3));
    }

    @Override // com.sun.jna.Pointer
    public short getShort(long j3) {
        boundsCheck(j3, 2L);
        return super.getShort(j3);
    }

    @Override // com.sun.jna.Pointer
    public String getString(long j3, String str) {
        boundsCheck(j3, 0L);
        return super.getString(j3, str);
    }

    @Override // com.sun.jna.Pointer
    public String getWideString(long j3) {
        boundsCheck(j3, 0L);
        return super.getWideString(j3);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, byte[] bArr, int i3, int i4) {
        boundsCheck(j3, i4);
        super.read(j3, bArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void setByte(long j3, byte b3) {
        boundsCheck(j3, 1L);
        super.setByte(j3, b3);
    }

    @Override // com.sun.jna.Pointer
    public void setChar(long j3, char c3) {
        boundsCheck(j3, Native.WCHAR_SIZE);
        super.setChar(j3, c3);
    }

    @Override // com.sun.jna.Pointer
    public void setDouble(long j3, double d3) {
        boundsCheck(j3, 8L);
        super.setDouble(j3, d3);
    }

    @Override // com.sun.jna.Pointer
    public void setFloat(long j3, float f3) {
        boundsCheck(j3, 4L);
        super.setFloat(j3, f3);
    }

    @Override // com.sun.jna.Pointer
    public void setInt(long j3, int i3) {
        boundsCheck(j3, 4L);
        super.setInt(j3, i3);
    }

    @Override // com.sun.jna.Pointer
    public void setLong(long j3, long j4) {
        boundsCheck(j3, 8L);
        super.setLong(j3, j4);
    }

    @Override // com.sun.jna.Pointer
    public void setPointer(long j3, Pointer pointer) {
        boundsCheck(j3, Native.POINTER_SIZE);
        super.setPointer(j3, pointer);
    }

    @Override // com.sun.jna.Pointer
    public void setShort(long j3, short s2) {
        boundsCheck(j3, 2L);
        super.setShort(j3, s2);
    }

    @Override // com.sun.jna.Pointer
    public void setString(long j3, String str, String str2) {
        boundsCheck(j3, ((long) Native.getBytes(str, str2).length) + 1);
        super.setString(j3, str, str2);
    }

    @Override // com.sun.jna.Pointer
    public void setWideString(long j3, String str) {
        boundsCheck(j3, (((long) str.length()) + 1) * ((long) Native.WCHAR_SIZE));
        super.setWideString(j3, str);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j3) {
        return share(j3, size() - j3);
    }

    public long size() {
        return this.size;
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    public boolean valid() {
        return this.peer != 0;
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, byte[] bArr, int i3, int i4) {
        boundsCheck(j3, i4);
        super.write(j3, bArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j3, long j4) {
        boundsCheck(j3, j4);
        return new SharedMemory(j3, j4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, short[] sArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 2);
        super.read(j3, sArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, short[] sArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 2);
        super.write(j3, sArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, char[] cArr, int i3, int i4) {
        boundsCheck(j3, Native.WCHAR_SIZE * i4);
        super.read(j3, cArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, char[] cArr, int i3, int i4) {
        boundsCheck(j3, Native.WCHAR_SIZE * i4);
        super.write(j3, cArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, int[] iArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 4);
        super.read(j3, iArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, int[] iArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 4);
        super.write(j3, iArr, i3, i4);
    }

    protected Memory() {
        this.cleanable = null;
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, long[] jArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 8);
        super.read(j3, jArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, long[] jArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 8);
        super.write(j3, jArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, float[] fArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 4);
        super.read(j3, fArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, float[] fArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 4);
        super.write(j3, fArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, double[] dArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 8);
        super.read(j3, dArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, double[] dArr, int i3, int i4) {
        boundsCheck(j3, ((long) i4) * 8);
        super.write(j3, dArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j3, Pointer[] pointerArr, int i3, int i4) {
        boundsCheck(j3, Native.POINTER_SIZE * i4);
        super.read(j3, pointerArr, i3, i4);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j3, Pointer[] pointerArr, int i3, int i4) {
        boundsCheck(j3, Native.POINTER_SIZE * i4);
        super.write(j3, pointerArr, i3, i4);
    }
}
