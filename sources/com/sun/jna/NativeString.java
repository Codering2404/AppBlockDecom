package com.sun.jna;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class NativeString implements CharSequence, Comparable {
    static final String WIDE_STRING = "--WIDE-STRING--";
    private String encoding;
    private Pointer pointer;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class StringMemory extends Memory {
        public StringMemory(long j3) {
            super(j3);
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return NativeString.this.toString();
        }
    }

    public NativeString(String str) {
        this(str, Native.getDefaultStringEncoding());
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return toString().charAt(i3);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        return toString().compareTo(obj.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof CharSequence) && compareTo(obj) == 0;
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return toString().subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return WIDE_STRING.equals(this.encoding) ? this.pointer.getWideString(0L) : this.pointer.getString(0L, this.encoding);
    }

    public NativeString(String str, boolean z2) {
        this(str, z2 ? WIDE_STRING : Native.getDefaultStringEncoding());
    }

    public NativeString(WString wString) {
        this(wString.toString(), WIDE_STRING);
    }

    public NativeString(String str, String str2) {
        if (str != null) {
            this.encoding = str2;
            if (WIDE_STRING.equals(str2)) {
                StringMemory stringMemory = new StringMemory((str.length() + 1) * Native.WCHAR_SIZE);
                this.pointer = stringMemory;
                stringMemory.setWideString(0L, str);
                return;
            } else {
                byte[] bytes = Native.getBytes(str, str2);
                StringMemory stringMemory2 = new StringMemory(bytes.length + 1);
                this.pointer = stringMemory2;
                stringMemory2.write(0L, bytes, 0, bytes.length);
                this.pointer.setByte(bytes.length, (byte) 0);
                return;
            }
        }
        throw new NullPointerException("String must not be null");
    }
}
