package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class KeylineStateList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeylineState f80389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f80390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f80391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f80392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float[] f80393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f80394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f80395g;

    private KeylineStateList(KeylineState keylineState, List list, List list2) {
        this.f80389a = keylineState;
        this.f80390b = Collections.unmodifiableList(list);
        this.f80391c = Collections.unmodifiableList(list2);
        float f3 = ((KeylineState) list.get(list.size() - 1)).c().f80381a - keylineState.c().f80381a;
        this.f80394f = f3;
        float f4 = keylineState.j().f80381a - ((KeylineState) list2.get(list2.size() - 1)).j().f80381a;
        this.f80395g = f4;
        this.f80392d = m(f3, list, true);
        this.f80393e = m(f4, list2, false);
    }

    private KeylineState a(List list, float f3, float[] fArr) {
        float[] fArrO = o(list, f3, fArr);
        return fArrO[0] >= 0.5f ? (KeylineState) list.get((int) fArrO[2]) : (KeylineState) list.get((int) fArrO[1]);
    }

    private static int b(KeylineState keylineState, float f3) {
        for (int i3 = keylineState.i(); i3 < keylineState.g().size(); i3++) {
            if (f3 == ((KeylineState.Keyline) keylineState.g().get(i3)).f80383c) {
                return i3;
            }
        }
        return keylineState.g().size() - 1;
    }

    private static int c(KeylineState keylineState) {
        for (int i3 = 0; i3 < keylineState.g().size(); i3++) {
            if (!((KeylineState.Keyline) keylineState.g().get(i3)).f80385e) {
                return i3;
            }
        }
        return -1;
    }

    private static int d(KeylineState keylineState, float f3) {
        for (int iB = keylineState.b() - 1; iB >= 0; iB--) {
            if (f3 == ((KeylineState.Keyline) keylineState.g().get(iB)).f80383c) {
                return iB;
            }
        }
        return 0;
    }

    private static int e(KeylineState keylineState) {
        for (int size = keylineState.g().size() - 1; size >= 0; size--) {
            if (!((KeylineState.Keyline) keylineState.g().get(size)).f80385e) {
                return size;
            }
        }
        return -1;
    }

    static KeylineStateList f(Carousel carousel, KeylineState keylineState, float f3, float f4, float f5) {
        return new KeylineStateList(keylineState, p(carousel, keylineState, f3, f4), n(carousel, keylineState, f3, f5));
    }

    private static float[] m(float f3, List list, boolean z2) {
        int size = list.size();
        float[] fArr = new float[size];
        int i3 = 1;
        while (i3 < size) {
            int i4 = i3 - 1;
            KeylineState keylineState = (KeylineState) list.get(i4);
            KeylineState keylineState2 = (KeylineState) list.get(i3);
            fArr[i3] = i3 == size + (-1) ? 1.0f : fArr[i4] + ((z2 ? keylineState2.c().f80381a - keylineState.c().f80381a : keylineState.j().f80381a - keylineState2.j().f80381a) / f3);
            i3++;
        }
        return fArr;
    }

    private static List n(Carousel carousel, KeylineState keylineState, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iE = e(keylineState);
        float fC = carousel.b() ? carousel.c() : carousel.d();
        if (!r(carousel, keylineState) && iE != -1) {
            int i3 = iE - keylineState.i();
            float f5 = keylineState.c().f80382b - (keylineState.c().f80384d / 2.0f);
            if (i3 <= 0 && keylineState.h().f80386f > 0.0f) {
                arrayList.add(v(keylineState, f5 - keylineState.h().f80386f, fC));
                return arrayList;
            }
            int i4 = 0;
            float f6 = 0.0f;
            while (i4 < i3) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i5 = iE - i4;
                float f7 = f6 + ((KeylineState.Keyline) keylineState.g().get(i5)).f80386f;
                int i6 = i5 + 1;
                KeylineState keylineStateT = t(keylineState2, iE, i6 < keylineState.g().size() ? d(keylineState2, ((KeylineState.Keyline) keylineState.g().get(i6)).f80383c) + 1 : 0, f5 - f7, keylineState.b() + i4 + 1, keylineState.i() + i4 + 1, fC);
                if (i4 == i3 - 1 && f4 > 0.0f) {
                    keylineStateT = u(keylineStateT, f4, fC, false, f3);
                }
                arrayList.add(keylineStateT);
                i4++;
                f6 = f7;
            }
        } else if (f4 > 0.0f) {
            arrayList.add(u(keylineState, f4, fC, false, f3));
        }
        return arrayList;
    }

    private static float[] o(List list, float f3, float[] fArr) {
        int size = list.size();
        float f4 = fArr[0];
        int i3 = 1;
        while (i3 < size) {
            float f5 = fArr[i3];
            if (f3 <= f5) {
                return new float[]{AnimationUtils.b(0.0f, 1.0f, f4, f5, f3), i3 - 1, i3};
            }
            i3++;
            f4 = f5;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List p(Carousel carousel, KeylineState keylineState, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iC = c(keylineState);
        float fC = carousel.b() ? carousel.c() : carousel.d();
        if (!q(keylineState) && iC != -1) {
            int iB = keylineState.b() - iC;
            float f5 = keylineState.c().f80382b - (keylineState.c().f80384d / 2.0f);
            if (iB <= 0 && keylineState.a().f80386f > 0.0f) {
                arrayList.add(v(keylineState, f5 + keylineState.a().f80386f, fC));
                return arrayList;
            }
            int i3 = 0;
            float f6 = 0.0f;
            while (i3 < iB) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i4 = iC + i3;
                int size = keylineState.g().size() - 1;
                float f7 = f6 + ((KeylineState.Keyline) keylineState.g().get(i4)).f80386f;
                int i5 = i4 - 1;
                if (i5 >= 0) {
                    size = b(keylineState2, ((KeylineState.Keyline) keylineState.g().get(i5)).f80383c) - 1;
                }
                KeylineState keylineStateT = t(keylineState2, iC, size, f5 + f7, (keylineState.b() - i3) - 1, (keylineState.i() - i3) - 1, fC);
                if (i3 == iB - 1 && f4 > 0.0f) {
                    keylineStateT = u(keylineStateT, f4, fC, true, f3);
                }
                arrayList.add(keylineStateT);
                i3++;
                f6 = f7;
            }
        } else if (f4 > 0.0f) {
            arrayList.add(u(keylineState, f4, fC, true, f3));
        }
        return arrayList;
    }

    private static boolean q(KeylineState keylineState) {
        return keylineState.a().f80382b - (keylineState.a().f80384d / 2.0f) >= 0.0f && keylineState.a() == keylineState.d();
    }

    private static boolean r(Carousel carousel, KeylineState keylineState) {
        int iD = carousel.d();
        if (carousel.b()) {
            iD = carousel.c();
        }
        return keylineState.h().f80382b + (keylineState.h().f80384d / 2.0f) <= ((float) iD) && keylineState.h() == keylineState.k();
    }

    private static KeylineState s(List list, float f3, float[] fArr) {
        float[] fArrO = o(list, f3, fArr);
        return KeylineState.m((KeylineState) list.get((int) fArrO[1]), (KeylineState) list.get((int) fArrO[2]), fArrO[0]);
    }

    private static KeylineState t(KeylineState keylineState, int i3, int i4, float f3, int i5, int i6, float f4) {
        ArrayList arrayList = new ArrayList(keylineState.g());
        arrayList.add(i4, (KeylineState.Keyline) arrayList.remove(i3));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.f(), f4);
        int i7 = 0;
        while (i7 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i7);
            float f5 = keyline.f80384d;
            builder.e(f3 + (f5 / 2.0f), keyline.f80383c, f5, i7 >= i5 && i7 <= i6, keyline.f80385e, keyline.f80386f);
            f3 += keyline.f80384d;
            i7++;
        }
        return builder.i();
    }

    private static KeylineState u(KeylineState keylineState, float f3, float f4, boolean z2, float f5) {
        ArrayList arrayList = new ArrayList(keylineState.g());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.f(), f4);
        float fL = f3 / keylineState.l();
        float f6 = z2 ? f3 : 0.0f;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i3);
            if (keyline.f80385e) {
                builder.e(keyline.f80382b, keyline.f80383c, keyline.f80384d, false, true, keyline.f80386f);
            } else {
                boolean z3 = i3 >= keylineState.b() && i3 <= keylineState.i();
                float f7 = keyline.f80384d - fL;
                float fB = CarouselStrategy.b(f7, keylineState.f(), f5);
                float f8 = (f7 / 2.0f) + f6;
                float f9 = f8 - keyline.f80382b;
                builder.f(f8, fB, f7, z3, false, keyline.f80386f, z2 ? f9 : 0.0f, z2 ? 0.0f : f9);
                f6 += f7;
            }
            i3++;
        }
        return builder.i();
    }

    private static KeylineState v(KeylineState keylineState, float f3, float f4) {
        return t(keylineState, 0, 0, f3, keylineState.b(), keylineState.i(), f4);
    }

    KeylineState g() {
        return this.f80389a;
    }

    KeylineState h() {
        return (KeylineState) this.f80391c.get(r0.size() - 1);
    }

    Map i(int i3, int i4, int i5, boolean z2) {
        float f3 = this.f80389a.f();
        HashMap map = new HashMap();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= i3) {
                break;
            }
            int i8 = z2 ? (i3 - i6) - 1 : i6;
            if (i8 * f3 * (z2 ? -1 : 1) > i5 - this.f80395g || i6 >= i3 - this.f80391c.size()) {
                Integer numValueOf = Integer.valueOf(i8);
                List list = this.f80391c;
                map.put(numValueOf, (KeylineState) list.get(MathUtils.b(i7, 0, list.size() - 1)));
                i7++;
            }
            i6++;
        }
        int i9 = 0;
        for (int i10 = i3 - 1; i10 >= 0; i10--) {
            int i11 = z2 ? (i3 - i10) - 1 : i10;
            if (i11 * f3 * (z2 ? -1 : 1) < i4 + this.f80394f || i10 < this.f80390b.size()) {
                Integer numValueOf2 = Integer.valueOf(i11);
                List list2 = this.f80390b;
                map.put(numValueOf2, (KeylineState) list2.get(MathUtils.b(i9, 0, list2.size() - 1)));
                i9++;
            }
        }
        return map;
    }

    public KeylineState j(float f3, float f4, float f5) {
        return k(f3, f4, f5, false);
    }

    KeylineState k(float f3, float f4, float f5, boolean z2) {
        float fB;
        List list;
        float[] fArr;
        float f6 = this.f80394f + f4;
        float f7 = f5 - this.f80395g;
        float f8 = l().a().f80387g;
        float f9 = h().h().f80388h;
        if (this.f80394f == f8) {
            f6 += f8;
        }
        if (this.f80395g == f9) {
            f7 -= f9;
        }
        if (f3 < f6) {
            fB = AnimationUtils.b(1.0f, 0.0f, f4, f6, f3);
            list = this.f80390b;
            fArr = this.f80392d;
        } else {
            if (f3 <= f7) {
                return this.f80389a;
            }
            fB = AnimationUtils.b(0.0f, 1.0f, f7, f5, f3);
            list = this.f80391c;
            fArr = this.f80393e;
        }
        return z2 ? a(list, fB, fArr) : s(list, fB, fArr);
    }

    KeylineState l() {
        return (KeylineState) this.f80390b.get(r0.size() - 1);
    }
}
