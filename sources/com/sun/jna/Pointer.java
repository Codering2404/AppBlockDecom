package com.sun.jna;

import com.facebook.appevents.AppEventsConstants;
import com.sun.jna.Structure;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Pointer {
    public static final Pointer NULL = null;
    protected long peer;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Opaque extends Pointer {
        private final String MSG;

        @Override // com.sun.jna.Pointer
        public void clear(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String dump(long j3, int i3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public byte getByte(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public ByteBuffer getByteBuffer(long j3, long j4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public char getChar(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public double getDouble(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public float getFloat(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public int getInt(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long getLong(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer getPointer(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public short getShort(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getString(long j3, String str) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getWideString(long j3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long indexOf(long j3, byte b3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, byte[] bArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setByte(long j3, byte b3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setChar(long j3, char c3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setDouble(long j3, double d3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setFloat(long j3, float f3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setInt(long j3, int i3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setLong(long j3, long j4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setMemory(long j3, long j4, byte b3) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setPointer(long j3, Pointer pointer) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setShort(long j3, short s2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setString(long j3, String str, String str2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setWideString(long j3, String str) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer share(long j3, long j4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String toString() {
            return "const@0x" + Long.toHexString(this.peer);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, byte[] bArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        private Opaque(long j3) {
            super(j3);
            this.MSG = "This pointer is opaque: " + this;
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, char[] cArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, char[] cArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, short[] sArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, short[] sArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, int[] iArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, int[] iArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, long[] jArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, long[] jArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, float[] fArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, float[] fArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, double[] dArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, double[] dArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j3, Pointer[] pointerArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j3, Pointer[] pointerArr, int i3, int i4) {
            throw new UnsupportedOperationException(this.MSG);
        }
    }

    Pointer() {
    }

    public static final Pointer createConstant(long j3) {
        return new Opaque(j3);
    }

    public static long nativeValue(Pointer pointer) {
        if (pointer == null) {
            return 0L;
        }
        return pointer.peer;
    }

    private void readArray(long j3, Object obj, Class<?> cls) {
        int length = Array.getLength(obj);
        if (cls == Byte.TYPE) {
            read(j3, (byte[]) obj, 0, length);
            return;
        }
        if (cls == Short.TYPE) {
            read(j3, (short[]) obj, 0, length);
            return;
        }
        if (cls == Character.TYPE) {
            read(j3, (char[]) obj, 0, length);
            return;
        }
        if (cls == Integer.TYPE) {
            read(j3, (int[]) obj, 0, length);
            return;
        }
        if (cls == Long.TYPE) {
            read(j3, (long[]) obj, 0, length);
            return;
        }
        if (cls == Float.TYPE) {
            read(j3, (float[]) obj, 0, length);
            return;
        }
        if (cls == Double.TYPE) {
            read(j3, (double[]) obj, 0, length);
            return;
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            read(j3, (Pointer[]) obj, 0, length);
            return;
        }
        int i3 = 0;
        if (!Structure.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Reading array of " + cls + " from memory not supported");
            }
            NativeMapped[] nativeMappedArr = (NativeMapped[]) obj;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            int nativeSize = Native.getNativeSize(obj.getClass(), obj) / nativeMappedArr.length;
            while (i3 < nativeMappedArr.length) {
                nativeMappedArr[i3] = (NativeMapped) nativeMappedConverter.fromNative(getValue(((long) (nativeSize * i3)) + j3, nativeMappedConverter.nativeType(), nativeMappedArr[i3]), new FromNativeContext(cls));
                i3++;
            }
            return;
        }
        Structure[] structureArr = (Structure[]) obj;
        if (Structure.ByReference.class.isAssignableFrom(cls)) {
            Pointer[] pointerArray = getPointerArray(j3, structureArr.length);
            while (i3 < structureArr.length) {
                structureArr[i3] = Structure.updateStructureByReference(cls, structureArr[i3], pointerArray[i3]);
                i3++;
            }
            return;
        }
        Structure structureNewInstance = structureArr[0];
        if (structureNewInstance == null) {
            structureNewInstance = Structure.newInstance((Class<Structure>) cls, share(j3));
            structureNewInstance.conditionalAutoRead();
            structureArr[0] = structureNewInstance;
        } else {
            structureNewInstance.useMemory(this, (int) j3, true);
            structureNewInstance.read();
        }
        Structure[] array = structureNewInstance.toArray(structureArr.length);
        for (int i4 = 1; i4 < structureArr.length; i4++) {
            Structure structure = structureArr[i4];
            if (structure == null) {
                structureArr[i4] = array[i4];
            } else {
                structure.useMemory(this, (int) (((long) (structure.size() * i4)) + j3), true);
                structureArr[i4].read();
            }
        }
    }

    private void writeArray(long j3, Object obj, Class<?> cls) {
        if (cls == Byte.TYPE) {
            byte[] bArr = (byte[]) obj;
            write(j3, bArr, 0, bArr.length);
            return;
        }
        if (cls == Short.TYPE) {
            short[] sArr = (short[]) obj;
            write(j3, sArr, 0, sArr.length);
            return;
        }
        if (cls == Character.TYPE) {
            char[] cArr = (char[]) obj;
            write(j3, cArr, 0, cArr.length);
            return;
        }
        if (cls == Integer.TYPE) {
            int[] iArr = (int[]) obj;
            write(j3, iArr, 0, iArr.length);
            return;
        }
        if (cls == Long.TYPE) {
            long[] jArr = (long[]) obj;
            write(j3, jArr, 0, jArr.length);
            return;
        }
        if (cls == Float.TYPE) {
            float[] fArr = (float[]) obj;
            write(j3, fArr, 0, fArr.length);
            return;
        }
        if (cls == Double.TYPE) {
            double[] dArr = (double[]) obj;
            write(j3, dArr, 0, dArr.length);
            return;
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            Pointer[] pointerArr = (Pointer[]) obj;
            write(j3, pointerArr, 0, pointerArr.length);
            return;
        }
        if (!Structure.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Writing array of " + cls + " to memory not supported");
            }
            NativeMapped[] nativeMappedArr = (NativeMapped[]) obj;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            Class<?> clsNativeType = nativeMappedConverter.nativeType();
            int nativeSize = Native.getNativeSize(obj.getClass(), obj) / nativeMappedArr.length;
            for (int i3 = 0; i3 < nativeMappedArr.length; i3++) {
                setValue(((long) (i3 * nativeSize)) + j3, nativeMappedConverter.toNative(nativeMappedArr[i3], new ToNativeContext()), clsNativeType);
            }
            return;
        }
        Structure[] structureArr = (Structure[]) obj;
        if (Structure.ByReference.class.isAssignableFrom(cls)) {
            int length = structureArr.length;
            Pointer[] pointerArr2 = new Pointer[length];
            for (int i4 = 0; i4 < structureArr.length; i4++) {
                Structure structure = structureArr[i4];
                if (structure == null) {
                    pointerArr2[i4] = null;
                } else {
                    pointerArr2[i4] = structure.getPointer();
                    structureArr[i4].write();
                }
            }
            write(j3, pointerArr2, 0, length);
            return;
        }
        Structure structureNewInstance = structureArr[0];
        if (structureNewInstance == null) {
            structureNewInstance = Structure.newInstance((Class<Structure>) cls, share(j3));
            structureArr[0] = structureNewInstance;
        } else {
            structureNewInstance.useMemory(this, (int) j3, true);
        }
        structureNewInstance.write();
        Structure[] array = structureNewInstance.toArray(structureArr.length);
        for (int i5 = 1; i5 < structureArr.length; i5++) {
            Structure structure2 = structureArr[i5];
            if (structure2 == null) {
                structureArr[i5] = array[i5];
            } else {
                structure2.useMemory(this, (int) (((long) (structure2.size() * i5)) + j3), true);
            }
            structureArr[i5].write();
        }
    }

    public void clear(long j3) {
        setMemory(0L, j3, (byte) 0);
    }

    public String dump(long j3, int i3) {
        StringWriter stringWriter = new StringWriter(13 + (i3 * 2) + ((i3 / 4) * 4));
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("memory dump");
        for (int i4 = 0; i4 < i3; i4++) {
            byte b3 = getByte(((long) i4) + j3);
            int i5 = i4 % 4;
            if (i5 == 0) {
                printWriter.print("[");
            }
            if (b3 >= 0 && b3 < 16) {
                printWriter.print(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            printWriter.print(Integer.toHexString(b3 & 255));
            if (i5 == 3 && i4 < i3 - 1) {
                printWriter.println("]");
            }
        }
        if (stringWriter.getBuffer().charAt(stringWriter.getBuffer().length() - 2) != ']') {
            printWriter.println("]");
        }
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof Pointer) && ((Pointer) obj).peer == this.peer;
    }

    public byte getByte(long j3) {
        return Native.getByte(this, this.peer, j3);
    }

    public byte[] getByteArray(long j3, int i3) {
        byte[] bArr = new byte[i3];
        read(j3, bArr, 0, i3);
        return bArr;
    }

    public ByteBuffer getByteBuffer(long j3, long j4) {
        return Native.getDirectByteBuffer(this, this.peer, j3, j4).order(ByteOrder.nativeOrder());
    }

    public char getChar(long j3) {
        return Native.getChar(this, this.peer, j3);
    }

    public char[] getCharArray(long j3, int i3) {
        char[] cArr = new char[i3];
        read(j3, cArr, 0, i3);
        return cArr;
    }

    public double getDouble(long j3) {
        return Native.getDouble(this, this.peer, j3);
    }

    public double[] getDoubleArray(long j3, int i3) {
        double[] dArr = new double[i3];
        read(j3, dArr, 0, i3);
        return dArr;
    }

    public float getFloat(long j3) {
        return Native.getFloat(this, this.peer, j3);
    }

    public float[] getFloatArray(long j3, int i3) {
        float[] fArr = new float[i3];
        read(j3, fArr, 0, i3);
        return fArr;
    }

    public int getInt(long j3) {
        return Native.getInt(this, this.peer, j3);
    }

    public int[] getIntArray(long j3, int i3) {
        int[] iArr = new int[i3];
        read(j3, iArr, 0, i3);
        return iArr;
    }

    public long getLong(long j3) {
        return Native.getLong(this, this.peer, j3);
    }

    public long[] getLongArray(long j3, int i3) {
        long[] jArr = new long[i3];
        read(j3, jArr, 0, i3);
        return jArr;
    }

    public NativeLong getNativeLong(long j3) {
        return new NativeLong(NativeLong.SIZE == 8 ? getLong(j3) : getInt(j3));
    }

    public Pointer getPointer(long j3) {
        return Native.getPointer(this.peer + j3);
    }

    public Pointer[] getPointerArray(long j3) {
        ArrayList arrayList = new ArrayList();
        Pointer pointer = getPointer(j3);
        int i3 = 0;
        while (pointer != null) {
            arrayList.add(pointer);
            i3 += Native.POINTER_SIZE;
            pointer = getPointer(((long) i3) + j3);
        }
        return (Pointer[]) arrayList.toArray(new Pointer[0]);
    }

    public short getShort(long j3) {
        return Native.getShort(this, this.peer, j3);
    }

    public short[] getShortArray(long j3, int i3) {
        short[] sArr = new short[i3];
        read(j3, sArr, 0, i3);
        return sArr;
    }

    public String getString(long j3) {
        return getString(j3, Native.getDefaultStringEncoding());
    }

    public String[] getStringArray(long j3) {
        return getStringArray(j3, -1, Native.getDefaultStringEncoding());
    }

    Object getValue(long j3, Class<?> cls, Object obj) {
        Pointer directBufferPointer;
        if (Structure.class.isAssignableFrom(cls)) {
            Structure structure = (Structure) obj;
            if (Structure.ByReference.class.isAssignableFrom(cls)) {
                return Structure.updateStructureByReference(cls, structure, getPointer(j3));
            }
            structure.useMemory(this, (int) j3, true);
            structure.read();
            return structure;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return Function.valueOf(getInt(j3) != 0);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return Byte.valueOf(getByte(j3));
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return Short.valueOf(getShort(j3));
        }
        if (cls == Character.TYPE || cls == Character.class) {
            return Character.valueOf(getChar(j3));
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return Integer.valueOf(getInt(j3));
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return Long.valueOf(getLong(j3));
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return Float.valueOf(getFloat(j3));
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return Double.valueOf(getDouble(j3));
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            Pointer pointer = getPointer(j3);
            if (pointer == null) {
                return null;
            }
            directBufferPointer = obj instanceof Pointer ? (Pointer) obj : null;
            return (directBufferPointer == null || pointer.peer != directBufferPointer.peer) ? pointer : directBufferPointer;
        }
        if (cls == String.class) {
            Pointer pointer2 = getPointer(j3);
            if (pointer2 != null) {
                return pointer2.getString(0L);
            }
            return null;
        }
        if (cls == WString.class) {
            Pointer pointer3 = getPointer(j3);
            if (pointer3 != null) {
                return new WString(pointer3.getWideString(0L));
            }
            return null;
        }
        if (Callback.class.isAssignableFrom(cls)) {
            Pointer pointer4 = getPointer(j3);
            if (pointer4 == null) {
                return null;
            }
            Callback callback = (Callback) obj;
            return !pointer4.equals(CallbackReference.getFunctionPointer(callback)) ? CallbackReference.getCallback(cls, pointer4) : callback;
        }
        if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) {
            Pointer pointer5 = getPointer(j3);
            if (pointer5 == null) {
                return null;
            }
            directBufferPointer = obj != null ? Native.getDirectBufferPointer((Buffer) obj) : null;
            if (directBufferPointer == null || !directBufferPointer.equals(pointer5)) {
                throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
            }
            return obj;
        }
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMapped nativeMapped = (NativeMapped) obj;
            if (nativeMapped != null) {
                Object objFromNative = nativeMapped.fromNative(getValue(j3, nativeMapped.nativeType(), null), new FromNativeContext(cls));
                return nativeMapped.equals(objFromNative) ? nativeMapped : objFromNative;
            }
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            return nativeMappedConverter.fromNative(getValue(j3, nativeMappedConverter.nativeType(), null), new FromNativeContext(cls));
        }
        if (cls.isArray()) {
            if (obj == null) {
                throw new IllegalStateException("Need an initialized array");
            }
            readArray(j3, obj, cls.getComponentType());
            return obj;
        }
        throw new IllegalArgumentException("Reading \"" + cls + "\" from memory is not supported");
    }

    public String getWideString(long j3) {
        return Native.getWideString(this, this.peer, j3);
    }

    public String[] getWideStringArray(long j3) {
        return getWideStringArray(j3, -1);
    }

    public int hashCode() {
        long j3 = this.peer;
        return (int) ((j3 >>> 32) + (j3 & 4294967295L));
    }

    public long indexOf(long j3, byte b3) {
        return Native.indexOf(this, this.peer, j3, b3);
    }

    public void read(long j3, byte[] bArr, int i3, int i4) {
        Native.read(this, this.peer, j3, bArr, i3, i4);
    }

    public void setByte(long j3, byte b3) {
        Native.setByte(this, this.peer, j3, b3);
    }

    public void setChar(long j3, char c3) {
        Native.setChar(this, this.peer, j3, c3);
    }

    public void setDouble(long j3, double d3) {
        Native.setDouble(this, this.peer, j3, d3);
    }

    public void setFloat(long j3, float f3) {
        Native.setFloat(this, this.peer, j3, f3);
    }

    public void setInt(long j3, int i3) {
        Native.setInt(this, this.peer, j3, i3);
    }

    public void setLong(long j3, long j4) {
        Native.setLong(this, this.peer, j3, j4);
    }

    public void setMemory(long j3, long j4, byte b3) {
        Native.setMemory(this, this.peer, j3, j4, b3);
    }

    public void setNativeLong(long j3, NativeLong nativeLong) {
        if (NativeLong.SIZE == 8) {
            setLong(j3, nativeLong.longValue());
        } else {
            setInt(j3, nativeLong.intValue());
        }
    }

    public void setPointer(long j3, Pointer pointer) {
        Native.setPointer(this, this.peer, j3, pointer != null ? pointer.peer : 0L);
    }

    public void setShort(long j3, short s2) {
        Native.setShort(this, this.peer, j3, s2);
    }

    public void setString(long j3, WString wString) {
        setWideString(j3, wString == null ? null : wString.toString());
    }

    void setValue(long j3, Object obj, Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            setInt(j3, Boolean.TRUE.equals(obj) ? -1 : 0);
            return;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            setByte(j3, obj != null ? ((Byte) obj).byteValue() : (byte) 0);
            return;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            setShort(j3, obj != null ? ((Short) obj).shortValue() : (short) 0);
            return;
        }
        if (cls == Character.TYPE || cls == Character.class) {
            setChar(j3, obj != null ? ((Character) obj).charValue() : (char) 0);
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            setInt(j3, obj != null ? ((Integer) obj).intValue() : 0);
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            setLong(j3, obj == null ? 0L : ((Long) obj).longValue());
            return;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            setFloat(j3, obj == null ? 0.0f : ((Float) obj).floatValue());
            return;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            setDouble(j3, obj == null ? 0.0d : ((Double) obj).doubleValue());
            return;
        }
        if (cls == Pointer.class) {
            setPointer(j3, (Pointer) obj);
            return;
        }
        if (cls == String.class) {
            setPointer(j3, (Pointer) obj);
            return;
        }
        if (cls == WString.class) {
            setPointer(j3, (Pointer) obj);
            return;
        }
        if (Structure.class.isAssignableFrom(cls)) {
            Structure structure = (Structure) obj;
            if (!Structure.ByReference.class.isAssignableFrom(cls)) {
                structure.useMemory(this, (int) j3, true);
                structure.write();
                return;
            } else {
                setPointer(j3, structure != null ? structure.getPointer() : null);
                if (structure != null) {
                    structure.autoWrite();
                    return;
                }
                return;
            }
        }
        if (Callback.class.isAssignableFrom(cls)) {
            setPointer(j3, CallbackReference.getFunctionPointer((Callback) obj));
            return;
        }
        if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) {
            setPointer(j3, obj != null ? Native.getDirectBufferPointer((Buffer) obj) : null);
            return;
        }
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            setValue(j3, nativeMappedConverter.toNative(obj, new ToNativeContext()), nativeMappedConverter.nativeType());
        } else {
            if (cls.isArray()) {
                writeArray(j3, obj, cls.getComponentType());
                return;
            }
            throw new IllegalArgumentException("Writing " + cls + " to memory is not supported");
        }
    }

    public void setWideString(long j3, String str) {
        Native.setWideString(this, this.peer, j3, str);
    }

    public Pointer share(long j3) {
        return share(j3, 0L);
    }

    public String toString() {
        return "native@0x" + Long.toHexString(this.peer);
    }

    public void write(long j3, byte[] bArr, int i3, int i4) {
        Native.write(this, this.peer, j3, bArr, i3, i4);
    }

    public Pointer(long j3) {
        this.peer = j3;
    }

    public static final Pointer createConstant(int i3) {
        return new Opaque(((long) i3) & 4294967295L);
    }

    public static void nativeValue(Pointer pointer, long j3) {
        pointer.peer = j3;
    }

    public String getString(long j3, String str) {
        return Native.getString(this, j3, str);
    }

    public String[] getStringArray(long j3, String str) {
        return getStringArray(j3, -1, str);
    }

    public String[] getWideStringArray(long j3, int i3) {
        return getStringArray(j3, i3, "--WIDE-STRING--");
    }

    public void read(long j3, short[] sArr, int i3, int i4) {
        Native.read(this, this.peer, j3, sArr, i3, i4);
    }

    public void setString(long j3, String str) {
        setString(j3, str, Native.getDefaultStringEncoding());
    }

    public Pointer share(long j3, long j4) {
        return j3 == 0 ? this : new Pointer(this.peer + j3);
    }

    public void write(long j3, short[] sArr, int i3, int i4) {
        Native.write(this, this.peer, j3, sArr, i3, i4);
    }

    public String[] getStringArray(long j3, int i3) {
        return getStringArray(j3, i3, Native.getDefaultStringEncoding());
    }

    public void read(long j3, char[] cArr, int i3, int i4) {
        Native.read(this, this.peer, j3, cArr, i3, i4);
    }

    public void setString(long j3, String str, String str2) {
        byte[] bytes = Native.getBytes(str, str2);
        write(j3, bytes, 0, bytes.length);
        setByte(((long) bytes.length) + j3, (byte) 0);
    }

    public void write(long j3, char[] cArr, int i3, int i4) {
        Native.write(this, this.peer, j3, cArr, i3, i4);
    }

    public String[] getStringArray(long j3, int i3, String str) {
        String string;
        String wideString;
        ArrayList arrayList = new ArrayList();
        if (i3 == -1) {
            int i4 = 0;
            while (true) {
                Pointer pointer = getPointer(((long) i4) + j3);
                if (pointer == null) {
                    break;
                }
                if ("--WIDE-STRING--".equals(str)) {
                    string = pointer.getWideString(0L);
                } else {
                    string = pointer.getString(0L, str);
                }
                arrayList.add(string);
                i4 += Native.POINTER_SIZE;
            }
        } else {
            Pointer pointer2 = getPointer(((long) 0) + j3);
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = i5 + 1;
                if (i5 >= i3) {
                    break;
                }
                if (pointer2 == null) {
                    wideString = null;
                } else {
                    wideString = "--WIDE-STRING--".equals(str) ? pointer2.getWideString(0L) : pointer2.getString(0L, str);
                }
                arrayList.add(wideString);
                if (i7 < i3) {
                    i6 += Native.POINTER_SIZE;
                    pointer2 = getPointer(((long) i6) + j3);
                }
                i5 = i7;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void read(long j3, int[] iArr, int i3, int i4) {
        Native.read(this, this.peer, j3, iArr, i3, i4);
    }

    public void write(long j3, int[] iArr, int i3, int i4) {
        Native.write(this, this.peer, j3, iArr, i3, i4);
    }

    public void read(long j3, long[] jArr, int i3, int i4) {
        Native.read(this, this.peer, j3, jArr, i3, i4);
    }

    public void write(long j3, long[] jArr, int i3, int i4) {
        Native.write(this, this.peer, j3, jArr, i3, i4);
    }

    public void read(long j3, float[] fArr, int i3, int i4) {
        Native.read(this, this.peer, j3, fArr, i3, i4);
    }

    public void write(long j3, float[] fArr, int i3, int i4) {
        Native.write(this, this.peer, j3, fArr, i3, i4);
    }

    public Pointer[] getPointerArray(long j3, int i3) {
        Pointer[] pointerArr = new Pointer[i3];
        read(j3, pointerArr, 0, i3);
        return pointerArr;
    }

    public void read(long j3, double[] dArr, int i3, int i4) {
        Native.read(this, this.peer, j3, dArr, i3, i4);
    }

    public void write(long j3, double[] dArr, int i3, int i4) {
        Native.write(this, this.peer, j3, dArr, i3, i4);
    }

    public void read(long j3, Pointer[] pointerArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            Pointer pointer = getPointer(((long) (Native.POINTER_SIZE * i5)) + j3);
            int i6 = i5 + i3;
            Pointer pointer2 = pointerArr[i6];
            if (pointer2 == null || pointer == null || pointer.peer != pointer2.peer) {
                pointerArr[i6] = pointer;
            }
        }
    }

    public void write(long j3, Pointer[] pointerArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            setPointer(((long) (Native.POINTER_SIZE * i5)) + j3, pointerArr[i3 + i5]);
        }
    }
}
