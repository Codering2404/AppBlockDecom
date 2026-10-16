package com.sun.jna;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class StructureWriteContext extends ToNativeContext {
    private Field field;
    private Structure struct;

    StructureWriteContext(Structure structure, Field field) {
        this.struct = structure;
        this.field = field;
    }

    public Field getField() {
        return this.field;
    }

    public Structure getStructure() {
        return this.struct;
    }
}
