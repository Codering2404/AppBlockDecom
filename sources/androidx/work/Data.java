package androidx.work;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Data {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f54508b = Logger.i("Data");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Data f54509c = new Builder().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map f54510a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map f54511a = new HashMap();

        public Data a() throws Throwable {
            Data data = new Data(this.f54511a);
            Data.l(data);
            return data;
        }

        public Builder b(String str, Object obj) {
            if (obj == null) {
                this.f54511a.put(str, null);
                return this;
            }
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                this.f54511a.put(str, obj);
                return this;
            }
            if (cls == boolean[].class) {
                this.f54511a.put(str, Data.a((boolean[]) obj));
                return this;
            }
            if (cls == byte[].class) {
                this.f54511a.put(str, Data.b((byte[]) obj));
                return this;
            }
            if (cls == int[].class) {
                this.f54511a.put(str, Data.e((int[]) obj));
                return this;
            }
            if (cls == long[].class) {
                this.f54511a.put(str, Data.f((long[]) obj));
                return this;
            }
            if (cls == float[].class) {
                this.f54511a.put(str, Data.d((float[]) obj));
                return this;
            }
            if (cls == double[].class) {
                this.f54511a.put(str, Data.c((double[]) obj));
                return this;
            }
            throw new IllegalArgumentException("Key " + str + " has invalid type " + cls);
        }

        public Builder c(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder d(String str, boolean z2) {
            this.f54511a.put(str, Boolean.valueOf(z2));
            return this;
        }

        public Builder e(String str, String str2) {
            this.f54511a.put(str, str2);
            return this;
        }
    }

    public Data(Data data) {
        this.f54510a = new HashMap(data.f54510a);
    }

    public static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i3 = 0; i3 < zArr.length; i3++) {
            boolArr[i3] = Boolean.valueOf(zArr[i3]);
        }
        return boolArr;
    }

    public static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            bArr2[i3] = Byte.valueOf(bArr[i3]);
        }
        return bArr2;
    }

    public static Double[] c(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            dArr2[i3] = Double.valueOf(dArr[i3]);
        }
        return dArr2;
    }

    public static Float[] d(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr2[i3] = Float.valueOf(fArr[i3]);
        }
        return fArr2;
    }

    public static Integer[] e(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            numArr[i3] = Integer.valueOf(iArr[i3]);
        }
        return numArr;
    }

    public static Long[] f(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i3 = 0; i3 < jArr.length; i3++) {
            lArr[i3] = Long.valueOf(jArr[i3]);
        }
        return lArr;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(5:55|5|56|6|(2:8|9))|49|16|53|20|33|34) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        android.util.Log.e(androidx.work.Data.f54508b, "Error in Data#fromByteArray: ", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        android.util.Log.e(androidx.work.Data.f54508b, "Error in Data#fromByteArray: ", r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0031 A[EXC_TOP_SPLITTER, PHI: r3
      0x0031: PHI (r3v8 java.io.ObjectInputStream) = (r3v7 java.io.ObjectInputStream), (r3v10 java.io.ObjectInputStream) binds: [B:31:0x0056, B:7:0x001b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.work.Data g(byte[] r7) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "Error in Data#fromByteArray: "
            int r1 = r7.length
            r2 = 10240(0x2800, float:1.4349E-41)
            if (r1 > r2) goto L76
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r3 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L46 java.lang.ClassNotFoundException -> L4a java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L46 java.lang.ClassNotFoundException -> L4a java.io.IOException -> L4f
            int r7 = r3.readInt()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
        L1b:
            if (r7 <= 0) goto L31
            java.lang.String r4 = r3.readUTF()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            java.lang.Object r5 = r3.readObject()     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            r1.put(r4, r5)     // Catch: java.lang.Throwable -> L2b java.lang.ClassNotFoundException -> L2d java.io.IOException -> L2f
            int r7 = r7 + (-1)
            goto L1b
        L2b:
            r7 = move-exception
            goto L5f
        L2d:
            r7 = move-exception
            goto L51
        L2f:
            r7 = move-exception
            goto L51
        L31:
            r3.close()     // Catch: java.io.IOException -> L35
            goto L3b
        L35:
            r7 = move-exception
            java.lang.String r3 = androidx.work.Data.f54508b
            android.util.Log.e(r3, r0, r7)
        L3b:
            r2.close()     // Catch: java.io.IOException -> L3f
            goto L59
        L3f:
            r7 = move-exception
            java.lang.String r2 = androidx.work.Data.f54508b
            android.util.Log.e(r2, r0, r7)
            goto L59
        L46:
            r1 = move-exception
            r3 = r7
            r7 = r1
            goto L5f
        L4a:
            r3 = move-exception
        L4b:
            r6 = r3
            r3 = r7
            r7 = r6
            goto L51
        L4f:
            r3 = move-exception
            goto L4b
        L51:
            java.lang.String r4 = androidx.work.Data.f54508b     // Catch: java.lang.Throwable -> L2b
            android.util.Log.e(r4, r0, r7)     // Catch: java.lang.Throwable -> L2b
            if (r3 == 0) goto L3b
            goto L31
        L59:
            androidx.work.Data r7 = new androidx.work.Data
            r7.<init>(r1)
            return r7
        L5f:
            if (r3 == 0) goto L6b
            r3.close()     // Catch: java.io.IOException -> L65
            goto L6b
        L65:
            r1 = move-exception
            java.lang.String r3 = androidx.work.Data.f54508b
            android.util.Log.e(r3, r0, r1)
        L6b:
            r2.close()     // Catch: java.io.IOException -> L6f
            goto L75
        L6f:
            r1 = move-exception
            java.lang.String r2 = androidx.work.Data.f54508b
            android.util.Log.e(r2, r0, r1)
        L75:
            throw r7
        L76:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.g(byte[]):androidx.work.Data");
    }

    public static byte[] l(Data data) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
        }
        try {
            objectOutputStream.writeInt(data.k());
            for (Map.Entry entry : data.f54510a.entrySet()) {
                objectOutputStream.writeUTF((String) entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException e4) {
                Log.e(f54508b, "Error in Data#toByteArray: ", e4);
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                Log.e(f54508b, "Error in Data#toByteArray: ", e5);
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException e6) {
            e = e6;
            objectOutputStream2 = objectOutputStream;
            Log.e(f54508b, "Error in Data#toByteArray: ", e);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e7) {
                    Log.e(f54508b, "Error in Data#toByteArray: ", e7);
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e8) {
                Log.e(f54508b, "Error in Data#toByteArray: ", e8);
            }
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException e9) {
                    Log.e(f54508b, "Error in Data#toByteArray: ", e9);
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException e10) {
                Log.e(f54508b, "Error in Data#toByteArray: ", e10);
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Data.class != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> setKeySet = this.f54510a.keySet();
        if (!setKeySet.equals(data.f54510a.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj2 = this.f54510a.get(str);
            Object obj3 = data.f54510a.get(str);
            if (!((obj2 == null || obj3 == null) ? obj2 == obj3 : ((obj2 instanceof Object[]) && (obj3 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3))) {
                return false;
            }
        }
        return true;
    }

    public int h(String str, int i3) {
        Object obj = this.f54510a.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
    }

    public int hashCode() {
        return this.f54510a.hashCode() * 31;
    }

    public Map i() {
        return Collections.unmodifiableMap(this.f54510a);
    }

    public String j(String str) {
        Object obj = this.f54510a.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int k() {
        return this.f54510a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.f54510a.isEmpty()) {
            for (String str : this.f54510a.keySet()) {
                sb.append(str);
                sb.append(" : ");
                Object obj = this.f54510a.get(str);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public Data(Map map) {
        this.f54510a = new HashMap(map);
    }
}
