package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeAdMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f70489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f70490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f70491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private NativeAd.Image f70492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f70493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f70494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Double f70495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f70496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f70497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f70498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f70499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f70500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bundle f70501m = new Bundle();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f70502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f70503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private float f70504p;

    public final void A(NativeAd.Image image) {
        this.f70492d = image;
    }

    public final void B(List list) {
        this.f70490b = list;
    }

    public void C(View view) {
        this.f70500l = view;
    }

    public final void D(boolean z2) {
        this.f70503o = z2;
    }

    public final View G() {
        return this.f70500l;
    }

    public View b() {
        return this.f70499k;
    }

    public final String c() {
        return this.f70494f;
    }

    public final String d() {
        return this.f70491c;
    }

    public final String e() {
        return this.f70493e;
    }

    public float f() {
        return 0.0f;
    }

    public float g() {
        return 0.0f;
    }

    public final Bundle h() {
        return this.f70501m;
    }

    public final String i() {
        return this.f70489a;
    }

    public final NativeAd.Image j() {
        return this.f70492d;
    }

    public final List k() {
        return this.f70490b;
    }

    public float l() {
        return this.f70504p;
    }

    public final boolean m() {
        return this.f70503o;
    }

    public final boolean n() {
        return this.f70502n;
    }

    public final String o() {
        return this.f70497i;
    }

    public final Double p() {
        return this.f70495g;
    }

    public final String q() {
        return this.f70496h;
    }

    public void t(View view) {
        this.f70499k = view;
    }

    public final void u(String str) {
        this.f70494f = str;
    }

    public final void v(String str) {
        this.f70491c = str;
    }

    public final void w(String str) {
        this.f70493e = str;
    }

    public final void x(Bundle bundle) {
        this.f70501m = bundle;
    }

    public void y(boolean z2) {
        this.f70498j = z2;
    }

    public final void z(String str) {
        this.f70489a = str;
    }

    public void a() {
    }

    public void s() {
    }

    public void F(View view) {
    }

    public void r(View view) {
    }

    public void E(View view, Map map, Map map2) {
    }
}
