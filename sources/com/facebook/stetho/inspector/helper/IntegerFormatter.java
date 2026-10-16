package com.facebook.stetho.inspector.helper;

import android.view.ViewDebug;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class IntegerFormatter {
    private static IntegerFormatter cachedFormatter;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @Override // com.facebook.stetho.inspector.helper.IntegerFormatter
        public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
            if (exportedProperty == null || !exportedProperty.formatToHexString()) {
                return super.format(num, exportedProperty);
            }
            return "0x" + Integer.toHexString(num.intValue());
        }
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                try {
                    if (cachedFormatter == null) {
                        cachedFormatter = new IntegerFormatterWithHex();
                    }
                } finally {
                }
            }
        }
        return cachedFormatter;
    }

    public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }

    private IntegerFormatter() {
    }
}
