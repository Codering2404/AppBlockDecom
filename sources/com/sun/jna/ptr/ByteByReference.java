package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class ByteByReference extends ByReference {
    public ByteByReference() {
        this((byte) 0);
    }

    public byte getValue() {
        return getPointer().getByte(0L);
    }

    public void setValue(byte b3) {
        getPointer().setByte(0L, b3);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("byte@0x%1$x=0x%2$x (%2$d)", Long.valueOf(Pointer.nativeValue(getPointer())), Byte.valueOf(getValue()));
    }

    public ByteByReference(byte b3) {
        super(1);
        setValue(b3);
    }
}
