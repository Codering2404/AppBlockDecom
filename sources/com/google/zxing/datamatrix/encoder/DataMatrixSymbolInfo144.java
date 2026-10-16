package com.google.zxing.datamatrix.encoder;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int b(int i3) {
        if (i3 <= 8) {
            return 156;
        }
        return ModuleDescriptor.MODULE_VERSION;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int f() {
        return 10;
    }
}
