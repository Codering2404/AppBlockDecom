package com.sun.jna.win32;

import com.sun.jna.Callback;
import com.sun.jna.FunctionMapper;
import com.sun.jna.Library;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public interface StdCallLibrary extends Library, StdCall {
    public static final FunctionMapper FUNCTION_MAPPER = new StdCallFunctionMapper();
    public static final int STDCALL_CONVENTION = 63;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface StdCallCallback extends Callback, StdCall {
    }
}
