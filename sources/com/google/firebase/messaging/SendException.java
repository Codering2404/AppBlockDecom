package com.google.firebase.messaging;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class SendException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89451a;

    SendException(String str) {
        super(str);
        this.f89451a = a(str);
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        lowerCase.getClass();
        switch (lowerCase) {
        }
        return 0;
    }
}
