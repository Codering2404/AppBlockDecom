package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sj;
import com.applovin.impl.vi;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class e extends com.applovin.impl.sdk.network.a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f63553s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f63554t;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a extends a.C0125a {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f63555r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f63556s;

        public a(j jVar) {
            super(jVar);
            this.f63502h = ((Integer) jVar.a(sj.K2)).intValue();
            this.f63503i = ((Integer) jVar.a(sj.J2)).intValue();
            this.f63504j = ((Integer) jVar.a(sj.T2)).intValue();
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(vi.a aVar) {
            this.f63511q = aVar;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(String str) {
            this.f63497c = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a b(int i3) {
            this.f63504j = i3;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a b(String str) {
            this.f63496b = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a c(String str) {
            this.f63495a = str;
            return this;
        }

        public a h(boolean z2) {
            this.f63556s = z2;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a b(boolean z2) {
            this.f63510p = z2;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a b(Map map) {
            this.f63498d = map;
            return this;
        }

        public a e(String str) {
            this.f63555r = str;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public a c(int i3) {
            this.f63503i = i3;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a a(boolean z2) {
            this.f63508n = z2;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a(Map map) {
            this.f63499e = map;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(int i3) {
            this.f63502h = i3;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(JSONObject jSONObject) {
            this.f63500f = jSONObject;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Object obj) {
            this.f63501g = obj;
            return this;
        }

        @Override // com.applovin.impl.sdk.network.a.C0125a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a() {
            return new e(this);
        }
    }

    protected e(a aVar) {
        super(aVar);
        this.f63553s = aVar.f63555r;
        this.f63554t = aVar.f63556s;
    }

    public static a b(j jVar) {
        return new a(jVar);
    }

    public String s() {
        return this.f63553s;
    }

    public boolean t() {
        return this.f63553s != null;
    }

    public boolean u() {
        return this.f63554t;
    }
}
