package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class UnifiedNativeAdMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f70505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f70506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f70507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NativeAd.Image f70508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f70509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f70510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Double f70511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f70512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f70513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private VideoController f70514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f70515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f70516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private View f70517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Object f70518n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Bundle f70519o = new Bundle();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f70520p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f70521q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f70522r;

    public final void A(boolean z2) {
        this.f70521q = z2;
    }

    public final void B(boolean z2) {
        this.f70520p = z2;
    }

    public final void C(String str) {
        this.f70513i = str;
    }

    public final void D(Double d3) {
        this.f70511g = d3;
    }

    public final void E(String str) {
        this.f70512h = str;
    }

    public final void H(VideoController videoController) {
        this.f70514j = videoController;
    }

    public final void I(Object obj) {
        this.f70518n = obj;
    }

    public final VideoController J() {
        return this.f70514j;
    }

    public final View K() {
        return this.f70517m;
    }

    public final Object L() {
        return this.f70518n;
    }

    public View b() {
        return this.f70516l;
    }

    public final String c() {
        return this.f70510f;
    }

    public final String d() {
        return this.f70507c;
    }

    public final String e() {
        return this.f70509e;
    }

    public float f() {
        return 0.0f;
    }

    public float g() {
        return 0.0f;
    }

    public final Bundle h() {
        return this.f70519o;
    }

    public final String i() {
        return this.f70505a;
    }

    public final NativeAd.Image j() {
        return this.f70508d;
    }

    public final List k() {
        return this.f70506b;
    }

    public float l() {
        return this.f70522r;
    }

    public final boolean m() {
        return this.f70521q;
    }

    public final boolean n() {
        return this.f70520p;
    }

    public final String o() {
        return this.f70513i;
    }

    public final Double p() {
        return this.f70511g;
    }

    public final String q() {
        return this.f70512h;
    }

    public boolean s() {
        return this.f70515k;
    }

    public final void u(String str) {
        this.f70510f = str;
    }

    public final void v(String str) {
        this.f70507c = str;
    }

    public final void w(String str) {
        this.f70509e = str;
    }

    public final void x(String str) {
        this.f70505a = str;
    }

    public final void y(NativeAd.Image image) {
        this.f70508d = image;
    }

    public final void z(List list) {
        this.f70506b = list;
    }

    public void a() {
    }

    public void t() {
    }

    public void G(View view) {
    }

    public void r(View view) {
    }

    public void F(View view, Map map, Map map2) {
    }
}
