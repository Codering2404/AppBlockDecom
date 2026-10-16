package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class TzdbZoneRulesProvider extends ZoneRulesProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f146609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentNavigableMap f146610d = new ConcurrentSkipListMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Set f146611e = new CopyOnWriteArraySet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Version {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f146612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f146613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final short[] f146614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicReferenceArray f146615d;

        Version(String str, String[] strArr, short[] sArr, AtomicReferenceArray atomicReferenceArray) {
            this.f146615d = atomicReferenceArray;
            this.f146612a = str;
            this.f146613b = strArr;
            this.f146614c = sArr;
        }

        ZoneRules b(short s2) {
            Object objA = this.f146615d.get(s2);
            if (objA instanceof byte[]) {
                objA = Ser.a(new DataInputStream(new ByteArrayInputStream((byte[]) objA)));
                this.f146615d.set(s2, objA);
            }
            return (ZoneRules) objA;
        }

        ZoneRules c(String str) {
            int iBinarySearch = Arrays.binarySearch(this.f146613b, str);
            if (iBinarySearch < 0) {
                return null;
            }
            try {
                return b(this.f146614c[iBinarySearch]);
            } catch (Exception e3) {
                throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + str + ", version: " + this.f146612a, e3);
            }
        }

        public String toString() {
            return this.f146612a;
        }
    }

    public TzdbZoneRulesProvider() {
        if (!i(ZoneRulesProvider.class.getClassLoader())) {
            throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
        }
    }

    private boolean h(InputStream inputStream) {
        boolean z2 = false;
        for (Version version : k(inputStream)) {
            Version version2 = (Version) this.f146610d.putIfAbsent(version.f146612a, version);
            if (version2 != null && !version2.f146612a.equals(version.f146612a)) {
                throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + version.f146612a);
            }
            z2 = true;
        }
        return z2;
    }

    private boolean i(ClassLoader classLoader) {
        URL url = null;
        try {
            Enumeration<URL> resources = classLoader.getResources("org/threeten/bp/TZDB.dat");
            boolean zJ = false;
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                try {
                    zJ |= j(urlNextElement);
                    url = urlNextElement;
                } catch (Exception e3) {
                    e = e3;
                    url = urlNextElement;
                    throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + url, e);
                }
            }
            return zJ;
        } catch (Exception e4) {
            e = e4;
        }
    }

    private boolean j(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        if (!this.f146611e.add(url.toExternalForm())) {
            return false;
        }
        try {
            inputStreamOpenStream = url.openStream();
            try {
                boolean zH = h(inputStreamOpenStream);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                return zH;
            } catch (Throwable th) {
                th = th;
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenStream = null;
        }
    }

    private Iterable k(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        if (dataInputStream.readByte() != 1) {
            throw new StreamCorruptedException("File format not recognised");
        }
        if (!"TZDB".equals(dataInputStream.readUTF())) {
            throw new StreamCorruptedException("File format not recognised");
        }
        int i3 = dataInputStream.readShort();
        String[] strArr = new String[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            strArr[i4] = dataInputStream.readUTF();
        }
        int i5 = dataInputStream.readShort();
        String[] strArr2 = new String[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            strArr2[i6] = dataInputStream.readUTF();
        }
        this.f146609c = Arrays.asList(strArr2);
        int i7 = dataInputStream.readShort();
        Object[] objArr = new Object[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            byte[] bArr = new byte[dataInputStream.readShort()];
            dataInputStream.readFully(bArr);
            objArr[i8] = bArr;
        }
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(objArr);
        HashSet hashSet = new HashSet(i3);
        for (int i9 = 0; i9 < i3; i9++) {
            int i10 = dataInputStream.readShort();
            String[] strArr3 = new String[i10];
            short[] sArr = new short[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                strArr3[i11] = strArr2[dataInputStream.readShort()];
                sArr[i11] = dataInputStream.readShort();
            }
            hashSet.add(new Version(strArr[i9], strArr3, sArr, atomicReferenceArray));
        }
        return hashSet;
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected ZoneRules d(String str, boolean z2) {
        Jdk8Methods.i(str, "zoneId");
        ZoneRules zoneRulesC = ((Version) this.f146610d.lastEntry().getValue()).c(str);
        if (zoneRulesC != null) {
            return zoneRulesC;
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected Set e() {
        return new HashSet(this.f146609c);
    }

    public String toString() {
        return "TZDB";
    }

    public TzdbZoneRulesProvider(InputStream inputStream) {
        try {
            h(inputStream);
        } catch (Exception e3) {
            throw new ZoneRulesException("Unable to load TZDB time-zone rules", e3);
        }
    }
}
