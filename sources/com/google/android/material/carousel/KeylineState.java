package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class KeylineState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f80368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f80369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f80370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f80371d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f80372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f80373b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Keyline f80375d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Keyline f80376e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f80374c = new ArrayList();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f80377f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f80378g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f80379h = 0.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f80380i = -1;

        Builder(float f3, float f4) {
            this.f80372a = f3;
            this.f80373b = f4;
        }

        private static float j(float f3, float f4, int i3, int i4) {
            return (f3 - (i3 * f4)) + (i4 * f4);
        }

        Builder a(float f3, float f4, float f5) {
            return d(f3, f4, f5, false, true);
        }

        Builder b(float f3, float f4, float f5) {
            return c(f3, f4, f5, false);
        }

        Builder c(float f3, float f4, float f5, boolean z2) {
            return d(f3, f4, f5, z2, false);
        }

        Builder d(float f3, float f4, float f5, boolean z2, boolean z3) {
            float fAbs;
            float f6 = f5 / 2.0f;
            float f7 = f3 - f6;
            float f8 = f6 + f3;
            float f9 = this.f80373b;
            if (f8 > f9) {
                fAbs = Math.abs(f8 - Math.max(f8 - f5, f9));
            } else {
                fAbs = 0.0f;
                if (f7 < 0.0f) {
                    fAbs = Math.abs(f7 - Math.min(f7 + f5, 0.0f));
                }
            }
            return e(f3, f4, f5, z2, z3, fAbs);
        }

        Builder e(float f3, float f4, float f5, boolean z2, boolean z3, float f6) {
            return f(f3, f4, f5, z2, z3, f6, 0.0f, 0.0f);
        }

        Builder f(float f3, float f4, float f5, boolean z2, boolean z3, float f6, float f7, float f8) {
            if (f5 <= 0.0f) {
                return this;
            }
            if (z3) {
                if (z2) {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
                int i3 = this.f80380i;
                if (i3 != -1 && i3 != 0) {
                    throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                }
                this.f80380i = this.f80374c.size();
            }
            Keyline keyline = new Keyline(Float.MIN_VALUE, f3, f4, f5, z3, f6, f7, f8);
            if (z2) {
                if (this.f80375d == null) {
                    this.f80375d = keyline;
                    this.f80377f = this.f80374c.size();
                }
                if (this.f80378g != -1 && this.f80374c.size() - this.f80378g > 1) {
                    throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                }
                if (f5 != this.f80375d.f80384d) {
                    throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
                }
                this.f80376e = keyline;
                this.f80378g = this.f80374c.size();
            } else {
                if (this.f80375d == null && keyline.f80384d < this.f80379h) {
                    throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                }
                if (this.f80376e != null && keyline.f80384d > this.f80379h) {
                    throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                }
            }
            this.f80379h = keyline.f80384d;
            this.f80374c.add(keyline);
            return this;
        }

        Builder g(float f3, float f4, float f5, int i3) {
            return h(f3, f4, f5, i3, false);
        }

        Builder h(float f3, float f4, float f5, int i3, boolean z2) {
            if (i3 > 0 && f5 > 0.0f) {
                for (int i4 = 0; i4 < i3; i4++) {
                    c((i4 * f5) + f3, f4, f5, z2);
                }
            }
            return this;
        }

        KeylineState i() {
            if (this.f80375d == null) {
                throw new IllegalStateException(KrzujOtzIk.BdDjlAr);
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < this.f80374c.size(); i3++) {
                Keyline keyline = (Keyline) this.f80374c.get(i3);
                arrayList.add(new Keyline(j(this.f80375d.f80382b, this.f80372a, this.f80377f, i3), keyline.f80382b, keyline.f80383c, keyline.f80384d, keyline.f80385e, keyline.f80386f, keyline.f80387g, keyline.f80388h));
            }
            return new KeylineState(this.f80372a, arrayList, this.f80377f, this.f80378g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Keyline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f80381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float f80382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final float f80383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final float f80384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f80385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final float f80386f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final float f80387g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final float f80388h;

        Keyline(float f3, float f4, float f5, float f6) {
            this(f3, f4, f5, f6, false, 0.0f, 0.0f, 0.0f);
        }

        static Keyline a(Keyline keyline, Keyline keyline2, float f3) {
            return new Keyline(AnimationUtils.a(keyline.f80381a, keyline2.f80381a, f3), AnimationUtils.a(keyline.f80382b, keyline2.f80382b, f3), AnimationUtils.a(keyline.f80383c, keyline2.f80383c, f3), AnimationUtils.a(keyline.f80384d, keyline2.f80384d, f3));
        }

        Keyline(float f3, float f4, float f5, float f6, boolean z2, float f7, float f8, float f9) {
            this.f80381a = f3;
            this.f80382b = f4;
            this.f80383c = f5;
            this.f80384d = f6;
            this.f80385e = z2;
            this.f80386f = f7;
            this.f80387g = f8;
            this.f80388h = f9;
        }
    }

    static KeylineState m(KeylineState keylineState, KeylineState keylineState2, float f3) {
        if (keylineState.f() != keylineState2.f()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
        }
        List listG = keylineState.g();
        List listG2 = keylineState2.g();
        if (listG.size() != listG2.size()) {
            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < keylineState.g().size(); i3++) {
            arrayList.add(Keyline.a((Keyline) listG.get(i3), (Keyline) listG2.get(i3), f3));
        }
        return new KeylineState(keylineState.f(), arrayList, AnimationUtils.c(keylineState.b(), keylineState2.b(), f3), AnimationUtils.c(keylineState.i(), keylineState2.i(), f3));
    }

    static KeylineState n(KeylineState keylineState, float f3) {
        Builder builder = new Builder(keylineState.f(), f3);
        float f4 = (f3 - keylineState.j().f80382b) - (keylineState.j().f80384d / 2.0f);
        int size = keylineState.g().size() - 1;
        while (size >= 0) {
            Keyline keyline = (Keyline) keylineState.g().get(size);
            builder.d((keyline.f80384d / 2.0f) + f4, keyline.f80383c, keyline.f80384d, size >= keylineState.b() && size <= keylineState.i(), keyline.f80385e);
            f4 += keyline.f80384d;
            size--;
        }
        return builder.i();
    }

    Keyline a() {
        return (Keyline) this.f80369b.get(this.f80370c);
    }

    int b() {
        return this.f80370c;
    }

    Keyline c() {
        return (Keyline) this.f80369b.get(0);
    }

    Keyline d() {
        for (int i3 = 0; i3 < this.f80369b.size(); i3++) {
            Keyline keyline = (Keyline) this.f80369b.get(i3);
            if (!keyline.f80385e) {
                return keyline;
            }
        }
        return null;
    }

    List e() {
        return this.f80369b.subList(this.f80370c, this.f80371d + 1);
    }

    float f() {
        return this.f80368a;
    }

    List g() {
        return this.f80369b;
    }

    Keyline h() {
        return (Keyline) this.f80369b.get(this.f80371d);
    }

    int i() {
        return this.f80371d;
    }

    Keyline j() {
        return (Keyline) this.f80369b.get(r0.size() - 1);
    }

    Keyline k() {
        for (int size = this.f80369b.size() - 1; size >= 0; size--) {
            Keyline keyline = (Keyline) this.f80369b.get(size);
            if (!keyline.f80385e) {
                return keyline;
            }
        }
        return null;
    }

    int l() {
        Iterator it = this.f80369b.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((Keyline) it.next()).f80385e) {
                i3++;
            }
        }
        return this.f80369b.size() - i3;
    }

    private KeylineState(float f3, List list, int i3, int i4) {
        this.f80368a = f3;
        this.f80369b = Collections.unmodifiableList(list);
        this.f80370c = i3;
        this.f80371d = i4;
    }
}
