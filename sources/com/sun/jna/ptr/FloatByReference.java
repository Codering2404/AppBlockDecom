package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class FloatByReference extends ByReference {
    public FloatByReference() {
        this(0.0f);
    }

    public float getValue() {
        return getPointer().getFloat(0L);
    }

    public void setValue(float f3) {
        getPointer().setFloat(0L, f3);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("float@0x%x=%s", Long.valueOf(Pointer.nativeValue(getPointer())), Float.valueOf(getValue()));
    }

    public FloatByReference(float f3) {
        super(4);
        setValue(f3);
    }
}
