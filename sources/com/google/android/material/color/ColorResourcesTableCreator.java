package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.common.Utf8Charset;
import com.sun.jna.Function;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ColorResourcesTableCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte f80523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PackageInfo f80524b = new PackageInfo(1, "android");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator f80525c = new Comparator<ColorResource>() { // from class: com.google.android.material.color.ColorResourcesTableCreator.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ColorResource colorResource, ColorResource colorResource2) {
            return colorResource.f80528c - colorResource2.f80528c;
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ColorResource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte f80526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte f80527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final short f80528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f80529d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f80530e;

        ColorResource(int i3, String str, int i4) {
            this.f80529d = str;
            this.f80530e = i4;
            this.f80528c = (short) (65535 & i3);
            this.f80527b = (byte) ((i3 >> 16) & 255);
            this.f80526a = (byte) ((i3 >> 24) & 255);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PackageChunk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResChunkHeader f80531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PackageInfo f80532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringPoolChunk f80533c = new StringPoolChunk(false, "?1", "?2", "?3", "?4", "?5", "color");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final StringPoolChunk f80534d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final TypeSpecChunk f80535e;

        PackageChunk(PackageInfo packageInfo, List list) {
            this.f80532b = packageInfo;
            String[] strArr = new String[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                strArr[i3] = ((ColorResource) list.get(i3)).f80529d;
            }
            this.f80534d = new StringPoolChunk(true, strArr);
            this.f80535e = new TypeSpecChunk(list);
            this.f80531a = new ResChunkHeader((short) 512, (short) 288, a());
        }

        int a() {
            return this.f80533c.a() + 288 + this.f80534d.a() + this.f80535e.b();
        }

        void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f80531a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80532b.f80536a));
            char[] charArray = this.f80532b.f80537b.toCharArray();
            for (int i3 = 0; i3 < 128; i3++) {
                if (i3 < charArray.length) {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h(charArray[i3]));
                } else {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h((char) 0));
                }
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80533c.a() + 288));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            this.f80533c.c(byteArrayOutputStream);
            this.f80534d.c(byteArrayOutputStream);
            this.f80535e.c(byteArrayOutputStream);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PackageInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f80536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f80537b;

        PackageInfo(int i3, String str) {
            this.f80536a = i3;
            this.f80537b = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResChunkHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final short f80538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final short f80539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f80540c;

        ResChunkHeader(short s2, short s3, int i3) {
            this.f80538a = s2;
            this.f80539b = s3;
            this.f80540c = i3;
        }

        void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f80538a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f80539b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80540c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResEntry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f80541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f80542b;

        ResEntry(int i3, int i4) {
            this.f80541a = i3;
            this.f80542b = i4;
        }

        void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 8));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 2));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80541a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k((short) 8));
            byteArrayOutputStream.write(new byte[]{0, Ascii.FS});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80542b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResTable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResChunkHeader f80543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f80544b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f80546d = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final StringPoolChunk f80545c = new StringPoolChunk(new String[0]);

        ResTable(Map map) {
            this.f80544b = map.size();
            for (Map.Entry entry : map.entrySet()) {
                List list = (List) entry.getValue();
                Collections.sort(list, ColorResourcesTableCreator.f80525c);
                this.f80546d.add(new PackageChunk((PackageInfo) entry.getKey(), list));
            }
            this.f80543a = new ResChunkHeader((short) 2, (short) 12, a());
        }

        private int a() {
            Iterator it = this.f80546d.iterator();
            int iA = 0;
            while (it.hasNext()) {
                iA += ((PackageChunk) it.next()).a();
            }
            return this.f80545c.a() + 12 + iA;
        }

        void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f80543a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80544b));
            this.f80545c.c(byteArrayOutputStream);
            Iterator it = this.f80546d.iterator();
            while (it.hasNext()) {
                ((PackageChunk) it.next()).b(byteArrayOutputStream);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class StringPoolChunk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResChunkHeader f80547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f80548b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f80549c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f80550d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f80551e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final List f80552f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final List f80553g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final List f80554h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final List f80555i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final boolean f80556j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f80557k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final int f80558l;

        StringPoolChunk(String... strArr) {
            this(false, strArr);
        }

        private Pair b(String str) {
            return new Pair(this.f80556j ? ColorResourcesTableCreator.m(str) : ColorResourcesTableCreator.l(str), Collections.EMPTY_LIST);
        }

        int a() {
            return this.f80558l;
        }

        void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f80547a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80548b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80549c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80556j ? Function.MAX_NARGS : 0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80550d));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80551e));
            Iterator it = this.f80552f.iterator();
            while (it.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(((Integer) it.next()).intValue()));
            }
            Iterator it2 = this.f80553g.iterator();
            while (it2.hasNext()) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(((Integer) it2.next()).intValue()));
            }
            Iterator it3 = this.f80554h.iterator();
            while (it3.hasNext()) {
                byteArrayOutputStream.write((byte[]) it3.next());
            }
            int i3 = this.f80557k;
            if (i3 > 0) {
                byteArrayOutputStream.write(new byte[i3]);
            }
            Iterator it4 = this.f80555i.iterator();
            while (it4.hasNext()) {
                Iterator it5 = ((List) it4.next()).iterator();
                while (it5.hasNext()) {
                    ((StringStyledSpan) it5.next()).b(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(-1));
            }
        }

        StringPoolChunk(boolean z2, String... strArr) {
            this.f80552f = new ArrayList();
            this.f80553g = new ArrayList();
            this.f80554h = new ArrayList();
            this.f80555i = new ArrayList();
            this.f80556j = z2;
            int length = 0;
            for (String str : strArr) {
                Pair pairB = b(str);
                this.f80552f.add(Integer.valueOf(length));
                Object obj = pairB.first;
                length += ((byte[]) obj).length;
                this.f80554h.add((byte[]) obj);
                this.f80555i.add((List) pairB.second);
            }
            int size = 0;
            for (List<StringStyledSpan> list : this.f80555i) {
                for (StringStyledSpan stringStyledSpan : list) {
                    this.f80552f.add(Integer.valueOf(length));
                    length += stringStyledSpan.f80559a.length;
                    this.f80554h.add(stringStyledSpan.f80559a);
                }
                this.f80553g.add(Integer.valueOf(size));
                size += (list.size() * 12) + 4;
            }
            int i3 = length % 4;
            int i4 = i3 == 0 ? 0 : 4 - i3;
            this.f80557k = i4;
            int size2 = this.f80554h.size();
            this.f80548b = size2;
            this.f80549c = this.f80554h.size() - strArr.length;
            boolean z3 = this.f80554h.size() - strArr.length > 0;
            if (!z3) {
                this.f80553g.clear();
                this.f80555i.clear();
            }
            int size3 = (size2 * 4) + 28 + (this.f80553g.size() * 4);
            this.f80550d = size3;
            int i5 = length + i4;
            this.f80551e = z3 ? size3 + i5 : 0;
            int i6 = size3 + i5 + (z3 ? size : 0);
            this.f80558l = i6;
            this.f80547a = new ResChunkHeader((short) 1, (short) 28, i6);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class StringStyledSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private byte[] f80559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f80560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f80561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f80562d;

        void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80560b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80561c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80562d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TypeChunk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResChunkHeader f80563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f80564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f80565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int[] f80566d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ResEntry[] f80567e;

        TypeChunk(List list, Set set, int i3) {
            byte[] bArr = new byte[64];
            this.f80565c = bArr;
            this.f80564b = i3;
            bArr[0] = 64;
            this.f80567e = new ResEntry[list.size()];
            for (int i4 = 0; i4 < list.size(); i4++) {
                this.f80567e[i4] = new ResEntry(i4, ((ColorResource) list.get(i4)).f80530e);
            }
            this.f80566d = new int[i3];
            int i5 = 0;
            for (short s2 = 0; s2 < i3; s2 = (short) (s2 + 1)) {
                if (set.contains(Short.valueOf(s2))) {
                    this.f80566d[s2] = i5;
                    i5 += 16;
                } else {
                    this.f80566d[s2] = -1;
                }
            }
            this.f80563a = new ResChunkHeader((short) 513, (short) 84, a());
        }

        private int b() {
            return c() + 84;
        }

        private int c() {
            return this.f80566d.length * 4;
        }

        int a() {
            return b() + (this.f80567e.length * 16);
        }

        void d(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f80563a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f80523a, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80564b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(b()));
            byteArrayOutputStream.write(this.f80565c);
            for (int i3 : this.f80566d) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(i3));
            }
            for (ResEntry resEntry : this.f80567e) {
                resEntry.a(byteArrayOutputStream);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TypeSpecChunk {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResChunkHeader f80568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f80569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f80570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TypeChunk f80571d;

        TypeSpecChunk(List list) {
            this.f80569b = ((ColorResource) list.get(list.size() - 1)).f80528c + 1;
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(Short.valueOf(((ColorResource) it.next()).f80528c));
            }
            this.f80570c = new int[this.f80569b];
            for (short s2 = 0; s2 < this.f80569b; s2 = (short) (s2 + 1)) {
                if (hashSet.contains(Short.valueOf(s2))) {
                    this.f80570c[s2] = 1073741824;
                }
            }
            this.f80568a = new ResChunkHeader((short) 514, (short) 16, a());
            this.f80571d = new TypeChunk(list, hashSet, this.f80569b);
        }

        private int a() {
            return (this.f80569b * 4) + 16;
        }

        int b() {
            return a() + this.f80571d.a();
        }

        void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f80568a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f80523a, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f80569b));
            for (int i3 : this.f80570c) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(i3));
            }
            this.f80571d.d(byteArrayOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] h(char c3) {
        return new byte[]{(byte) (c3 & 255), (byte) ((c3 >> '\b') & 255)};
    }

    static byte[] i(Context context, Map map) throws IOException {
        PackageInfo packageInfo;
        if (map.entrySet().isEmpty()) {
            throw new IllegalArgumentException("No color resources provided for harmonization.");
        }
        PackageInfo packageInfo2 = new PackageInfo(127, context.getPackageName());
        HashMap map2 = new HashMap();
        ColorResource colorResource = null;
        for (Map.Entry entry : map.entrySet()) {
            ColorResource colorResource2 = new ColorResource(((Integer) entry.getKey()).intValue(), context.getResources().getResourceName(((Integer) entry.getKey()).intValue()), ((Integer) entry.getValue()).intValue());
            if (!context.getResources().getResourceTypeName(((Integer) entry.getKey()).intValue()).equals("color")) {
                throw new IllegalArgumentException("Non color resource found: name=" + colorResource2.f80529d + ", typeId=" + Integer.toHexString(colorResource2.f80527b & 255));
            }
            if (colorResource2.f80526a == 1) {
                packageInfo = f80524b;
            } else {
                if (colorResource2.f80526a != 127) {
                    throw new IllegalArgumentException("Not supported with unknown package id: " + ((int) colorResource2.f80526a));
                }
                packageInfo = packageInfo2;
            }
            if (!map2.containsKey(packageInfo)) {
                map2.put(packageInfo, new ArrayList());
            }
            ((List) map2.get(packageInfo)).add(colorResource2);
            colorResource = colorResource2;
        }
        byte b3 = colorResource.f80527b;
        f80523a = b3;
        if (b3 == 0) {
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new ResTable(map2).b(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] j(int i3) {
        return new byte[]{(byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] k(short s2) {
        return new byte[]{(byte) (s2 & 255), (byte) ((s2 >> 8) & 255)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] l(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[length + 4];
        byte[] bArrK = k((short) charArray.length);
        bArr[0] = bArrK[0];
        bArr[1] = bArrK[1];
        for (int i3 = 0; i3 < charArray.length; i3++) {
            byte[] bArrH = h(charArray[i3]);
            int i4 = i3 * 2;
            bArr[i4 + 2] = bArrH[0];
            bArr[i4 + 3] = bArrH[1];
        }
        bArr[length + 2] = 0;
        bArr[length + 3] = 0;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] m(String str) {
        byte[] bytes = str.getBytes(Charset.forName(Utf8Charset.NAME));
        byte length = (byte) bytes.length;
        int length2 = bytes.length;
        byte[] bArr = new byte[length2 + 3];
        System.arraycopy(bytes, 0, bArr, 2, length);
        bArr[1] = length;
        bArr[0] = length;
        bArr[length2 + 2] = 0;
        return bArr;
    }
}
