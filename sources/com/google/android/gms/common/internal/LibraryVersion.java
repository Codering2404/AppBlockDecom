package com.google.android.gms.common.internal;

import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LibraryVersion {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final GmsLogger f71998b = new GmsLogger("LibraryVersion", "");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LibraryVersion f71999c = new LibraryVersion();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f72000a = new ConcurrentHashMap();

    protected LibraryVersion() {
    }

    public static LibraryVersion a() {
        return f71999c;
    }

    public String b(String str) throws Throwable {
        String str2;
        InputStream resourceAsStream;
        Preconditions.h(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.f72000a;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        String property = null;
        inputStream = null;
        try {
            try {
                resourceAsStream = LibraryVersion.class.getResourceAsStream(String.format("/%s.properties", str));
            } catch (IOException e3) {
                e = e3;
                str2 = null;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (resourceAsStream != null) {
                properties.load(resourceAsStream);
                property = properties.getProperty("version", null);
                GmsLogger gmsLogger = f71998b;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12 + String.valueOf(property).length());
                sb.append(str);
                sb.append(" version is ");
                sb.append(property);
                gmsLogger.d("LibraryVersion", sb.toString());
            } else {
                GmsLogger gmsLogger2 = f71998b;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 43);
                sb2.append("Failed to get app version for libraryName: ");
                sb2.append(str);
                gmsLogger2.e("LibraryVersion", sb2.toString());
            }
        } catch (IOException e4) {
            e = e4;
            str2 = property;
            inputStream = resourceAsStream;
            GmsLogger gmsLogger3 = f71998b;
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 43);
            sb3.append("Failed to get app version for libraryName: ");
            sb3.append(str);
            gmsLogger3.c("LibraryVersion", sb3.toString(), e);
            resourceAsStream = inputStream;
            property = str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = resourceAsStream;
            if (inputStream != null) {
                IOUtils.a(inputStream);
            }
            throw th;
        }
        if (resourceAsStream != null) {
            IOUtils.a(resourceAsStream);
        }
        if (property == null) {
            f71998b.b("LibraryVersion", ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            property = "UNKNOWN";
        }
        this.f72000a.put(str, property);
        return property;
    }
}
