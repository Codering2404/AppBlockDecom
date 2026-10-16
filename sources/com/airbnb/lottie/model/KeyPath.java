package com.airbnb.lottie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class KeyPath {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final KeyPath f56708c = new KeyPath("COMPOSITION");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f56709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private KeyPathElement f56710b;

    public KeyPath(String... strArr) {
        this.f56709a = Arrays.asList(strArr);
    }

    private boolean b() {
        return ((String) this.f56709a.get(r0.size() - 1)).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    public KeyPath a(String str) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f56709a.add(str);
        return keyPath;
    }

    public boolean c(String str, int i3) {
        if (i3 >= this.f56709a.size()) {
            return false;
        }
        boolean z2 = i3 == this.f56709a.size() - 1;
        String str2 = (String) this.f56709a.get(i3);
        if (!str2.equals("**")) {
            return (z2 || (i3 == this.f56709a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z2 && ((String) this.f56709a.get(i3 + 1)).equals(str)) {
            return i3 == this.f56709a.size() + (-2) || (i3 == this.f56709a.size() + (-3) && b());
        }
        if (z2) {
            return true;
        }
        int i4 = i3 + 1;
        if (i4 < this.f56709a.size() - 1) {
            return false;
        }
        return ((String) this.f56709a.get(i4)).equals(str);
    }

    public KeyPathElement d() {
        return this.f56710b;
    }

    public int e(String str, int i3) {
        if (f(str)) {
            return 0;
        }
        if (((String) this.f56709a.get(i3)).equals("**")) {
            return (i3 != this.f56709a.size() - 1 && ((String) this.f56709a.get(i3 + 1)).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            KeyPath keyPath = (KeyPath) obj;
            if (!this.f56709a.equals(keyPath.f56709a)) {
                return false;
            }
            KeyPathElement keyPathElement = this.f56710b;
            KeyPathElement keyPathElement2 = keyPath.f56710b;
            if (keyPathElement != null) {
                return keyPathElement.equals(keyPathElement2);
            }
            if (keyPathElement2 == null) {
                return true;
            }
        }
        return false;
    }

    public boolean g(String str, int i3) {
        if (f(str)) {
            return true;
        }
        if (i3 >= this.f56709a.size()) {
            return false;
        }
        return ((String) this.f56709a.get(i3)).equals(str) || ((String) this.f56709a.get(i3)).equals("**") || ((String) this.f56709a.get(i3)).equals("*");
    }

    public boolean h(String str, int i3) {
        return "__container".equals(str) || i3 < this.f56709a.size() - 1 || ((String) this.f56709a.get(i3)).equals("**");
    }

    public int hashCode() {
        int iHashCode = this.f56709a.hashCode() * 31;
        KeyPathElement keyPathElement = this.f56710b;
        return iHashCode + (keyPathElement != null ? keyPathElement.hashCode() : 0);
    }

    public KeyPath i(KeyPathElement keyPathElement) {
        KeyPath keyPath = new KeyPath(this);
        keyPath.f56710b = keyPathElement;
        return keyPath;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f56709a);
        sb.append(",resolved=");
        sb.append(this.f56710b != null);
        sb.append('}');
        return sb.toString();
    }

    private KeyPath(KeyPath keyPath) {
        this.f56709a = new ArrayList(keyPath.f56709a);
        this.f56710b = keyPath.f56710b;
    }
}
