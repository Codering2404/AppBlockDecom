package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class qg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f62627a = new AtomicReference();

    public static String a() {
        return "iabtechlab-Applovin";
    }

    public static URL b() {
        try {
            return new URL("https://compliance.iabtechnologylab.com/compliance-js/omid-validation-verification-script-v1-APPLOVIN-01102024.js");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        return "iabtechlab.com-omid";
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        InputStream inputStreamA;
        String str = (String) f62627a.get();
        if (StringUtils.isValidString(str)) {
            return str;
        }
        URL urlB = b();
        BufferedReader bufferedReader = null;
        if (urlB == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (((Boolean) jVar.a(sj.f63809z)).booleanValue()) {
            try {
                InputStream inputStreamA2 = jVar.A().a(urlB.toString(), (List) null, false, new u2());
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamA2));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } finally {
                        }
                    }
                    bufferedReader2.close();
                    if (inputStreamA2 != null) {
                        inputStreamA2.close();
                    }
                } finally {
                }
            } catch (Throwable th) {
                jVar.I().a("OpenMeasurementTestParameters", th);
                jVar.D().a("OpenMeasurementTestParameters", "getTestValidationJavaScriptContent", th);
            }
        } else {
            try {
                inputStreamA = jVar.A().a(urlB.toString(), (List) null, false, new u2());
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStreamA));
                    while (true) {
                        try {
                            String line2 = bufferedReader3.readLine();
                            if (line2 == null) {
                                break;
                            }
                            sb.append(line2);
                            sb.append("\n");
                        } catch (Throwable unused) {
                            bufferedReader = bufferedReader3;
                            yp.a(inputStreamA, jVar);
                            yp.a(bufferedReader, jVar);
                        }
                    }
                    yp.a(inputStreamA, jVar);
                    yp.a(bufferedReader3, jVar);
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
                inputStreamA = null;
            }
        }
        String string = sb.toString();
        f62627a.set(string);
        return string;
    }
}
