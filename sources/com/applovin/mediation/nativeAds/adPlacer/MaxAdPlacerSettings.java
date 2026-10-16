package com.applovin.mediation.nativeAds.adPlacer;

import com.applovin.impl.sdk.n;
import com.sun.jna.Function;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdPlacerSettings {
    public static final int MIN_REPEATING_INTERVAL = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f65574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f65575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f65576c = new TreeSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f65577d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f65578e = Function.MAX_NARGS;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f65579f = 4;

    public MaxAdPlacerSettings(String str) {
        this.f65574a = str;
    }

    public void addFixedPosition(int i3) {
        this.f65576c.add(Integer.valueOf(i3));
    }

    public String getAdUnitId() {
        return this.f65574a;
    }

    public Set<Integer> getFixedPositions() {
        return this.f65576c;
    }

    public int getMaxAdCount() {
        return this.f65578e;
    }

    public int getMaxPreloadedAdCount() {
        return this.f65579f;
    }

    public String getPlacement() {
        return this.f65575b;
    }

    public int getRepeatingInterval() {
        return this.f65577d;
    }

    public boolean hasValidPositioning() {
        return !this.f65576c.isEmpty() || isRepeatingEnabled();
    }

    public boolean isRepeatingEnabled() {
        return this.f65577d >= 2;
    }

    public void resetFixedPositions() {
        this.f65576c.clear();
    }

    public void setMaxAdCount(int i3) {
        this.f65578e = i3;
    }

    public void setMaxPreloadedAdCount(int i3) {
        this.f65579f = i3;
    }

    public void setPlacement(String str) {
        this.f65575b = str;
    }

    public void setRepeatingInterval(int i3) {
        if (i3 >= 2) {
            this.f65577d = i3;
            n.g("MaxAdPlacerSettings", "Repeating interval set to " + i3);
            return;
        }
        this.f65577d = 0;
        n.j("MaxAdPlacerSettings", "Repeating interval has been disabled, since it has been set to " + i3 + ", which is less than minimum value of 2");
    }

    public String toString() {
        return "MaxAdPlacerSettings{adUnitId='" + this.f65574a + "', fixedPositions=" + this.f65576c + ", repeatingInterval=" + this.f65577d + ", maxAdCount=" + this.f65578e + ", maxPreloadedAdCount=" + this.f65579f + '}';
    }
}
