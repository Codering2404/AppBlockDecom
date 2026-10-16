package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LongByReference extends ByReference {
    public LongByReference() {
        this(0L);
    }

    public long getValue() {
        return getPointer().getLong(0L);
    }

    public void setValue(long j3) {
        getPointer().setLong(0L, j3);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("long@0x%1$x=0x%2$x (%2$d)", Long.valueOf(Pointer.nativeValue(getPointer())), Long.valueOf(getValue()));
    }

    public LongByReference(long j3) {
        super(8);
        setValue(j3);
    }
}
