package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class IntegerType extends Number implements NativeMapped {
    private static final long serialVersionUID = 1;
    private Number number;
    private int size;
    private boolean unsigned;
    private long value;

    public IntegerType(int i3) {
        this(i3, 0L, false);
    }

    public static final int compare(long j3, long j4) {
        if (j3 == j4) {
            return 0;
        }
        return j3 < j4 ? -1 : 1;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.number.doubleValue();
    }

    public boolean equals(Object obj) {
        return (obj instanceof IntegerType) && this.number.equals(((IntegerType) obj).number);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.number.floatValue();
    }

    @Override // com.sun.jna.NativeMapped
    public Object fromNative(Object obj, FromNativeContext fromNativeContext) {
        long jLongValue = obj == null ? 0L : ((Number) obj).longValue();
        IntegerType integerType = (IntegerType) Klass.newInstance(getClass());
        integerType.setValue(jLongValue);
        return integerType;
    }

    public int hashCode() {
        return this.number.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // com.sun.jna.NativeMapped
    public Class<?> nativeType() {
        return this.number.getClass();
    }

    public void setValue(long j3) {
        long j4;
        this.value = j3;
        int i3 = this.size;
        if (i3 == 1) {
            if (this.unsigned) {
                this.value = 255 & j3;
            }
            byte b3 = (byte) j3;
            j4 = b3;
            this.number = Byte.valueOf(b3);
        } else if (i3 == 2) {
            if (this.unsigned) {
                this.value = 65535 & j3;
            }
            short s2 = (short) j3;
            j4 = s2;
            this.number = Short.valueOf(s2);
        } else if (i3 == 4) {
            if (this.unsigned) {
                this.value = 4294967295L & j3;
            }
            int i4 = (int) j3;
            j4 = i4;
            this.number = Integer.valueOf(i4);
        } else {
            if (i3 != 8) {
                throw new IllegalArgumentException("Unsupported size: " + this.size);
            }
            this.number = Long.valueOf(j3);
            j4 = j3;
        }
        int i5 = this.size;
        if (i5 < 8) {
            long j5 = ~((1 << (i5 * 8)) - 1);
            if ((j3 >= 0 || j4 == j3) && (j3 < 0 || (j5 & j3) == 0)) {
                return;
            }
            throw new IllegalArgumentException("Argument value 0x" + Long.toHexString(j3) + " exceeds native capacity (" + this.size + " bytes) mask=0x" + Long.toHexString(j5));
        }
    }

    @Override // com.sun.jna.NativeMapped
    public Object toNative() {
        return this.number;
    }

    public String toString() {
        return this.number.toString();
    }

    public IntegerType(int i3, boolean z2) {
        this(i3, 0L, z2);
    }

    public static <T extends IntegerType> int compare(T t2, T t3) {
        if (t2 == t3) {
            return 0;
        }
        if (t2 == null) {
            return 1;
        }
        if (t3 == null) {
            return -1;
        }
        return compare(t2.longValue(), t3.longValue());
    }

    public IntegerType(int i3, long j3) {
        this(i3, j3, false);
    }

    public static int compare(IntegerType integerType, long j3) {
        if (integerType == null) {
            return 1;
        }
        return compare(integerType.longValue(), j3);
    }

    public IntegerType(int i3, long j3, boolean z2) {
        this.size = i3;
        this.unsigned = z2;
        setValue(j3);
    }
}
