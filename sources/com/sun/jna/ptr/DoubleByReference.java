package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class DoubleByReference extends ByReference {
    public DoubleByReference() {
        this(0.0d);
    }

    public double getValue() {
        return getPointer().getDouble(0L);
    }

    public void setValue(double d3) {
        getPointer().setDouble(0L, d3);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("double@0x%x=%s", Long.valueOf(Pointer.nativeValue(getPointer())), Double.valueOf(getValue()));
    }

    public DoubleByReference(double d3) {
        super(8);
        setValue(d3);
    }
}
