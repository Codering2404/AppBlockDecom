package com.applovin.impl;

import android.net.Uri;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class b6 implements n8 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f58556n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 14};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Constructor f58557o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f58558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f58559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f58560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f58561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f58562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f58563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f58564h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f58565i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f58566j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f58568l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f58567k = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f58569m = 112800;

    static {
        Constructor constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.applovin.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", null).invoke(null, null))) {
                constructor = Class.forName("com.applovin.exoplayer2.ext.flac.FlacExtractor").asSubclass(j8.class).getConstructor(Integer.TYPE);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e3) {
            throw new RuntimeException("Error instantiating FLAC extension", e3);
        }
        f58557o = constructor;
    }

    private void a(int i3, List list) {
        switch (i3) {
            case 0:
                list.add(new i());
                return;
            case 1:
                list.add(new l());
                return;
            case 2:
                list.add(new j0((this.f58559c ? 2 : 0) | this.f58560d | (this.f58558b ? 1 : 0)));
                return;
            case 3:
                list.add(new q0((this.f58559c ? 2 : 0) | this.f58561e | (this.f58558b ? 1 : 0)));
                return;
            case 4:
                Constructor constructor = f58557o;
                if (constructor == null) {
                    list.add(new u8(this.f58562f));
                    return;
                }
                try {
                    list.add((j8) constructor.newInstance(Integer.valueOf(this.f58562f)));
                    return;
                } catch (Exception e3) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e3);
                }
            case 5:
                list.add(new d9());
                return;
            case 6:
                list.add(new xc(this.f58563g));
                return;
            case 7:
                list.add(new nf((this.f58559c ? 2 : 0) | this.f58566j | (this.f58558b ? 1 : 0)));
                return;
            case 8:
                list.add(new i9(this.f58565i));
                list.add(new of(this.f58564h));
                return;
            case 9:
                list.add(new gg());
                return;
            case 10:
                list.add(new ii());
                return;
            case 11:
                list.add(new cp(this.f58567k, this.f58568l, this.f58569m));
                return;
            case 12:
                list.add(new lr());
                return;
            case 13:
            default:
                return;
            case 14:
                list.add(new xb());
                return;
        }
    }

    @Override // com.applovin.impl.n8
    public synchronized j8[] a() {
        return a(Uri.EMPTY, new HashMap());
    }

    @Override // com.applovin.impl.n8
    public synchronized j8[] a(Uri uri, Map map) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList(14);
            int iA = p8.a(map);
            if (iA != -1) {
                a(iA, arrayList);
            }
            int iA2 = p8.a(uri);
            if (iA2 != -1 && iA2 != iA) {
                a(iA2, arrayList);
            }
            for (int i3 : f58556n) {
                if (i3 != iA && i3 != iA2) {
                    a(i3, arrayList);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return (j8[]) arrayList.toArray(new j8[arrayList.size()]);
    }
}
