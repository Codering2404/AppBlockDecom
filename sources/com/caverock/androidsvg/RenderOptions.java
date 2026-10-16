package com.caverock.androidsvg;

import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.SVG;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RenderOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CSSParser.Ruleset f67421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    PreserveAspectRatio f67422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f67423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    SVG.Box f67424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f67425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    SVG.Box f67426f;

    public RenderOptions() {
        this.f67421a = null;
        this.f67422b = null;
        this.f67423c = null;
        this.f67424d = null;
        this.f67425e = null;
        this.f67426f = null;
    }

    public RenderOptions a(String str) {
        this.f67421a = new CSSParser(CSSParser.Source.RenderOptions).d(str);
        return this;
    }

    public boolean b() {
        CSSParser.Ruleset ruleset = this.f67421a;
        return ruleset != null && ruleset.f() > 0;
    }

    public boolean c() {
        return this.f67422b != null;
    }

    public boolean d() {
        return this.f67423c != null;
    }

    public boolean e() {
        return this.f67425e != null;
    }

    public boolean f() {
        return this.f67424d != null;
    }

    public boolean g() {
        return this.f67426f != null;
    }

    public RenderOptions h(float f3, float f4, float f5, float f6) {
        this.f67426f = new SVG.Box(f3, f4, f5, f6);
        return this;
    }

    public RenderOptions(RenderOptions renderOptions) {
        this.f67421a = null;
        this.f67422b = null;
        this.f67423c = null;
        this.f67424d = null;
        this.f67425e = null;
        this.f67426f = null;
        if (renderOptions == null) {
            return;
        }
        this.f67421a = renderOptions.f67421a;
        this.f67422b = renderOptions.f67422b;
        this.f67424d = renderOptions.f67424d;
        this.f67425e = renderOptions.f67425e;
        this.f67426f = renderOptions.f67426f;
    }
}
