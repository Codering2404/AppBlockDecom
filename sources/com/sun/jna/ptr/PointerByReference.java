package com.sun.jna.ptr;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class PointerByReference extends ByReference {
    public PointerByReference() {
        this(null);
    }

    public Pointer getValue() {
        return getPointer().getPointer(0L);
    }

    public void setValue(Pointer pointer) {
        getPointer().setPointer(0L, pointer);
    }

    public PointerByReference(Pointer pointer) {
        super(Native.POINTER_SIZE);
        setValue(pointer);
    }
}
