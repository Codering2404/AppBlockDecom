package com.sun.jna.ptr;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ByReference extends PointerType {
    protected ByReference(int i3) {
        setPointer(new Memory(i3));
    }

    @Override // com.sun.jna.PointerType
    public String toString() {
        try {
            Object objInvoke = getClass().getMethod("getValue", null).invoke(this, null);
            return objInvoke == null ? String.format("null@0x%x", Long.valueOf(Pointer.nativeValue(getPointer()))) : String.format("%s@0x%x=%s", objInvoke.getClass().getSimpleName(), Long.valueOf(Pointer.nativeValue(getPointer())), objInvoke);
        } catch (Exception e3) {
            return String.format("ByReference Contract violated - %s#getValue raised exception: %s", getClass().getName(), e3.getMessage());
        }
    }
}
