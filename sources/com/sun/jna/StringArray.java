package com.sun.jna;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class StringArray extends Memory implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives;
    private Object[] original;

    public StringArray(String[] strArr) {
        this(strArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object[]] */
    @Override // com.sun.jna.Function.PostCallRead
    public void read() {
        ?? wideString;
        boolean z2 = this.original instanceof WString[];
        boolean zEquals = "--WIDE-STRING--".equals(this.encoding);
        for (int i3 = 0; i3 < this.original.length; i3++) {
            Pointer pointer = getPointer(Native.POINTER_SIZE * i3);
            if (pointer != null) {
                wideString = zEquals ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
                if (z2) {
                    wideString = new WString(wideString);
                }
            } else {
                wideString = 0;
            }
            this.original[i3] = wideString;
        }
    }

    @Override // com.sun.jna.Memory, com.sun.jna.Pointer
    public String toString() {
        return ("--WIDE-STRING--".equals(this.encoding) ? "const wchar_t*[]" : "const char*[]") + Arrays.asList(this.original);
    }

    public StringArray(String[] strArr, boolean z2) {
        this((Object[]) strArr, z2 ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
    }

    public StringArray(String[] strArr, String str) {
        this((Object[]) strArr, str);
    }

    public StringArray(WString[] wStringArr) {
        this(wStringArr, "--WIDE-STRING--");
    }

    private StringArray(Object[] objArr, String str) {
        super((objArr.length + 1) * Native.POINTER_SIZE);
        this.natives = new ArrayList();
        this.original = objArr;
        this.encoding = str;
        int i3 = 0;
        while (true) {
            Pointer pointer = null;
            if (i3 < objArr.length) {
                Object obj = objArr[i3];
                if (obj != null) {
                    NativeString nativeString = new NativeString(obj.toString(), str);
                    this.natives.add(nativeString);
                    pointer = nativeString.getPointer();
                }
                setPointer(Native.POINTER_SIZE * i3, pointer);
                i3++;
            } else {
                setPointer(Native.POINTER_SIZE * objArr.length, null);
                return;
            }
        }
    }
}
