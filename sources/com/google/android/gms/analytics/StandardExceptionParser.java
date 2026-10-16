package com.google.android.gms.analytics;

import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class StandardExceptionParser implements ExceptionParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TreeSet f70877a;

    @Override // com.google.android.gms.analytics.ExceptionParser
    public String a(String str, Throwable th) {
        return d(c(th), b(c(th)), str);
    }

    protected StackTraceElement b(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || (stackTrace.length) == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator it = this.f70877a.iterator();
            while (it.hasNext()) {
                if (className.startsWith((String) it.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    protected Throwable c(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    protected String d(Throwable th, StackTraceElement stackTraceElement, String str) {
        int length;
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getSimpleName());
        if (stackTraceElement != null) {
            String[] strArrSplit = stackTraceElement.getClassName().split("\\.");
            sb.append(String.format(" (@%s:%s:%s)", (strArrSplit == null || (length = strArrSplit.length) <= 0) ? "unknown" : strArrSplit[length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
        }
        if (str != null) {
            sb.append(String.format(" {%s}", str));
        }
        return sb.toString();
    }
}
