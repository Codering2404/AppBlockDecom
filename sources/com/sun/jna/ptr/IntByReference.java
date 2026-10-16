package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class IntByReference extends ByReference {
    public IntByReference() {
        this(0);
    }

    public int getValue() {
        return getPointer().getInt(0L);
    }

    public void setValue(int i3) {
        getPointer().setInt(0L, i3);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("int@0x%1$x=0x%2$x (%2$d)", Long.valueOf(Pointer.nativeValue(getPointer())), Integer.valueOf(getValue()));
    }

    public IntByReference(int i3) {
        super(4);
        setValue(i3);
    }
}
