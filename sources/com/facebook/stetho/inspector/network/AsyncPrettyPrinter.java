package com.facebook.stetho.inspector.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AsyncPrettyPrinter {
    PrettyPrinterDisplayType getPrettifiedType();

    void printTo(PrintWriter printWriter, InputStream inputStream) throws IOException;
}
